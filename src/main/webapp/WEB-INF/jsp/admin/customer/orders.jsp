<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Orders</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="1" height="40" /></td>
                <td align="right"><table border="0" width="100%" cellspacing="0" cellpadding="0">
                    <tr>
                        <form name="orders" action="http://localhost/oscommerce2/admin/orders.php" method="get">
                        <td class="smallText" align="right">Order ID: <input type="text" name="oID" size="12" /><input type="hidden" name="action" value="edit" />
                        </td>
                        </form>
                    </tr>
                    <tr>
                        <form name="status" action="http://localhost/oscommerce2/admin/orders.php" method="get">
                        <td class="smallText" align="right">Status: <select name="status" onchange="this.form.submit();">
                            <option value="" selected="selected">All Orders</option>
                            <option value="3">Delivered</option>
                            <option value="4">PayPal [Transactions]</option>
                            <option value="1">Pending</option><option value="2">Processing</option>
                        </select>
                        </td>
                    </form>
                    </tr>
                </table></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Customers</td>
                        <td class="dataTableHeadingContent" align="right">Order Total</td>
                        <td class="dataTableHeadingContent" align="center">Date Purchased</td>
                        <td class="dataTableHeadingContent" align="right">Status</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:forEach var="order" items="${orders}">
                    <c:if test="${order.orderId == thisOrder.orderId}">
                        <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=edit'">
                            <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;${order.customerName}</td>
                            <td class="dataTableContent" align="right">$<fmt:formatNumber
                                    value="${order.orderTotal}"
                                    minFractionDigits="2" maxFractionDigits="2" /></td>
                            <td class="dataTableContent" align="center"><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${order.orderPlaced}" /></td>
                            <td class="dataTableContent" align="right">${order.orderStatus.ordersStatusName}</td>
                            <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                        </tr>
                    </c:if>
                    <c:if test="${order.orderId != thisOrder.orderId}">
                        <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/orders/${order.orderId}"/>'">
                            <td class="dataTableContent"><a href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=9&action=edit"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;${order.customerName}</td>
                            <td class="dataTableContent" align="right">$<fmt:formatNumber
                                    value="${order.orderTotal}"
                                    minFractionDigits="2" maxFractionDigits="2" /></td>
                            <td class="dataTableContent" align="center"><fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${order.orderPlaced}" /></td>
                            <td class="dataTableContent" align="right">${order.orderStatus.ordersStatusName}</td>
                            <td class="dataTableContent" align="right"><a href="<c:url value="/admin/orders/${order.orderId}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                        </tr>
                    </c:if>
                    </c:forEach>
                    <tr>
                        <td colspan="5"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>10</strong> (of <strong>10</strong> orders)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>[${thisOrder.orderId}]&nbsp;&nbsp;<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${thisOrder.orderPlaced}" /></strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb1" href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=edit">Edit</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/orders.php?page=1&oID=10&action=delete">Delete</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb3" href="http://localhost/oscommerce2/admin/invoice.php?oID=10" target="_blank">Invoice</a></span><script type="text/javascript">$("#tdb3").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb4" href="http://localhost/oscommerce2/admin/packingslip.php?oID=10" target="_blank">Packing Slip</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Created: <fmt:formatDate pattern="MM/dd/yyyy" value="${thisOrder.orderPlaced}" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Payment Method: ${thisOrder.paymentMethod}</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>