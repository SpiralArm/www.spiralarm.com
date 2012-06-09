name := "spiralarm"

version := "1.0"

organization := "com.spiralarm"
 
scalaVersion := "2.9.2" 

seq(webSettings :_*)

scanDirectories in Compile := Nil

resolvers += ScalaToolsSnapshots

//  override def beesUsername = Some("spiralarm")
//  override def beesApplicationId = Some("spiralarm/spiralarm.com")    

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= {
  val liftVersion = "2.5-SNAPSHOT" 
  Seq(
    "net.liftmodules" %% "google-analytics" % (liftVersion+"-1.0-SNAPSHOT"),   
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "ch.qos.logback" % "logback-classic" % "0.9.29",
    "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"
    )
}


libraryDependencies ++= Seq(
    "junit" % "junit" % "4.5" % "test->default",
    "org.specs2" %% "specs2" % "1.11" % "test")



