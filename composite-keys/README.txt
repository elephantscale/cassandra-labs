Lab : composite keys

== STEP 1)  launch csqlsh
    $ csqlsh


== STEP 2)  Define cities table
    cqlsh>  use myflix;   // select keyspace

    cqlsh>
            CREATE TABLE cities (
                    country text,
                    city text,
                    population int,
                    PRIMARY KEY (country, city)
             );


== STEP 3)  Insert some sample data
    cqlsh>
        INSERT INTO cities (country, city, population)  VALUES ('USA', 'Melbourne', 10);
        INSERT INTO cities (country, city, population)  VALUES ('Australia', 'Melbourne', 20);
        INSERT INTO cities (country, city, population)  VALUES ('Australia', 'Sydney', 30);
        INSERT INTO cities (country, city, population)  VALUES ('Ireland', 'Sydney', 30);
        INSERT INTO cities (country, city, population)  VALUES ('Columbia', 'San Jose', 40);
        INSERT INTO cities (country, city, population)  VALUES ('USA', 'San Jose', 40);
        INSERT INTO cities (country, city, population)  VALUES ('USA', 'San Francisco', 40);

verify data
    cqlsh>   select * from cities;

Q : Is there a sorting order?

== STEP 4)  query cities in country 'USA'
    cqlsh>    SELECT * FROM cities  WHERE country = 'USA';


== STEP 5)  find all cities named 'Melbourne'

what is the query result?
Try 'ALLOW FILTERING'
    SELECT ......  WHERE .....  ALLOW FILTERING;


== STEP 6)  find all cities with population = 20
what is the query result?  why?
