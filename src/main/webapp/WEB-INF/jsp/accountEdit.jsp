<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>My Account Information</h1>


<form:form commandName="customerDetails" method="post">
<!-- 
<input type="hidden" name="formid" value="0923a4ea590b42438f4ff4a9af74d302" />
<input type="hidden" name="action" value="process" /> -->
<div class="contentContainer">
  <div>
    <div class="inputRequirement" style="float: right;">* Required information</div>

    <h2>My Account</h2>
  </div>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2" width="100%">

      <tr>
        <td class="fieldKey">Gender:</td>
        <td class="fieldValue">
        	<form:radiobutton path="gender" value="m" />&nbsp;&nbsp;Male&nbsp;&nbsp;<form:radiobutton path="gender" value="f" />&nbsp;&nbsp;Female&nbsp;<span class="inputRequirement">*</span><form:errors path="gender"/>
        </td>
      </tr>

      <tr>
        <td class="fieldKey">First Name:</td>
        <td class="fieldValue"><form:input path="firstname"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="firstname"/></td>
      </tr>
      <tr>
        <td class="fieldKey">Last Name:</td>
        <td class="fieldValue"><form:input path="lastname"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="lastname"/></td>
      </tr>

      <tr>
        <td class="fieldKey">Date of Birth:</td>
        <td class="fieldValue"><form:input path="dob" id="dob"/>&nbsp;<span class="inputRequirement">* (eg. 05/21/1970)</span><script type="text/javascript">$('#dob').datepicker({dateFormat: 'mm/dd/yy', changeMonth: true, changeYear: true, yearRange: '-100:+0'});</script><form:errors path="dob"/></td>
      </tr>

      <tr>
        <td class="fieldKey">E-Mail Address:</td>
        <td class="fieldValue"><form:input path="emailAddress"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="emailAddress"/></td>
      </tr>
      <tr>
        <td class="fieldKey">Telephone Number:</td>
        <td class="fieldValue"><form:input path="telephone"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="telephone"/></td>
      </tr>
      <tr>
        <td class="fieldKey">Fax Number:</td>
        <td class="fieldValue"><form:input path="fax"/>&nbsp;<form:errors path="fax"/></td>
      </tr>
    </table>

    <br />

    <div class="buttonSet">
      <span class="buttonAction"><span class="tdbLink"><button id="tdb5" type="submit">Continue</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>

      <span class="tdbLink"><a id='tdb6' href='<c:url value="/account" />'>Back</a></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>    </div>
  </div>
</div>

</form:form>

