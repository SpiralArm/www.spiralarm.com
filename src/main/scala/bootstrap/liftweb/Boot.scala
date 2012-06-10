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

    import bootstrap.liftmodules.GoogleAnalytics
    import GoogleAnalytics.dsl._
    
    GoogleAnalytics.init
    
    GoogleAnalytics.alertUser( only when S.cookieValue("ckns_policy").isEmpty )  {
      import net.liftweb.http.js._
      import JE._ 
      import JsCmds._
      import net.liftweb.http.provider.HTTPCookie
      
      val oneYear = 365 * 24 * 60 * 60
      S.addCookie( HTTPCookie("ckns_policy", "1").setPath("/").setMaxAge(oneYear) ) 
 
      JsRaw("$('body').prepend('<div id=cookie-notice></div>')") &
      JsRaw("$('body').delegate('#close', 'click', function() { $('#cookie-notice').hide(); })") &
      SetHtml("cookie-notice", <div id="cookie-notice">
          We use cookies to ensure that we give you the best experience on our website. 
            If you continue we'll assume that you are happy to receive cookies. 
            Our <a href="/cookies.html">cookie policy</a> page gives more details.  <a href="#close" id="close">Close</a> 
          </div>)
      
    }
    

  }
}
