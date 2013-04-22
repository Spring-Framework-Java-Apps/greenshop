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
  if (document.checkout_payment.payment[0]) {
    document.checkout_payment.payment[buttonSelect].checked=true;
  } else {
    document.checkout_payment.payment.checked=true;
  }
}

function rowOverEffect(object) {
  if (object.className == 'moduleRow') object.className = 'moduleRowOver';
}

function rowOutEffect(object) {
  if (object.className == 'moduleRowOver') object.className = 'moduleRow';
}
//--></script>
<script type="text/javascript"><!-- 
function check_form() {
  var error = 0;
  var error_message = "Errors have occured during the process of your form.\n\nPlease make the following corrections:\n\n";
  var payment_value = null;
  if (document.checkout_payment.payment.length) {
    for (var i=0; i<document.checkout_payment.payment.length; i++) {
      if (document.checkout_payment.payment[i].checked) {
        payment_value = document.checkout_payment.payment[i].value;
      }
    }
  } else if (document.checkout_payment.payment.checked) {
    payment_value = document.checkout_payment.payment.value;
  } else if (document.checkout_payment.payment.value) {
    payment_value = document.checkout_payment.payment.value;
  }


  if (payment_value == null) {
    error_message = error_message + "* Please select a payment method for your order.\n";
    error = 1;
  }

  if (error == 1) {
    alert(error_message);
    return false;
  } else {
    return true;
  }
}
//--></script>

<h1>Payment Information</h1>

<form name="checkout_payment" action="<c:url value="/checkout/confirmation" />" method="get" onsubmit="return check_form();"><input type="hidden" name="formid" value="ba9cd75f52b4b6bd3f9bdc27060bbb7e" />
<div class="contentContainer">


  <h2>Billing Address</h2>

  <div class="contentText">
    <div class="ui-widget infoBoxContainer" style="float: right;">
      <div class="ui-widget-header infoBoxHeading">Billing Address:</div>

      <div class="ui-widget-content infoBoxContents">
        ${checkout.paymentAddress.formattedAddress}      </div>
    </div>

    Please choose from your address book where you would like the invoice to be sent to.<br /><br /><span class="tdbLink"><a id="tdb5" href="<c:url value="/checkout/paymentAddress" />">Change Address</a></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-home"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>

  <div style="clear: both;"></div>

  <h2>Payment Method</h2>


  <div class="contentText">
    <div style="float: right;">
      <strong>Please Select</strong>    </div>

    Please select the preferred payment method to use on this order.  </div>


  <div class="contentText">


    <table border="0" width="100%" cellspacing="0" cellpadding="2">

      <tr id="defaultSelected" class="moduleRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="selectRowEffect(this, 0)">

        <td><strong>Cash on Delivery</strong></td>
        <td align="right">

<input type="radio" name="payment" value="cod" checked="checked" />
        </td>
      </tr>


    </table>


    <table border="0" width="100%" cellspacing="0" cellpadding="2">

      <tr class="moduleRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="selectRowEffect(this, 1)">

        <td><strong>PayPal (including Credit and Debit Cards)</strong></td>
        <td align="right">

<input type="radio" name="payment" value="paypal_express" />
        </td>
      </tr>


    </table>


  </div>

  <h2>Add Comments About Your Order</h2>

  <div class="contentText">
    <textarea name="comments" cols="60" rows="5"></textarea>  </div>

  <div class="contentText">
    <div style="float: left; width: 60%; padding-top: 5px; padding-left: 15%;">
      <div id="coProgressBar" style="height: 5px;"></div>

      <table border="0" width="100%" cellspacing="0" cellpadding="2">
        <tr>
          <td align="center" width="33%" class="checkoutBarFrom"><a href="http://shadowfax/oscommerce2/checkout_shipping.php" class="checkoutBarFrom">Delivery Information</a></td>
          <td align="center" width="33%" class="checkoutBarCurrent">Payment Information</td>
          <td align="center" width="33%" class="checkoutBarTo">Confirmation</td>
        </tr>
      </table>
    </div>

    <div style="float: right;"><span class="tdbLink"><button id="tdb6" type="submit">Continue</button></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></div>
  </div>
</div>

<script type="text/javascript">
$('#coProgressBar').progressbar({
  value: 66
});
</script>

</form>