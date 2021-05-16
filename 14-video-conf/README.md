<link rel='stylesheet' href='../assets/css/main.css'/>

 

Bonus Lab 15 : Modeling WebEx / Video Conferencing
====================

### Overview
Model a video conference system on C*

### Depends On 
None

### Run time
1 hr

## Models:
----------------------------
* Video Conference
* Users
* Metrics

## Model Interactions
* A video conference has multiple users
    * conference id  (uniq)

* A user can participate in multiple conferences
    * user_id (uniq)

* metrics are collected for each conference.  
  metrics are sent every minute during the conference
    * user_id
    * IP address
    * network provider (comcast, t-mobile ..etc)
    * quality  (a percentage 1-100)
    * device type (iphone, ipad, PC, Mac)
    * geo (location : San Jose ..etc)
    * timestamp


## Step 1: Design Tables

* q1 : find all users invited for a conference

* q2 : find all conferences a user participated in


## Step 2 : Generate Data
(copy and modify one from generators/)
generate users
generate conferences


## Step 3 : Design table to hold metrics
keep in mind, there can be 100s of millions of these


## Step 4 : Write a Java client that 'streams' metrics into C*
Adjust  Insert.java under java-driver/


## Step 5 :  Write a Java class  Conference.java
implement functions:
    - getUsers()
    - getMetrics()


## Step 6 : Find average quality for each network providers