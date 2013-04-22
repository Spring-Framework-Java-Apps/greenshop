<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>My Account Information</h1>


<p><font color="#FF0000"><small><strong>NOTE:</strong></small></font> If you already have an account with us, please login at the <a href='<c:url value="/login"/>'><u>login page</u></a>.</p>

<form:form commandName="createNewCustomerFormBean" method="post">
<!-- 
<input type="hidden" name="formid" value="1e6b0d45174da800bad4fea9bafd1603" />
<input type="hidden" name="action" value="process" />
-->
<div class="contentContainer">
  <div>
    <span class="inputRequirement" style="float: right;">* Required information</span>
    <h2>Your Personal Details</h2>
  </div>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2" width="100%">

      <tr>
        <td class="fieldKey">Gender:</td>
        <td class="fieldValue"><form:radiobutton path="gender" value="m" />&nbsp;&nbsp;Male&nbsp;&nbsp;<form:radiobutton path="gender" value="f" />&nbsp;&nbsp;Female&nbsp;<span class="inputRequirement">*</span><form:errors path="gender"/></td>
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
        <td class="fieldValue"><form:input path="dob"/>&nbsp;<span class="inputRequirement">* (eg. 05/21/1970)</span><script type="text/javascript">$('#dob').datepicker({dateFormat: 'mm/dd/yy', changeMonth: true, changeYear: true, yearRange: '-100:+0'});</script><form:errors path="dob"/></td>
      </tr>


      <tr>
        <td class="fieldKey">E-Mail Address:</td>
        <td class="fieldValue"><form:input path="emailAddress"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="emailAddress"/></td>
      </tr>
    </table>
  </div>


  <h2>Company Details</h2>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2" width="100%">
      <tr>
        <td class="fieldKey">Company Name:</td>
        <td class="fieldValue"><form:input path="company"/>&nbsp;<form:errors path="company"/></td>
      </tr>
    </table>
  </div>


  <h2>Your Address</h2>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2" width="100%">
      <tr>
        <td class="fieldKey">Street Address:</td>
        <td class="fieldValue"><form:input path="streetAddress"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="streetAddress"/></td>
      </tr>


      <tr>
        <td class="fieldKey">Suburb:</td>
        <td class="fieldValue"><form:input path="suburb"/>&nbsp;<form:errors path="suburb"/></td>
      </tr>


      <tr>
        <td class="fieldKey">Post Code:</td>
        <td class="fieldValue"><form:input path="postcode"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="postcode"/></td>
      </tr>
      <tr>
        <td class="fieldKey">City:</td>
        <td class="fieldValue"><form:input path="city"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="city"/></td>
      </tr>


      <tr>
        <td class="fieldKey">State/Province:</td>
        <td class="fieldValue">
		<form:input path="state"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="state"/>        </td>
      </tr>


      <tr>
        <td class="fieldKey">Country:</td>
        <td class="fieldValue">
        	<form:select path="country">
        	   <option value="0" selected="selected">Please Select</option>
        	   <c:forEach items="${allCountriesOrderByName}" var="country">
        	   <option value="${country.id}"><c:out value="${country.name}"/></option>
        	   </c:forEach>
        	</form:select>&nbsp;<span class="inputRequirement">*</span><form:errors path="country"/></td>
      </tr>
    </table>
  </div>

  <h2>Your Contact Information</h2>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2" width="100%">
      <tr>
        <td class="fieldKey">Telephone Number:</td>
        <td class="fieldValue"><form:input path="telephone"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="telephone"/></td>
      </tr>
      <tr>
        <td class="fieldKey">Fax Number:</td>
        <td class="fieldValue"><form:input path="fax"/>&nbsp;<form:errors path="fax"/></td>
      </tr>
      <tr>
        <td class="fieldKey">Newsletter:</td>
        <td class="fieldValue"><form:checkbox path="newsletter" value="true" />&nbsp;<form:errors path="newsletter"/></td>
      </tr>
    </table>
  </div>

  <h2>Your Password</h2>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2" width="100%">
      <tr>
        <td class="fieldKey">Password:</td>
        <td class="fieldValue"><form:password path="password" maxlength="40"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="password"/></td>
      </tr>
      <tr>
        <td class="fieldKey">Password Confirmation:</td>
        <td class="fieldValue"><form:password path="confirmation" maxlength="40"/>&nbsp;<span class="inputRequirement">*</span><form:errors path="confirmation"/></td>
      </tr>
    </table>
  </div>

  <div class="buttonSet">
    <span class="buttonAction"><span class="tdbLink"><button id="tdb4" type="submit">Continue</button></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-person"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>
  </div>
</div>

</form:form>