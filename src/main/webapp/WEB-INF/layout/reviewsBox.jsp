<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">
        <a href="http://shadowfax/oscommerce2/reviews.php">Reviews</a>
    </div>
    <div class="ui-widget-content infoBoxContents">
        <div align="center">
            <a href="<c:url value="/product/review/${randomReview.review.id}"/>">
                <img src="images/${randomReview.review.product.image}" alt="${randomReview.review.product.image}" title=" ${randomReview.review.product.image} " width="100" height="80" />
            </a>
        </div>
        <a href="<c:url value="/product/review/${randomReview.review.id}"/>">
            <c:out value="${randomReview.reviewTextShort}"/>
        </a>
        <br />
        <div align="center">
            <c:choose>
                <c:when test="${randomReview.review.rating == 5}">
                    <img src="images/stars_5.gif" alt="5 of 5 Stars!" title="5 of 5 Stars!" width="59" height="11" /> [5 of 5 Stars!]
                </c:when>
                <c:when test="${randomReview.review.rating == 4}">
                    <img src="images/stars_4.gif" alt="4 of 5 Stars!" title="4 of 5 Stars!" width="59" height="11" /> [4 of 5 Stars!]
                </c:when>
                <c:when test="${randomReview.review.rating == 3}">
                    <img src="images/stars_3.gif" alt="3 of 5 Stars!" title="3 of 5 Stars!" width="59" height="11" /> [3 of 5 Stars!]
                </c:when>
                <c:when test="${randomReview.review.rating == 2}">
                    <img src="images/stars_2.gif" alt="2 of 5 Stars!" title="2 of 5 Stars!" width="59" height="11" /> [2 of 5 Stars!]
                </c:when>
                <c:when test="${randomReview.review.rating == 1}">
                    <img src="images/stars_1.gif" alt="1 of 5 Stars!" title="1 of 5 Stars!" width="59" height="11" /> [1 of 5 Stars!]
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
