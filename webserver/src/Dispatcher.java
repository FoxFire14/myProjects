import java.io.*;
import java.net.Socket;

public class Dispatcher implements Runnable{

    private Socket clientSocket;
    private final String resourcesDirectoryName = "www/";
    private final String path404 = "www/404.html";
    private final String pathIndex = "www/index.html";

    public Dispatcher(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            validateHeader(getHeader());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHeader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        StringBuilder headerBuilder = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            headerBuilder.append(line).append("\r\n");
            if (line.isEmpty()) {
                break; // Stop reading once an empty line is encountered (end of header)
            }
        }

        String header = headerBuilder.toString();
        System.out.println(header);

        return header;
    }

    public void validateHeader(String header) throws IOException {

        String[] wordsArray = header.split("/");
        String[] nameAndExtension = wordsArray[1].split("\\.|\\s");
        String fileName = nameAndExtension[0];
        String fileExtension = nameAndExtension[1];
        String responseHeader;
        System.out.println(fileExtension + " --------  ");
        System.out.println(fileName);

        try {

            File file = new File(resourcesDirectoryName + fileName + "." + fileExtension);

            if(fileExtension.equals("HTTP")){
                File file2 = new File(pathIndex);
                responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + file2.length() + " \r\n\r\n";

                sendResponseHeader(responseHeader);
                sendOutput(file2);
                close(clientSocket);
            }
            else if (!file.exists()) {
                File file1 = new File(path404);
                responseHeader = "HTTP/1.0 404 Not Found\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + file1.length() + "\r\n\r\n";
                sendResponseHeader(responseHeader);
                sendOutput(file1);
                close(clientSocket);

            }
            else if (fileExtension.equals("html")) {
                responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: " + file.length() + " \r\n\r\n";

                sendResponseHeader(responseHeader);
                sendOutput(file);
                close(clientSocket);

            } else if (fileExtension.equals("png")) {
                responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: image/" + fileExtension + "\r\n" +
                        "Content-Length: " + file.length() + "\r\n\r\n";
                sendResponseHeader(responseHeader);
                sendOutput(file);
                close(clientSocket);

            } else if (fileExtension.equals("ico")) {
                responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                        "Content-Type: image/x-icon\r\n" +
                        "Content-Length: " + file.length() + "\r\n\r\n";
                sendResponseHeader(responseHeader);
                sendOutput(file);
                close(clientSocket);
            }
        } catch (IOException e){
            throw new IOException(e);
        }
    }

    public void sendResponseHeader(String responseHeader) throws IOException {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            dataOutputStream.writeBytes(responseHeader);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendOutput(File file) throws IOException {
        FileInputStream fileInputStream = null;
        DataOutputStream dataOutputStream = null;

        int bufferSize;
        byte[] byteBuffer = new byte[1024];
        try {

            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            fileInputStream = new FileInputStream(file);
            while ((bufferSize = fileInputStream.read(byteBuffer)) != -1){
                dataOutputStream.write(byteBuffer,0,bufferSize);

            }
            clientSocket.close();
            System.out.println("Connection closed \n");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataOutputStream != null){
                dataOutputStream.close();
            }
            if (fileInputStream != null){
                fileInputStream.close();
            }
        }
    }
    public String extensionCheck(String fileName, String fileExtension){
        if (fileName.isEmpty()){
            return resourcesDirectoryName + "index" + "." + "html";
        }
        return resourcesDirectoryName + fileName + "." + fileExtension;
    }
    public void close(Socket clientSocket) throws IOException {
        clientSocket.close();
    }



}
