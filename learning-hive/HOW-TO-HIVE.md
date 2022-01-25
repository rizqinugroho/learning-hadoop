# How To Hive in GCP

based on this article : https://dzone.com/articles/how-to-hive-on-gcp-using-google-dataproc-and-cloud

1. Create cloud dataproc cluster

after dataproc created and you enter the ssh. Run this

> beeline -u jdbc:hive2://localhost:10000/default -n myusername@cluster-tlc-m -d org.apache.hive.jdbc.HiveDriver


# Installing Apache Sqoop On GCP

> wget https://archive.apache.org/dist/sqoop/1.4.7/sqoop-1.4.7.tar.gz

> tar -xvf sqoop-1.4.7.tar.gz<br>
> sudo mv sqoop-1.4.7 sqoop <br>
> sudo mv sqoop /usr/lib/ <br>
>  vi ~/.profile 

Add this 

#Sqoop
export SQOOP_HOME=/usr/lib/sqoop 
export PATH=$PATH:$SQOOP_HOME/bin

> !wq
> <br> source ~/.profile

## configuring sqoop
While, we need to edit the sqoop-env.sh file, that is placed in the $SQOOP_HOME/conf directory, in order to configure Sqoop with Hadoop. Now, using the following command redirect to Sqoop config directory and copy the template file.
>cd /usr/lib/sqoop/conf
><br>mv sqoop-env-template.sh sqoop-env.sh

Also, open sqoop-env.sh and edit the following lines



