<link rel='stylesheet' href='../assets/css/main.css'/>

 / [Install](README.md) 

Lab 10. Single Node Install / RPM Install
====================

### Overview
RPM install

### Depends On 
None

### Run time
20 mins


## Step 1 Install the libaio package. For example:

```bash
sudo apt-get update
sudo apt-get install libaio1
````

## Step 2: Add apt repository


```bash
echo "deb https://debian.datastax.com/enterprise \
stable main" | sudo tee -a /etc/apt/sources.list.d/datastax.sources.list
```


## Step 3: Add datastax Repository Key

``` bash
curl -L https://debian.datastax.com/debian/repo_key | sudo apt-key add -
```

## Step 4: Verify Java


Verify that a required version of Java is installed:
```bash
java -version
```
Note: DataStax recommends the latest build of a Technology Compatibility Kit (TCK) Certified OpenJDK version 8.

If OpenJDK, the results should look like:

```console
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (build 1.8.0_242-b09)
OpenJDK 64-Bit Server VM (build 25.242-b09, mixed mode)
If Oracle Java, the results should look like:
java version "1.8.0_241"
Java(TM) SE Runtime Environment (build 1.8.0_241-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.241-b13, mixed mode)
```

If not OpenJDK 8 or Oracle Java 8, see Installing the JDK.


```

## Update the packages:

```bash
sudo apt-get update
```

## Step 5: Install the DataStax Enterprise packages:

Attention: Specify all packages; otherwise, the installation fails.

Install the latest version (6.8.x):

```bash
sudo apt-get install dse-full
````

```bash
sudo apt-get install dse=version_number-1 \
    dse-full=version_number-1 \
    dse-libcassandra=version_number-1 \
    dse-libgraph=version_number-1 \
    dse-libhadoop2-client-native=version_number-1 \
    dse-libhadoop2-client=version_number-1 \
    dse-liblog4j=version_number-1 \
    dse-libsolr=version_number-1 \
    dse-libspark=version_number-1 \
    dse-libtomcat=version_number-1
```

For example:

Attention: Specify all packages; otherwise, the installation fails.

```bash
sudo apt-get install dse=6.8.0-1 \
    dse-full=6.8.0-1 \
    dse-libcassandra=6.8.0-1 \
    dse-libgraph=6.8.0-1 \
    dse-libhadoop2-client-native=6.8.0-1 \
    dse-libhadoop2-client=6.8.0-1 \
    dse-liblog4j=6.8.0-1 \
    dse-libsolr=6.8.0-1 \
    dse-libspark=6.8.0-1 \
    dse-libtomcat=6.8.0-1
```

Optional: Install the demos:

Attention: Installing the DSE demos is not recommended for production. Only install the demos in development environments to run tutorials.

```bash
sudo apt-get install dse-demos=version_number-1
```

### Result

DataStax Enterprise is ready for additional configuration:

For production, be sure to change the cassandra user. Failing to do so is a security risk. See Adding a superuser login.

DataStax Enterprise provides several types of workloads (default is transactional). See startup options for service or stand-alone installations.

What's next below provides links to related tasks and information.

Optional: Single-node cluster installations only:

## Start DataStax Enterprise:

```bash 
sudo service dse start

```
## Verify that DataStax Enterprise is running:

```console
$ nodetool status

Datacenter: Cassandra
=====================
Status=Up/Down
|/ State=Normal/Leaving/Joining/Moving
--  Address    Load       Tokens  Owns    Host ID                               Rack
UN  127.0.0.1  82.43 KB   128     ?       40725dc8-7843-43ae-9c98-7c532b1f517e  rack1

```



## STEP 7: Post Install
----------------------------
Follow [post-install.md](post-install.md)




