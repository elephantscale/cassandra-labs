<link rel='stylesheet' href='../assets/css/main.css'/>

[<< back to main index](../README.md) 

Lab 06 : Counters
=================

### Overview
Using counters

### Depends On 
None

### Run time
45 mins


## STEP 1: Create a Counter Table
We don't mix counter values in regular tables.

```
    $  cqlsh
    cqlsh> 
        CREATE TABLE count_pageviews (
            visits counter,
            url varchar,
          PRIMARY KEY (url)
        );
```



## STEP 2: Update Counters
```
    cqlsh> 
        UPDATE count_pageviews
        SET visits = visits + 1
        WHERE url ='http://www.mysite.com'
```

Query the table:
```
    cqlsh>
        select * from count_pageviews;
```


## STEP 3: Repeat STEP-2 
Change the `url` to different values.  
e.g.  url = 'http://www.mysite.com/page1.html'
