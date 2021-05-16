<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) / [Debugging](README.md)

Lab 11.1: C* Tracing
====================

### Overview
Tracing

### Depends On
None

### Run time
20 mins


## STEP 1: Setup
Create a table and populate with some data.  
Note : If you already have a table with data, you can skip this step..
```
    $   cqlsh
    cqlsh>   
          describe cluster;

          CREATE KEYSPACE test
              WITH REPLICATION = {
              'class' : 'SimpleStrategy',
              'replication_factor' : 1
              };

         use test;

         CREATE TABLE users (
                userid  text,
                name  text,
                PRIMARY KEY (userid)
            );

        INSERT INTO users(userid, name) VALUES ('user1',  'Frodo');
        INSERT INTO users(userid, name) VALUES ('user2',  'Sam');
        INSERT INTO users(userid, name) VALUES ('user3',  'Perigrin');

        select * from users;
```

## STEP 2:  Turn On Tracing
Query with tracing ON.

```
    cqlsh>   
          TRACING ON;

          select * from users
```

Inspect the tracing output.


## STEP 3: Find where data is located
Which node has my data?  
We will use 'getendpoints' options in nodetool.

Usage:
```bash
  $ ~/apps/cassandra/bin/nodetool getendpoints   keyspace  table  primary_key
```

Try:
```bash
  $ ~/apps/cassandra/bin/nodetool getendpoints   myflix  features  'sopr'
```
