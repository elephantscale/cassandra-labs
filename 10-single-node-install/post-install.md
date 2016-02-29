<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) / [Install](README.md) 

Lab 10. Single Node Install / Post Install
====================

### Overview
Post

### Depends On 
None

### Run time
20 mins

## STEP 1:  cqlsh
----------------------------
Start cqlsh and interact with C*.  
In tar install cqlsh can be found : /path/to/cassandra/install/bin/cqlsh
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

        exit;
```


## STEP 2:  Stress Test
----------------------------
We will use `cassandra-stress` tool.  
In tar installs cassandra-stress will be in : `/path/to/cassandra/install/tools/bin/cassandra-stress`

```
   $   cassandra-stress  help
```

Will print out help.

Before running the stress test, open another terminal to the node.
Run `atop` command on this terminal
```
    $ atop
```

If atop is not installed, do
```
    $ sudo yum install -y atop
```

Now lets run a write test
```
   $   cassandra-stress  write
   (older versions 'cassandra-stress  -t 8 ')
```

Look at atop output (You may want to make atop terminal window wider).  
Which component (cpu, mem, disk) is busy?

Also use `iostat` command to see disk IO stats.

Interpreting stress-test results:
- http://www.datastax.com/documentation/cassandra/1.2/cassandra/tools/toolsCStressOutput_c.html
- http://www.datastax.com/docs/1.1/references/stress_java

We just ran a 'insert' benchmark.  
Also run a 'read' benchmark.  