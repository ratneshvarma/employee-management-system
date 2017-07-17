
<%--<div class="form-group">--%>
    <%--<label class="col-sm-3 control-label no-padding-right" for="empId"> Employee Id </label>--%>

    <%--<div class="col-sm-9">--%>
        <%--&lt;%&ndash;<form:input path="empId" readonly="true" type="text" id="empId"  />&ndash;%&gt;--%>

    <%--</div>--%>
<%--</div>--%>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="firstName"> First Name </label>

    <div class="col-sm-9">
        <form:input path="firstName" type="text" id="firstName" placeholder="xxxx"  />
    </div>
</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="lastName"> Last Name </label>

    <div class="col-sm-9">
        <form:input path="lastName" type="text" id="lastName" placeholder="yyyy"  />
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="age">Age </label>

    <div class="col-sm-9">
        <form:input path="age" type="text" id="age" placeholder="28"  value="" />
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="gender"> Gender </label>

    <div class="col-sm-9">
        <form:select path="gender" id="gender">
            <form:option value="" label="Please select"/>
            <form:options items="${genderList}"/>
        </form:select>

    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="maritalStatus"> Marital Status </label>

    <div class="col-sm-9">
        <form:select path="maritalStatus" id="maritalStatus">
            <form:option value="" label="Please select"/>
            <form:options items="${maritalList}"/>
        </form:select>


    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="dob"> Date of Birth </label>

    <div class="col-sm-9">
        <form:input path="dob" type="text" id="dob" placeholder="05/01/1982" />
    </div>
</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="designation"> Designation </label>

    <div class="col-sm-9">
        <form:select path="designation" id="designation">
            <form:options items="${designationList}"/>
        </form:select>

    </div>
</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="doj"> Date of Joining </label>

    <div class="col-sm-9">
        <form:input path="doj" type="text" id="doj" placeholder=""  />
    </div>
</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="email"> Email </label>

    <div class="col-sm-9">
        <form:input path="email" type="text" id="email" placeholder="abc@gmail.com"  />
    </div>
</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="mobile"> Mobile </label>

    <div class="col-sm-9">
        <form:input path="mobile" type="text" id="mobile" placeholder="0000000000"  />

    </div>
</div>



<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="address"> Address </label>

    <div class="col-sm-9">
        <form:textarea path="address" rows="5" cols="30" id="address" />

    </div>

</div>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="branchId"> Branch </label>

    <div class="col-sm-9">
        <form:select path="branchId" id="branchId">
            <form:options items="${branchList}"/>
        </form:select>


    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right" for="photo"> Uplaod Employee's Photo </label>

    <div class="col-sm-9">
        <input type="file" name="photo" id="photo" placeholder="select image"  />
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
