Cassandra Intro
----------------
Objective : Get familiar with C* command line shell

command : cqlsh
It can be found in  CASSANDRA_INSTALL_DIR/bin  directory

== STEP 1)  Invoke cqlsh
    $  cqlsh
you should see the prompt
    cqlsh>


== STEP 2) Tips for CSQL : Use Help
to get help use 'help'  or '?'
    cqlsh>   ?
    cqlsh>  help

and use help for keyword
    cqlsh>   help <keyword>;
    cqlsh>   help  describe;


== STEP 3) Make use of 'tab completion' to save some typing.
Type a command and hit 'Tab' key.  Hit Tab again to see all possible matches
Try this:
    cqlsh>  descr<Tab>   <Tab> again

    cqlsh>  describe cluster;
output might look like:
        Cluster: Test Cluster
        Partitioner: Murmur3Partitioner
        Snitch: SimpleSnitch


== STEP 4)  Inspect existing keyspaces
hint : use 'describe' command  (help describe)
what keyspaces do you see?


== STEP 5)  get details of  keyspace 'system'
hint : use describe command
inspect the output