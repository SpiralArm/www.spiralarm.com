import sbt._
import de.element34.sbteclipsify._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) with Eclipsify  with bees.RunCloudPlugin {
  val liftVersion = "2.3"

  override def beesUsername = Some("spiralarm")
  override def beesApplicationId = Some("spiralarm/spiralarm.com")	  
	  
  // uncomment the following if you want to use the snapshot repo
  //  val scalatoolsSnapshot = ScalaToolsSnapshots

  val liftModulesRelease = "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

  override def jettyWebappPath = webappPath
  override def scanDirectories = Nil

  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default" withSources(),
    "net.liftmodules" %% "google-analytics" % (liftVersion+"-0.9"),
    
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test",
    "ch.qos.logback" % "logback-classic" % "0.9.26",

    "junit" % "junit" % "4.5" % "test",
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test"
    
  ) ++ super.libraryDependencies

}