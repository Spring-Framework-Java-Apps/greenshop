<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<!--  <form name="cart_quantity" action="http://shadowfax/oscommerce2/product_info.php?cPath=2_19&amp;products_id=22&amp;action=add_product" method="post">-->
<form action='<c:url value="/shoppingCart/add/${product.product.id}"/>' method="get">
<div>
  <h1 style="float: right;">$<c:out value="${product.product.price}"/></h1>
  <h1><c:out value="${product.name}"/><br /><span class="smallText">[<c:out value="${product.product.model}"/>]</span></h1>
</div>

<div class="contentContainer">
  <div class="contentText">


    <div id="piGal" style="float: right;">
      <a href='images/<c:out value="${product.product.image}"/>' target='_blank' rel='fancybox'>
          <img src='images/<c:out value="${product.product.image}"/>' alt='<c:out value="${product.name}"/>' title=' <c:out value="${product.name}"/> ' width="100" height="80" hspace="5" vspace="5" />
      </a>
    </div>


<script type="text/javascript">
$("#piGal a[rel^='fancybox']").fancybox({
  cyclic: true
});
</script>


${product.description}

    <p>Available Options:</p>
	<c:forEach items="${productAttributes.mapProductOptionAttribute}" var="productAttribute" varStatus="status">
    <p>
      <strong>${productAttribute.key.name}:</strong><br />
      <select name="id_${productAttribute.key.id}">
      	<c:forEach items="${productAttribute.value}" var="productAttributeValue">
      	<option value="${productAttributeValue.productOptionValue.id}">${productAttributeValue.optionValue}</option>
      	 </c:forEach>
      </select><br />
    </p>
</c:forEach>

    <div style="clear: both;"></div>


  </div>


  <div class="buttonSet">
    <span class="buttonAction">
        <span class="tdbLink">
            <button id="tdb4" type="submit">Add to Cart</button>
        </span>
        <script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script>
    </span>

    <span class="tdbLink">
        <a id="tdb5" href="http://shadowfax/oscommerce2/product_reviews.php?cPath=2_19&amp;products_id=22">Reviews</a>
    </span>
      <script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-comment"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
  </div>


</div>

</form>

