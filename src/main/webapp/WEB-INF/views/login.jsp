<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Login Page | Amaze UI Example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="alternate icon" type="image/png" href="/static/assets/i/favicon.png">
    <link rel="stylesheet" href="/static/assets/css/amazeui.min.css"/>
    <style>
        .header {
            text-align: center;
        }

        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }

        .header p {
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <h1>Web ide</h1>
        <p>Integrated Development Environment<br/>代码编辑，代码生成，界面设计，调试，编译</p>
    </div>
    <hr/>
</div>
<div class="am-g">
    <div class="col-lg-6 col-md-8 col-sm-centered">
        <h3>登录</h3>
        <hr>
        <div class="am-btn-group">
            <a href="#" class="am-btn am-btn-secondary am-btn-sm"><i class="am-icon-github am-icon-sm"></i> Github</a>
            <a href="#" class="am-btn am-btn-success am-btn-sm"><i class="am-icon-google-plus-square am-icon-sm"></i>
                Google+</a>
            <a href="#" class="am-btn am-btn-primary am-btn-sm"><i class="am-icon-stack-overflow am-icon-sm"></i>
                stackOverflow</a>
        </div>
        <br>
        <br>

        <form method="post" class="am-form" action="/loginCheck" onsubmit="return searchCheck()">
            <label for="name">用户名:</label>
            <input type="text" name="name" id="name" value="">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" value="">
            <br>
            <label for="remember-me">
                <input id="remember-me" type="checkbox">
                记住密码
            </label>
            <br/>
            <div class="am-cf">
                <input type="submit" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
            </div>
        </form>
        <hr>
        <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
<script>
    function searchCheck() {
        //得到输入框对象
        var name = document.getElementById("name");
        var password = document.getElementById("password");
        //判断输入框是否有内容
        if (name.value.length === 0) {
            confirm("用户名不能为空");
            return false;
        }
        if (password.value.length === 0) {
            confirm("密码不能为空");
            return false;
        }

        return true;
    }
</script>
</body>
</html>