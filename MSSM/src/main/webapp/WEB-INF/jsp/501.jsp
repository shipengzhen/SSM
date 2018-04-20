<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>501</title>

    <!-- Bootstrap -->
    <link href="${path}/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${path}/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${path}/statics/css/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${path}/statics/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
          <div class="col-middle">
            <div class="text-center">
              <h1 class="error-number">501</h1>
              <h2>${exception.message}</h2>
              <p>请返回到 <a href="${path}/login">系统入口</a>
              </p>
            </div>
          </div>
        </div>
        <!-- /page content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="${path}/statics/js/jquery-1.8.0.min.js"></script>
    <!-- Bootstrap -->
    <script src="${path}/statics/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${path}/statics/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${path}/statics/js/nprogress.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="${path}/statics/js/custom.min.js"></script>
  </body>
</html>				
			