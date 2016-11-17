<link rel='stylesheet' href='assets/css/main.css'/>

[<< main](README.md)

# Editing Files
There are 3 ways of editing files on VM.  
In order of preference & ease
1. NoIDE web editor (<a href="#noide">instructions</a>)
2. Sublime editor or GEdit (<a href="#sublime">instructions</a>)
3. Command line editors like vi and nano (<a href="#vi">instructions</a>)


<a name="noide"/>
## Option 1 : Using NoIDE
### Start Noide
```bash
    $   nohup   ~/run-noide.sh & 
```

### Goto port 3000 in browser
In your browser go to : http://your_ip_address:3000   
Happy editing!


<a name="sublime"/>
## Option 2 : Using Sublime or GEdit

### Login into web desktop
<img src="assets/images/setup1d-vnc.png" style="border: 5px solid grey ; max-width:100%;" />

### Open Sublime Editor via desktop shortcut

<img src="assets/images/setup-sublime.png" style="border: 5px solid grey ; max-width:100%;" />

### Open GEdit Editor via desktop shortcut
<img src="assets/images/setup1f.png" style="border: 5px solid grey ; max-width:100%;" />




<a name="vi"/>
## Option 3 : Using command line editors like VI or Nano

```bash
    $   cd  ~/cassandra-labs

    $   vi file_name_to_edit
    # or
    $   nanon file_to_edit
```
