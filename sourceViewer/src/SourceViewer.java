import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SourceViewer {
    public static void main(String[] args) {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give me the url: " );
            String myUrl = "https://" + bufferedReader.readLine();
            bufferedReader.close();

            URL url = new URL(myUrl);
            URLConnection urlConnection = url.openConnection();

            BufferedReader readUrlData = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String urlContent;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/vans.html"));


            //update urlContent variable on each loop round, reading and printing line by line
            while((urlContent = readUrlData.readLine()) != null){

                System.out.println(urlContent);
                bufferedWriter.write(urlContent);
                bufferedWriter.flush();

            }

            bufferedReader.close();
            bufferedWriter.close();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}