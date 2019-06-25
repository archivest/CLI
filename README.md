# СLI example
    
This program is basically an implementation of a CLI interface for a database.

When it starts, it reads all lines from a file, then does its own thing which depends on starting arguments (see below, please note that it can work with multiple instances with only one command for each), and before closing writes everything there back into a file.

## Starting arguments are:

### "-c" to create a person. 
Three more parameters should follow, which are the person's Name, 

their sex (m or f) and their birthdate (in the format of dd/MM/yyyy).

Example: -c Ivanov m 19/05/1995
This example creates the person "Ivanov, male, born 19 of May 1995 A.D."

Example: -c Ivanov m 19/05/1995 Petrova f 23/02/1992
This example creates person "Ivanov, male, born 19 of May 1995 A.D." AND person "Petrova, female, born 23 of Februrary 1992 A.D."

The program then prints the personID assigned to each person.


### "-u" to update info of given person. 
Four more parameters should follow, which are the personID of given person,

the person's Name, their sex (m or f), and their birthdate (in the format of dd/MM/yyyy).

Example: -u 0 Sokolova f 23/03/1992 ... 
This example replaces previously a created person "Ivanov" with the person "Sokolova, female, born 23 of Marxh 1992 A.D."



### "-d" to delete a person from the database. 
One more parameter should follow, which is the personID assigned to the person that we want to delete.

Example: -d 0 ...
This example nullifies all fields assigned to previously added "Ivanov".



### "-i" to get info about given person. 
One more parameter should follow, which is the personID assigned to the person that we want to get info about.

Example: -i 0 ...
This example prints in the console "Ivanov m 19/05/1995".
