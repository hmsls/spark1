import org.apache.spark.{SparkConf, SparkContext}

object TopK {
  def main(args: Array[String]):Unit = {
    val conf = new SparkConf()
    //执行Wordcount，统计出最高频的词
    val spark = new SparkContext("local","TopK",conf)
    val count = spark.textFile("data").flatMap(line=>line.split(" ")).map(word=>(word,1)).reduceByKey(_+_)
    //统计RDD每个分区内的Top K查询
    val topk = count.mapPartitions(iter=>{
      while(iter.hasNext){
        putToHeap(iter.next())
      }
      getHeap().iterator
    }).collect()
    //将每个分区内统计出的TopK查询合并为一个新的集合，统计出TopK查询
    val iter = topk.iterator
    while (iter.hasNext){
      putToHeap(iter.next())
    }
    val outiter = getHeap().iterator
    //输出TopK的值
    println("Topk 值 ：")
    while(outiter.hasNext){
      println("\n 词频："+outiter.next()._1+" 词："+outiter.next()._2)
    }
    spark.stop()
  }

  def putToHeap(iter:(String,Int)): Unit ={
    //数据加入含k个元素的堆中
  }
  def getHeap():Array[(String,Int)] ={
    //获取含k个元素的堆中的元素
    val a = new Array[(String,Int)](3)
    return a
  }
}
