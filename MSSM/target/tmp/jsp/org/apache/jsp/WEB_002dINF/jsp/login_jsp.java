package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jsp/common/taglib.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();//ç¸å¯¹è·¯å¾
session.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";//ç»å¯¹è·¯å¾
String images=path+"/statics/images";
session.setAttribute("images",images);
String css=path+"/statics/css";
session.setAttribute("css",css);
String js=path+"/statics/js";
session.setAttribute("js",js);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>北大青鸟办公自动化管理系统</title>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("* {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tfont: 12px 宋体;\r\n");
      out.write("\tbackground: #4BB8EF url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${images}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/bg.gif) repeat-x;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("img {\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-top {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 186px;\r\n");
      out.write("\tmargin: 147px auto 0;\r\n");
      out.write("\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${images}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login_01.gif) no-repeat center 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-area {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 140px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${images}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login_02.gif) no-repeat center 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-area form {\r\n");
      out.write("\twidth: 290px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-area label {\r\n");
      out.write("\tclear: left;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-top: 13px;\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\tfont: 600 14px 宋体;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-area  input {\r\n");
      out.write("\twidth: 122px;\r\n");
      out.write("\theight: 16px;\r\n");
      out.write("\tmargin-top: 11px;\r\n");
      out.write("\tborder: 1px #767F94 solid;\r\n");
      out.write("\tfont: 12px/16px 宋体;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input.login-sub {\r\n");
      out.write("\twidth: 104px;\r\n");
      out.write("\theight: 34px;\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${images}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login_sub.gif) no-repeat 0px 1px; *\r\n");
      out.write("\tmargin-top: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-copyright {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tmargin: 18px auto 0;\r\n");
      out.write("\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${images}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/copyright.gif) no-repeat center 0;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction changeValidateCode(obj) {\r\n");
      out.write("\t\t//获取当前的时间作为参数，无具体意义 \r\n");
      out.write("\t\tvar timenow = new Date().getTime();\r\n");
      out.write("\t\t//每次请求需要一个不同的参数，否则可能会返回同样的验证码\r\n");
      out.write("\t\t//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 \r\n");
      out.write("\t\tobj.src = \"random.action?d=\" + timenow;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check() {\r\n");
      out.write("\t\tvar msg = document.getElementById(\"msg\").value;\r\n");
      out.write("\t\tif (msg.length != 0) {\r\n");
      out.write("\t\t\tdocument.getElementById(\"msg\").value = \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"check()\">\r\n");
      out.write("\t<div class=\"login-top\"></div>\r\n");
      out.write("\t<div class=\"login-area\">\r\n");
      out.write("\t\t<form action=\"dologin\" method=\"post\">\r\n");
      out.write("\t\t\t<label> 工&nbsp;&nbsp;号： </label>\r\n");
      out.write("\t\t\t<input type=\"text\"name=\"sn\" /> \r\n");
      out.write("\t\t\t<label> 密&nbsp;&nbsp;码： </label>\r\n");
      out.write("\t\t\t<input type=\"password\" name=\"passWord\" /> \r\n");
      out.write("\t\t\t<label> 验证码： </label> \r\n");
      out.write("\t\t\t<input type=\"text\" name=\"random\" size=\"6\" /> \r\n");
      out.write("\t\t\t<input type=\"image\"src=\"random.action\" onclick=\"changeValidateCode(this)\" title=\"点击图片刷新验证码\" /> \r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"login-sub\" value=\"\" />\r\n");
      out.write("\t\t\t<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"msg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.msg }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login-copyright\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
