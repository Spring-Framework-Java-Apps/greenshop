<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading"><a href="http://localhost/oscommerce2/reviews.php">Reviews</a></div>
    <table border="0" cellspacing="0" cellpadding="2" class="ui-widget-content infoBoxContents">
        <tr>
            <td><a href="http://localhost/oscommerce2/product_reviews_write.php?products_id=28">
                <img src="images/box_write_review.gif" alt="Write Review" title="Write Review" width="50" height="50" />
            </a>
            </td>
            <td>
                <a href="<c:url value="/review/write/product/${product.product.id}"/>">Write a review on this product!</a>
            </td>
        </tr>
    </table>
</div>
