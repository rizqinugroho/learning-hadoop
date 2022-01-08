# learning-hadoop
This repository contain docker compose for you to learning hadoop

## Step 1
### Install Docker in your local environtment and verify your installation
Follow guidance provide in bellow URL

* Windows :  https://docs.docker.com/desktop/windows/install/
* Mac     :  https://docs.docker.com/desktop/mac/install/



#### 

#### a. Docker installation can be verified by <br/>
 
> $ docker --version 

#### b. Check for Docker-Compose installation. It can be verified by <br/>
> $ docker-compose --version

if not installed, you can follow this guidance https://docs.docker.com/compose/install/ to install the docker compose. 
<br/>
<br/>
c. Check for git installation
> $ git -version

If not installed follow this link, to install GIT (https://www.linode.com/docs/development/version-control/how-to-install-git-on-linux-mac-and-windows/)

## Step 2 Download docker compose 

Git clone docker compose
> $ git clone https://github.com/rizqinugroho/learning-hadoop.git <br>
> $ cd learning-hadoop

Download hadoop images and start container
> $ docker-compose up -d

This step will takes about 15-30 minutes depends on your network speed for docker to download all the images and configure the hadoop settings. 

## Step 3 Verifying 

When it done, we need to make sure all the container are running with issue the following command
> $ docker ps

Verify the name node
> http://localhost:50070

Verify Hue
> http://localhost:8888/

Default userid / passwod : admin/admin




