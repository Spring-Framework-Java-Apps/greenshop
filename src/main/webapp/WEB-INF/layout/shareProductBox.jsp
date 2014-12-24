<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">
    <div class="ui-widget-header infoBoxHeading">Share Product</div>
    <div class="ui-widget-content infoBoxContents" style="text-align: center;">
        <a href="http://localhost/oscommerce2/tell_a_friend.php?products_id=6">
            <img src="images/social_bookmarks/email.png" border="0" title="Share via E-Mail" alt="Share via E-Mail" />
        </a>
        <a href="http://www.facebook.com/share.php?u=${shareProductBean.productUrl}" target="_blank">
            <img src="images/social_bookmarks/facebook.png" border="0" title="Share on Facebook" alt="Share on Facebook" />
        </a>
        <div class="g-plus" data-action="share" data-href="<c:url value="/product/${product.product.id}"/>" data-annotation="none" data-height="15" data-align="left">

        </div>
        <script type="text/javascript">
    (function() {
        var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
        po.src = 'https://apis.google.com/js/plusone.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
    })();
</script>
    <a href="http://pinterest.com/pin/create/button/?description=${shareProductBean.productName}&media=${shareProductBean.productImageUrl}&url=${shareProductBean.productUrl}" class="pin-it-button" count-layout="none">
        <img border="0" src="//assets.pinterest.com/images/PinExt.png" title="Pin It" />
    </a>
        <a href="http://twitter.com/home?status=${shareProductBean.productUrl}" target="_blank">
            <img src="images/social_bookmarks/twitter.png" border="0" title="Share on Twitter" alt="Share on Twitter" />
        </a>
    </div>
</div>