<link rel='stylesheet' href='../assets/css/main.css'/>

 

Bonus Lab 14 : Spring And C*
====================

### Overview
Use Spring APIs to interact with C*

### Depends On 
None

### Run time
1 hr


## STEP1: Prepare
----------------------------
```
    $ cqlsh
    cqlsh> 

        CREATE KEYSPACE    IF NOT EXISTS   myflix
                WITH REPLICATION = {
                    'class' : 'SimpleStrategy',
                    'replication_factor' : 1
                    };

        USE myflix;

        CREATE TABLE poets (
                    id int,
                    address text,
                    name text,
                    PRIMARY KEY(id)
                );

        INSERT INTO poets (id, address, name) values (1, 'England', 'John Donne');
        INSERT INTO poets (id, address, name) values (2, 'France', 'Michel Montaigne');
        INSERT INTO poets (id, address, name) values (3, 'England', 'Bill Shakespeare');
```


## STEP 2: Inspect Code
----------------------------
* Poet Model : `src/main/java/com/devjavasource/cassandra/dto/Poet.java`
* Application : `src/main/java/com/devjavasource/cassandra/SpringDataCassandra/App.java`


## STEP 3: Build And Run
----------------------------
```
    $  mvn clean install
```

Observe the results with
```
    $  mvn test
```
