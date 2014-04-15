# Generate Users

## ----- config
entries = 100
file_name = 'features.data'
keyspace = 'myflix'
## --- end config


import os
import datetime
import random

start_date = datetime.datetime(2000,1,1,0,0,0)
end_date = datetime.datetime(2014,1,1,0,0,0)
show_type = ['Movie', 'TV Show', 'Live Comedy']


def random_date(start, end):
    """
    This function will return a random datetime between two datetime
    objects.
    """
    delta = end - start
    int_delta = (delta.days * 24 * 60 * 60) + delta.seconds
    random_second = random.randrange(int_delta)
    return start + datetime.timedelta(seconds=random_second)


## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            code = "feature-%s" % x
            name = "Feature-%s" % x
            studio = "studio-%s" % random.randint(1,20)
            feature_type = random.choice(show_type)
            release_date = random_date(start_date, end_date).date()
            #print release_date


            logline = "INSERT INTO features(code, name, release_date, studio, type) VALUES('%s', '%s', '%s', '%s', '%s');" % (code, name, release_date, studio, feature_type)
            #print logline
            fout.write(logline + "\n")




