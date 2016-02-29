<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) / [Install](README.md) 

Lab 10. Single Node Install / RPM Install
====================

### Overview
RPM install

### Depends On 
None

### Run time
20 mins



## STEP 1:  Login
----------------------------
Make sure this is a CentOS based machine.

Pre-requisites:
- need root or sudo access
- java 7 installed
    test it with   'java -version'  command


## STEP 2:  Add yum repository
----------------------------
Create a file `/etc/yum.repos.d/datastax.repo`
```
    $   sudo vi /etc/yum.repos.d/datastax.repo
```
add the following content to this file

```
[datastax]
name = DataStax Repository
baseurl = http://rpm.datastax.com/community
enabled = 1
gpgcheck = 0
```

Save and exit

## STEP 3: Install Cassandra
----------------------------
We will be installing cassandra 3.x.
To find the versions available for install:
```
    $  sudo yum update
    $  yum list | grep cassandra
```

Install:
```
    $   sudo yum install -y cassandra30.noarch  cassandra30-tools.noarch
```

## STEP 4:  Start Cassandra
----------------------------
```
    $  sudo service cassandra start
```


## STEP 5: [Optional]  Inspect cassandra configuration
----------------------------
Conf dir is : `/etc/cassandra/conf`  
Inspect the file  : `cassandra.yaml`   
Verify the following properties in this file
- data_file_directories
- commitlog_directory



## STEP 6:  Verifying Cassandra Is Running
----------------------------
```
    $  ps -ef  | grep  cassandra
```

Use `nodetool` command
```
    $   nodetool    status
```
Verify the output



## STEP 7: Post Install
----------------------------
Follow [post-install.md](post-install.md)
