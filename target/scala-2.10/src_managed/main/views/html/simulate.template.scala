
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object simulate extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Welcome to My Play")/*1.28*/ {_display_(Seq[Any](format.raw/*1.30*/("""

  <section id="container" >

"""),_display_(Seq[Any](/*5.2*/commonTemplate())),format.raw/*5.18*/("""
      
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Details Page</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		</div>
          	</div>
	      </section>
      </section>

"""),_display_(Seq[Any](/*17.2*/footer())),format.raw/*17.10*/("""

  </section>

"""),_display_(Seq[Any](/*21.2*/customSelect())),format.raw/*21.16*/("""

""")))})),format.raw/*23.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 06 22:07:15 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/simulate.scala.html
                    HASH: 0f90b7303f49938288044d7fd9b53af9467cb93d
                    MATRIX: 867->1|901->27|940->29|1010->65|1047->81|1397->396|1427->404|1483->425|1519->439|1555->444
                    LINES: 29->1|29->1|29->1|33->5|33->5|45->17|45->17|49->21|49->21|51->23
                    -- GENERATED --
                */
            