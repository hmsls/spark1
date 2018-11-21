import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object SparkSQL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkSQLTest").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    val hiveContext = new HiveContext(sc);
    hiveContext.sql("show databases").show()

  }
}
