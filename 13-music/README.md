<link rel='stylesheet' href='../assets/css/main.css'/>

 

Bonus Lab 13 : Modeling Spotify
====================

### Overview
Model Spotify on C*  using Java APIs

### Depends On 
None

### Run time
1 hr


## Models in Music Service:
----------------------------
* Users
* Songs
* Playlists

## Model Interaction:
----------------------------
* Users can have multiple playlists.
* A play list can have multiple songs
* A song can be in mulitple playlists.


## STEP 1: Design Schemas For All Models
Discuss design decisions.


## STEP 2: Create A Keyspace 'music' (similar to myflix)


## STEP 3: Create Tables For All Models
----------------------------
Use   `mvn  eclipse:eclipse`  to generate eclipse project

## STEP 4: Inspect The Song model
----------------------------
file : `src/main/java/com/es/cassandra/Song.java`   
Complete the 'save' function.

Compile the code using `mvn package`  command.


## STEP 5) TestInsert
----------------------------
Inspect the file `src/main/java/com/es/cassandra/TestInsert.java`

Complete TODO-1
compile the code using 'mvn package'  command


## STEP 6: Run
----------------------------
```
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestInsert
```

Inspect the songs table in C* and see if values are populated correctly.


## STEP 7: Inspect the Playlist model
file : `src/main/java/com/es/cassandra/Playlist.java`   
Complete the 'save' function.

Compile the code using `mvn package`  command.


## STEP 8) TestInsert
----------------------------
Inspect the file : `src/main/java/com/es/cassandra/TestInsert.java`

Complete TODO-2.  
Compile the code using `mvn package`  command.  


## STEP 9: Run the code
----------------------------
```
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestInsert
```

Inspect the playlists table in C* and see if values are populated correctly.


## STEP 10: Inspect the User model
----------------------------
Inspect : `src/main/java/com/es/cassandra/User.java`   
Complete the 'save' function.

Compile the code using `mvn package`  command.


## STEP 11: TestInsert
----------------------------
Inspect the file : `src/main/java/com/es/cassandra/TestInsert.java`

Complete TODO-3.
Compile the code using `mvn package`  command.


## STEP 12: Run the code
----------------------------
```
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestInsert
```

Inspect the user table in C* and see if values are populated correctly.


## STEP 13: Test Query
----------------------------
Inspect `src/main/java/com/es/cassandra/TestQuery.java`

Using the query example for User model, complete queries for playlists and songs.

Compile the code using `mvn package`  command.


## STEP 14: Run the code
----------------------------
```
    $ java -cp target/music-1.0.0.jar:target/dependency-jars/*   com.es.cassandra.TestQuery
```

Verify the output.


## BONUS Lab: Data Modeling
----------------------------
So far we have hand-crafted queries for loading objects.  A better approach is each object loads it's data from C*.

Implement a method  in `Song.java`  
```
    Song load(String songId)
```
This method will retrieve the given song information from C* and create a `Song` java object with all the right values.

Similarly write load()  methods for Playlist and User models.

Write a Test code to exercise the load() methods.