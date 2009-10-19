package com.spiralarm.www.snippet

import java.util.Calendar 
import scala.xml._

class DateTime {

  def year(in: NodeSeq): NodeSeq = <span>{Calendar.getInstance.get(Calendar.YEAR)}</span>
  
}
