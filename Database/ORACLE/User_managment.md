
# USER MANAGEMENT IN ORACLE DATABASE

https://www.youtube.com/watch?v=tmb1DmGYsjk


1. To access the database, a user must spedify a valid database user account and successfully authenticate as requried by that user account.

2. Each database user has a unique database account.

3. Oracle recommends this to avoid potential security hoels and provide meaningful data for certain audit activities.

### Tablespace

A tablespace in an Oracle database consists of one or more physical datafiles. A datafile can be associated with only one tablespace and only one database. Oracle creates a datafile for a tablespace by allocating the specified amount of disk space plus the overhead required for the file header.


Oracle stores data logically in tablespaces and physically in datafiles associated with the corresponding tablespace.

![Tablespace](tablespace.GIF?raw=true "USER CRATION AND MANAGEING")


## Each database user account has :

* A unique username
* An Authenticaiton method
* A defatul tablespace
* A temporary tablespace
* A user profile
* A account status

### SYS account :

* is granted the DBA role
* Has all previleges with ADMIN OPTION
* is required for startup, shutdown, and some maintenance commands.
* owns the data directory.

### SYSTEM account

* is granted the DBA role.
* There acconts are not used for routine operations.
* Its for the oracle db system.


### Managing users

![USER CREATION](user1.PNG?raw=true "USER CRATION AND MANAGEING")


SQL > CREATE USER mentors
        Identified by mentors
        default tablespace users
        temporary tablespace temp
        quote 5M on users;



User Created


// Change the password
SQL > alter user mentors identified by usa;

User altered.


// check whether changes applied.
SQL> desc dba_users;
SQL> select username, account_status, created from dba_users;


// Dropping user
SQL> Drop user mentors;


## LOCK and UNLOCK users and USER MANAGMENT further.

https://www.youtube.com/watch?v=SdGoxfraVUI

![USER CREATION](user2.PNG?raw=true "USER CRATION AND MANAGEING")

Always dont delete user if the dba not sure. First lock the user, if no one come for help after one month you may delete the user.

User mangement, preivilesges, quota allocation good informations are given in this url.

https://www.youtube.com/watch?v=SdGoxfraVUI


## USER PREVILEGES

Introduction to Privileges
A privilege is a right to execute a particular type of SQL statement or to access another user's object. Some examples of privileges include the right to:

Connect to the database (create a session)

Create a table

Select rows from another user's table

Execute another user's stored procedure

You grant privileges to users so these users can accomplish tasks required for their jobs. You should grant a privilege only to a user who requires that privilege to accomplish the necessary work. Excessive granting of unnecessary privileges can compromise security. A user can receive a privilege in two different ways:

You can grant privileges to users explicitly. For example, you can explicitly grant to user SCOTT the privilege to insert records into the employees table.

You can also grant privileges to a role (a named group of privileges), and then grant the role to one or more users. For example, you can grant the privileges to select, insert, update, and delete records from the employees table to the role named clerk, which in turn you can grant to users scott and brian.

Because roles allow for easier and better management of privileges, you should normally grant privileges to roles and not to specific users.





## USER PROFILES and PROFILE MANAGMENT in oracle

https://www.youtube.com/watch?v=PUzUwtvfgDU

https://docs.oracle.com/cd/B19306_01/network.102/b14266/authoriz.htm#i1008223

![Resouce managment](oracle-1.PNG?raw=true "ORACLE Resource managment")


![Resouce managment](oracle0.PNG?raw=true "ORACLE Resource managment")

// password managment profile 

![Password managment](oracle1.PNG?raw=true "ORACLE Password managment")

How to create a profile and assign to a user.

![Resource managment](oracle2.PNG?raw=true "ORACLE Password managment")