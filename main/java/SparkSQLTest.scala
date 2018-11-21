import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

class SparkSQLTest {

}
case class People(name:String,age:Int)
object SparkSQLTest{
  val conf = new SparkConf().setMaster("local").setAppName("SQLTest")
  val sc = new SparkContext(conf)
  def main(args: Array[String]): Unit = {
    val sqlContext = new SQLContext(sc)
    // this is used to implicitly convert an RDD to a DataFrame.
////    val people = sc.textFile("file:///F:\\java_file\\SparkTest1\\testFile\\people.txt").map(_.split(",")).map(
////      p=>People(p(0),p(1).trim.toInt)
////    ).toDF()
//    people.registerTempTable("people")
//
//    val teenagers = sqlContext.sql("SELECT name, age FROM people")
//    //查看teenagers的Schema信息
//    teenagers.printSchema()
//    //查看运行流程
//    println(teenagers.queryExecution)
  }
}