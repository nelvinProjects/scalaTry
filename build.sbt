name := "scalaTry"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

libraryDependencies += "org.pegdown" % "pegdown" % "1.6.0" % Test

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",
  "mysql" % "mysql-connector-java" % "8.0.12")


testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")