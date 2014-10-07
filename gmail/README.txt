Building a Gmail like system on Cassandra
-----

Models:
  1) users
    user_id (e.g  u1)
    email  (e.g.  u1@gmail.com)

  2) email
      email_id : a unique id (e.g.   'e1')
      subject:
      from: (email)
      to : email
      content : text
      ref_id : text (id of previous email if replying)

== STEP 1) create tables for both user and email models


== STEP 2) insert some sample data for users
Create a file called 'users.cql'  with sample data like this
    INSERT INTO users(user_id, email)  VALUES ('u1', 'u1@gmail.com');
create a few more entries for various users
save the file
import the data into cassandra
    $    cqlsh  -f   users.cql


== STEP 3) insert sample data for emails
Create a file called 'emails.cql' with sample data like this  :

    INSERT INTO emails(email_id, subject, from , to , content)
    VALUES ('u1e1', hello 1', 'u1@gmail.com',  'u2@gmail.com',  'hi there' ) ;

    -- this email is a reply to previous email 'e1'
    -- note ref_id
    INSERT INTO emails(email_id, subject, from , to , content)
    VALUES ('u2e1', hello 1', 'u2@gmail.com',  'u1@gmail.com',  'hi there' , 'u1e1') ;


Create a few more entries to reflect the following relationship
    U1 sent  email to U2,  U3, and U4
    U2 and U3 replied to U1's email
    U3 sent an email to U4
    U4 replied to U3
    U1 sent another email to U3

Save this file and import the data
    $   cqlsh   -f email.cql


== STEP 4)   Figure out how to answer the following queries
Q1 : Find all emails sent by U1

Q2 : Find all emails sent TO U3

Q3: Find all emails that correspond to first email (u1e1) sent by U1


