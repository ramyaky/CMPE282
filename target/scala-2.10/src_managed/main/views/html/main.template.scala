
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
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*26.39*/routes/*26.45*/.Assets.at("stylesheets/morris-0.4.3.min.css"))),format.raw/*26.91*/("""">
        
        <script src=""""),_display_(Seq[Any](/*28.23*/routes/*28.29*/.Assets.at("javascripts/weather.js"))),format.raw/*28.65*/(""""></script>        
        <script src=""""),_display_(Seq[Any](/*29.23*/routes/*29.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*29.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*30.23*/routes/*30.29*/.Assets.at("javascripts/chart-master/Chart.js"))),format.raw/*30.76*/(""""></script>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body onload="getCurrentWeather();">
        """),_display_(Seq[Any](/*38.10*/content)),format.raw/*38.17*/("""
    </body>

        <!--<script src=""""),_display_(Seq[Any](/*41.27*/routes/*41.33*/.Assets.at("javascripts/jquery.js"))),format.raw/*41.68*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*42.23*/routes/*42.29*/.Assets.at("javascripts/jquery-1.8.3.min.js"))),format.raw/*42.74*/(""""></script> -->
        <script src=""""),_display_(Seq[Any](/*43.23*/routes/*43.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*43.71*/(""""></script>
        <script class="include" type="text/javascript" src=""""),_display_(Seq[Any](/*44.62*/routes/*44.68*/.Assets.at("javascripts/jquery.dcjqaccordion.2.7.js"))),format.raw/*44.121*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*45.23*/routes/*45.29*/.Assets.at("javascripts/jquery.scrollTo.min.js"))),format.raw/*45.77*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*46.23*/routes/*46.29*/.Assets.at("javascripts/jquery.nicescroll.js"))),format.raw/*46.75*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*47.23*/routes/*47.29*/.Assets.at("javascripts/jquery.sparkline.js"))),format.raw/*47.74*/(""""></script>


        <!--common script for all pages-->
        <script src=""""),_display_(Seq[Any](/*51.23*/routes/*51.29*/.Assets.at("javascripts/common-scripts.js"))),format.raw/*51.72*/(""""></script>
    
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*53.46*/routes/*53.52*/.Assets.at("javascripts/gritter/js/jquery.gritter.js"))),format.raw/*53.106*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*54.46*/routes/*54.52*/.Assets.at("javascripts/gritter-conf.js"))),format.raw/*54.93*/(""""></script>

        <!--script for this page-->
        <script src=""""),_display_(Seq[Any](/*57.23*/routes/*57.29*/.Assets.at("javascripts/morris-conf.js"))),format.raw/*57.69*/(""""></script>         
        <script src=""""),_display_(Seq[Any](/*58.23*/routes/*58.29*/.Assets.at("javascripts/sparkline-chart.js"))),format.raw/*58.73*/(""""></script>    
        <script src=""""),_display_(Seq[Any](/*59.23*/routes/*59.29*/.Assets.at("javascripts/zabuto_calendar.js"))),format.raw/*59.73*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*60.23*/routes/*60.29*/.Assets.at("javascripts/jquery-ui-1.9.2.custom.min.js"))),format.raw/*60.84*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*61.23*/routes/*61.29*/.Assets.at("javascripts/jquery.ui.touch-punch.min.js"))),format.raw/*61.83*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*62.23*/routes/*62.29*/.Assets.at("javascripts/raphael-min.js"))),format.raw/*62.69*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*63.23*/routes/*63.29*/.Assets.at("javascripts/morris-0.4.3.min.js"))),format.raw/*63.74*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*64.46*/routes/*64.52*/.Assets.at("javascripts/jquery.canvasjs.min.js"))),format.raw/*64.100*/(""""></script>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 07 00:34:37 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/main.scala.html
                    HASH: ba3ea01ce3a816b3d370433d612a8694849a1ea0
                    MATRIX: 778->1|902->31|1308->401|1335->406|1433->468|1448->474|1504->508|1601->569|1616->575|1670->607|1747->648|1762->654|1823->693|1928->762|1943->768|2012->815|2105->872|2120->878|2188->923|2281->980|2296->986|2375->1042|2468->1099|2483->1105|2538->1138|2673->1237|2688->1243|2745->1278|2822->1319|2837->1325|2905->1371|2982->1412|2997->1418|3065->1464|3135->1498|3150->1504|3208->1540|3286->1582|3301->1588|3368->1633|3461->1690|3476->1696|3545->1743|3982->2144|4011->2151|4087->2191|4102->2197|4159->2232|4229->2266|4244->2272|4311->2317|4385->2355|4400->2361|4464->2403|4573->2476|4588->2482|4664->2535|4734->2569|4749->2575|4819->2623|4889->2657|4904->2663|4972->2709|5065->2766|5080->2772|5147->2817|5262->2896|5277->2902|5342->2945|5440->3007|5455->3013|5532->3067|5625->3124|5640->3130|5703->3171|5810->3242|5825->3248|5887->3288|5966->3331|5981->3337|6047->3381|6121->3419|6136->3425|6202->3469|6272->3503|6287->3509|6364->3564|6434->3598|6449->3604|6525->3658|6595->3692|6610->3698|6672->3738|6742->3772|6757->3778|6824->3823|6917->3880|6932->3886|7003->3934
                    LINES: 26->1|29->1|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|66->38|66->38|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|79->51|79->51|79->51|81->53|81->53|81->53|82->54|82->54|82->54|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64
                    -- GENERATED --
                */
            