<link rel='stylesheet' href='../assets/css/main.css'/>

Lab 09: Java Drivers
====================

### Overview

Learn to use Java drivers to interact with Apache Cassandra (C*). Java drivers provide a way for Java applications to connect to and communicate with Cassandra clusters, enabling data operations such
as inserts, queries, and more.

### Depends On

None. This lab is self-contained and does not require any prior labs.

### Run time

4 hours. This includes time for understanding the concepts, writing code, and experimenting with different driver features.

### Java driver docs:

[DataStax Java Driver 3.x Documentation](https://docs.datastax.com/en/developer/java-driver/3.11/)

## Labs

- [1. Connect](9.1-connect.md) : Connect to a Cassandra cluster. This lab will guide you through establishing a connection to your Cassandra database using the Java driver.
- [2. Insert](9.2-insert.md): Insert data into the Cassandra database. You'll learn how to create and execute insert statements to add records to your database.
- [3. Query](9.3-query.md): Execute queries to retrieve data. This section focuses on reading data from Cassandra using simple and complex queries.
- [4. Async](9.4-async.md): Perform asynchronous queries. Learn how to use asynchronous operations to improve the performance of your application by handling database requests without blocking the 
  main thread.
