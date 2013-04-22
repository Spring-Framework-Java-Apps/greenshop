<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>Update Address Book Entry</h1>

<form:form commandName="customersAddress" method="post">
<!--  <form name="addressbook" action="http://shadowfax/oscommerce2/address_book_process.php?edit=16" method="post" onsubmit="return check_form(addressbook);">
<input type="hidden" name="formid" value="3a4c9c90755e04ca8b4f0dc787c055fe" />-->
<div class="contentContainer">
  <div>
    <span class="inputRequirement" style="float: right;">* Required information</span>
    <h2>New Address Book Entry</h2>
  </div>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="2" cellpadding="2">

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
        <td class="fieldKey">Company Name:</td>
        <td class="fieldValue"><form:input path="company"/>&nbsp;<form:errors path="company"/></td>
      </tr>

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
        	   <c:forEach items="${allCountriesOrderByName}" var="countryOption">
        	   <c:choose>
        	   <c:when test="${countryOption.id == customersAddress.country}">   	   
        	   <option selected value="${countryOption.id}"><c:out value="${countryOption.name}"/></option>
        	   </c:when>
        	   <c:otherwise> 	
        	   <option value="${countryOption.id}"><c:out value="${countryOption.name}"/></option>
        	   </c:otherwise>
        	   </c:choose>
        	   </c:forEach>
        	</form:select>&nbsp;<span class="inputRequirement">*</span><form:errors path="country"/></td>
      </tr>

    </table>
  </div>


  <div>
    <span style="float: right;"><input type="hidden" name="action" value="update" /><input type="hidden" name="edit" value="16" /><span class="tdbLink"><button id="tdb5" type="submit">Update</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-refresh"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>

    <span class="tdbLink"><a id="tdb6" href="<c:url value="/addressBook"/>">Back</a></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>


</div>

</form:form>