<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md)  / [CQL](README.md)

Lab 2.5 : Indexing
==================

### Overview
Use indexing support in C*

### Depends On 
None

### Run time
10 mins


## STEP 1 : CQL Reference
[CQL Reference Docs](http://docs.datastax.com/en//cql/latest/cql/cqlIntro.html)


## STEP 2:  Restore 'features' table
If you had dropped `features` table restore it as follows.
```
    $   cd ~/cassandra-labs

    $   cqlsh -f features.cql
```


## STEP 3:  Invoke cqlsh
```
    $  cqlsh
```

##  STEP 4: Try This Query 
```
    cqlsh>
        use myflix;

        select * from features where type = 'TV Show’;
```
**=> what is the result?**


##  STEP 5: Add an Index On 'Features' Table
Enter the following in cqlsh
```
    cqlsh>

        -- use myflix;

        create index idx_type ON features (type)

        describe table features;
```

##  STEP 6: Try The Query Again
```
    cqlsh>
        select * from features where type = 'TV Show’;
```

Your result may look like the following:
```console
code   | name     | release_date             | studio | type
--------+----------+--------------------------+--------+---------
 madmen | Mad Men2 | 2010-01-01 00:00:00+0000 |    AMC | TV Show
   sopr | Sopranos | 2008-06-01 00:00:00+0000 |    HBO | TV Show

```

