<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Greenshop</title>
<base href='<c:url value="/resources/"/>' />
<link rel="stylesheet" type="text/css" href="ext/jquery/ui/redmond/jquery-ui-1.8.6.css" />
<script type="text/javascript" src="ext/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="ext/jquery/ui/jquery-ui-1.8.6.min.js"></script>


<script type="text/javascript" src="ext/jquery/bxGallery/jquery.bxGallery.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="ext/jquery/fancybox/jquery.fancybox-1.3.4.css" />
<script type="text/javascript" src="ext/jquery/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="ext/960gs/960_24_col.css" />
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>
<body>

<div id="bodyWrapper" class="container_24">

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="breadcrumb" />

<div id="bodyContent" class="grid_16 push_4">
<tiles:insertAttribute name="bodyContent" />	
</div> <!-- bodyContent //-->

<div id="columnLeft" class="grid_4 pull_16">
<tiles:insertAttribute name="categoryBox" />
<tiles:insertAttribute name="manufacturersBox" />
<tiles:insertAttribute name="quickFindBox" />
<tiles:insertAttribute name="newProductsBox" />
<tiles:insertAttribute name="informationPagesBox" />
</div>
<div id="columnRight" class="grid_4">
<tiles:insertAttribute name="shoppingCartBox" />

<tiles:insertAttribute name="specialsBox" />
<tiles:insertAttribute name="reviewsBox" />

<tiles:insertAttribute name="manufacturerInfoBox" />
<tiles:insertAttribute name="setNotificationBox" />
<tiles:insertAttribute name="shareProductBox" />
<tiles:insertAttribute name="writeReviewBox" />

<tiles:insertAttribute name="languagesBox" />
<tiles:insertAttribute name="currenciesBox" />
</div>

<tiles:insertAttribute name="footer" />
<tiles:insertAttribute name="banner" />

<script type="text/javascript">
$('.productListTable tr:nth-child(even)').addClass('alt');
</script>

</div> <!-- bodyWrapper //-->


</body>
</html>
