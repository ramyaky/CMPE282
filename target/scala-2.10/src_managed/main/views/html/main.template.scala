
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>"""),_display_(Seq[Any](/*13.17*/title)),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*14.54*/routes/*14.60*/.Assets.at("stylesheets/main.css"))),format.raw/*14.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*15.59*/routes/*15.65*/.Assets.at("images/favicon.png"))),format.raw/*15.97*/("""">
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*16.39*/routes/*16.45*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*16.84*/("""">
        <!--external css-->
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*18.39*/routes/*18.45*/.Assets.at("font-awesome/css/font-awesome.css"))),format.raw/*18.92*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*19.55*/routes/*19.61*/.Assets.at("stylesheets/zabuto_calendar.css"))),format.raw/*19.106*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*20.55*/routes/*20.61*/.Assets.at("javascripts/gritter/css/jquery.gritter.css"))),format.raw/*20.117*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*21.55*/routes/*21.61*/.Assets.at("lineicons/style.css"))),format.raw/*21.94*/("""">    
    
        <!-- Custom styles for this template -->
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*24.39*/routes/*24.45*/.Assets.at("stylesheets/style.css"))),format.raw/*24.80*/("""">
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*25.39*/routes/*25.45*/.Assets.at("stylesheets/style-responsive.css"))),format.raw/*25.91*/("""">

        <script src=""""),_display_(Seq[Any](/*27.23*/routes/*27.29*/.Assets.at("javascripts/weather.js"))),format.raw/*27.65*/(""""></script>        
        <script src=""""),_display_(Seq[Any](/*28.23*/routes/*28.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*28.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*29.23*/routes/*29.29*/.Assets.at("javascripts/chart-master/Chart.js"))),format.raw/*29.76*/(""""></script>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body onload="getCurrentWeather();">
        """),_display_(Seq[Any](/*37.10*/content)),format.raw/*37.17*/("""
    </body>

        <script src=""""),_display_(Seq[Any](/*40.23*/routes/*40.29*/.Assets.at("javascripts/jquery.js"))),format.raw/*40.64*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*41.23*/routes/*41.29*/.Assets.at("javascripts/jquery-1.8.3.min.js"))),format.raw/*41.74*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*42.23*/routes/*42.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*42.71*/(""""></script>
        <script class="include" type="text/javascript" src=""""),_display_(Seq[Any](/*43.62*/routes/*43.68*/.Assets.at("javascripts/jquery.dcjqaccordion.2.7.js"))),format.raw/*43.121*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*44.23*/routes/*44.29*/.Assets.at("javascripts/jquery.scrollTo.min.js"))),format.raw/*44.77*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*45.23*/routes/*45.29*/.Assets.at("javascripts/jquery.nicescroll.js"))),format.raw/*45.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*46.23*/routes/*46.29*/.Assets.at("javascripts/jquery.sparkline.js"))),format.raw/*46.74*/(""""></script>


        <!--common script for all pages-->
        <script src=""""),_display_(Seq[Any](/*50.23*/routes/*50.29*/.Assets.at("javascripts/common-scripts.js"))),format.raw/*50.72*/(""""></script>
    
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*52.46*/routes/*52.52*/.Assets.at("javascripts/gritter/js/jquery.gritter.js"))),format.raw/*52.106*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*53.46*/routes/*53.52*/.Assets.at("javascripts/gritter-conf.js"))),format.raw/*53.93*/(""""></script>

        <!--script for this page-->
        <script src=""""),_display_(Seq[Any](/*56.23*/routes/*56.29*/.Assets.at("javascripts/sparkline-chart.js"))),format.raw/*56.73*/(""""></script>    
        <script src=""""),_display_(Seq[Any](/*57.23*/routes/*57.29*/.Assets.at("javascripts/zabuto_calendar.js"))),format.raw/*57.73*/(""""></script>    

</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 05 17:59:43 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/main.scala.html
                    HASH: 27e5b80e77c45ab573a4801b508c4f84344172ab
                    MATRIX: 778->1|902->31|1308->401|1335->406|1433->468|1448->474|1504->508|1601->569|1616->575|1670->607|1747->648|1762->654|1823->693|1928->762|1943->768|2012->815|2105->872|2120->878|2188->923|2281->980|2296->986|2375->1042|2468->1099|2483->1105|2538->1138|2673->1237|2688->1243|2745->1278|2822->1319|2837->1325|2905->1371|2967->1397|2982->1403|3040->1439|3118->1481|3133->1487|3200->1532|3293->1589|3308->1595|3377->1642|3814->2043|3843->2050|3915->2086|3930->2092|3987->2127|4057->2161|4072->2167|4139->2212|4209->2246|4224->2252|4288->2294|4397->2367|4412->2373|4488->2426|4558->2460|4573->2466|4643->2514|4713->2548|4728->2554|4796->2600|4889->2657|4904->2663|4971->2708|5086->2787|5101->2793|5166->2836|5264->2898|5279->2904|5356->2958|5449->3015|5464->3021|5527->3062|5634->3133|5649->3139|5715->3183|5789->3221|5804->3227|5870->3271
                    LINES: 26->1|29->1|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|52->24|52->24|52->24|53->25|53->25|53->25|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|65->37|65->37|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|78->50|78->50|78->50|80->52|80->52|80->52|81->53|81->53|81->53|84->56|84->56|84->56|85->57|85->57|85->57
                    -- GENERATED --
                */
            