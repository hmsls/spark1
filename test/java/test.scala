/**
  * Created by LISHUAI on 2018/12/9.
  */
object test {
  def main(args: Array[String]): Unit ={
    val list1 = List("cool","tools","rule")
//    list1.foreach(print)
    val thrill= "will" :: "file" :: "until" :: Nil
    val list2 = List("a","b") ::: List("c","d")
//    print(thrill(2))
//    print(thrill.count(s=> s.length() == 4))
//    print(thrill.exists(s=>s=="until"))
//    print(thrill.filter(s=>s.length == 4))
//    print(thrill.forall(s=>s.endsWith("l")))
//    print(thrill.foreach(s=>print(s)))
//    print(thrill.head)
//    print(thrill.init)
//    print(thrill.isEmpty)
//    print(thrill.last)
//    print(thrill.map(s=>s + "l"))
//    print(thrill.mkString("|"))
//    print(thrill.reverse)
//    print(thrill.tail)
//    print(thrill.sortWith((s,t)=>s.charAt(0) < t.charAt(0)))

    var jetSet = Set("boeing","aribus")
//    println(jetSet.hashCode())
    jetSet += "lear" //这里相当于重新创建了一个集合jetSet,增加了新元素lear
//    print(jetSet.contains("lear"))
//    println(jetSet.hashCode())
    import scala.collection.mutable.Set
    val movieSet = Set("Hith","Poltergeitst")
    movieSet += "shrek"
//    print(movieSet.contains("shrek"))

    import scala.collection.mutable.Map
    val treasureMap = Map[Int,String]()
    treasureMap.+=(1->"Go to Islang")
    treasureMap += (2->"Find big X on Island")
    treasureMap += (3-> "dig.")
//    print(treasureMap(2))
  }
}
