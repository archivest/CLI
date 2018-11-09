package ConsoleLineInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class DataBaseReader {
    public static void read() throws IOException, ParseException {
        //Initializing our file.
        File dataFile = new File("database.txt");

        //Opening Input Stream.
        BufferedReader dataReader = new BufferedReader(
                new FileReader(dataFile));

        //Declaring line we will later use to add to our list [allPeople].
        String personalizedLine;

        //While there are lines in file - run CLI.main with given parameters.
        while ((personalizedLine = dataReader.readLine()) != null) {

            //Splitting lines where there is ";" to get separated arguments for CLI.main.
            String[] info = personalizedLine.split(";");

            //Run CLI.main with parameters taken from line (which are now in array [info].
            CLI.main(info);
        }

        //Closing reader stream.
        dataReader.close();
    }
}
