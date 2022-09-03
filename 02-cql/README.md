<link rel='stylesheet' href='../assets/css/main.css'/>


# Lab 02: CQL Introduction

## Overview

Learning CQL

## Depends On

None

## Run time

20 mins


## STEP 0: CQL Reference

[CQL Reference Docs](https://cassandra.apache.org/doc/latest/cassandra/cql/index.html)

## STEP 1: Create A Table

Follow [create.md](2.1-create.md)

## STEP 2: Insert Some Data

Follow [insert.md](2.2-insert.md)

## STEP 3: Query Data

Follow [query.md](2.3-query.md)

## STEP 4: Alter Table

Follow [alter.md](2.4-alter.md)

## STEP 5: Update

Follow [update.md](2.5-update.md)

## STEP 6: Delete

Follow [delete.md](2.6-delete.md)

## Step 7: Restore all data

Dropped all data?  Use the following to get the data back.
```
    $   ~/apps/cassandra/bin/cqlsh   -f   ~/cassandra-labs/02-cql/features.cql
```
