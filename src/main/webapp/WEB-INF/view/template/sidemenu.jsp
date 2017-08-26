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
            <li class="">
                <a href="/employee/home">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>

            <%--<% String url_requested =  request.getAttribute("javax.servlet.forward.request_uri").toString();--%>

                <%--String nav_select_flag = null;--%>
                <%--String nav_select_open= null;--%>
                <%--System.out.println(url_requested);--%>
                <%--if(url_requested.equals("/employee/addNewEmployee")){--%>
                    <%--System.out.println("hello");--%>
                    <%--nav_select_flag = "nav-show";--%>
                    <%--nav_select_open= "open";--%>

                <%--}--%>
                <%--System.out.println(nav_select_flag);--%>
            <%--%>--%>


            <li class="open" id="employee">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">
								Employee
							</span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="" id="addNewEmployee">
                        <a href="/employee/addNewEmployee" id="employeeAdd">
                            <i class="menu-icon fa fa-caret-right"></i>
                            New Entry
                        </a>

                        <b class="arrow" id="employeeList"></b>
                    </li>
                    <li class="open">
                        <a href="/employee/home">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>



                </ul>
            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Branch </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>
<%--<%= request.getRequestURL()+"?"%>--%>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="/branch/addBranch">
                            <i class="menu-icon fa fa-caret-right"></i>
                            New Branch
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="/branch/viewAll">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>

            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Salary </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="/salary/addSalary">
                            <i class="menu-icon fa fa-caret-right"></i>
                           Add Salary
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="/salary/viewAll">
                            <i class="menu-icon fa fa-caret-right"></i>
                            View All
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>

            </li>


            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Designation </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="/designation/addDesignation">
                            <i class="menu-icon fa fa-caret-right"></i>
                            New Designation
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
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
