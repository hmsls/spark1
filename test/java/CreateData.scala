import java.io.{FileWriter, Writer}

import scala.util.Random

object CreateData {
  private val datapath = "F:\\java_file\\spark\\data\\data1.txt"
  private val max_records = 100
  private val age = 80
  private val brand = Array("Huawei","MI","Apple","Samsung","Meizu","Lenovo","Oppo","Nokia")

  def createData():Unit = {
    val rand = new Random()
    val writer:FileWriter = new FileWriter(datapath,true)
    for(i <- 1 to max_records){
      var dataage = rand.nextInt(age)
      if (dataage < 15){dataage = age + 15}

      //创建手机品牌字段数据
      var phonePlus = brand(rand.nextInt(8))

      //创建点击字段数据
      var clicks = rand.nextInt(20)

      //创建用户数据
      var name = "Role"+ rand.nextInt(100).toString
      //println(name)

      var months = rand.nextInt(12)+1
      var logintime = "2018" + "-" + months + "-" + rand.nextInt(31)
      //println(logintime)

      //DataStructure("ID","Username","Userage","PhoneType,"Click","LoginTime")
      writer.write(i + "," + name + "," + dataage + "," + phonePlus + "," + clicks + "," + logintime)
      writer.write(System.getProperty("line.separator"))
    }
    writer.flush()
    writer.close()
  }
  def main(args: Array[String]): Unit = {
    createData()
    System.exit(1)
  }
}

