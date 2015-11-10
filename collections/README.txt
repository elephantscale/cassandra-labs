Collections  (run time : 45 min)
===========

CQL Collections documentation :
http://www.datastax.com/documentation/cql/3.0/cql/cql_using/use_collections_c.html

== STEP 1)  Invoke cqlsh
    $  cqlsh


== STEP 2)
  create users table with the following fields
      uname ... primary key

  Add a user named 'tim'
    INSERT INTO users (uname) VALUES (???);


== STEP 3)
  We need to store multiple emails for user.  What collection type can be used?

  Modify the users table to add a new field 'emails'
    >  ALTER TABLE users  ADD emails ????;

  Add two emails (tim@gmail.com, tim@mac.com ) to a user
  Check the documentation for syntax
    > INSERT INTO users (uname, emails)
            VALUES ('tim', ???);

  Add another email (tim@office.com) to the same user.

  Verify the user has 3 emails.

  Insert a duplicate email (tim@gmail.com) to the same user.
  How many emails are set for the user?



== STEP 4)
  We need to add multiple IM contacts per user
      skype
      ichat
      hangout
      whatsapp
  What data type could we use to do this?

  Modify the users table to add a new field 'chats'

  Add the following values into the new field
    skype : tim_skype
    ichat : tim_mac

  Verify the values

  Add another dataset
    hangout : tim_google

  Verify the values

  Update one value to
    skype ->   tim_skype_new

  Verify the values


== STEP 5)
  Users 'check in' from various locations (coffee shop, park ...etc)
  We are going to be adding 'check in locations' for user.
  Let's store the locations in the same user table.
  What would be a suitable data type?

  Modify the users table to add a new field 'locations' with an appropriate type

  Insert the following location data:
    Neal's coffee @ 2014-10-01 17:00
    Echo Park @ 2014-10-01 18:00    ( 1 hr later)

  Can we keep the latest location first? (for faster queries?)

  What are the limitations of this data type?


== STEP 6)  Check the documentation
  Q : Are there size limitations for collections?

  Q: Can you index collections?  which types

  Q : what type of queries are supported for collections?

