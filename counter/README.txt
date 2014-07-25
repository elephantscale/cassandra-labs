Counter lab

== STEP 1) create a table for storing counters
(we don't mix counter values in regular tables)

CREATE TABLE count_pageviews (
    visits counter,
    url varchar,
  PRIMARY KEY (url)
);


== STEP 2) query counter table


== STEP 3) increment counter
    UPDATE count_pageviews
    SET visits = visits + 1
    WHERE url ='http://www.mysite.com'

query the table


== STEP 4) repeat step (3) a few times and query the table
change the 'url' to different values.
e.g.  url = 'http://www.mysite.com/page1.html'
