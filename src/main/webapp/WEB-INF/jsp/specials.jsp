<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<h1>Get Them While They're Hot!</h1>

<div class="contentContainer">
    <div class="contentText">


        <table border="0" width="100%" cellspacing="0" cellpadding="2">
            <tr>
            <c:forEach items="${specialProducts}" var="specialProduct" varStatus="status">
                <td align="center" width="33%">
                    <a href="<c:url value="/product/${specialProduct.productDescription.product.id}" />">
                        <img src="images/${specialProduct.productDescription.product.image}"
                             alt="${specialProduct.productDescription.name}"
                             title="${specialProduct.productDescription.name}"
                             width="100" height="80" />
                    </a>
                    <br />
                    <a href="<c:url value="/product/${specialProduct.productDescription.product.id}" />">
                        <c:out value="${specialProduct.productDescription.name}"/>
                    </a>
                    <br />
                    <del>$<fmt:formatNumber
                            value="${specialProduct.special.newPrice}"
                            minFractionDigits="2" maxFractionDigits="2" /></del>
                    <br />
                    <span class="productSpecialPrice">$<fmt:formatNumber
                            value="${specialProduct.productDescription.product.price}"
                            minFractionDigits="2" maxFractionDigits="2" /></span>
                </td>
                <c:if test="${status.index % 3 == 2}">
                    </tr><tr>
                </c:if>
            </c:forEach>
            </tr>
        </table>


        <br />

        <div>
            <span style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;</span>

            <span>Displaying <strong>1</strong> to <strong>4</strong> (of <strong>4</strong> specials)</span>
        </div>


    </div>
</div>
