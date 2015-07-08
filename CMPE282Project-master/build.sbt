name := "CMPE282Project-master"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.code.gson" % "gson" % "2.2"
)     

libraryDependencies += "com.github.thiagolocatelli" % "parse4j" % "1.4"

