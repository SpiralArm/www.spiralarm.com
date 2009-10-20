package bootstrap.liftweb

import _root_.net.liftweb.util._
import _root_.net.liftweb.http._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._
import _root_.net.liftweb.mapper.{DB, ConnectionManager, Schemifier, DefaultConnectionIdentifier, ConnectionIdentifier}
import _root_.java.sql.{Connection, DriverManager}

import _root_.javax.servlet.http.{HttpServletRequest}

/**
  * A class that's instantiated early and run.  It allows the application
  * to modify lift's environment
  */
class Boot {
  def boot {
    Log.info("RUN MODE: "+Props.mode+" on "+Props.userName+"@"+Props.hostName)

    // where to search snippet
    LiftRules.addToPackages("com.spiralarm.www")

    // Build SiteMap
	val pages = Menu(Loc("Home", List("index"), "Home",Hidden)) ::
            Menu(Loc("aboutSpiralArm", List("aboutSpiralArm"), "aboutSpiralArm", Hidden)) ::
            Menu(Loc("contactUs", List("contactUs"), "contactUs", Hidden)) ::
            Menu(Loc("howWeWork", List("howWeWork"), "howWeWork", Hidden)) ::
            Menu(Loc("privacyStatement", List("privacyStatement"), "privacyStatement", Hidden)) ::
            Menu(Loc("siteMap", List("siteMap"), "siteMap", Hidden)) ::
            Menu(Loc("siteReorganized", List("siteReorganized"), "siteReorganized", Hidden)) ::
            Menu(Loc("technologies", List("technologies"), "technologies", Hidden)) ::
            Menu(Loc("work", List("work"), "work", Hidden)) ::
            Menu(Loc("newMobileImagingService", List("ourWork" , "newMobileImagingService"), "newMobileImagingService", Hidden)) ::   
            Menu(Loc("pictureMessagingAtTheGuardian", List("ourWork" , "pictureMessagingAtTheGuardian"), "pictureMessagingAtTheGuardian", Hidden)) ::   
            Menu(Loc("pictureMessagingAtTheTimes", List("ourWork" , "pictureMessagingAtTheTimes"), "pictureMessagingAtTheTimes", Hidden)) ::   
            Menu(Loc("regionalNewspapersEmbraceMMS", List("ourWork" , "regionalNewspapersEmbraceMMS"), "regionalNewspapersEmbraceMMS", Hidden)) ::   
            Menu(Loc("visualizingTvResearch", List("ourWork" , "visualizingTvResearch"), "visualizingTvResearch", Hidden)) ::   
            Menu(Loc("websiteRedevelopment", List("ourWork" , "websiteRedevelopment"), "websiteRedevelopment", Hidden)) ::   
            Nil    
    
    LiftRules.setSiteMap(SiteMap(pages:_*))
    LiftRules.siteMapFailRedirectLocation = "/siteReorganized.html" :: Nil
    LiftRules.uriNotFound.prepend{ case (req, _) => PermRedirectResponse("/siteReorganized.html", req)}  
    LiftRules.exceptionHandler.prepend{ case(mode,req, throwable) =>PermRedirectResponse("siteReorganized", req)}

  }

}
