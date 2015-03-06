
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
object dashboard extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Cattle Center Dashboard")/*1.33*/ {_display_(Seq[Any](format.raw/*1.35*/("""

    <section id="container">
        <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
        <!--header start-->
        <header class="header black-bg">
            <div class="sidebar-toggle-box">
                <div class="fa fa-bars tooltips" data-placement="right"
                    data-original-title="Toggle Navigation"></div>
            </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>Smart App</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu"></div>
            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.html">Logout</a></li>
                </ul>
            </div>
        </header>
        <!--header end-->

        <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
        <!--sidebar start-->
        <aside>
            <div id="sidebar" class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu" id="nav-accordion">

                    <p class="centered">
                        <a href="profile.html"><img src=""""),_display_(Seq[Any](/*35.59*/routes/*35.65*/.Assets.at("images/tible.png"))),format.raw/*35.95*/(""""
                            class="img-circle" width="60" style="background-color: white;"></a>
                    </p>
                    <h5 class="centered">Admin</h5>

                    <li class="mt"><a class="active" href="index.html"> <i
                            class="fa fa-dashboard"></i> <span>Dashboard</span>
                    </a></li>

                    <li class="sub-menu"><a href="javascript:;"> <i
                            class="fa fa-desktop"></i> <span>UI Elements</span>
                    </a>
                        <ul class="sub">
                            <li><a href="general.html">General</a></li>
                            <li><a href="buttons.html">Buttons</a></li>
                            <li><a href="panels.html">Panels</a></li>
                        </ul></li>

                    <li class="sub-menu"><a href="javascript:;"> <i
                            class="fa fa-cogs"></i> <span>Components</span>
                    </a>
                        <ul class="sub">
                            <li><a href="calendar.html">Calendar</a></li>
                            <li><a href="gallery.html">Gallery</a></li>
                            <li><a href="todo_list.html">Todo List</a></li>
                        </ul></li>
                    <li class="sub-menu"><a href="javascript:;"> <i
                            class="fa fa-book"></i> <span>Extra Pages</span>
                    </a>
                        <ul class="sub">
                            <li><a href="blank.html">Blank Page</a></li>
                            <li><a href="login.html">Login</a></li>
                            <li><a href="lock_screen.html">Lock Screen</a></li>
                        </ul></li>
                    <li class="sub-menu"><a href="javascript:;"> <i
                            class="fa fa-tasks"></i> <span>Forms</span>
                    </a>
                        <ul class="sub">
                            <li><a href="form_component.html">Form Components</a></li>
                        </ul></li>
                    <li class="sub-menu"><a href="javascript:;"> <i
                            class="fa fa-th"></i> <span>Data Tables</span>
                    </a>
                        <ul class="sub">
                            <li><a href="basic_table.html">Basic Table</a></li>
                            <li><a href="responsive_table.html">Responsive Table</a></li>
                        </ul></li>
                    <li class="sub-menu"><a href="javascript:;"> <i
                            class=" fa fa-bar-chart-o"></i> <span>Charts</span>
                    </a>
                        <ul class="sub">
                            <li><a href="morris.html">Morris</a></li>
                            <li><a href="chartjs.html">Chartjs</a></li>
                        </ul></li>

                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
        <!--sidebar end-->

        <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
        <!--main content start-->
        <section id="main-content">
            <section class="wrapper">

                <div class="row">
                    <div class="col-lg-9 main-chart">

                        <div class="row mtbox">
                            <div class="col-md-3 col-sm-2 col-md-offset-1 box0">
                                <div class="box1">
                                    <img alt="Relax" src=""""),_display_(Seq[Any](/*109.60*/routes/*109.66*/.Assets.at("images/presentCow_burned.png"))),format.raw/*109.108*/(""""
                                        style="width: 100px; height: 120px;">
                                    <!-- <span class="li_heart"></span> -->
                                    <h3>33</h3>
                                </div>
                                <p>Number of cows in catle center as of today</p>
                            </div>
                            <div class="col-md-2 col-sm-2 box0">
                                <div class="box1">
                                    <img alt="Relax" src=""""),_display_(Seq[Any](/*118.60*/routes/*118.66*/.Assets.at("images/crying.png"))),format.raw/*118.97*/(""""
                                        style="width: 100px; height: 120px;">
                                    <!-- <span class="li_cloud"></span> -->
                                    <h3 id="weathervalue"></h3>
                                </div>
                                <p>Number of cows infected with BRD</p>
                            </div>
                            <!--  <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                 <span class="li_stack"></span>
                                <h3>23</h3> 
                            </div>
                             <p>Number of cows cured from BRD</p>
                        </div> -->
                            <div class="col-md-2 col-sm-2 box0">
                                <div class="box1">
                                    <img alt="Relax" src=""""),_display_(Seq[Any](/*134.60*/routes/*134.66*/.Assets.at("images/sadCow.png"))),format.raw/*134.97*/(""""
                                        style="width: 100px; height: 120px;">
                                    <!-- <span class="li_news"></span> -->
                                    <h3>+10</h3>
                                </div>
                                <p>Some cows are experiencing abnormal body temperatures!</p>
                            </div>
                            <div class="col-md-3 col-sm-2 box0">
                                <div class="box1">
                                    <img alt="Relax" src=""""),_display_(Seq[Any](/*143.60*/routes/*143.66*/.Assets.at("images/Relax_burned.png"))),format.raw/*143.103*/(""""
                                        style="width: 100px; height: 120px;">
                                    <!-- <span style="background-image: url(assets/img/Relax.jpg)"></span> -->
                                    <h3>OK!</h3>
                                </div>
                                <p>Your Cattle is working perfectly. Relax & enjoy.</p>
                            </div>

                        </div>
                        <!-- /row mt -->


                        <div class="row">
                            <!-- TWITTER PANEL -->
                            <div class="col-md-4 mb">
                                <div class="darkblue-panel pn">
                                    <div class="darkblue-header">
                                        <h5>DROPBOX STATICS</h5>
                                    </div>
                                    <canvas id="serverstatus02" height="120" width="120"></canvas>
                                    <script>
                                    var doughnutData = [
                                            """),format.raw/*165.45*/("""{"""),format.raw/*165.46*/("""
                                                value: 60,
                                                color:"#68dff0"
                                            """),format.raw/*168.45*/("""}"""),format.raw/*168.46*/(""",
                                            """),format.raw/*169.45*/("""{"""),format.raw/*169.46*/("""
                                                value : 40,
                                                color : "#444c57"
                                            """),format.raw/*172.45*/("""}"""),format.raw/*172.46*/("""
                                        ];
                                        var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
                                </script>
                                    <p>April 17, 2014</p>
                                    <footer>
                                        <div class="pull-left">
                                            <h5>
                                                <i class="fa fa-hdd-o"></i> 17 GB
                                            </h5>
                                        </div>
                                        <div class="pull-right">
                                            <h5>60% Used</h5>
                                        </div>
                                    </footer>
                                </div>
                                <! -- /darkblue panel -->
                            </div>
                            <!-- /col-md-4 -->


                            <div class="col-md-4 mb">
                                <!-- INSTAGRAM PANEL -->
                                <div class="darkblue-panel pn">
                                    <div class="darkblue-header">
                                        <h5>Today's Temperature Index</h5>
                                    </div>
                                    <canvas id="bar1" height="180" width="400"></canvas>
                                    <div id="buckets-size-bar-chart"> </div>
                                </div>
                            </div>
                            <!-- /col-md-4 -->

                            <div class="col-md-4 col-sm-4 mb">
                                <!-- REVENUE PANEL -->
                                <div class="darkblue-panel pn">
                                    <div class="darkblue-header">
                                        <h5>REVENUE</h5>
                                    </div>
                                    <div class="chart mt">
                                        <div class="sparkline" data-type="line" data-resize="true"
                                            data-height="75" data-width="90%" data-line-width="1"
                                            data-line-color="#fff" data-spot-color="#fff"
                                            data-fill-color="" data-highlight-line-color="#fff"
                                            data-spot-radius="4"
                                            data-data="[200,135,667,333,526,996,564,123,890,464,655]"></div>
                                    </div>
                                    <p class="mt">
                                        <b>$ 17,980</b><br />Month Income
                                    </p>
                                </div>
                            </div>
                            <!-- /col-md-4 -->

                        </div>
                        <!-- /row -->

                        <div class="row mt">
                            <!--CUSTOM CHART START -->
                            <div class="border-head">
                                <h3>VISITS</h3>
                            </div>
                            <div class="custom-bar-chart">
                                <ul class="y-axis">
                                    <li><span>10.000</span></li>
                                    <li><span>8.000</span></li>
                                    <li><span>6.000</span></li>
                                    <li><span>4.000</span></li>
                                    <li><span>2.000</span></li>
                                    <li><span>0</span></li>
                                </ul>
                                <div class="bar">
                                    <div class="title">JAN</div>
                                    <div class="value tooltips" data-original-title="8.500"
                                        data-toggle="tooltip" data-placement="top">85%</div>
                                </div>
                                <div class="bar ">
                                    <div class="title">FEB</div>
                                    <div class="value tooltips" data-original-title="5.000"
                                        data-toggle="tooltip" data-placement="top">50%</div>
                                </div>
                                <div class="bar ">
                                    <div class="title">MAR</div>
                                    <div class="value tooltips" data-original-title="6.000"
                                        data-toggle="tooltip" data-placement="top">60%</div>
                                </div>
                                <div class="bar ">
                                    <div class="title">APR</div>
                                    <div class="value tooltips" data-original-title="4.500"
                                        data-toggle="tooltip" data-placement="top">45%</div>
                                </div>
                                <div class="bar">
                                    <div class="title">MAY</div>
                                    <div class="value tooltips" data-original-title="3.200"
                                        data-toggle="tooltip" data-placement="top">32%</div>
                                </div>
                                <div class="bar ">
                                    <div class="title">JUN</div>
                                    <div class="value tooltips" data-original-title="6.200"
                                        data-toggle="tooltip" data-placement="top">62%</div>
                                </div>
                                <div class="bar">
                                    <div class="title">JUL</div>
                                    <div class="value tooltips" data-original-title="7.500"
                                        data-toggle="tooltip" data-placement="top">75%</div>
                                </div>
                            </div>
                            <!--custom chart end-->
                        </div>
                        <!-- /row -->

                    </div>
                    <!-- /col-lg-9 END SECTION MIDDLE -->


                    <!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

                    <div class="col-lg-3 ds">
                        <!--COMPLETED ACTIONS DONUTS CHART-->
                        <h3>Notifications</h3>

                        <!-- First Action -->
                        <div class="desc">
                            <div class="thumb">
                                <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                            </div>
                            <div class="details">
                                <p>
                                    <muted>2 Minutes Ago</muted>
                                    <br /> <a href="#">Cow1</a> experienced sudden rise in its body
                                    temperature<br />
                                </p>
                            </div>
                        </div>
                        <!-- Second Action -->
                        <div class="desc">
                            <div class="thumb">
                                <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                            </div>
                            <div class="details">
                                <p>
                                    <muted>3 Hours Ago</muted>
                                    <br /> <a href="#">Cow 3</a> experienced sudden rise in its
                                    body temperature<br />
                                </p>
                            </div>
                        </div>

                        <!-- USERS ONLINE SECTION -->
                        <h3>Treatments offered for BRD in Metaphylaxis</h3>
                        <!-- First Member -->
                        <div class="desc">
                            <div class="thumb"></div>
                            <div class="details">
                                <p>
                                    <a href="#">Micotil® (tilmicosin)</a><br />
                                    <muted>Cost to treat a 500-pound calf - $8.00</muted>
                                </p>
                            </div>
                        </div>
                        <!-- Second Member -->
                        <div class="desc">
                            <div class="thumb"></div>
                            <div class="details">
                                <p>
                                    <a href="#">Nuflor® (florphenicol)</a><br />
                                    <muted>Cost to treat a 500-pound calf - $15.00</muted>
                                </p>
                            </div>
                        </div>
                        <!-- Third Member -->
                        <div class="desc">
                            <div class="thumb"></div>
                            <div class="details">
                                <p>
                                    <a href="#">Tetradure® (oxytetracycline 300 mg/ml)</a><br />
                                    <muted>Cost to treat a 500-pound calf - ($4.05 - $6.02)</muted>
                                </p>
                            </div>
                        </div>
                        <!-- Fourth Member -->
                        <div class="desc">
                            <div class="thumb"></div>
                            <div class="details">
                                <p>
                                    <a href="#">Excede® (ceftiofur 200mg/ml)</a><br />
                                    <muted>Cost to treat a 500-pound calf - $13.12</muted>
                                </p>
                            </div>
                        </div>
                        <!-- Fifth Member -->
                        <div class="desc">
                            <div class="thumb"></div>
                            <div class="details">
                                <p>
                                    <a href="#">Draxxin® (tuluthramycin)</a><br />
                                    <muted>Cost to treat a 500-pound calf - $18.15</muted>
                                </p>
                            </div>
                        </div>

                        <!-- CALENDAR-->
                        <div id="calendar" class="mb">
                            <div class="panel green-panel no-margin">
                                <div class="panel-body">
                                    <div id="date-popover" class="popover top"
                                        style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
                                        <div class="arrow"></div>
                                        <h3 class="popover-title" style="disadding: none;"></h3>
                                        <div id="date-popover-content" class="popover-content"></div>
                                    </div>
                                    <div id="my-calendar"></div>
                                </div>
                            </div>
                        </div>
                        <!-- / calendar -->

                    </div>
                    <!-- /col-lg-3 -->
                </div>
            </section>
        </section>

        <!--main content end-->
        <!--footer start-->
        <footer class="site-footer">
            <div class="text-center">
                2014 - Alvarez.is <a href="index.html#" class="go-top"> <i
                    class="fa fa-angle-up"></i>
                </a>
            </div>
        </footer>
        <!--footer end-->
    </section>

    <script type="application/javascript">
        $(document).ready(function () """),format.raw/*410.39*/("""{"""),format.raw/*410.40*/("""
            //$("#date-popover").popover("""),format.raw/*411.42*/("""{"""),format.raw/*411.43*/("""html: true, trigger: "manual""""),format.raw/*411.72*/("""}"""),format.raw/*411.73*/(""");
            $("#date-popover").hide();
            $("#date-popover").click(function (e) """),format.raw/*413.51*/("""{"""),format.raw/*413.52*/("""
                $(this).hide();
            """),format.raw/*415.13*/("""}"""),format.raw/*415.14*/(""");
        
            $("#my-calendar").zabuto_calendar("""),format.raw/*417.47*/("""{"""),format.raw/*417.48*/("""
                action: function () """),format.raw/*418.37*/("""{"""),format.raw/*418.38*/("""
                    return myDateFunction(this.id, false);
                """),format.raw/*420.17*/("""}"""),format.raw/*420.18*/(""",
                action_nav: function () """),format.raw/*421.41*/("""{"""),format.raw/*421.42*/("""
                    return myNavFunction(this.id);
                """),format.raw/*423.17*/("""}"""),format.raw/*423.18*/(""",
                ajax: """),format.raw/*424.23*/("""{"""),format.raw/*424.24*/("""
                    url: "show_data.php?action=1",
                    modal: true
                """),format.raw/*427.17*/("""}"""),format.raw/*427.18*/(""",
                legend: [
                    """),format.raw/*429.21*/("""{"""),format.raw/*429.22*/("""type: "text", label: "Special event", badge: "00""""),format.raw/*429.71*/("""}"""),format.raw/*429.72*/(""",
                    """),format.raw/*430.21*/("""{"""),format.raw/*430.22*/("""type: "block", label: "Regular event", """),format.raw/*430.61*/("""}"""),format.raw/*430.62*/("""
                ]
            """),format.raw/*432.13*/("""}"""),format.raw/*432.14*/(""");
        """),format.raw/*433.9*/("""}"""),format.raw/*433.10*/(""");
        
        
        function myNavFunction(id) """),format.raw/*436.36*/("""{"""),format.raw/*436.37*/("""
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        """),format.raw/*441.9*/("""}"""),format.raw/*441.10*/("""
    </script>

    <script>
        var barChartData = """),format.raw/*445.28*/("""{"""),format.raw/*445.29*/("""
            labels : ["January","February","March","April","May","June","July"],
            datasets : [
                """),format.raw/*448.17*/("""{"""),format.raw/*448.18*/("""
                    fillColor : "rgba(220,220,220,0.5)",
                    strokeColor : "rgba(220,220,220,1)",
                    data : [65,59,90,81,56,55,40]
                """),format.raw/*452.17*/("""}"""),format.raw/*452.18*/(""",
                """),format.raw/*453.17*/("""{"""),format.raw/*453.18*/("""
                    fillColor : "rgba(151,187,205,0.5)",
                    strokeColor : "rgba(151,187,205,1)",
                    data : [28,48,40,19,96,27,100]
                """),format.raw/*457.17*/("""}"""),format.raw/*457.18*/("""
            ]
        """),format.raw/*459.9*/("""}"""),format.raw/*459.10*/(""";
        var mybar = new Chart(document.getElementById("bar1").getContext("2d")).Bar(barChartData);
    </script> 

""")))})),format.raw/*463.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 06 14:27:14 PST 2015
                    SOURCE: /home/ramyaky/Ramya/play-2.2.4/projectcmpe282/app/views/dashboard.scala.html
                    HASH: da0a953aa14db0875a6e5248c7744c9ca538d81f
                    MATRIX: 868->1|907->32|946->34|2753->1805|2768->1811|2820->1841|6668->5652|6684->5658|6750->5700|7322->6235|7338->6241|7392->6272|8333->7176|8349->7182|8403->7213|8987->7760|9003->7766|9064->7803|10200->8910|10230->8911|10427->9079|10457->9080|10532->9126|10562->9127|10762->9298|10792->9299|23357->21835|23387->21836|23458->21878|23488->21879|23546->21908|23576->21909|23697->22001|23727->22002|23801->22047|23831->22048|23918->22106|23948->22107|24014->22144|24044->22145|24149->22221|24179->22222|24250->22264|24280->22265|24377->22333|24407->22334|24460->22358|24490->22359|24619->22459|24649->22460|24726->22508|24756->22509|24834->22558|24864->22559|24915->22581|24945->22582|25013->22621|25043->22622|25103->22653|25133->22654|25172->22665|25202->22666|25287->22722|25317->22723|25568->22946|25598->22947|25683->23003|25713->23004|25865->23127|25895->23128|26105->23309|26135->23310|26182->23328|26212->23329|26423->23511|26453->23512|26504->23535|26534->23536|26684->23654
                    LINES: 29->1|29->1|29->1|63->35|63->35|63->35|137->109|137->109|137->109|146->118|146->118|146->118|162->134|162->134|162->134|171->143|171->143|171->143|193->165|193->165|196->168|196->168|197->169|197->169|200->172|200->172|438->410|438->410|439->411|439->411|439->411|439->411|441->413|441->413|443->415|443->415|445->417|445->417|446->418|446->418|448->420|448->420|449->421|449->421|451->423|451->423|452->424|452->424|455->427|455->427|457->429|457->429|457->429|457->429|458->430|458->430|458->430|458->430|460->432|460->432|461->433|461->433|464->436|464->436|469->441|469->441|473->445|473->445|476->448|476->448|480->452|480->452|481->453|481->453|485->457|485->457|487->459|487->459|491->463
                    -- GENERATED --
                */
            