 import sbt._
class Plugins(info: ProjectInfo) extends PluginDefinition(info) {

	lazy val scctRepo = "scct-repo" at "http://mtkopone.github.com/scct/maven-repo/"
    lazy val scctPlugin = "reaktor" % "sbt-scct-for-2.8" % "0.1-SNAPSHOT"

    lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.7.0"
}
