package ConsoleLineInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataBaseWriter {
    public static void write() throws IOException {
        //Initializing our file.
        File database = new File("database.txt");

        /*
        Opening Output Streams.
        Setting @append to "false" to rewrite lines in file.
         */
        FileOutputStream fileOutStream = new FileOutputStream(database, false);
        ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream);

        //For each person in list [allPeople] write line in file.
        for (Person person : CLI.allPeople){
        objOutStream.writeObject(Person.toString(person));
        }

        //Closing streams.
        objOutStream.close();
        fileOutStream.close();
    }
}
