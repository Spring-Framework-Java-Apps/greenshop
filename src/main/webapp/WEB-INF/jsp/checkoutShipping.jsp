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
  if (document.checkout_address.shipping[0]) {
    document.checkout_address.shipping[buttonSelect].checked=true;
  } else {
    document.checkout_address.shipping.checked=true;
  }
}

function rowOverEffect(object) {
  if (object.className == 'moduleRow') object.className = 'moduleRowOver';
}

function rowOutEffect(object) {
  if (object.className == 'moduleRowOver') object.className = 'moduleRow';
}
//--></script>

<h1>Delivery Information</h1>

<form name="checkout_address" action="<c:url value="/checkout/payment" />" method="get"><input type="hidden" name="formid" value="ba9cd75f52b4b6bd3f9bdc27060bbb7e" /><input type="hidden" name="action" value="process" />
<div class="contentContainer">
  <h2>Shipping Address</h2>

  <div class="contentText">
    <div class="ui-widget infoBoxContainer" style="float: right;">
      <div class="ui-widget-header infoBoxHeading">Shipping Address:</div>

      <div class="ui-widget-content infoBoxContents">
      ${checkout.shippingAddress.formattedAddress}      </div>
    </div>

    Please choose from your address book where you would like the items to be delivered to.<br /><br /><span class="tdbLink"><a id="tdb5" href="<c:url value="/checkout/shippingAddress" />">Change Address</a></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-home"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>

  <div style="clear: both;"></div>


  <h2>Shipping Method</h2>


  <div class="contentText">
    This is currently the only shipping method available to use on this order.  </div>


  <div class="contentText">
    <table border="0" width="100%" cellspacing="0" cellpadding="2">


      <tr>
        <td colspan="3"><strong>Flat Rate</strong>&nbsp;</td>
      </tr>

      <tr id="defaultSelected" class="moduleRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="selectRowEffect(this, 0)">

        <td width="75%" style="padding-left: 15px;">Best Way</td>


        <td align="right" colspan="2">$5.00<input type="hidden" name="shipping" value="flat_flat" /></td>


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
          <td align="center" width="33%" class="checkoutBarCurrent">Delivery Information</td>
          <td align="center" width="33%" class="checkoutBarTo">Payment Information</td>
          <td align="center" width="33%" class="checkoutBarTo">Confirmation</td>
        </tr>
      </table>
    </div>

    <div style="float: right;"><span class="tdbLink"><button id="tdb6" type="submit">Continue</button></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></div>
  </div>
</div>

<script type="text/javascript">
$('#coProgressBar').progressbar({
  value: 33
});
</script>

</form>
