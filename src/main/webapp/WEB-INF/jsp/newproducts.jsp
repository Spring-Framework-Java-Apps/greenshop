<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>New Products</h1>

<div class="contentContainer">
    <div class="contentText">

        <table border="0" width="100%" cellspacing="2" cellpadding="2">
            <c:forEach var="newProduct" items="${newProducts}" varStatus="status">
            <tr>
                <td width="110" valign="top" class="main">
                    <a href="<c:url value="/product/${newProduct.productDescription.product.id}" />">
                        <img src="images/${newProduct.productDescription.product.image}"
                             alt="${newProduct.productDescription.name}"
                             title="${newProduct.productDescription.name}"
                             width="100" height="80" />
                    </a>
                </td>
                <td valign="top" class="main">
                    <a href="<c:url value="/product/${newProduct.productDescription.product.id}" />">
                        <strong><u><c:out value="${newProduct.productDescription.name}"/></u></strong>
                    </a>
                    <br />Date Added: <fmt:formatDate pattern="MM/dd/yyyy"
                                                      value="${newProduct.productDescription.product.dateAdded}" />
                    <br />Manufacturer: <c:out value="${newProduct.productDescription.product.manufacturer.name}"/>
                    <br />
                    <br />
                    Price: <c:if test="${! newProduct.specialProduct}">
                    $<fmt:formatNumber
                        value="${newProduct.productDescription.product.price}"
                        minFractionDigits="2" maxFractionDigits="2" />
                    </c:if>
                    <c:if test="${newProduct.specialProduct}">
                        <del>$<fmt:formatNumber
                                value="${newProduct.productDescription.product.price}"
                                minFractionDigits="2" maxFractionDigits="2" /></del>
				        <span class="productSpecialPrice">$<fmt:formatNumber
                            value="${newProduct.special.newPrice}"
                            minFractionDigits="2" maxFractionDigits="2" /></span>
                    </c:if>
                </td>
                <td align="right" valign="middle" class="smallText">
                    <span class="tdbLink">
                        <a id="tdb${status.index + 4}"
                           href="<c:url value="/shoppingCart/add/${newProduct.productDescription.product.id}" />">
                            Add to Cart
                        </a>
                    </span>
                    <script type="text/javascript">$("#tdb${status.index + 4}").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
                </td>
            </tr>
            </c:forEach>
        </table>

        <br />

        <div>
            <span style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;&nbsp;<a href="http://shadowfax/oscommerce2/products_new.php?page=2" class="pageResults" title=" Page 2 "><u>2</u></a>&nbsp;&nbsp;<a href="http://shadowfax/oscommerce2/products_new.php?page=3" class="pageResults" title=" Page 3 "><u>3</u></a>&nbsp;&nbsp;<a href="http://shadowfax/oscommerce2/products_new.php?page=2" class="pageResults" title=" Next Page "><u>[Next&nbsp;&gt;&gt;]</u></a>&nbsp;</span>

            <span>Displaying <strong>1</strong> to <strong>10</strong> (of <strong>28</strong> new products)</span>
        </div>


    </div>
</div>
