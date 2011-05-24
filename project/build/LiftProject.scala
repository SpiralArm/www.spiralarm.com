import sbt._
import de.element34.sbteclipsify._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) with Eclipsify {
  val liftVersion = "2.3"

  // uncomment the following if you want to use the snapshot repo
  //  val scalatoolsSnapshot = ScalaToolsSnapshots

  override def jettyWebappPath = webappPath
  override def scanDirectories = Nil

  override def libraryDependencies = Set(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default" withSources(),
    "net.liftmodules" %% "google-analytics" % "0.8",
    
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test",
    "ch.qos.logback" % "logback-classic" % "0.9.26"

  ) ++ super.libraryDependencies
}