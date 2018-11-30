import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object SimpleExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    //Using this context, we can create a DStream that represents streaming data from a TCP source, specified as hostname (e.g. localhost) and por
    val ssc = new StreamingContext(conf,Seconds(10))
    val lines = ssc.socketTextStream("60.24.64.142",9999)
    //切割每一行的单词,把行记录变为单词记录，结果是把一行的流变成了每个单词的流
    val words = lines.flatMap(_.split(" "))

    val pairs = words.map(word => (word,1))
    val wordCount = pairs.reduceByKey(_+_)
    wordCount.print()

    //开始进行计算，在此之前只是设置了计算，并没有开始计算，下面的才是计算的开关
    ssc.start()
    ssc.awaitTermination() //一直在运行，直到被退出
  }
}
