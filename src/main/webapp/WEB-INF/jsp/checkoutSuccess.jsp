<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<h1>Your Order Has Been Processed!</h1>

<form name="order" action="<c:url value="/shoppingCart" />" method="get">
<div class="contentContainer">
  <div class="contentText">
    Your order has been successfully processed! Your products will arrive at their destination within 2-5 working days.  </div>

  <div class="contentText">

Please notify me of updates to the products I have selected below:<br /><p class="productsNotifications"><input type="checkbox" name="notify[]" value="8" /> A Bug's Life<br /></p>You can view your order history by going to the <a href="http://shadowfax/oscommerce2/account.php">'My Account'</a> page and by clicking on <a href="http://shadowfax/oscommerce2/account_history.php">'History'</a>.<br /><br />Please direct any questions you have to the <a href="http://shadowfax/oscommerce2/contact_us.php">store owner</a>.
  </div>

  <div class="contentText">
    <h3>Thanks for shopping with us online!</h3>
  </div>


  <div class="buttonSet">
    <span class="buttonAction"><span class="tdbLink"><button id="tdb5" type="submit">Continue</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>
  </div>
</div>

</form>
