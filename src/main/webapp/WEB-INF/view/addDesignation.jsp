<%@ page import="javax.naming.Context" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/resource/header.jsp"%>

<%@include file="/resource/sidemenu.jsp"%>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>


                <li class="active">Designation</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">

            <div class="page-header">
                <h1>
                    New Designation
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        Enter Designation details
                    </small>
                </h1>


            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">

                    <!-- PAGE CONTENT BEGINS -->
     <form:form  modelAttribute="designation" class="form-horizontal"  action="/designation/saveDesignation" method="POST"  >

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" >  </label>
                        <div class="col-sm-9"> <font color="#008b8b"> <b> ${message}</b> </font>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="designation"> Designation </label>

                            <div class="col-sm-9">

                                <form:input path="designation" type="text" id="designation"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="description"> Description </label>

                            <div class="col-sm-9">
                                <form:textarea path="description" rows="5" cols="30" id="description" />

                            </div>

                        </div>


                        <div class="space-4"></div>


                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn btn-info" type="button">
                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                    Submit
                                </button>
                                                           &nbsp; &nbsp; &nbsp;
                                <form:button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Reset
                                </form:button>
                            </div>
                        </div>
                    </form:form>


    </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->


<%--footer start--%>
<%@include file="/resource/footer.jsp"%>
<%--footer end--%>
</body>
</html>