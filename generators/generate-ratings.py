# Generate Ratings

## ----- config
entries = 100
file_name = 'ratings.data'
keyspace = 'myflix'
table = 'ratings_by_user'
## --- end config

import os
import datetime
import random

## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            user_name = "user-%s" % random.randint(1,entries)
            feature_name = "feature-%s" % random.randint(1,entries)
            rating = random.randint(1,5)


            logline = "INSERT INTO %s(user_name, feature_name, rating) VALUES('%s', '%s', %s);" % (table, user_name, feature_name, rating)
            #print logline
            fout.write(logline + "\n")
