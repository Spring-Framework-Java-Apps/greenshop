<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Currencies</div>  <div class="ui-widget-content infoBoxContents">    <form name="currencies" action="http://shadowfax/oscommerce2/index.php" method="get">    <select name="currency" onchange="this.form.submit();" style="width: 100%"><option value="USD" selected="selected">U.S. Dollar</option><option value="EUR">Euro</option></select></form>  </div></div>

