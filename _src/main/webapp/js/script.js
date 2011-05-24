var pull_quote_title=new Array();

pull_quote_title[0]='We Make Useful Things';
pull_quote_title[1]='&#8220;It&#8217;s Changed My Life&#8221;';
pull_quote_title[2]='Plays Well With Others';
pull_quote_title[3]='We Love Interesting Problems';
pull_quote_title[4]='Holistic Development';


var pull_quote_body=new Array();    
pull_quote_body[0] = 'On the web, on mobile, and on the desktop. Spiral Arm is a team of software developers dedicated to creating useful products and services.'
pull_quote_body[1] = 'Spiral Arm is a team of software developers creating useful products and services. We\'re delighted when we can make a difference.';
pull_quote_body[2] = 'Spiral Arm is a team of software developers, able to work with third parties, to professionally plan, manage and deliver successful projects.';
pull_quote_body[3] = 'Spiral Arm is a team of software developers, building products and bespoke applications. We love interesting problems. The scarier, the better.';
pull_quote_body[4] = 'We don\'t just do web. Or just mobile, or just desktop.  We look at the whole picture, solve the whole problem.';

var next = 1;    
    
function changeQuote()
{
   document.getElementById('pull_quote_title').innerHTML = pull_quote_title[next];
   document.getElementById('pull_quote_body').innerHTML =
            pull_quote_body[next] +
            ' <span id="pull_quote_navigation"><a href="#" onclick="changeQuote()">Next &#8250;</a></span>';

   next = ++next % Math.min(pull_quote_title.length,pull_quote_body.length); 
}
    
    