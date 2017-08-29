<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>

                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>

                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>

                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>

            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div><!-- /.sidebar-shortcuts -->

        <ul class="nav nav-list">
            <li class="" id="dashboard">
                <a href="/employee/home">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="" id="employee">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">
								Employee
							</span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="" id="empNewEntry">
                        <a href="/employee/addNewEmployee">
                            <i class="menu-icon fa fa-caret-right"></i>
                            New Entry
                        </a>

                        <b class="arrow" id="employeeList"></b>
                    </li>
                    <li class="" id="empViewAll">
                        <a href="/employee/viewAll">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>



                </ul>
            </li>

            <li class="" id="branch">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Branch </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>
<%--<%= request.getRequestURL()+"?"%>--%>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="" id="branchNewEntry" >
                        <a href="/branch/addBranch">
                            <i class="menu-icon fa fa-caret-right"></i>
                            New Branch
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="" id="branchViewAll">
                        <a href="/branch/viewAll">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>

            </li>

            <li class="" id="salary">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Salary </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="" id="salaryNewEntry">
                        <a href="/salary/addSalary">
                            <i class="menu-icon fa fa-caret-right"></i>
                           Add Salary
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="" id="salaryViewAll">
                        <a href="/salary/viewAll">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>

            </li>


            <li class="" id="designation">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Designation </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="" id="designationNewEntry">
                        <a href="/designation/addDesignation">
                            <i class="menu-icon fa fa-caret-right"></i>
                            New Designation
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="" id="designationViewAll">
                        <a href="/designation/viewAll">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>

            </li>


        </ul><!-- /.nav-list -->

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>
