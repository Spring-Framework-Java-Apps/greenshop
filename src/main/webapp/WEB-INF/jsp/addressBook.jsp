<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>My Personal Address Book</h1>


<div class="contentContainer">
  <h2>Primary Address</h2>

  <div class="contentText">
    <div class="ui-widget infoBoxContainer" style="float: right;">
      <div class="ui-widget-header infoBoxHeading">Primary Address</div>

      <div class="ui-widget-content infoBoxContents">
      	${customer.defaultAddress.formattedAddress}
        <!--  Thomas Woehlke<br /> Kirchstr. 3<br /> 10551 Berlin<br /> Germany      -->
        </div>
    </div>

    This address is used as the pre-selected shipping and billing address for orders placed on this store.<br /><br />This address is also used as the base for product and service tax calculations.  </div>

  <div style="clear: both;"></div>

  <h2>Address Book Entries</h2>

  <div class="contentText">


<c:forEach var="adress" items="${adressBook}" varStatus="status">
   <div>
      <span style="float: right;"><span class="tdbLink"><a id="tdb${status.index*2+5}" href="<c:url value="/addressBook/edit/${adress.id}"/>">Edit</a></span><script type="text/javascript">$("#tdb<c:out value="${status.index*2+5}"/>").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script> <span class="tdbLink"><a id="tdb${status.index*2+6}" href="<c:url value="/addressBook/delete/${adress.id}"/>">Delete</a></span><script type="text/javascript">$("#tdb<c:out value="${status.index*2+6}"/>").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></span>
      <p><strong><c:out value="${adress.firstname}" /> <c:out value="${adress.lastname}" /></strong>
      <c:if test="${adress.primaryAddress}">&nbsp;<small><i>(primary address)</i></small></c:if></p>
      <p style="padding-left: 20px;">${adress.formattedAddress}</p>
    </div>
</c:forEach>
 
<!--  
    <div>
      <span style="float: right;"><span class="tdbLink"><a id="tdb5" href="http://localhost/oscommerce2/address_book_process.php?edit=7">Edit</a></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script> <span class="tdbLink"><a id="tdb6" href="http://localhost/oscommerce2/address_book_process.php?delete=7">Delete</a></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></span>
      <p><strong>Andreas Mueller</strong></p>
      <p style="padding-left: 20px;">Andreas Mueller<br /> Kirchstr. 3<br /> 10557 Berlin<br /> Germany</p>
    </div>


    <div>
      <span style="float: right;"><span class="tdbLink"><a id="tdb7" href="http://localhost/oscommerce2/address_book_process.php?edit=6">Edit</a></span><script type="text/javascript">$("#tdb7").button({icons:{primary:"ui-icon-document"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script> <span class="tdbLink"><a id="tdb8" href="http://localhost/oscommerce2/address_book_process.php?delete=6">Delete</a></span><script type="text/javascript">$("#tdb8").button({icons:{primary:"ui-icon-trash"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></span>
      <p><strong>Thomas Woehlke</strong>&nbsp;<small><i>(primary address)</i></small></p>
      <p style="padding-left: 20px;">Thomas Woehlke<br /> Kirchstr. 3<br /> 10551 Berlin<br /> Germany</p>
    </div>
-->

  </div>

  <div class="buttonSet">


    <span class="buttonAction"><span class="tdbLink"><a id="tdb9" href="<c:url value="/addressBook/add"/>">Add Address</a></span><script type="text/javascript">$("#tdb9").button({icons:{primary:"ui-icon-home"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>


    <span class="tdbLink"><a id="tdb10" href='<c:url value="/account" />'>Back</a></span><script type="text/javascript">$("#tdb10").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>

  <p><font color="#ff0000"><strong>NOTE:</strong></font> A maximum of 5 address book entries allowed.</p>
</div>