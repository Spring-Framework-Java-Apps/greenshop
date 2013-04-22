<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<script type="text/javascript"><!--
var selected;

function selectRowEffect(object, buttonSelect) {
  if (!selected) {
    if (document.getElementById) {
      selected = document.getElementById('defaultSelected');
    } else {
      selected = document.all['defaultSelected'];
    }
  }

  if (selected) selected.className = 'moduleRow';
  object.className = 'moduleRowSelected';
  selected = object;

// one button is not an array
  if (document.checkout_address.address[0]) {
    document.checkout_address.address[buttonSelect].checked=true;
  } else {
    document.checkout_address.address.checked=true;
  }
}

function rowOverEffect(object) {
  if (object.className == 'moduleRow') object.className = 'moduleRowOver';
}

function rowOutEffect(object) {
  if (object.className == 'moduleRowOver') object.className = 'moduleRow';
}

function check_form_optional(form_name) {
  var form = form_name;

  var firstname = form.elements['firstname'].value;
  var lastname = form.elements['lastname'].value;
  var street_address = form.elements['street_address'].value;

  if (firstname == '' && lastname == '' && street_address == '') {
    return true;
  } else {
    return check_form(form_name);
  }
}
//--></script>
<script type="text/javascript"><!--
var form = "";
var submitted = false;
var error = false;
var error_message = "";

function check_input(field_name, field_size, message) {
  if (form.elements[field_name] && (form.elements[field_name].type != "hidden")) {
    var field_value = form.elements[field_name].value;

    if (field_value.length < field_size) {
      error_message = error_message + "* " + message + "\n";
      error = true;
    }
  }
}

function check_radio(field_name, message) {
  var isChecked = false;

  if (form.elements[field_name] && (form.elements[field_name].type != "hidden")) {
    var radio = form.elements[field_name];

    for (var i=0; i<radio.length; i++) {
      if (radio[i].checked == true) {
        isChecked = true;
        break;
      }
    }

    if (isChecked == false) {
      error_message = error_message + "* " + message + "\n";
      error = true;
    }
  }
}

function check_select(field_name, field_default, message) {
  if (form.elements[field_name] && (form.elements[field_name].type != "hidden")) {
    var field_value = form.elements[field_name].value;

    if (field_value == field_default) {
      error_message = error_message + "* " + message + "\n";
      error = true;
    }
  }
}

function check_password(field_name_1, field_name_2, field_size, message_1, message_2) {
  if (form.elements[field_name_1] && (form.elements[field_name_1].type != "hidden")) {
    var password = form.elements[field_name_1].value;
    var confirmation = form.elements[field_name_2].value;

    if (password.length < field_size) {
      error_message = error_message + "* " + message_1 + "\n";
      error = true;
    } else if (password != confirmation) {
      error_message = error_message + "* " + message_2 + "\n";
      error = true;
    }
  }
}

function check_form(form_name) {
  if (submitted == true) {
    alert("This form has already been submitted. Please press Ok and wait for this process to be completed.");
    return false;
  }

  error = false;
  form = form_name;
  error_message = "Errors have occured during the process of your form.\n\nPlease make the following corrections:\n\n";

  check_radio("gender", "Please select your Gender.");

  check_input("firstname", 2, "Your First Name must contain a minimum of 2 characters.");
  check_input("lastname", 2, "Your Last Name must contain a minimum of 2 characters.");

  check_input("dob", 10, "Your Date of Birth must be in this format: MM/DD/YYYY (eg 05/21/1970)");

  check_input("email_address", 6, "Your E-Mail Address must contain a minimum of 6 characters.");
  check_input("street_address", 5, "Your Street Address must contain a minimum of 5 characters.");
  check_input("postcode", 4, "Your Post Code must contain a minimum of 4 characters.");
  check_input("city", 3, "Your City must contain a minimum of 3 characters.");

  check_input("state", 2, "Your State must contain a minimum of 2 characters.");

  check_select("country", "", "You must select a country from the Countries pull down menu.");

  check_input("telephone", 3, "Your Telephone Number must contain a minimum of 3 characters.");

  check_password("password", "confirmation", 5, "Your Password must contain a minimum of 5 characters.", "The Password Confirmation must match your Password.");
  check_password("password_new", "password_confirmation", 5, "Your new Password must contain a minimum of 5 characters.", "The Password Confirmation must match your new Password.");

  if (error == true) {
    alert(error_message);
    return false;
  } else {
    submitted = true;
    return true;
  }
}
//--></script>

<h1>Delivery Information</h1>


<form:form commandName="newAddress" method="post">
<!-- 
<form name="checkout_address" action="<c:url value="/checkout/payment" />" method="get" onsubmit="return check_form_optional(checkout_address);">
<input type="hidden" name="formid" value="ba9cd75f52b4b6bd3f9bdc27060bbb7e" /> 
-->
<div class="contentContainer">


  <h2>Shipping Address</h2>

  <div class="contentText">
    <div class="ui-widget infoBoxContainer" style="float: right;">
      <div class="ui-widget-header infoBoxHeading">Shipping Address:</div>

      <div class="ui-widget-content infoBoxContents">
        ${checkout.shippingAddress.formattedAddress}       </div>
    </div>

    This is the currently selected shipping address where the items in this order will be delivered to.  </div>

  <div style="clear: both;"></div>

<c:if test="${fn:length(addressBook) gt 1}">
<h2>Address Book Entries</h2>

  <div class="contentText">
    <div style="float: right;">
      <strong>Please Select</strong>    </div>

    Please select the preferred shipping address if the items in this order are to be delivered elsewhere.  </div>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="0" cellpadding="2">
	  <c:forEach items="${addressBook}" var="address">
      <tr class="moduleRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="selectRowEffect(this, 0)">

        <td><strong>${address.firstname} ${address.lastname}</strong></td>
        <td align="right"><form:radiobutton path="choosenAddressId" value="${address.id}" /></td>
      </tr>
      <tr>
        <td colspan="2" style="padding-left: 15px;">${address.firstname} ${address.lastname},  ${address.streetAddress},  ${address.postcode} ${address.city},  ${address.country.name}</td>
      </tr>
      </c:forEach>
    </table>
  </div>
</c:if>
  <h2>New Shipping Address</h2>

  <div class="contentText">
    Please use the following form to create a new shipping address to use for this order.  </div>

  
  <div class="contentText">
    <table border="0" width="100%" cellspacing="0" cellpadding="2">


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
        	<form:select path="countryId">
        	   <option value="0" selected="selected">Please Select</option>
        	   <c:forEach items="${allCountriesOrderByName}" var="countryOption">
        	   <c:choose>
        	   <c:when test="${countryOption.id == newAddress.countryId}">   	   
        	   <option selected value="${countryOption.id}"><c:out value="${countryOption.name}"/></option>
        	   </c:when>
        	   <c:otherwise> 	
        	   <option value="${countryOption.id}"><c:out value="${countryOption.name}"/></option>
        	   </c:otherwise>
        	   </c:choose>
        	   </c:forEach>
        	</form:select>&nbsp;<span class="inputRequirement">*</span><form:errors path="countryId"/></td>
      </tr>
  </table>
</div>


  <div class="contentText">
    <div style="float: left; width: 60%; padding-top: 5px; padding-left: 15%;">
      <div id="coProgressBar" style="height: 5px;"></div>

      <table border="0" width="100%" cellspacing="0" cellpadding="2">
        <tr>
          <td align="center" width="33%" class="checkoutBarCurrent"><a href="http://shadowfax/oscommerce2/checkout_shipping.php" class="checkoutBarCurrent">Delivery Information</a></td>
          <td align="center" width="33%" class="checkoutBarTo">Payment Information</td>
          <td align="center" width="33%" class="checkoutBarTo">Confirmation</td>
        </tr>
      </table>
    </div>

    <div style="float: right;"><input type="hidden" name="action" value="submit" /><span class="tdbLink"><button id="tdb5" type="submit">Continue</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></div>
  </div>

<script type="text/javascript">
$('#coProgressBar').progressbar({
  value: 33
});
</script>


</div>

</form:form>