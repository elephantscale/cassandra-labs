# Generate Videos

## ----- config
entries = 100
map_entries = 10
file_name = 'videos.data'
keyspace = 'myflix'
table = 'videos'
table2 = 'username_videos_index'
## --- end config

import os
import datetime as dt
import random
import uuid

from myutils import *

start_date = datetime.datetime(2010,1,1,0,0,0)
end_date = datetime.datetime(2014,1,1,0,0,0)

## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            video_id = uuid.uuid1()
            user_name = "user-%s" % random.randint(1,100)
            video_name = "video %s" % x
            location = 'http://cdn.com/video/%s' % video_id
            upload_time = random_timestamp(start_date, end_date)

            num_tags = random.randint(1,3)
            tags = []
            for y  in range(1, num_tags+1):
                tags.append("'tag%s'" % y)
            all_tags = "{" + ','.join(tags) + "}"

            logline = "INSERT INTO %s(video_id, video_name, user_name, tags, upload_date) VALUES(%s, '%s', '%s', %s, '%s');" % (table, video_id, video_name, user_name, all_tags, upload_time)
            fout.write(logline + "\n")

            #TODO : also insert the data into videos_by_users table
