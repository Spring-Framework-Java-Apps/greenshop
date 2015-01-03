<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Reviews</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                    <tr class="dataTableHeadingRow">
                        <td class="dataTableHeadingContent">Products</td>
                        <td class="dataTableHeadingContent" align="right">Rating</td>
                        <td class="dataTableHeadingContent" align="right">Date Added</td>
                        <td class="dataTableHeadingContent" align="center">Status</td>
                        <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                    </tr>
                    <c:forEach var="review" items="${reviews}">
                    <c:if test="${review.review.review.id == thisReview.review.review.id}">
                    <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/reviews/${review.review.review.id}"/>'">
                    </c:if>
                    <c:if test="${review.review.review.id != thisReview.review.review.id}">
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/reviews/${review.review.review.id}"/>'">
                    </c:if>
                        <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/reviews.php?page=1&rID=2&action=preview&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;${review.product.name}</td>
                        <td class="dataTableContent" align="right">
                            <c:choose>
                                <c:when test="${review.review.review.rating == 5}">
                                    <img src="resources/images/stars_5.gif" border="0" alt="" />
                                </c:when>
                                <c:when test="${review.review.review.rating == 4}">
                                    <img src="resources/images/stars_4.gif" border="0" alt="" />
                                </c:when>
                                <c:when test="${review.review.review.rating == 3}">
                                    <img src="resources/images/stars_3.gif" border="0" alt="" />
                                </c:when>
                                <c:when test="${review.review.review.rating == 2}">
                                    <img src="resources/images/stars_2.gif" border="0" alt="" />
                                </c:when>
                                <c:when test="${review.review.review.rating == 1}">
                                    <img src="resources/images/stars_1.gif" border="0" alt="" />
                                </c:when>
                            </c:choose>
                        </td>
                        <td class="dataTableContent" align="right"><fmt:formatDate pattern="MM/dd/yyyy" value="${review.review.review.dateAdded}" /></td>
                        <td class="dataTableContent" align="center">
                            <img src="resources/admin/images/icon_status_green.gif" border="0" alt="Active" title="Active" width="10" height="10" />&nbsp;&nbsp;<a href="http://shadowfax/oscommerce2/admin/reviews.php?action=setflag&flag=0&rID=2&page=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icon_status_red_light.gif" border="0" alt="Set Inactive" title="Set Inactive" width="10" height="10" /></a></td>
                        <td class="dataTableContent" align="right">
                        <c:if test="${review.review.review.id == thisReview.review.review.id}"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" /></c:if>
                        <c:if test="${review.review.review.id != thisReview.review.review.id}"><a href="<c:url value="/admin/reviews/${review.review.review.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a></c:if>&nbsp;</td>
                    </tr>
                    </c:forEach>
                    <!--
                    <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='http://shadowfax/oscommerce2/admin/reviews.php?page=1&rID=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1'">
                        <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/reviews.php?page=1&rID=1&action=preview&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icons/preview.gif" border="0" alt="Preview" title="Preview" /></a>&nbsp;There's Something About Mary</td>
                        <td class="dataTableContent" align="right"><img src="http://shadowfax/oscommerce2/images/stars_5.gif" border="0" alt="" /></td>
                        <td class="dataTableContent" align="right">12/27/2014</td>
                        <td class="dataTableContent" align="center">
                            <img src="resources/admin/images/icon_status_green.gif" border="0" alt="Active" title="Active" width="10" height="10" />&nbsp;&nbsp;<a href="http://shadowfax/oscommerce2/admin/reviews.php?action=setflag&flag=0&rID=1&page=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icon_status_red_light.gif" border="0" alt="Set Inactive" title="Set Inactive" width="10" height="10" /></a></td>
                        <td class="dataTableContent" align="right"><a href="http://shadowfax/oscommerce2/admin/reviews.php?page=1&rID=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                    </tr>
                    -->
                    <tr>
                        <td colspan="4"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>2</strong> (of <strong>2</strong> product reviews)</td>
                                <td class="smallText" align="right">Page 1 of 1</td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>${thisReview.product.name}</strong></td>
                        </tr>
                    </table>
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr>
                            <td align="center" class="infoBoxContent"><span class="tdbLink"><a id="tdb1" href="http://shadowfax/oscommerce2/admin/reviews.php?page=1&rID=2&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Edit</a></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://shadowfax/oscommerce2/admin/reviews.php?page=1&rID=2&action=delete&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Delete</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Date Added: 12/30/2014</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br /><img src="resources/images/${thisReview.product.product.image}" border="0" alt="${thisReview.product.name}" title="${thisReview.product.name}" width="100" height="80" /></td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Author: ${thisReview.review.review.customersName}</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Rating:
                                <c:choose>
                                    <c:when test="${thisReview.review.review.rating == 5}">
                                        <img src="resources/images/stars_5.gif" border="0" alt="" />
                                    </c:when>
                                    <c:when test="${thisReview.review.review.rating == 4}">
                                        <img src="resources/images/stars_4.gif" border="0" alt="" />
                                    </c:when>
                                    <c:when test="${thisReview.review.review.rating == 3}">
                                        <img src="resources/images/stars_3.gif" border="0" alt="" />
                                    </c:when>
                                    <c:when test="${thisReview.review.review.rating == 2}">
                                        <img src="resources/images/stars_2.gif" border="0" alt="" />
                                    </c:when>
                                    <c:when test="${thisReview.review.review.rating == 1}">
                                        <img src="resources/images/stars_1.gif" border="0" alt="" />
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent">Read: ${thisReview.review.review.reviewsRead}</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Size: ${thisReview.review.reviewText.length()} bytes</td>
                        </tr>
                        <tr>
                            <td class="infoBoxContent"><br />Average Rating: <c:choose>
                                <c:when test="${averageRating == 5}">100</c:when>
                                <c:when test="${averageRating == 4}">80</c:when>
                                <c:when test="${averageRating == 3}">60</c:when>
                                <c:when test="${averageRating == 2}">40</c:when>
                                <c:when test="${averageRating == 1}">20</c:when>
                            </c:choose>%</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table></td>
    </tr>
</table>