# Generate Ratings

## ----- config
entries = 1000
file_name = 'ratings.data'
keyspace = 'myflix'
table = 'ratings_by_user'
table2 = 'ratings_by_feature'
## --- end config
user_entries = entries / 10

import os
import datetime
import random

## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            user_name = "user-%s" % random.randint(1,user_entries)
            feature_name = "feature-%s" % random.randint(1,user_entries)
            rating = random.randint(1,5)


            logline = "INSERT INTO %s(user_name, feature_code, rating) VALUES('%s', '%s', %s);" % (table, user_name, feature_name, rating)
            fout.write(logline + "\n")

            # second table : raitings_by_feature
            logline = "INSERT INTO %s(user_name, feature_code, rating) VALUES('%s', '%s', %s);" % (table2, user_name, feature_name, rating)
            fout.write(logline + "\n")
