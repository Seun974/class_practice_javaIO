package se.lexicon.samuel;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args ) {

        List<String> content = Arrays.asList(
                "Hello", "World!"
        );
        //creating a new file
        File file = new File("src/text/message.txt");

       // write(file, content); //this is used to write what should be in the file and it overwrites whatever is in it.
        //commenting the above line makes it possible to overwrite and read a new manually inputted message from the file
        //to read from a file, you just need the file as the only parameter and prints a list like this [Hello, World!]
        System.out.println(read(file).toString());
        for(String message : read(file)){
            System.out.println(message);
        }
    }

    private static List<String> read(File file) {
        List<String> message = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            //reader.readLine() more like reads individual/single lines but it bloats code
            String line;
            while((line = reader.readLine()) != null){
                message.add(line);
            }

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return message;
    }

    private static List<String> write(File file, List<String> content) {
        //we used a try with resources to open and close the stream for handling file
        //opening and closing new connection to a file
       try(BufferedWriter writer = new BufferedWriter((new FileWriter(file)))){
           //writing String by String with new line between
           for (String messageToWrite: content){
               writer.write(messageToWrite);
               writer.newLine();
           }
           writer.flush();

       }catch (IOException ex){
           ex.printStackTrace();
       }


        return content;
    }


}
