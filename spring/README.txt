Spring Cassandra Example
-----------------------

==> STEP1. To prepare for lab, do this

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

==> STEP 2

Run the project by doing

mvn clean install

Observe the results with

mvn test

==> STEP 3

Modify the code to read information about a different poet