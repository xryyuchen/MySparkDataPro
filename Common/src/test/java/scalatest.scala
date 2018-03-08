import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object scalatest {


  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("scalatest").setMaster("local[*]")
    sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")

    // 创建Spark客户端
    val sc = SparkSession.builder().config(sparkConf).getOrCreate().sparkContext

    val rdd = sc.textFile("/Users/changya/cluster/hive-1.1.0-cdh5.12.0/conf")

    val rrdd = rdd.map((_,1)).reduceByKey(_+_).collect()

    println(rrdd.toString)

    sc.stop()

  }

}
