<%--
  Created by IntelliJ IDEA.
  User: julia98
  Date: 2019/5/9
  Time: 下午11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>企业网站模板</title>
    <link rel="stylesheet" href="css/amazeui.css" />
    <link rel="stylesheet" href="css/common.min.css" />
    <link rel="stylesheet" href="css/index.min.css" />
</head>
<body onload="getMovie()">
<div class="layout">
    <!--===========layout-header================-->
    <div class="layout-header am-hide-sm-only">


        <div class="header-box" data-am-sticky>
            <!--header start-->
            <div class="container">
                <div class="header">
                    <div class="am-g">
                        <div class="am-u-lg-2 am-u-sm-12">
                            <div class="logo">
                                <a href=""><img src="images/logo.png" alt="" /></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--header end-->
        </div>
    </div>

    <!--mobile header start-->
    <div class="m-header">
        <div class="am-g am-show-sm-only">
            <div class="am-u-sm-2">
                <div class="menu-bars">
                    <a href="#doc-oc-demo1" data-am-offcanvas="{effect: 'push'}"><i class="am-menu-toggle-icon am-icon-bars"></i></a>
                    <!-- 侧边栏内容 -->
                    <nav data-am-widget="menu" class="am-menu  am-menu-offcanvas1" data-am-menu-offcanvas >
                        <a href="javascript: void(0)" class="am-menu-toggle"></a>

                        <div class="am-offcanvas" >
                            <div class="am-offcanvas-bar">
                                <ul class="am-menu-nav am-avg-sm-1">
                                    <li><a href="./index.html" class="" >首页</a></li>
                                    <li class="am-parent">
                                        <a href="#" class="" >产品中心</a>
                                        <ul class="am-menu-sub am-collapse ">
                                            <li class="">
                                                <a href="html/product1.html" class="" >产品展示1</a>
                                            </li>
                                            <li class="">
                                                <a href="html/product2.html" class="" >产品展示2</a>
                                            </li>
                                            <li class="">
                                                <a href="html/product3.html" class="" >产品展示3</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class=""><a href="html/example.html" class="" >客户案例</a></li>
                                    <li class=""><a href="html/solution.html" class="" >解决方案</a></li>
                                    <li class="am-parent">
                                        <a href="html/news.html" class="" >新闻中心</a>
                                        <ul class="am-menu-sub am-collapse  ">
                                            <li class="">
                                                <a href="html/news-content.html" class="" >公司动态</a>
                                            </li>
                                            <li class="">
                                                <a href="html/404-dark.html" class="" >行业动态</a>
                                            </li>
                                            <li class="">
                                                <a href="html/404-light.html" class="" >精彩专题</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class=""><a href="html/about.html" class="" >关于我们</a></li>
                                    <li class=""><a href="html/join.html" class="" >加入我们</a></li>
                                    <li class=""><a href="html/contact.html" class="" >联系我们</a></li>
                                    <li class="am-parent">
                                        <a href="" class="nav-icon nav-icon-globe" >Language</a>
                                        <ul class="am-menu-sub am-collapse  ">
                                            <li>
                                                <a href="#" >English</a>
                                            </li>
                                            <li class="">
                                                <a href="#" >Chinese</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-share-contain">
                                        <div class="nav-share-links">
                                            <i class="am-icon-facebook"></i>
                                            <i class="am-icon-twitter"></i>
                                            <i class="am-icon-google-plus"></i>
                                            <i class="am-icon-pinterest"></i>
                                            <i class="am-icon-instagram"></i>
                                            <i class="am-icon-linkedin"></i>
                                            <i class="am-icon-youtube-play"></i>
                                            <i class="am-icon-rss"></i>
                                        </div>
                                    </li>
                                    <li class=""><a href="html/login.html" class="" >登录</a></li>
                                    <li class=""><a href="html/register.html" class="" >注册</a></li>
                                </ul>

                            </div>
                        </div>
                    </nav>

                </div>
            </div>
            <div class="am-u-sm-5 am-u-end">
                <div class="m-logo">
                    <a href=""><img src="images/logo.png" alt=""></a>
                </div>
            </div>
        </div>
        <!--mobile header end-->
    </div>




    <!--===========layout-container================-->
    <div class="layout-container">
        <div class="index-page">
            <div data-am-widget="tabs" class="am-tabs am-tabs-default">
                <div class="am-tabs-bd">
                    <div data-tab-panel-0 class="am-tab-panel am-active">
                        <div class="index-banner">
                            <div class="index-mask">
                                <div class="container">
                                    <div class="am-g">
                                        <div class="am-u-md-10 am-u-sm-centered">
                                            <h1 class="slide_simple--title">电影</h1>
                                            <p class="slide_simple--text am-text-left">
                                                电影电影电影电影电影电影电影电影电影电影电影电影
                                            </p>
                                            <div class="slide_simple--buttons">
                                                <button type="button" class="am-btn am-btn-danger">了解更多</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div data-tab-panel-1 class="am-tab-panel ">
                        <div class="index-banner">
                            <div class="index-mask">
                                <div class="container">
                                    <div class="am-g">
                                        <div class="am-u-md-10 am-u-sm-centered">
                                            <h1 class="slide_simple--title">电影</h1>
                                            <p class="slide_simple--text am-text-left">
                                                电影电影电影电影电影电影电影电影电影电影电影电影
                                            </p>
                                            <div class="slide_simple--buttons">
                                                <button type="button" class="am-btn am-btn-danger">了解更多</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div data-tab-panel-2 class="am-tab-panel ">
                        <div class="index-banner">
                            <div class="index-mask">
                                <div class="container">
                                    <div class="am-g">
                                        <div class="am-u-md-10 am-u-sm-centered">
                                            <h1 class="slide_simple--title">电影</h1>
                                            <p class="slide_simple--text am-text-left">
                                                电影电影电影电影电影电影电影电影电影电影电影电影
                                            </p>
                                            <div class="slide_simple--buttons">
                                                <button type="button" class="am-btn am-btn-danger">了解更多</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div data-tab-panel-3 class="am-tab-panel ">
                        <div class="index-banner">
                            <div class="index-mask">
                                <div class="container">
                                    <div class="am-g">
                                        <div class="am-u-md-10 am-u-sm-centered">
                                            <h1 class="slide_simple--title">电影</h1>
                                            <p class="slide_simple--text am-text-left">
                                                电影电影电影电影电影电影电影电影电影电影电影电影
                                            </p>
                                            <div class="slide_simple--buttons">
                                                <button type="button" class="am-btn am-btn-danger">了解更多</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <ul class="am-tabs-nav am-cf index-tab">
                    <li class="am-active">
                        <a href="[data-tab-panel-0] am-g">
                            <div class="am-u-md-3 am-u-sm-3 am-padding-right-0">
                                <i class="am-icon-cog"></i>
                            </div>
                            <div class="school-item-right am-u-md-9 am-u-sm-9 am-text-left">
                                <strong class="promo_slider_nav--item_title">电影1</strong>
                                <p class="promo_slider_nav--item_description">电影电影电影</p>
                            </div>
                        </a>
                    </li>
                    <li class="a">
                        <a href="[data-tab-panel-1] am-g">
                            <div class="am-u-md-3 am-u-sm-3 am-padding-right-0">
                                <i class="am-icon-lightbulb-o"></i>
                            </div>
                            <div class="school-item-right am-u-md-9 am-u-sm-9 am-text-left">
                                <strong class="promo_slider_nav--item_title">电影2</strong>
                                <p class="promo_slider_nav--item_description">电影电影电影</p>
                            </div>
                        </a>
                    </li>
                    <li class="">
                        <a href="[data-tab-panel-2] am-g">
                            <div class="am-u-md-3 am-u-sm-3 am-padding-right-0">
                                <i class="am-icon-line-chart"></i>
                            </div>
                            <div class="school-item-right am-u-md-9 am-u-sm-9 am-text-left">
                                <strong class="promo_slider_nav--item_title">电影3</strong>
                                <p class="promo_slider_nav--item_description">电影电影电影</p>
                            </div>
                        </a>
                    </li>
                    <li class="">
                        <a href="[data-tab-panel-3] am-g">
                            <div class="am-u-md-3 am-u-sm-3 am-padding-right-0">
                                <i class="am-icon-hourglass-end"></i>
                            </div>
                            <div class="school-item-right am-u-md-9 am-u-sm-9 am-text-left">
                                <strong class="promo_slider_nav--item_title">电影4</strong>
                                <p class="promo_slider_nav--item_description">电影电影电影</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </div>


    <div class="section">
        <div class="container">
            <div class="section--header">
                <h2 class="section--title">电影集成平台</h2>
                <p class="section--description">
                    电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影
                    <br>电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影电影
                </p>
            </div>

            <script>
                function getMovie() {
                    var movie;
                    $.ajax({
                        url: "/movie",
                        method: "get",
                        async: false,
                        success: function(res) {
                            movie = JSON.parse(res.data);
                            var time = movie/4;
                            for(var i = 0;i<movie.length;i++) {
                                if(i !== (time+1)) {
                                    document.getElementById("movie").innerHTML += "<div class=\"am-g\">\n" +
                                        "                    <div class=\"am-u-md-3\">\n" +
                                        "                        <div class=\"features_item\">\n" +
                                        "                            <img src=\"images/index/f01.jpg\" alt=\"\">\n" +
                                        "                            <h3 class=\"features_item--title\">" + movie.get(i*4).name + "</h3>\n" +
                                        "                            <p class=\"features_item--text\">\n" +
                                        "                                " + movie.get(i*4).description +"\n" +
                                        "                            </p>\n" +
                                        "                        </div>\n" +
                                        "                    </div>\n" +
                                        "                    <div class=\"am-u-md-3\">\n" +
                                        "                        <div class=\"features_item\">\n" +
                                        "                            <img src=\"images/index/f02.jpg\" alt=\"\">\n" +
                                        "                            <h3 class=\"features_item--title\">" + movie.get(i*4+1).name + "</h3>\n" +
                                        "                            <p class=\"features_item--text\">\n" +
                                        "                                " + movie.get(i*4+1).description +"\n" +
                                        "                            </p>\n" +
                                        "                        </div>\n" +
                                        "                    </div>\n" +
                                        "                    <div class=\"am-u-md-3\">\n" +
                                        "                        <div class=\"features_item\">\n" +
                                        "                            <img src=\"images/index/f03.jpg\" alt=\"\">\n" +
                                        "                            <h3 class=\"features_item--title\">" + movie.get(i*4+2).name + "</h3>\n" +
                                        "                            <p class=\"features_item--text\">\n" +
                                        "                                " + movie.get(i*4+2).description +"\n" +
                                        "                        </div>\n" +
                                        "                    </div>\n" +
                                        "                    <div class=\"am-u-md-3\">\n" +
                                        "                        <div class=\"features_item\">\n" +
                                        "                            <img src=\"images/index/f04.jpg\" alt=\"\">\n" +
                                        "                            <h3 class=\"features_item--title\">" + movie.get(i*4+3).name + "</h3>\n" +
                                        "                            <p class=\"features_item--text\">\n" +
                                        "                                " + movie.get(i*4+3).description +"\n" +
                                        "                            </p>\n" +
                                        "                        </div>\n" +
                                        "                    </div>\n" +
                                        "                </div>";
                                } else {
                                    var num = movie - time*4;
                                    document.getElementById("movie").innerHTML += "<div class=\"am-g\">";
                                    for(var j = 0;j<num;j++) {
                                        document.getElementById("movie").innerHTML += "<div class=\"am-u-md-3\">\n" +
                                            "                        <div class=\"features_item\">\n" +
                                            "                            <img src=\"images/index/f01.jpg\" alt=\"\">\n" +
                                            "                            <h3 class=\"features_item--title\">" + movie.get(time*4+j).name + "</h3>\n" +
                                            "                            <p class=\"features_item--text\">\n" +
                                            "                                " + movie.get(time*4+j).description +"\n" +
                                            "                            </p>\n" +
                                            "                        </div>\n" +
                                            "                    </div>";
                                    }
                                }
                            }
                        }
                    })
                }
            </script>

            <!--index-container start-->
            <div class="index-container" id="movie">
                <div class="am-g">
                    <div class="am-u-md-3">
                        <div class="features_item">
                            <img src="images/index/f01.jpg" alt="">
                            <h3 class="features_item--title">电影1</h3>
                            <p class="features_item--text">
                                用户可快速学习适配开发，通过丰富的组件库完成页面功能的移动化适配。
                            </p>
                        </div>
                    </div>
                    <div class="am-u-md-3">
                        <div class="features_item">
                            <img src="images/index/f02.jpg" alt="">
                            <h3 class="features_item--title">电影2</h3>
                            <p class="features_item--text">
                                Enterplorer Studio内置丰富的移动组件，大大提升了开发效率。
                            </p>
                        </div>
                    </div>
                    <div class="am-u-md-3">
                        <div class="features_item">
                            <img src="images/index/f03.jpg" alt="">
                            <h3 class="features_item--title">电影3</h3>
                            <p class="features_item--text">
                                整个适配过程可视化，集成手机模拟器，可以快速的开发调试。
                        </div>
                    </div>
                    <div class="am-u-md-3">
                        <div class="features_item">
                            <img src="images/index/f04.jpg" alt="">
                            <h3 class="features_item--title">电影4</h3>
                            <p class="features_item--text">
                                无需部署，实时上传实时呈现，复用现有系统流程及数据
                            </p>
                        </div>
                    </div>
                </div>

            </div>
            <!--index-container end-->
        </div>
    </div>

</div>


<!--===========layout-footer================-->
<%--<div class="layout-footer">--%>
    <%--<div class="footer">--%>
        <%--<div style="background-color:#383d61" class="footer--bg"></div>--%>
        <%--<div class="footer--inner">--%>
            <%--<div class="container">--%>
                <%--<div class="footer_main">--%>
                    <%--<div class="am-g">--%>
                        <%--&lt;%&ndash;<div class="am-u-md-3 ">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<div class="footer_main--column">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<strong class="footer_main--column_title">关于我们</strong>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<div class="footer_about">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<p class="footer_about--text">&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;云适配(AllMobilize Inc.) 是全球领先的HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立.&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<p class="footer_about--text">&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;云适配跨屏云也成功应用于超过30万家企业网站，包括微软、联想等世界500强企业&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<script src="js/jquery-2.1.0.js" charset="utf-8"></script>
<script src="js/amazeui.js" charset="utf-8"></script>
<script src="js/common.js" charset="utf-8"></script>
</body>

</html>

