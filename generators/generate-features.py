# Generate Features

## ----- config
entries = 100
file_name = 'features.data'
keyspace = 'myflix'
table = 'features'
## --- end config


import os
import datetime
import random
from myutils import *

start_date = datetime.datetime(2000,1,1,0,0,0)
end_date = datetime.datetime(2014,1,1,0,0,0)
show_type = ['Movie', 'TV Show', 'Live Comedy']
studios = ['HBO', 'Disney',  'FOX', 'ABC', 'Columbia', 'Netflix', 'FX', 'Lucas']



## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            code = "feature-%s" % x
            name = "Feature %s" % x
            studio = random.choice(studios)
            feature_type = random.choice(show_type)
            release_date = random_timestamp(start_date, end_date).date()
            #print release_date

            logline = "INSERT INTO %s(code, name, release_date, studio, type) VALUES('%s', '%s', '%s', '%s', '%s');" % (table, code, name, release_date, studio, feature_type)
            #print logline
            fout.write(logline + "\n")
