Lab : Single Node Install of Cassandra

== STEP 1)  Login to the node


== STEP 2)  Download and unpack Datastax community edition
    $   wget http://downloads.datastax.com/community/dsc.tar.gz
    $   tar xvf  dsc.tar.gz

This would create a directory 'dsc-cassandra-VERSION'
This directory would be 'CASSANDRA_INSTALL_DIR'


== STEP 3) Setup Cassandra directories
By default cassandra stores data under /var/lib/cassandra
Create this directory and assign permissions
    $  sudo mkdir /var/lib/cassandra
    $  sudo chown $USER   /var/lib/cassandra

Also cassandra log directory is : /var/log/cassandra
Lets create this directory too
    $  sudo mkdir /var/log/cassandra
    $  sudo chown $USER   /var/log/cassandra


== STEP 4)  Inspect cassandra configuration
Configuration is in :  CASSANDRA_INSTALL_DIR/conf
inspect the file  : cassandra.yml
verify the following properties in this file
    data_file_directories
    commitlog_directory


== STEP 5)  Start Cassandra
CASSANDRA_INSTALL_DIR/bin  will have C* executables
use 'cassandra' command
    $   cd CASSANDRA_INSTALL_DIR
    $   ./bin/cassandra

Watch the console to make sure no errors


== STEP 6)  Verifying Cassandra is running
Use 'jps' command
    $  jps
Is there 'CassandraDaemon' running?

Use 'nodetool'
    $   cd CASSANDRA_INSTALL_DIR
    $   ./bin/nodetool status
verify the output


== STEP 7)  cqlsh
Start cqlsh and interact with C*

    $   cd CASSANDRA_INSTALL_DIR
    $   ./bin/cqlsh

    cqlsh>   describe cluster;

    cqlsh>    CREATE KEYSPACE test
              WITH REPLICATION = {
              'class' : 'SimpleStrategy',
              'replication_factor' : 1
              };

    cqlsh>  use test;

    cqlsh>  CREATE TABLE users (
                userid  text,
                name  text,
                PRIMARY KEY (userid)
            );

    cqlsh>
        INSERT INTO users(userid, name) VALUES ('user1',  'Frodo');
        INSERT INTO users(userid, name) VALUES ('user2',  'Sam');
        INSERT INTO users(userid, name) VALUES ('user3',  'Perigrin');


    cqlsh>  select * from users;


    cqlsh> exit;


== STEP 8)  Do a stress test
We will use 'cassandra-stress' tool
   $   cd CASSANDRA_INSTALL_DIR
   $   ./tools/bin/cassandra-stress  -h
will print out help

Before running the stress test, open another terminal to the server;
run 'atop' command on this terminal
    $ atop

now lets run the stress
   $  ./tools/bin/cassandra-stress  -t 8


Look at atop output (You may want to make atop terminal window wider)
    which component (cpu, mem, disk) is busy?


we just rant a 'insert' benchmark.  Run a 'read' benchmark