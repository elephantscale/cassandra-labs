<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md)

Lab 02 : CQL Introduction
=========================

### Overview
Learning CQL

### Depends On
None

### Run time
20 mins


## STEP 1 : CQL Reference
[CQL Reference Docs](http://docs.datastax.com/en//cql/latest/cql/cqlIntro.html)

## STEP 2 : Create A Table
Follow [create.md](2.1-create.md)

## STEP 3 : Insert Some Data
Follow [insert.md](2.2-insert.md)

## STEP 4 : Query Data
Follow [query.md](2.3-query.md)

## STEP 5 : Alter Table
Follow [alter.md](2.4-alter.md)

## STEP 6 : Update
Follow [update.md](2.5-update.md)

## STEP 7 : Delete
Follow [delete.md](2.6-delete.md)

## Step 8 : Restore Data
Dropped all data?  Use the following to get the data back..
```
    $    ~/cassandra/bin/cqlsh   -f   ~/cassandra-labs/02-cql/features.cql
```
