<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

                <li>
                    <a href="#">Designation</a>
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
                    List Of Designation
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        operations
                    </small>
                </h1>
                <%@include file="../template/_messages.jsp"%>
            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">


                    <!-- PAGE CONTENT BEGINS -->


                    <div class="row">
                        <div class="col-xs-12">

                            <div class="table-header">
                                Results for "Designation"
                            </div>

                            <!-- div.table-responsive -->

                            <!-- div.dataTables_borderWrap -->
                            <div>
                                <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Designation</th>
                                        <th class="hidden-480">Description</th>

                                        <th></th>
                                    </tr>
                                    </thead>

                                    <tbody>



                                    <c:forEach items="${designationList}" var="designation">
                                    <tr>
                                            <td> ${designation.designation}</td>
                                            <td class="hidden-480">${designation.description}</td>

                                            <td>
                                                <div class="hidden-sm hidden-xs action-buttons">

                                                    <a class="green" href="/designation/update?id=${designation.designationId}">
                                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>
                                                    <i ></i>

                                                    <a class="red" href="/designation/delete?id=${designation.designationId}">
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
<%@include file="../template/footer.jsp"%>
<%--footer end--%>
</body>
</html>