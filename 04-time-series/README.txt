Lab : Time Series

== STEP 1) start cqlsh
    $   cqlsh


== STEP 2) Define sensor table
    cqlsh>
            CREATE TABLE sensors (
                sensor_id text,
                time  timestamp,
                temperature  float,
                humidity  float,
                co_level float,

                PRIMARY KEY (sensor_id,  time)

            )
            WITH CLUSTERING ORDER BY (time DESC);


== STEP 3)  insert some data
    cqlsh>
        INSERT INTO sensors(sensor_id, time, temperature, humidity, co_level)
        VALUES ('sensor1', '2014-01-01 10:00:00',  72,  34, 1.5);

        INSERT INTO sensors(sensor_id, time, temperature, humidity, co_level)
        VALUES ('sensor1', '2014-01-01 10:00:10',  72.5,  34.4, 1.5);

        INSERT INTO sensors(sensor_id, time, temperature, humidity, co_level)
        VALUES ('sensor2', '2014-01-01 10:00:00',  42,  84, 3.5);

        INSERT INTO sensors(sensor_id, time, temperature, humidity, co_level)
        VALUES ('sensor2', '2014-01-01 10:00:10',  44,  84, 3.6);

        INSERT INTO sensors(sensor_id, time, temperature, humidity, co_level)
        VALUES ('sensor1', '2014-01-01 10:00:30',  74,  34, 2.6);

verify data
    cqlsh>   select * from sensors;

Inspect the sort order  on time.  Which record is first?


== STEP 4)  get the latest data from sensor1
    cqlsh>    select * from sensors  where sensor_id = 'sensor1' LIMIT 1;

do you get the earliest time or latest time?


== STEP 5)  Find all sensor readings after a certain time  (2014-01-01 10:00:10)
    cqlsh>   SELECT ........ WHERE   time > .....

what happens when you run the query?


== BONUS LAB ) Create a table partitioned by sensor_id and month
Hint:
    create table .... (
        ....
        month text,

        PRIMARY KEY ( (sensor_id, month),  time)
    )
    WITH CLUSTERING ORDER BY (time DESC);

insert some sample data:
INSERT INTO sensors(sensor_id, time, month, temperature, humidity, co_level)
VALUES ('sensor1', '2014-01-01 10:00:30', '2014-01',  74,  34, 2.6);

Query table and look at the sorting order
