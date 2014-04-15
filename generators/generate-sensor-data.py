# Generate Users

## ----- config
entries = 100
file_name = 'sensor.data'
keyspace = 'myflix'
## --- end config


import os
import datetime
import random

start_date = datetime.datetime(2014,1,1,0,0,0)
end_date = datetime.datetime(2014,4,1,0,0,0)


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
            sensor_id = "sensor-%s" % random.randint(1,entries)
            timestamp = random_date(start_date, end_date)
            month = timestamp.strftime("%Y-%m")  #2014-04
            temp = round(random.uniform(30,90), 1)
            humidity = random.randint(20,100)


            logline = "INSERT INTO sensors(sensor_id, time, temperature, humidity) VALUES('%s', '%s', %s, %s);" % (sensor_id, timestamp, temp, humidity)

            # for partitioning by month (bonus lab)
            #logline = "INSERT INTO sensors(sensor_id, time, month, temperature, humidity) VALUES('%s', '%s', '%s', %s, %s);" % (sensor_id, timestamp, month, temp, humidity)

            #print logline
            fout.write(logline + "\n")
