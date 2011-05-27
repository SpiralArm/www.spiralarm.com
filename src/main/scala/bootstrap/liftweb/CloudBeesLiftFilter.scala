package bootstrap.liftweb { 

import javax.servlet._ 
import javax.servlet.http._ 

import net.liftweb.http.LiftFilter 

//Based on http://groups.google.com/group/liftweb/browse_thread/thread/93f315f98641a63b/5149cd4b4efe49c2?lnk=gst&q=run+mode#5149cd4b4efe49c2
class CloudBeesLiftFilter extends LiftFilter { 
			
    private def run_mode_not_set_? = null == System.getProperty("run.mode")

    private def run_mode_from(config: FilterConfig) = Option(config.getServletContext.getInitParameter("run.mode"))

	override def init(config: FilterConfig) { 
		if (run_mode_not_set_?) {
			val mode = run_mode_from(config) getOrElse "development"
			println("Run mode set to: "+mode)
			System.setProperty("run.mode", mode)
		}
		super.init(config) 
	} 
} 


import dispatch._

import net.liftweb.util._
import net.liftweb.common._
import net.liftweb.actor._
import net.liftweb.util.Helpers._

/** Ping ourselves to prevent hibernation in CloudBees */
object CloudBeesKeepAlive extends LiftActor {

  val url = "http://www.spiralarm.com"
  
  def schedule = Schedule.schedule(this, 'ping, 2 hours)
  
  def messageHandler = { 
    case 'ping =>
      schedule 
      println("CloudBeesKeepAlive running")
      new Http().apply(new Request(url) >|) 
      
  }
  
}



}