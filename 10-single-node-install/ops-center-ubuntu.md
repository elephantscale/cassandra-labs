# Installing OPS center

## Step 1: Add apt repository


```bash
echo "deb https://debian.datastax.com/enterprise \
stable main" | sudo tee -a /etc/apt/sources.list.d/datastax.sources.list
```


## Step 2: Add datastax Repository Key

``` bash
curl -L https://debian.datastax.com/debian/repo_key | sudo apt-key add -
```


## Step 3: Use Apt to install


```bash
sudo apt-get update
sudo apt-get install opscenter
```


## Step 4: Change he port

Currently on our machines port 8888 is occupied, so let's change the port to 8889

Use a text editor (vi, vim, nano, etc) to edit the file `/etc/opscenter/opscenterd.conf`

```bash
sudo /etc/opscenter/opscenterd.conf
```


Change port `8888`  to `8889` and save.  (`:wq` in vim)


save and exit


```bash
sudo service opscenterd restart
```

## Step 4: Browse to your host `http://<opscenter-host>:8889/

```
http://<opscenter-host>:8889/
```

![](../assets/images/opscenter1.png)

You will select Manage existing cluster

## Step 5: Select your existing cluster

![](../assets/images/opscenter3.png)


## Step 5: Observe metrics
j
Once opscenter is functional, re-run benchmark from 'post-install.txt'.
Observe metrics on ops-center

