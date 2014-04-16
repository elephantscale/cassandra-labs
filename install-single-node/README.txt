Lab : Single Node Install of Cassandra
-----

== STEP 1)
Login to the node (instructor will provide details)


== STEP 2)
you can install cassandra one of two ways
    - rpm based install (follow rpm-install.txt)
    - or tar file based install (follow tar-install.txt)


== STEP 3)  install ops-center
follow ops-center.txt


== STEP 4) Optimizing C*
Our EC2 instances are using /var/lib/cassandra for storage
This directory is on a EBS device
    Not very high IO
Ephemeral disks are ‘local’, and provide higher IO
Move cassandra directory from EBS storage to ephemeral storage

use   'df -kh'  to find out disk layouts

Create  a cassandra dir in ephemeral storage  (/media/ephemeral0)
Set correct permissions for this dir
Update config files and restart c*
Do benchmarks before & after(cassandra-stress  tool)

