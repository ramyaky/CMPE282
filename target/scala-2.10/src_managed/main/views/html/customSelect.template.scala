
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
object customSelect extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.3*/("""<script>
      //custom select box

      $(function()"""),format.raw/*4.19*/("""{"""),format.raw/*4.20*/("""
          $('select.styled').customSelect();
      """),format.raw/*6.7*/("""}"""),format.raw/*6.8*/(""");

  </script>

"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 06 21:59:03 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/customSelect.scala.html
                    HASH: a833c164f0e51532804e84f83c01b84c9e277e18
                    MATRIX: 862->2|943->56|971->57|1049->109|1076->110
                    LINES: 29->1|32->4|32->4|34->6|34->6
                    -- GENERATED --
                */
            