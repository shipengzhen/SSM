<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
String path = request.getContextPath();//相对路径
session.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";//相对路径
String images=path+"/statics/images";
session.setAttribute("images",images);
String css=path+"/statics/css";
session.setAttribute("css",css);
String js=path+"/statics/js";
session.setAttribute("js",js);
%>


