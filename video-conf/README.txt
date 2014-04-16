Video Conference
-------------------
Models:
- Video Conference
- Users
- Metrics

- A video conference has multiple users
    . conference id  (uniq)

- A user can participate in multiple conferences
    . user_id (uniq)

- metrics are collected for each conference
  metrics are sent every minute during the conference
    . user_id
    . IP address
    . network provider (comcast, t-mobile ..etc)
    . quality  (a percentage 1-100)
    . device type (iphone, ipad, PC, Mac)
    . geo (location : San Jose ..etc)
    . timestamp


Task 1 : Design tables for the models to support the following queries
    q1 : find all users invited for a conference

    q2 : find all conferences a user participated in


Task 2 : create data generators to generate some fake data
(copy and modify one from generators/)
generate users
generate conferences


Task 3 : Design table to hold metrics
keep in mind, there can be 100s of millions of these


Task 4 : Write a Java client that 'streams' metrics into C*
Adjust  Insert.java under java-driver/


Task 5 :  Write a Java class  Conference.java
implement functions:
    - getUsers()
    - getMetrics()


Task 6 : Find average quality for each network providers