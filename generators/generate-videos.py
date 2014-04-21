# Generate Videos

## ----- config
entries = 100
map_entries = 10
file_name = 'videos.data'
keyspace = 'myflix'
table = 'videos'
## --- end config

import os
import datetime as dt
import random
import uuid

## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            video_id = uuid.uuid1()
            user_name = "user%s" % random.randint(1,100)
            video_name = "video %s" % x
            location = {'us' : 'http://right.here'}

            num_tags = random.randint(1,3)
            tags = []
            for y  in range(1, num_tags+1):
                tags.append("'tag%s'" % y)
            all_tags = "{" + ','.join(tags) + "}"

            logline = "INSERT INTO %s(video_id, video_name, user_name, tags) VALUES(%s, '%s', '%s', %s);" % (table, video_id, video_name, user_name, all_tags)
            #print logline
            fout.write(logline + "\n")
