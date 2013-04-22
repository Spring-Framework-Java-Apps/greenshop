<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<h1>Newsletter Subscriptions</h1>

<form name="account_newsletter" action="http://localhost/oscommerce2/account_newsletters.php" method="post"><input type="hidden" name="formid" value="0923a4ea590b42438f4ff4a9af74d302" /><input type="hidden" name="action" value="process" />
<div class="contentContainer">
  <h2>My Newsletter Subscriptions</h2>

  <div class="contentText">
    <table border="0" cellspacing="2" cellpadding="2">
      <tr>
        <td><input type="checkbox" name="newsletter_general" value="1" onclick="checkBox('newsletter_general')" /></td>
        <td><strong>General Newsletter</strong><br />Including store news, new products, special offers, and other promotional announcements.</td>
      </tr>
    </table>
  </div>

  <div class="buttonSet">
    <span class="buttonAction"><span class="tdbLink"><button id="tdb5" type="submit">Continue</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></span>

    <span class="tdbLink"><a id="tdb6" href='<c:url value="/account" />'>Back</a></span><script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>  </div>
</div>

</form>