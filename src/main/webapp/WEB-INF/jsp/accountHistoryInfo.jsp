<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>Order Information</h1>

<div class="contentContainer">
  <h2>Order #1 <span class="contentText">(${orderHistoryDetailsBean.orderStatus.ordersStatusName})</span></h2>

  <div class="contentText">
    <div>
      <span style="float: right;">Order Total: $304.99</span>
      Order Date: Monday 28 January, 2013    </div>

    <table border="0" width="100%" cellspacing="1" cellpadding="2">
      <tr>

        <td width="30%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td><strong>Delivery Address</strong></td>
          </tr>
          <tr>
            <td>${orderHistoryDetailsBean.order.formattedDeliveryAddress} </td>
          </tr>
          <tr>
            <td><strong>Shipping Method</strong></td>
          </tr>
          <tr>
            <td>Flat Rate (Best Way)</td>
          </tr>
        </table></td>
        <td width="70%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td colspan="2"><strong>Products</strong></td>
            <td align="right"><strong>Total</strong></td>
          </tr>
          <tr>
            <td align="right" valign="top" width="30">1&nbsp;x&nbsp;</td>
            <td valign="top">Matrox G200 MMS<br /><nobr><small>&nbsp;<i> - Memory: 4 mb</i></small></nobr><br /><nobr><small>&nbsp;<i> - Model: Value</i></small></nobr></td>
            <td align="right" valign="top">$299.99</td>
          </tr>
        </table></td>
      </tr>
    </table>
  </div>

  <h2>Billing Information</h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="1" cellpadding="2">
      <tr>
        <td width="30%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td><strong>Billing Address</strong></td>
          </tr>
          <tr>
            <td>${orderHistoryDetailsBean.order.formattedBillingAddress}</td>
          </tr>
          <tr>
            <td><strong>Payment Method</strong></td>
          </tr>
          <tr>
            <td>${orderHistoryDetailsBean.order.paymentMethod}</td>
          </tr>
        </table></td>
        <td width="70%" valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td align="right" width="100%">Sub-Total:</td>
            <td align="right">$299.99</td>
          </tr>
          <tr>
            <td align="right" width="100%">Flat Rate (Best Way):</td>
            <td align="right">$5.00</td>
          </tr>
          <tr>
            <td align="right" width="100%">Total:</td>
            <td align="right"><strong>$304.99</strong></td>
          </tr>
        </table></td>
      </tr>
    </table>
  </div>

  <h2>Order History</h2>

  <div class="contentText">
    <table border="0" width="100%" cellspacing="1" cellpadding="2">
      <tr>
        <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
          <tr>
            <td valign="top" width="70">01/28/2013</td>
            <td valign="top" width="70">Pending</td>
            <td valign="top">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
  </div>


  <div class="buttonSet">
    <span class="tdbLink"><a id="tdb5" href='<c:url value="/accountHistory" />'>Back</a></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>
</div>