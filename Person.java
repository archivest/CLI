package ConsoleLineInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDate;

    //A bunch of constructors, initializators and getters/setters to be able to work with parameters.
    private Person(String name, Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Person createMale(String name, Date birthDate) {
        return new Person(name, Sex.MALE, birthDate);
    }

    public static Person createFemale(String name, Date birthDate) {
        return new Person(name, Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    //Block of methods that implement our Console Line Interface.

    public synchronized static void getInfo(String index){
        //Deciding on person we want to get info about.
        Person person = CLI.allPeople.get(Integer.parseInt(index));

        //parse @sex to string value with format given in the task
        String sexOfGivenPerson = (person.getSex() == Sex.MALE) ? "m" : "f";

        //change format of date to match the criteria of the task
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        //print info [@name @sex @dateOfBirth]
        System.out.println("Personal information assigned to this person: " + person.getName() + " " + sexOfGivenPerson + " " + sdf.format(person.getBirthDate()));
    }

    public synchronized static void create(String givenName, String givenSex, String givenDate) throws ParseException {

        //Declaring parameters.
        Person person;
        DateFormat dtf = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);
        Date dateOfBirth = dtf.parse(givenDate);
        Sex sex = (givenSex.equals("m")) ? Sex.MALE : Sex.FEMALE;

        //If given person has male as param. @sex then createMale() with given @name and @dateOfBirth.
        if (sex == Sex.MALE) { person = Person.createMale(givenName, dateOfBirth); }

        //Else create female with same parameters.
        else person = Person.createFemale(givenName, dateOfBirth);

        //Add person to list [allPeople].
        CLI.allPeople.add(person);

        //Print assigned index.
        System.out.println("Personal ID assigned to this person is: " + CLI.allPeople.indexOf(person));
    }

    public synchronized static void delete(String index){

        ///Deciding on person we want to delete from database.
        Person person = CLI.allPeople.get(Integer.parseInt(index));

        //Nullifying fields assigned to this person
        person.setSex(null);
        person.setBirthDate(null);
        person.setName(null);
        System.out.println("Info on person with this ID was deleted");
    }

    public synchronized static void update(String givenIndex, String givenName, String givenSex, String givenDate) throws ParseException {

        //Declaring parameters.
        Person person;
        DateFormat dtf = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);
        Date dateOfBirth = dtf.parse(givenDate);
        Sex sex = (givenSex.equals("m")) ? Sex.MALE : Sex.FEMALE;

        //If given person has male as param. @sex then createMale() with given @name and @dateOfBirth.
        if (sex == Sex.MALE) { person = Person.createMale(givenName, dateOfBirth); }

        //Else create female with same parameters.
        else person = Person.createFemale(givenName, dateOfBirth);

        //Assigning new info on given person.
        CLI.allPeople.set(Integer.parseInt(givenIndex), person);
    }

    //Method to make elements of list [allPeople] suitable for our database.
    public synchronized static String toString(Person person){
        DateFormat dtf = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);
        return "-c;" + person.getName() + ";" + ((person.getSex() == Sex.MALE) ? "m" : "f") + ";" + dtf.format(person.getBirthDate());
    }
}
