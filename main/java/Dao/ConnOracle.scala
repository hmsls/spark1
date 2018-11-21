package Dao

import java.sql.{Driver, DriverManager}

object ConnOracle {
  Class.forName("oracle.jdbc.driver.OracleDriver")
  val conn = DriverManager.getConnection("jdbc:oracle:thin:@60.24.64.71:1521/ODSDB","MSG_USER","MSG_USER")
}
