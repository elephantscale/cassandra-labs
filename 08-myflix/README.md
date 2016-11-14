<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) 

Lab 07 : Modeling MyFlix on C*
====================

### Overview
Data modeling MyFlix in C*.
- Design myflix tables
- populate the tables with data

### Depends On 
None

### Run time
1 hour

### Solution
/labs-private/solutions/cassandra-solutions/myflix-solutions.txt

## STEP 1:  'features' Table
Note : If you already have this table defined, you may skip this step.
Or drop the previous table and re-create it as follows.
```
    $    ~/cassandra/bin/cqlsh
    cqlsh>
        use myflix;

        CREATE TABLE features (
                code text,
                name text,
                type text,
                release_date timestamp,
                studio text,
                PRIMARY KEY(code)
            );
```

## STEP 2: Populate 'features' Table
We are going to generate 'features' data.  
Script to use :  `generators/generate-features.py`  
Inspect the python script in `../generators/generate-features.py`  
Make any changes in config section
```
    $   vi  ../generators/generate-features.py
        or
    $   nano  ../generators/generate-features.py
```

Run the script to generate data
```
    $   python  ../generators/generate-features.py
```

This will generate  `features.data` file.  
Inspect the file.  
```
    $    head features.data
```
This file contains CQL statements to populate features table

Import the features.data
```
    $    ~/cassandra/bin/cqlsh   -f features.data
```

Verify the data from cqlsh
```
    $   ~/cassandra/bin/cqlsh
    cqlsh> 
        select * from  features limit 10;
```

## STEP 3:  Create Indexes For Features Table
We want to find all features by a particular studio, say 'HBO'
Try this query:
```
    cqlsh>   
        select *  from features where studio = 'HBO';
```

This query will fail,  we need to add an index.
syntax :
```
    cqlsh > 
        create  index   name_of_index  on table(column_name)
```

CQL Reference on indexes : http://www.datastax.com/documentation/cql/3.1/cql/cql_reference/create_index_r.html

Now do the same query again.

Also add an index on `type` column.  
Query for all features of type=Movie and studio=HBO.   
What is the result of query execution?  why?


## STEP 4: Users Table
Create a users table with the following attributes
    - user_name  : text  (primary key)
    - fname : text
    - lname : text
    - emails : list of text

Use  `../generators/generate-users.py`  script to generate users data.  
Import the data into users table.   
Follow similar import procedure as step 2.


## STEP 5) 'ratings_by_user' Table
Create `ratings_by_user` table with following attributes
    - user_name : text
    - feature_code : text
    - rating : int  // 1 -- 5
    - primary key (???,  ???)

Also create `ratings_by_feature` table
- what are the attributes
- and what is the primary key?


use script `../generators/generate-ratings.py`  to generate some ratings data and import it into the table.
Follow similar procedure in step (2)


## STEP 6: Populating  'ratings_by_feature' Table
In step-5 the `../generators/generate-ratings.py` script only populated `ratings_by_user` table.  Modify the script to add data for `ratings_by_feature` table.

Hint : look around line 31 in the python script

After updating the script, run it again and import the data.  
Hint : you may want to clear the data that is already in table `ratings_by_user` before re-importing  (using `truncate` command)


## STEP 7: Queries
```
    Q1 : select * from ratings_by_feature;
        what is the order / clustering order of data?

    Q2 : select * from ratings_by_user;
        what is the order / clustering order of data?

    Q3 : Find all ratings by a particular user

    Q4 : Find all ratings by a feature / movie

    Q5 : Find the best / worst rating for a movie
```

## STEP 8: Use 'cassandra-cli' To Inspect Data
```
    $   cassandra-cli
    cli>   use myflix;
    cli>   list ratings_by_user;
    cli>   list ratings_by_features;
```

**=> Q : how is c* storing the data?** 


## BONUS Lab 1:  Rating Distribution
For each movie, find out how ratings are distributed.
For example:
- rating 1 : given by 10 users
- rating 2 : given by 20 users
- ..etc

Interesting reads:
- https://www.cs.duke.edu/courses/spring09/cps296.3/lectures/12-colfil-multiscale.pdf


## BONUS Lab 2: Global Rating Distribution
Find out how many movies have a particular rating.
Example:
- 70 movies have rating 1
- 100 movies have rating 2
- ...etc