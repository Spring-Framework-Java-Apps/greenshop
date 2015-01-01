<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="contentContainer">

  <h1>Welcome to Greenshop</h1>

  <div class="contentText">
    Welcome <span class="greetUser">Guest!</span> Would you like to <a href="http://shadowfax/oscommerce2/login.php"><u>log yourself in</u></a>? Or would you prefer to <a href="http://shadowfax/oscommerce2/create_account.php"><u>create an account</u></a>?  </div>


  <h2>New Products</h2>

  <div class="contentText">
  <!-- 
    <table border="0" width="100%" cellspacing="0" cellpadding="2"><tr><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=28"><img src="images/samsung/galaxy_tab.gif" alt="Samsung Galaxy Tab" title=" Samsung Galaxy Tab " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=28">Samsung Galaxy Tab</a><br />$749.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=16"><img src="images/dvd/courage_under_fire.gif" alt="Courage Under Fire" title=" Courage Under Fire " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=16">Courage Under Fire</a><br />$29.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=17"><img src="images/dvd/speed.gif" alt="Speed" title=" Speed " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=17">Speed</a><br />$39.99</td></tr><tr><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=18"><img src="images/dvd/speed_2.gif" alt="Speed 2: Cruise Control" title=" Speed 2: Cruise Control " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=18">Speed 2: Cruise Control</a><br />$42.00</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=19"><img src="images/dvd/theres_something_about_mary.gif" alt="There's Something About Mary" title=" There's Something About Mary " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=19">There's Something About Mary</a><br />$49.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=20"><img src="images/dvd/beloved.gif" alt="Beloved" title=" Beloved " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=20">Beloved</a><br />$54.99</td></tr><tr><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=21"><img src="images/sierra/swat_3.gif" alt="SWAT 3: Close Quarters Battle" title=" SWAT 3: Close Quarters Battle " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=21">SWAT 3: Close Quarters Battle</a><br />$79.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=22"><img src="images/gt_interactive/unreal_tournament.gif" alt="Unreal Tournament" title=" Unreal Tournament " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=22">Unreal Tournament</a><br />$89.99</td><td width="33%" align="center" valign="top"><a href="http://shadowfax/oscommerce2/product_info.php?products_id=23"><img src="images/gt_interactive/wheel_of_time.gif" alt="The Wheel Of Time" title=" The Wheel Of Time " width="100" height="80" /></a><br /><a href="http://shadowfax/oscommerce2/product_info.php?products_id=23">The Wheel Of Time</a><br />$99.99</td></tr></table>  
  --> 
   	<table border="0" width="100%" cellspacing="0" cellpadding="2"><tr>
   	<c:forEach items="${newProducts}" var="newProduct" varStatus="status">
   		<td width="33%" align="center" valign="top">
   			<a href='<c:url value="/product/${newProduct.productDescription.product.id}" />'>
				<img src='<c:url value="/resources/images/${newProduct.productDescription.product.image}" />'/>
			</a>
			<br/>
			<a href='<c:url value="/product/${newProduct.productDescription.product.id}" />'>
				<c:out value="${newProduct.productDescription.name}"/>
			</a>
			<br/>
			<c:if test="${! newProduct.specialProduct}">
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
			<br/>
   		</td>
   		<c:if test="${status.index % 3 == 2}">
   			</tr><tr>	
   		</c:if>
   	</c:forEach>
   	</tr></table>
    </div>
</div>  

