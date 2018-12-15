import org.apache.spark.SparkConf
import org.apache.spark.sql.catalyst.expressions.Second
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by LISHUAI on 2018/12/15.
  */
//样本类，用于构建RDD对应的DataFrame实例
//可以根据实际的数据格式，给出对应的解析样本类
case class Row(word:String)
object HdfsApp {
  def main(args: Array[String]): Unit = {
    //设置loglevel减少控制台的输出信息
    import org.apache.log4j.{Level,Logger}
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    Logger.getLogger("org.apache.spark.sql").setLevel(Level.WARN)
    Logger.getLogger("org.apache.spark.streaming").setLevel(Level.WARN)

    //日志文件监控路径
    val logFile = args(0)
    val conf = new SparkConf().setAppName("HdfsApp").setMaster("local[1]")
    val ssc = new StreamingContext(conf,Seconds(1))

    //在streaming的内部处理中，使用DataFrame，将读取到的文件数据注册到临时表中，并将表查询结果显示到控制台上
    val words:DStream[String] = ssc.textFileStream(logFile)

    //这里使用foreachRDD，针对每个RDD进行spark SQL操作
    words.foreachRDD(
      rdd=>
        if(!rdd.isEmpty()){
          //获取SQLContext实例
          val sqlContext = SQLContextSingleton.getInstance(rdd.sparkContext)
          //代码中需要手动添加以下的隐式转换
          import sqlContext.implicits._
          //将RDD转换为Dataframe
          val wordsDataFrame = rdd.map(w=>Row(w)).toDF()
          //将转换结果注册成临时表
          wordsDataFrame.registerTempTable("words")
          //对临时表执行sql语句
          val wordCountDataFrame = sqlContext.sql("select word,count(*) as total from words group by word")
          wordCountDataFrame.show()
        }
    )

    ssc.start()
    ssc.awaitTermination()
  }
}
