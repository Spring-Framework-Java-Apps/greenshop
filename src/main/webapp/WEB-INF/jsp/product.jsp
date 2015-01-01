<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<!--  <form name="cart_quantity" action="http://shadowfax/oscommerce2/product_info.php?cPath=2_19&amp;products_id=22&amp;action=add_product" method="post">-->
<form action='<c:url value="/shoppingCart/add/${product.productDescription.product.id}"/>' method="get">
<div>
  <h1 style="float: right;">
      <c:if test="${! product.specialProduct}">
      $<c:out value="${product.productDescription.product.price}"/>
      </c:if>
      <c:if test="${product.specialProduct}">
          <del>$<c:out value="${product.productDescription.product.price}"/></del>
          <span class="productSpecialPrice">$${product.special.newPrice}</span>
      </c:if>
  </h1>
  <h1><c:out value="${product.productDescription.name}"/><br /><span class="smallText">[<c:out value="${product.productDescription.product.model}"/>]</span></h1>
</div>

<div class="contentContainer">
  <div class="contentText">
      <c:if test="${empty images}">
    <div id="piGal" style="float: right;">
      <a href='images/<c:out value="${product.productDescription.product.image}"/>' target='_blank' rel='fancybox'>
          <img src='images/<c:out value="${product.productDescription.product.image}"/>' alt='<c:out value="${product.productDescription.name}"/>' title=' <c:out value="${product.productDescription.name}"/> ' width="100" height="80" hspace="5" vspace="5" />
      </a>
          </div>
      </c:if>
      <c:if test="${! empty images}">
      <div id="piGal" style="float: right;">
          <ul>
          <c:forEach var="image" items="${images}">
          <li><a href='images/<c:out value="${image.image}"/>'
             target='_blank' rel='fancybox'>
              <img src='images/<c:out value="${image.image}"/>'
                   alt="" width="640" height="480" />
          </a></li>
          </c:forEach>
              </ul>
          </div>
      </c:if>

<script type="text/javascript">
  $('#piGal ul').bxGallery({
      maxwidth: 300,
      maxheight: 200,
      thumbwidth: 75,
      thumbcontainer: 300,
      load_image: 'ext/jquery/bxGallery/spinner.gif'
  });
</script>


<script type="text/javascript">
  $("#piGal a[rel^='fancybox']").fancybox({
      cyclic: true
  });
</script>


${product.productDescription.description}

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
        <a id="tdb5" href="<c:url value="/product/reviews/${product.productDescription.product.id}"/>">
            Reviews<c:if test="${numberOfReviews > 0}"> (${numberOfReviews})</c:if>
        </a>
    </span>
      <script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-comment"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
  </div>


</div>

</form>

