package bootstrap.liftweb

import _root_.net.liftweb.util._
import _root_.net.liftweb.http._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._
import _root_.net.liftweb.mapper.{DB, ConnectionManager, Schemifier, DefaultConnectionIdentifier, ConnectionIdentifier}
import _root_.java.sql.{Connection, DriverManager}
import _root_.com.spiralarm.www.model._
import _root_.javax.servlet.http.{HttpServletRequest}

/**
  * A class that's instantiated early and run.  It allows the application
  * to modify lift's environment
  */
class Boot {
  def boot {

    // where to search snippet
    LiftRules.addToPackages("com.spiralarm.www")

    // Build SiteMap
    val entries = Menu(Loc("Home", List("index"), "Home")) :: User.sitemap
    LiftRules.setSiteMap(SiteMap(entries:_*))
  }

}
