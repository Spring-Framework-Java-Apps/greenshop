<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div>
    <h1 style="float: right;">$<c:out value="${product.productDescription.product.price}"/></h1>
    <h1><c:out value="${product.productDescription.name}"/><br /><span class="smallText">[<c:out value="${product.productDescription.product.model}"/>]</span></h1>
</div>

<div class="contentContainer">


    <div style="float: right; width: 120px; text-align: center;">
        <a href="<c:url value="/product/${product.productDescription.product.id}" />">
            <img src="images/<c:out value="${product.productDescription.product.image}"/>" alt="<c:out value="${product.productDescription.name}"/>" title="<c:out value="${product.productDescription.name}"/>" width="100" height="80" hspace="5" vspace="5" />
        </a>
        <p>
            <span class="tdbLink">
                <a id="tdb4" href="<c:url value="/shoppingCart/add/${product.productDescription.product.id}"/>">Add to Cart</a>
            </span>
            <script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
        </p>
    </div>

    <c:forEach var="reviewDescription" items="${reviewDescriptions}">
    <div>
        <span style="float: right;">Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${reviewDescription.review.dateAdded}" /></span>
        <h2><a href="<c:url value="/product/review/${reviewDescription.review.id}"/>">by <c:out value="${reviewDescription.review.customersName}"/></a></h2>
    </div>

    <div class="contentText">
        <c:out value="${reviewDescription.reviewTextShort}"/><br />
        <br />
        <i>
            Rating:
            <c:choose>
                <c:when test="${reviewDescription.review.rating == 5}">
                    <img src="images/stars_5.gif" alt="5 of 5 Stars!" title="5 of 5 Stars!" width="59" height="11" /> [5 of 5 Stars!]
                </c:when>
                <c:when test="${reviewDescription.review.rating == 4}">
                    <img src="images/stars_4.gif" alt="4 of 5 Stars!" title="4 of 5 Stars!" width="59" height="11" /> [4 of 5 Stars!]
                </c:when>
                <c:when test="${reviewDescription.review.rating == 3}">
                    <img src="images/stars_3.gif" alt="3 of 5 Stars!" title="3 of 5 Stars!" width="59" height="11" /> [3 of 5 Stars!]
                </c:when>
                <c:when test="${reviewDescription.review.rating == 2}">
                    <img src="images/stars_2.gif" alt="2 of 5 Stars!" title="2 of 5 Stars!" width="59" height="11" /> [2 of 5 Stars!]
                </c:when>
                <c:when test="${reviewDescription.review.rating == 1}">
                    <img src="images/stars_1.gif" alt="1 of 5 Stars!" title="1 of 5 Stars!" width="59" height="11" /> [1 of 5 Stars!]
                </c:when>
            </c:choose>
        </i>
    </div>
    </c:forEach>

    <div class="contentText">
        <p style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;</p>

        <p>Displaying <strong>1</strong> to <strong>2</strong> (of <strong>2</strong> reviews)</p>
    </div>


    <br />

    <div class="buttonSet">
        <span class="buttonAction">
            <span class="tdbLink">
                <a id="tdb5" href="<c:url value="/review/write/product/${product.productDescription.product.id}"/>">Write Review</a>
            </span>
            <script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-comment"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script>
        </span>

        <span class="tdbLink">
            <a id="tdb6" href="<c:url value="/product/${product.productDescription.product.id}" />">Back</a>
        </span>
        <script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
    </div>
</div>