<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>Product Notifications</h1>

<!--
<form name="account_notifications" action="http://localhost/oscommerce2/account_notifications.php" method="post"><input type="hidden" name="formid" value="0923a4ea590b42438f4ff4a9af74d302" />
<input type="hidden" name="action" value="process" />
-->
<form:form commandName="customerInfo" method="post">
<div class="contentContainer">
  <h2>My Product Notifications</h2>

  <div class="contentText">
    The product notification list allows you to stay up to date on products you find of interest.<br /><br />To be up to date on all product changes, select <strong>Global Product Notifications</strong>.  </div>

  <h2>Global Product Notifications</h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="0" cellpadding="2">
      <tr>
        <td width="30">
          <!-- <input type="checkbox" name="product_global" value="1" onclick="checkBox('product_global')" /> -->
          <form:checkbox path="globalProductNotifications"/>
        </td>
        <td><strong>Global Product Notifications</strong><br />Recieve notifications on all available products.</td>
      </tr>
    </table>
  </div>


  <h2>Product Notifications</h2>

  <div class="contentText">

    <div>To remove a product notification, clear the products checkbox and click on Continue.</div>

    <table border="0" width="100%" cellspacing="0" cellpadding="2">

      <c:forEach var="productNotification" items="${productNotifications}">
      <tr>
        <td width="30"><input type="checkbox" name="products[${productNotification.id.productId}]" value="1" checked="checked" onclick="checkBox('products[${productNotification.id.productId}]')" /></td>
        <td><strong>Matrox G200 MMS ${productNotification.id.productId}</strong></td>
      </tr>
      </c:forEach>

    </table>


  </div>


  <div class="buttonSet">
    <span class="buttonAction"><span class="tdbLink"><button id="tdb5" type="submit">Continue</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>

    <span class="tdbLink"><a id="tdb6" href='<c:url value="/account" />'>Back</a></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>
</div>

</form:form>