import org.apache.spark.{SparkConf, SparkContext}

object CountNums {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CountNums").setMaster("local")
    val sc = new SparkContext(conf)

    val data = sc.textFile("file:///F:\\CDH大数据\\新建CDH\\修改字段\\tttt2.txt")
    val fdata = data.map(x=>x.toString.substring(x.toString.indexOf(":")+1,x.toString.lastIndexOf(",")-1).trim())
    val mfdata = fdata.map(x=>(x,1))
    val res = mfdata.reduceByKey((x,y)=>x+y)
      //提示没有进行串行化
//    val fos = new FileOutputStream(new File("F:\\CDH大数据\\新建CDH\\修改字段\\res2.txt"))
    for(i<-res){
      println(i)
//      fos.write(i.toString().getBytes())
    }
  }
}
