package code.snippet

import scala.xml._
import net.liftweb.http._

object Html5Shim {
	
	def render = Unparsed("""<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->""")

	// Need to work out how to convert from Unparsed to an Elem for this to work:
	//def init {
	//	def addShim(s: LiftSession, r: Req) : Unit = S.putInHead(render)
    //   LiftSession.onBeginServicing = addShim _ :: LiftSession.onBeginServicing	
	//}
	
}

