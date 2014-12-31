<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>Read What Others Are Saying</h1>

<div class="contentContainer">


    <c:forEach var="review" items="${reviews}">
    <div>
        <span style="float: right;">Date Added: <fmt:formatDate pattern="MM/dd/yyyy" value="${review.review.review.dateAdded}" /></span>
        <h2><a href="<c:url value="/product/review/${review.review.review.id}"/>">
            <c:out value="${review.product.name}"/>
        </a><span class="smallText">by <c:out value="${review.review.review.customersName}"/></span></h2>
    </div>

    <div class="contentText">
        <table border="0" width="100%" cellspacing="0" cellpadding="2">
            <tr>
                <td width="110" align="center" valign="top" class="main">
                    <a href="<c:url value="/product/review/${review.review.review.id}"/>">
                        <img src="images/${review.review.review.product.image}"
                             alt="${review.product.name}"
                             title="${review.product.name}"
                             width="100" height="80" />
                    </a>
                </td>
                <td valign="top"><c:out value="${review.review.reviewTextShort}"/><br />
                    <br />
                    <i>
                        Rating:
                        <c:choose>
                            <c:when test="${review.review.review.rating == 5}">
                                <img src="images/stars_5.gif" alt="5 of 5 Stars!" title="5 of 5 Stars!" width="59" height="11" /> [5 of 5 Stars!]
                            </c:when>
                            <c:when test="${review.review.review.rating == 4}">
                                <img src="images/stars_4.gif" alt="4 of 5 Stars!" title="4 of 5 Stars!" width="59" height="11" /> [4 of 5 Stars!]
                            </c:when>
                            <c:when test="${review.review.review.rating == 3}">
                                <img src="images/stars_3.gif" alt="3 of 5 Stars!" title="3 of 5 Stars!" width="59" height="11" /> [3 of 5 Stars!]
                            </c:when>
                            <c:when test="${review.review.review.rating == 2}">
                                <img src="images/stars_2.gif" alt="2 of 5 Stars!" title="2 of 5 Stars!" width="59" height="11" /> [2 of 5 Stars!]
                            </c:when>
                            <c:when test="${review.review.review.rating == 1}">
                                <img src="images/stars_1.gif" alt="1 of 5 Stars!" title="1 of 5 Stars!" width="59" height="11" /> [1 of 5 Stars!]
                            </c:when>
                        </c:choose>
                    </i>
                </td>
            </tr>
        </table>
    </div>
    </c:forEach>

    <br />

    <div class="contentText">
        <p style="float: right;">Result Pages: &nbsp;<strong>1</strong>&nbsp;</p>

        <p>Displaying <strong>1</strong> to <strong>2</strong> (of <strong>2</strong> reviews)</p>
    </div>


</div>