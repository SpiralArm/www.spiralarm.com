jQuery(function( $ ){
	$.localScroll();
	
	// http://code.google.com/apis/analytics/docs/tracking/eventTrackerGuide.html
	function recordEvent(action,label) {
	 if (typeof _gaq != "undefined")
	   _gaq.push(['_trackEvent', 'Link Click', action, label]);
	 else
	   console.log('Link click: '+action+" "+label);
	}

  // Add a click event handler to all # links on the page:
    
  function isHashLink(index) {
   return this.href.indexOf(document.location.href+'#') == 0;
  }
	
  $('a').filter(isHashLink).bind('click', function() {
	     recordEvent('internal', this.href.substring(document.location.href.length));
	   } );

  // And record links to other sites:
  
  $('a').not(isHashLink).bind('click', function() {
       recordEvent('external', this.href);
     } );
	   

});

