Lab : Single Node Install of Cassandra
-----

== STEP 1)
Login to the node (instructor will provide details)


== STEP 2)
you can install cassandra one of two ways
    - rpm based install (follow rpm-install.txt)
    - or tar file based install (follow tar-install.txt)


== STEP 3) follow file : post-install.txt


== STEP 4)  install ops-center
follow ops-center.txt


== STEP 5) Optimizing C*
Our EC2 instances are using /var/lib/cassandra for storage
This directory is on a EBS device
    Not very high IO
Ephemeral disks are ‘local’, and provide higher IO

Use 'df -kh'  command to see what disks are available.

Lets see the IO throughput on both devices. we will use 'dd' command

    $   sudo dd  if=/dev/zero  of=/tmp/a   bs=1M  count=1000  conv=fsync

Explanation:
    - if : input file,  we read from a special device file that always returns zero
    - of : output file, destination file we want to write to
    - bs : block size , 1 Mega bytes
    - count : how many blocks to write, 1000
    - conv : fsync forces dd to flush data to disk at the end
    - we are writing 1G of data (1M x 1000)


Now do the same dd command to ephemeral disk.  Change the output file to a file on ephemeral disk (e.g. :  /media/ephemeral0/a)

Any noticeable difference?

Move cassandra directory from EBS storage to ephemeral storage
Create  a cassandra dir in ephemeral storage  (/media/ephemeral0)
Set correct permissions for this dir
Update config files and restart c*
Do benchmarks before & after (using cassandra-stress  tool)

