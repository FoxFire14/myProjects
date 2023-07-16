import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {

    BufferedReader bufferedReader;


    public String readFileToString(String path) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void countWords(String myText) {

        long counter = Stream.of(myText.split("\\s+|\\n"))
                .count();

        System.out.println(counter);
    }

    public void firstWordWithSize(String myText, int numbWords) {

        System.out.println(Stream.of(myText.split("\\s+|\\n"))
                .filter(word -> word.length() == numbWords)
                .findFirst());
    }

    public void findWordsWithSize(String myText, int numbWords) {

        List<String> myList = Stream.of(myText.split("\\s+|\\n"))
                .filter(word -> word.length() == numbWords)
                .collect(Collectors.toList());

        Stream.of(myList)
                .forEach(System.out::println);
    }

    public void matchingWords(String filePath, String filePath2) {
        String file = readFileToString(filePath);
        String file2 = readFileToString(filePath2);


        List<String> array = Stream.of(file.split("\\s+|\\n"))
                .filter(file2::contains)
                .distinct()
                .collect(Collectors.toList());

        Stream.of(array)
                .forEach(System.out::println);


    }


    public static void main(String[] args) {
        TextReader textReader = new TextReader();

        String myList = textReader.readFileToString("resources/text.txt");

        textReader.countWords(myList);

        textReader.firstWordWithSize(myList, 8);

        textReader.findWordsWithSize(myList, 6);

        textReader.matchingWords("resources/text.txt", "resources/text2.txt");

       /* for (String line : myList){
            System.out.println(line);
        }*/
    }

}
