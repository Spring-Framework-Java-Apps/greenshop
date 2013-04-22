<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>My Order History</h1>

<div class="contentContainer">


<c:forEach items="${orders}" var="order" varStatus="status">
  <c:set var="myindex" value="${status.index}" />
  <h2>Order Number: ${status.index+1} <span class="contentText">(${order.status})</span></h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="2" cellpadding="2">
      <tr>
        <td width="50%" valign="top"><strong>Order Date:</strong> <fmt:formatDate value="${order.date}" type="date" dateStyle="long"/><br /><strong>Shipped To:</strong> ${order.shippedTo}</td>
        <td width="30%" valign="top"><strong>Products:</strong> ${order.quantityOfProducts}<br /><strong>Order Cost:</strong> $<fmt:formatNumber value="${order.cost}" minFractionDigits="2" maxFractionDigits="2" /></td>
        <td width="20%" align="right"><span class="tdbLink"><a id="tdb${status.index+5}" href="<c:url value="/accountHistoryInfo/${order.orderId}"/>">View</a></span><script type="text/javascript">$("#tdb${status.index+5}").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></td>
     </tr>
    </table>
  </div>
</c:forEach>

  <div class="contentText">
    <p style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;</p>

    <p>Displaying <strong>1</strong> to <strong>1</strong> (of <strong>1</strong> orders)</p>
  </div>


  <div class="buttonSet">
    <span class="tdbLink"><a id="tdb${myindex+6}" href='<c:url value="/account" />'>Back</a></span><script type="text/javascript">$("#tdb${myindex+6}").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>
</div>