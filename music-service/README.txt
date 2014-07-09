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


== STEP 1) Create table schemas for all models.
Discuss design decisions.


== STEP 2) Complete data generators that will generate some data

== STEP 3) Write main / driver program to do the following:
- given a userid
- print out all play lists that is owned by user
- and all songs for each play list

e.g sample output:

user1 : 3 play lists , 10 songs
    list 1)  Workout  (3 songs)
        song1
        song2
        song3

    list 2) Chill Out (2 songs)
        song4
        song5

    list 3) Party Music (3 songs)
        song2  (also on Workout list)
        song6
        song7
