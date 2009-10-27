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
	val pages = Menu(Loc("Home", List("index"), "Building products and services with Scala and Lift" )) ::
            Menu(Loc("aboutSpiralArm", List("aboutSpiralArm"), "About" )) ::
            Menu(Loc("whatWeDo", List("whatWeDo"), "What we do" )) ::
            Menu(Loc("technologies", List("technologies"), "Technologies" )) ::
	   		Menu(Loc("newMobileImagingService", List("ourWork" , "newMobileImagingService"), "New mobile imaging service" )) ::   
            Menu(Loc("pictureMessagingAtTheGuardian", List("ourWork" , "pictureMessagingAtTheGuardian"), "Picture messaging at The Guardian" )) ::   
            Menu(Loc("pictureMessagingAtTheTimes", List("ourWork" , "pictureMessagingAtTheTimes"), "Picture messaging at The Times" )) ::   
            Menu(Loc("regionalNewspapersEmbraceMMS", List("ourWork" , "regionalNewspapersEmbraceMMS"), "Regional newspapers embrace MMS" )) ::   
            Menu(Loc("visualizingTvResearch", List("ourWork" , "visualizingTvResearch"), "Visualizing TV research" )) ::   
            Menu(Loc("twitterApps", List("ourWork" , "twitterApps"), "Twitter Applications" )) ::   
            Menu(Loc("iphoneWeb", List("ourWork" , "iphoneWeb"), "iPhone Web Apps" )) ::   
            Menu(Loc("websiteRedevelopment", List("ourWork" , "websiteRedevelopment"), "Website redevelopment" )) ::
            Menu(Loc("ourWork", List("ourWork") -> true , "Our work")) ::   
            Menu(Loc("privacyStatement", List("privacyStatement"), "Privacy statement" )) ::
            Menu(Loc("siteMap", List("siteMap"), "Site Map" )) ::
            Menu(Loc("siteReorganized", List("siteReorganized"), "Site reorganized" )) ::
            Nil    
 
    LiftRules.setSiteMap(SiteMap(pages:_*))
    LiftRules.siteMapFailRedirectLocation = "/siteReorganized.html" :: Nil
    LiftRules.uriNotFound.prepend{ case (req, _) => PermRedirectResponse("/siteReorganized.html", req)}  
    LiftRules.exceptionHandler.prepend{ case(mode,req, throwable) =>PermRedirectResponse("siteReorganized", req)}

  }

}
