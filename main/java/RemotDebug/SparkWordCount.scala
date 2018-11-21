package RemotDebug

import org.apache.spark.{SparkConf, SparkContext}

class SparkWordCount {

}

object SparkWordCount{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("spark://bigdata02:57128").setAppName("wcTest").setJars(List("/root/lishuai_test/Self_Spark.jar"))
    val sc = new SparkContext(conf)
    val file = sc.textFile("file:///root/lishuai_test/wordCount.txt")

    val counts = file.map(x=>x.split(" ")).map(x=>(x,1)).reduceByKey((x,y)=>x+y)
    counts.saveAsTextFile("file:///root/lishuai/wordCount.txt")

    sc.stop()
  }
}