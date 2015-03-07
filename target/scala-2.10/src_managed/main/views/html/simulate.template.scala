
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
          	<h3><i class="fa fa-angle-right"></i> Simulation </h3>
          	<div class="row mt">
          		<div class="col-lg-10">
                    <label> Click the button to simulate cattle temperature </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button id="simulate-button" type="button"> Simulate </button>
                    <br><br>
                    <div id="simulate-data" align="center"> </div>
          		</div>
          	</div>
	      </section>
      </section>

"""),_display_(Seq[Any](/*22.2*/footer())),format.raw/*22.10*/("""

  </section>
  
  <script type="text/javascript">
    $('#simulate-button').click(function () """),format.raw/*27.45*/("""{"""),format.raw/*27.46*/("""
        //Better to construct options first and then pass it as a parameter
        var options = """),format.raw/*29.23*/("""{"""),format.raw/*29.24*/("""
            backgroundColor: "#f2f2f2",
            title: """),format.raw/*31.20*/("""{"""),format.raw/*31.21*/("""
                text: "Cattle sensor values simulation"
            """),format.raw/*33.13*/("""}"""),format.raw/*33.14*/(""",
            animationEnabled: true,
            data: [
             """),format.raw/*36.14*/("""{"""),format.raw/*36.15*/("""
                type: "spline", //change it to line, area, column, pie, etc
                dataPoints: [
                    """),format.raw/*39.21*/("""{"""),format.raw/*39.22*/(""" x: 10, y: 10 """),format.raw/*39.36*/("""}"""),format.raw/*39.37*/(""",
                    """),format.raw/*40.21*/("""{"""),format.raw/*40.22*/(""" x: 20, y: 12 """),format.raw/*40.36*/("""}"""),format.raw/*40.37*/(""",
                    """),format.raw/*41.21*/("""{"""),format.raw/*41.22*/(""" x: 30, y: 8 """),format.raw/*41.35*/("""}"""),format.raw/*41.36*/(""",
                    """),format.raw/*42.21*/("""{"""),format.raw/*42.22*/(""" x: 40, y: 14 """),format.raw/*42.36*/("""}"""),format.raw/*42.37*/(""",
                    """),format.raw/*43.21*/("""{"""),format.raw/*43.22*/(""" x: 50, y: 6 """),format.raw/*43.35*/("""}"""),format.raw/*43.36*/(""",
                    """),format.raw/*44.21*/("""{"""),format.raw/*44.22*/(""" x: 60, y: 24 """),format.raw/*44.36*/("""}"""),format.raw/*44.37*/(""",
                    """),format.raw/*45.21*/("""{"""),format.raw/*45.22*/(""" x: 70, y: -4 """),format.raw/*45.36*/("""}"""),format.raw/*45.37*/(""",
                    """),format.raw/*46.21*/("""{"""),format.raw/*46.22*/(""" x: 80, y: 10 """),format.raw/*46.36*/("""}"""),format.raw/*46.37*/("""
                ]
             """),format.raw/*48.14*/("""}"""),format.raw/*48.15*/("""
            ]
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/(""";

        $("#simulate-data").CanvasJSChart(options);

    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/(""");
  </script>

"""),_display_(Seq[Any](/*57.2*/customSelect())),format.raw/*57.16*/("""

""")))})),format.raw/*59.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 07 00:48:28 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/simulate.scala.html
                    HASH: c1e0667f044ef3bd0743cdeb7d3677cb78e81788
                    MATRIX: 867->1|901->27|940->29|1010->65|1047->81|1716->715|1746->723|1875->824|1904->825|2033->926|2062->927|2152->989|2181->990|2280->1061|2309->1062|2411->1136|2440->1137|2598->1267|2627->1268|2669->1282|2698->1283|2749->1306|2778->1307|2820->1321|2849->1322|2900->1345|2929->1346|2970->1359|2999->1360|3050->1383|3079->1384|3121->1398|3150->1399|3201->1422|3230->1423|3271->1436|3300->1437|3351->1460|3380->1461|3422->1475|3451->1476|3502->1499|3531->1500|3573->1514|3602->1515|3653->1538|3682->1539|3724->1553|3753->1554|3815->1588|3844->1589|3896->1614|3925->1615|4016->1679|4044->1680|4099->1700|4135->1714|4171->1719
                    LINES: 29->1|29->1|29->1|33->5|33->5|50->22|50->22|55->27|55->27|57->29|57->29|59->31|59->31|61->33|61->33|64->36|64->36|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|73->45|73->45|73->45|73->45|74->46|74->46|74->46|74->46|76->48|76->48|78->50|78->50|82->54|82->54|85->57|85->57|87->59
                    -- GENERATED --
                */
            