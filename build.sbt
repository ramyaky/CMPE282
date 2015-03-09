name := "projectcmpe282"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

libraryDependencies += "com.github.thiagolocatelli" % "parse4j" % "1.4"

play.Project.playJavaSettings
