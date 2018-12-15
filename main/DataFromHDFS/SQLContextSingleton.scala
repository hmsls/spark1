import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

/**
  * Created by LISHUAI on 2018/12/15.
  */
object SQLContextSingleton {
  //这里使用lazy加载的单例模式（singleton pattern）的方式来构建SQLContext实例
  //可以避免在foreachRDD中重复构建
  @transient private var instance : SQLContext = null
  //lazy方式实例化
  def getInstance(sparkContext:SparkContext):SQLContext = synchronized{
    if(instance == null){
      instance = new SQLContext(sparkContext)
    }
    instance
  }
}
