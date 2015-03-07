
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
object cow extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to My Play")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""

  <section id="container" >
      
"""),_display_(Seq[Any](/*7.2*/commonTemplate())),format.raw/*7.18*/("""

      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> Details Page</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		<p>Please Select Individual Cow to view detailed report</p>
          		<select class="form-control">
						  <option>1</option>
						  <option>2</option>
						  <option>3</option>
						  <option>4</option>
						  <option>5</option>
						</select>
          		</div>
          	</div>
			 <div id="morris">
                  <div class="row mt">
                     <div class="col-lg-6">
                          <div class="content-panel">
                          <h4><i class="fa fa-angle-right"></i> Temperature Index</h4>
                              <div class="panel-body">
                                  <div id="hero-bar" class="graph"></div>
                              </div>
                          </div>
                      </div> 
                      <div class="col-lg-6">
                          <div class="content-panel">
                              <h4><i class="fa fa-angle-right"></i> Temperature Index</h4>
                              <div class="panel-body">
                                  <div id="hero-area" class="graph"></div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
		</section>
      </section>

"""),_display_(Seq[Any](/*47.2*/footer())),format.raw/*47.10*/("""

  </section>

  </script>


""")))})),format.raw/*54.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 06 22:36:58 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/cow.scala.html
                    HASH: 44f4caebfb797d822066cce6015b4c36d3d343d8
                    MATRIX: 772->1|883->18|922->23|956->49|995->51|1071->93|1108->109|2680->1646|2710->1654|2779->1692
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|75->47|75->47|82->54
                    -- GENERATED --
                */
            