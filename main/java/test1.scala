import org.apache.spark.{SparkConf, SparkContext}

class test1 {
}
object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "file:///F:\\java_file\\SparkTest1\\pom.xml" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sc = new SparkContext(conf)
    val data = sc.textFile(logFile, 3).cache()
//    val numAs = logData.filter(line => line.contains("a")).count()
//    val numBs = logData.filter(line => line.contains("b")).count()
//    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    for(i<-data){
      println(i)
    }
  }
}

