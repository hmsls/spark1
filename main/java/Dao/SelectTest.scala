package Dao

import java.sql.ResultSet

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

object SelectTest {
  def main(args: Array[String]): Unit = {
    val conn = ConnOracle.conn
    val conf = new SparkConf().setAppName("connOracle").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = new JdbcRDD(sc,()=>{conn},"select * from xy_whitelists",1,3,2,/*r => (r.getString(8))*/mapRow = getRes)
    rdd.map(x=>println(x))
    sc.stop()
  }
  def getRes(rs:ResultSet) ={
    (rs.getString(1),rs.getString(2))
  }
}
