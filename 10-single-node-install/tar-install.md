<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) / [Install](README.md) 

Lab 10. Single Node Install / Tar Install
====================

### Overview
Tar install

### Depends On 
None

### Run time
20 mins


## STEP 1:  Login to the node
----------------------------


## STEP 2)  Install
----------------------------
Install Cassandra tar file
```
    $   cd
    $   tar xvf software/cassandra/dsc-cassandra-2.1.0-bin.tar.gz
```

This will install cassandra in ~/dsc-cassandra-2.1.0/

(Optional : To get the latest Cassandra, download and unpack Datastax community edition
```
    $   wget http://downloads.datastax.com/community/dsc.tar.gz
    $   tar xvf  dsc.tar.gz
```

This would create a directory 'dsc-cassandra-VERSION'
This directory would be 'CASSANDRA_INSTALL_DIR'
)


## STEP 3: Setup
----------------------------
By default cassandra stores data under `/var/lib/cassandra`.   
Create this directory and assign permissions.   
```
    $  sudo mkdir /var/lib/cassandra
    $  sudo chown $USER   /var/lib/cassandra
```

Also cassandra log directory is : `/var/log/cassandra`   
Lets create this directory too.
```
    $  sudo mkdir /var/log/cassandra
    $  sudo chown $USER   /var/log/cassandra
```


## STEP 4:  Configuration
----------------------------
Conf dir is : `CASSANDRA_INSTALL_DIR/conf`  
Inspect the file  : `cassandra.yml`.   
Verify the following properties in this file.  
- data_file_directories
- commitlog_directory


## STEP 5:  Start Cassandra
----------------------------
CASSANDRA_INSTALL_DIR/bin  will have C* executables
use `cassandra` command
```
    $   cd CASSANDRA_INSTALL_DIR
    $   ./bin/cassandra
```

Watch the console to make sure no errors.


## STEP 6:  Verifying Cassandra is running
Use `jps` command
```
    $  jps
```
Is there 'CassandraDaemon' running?

Use `nodetool` command
```
    $   CASSANDRA_INSTALL_DIR/bin/nodetool    status
```

Verify the output.


## STEP 7: Post Install
----------------------------
Follow [post-install.md](post-install.md)
