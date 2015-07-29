Cassandra Labs
--------------

To zip up labs without .git folder
        $   git archive --format=zip HEAD -o cassandra-labs.zip

----
Lab order
------
    intro
    cql
    collections
    composite-keys
    time-series
    counter
    myflix
    java-driver
    single-node-install
    debug
    gmail  (bonus lab)
    music  (bonus lab)

Usage:
--
For first part of class use Amazon AMI : ami-67dcc10e
m1.medium is ok
username : ec2-user
password : usual
ssh key : cassandra-labs2.pem

To login to cluster
    $   ssh -i  cassandra-labs2.pem   ec2-user@host_ip_address

Verify Cassandra is running by
    $   nodetool  status


For install lab, spin up instances of CLEAN centos VMs
AMI :
