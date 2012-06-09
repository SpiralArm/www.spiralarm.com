package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._

import common._
import http._
import sitemap._
import Loc._
import mapper._


/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {

    LiftRules.addToPackages("code")
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))    

    LiftRules.uriNotFound.prepend{ case (req, _) => NotFoundAsResponse(PermRedirectResponse("/siteReorganized.html", req))}  
    LiftRules.exceptionHandler.prepend{ case (mode,req, throwable) => PermRedirectResponse("siteReorganized", req)}

    LiftRules.liftRequest.append {
      	case Req("sitemap" :: Nil, "xml", _) => false
    }


    bootstrap.liftmodules.GoogleAnalytics.init

  }
}
