# СLI example
    
This program is basically an implementation of CLI interface for Data Base.

With start, it reads all lines from a file, then does its own thing which depends on starting arguments (see below, please note that we can work with multiple instances but only with one command for each), and before closing writes everything there is now back into a file.

Starting arguments are:

"-c" to create a person. 
There should be following with three more parameters which are Name of a person, 

their sex(m orf) and birthdate (in the format of dd/MM/yyyy).

Example: -c Ivanov m 19/05/1995
This example creates person "Ivanov, male, born 19 of May 1995 A.D."

Example: -c Ivanov m 19/05/1995 Petrova f 23/02/1992
This example creates person "Ivanov, male, born 19 of May 1995 A.D." AND person "Petrova, female, born 23 of Februrary 1992 A.D."

The program then prints personID assigned to each person.


"-u" to update info of given person. There should be following with four more parameters which are the personal ID of given person,

 Name of a person, their sex(m or f) and birthdate (in the format of dd/MM/yyyy).

Example: -u 0 Sokolova f 23/03/1992 ... 
This example replaces previously created person "Ivanov" with a person "Sokolova, female, born 23 of Marxh 1992 A.D."



"-d" to delete a person from the database. There should be following with one more parameter which is ID assigned to person that we want to delete.

Example: -d 0 ...
This example nullifies all fields assigned to previously added "Ivanov".



"-i" to get info about given person. There should be following with one more parameter which is ID assigned to person that we want to get info about.

Example: -i 0 ...
This example prints in a console "Ivanov m 19/05/1995".
