<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) 

Bonus Lab 12 : Modeling GMAIL
====================

### Overview
Model GMAIL on C*

### Depends On 
None

### Run time
1 hr


## Models:
- users
    * user_id (e.g  u1)
    * email  (e.g.  u1@gmail.com)

- email
    * email_id : a unique id (e.g.   'e1')
    * subject:
    * from: (email)
    * to : email
    * content : text
    * ref_id : text (id of previous email if replying)

## STEP 1: Create Tables
----------------------------
Create a file called `gmail.cql` with the following content.
```
create table users (
    user_id ???,
    email ???,
    primary key(???)
    );

create table emails (
    ...
    // TODO 
  )
```

Create the tables by:
```
    $   ~/cassandra/bin/cqlsh   -f    gmail.cql
```

## STEP 2: Sample Data : Users
----------------------------
Create a file called `users.cql`  with sample data like this.
```
  INSERT INTO users(user_id, email)  VALUES ('u1', 'u1@gmail.com');
```

Create a few more entries for various users.  
Save the file.  
Import the data into Cassandra.  
```
    $     ~/cassandra/bin/cqlsh  -f   users.cql
```


## STEP 3) Sample Data : EMails
----------------------------
Create a file called `emails.cql` with sample data like this  :
```
    INSERT INTO emails(email_id, subject, from , to , content)
    VALUES ('u1e1', hello 1', 'u1@gmail.com',  'u2@gmail.com',  'hi there' ) ;
```

Following email is a reply to previous email `e1`  (note the `ref_id`).
```
    INSERT INTO emails(email_id, subject, from , to , content)
    VALUES ('u2e1', hello 1', 'u2@gmail.com',  'u1@gmail.com',  'hi there' , 'u1e1') ;
```

Tip for setting email ids:  
For emails from user `u1`, set ids as  `u1e1`  ,  `u1e2` ...

Create a few more entries to reflect the following relationship

* U1 sent  email to U2,  U3, and U4
* U2 and U3 replied to U1's email
* U3 sent an email to U4
* U4 replied to U3
* U1 sent another email to U3

Save this file (emails.cql) and import the data
```
    $    ~/cassandra/bin/cqlsh   -f email.cql
```


## STEP 4: Queries
----------------------------
Figure out how to answer the following queries

* Q1 : Find all emails sent by U1

* Q2 : Find all emails sent TO U3

* Q3: Find all emails that correspond to first email (u1e1) sent by U1


