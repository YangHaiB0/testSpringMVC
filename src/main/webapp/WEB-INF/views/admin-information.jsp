<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin user Examples</title>
    <meta name="description" content="这是一个 user 页面">
    <meta name="keywords" content="user">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="static/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="static/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="static/css/custom.css">
    <link rel="stylesheet" href="static/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="static/assets/css/admin.css">
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/js/bootstrap.min.js" type="application/javascript"></script>
</head>
<body>
<header class="am-topbar admin-header">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">后台管理模板</span>
                </button>
                <a class="navbar-brand" href="/">后台管理模板</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${sessionScope.user!=null}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true"
                               aria-expanded="false">
                                <c:set var="name" value="${sessionScope.user.getUserName()}"/>
                                <span>管理员${name}</span>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Unknown</a></li>
                                <li><a href="/logout">注销</a></li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div class="am-cf admin-main">
    <div class="admin-sidebar">
        <ul class="am-list admin-sidebar-list">
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-student'}"><span class="am-icon-file"></span>
                    学生管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-student">
                    <li><a href="/adminStudent"><span class="am-icon-table"></span> 表格<span
                            class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-user'}"><span class="am-icon-file"></span> 用户管理
                    <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-user">
                    <li><a href="/adminUser"><span class="am-icon-table"></span> 表格<span
                            class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
                </ul>
            </li>
            <li><a href="/adminLogout"><span class="am-icon-sign-out"></span> 注销</a></li>
        </ul>
        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-bookmark"></span> 公告</p>
                <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
            </div>
        </div>
    </div>

    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户信息</strong> / <small>user
                information</small></div>
        </div>
        <hr/>
        <div class="am-g">
            <div class="col-sm-12 col-md-4 col-md-push-8">
                <!--头像修改-->
                <%--                <div class="am-panel am-panel-default">--%>
                <%--                    <div class="am-panel-bd">--%>
                <%--                        <div class="am-g">--%>
                <%--                            <div class="col-md-4">--%>
                <%--                                <img class="am-img-circle am-img-thumbnail"--%>
                <%--                                     src="http://amui.qiniudn.com/bw-2014-06-19.jpg?imageView/1/w/1000/h/1000/q/80"--%>
                <%--                                     alt=""/>--%>
                <%--                            </div>--%>
                <%--                            <div class="col-md-8">--%>
                <%--                                <p>你可以使用<a href="#">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>--%>
                <%--                                <form class="am-form">--%>
                <%--                                    <div class="am-form-group">--%>
                <%--                                        <input type="file" id="user-pic">--%>
                <%--                                        <p class="am-form-help">请选择要上传的文件...</p>--%>
                <%--                                        <button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>--%>
                <%--                                    </div>--%>
                <%--                                </form>--%>
                <%--                            </div>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>

            <div class="col-sm-12 col-md-8 col-md-pull-4">
                <form class="am-form am-form-horizontal" action="/adminUpdateOrCreateUser" method="post"
                      onsubmit="return updateOrCreateUser()">
                    <div hidden>
                        <input type="text" id="user-id" name="id" value="${user.userId}">
                    </div>
                    <div class="am-form-group">
                        <label for="user-name" class="col-sm-3 am-form-label">姓名 / Name</label>
                        <div class="col-sm-9">
                            <input type="text" id="user-name" name="name" placeholder="${user.userName}"
                                   value="${user.userName}">
                        </div>
                    </div>
                    <c:if test="${user.userName == null}">
                        <div class="am-form-group">
                            <label for="user-intro" class="col-sm-3 am-form-label">密码 / Password</label>
                            <div class="col-sm-9">
                                <input type="password" name="password" id="user-password">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="user-intro" class="col-sm-3 am-form-label">重复密码 / Password</label>
                            <div class="col-sm-9">
                                <input type="password" id="user-password-re">
                            </div>
                        </div>
                    </c:if>

                    <div class="am-form-group">
                        <label for="user-email" class="col-sm-3 am-form-label">电子邮件 / Email</label>
                        <div class="col-sm-9">
                            <input type="email" id="user-email" name="email" placeholder="${user.userEmail}"
                                   value="${user.userEmail}">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="user-QQ" class="col-sm-3 am-form-label">QQ</label>
                        <div class="col-sm-9">
                            <input type="text" id="user-QQ" name="qq" placeholder="${user.userQq}"
                                   value="${user.userQq}">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="user-intro" class="col-sm-3 am-form-label">简介 / Intro</label>
                        <div class="col-sm-9">
                            <textarea class="" rows="5" id="user-intro" name="info"
                                      placeholder="${user.userInfo}">${user.userInfo}</textarea>
                        </div>
                    </div>
                    <c:if test="${user.userName == null}">
                        <div class="am-form-group">
                            <label for="user-intro" class="col-sm-3 am-form-label">是否管理员 / Admin</label>
                            <div class="col-sm-9">
                                <input hidden name="checked" id="user-is-admin" value="notAdmin">
                                <input type="checkbox" id="user-check-is-admin" value="notAdmin"
                                       class="am-btn am-btn-primary am-btn-sm am-fl" onclick="isAdminCheck(this)">
                            </div>
                        </div>
                    </c:if>
                    <div class="am-form-group">
                        <div class="col-sm-9 col-sm-push-3">
                            <button type="submit" class="am-btn am-btn-primary">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- content end -->

</div>

<footer>
    <hr>
    <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<script src="static/assets/js/zepto.min.js"></script>
<script src="static/assets/js/amazeui.min.js"></script>
<script src="static/assets/js/app.js"></script>
<script>
    function isAdminCheck(obj) {
        var checked = $("#user-check-is-admin").prop("checked");
        if (checked === true) {
            $("#user-is-admin").prop("value", "isAdmin");
        } else {
            $("#user-is-admin").prop("value", "notAdmin");
        }
    }

    function updateOrCreateUser() {
        //用户名为空判断
        var username = document.getElementById("user-name");
        if (username.value.length === 0) {
            confirm("请输入用户名");
            return false;
        }
        //密码为空判断
        var password = document.getElementById("user-password");
        if (password.value.length === 0) {
            confirm("请输入密码");
            return false;
        }
        //重复密码为空判断
        var re_password = document.getElementById("user-password-re");
        if (re_password.value.length === 0) {
            confirm("请再次确认密码");
            return false;
        }
        //两次密码一致性判断
        if (password.value !== re_password.value) {
            confirm("两次密码不一致");
            return false;
        }
        //电子邮件正确性判断
        var userEmail = document.getElementById("user-email");
        if (userEmail.value.length === 0) {
            confirm("请输入邮箱");
            return false;
        }
        var reg = /^\w+((-\w+)|(\.\w+))*@[A-Za-z0-9]+(([.\-])[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if (!reg.test(userEmail.value)) {
            confirm("邮箱格式不正确");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
