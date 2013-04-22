<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>My Account Information</h1>


<div class="contentContainer">
  <h2>My Account</h2>

  <div class="contentText">
    <ul class="accountLinkList">
      <li><span class="ui-icon ui-icon-person accountLinkListEntry"></span><a href='<c:url value="/accountEdit"/>'>View or change my account information.</a></li>
      <li><span class="ui-icon ui-icon-home accountLinkListEntry"></span><a href='<c:url value="/addressBook"/>'>View or change entries in my address book.</a></li>
      <li><span class="ui-icon ui-icon-key accountLinkListEntry"></span><a href='<c:url value="/accountPassword"/>'>Change my account password.</a></li>
    </ul>
  </div>

  <h2>My Orders</h2>

  <div class="contentText">
    <ul class="accountLinkList">
      <li><span class="ui-icon ui-icon-cart accountLinkListEntry"></span><a href='<c:url value="/accountHistory"/>'>View the orders I have made.</a></li>
    </ul>
  </div>

  <h2>E-Mail Notifications</h2>

  <div class="contentText">
    <ul class="accountLinkList">
      <li><span class="ui-icon ui-icon-mail-closed accountLinkListEntry"></span><a href='<c:url value="/accountNewsletter"/>'>Subscribe or unsubscribe from newsletters.</a></li>
      <li><span class="ui-icon ui-icon-heart accountLinkListEntry"></span><a href='<c:url value="/accountNotifications"/>'>View or change my product notification list.</a></li>
    </ul>
  </div>
</div>