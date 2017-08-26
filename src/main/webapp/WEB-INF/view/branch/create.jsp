<%@ page import="javax.naming.Context" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../template/header.jsp"%>

<%@include file="../template/sidemenu.jsp"%>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>


                <li class="active">Branch</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">

            <div class="page-header">
                <h1>
                    New Branch
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        Enter Branch details
                    </small>
                </h1>


            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">

                    <!-- PAGE CONTENT BEGINS -->
         <form:form  modelAttribute="branch" class="form-horizontal"  action="/branch/saveBranch" method="POST"  >
            <%@include file="../template/_messages.jsp"%>
            <%@include file="_form.jsp"%>
          </form:form>


                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->


<%--footer start--%>
<%@include file="../template/footer.jsp"%>
<%--footer end--%>
</body>
</html>