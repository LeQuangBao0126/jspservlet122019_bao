/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.27
 * Generated at: 2020-04-05 07:20:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin.building;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class abcinsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Thêm toà nhà</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main-content\">\r\n");
      out.write("    <div class=\"main-content-inner\">\r\n");
      out.write("        <div class=\"breadcrumbs ace-save-state\" id=\"breadcrumbs\">\r\n");
      out.write("            <ul class=\"breadcrumb\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <i class=\"ace-icon fa fa-home home-icon\"></i>\r\n");
      out.write("                    <a href=\"#\">Trang chủ</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"#\">Thêm toà nhà</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul><!-- /.breadcrumb -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"page-content\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"widget-box\">\r\n");
      out.write("                            <div class=\"widget-header\">\r\n");
      out.write("                                <h4 class=\"widget-title\">Thêm Toà Nhà</h4>\r\n");
      out.write("                                <div class=\"widget-toolbar\">\r\n");
      out.write("                                    <a href=\"#\" data-action=\"collapse\">\r\n");
      out.write("                                        <i class=\"ace-icon fa fa-chevron-up\"></i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"widget-body\">\r\n");
      out.write("                                <div class=\"widget-main\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-xs-12\">\r\n");
      out.write("                                            <!-- PAGE CONTENT BEGINS -->\r\n");
      out.write("                                            <form id=\"forminsert\">\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("                                                <div class=\"col-sm-7\">\r\n");
      out.write("                                                    <div>\r\n");
      out.write("                                                        <label for=\"name\"> Tên Toà Nhà </label>\r\n");
      out.write("                                                        <input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" />\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>                                                                                    \r\n");
      out.write("                                                <div class=\"col-sm-4\">\r\n");
      out.write("                                                    <label for=\"\">Phường</label>\r\n");
      out.write("                                                    <input type=\"text\" id=\"ward\" name=\"ward\" class=\"form-control\" />\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-sm-4\">\r\n");
      out.write("                                                    <label for=\"\">Đường</label>\r\n");
      out.write("                                                    <input type=\"text\" name=\"street\" name=\"street\" class=\"form-control\" />\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-sm-4\">\r\n");
      out.write("                                                    <label for=\"\">Số Tầng Hầm</label>\r\n");
      out.write("                                                    <input type=\"number\" id=\"numberOfBasement\" name=\"numberOfBasement\" class=\"form-control\" />\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                                                           \r\n");
      out.write("                                                <div class=\"col-sm-3\">\r\n");
      out.write("                                                    <label for=\"\">Diện tích thuê</label>\r\n");
      out.write("                                                    <input type=\"text\" id=\"rentAreas\" name=\"rentAreas\" class=\"form-control\" />\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                  <div class=\"col-sm-3\">\r\n");
      out.write("                                                    <label for=\"\">Diện tích sàn</label>\r\n");
      out.write("                                                    <input type=\"number\" id=\"floorarea\" name=\"floorarea\" class=\"form-control\" />\r\n");
      out.write("                                                </div>                                      \r\n");
      out.write("                                                <div class=\"col-sm-12\">\r\n");
      out.write("                                                    <div class=\"control-group\">\r\n");
      out.write("                                                        <label class=\"control-label bolder blue\">Loại toà nhà</label>\r\n");
      out.write("                                                        <div class=\"checkbox\">\r\n");
      out.write("                                                            <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"buildingTypes\" value=\"TANG_TRET\" type=\"checkbox\" class=\"ace\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"lbl\">Tầng Trệt</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("                                                            <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"buildingTypes\" value=\"NGUYEN_CAN\" type=\"checkbox\" class=\"ace\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"lbl\">Nguyên Căn</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("                                                            <label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"buildingTypes\" value=\"NOI_THAT\" type=\"checkbox\" class=\"ace\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"lbl\">Nội Thất</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-sm-12\">\r\n");
      out.write("                                                   \r\n");
      out.write("                                                 <button class=\"pull-left\" id=\"btnThemToaNha\"  title=\"Thêm Toà Nhà\" class=\"btn btn-sucess btn-info btn-bold\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t \t\tThêm Toà Nhà\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t     \t</button>\r\n");
      out.write("                                \r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                            <!-- PAGE CONTENT ENDS -->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <!-- /.col -->\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>                                      \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.row -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.page-content -->\r\n");
      out.write("    </div>\r\n");
      out.write("</div><!-- /.main-content -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
