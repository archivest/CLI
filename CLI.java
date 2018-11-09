package ConsoleLineInterface;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CLI {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException, IOException {
        //Read initial data from file.
        DataBaseReader.read();

        //Switching first argument.
        switch (args[0]) {

             //For first argument that is equal to "-c" (to CREATE).
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 0; i < ((args.length - 1) / 3); i++) {

                        /* So basically we need each 3 arguments after first one,
                        *  for instance 1st, 2nd and 3rd for first person
                        *  then 4th, 5th and 6th for second one
                        *  and so forth and so on.
                        *  So we take numbers of arguments in each step (1,2,3)
                        *  and add "step multiplier" to them, which is basically a number of step
                        *  multiplied by number of argument within it's step.
                        */
                        Person.create(args[1 + (i * 3)], args[2 + (i * 3)], args[3 + (i * 3)]);
                    }
                }
            break;

            //For First argument that is equal to "-u" (to UPDATE).
            case "-u" :
                synchronized (allPeople) {
                    for (int i = 0; i < ((args.length - 1) / 4); i++) {
                        //So now with additional argument our (index) our step contains 4 arguments.
                        Person.update(args[1 + (i * 4)], args[2 + (i * 4)], args[3 + (i * 4)], args[4 + (i * 4)]);
                    }
                }
            break;

            //For First argument that is equal to "-d" (to DELETE).
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person.delete(args[i]);
                    }
                }
            break;

            //For First argument that is equal to "-i" ("i" stands for INFO).
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person.getInfo(args[i]);
                    }
                }
            break;
        }

        //Rewrite our file after we done with [allPeople] list.
        DataBaseWriter.write();
    }
}
