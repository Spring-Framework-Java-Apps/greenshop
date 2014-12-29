<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">Manufacturer Info</div>
    <table border="0" width="100%" cellspacing="0" cellpadding="0" class="ui-widget-content infoBoxContents">
        <tr>
            <td align="center" colspan="2">
                <img src="images/${product.productDescription.product.manufacturer.image}" alt="Warner" title="Warner" width="100" height="57" />
            </td>
        </tr>
        <tr>
            <td valign="top">-&nbsp;</td>
            <td valign="top">
                <a href="<c:url value="/manufacturer/redirect/${product.productDescription.product.manufacturer.id}"/>" target="_blank">${product.productDescription.product.manufacturer.name} Homepage</a>
            </td>
        </tr>
        <tr>
            <td valign="top">-&nbsp;</td>
            <td valign="top">
                <a href="<c:url value="/manufacturer/${product.productDescription.product.manufacturer.id}"/>">Other products</a>
            </td>
        </tr>
    </table>
</div>
