val spark:SparkSession = SparkSession.builder()
    .master("local[5]")
    .appName("SparkByExamples.com")
    .getOrCreate()

val rdd = spark.sparkContext.parallelize(Range(0,20))
  println("From local[5]"+rdd.partitions.size)

val rdd1 = spark.sparkContext.parallelize(Range(0,25), 6)
  println("parallelize : "+rdd1.partitions.size)

val rddFromFile = spark.sparkContext.textFile("src/main/resources/test.txt",10)
  println("TextFile : "+rddFromFile.partitions.size)




//Example usage of map
import spark.implicits._
  val df3 = df2.map(row=>{
    val util = new Util() // Initialization happends for every record
    val fullName = util.combine(row.getString(0),row.getString(1),row.getString(2))
    (fullName, row.getString(3),row.getInt(5))
  })
  val df3Map =  df3.toDF("fullName","id","salary")


//Example usage of mapPartitions
  val df4 = df2.mapPartitions(iterator => {
    val util = new Util()
    val res = iterator.map(row=>{
      val fullName = util.combine(row.getString(0),row.getString(1),row.getString(2))
      (fullName, row.getString(3),row.getInt(5))
    })
    res
  })
  val df4part = df4.toDF("fullName","id","salary")


./bin/spark-class org.apache.spark.deploy.SparkSubmit <options & arguments>
