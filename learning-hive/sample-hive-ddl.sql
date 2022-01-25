CREATE TABLE IF NOT EXISTS employee_part ( eid int, name String, salary String, destination String) PARTITIONED BY (yoj string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY "|"
LINES TERMINATED BY "\n"
STORED AS TEXTFILE;

load data inpath '/user/learning/sample-employe.txt' overwrite into table employee;

select * from employee

drop table employee

--Create External table
CREATE EXTERNAL TABLE employee_stg( eid int, name String, salary String, destination String)
COMMENT "Employee details"
ROW FORMAT DELIMITED
FIELDS TERMINATED BY "|"
LINES TERMINATED BY "\n"
STORED AS TEXTFILE
LOCATION 'gs://hive-example/data/learning/';

CREATE EXTERNAL TABLE employee_stg_part( eid int, name String, salary String, destination String) PARTITIONED BY ('yoj=2020')
COMMENT "Employee details"
ROW FORMAT DELIMITED
FIELDS TERMINATED BY "|"
LINES TERMINATED BY "\n"
STORED AS TEXTFILE
LOCATION 'gs://hive-example/data/employee/2020';

CREATE TABLE employe_part PARTITION BY ('joy=2019')
AS
SELECT 


ALTER TABLE employee_part ADD PARTITION (year='2020')
location 'gs://hive-example/data/learning';