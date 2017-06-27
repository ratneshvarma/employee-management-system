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


                <li class="active">Employee</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">

            <div class="page-header">
                <h1>
                    Update Employee
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        Enter all employee details that you want update
                    </small>
                </h1>


            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">

                    <!-- PAGE CONTENT BEGINS -->
                    <form:form  modelAttribute="employee" class="form-horizontal" enctype="multipart/form-data" role="form" action="/employee/updateEmployee" method="POST"  >

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" >  </label>
                            <div class="col-sm-9"> <font color="#008b8b"> <b> ${message}</b> </font>
                            </div>



                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="empId"> Employee Id </label>

                            <div class="col-sm-9">
                                <form:input path="empId" readonly="true" type="text" id="empId" value="${employee.empId}" />

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="firstName"> First Name </label>

                            <div class="col-sm-9">
                                <form:input path="firstName" type="text" readonly="true" id="firstName" value="${employee.firstName}"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lastName"> Last Name </label>

                            <div class="col-sm-9">
                                <form:input path="lastName" type="text" id="lastName" value="${employee.lastName}"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="age">Age </label>

                            <div class="col-sm-9">
                                <form:input path="age" type="text" id="age" value="${employee.age}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="gender"> Gender </label>

                            <div class="col-sm-9">
                                <form:select path="gender">
                                    <form:option value="" label="Please select"/>
                                    <form:options items="${genderList}"/>
                                </form:select>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="maritalStatus"> Marital Status </label>

                            <div class="col-sm-9">
                                <form:select path="maritalStatus">
                                    <form:option value="" label="Please select"/>
                                    <form:options items="${maritalList}"/>
                                </form:select>


                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="dob"> Date of Birth </label>

                            <div class="col-sm-9">
                                <form:input path="dob" type="text" id="dob" value="${employee.dob}" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="designation"> Designation </label>

                            <div class="col-sm-9">
                                <form:select path="designation">
                                    <form:options items="${designationList}"/>
                                </form:select>

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="doj"> Date of Joining </label>

                            <div class="col-sm-9">
                                <form:input path="doj" type="text" id="doj" value="${employee.doj}" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="email"> Email </label>

                            <div class="col-sm-9">
                                <form:input path="email" type="text" id="email" value="${employee.email}"  />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="mobile"> Mobile </label>

                            <div class="col-sm-9">
                                <form:input path="mobile" type="text" id="mobile" value="${employee.mobile}" />

                            </div>
                        </div>



                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="address"> Address </label>

                            <div class="col-sm-9">
                                <form:textarea path="address" rows="5" cols="30" id="address"  value="${employee.address}"/>

                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="branchId"> Branch </label>

                            <div class="col-sm-9">
                                <form:select path="branchId">
                                    <form:options items="${branchList}"/>
                                </form:select>


                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="photo"> Uplaod New Photo </label>

                            <div class="col-sm-9">
                                <input type="file" name="photo" id="photo" placeholder="select image"  />
                         <img src="<c:url value="/employee_pictures/${employee.imageName}"/>" width="70" height="80" alt="Ratnesh Varma" />

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
                    <%--<img src="<c:url value="/employee_pictures/ratnesh_30.jpg"/>" width="50" height="50" alt="Ratnesh Varma" />--%>


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