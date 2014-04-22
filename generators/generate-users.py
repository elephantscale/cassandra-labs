# Generate Users

## ----- config
entries = 100
file_name = 'users.data'
keyspace = 'myflix'
table = 'users'
## --- end config


import os
import datetime as dt
import random

## --- script main
if __name__ == '__main__':
    with open(file_name, "w") as fout:
        print "generating file ", file_name

        fout.write("use %s;\n\n" % keyspace)

        for x in range(1, entries+1):
            username = "user-%s" % x
            fname = "Joe %s" % x
            lname = "Smith %s" % x

            num_emails = random.randint(1,3)
            emails = []
            for y in range(1, num_emails+1):
                emails.append("'user-%s.%s@email.com'" % (x, y))

            all_emails = "[" + ','.join(emails) + "]"

            logline = "INSERT INTO %s(user_name, fname, lname, emails) VALUES('%s', '%s', '%s', %s);" % (table, username, fname, lname, all_emails)
            #print logline
            fout.write(logline + "\n")
