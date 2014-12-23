<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading"><a href="http://localhost/oscommerce2/account_notifications.php">Notifications</a></div>
    <table border="0" cellspacing="0" cellpadding="2" class="ui-widget-content infoBoxContents">
        <tr>
            <td>
                <a href="<c:url value="/account/addProductNotification/${product.product.id}"/>"/>
                    <img src="images/box_products_notifications.gif" alt="Notifications" title="Notifications" width="50" height="50" />
                </a>
            </td>
            <td>
                <a href="<c:url value="/account/addProductNotification/${product.product.id}"/>">Notify me of updates to <strong>${product.name}</strong></a>
            </td>
        </tr>
    </table>
</div>