<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

                <li>
                    <a href="#">Employee</a>
                </li>
                <li class="active">List and Action</li>
            </ul><!-- /.breadcrumb -->

            <div class="nav-search" id="nav-search">
                <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                </form>
            </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    List Of Employees
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        operations
                    </small>
                </h1>                &nbsp; &nbsp; &nbsp; &nbsp;
                 <font color="#008b8b"> <b> ${message}</b> </font>

            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">


                    <!-- PAGE CONTENT BEGINS -->


                    <div class="row">
                        <div class="col-xs-12">

                            <div class="table-header">
                                Results for "Employees"
                            </div>

                            <!-- div.table-responsive -->

                            <!-- div.dataTables_borderWrap -->
                            <div>
                                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace" />
                                                <span class="lbl"></span>
                                            </label>
                                        </th>
                                        <th>Employee ID</th>
                                        <th>Name</th>
                                        <th class="hidden-480">Designation</th>

                                        <th>

                                            Gender
                                        </th>
                                        <th class="hidden-480">Mobile</th>

                                        <th></th>
                                    </tr>
                                    </thead>

                                    <tbody>



<c:forEach items="${employeeList}" var="employee">



                                    <tr>
                                        <td class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace" />
                                                <span class="lbl"></span>
                                            </label>
                                        </td>

                                        <td>
                                            <a href="#">${employee.empId}</a>
                                        </td>
                                        <td>${employee.firstName} ${employee.lastName}</td>
                                        <td class="hidden-480">${employee.designation}</td>
                                        <td>Male</td>

                                        <td class="hidden-480">
                                                ${employee.mobile}
                                        </td>

                                        <td>
                                            <div class="hidden-sm hidden-xs action-buttons">

                                                <a class="green" href="/employee/update?id=${employee.empId}">
                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                                <i ></i>

                                                <a class="red" href="/employee/delete?id=${employee.empId}">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                </a>
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                <div class="inline pos-rel">
                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                        <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                    </button>

                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                        <li>
                                                            <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																				<span class="blue">
																					<i class="ace-icon fa fa-search-plus bigger-120"></i>
																				</span>
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																				<span class="green">
																					<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																				<span class="red">
																					<i class="ace-icon fa fa-trash-o bigger-120"></i>
																				</span>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>

</c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>




                    </div>


                    <!-- PAGE CONTENT ENDS -->
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