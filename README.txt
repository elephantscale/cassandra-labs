Cassandra Labs
--------------

Amazon AMI : ami-67dcc10e
Use m3.large  or m3.xlarge instances (These instances have SSDs!)
username : ec2-user
ssh key : cassandra-labs2.pem

To login to cluster
    $   ssh -i  cassandra-labs2.pem   ec2-user@host_ip_address

Verify Cassandra is running by
    $   nodetools  status