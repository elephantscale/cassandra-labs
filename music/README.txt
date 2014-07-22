Designing a Music Service on Cassandra
------
Objective : Design data models for a music service and implement them in Java

Models in Music Service:
------
Users
Songs
Playlists

Model Interaction:
---
Users can have multiple playlists.
A play list can have multiple songs
A song can be in mulitple playlists.


== STEP 1) Design schemas for all models
Discuss design decisions.


== STEP 2) create a keyspace music (similar to myflix)


== STEP 3) create tables for all models

Note :  To import this project into eclipse...
Use   'mvn  eclipse:eclipse'  to generate eclipse project

== STEP 4) Inspect the Song model
src/main/java/com/es/cassandra/Song.java
complete the 'save' function.

compile the code using 'mvn package'  command


== STEP 5) TestInsert
Inspect the file
src/main/java/com/es/cassandra/TestInsert.java

Complete TODO-1
compile the code using 'mvn package'  command


== STEP 6) Run the code
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestInsert

inspect the songs table in C* and see if values are populated correctly.


== STEP 7) Inspect the Playlist model
src/main/java/com/es/cassandra/Playlist.java
complete the 'save' function.

compile the code using 'mvn package'  command


== STEP 8) TestInsert
Inspect the file
src/main/java/com/es/cassandra/TestInsert.java

Complete TODO-2
compile the code using 'mvn package'  command


== STEP 9) Run the code
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestInsert

inspect the playlists table in C* and see if values are populated correctly.


== STEP 10) Inspect the User model
src/main/java/com/es/cassandra/User.java
complete the 'save' function.

compile the code using 'mvn package'  command


== STEP 11) TestInsert
Inspect the file
src/main/java/com/es/cassandra/TestInsert.java

Complete TODO-3
compile the code using 'mvn package'  command


== STEP 12) Run the code
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestInsert

inspect the user table in C* and see if values are populated correctly.


== STEP 13) Inspect TestQuery.java
src/main/java/com/es/cassandra/TestQuery.java

Using the query example for User model, complete queries for playlists and songs.

compile the code using 'mvn package'  command


== STEP 14) Run the code
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestQuery

Verify the output