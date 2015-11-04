Spring Cassandra Example
-----------------------

==> STEP1. To prepare for lab, do this

CREATE KEYSPACE    IF NOT EXISTS   devjavasource
        WITH REPLICATION = {
            'class' : 'SimpleStrategy',
            'replication_factor' : 1
            };

USE devjavasource;

CREATE TABLE users (
            id int,
            address text,
            name text,
            PRIMARY KEY(id)
        );

INSERT INTO users (id, address, name) values (1, 'England', 'John Donne');
INSERT INTO users (id, address, name) values (2, 'Michel', 'Montagne');
INSERT INTO users (id, address, name) values (3, 'Bill', 'Shakespeare');

==> STEP 2

Run the project by doing

mvn clean install

Observe the results with

mvn test

==> STEP 3

Modify the code to show a different 'user'

Source http://www.devjavasource.com/cassandra/spring-data-cassandra-hello-world-example/