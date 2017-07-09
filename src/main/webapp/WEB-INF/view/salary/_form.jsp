<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="employeeId"> Employee </label>

    <div class="col-sm-9">
        <form:hidden path="salaryId" />
        <form:input path="employeeId" type="text"  id="employeeId"  />
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="salary"> Salary </label>

    <div class="col-sm-9">
        <form:input path="salary" id="salary"/>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="description"> Description </label>

    <div class="col-sm-9">
        <form:input path="description" type="text" id="description"  />
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