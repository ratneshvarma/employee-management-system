</div>  <%--Extra Div main closing--%>
<div class="footer">
    <div class="footer-inner">
        <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Employee Management System</span>
							 &copy; 2017
						</span>

            &nbsp; &nbsp;
            <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="http://facebook.com/ratneshkumarvarma">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

						</span>
        </div>
    </div>
</div>
<script language="JavaScript">
	$(document).ready(function(){
	var ur= document.URL.split("/");
	var selectedUrl= ur[ur.length-2]+"/"+document.URL.split("/").pop();

	if(selectedUrl=="employee/addNewEmployee"){
				$("#employee").addClass("open");
				$("#empNewEntry").addClass("open");
	}
	else if(selectedUrl=="employee/home"){
		$("#dashboard").addClass("open");
	}
	else if(selectedUrl=="employee/viewAll"){
		$("#employee").addClass("open");
		$("#empViewAll").addClass("open");
	}

	else if(selectedUrl=="branch/addBranch"){
		$("#branch").addClass("open");
		$("#branchNewEntry").addClass("open");
	}

	else if(selectedUrl=="branch/viewAll"){
		$("#branch").addClass("open");
		$("#branchViewAll").addClass("open");
	}

	else if(selectedUrl=="salary/addSalary"){
		$("#salary").addClass("open");
		$("#salaryNewEntry").addClass("open");
	}
	else if(selectedUrl=="salary/viewAll"){
		$("#salary").addClass("open");
		$("#salaryViewAll").addClass("open");
	}
	else if(selectedUrl=="designation/addDesignation"){
		$("#designation").addClass("open");
		$("#designationNewEntry").addClass("open");
	}
	else if(selectedUrl=="designation/viewAll"){
		$("#designation").addClass("open");
		$("#designationViewAll").addClass("open");
	}
	});

</script>



