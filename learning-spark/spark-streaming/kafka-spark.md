## Masuk ke home kafka dan run zookeeper dan kafka broker
> bin/zookeeper-server-start.sh config/zookeeper.properties
> <br>
> bin/kafka-server-start.sh config/server.properties

## Jalankan  Kafka Producer
> ./bin/kafka-console-producer.sh \
    --broker-list localhost:9092 \
    --topic test_streaming


## Masuk kedalam spark-shell 

untuk membuat sprak streaming bisa listen data dari kafka, kita perlu 
include kafka client saat menjalankan spark shell

> ./spark-shell --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.0.0
> val df = spark.readStream.format("kafka").option("kafka.bootstrap.servers", "localhost:9092").option("subscribe", "test_streaming").load()


## buat initial dataframe yang membaca message dari kafka

>val df = spark.readStream.format("kafka").option("kafka.bootstrap.servers", "localhost:9092").option("subscribe", "test_streaming").load().select(col("value").cast("string"))
<br><br>
df.printSchema()


## Transformasi data

> import org.apache.spark.sql.types._
> val wordCount = df.select(explode(split(col("value"), " ")).alias("words")).groupBy("words").count() <br><br>


## Mulai print value kedalam console
> wordCount.writeStream.outputMode("append").format("console").start().awaitTermination()
