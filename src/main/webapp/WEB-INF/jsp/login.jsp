<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<h1>Welcome, Please Sign In</h1>


<div class="contentContainer" style="width: 45%; float: left;">
  <h2>New Customer</h2>

  <div class="contentText">
    <p>I am a new customer.</p>
    <p>By creating an account at osCommerce2 you will be able to shop faster, be up to date on an orders status, and keep track of the orders you have previously made.</p>

    <p align="right"><span class="tdbLink"><a id='tdb4' href='<c:url value="/createAccount"/>'>Continue</a></span><script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></p>
  </div>
</div>

<div class="contentContainer" style="width: 45%; float: left; border-left: 1px dashed #ccc; padding-left: 3%; margin-left: 3%;">
  <h2>Returning Customer</h2>

  <div class="contentText">
    <p>I am a returning customer.</p>

    <form name="login" action='<c:url value="/j_spring_security_check"/>' method="post">
    <input type="hidden" name="formid" value="1e6b0d45174da800bad4fea9bafd1603" />
    <c:if test="${not empty param.login_error}">
		<span>
			Your login attempt was not successful, try again.<br /> Caused :
			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		</span>
	</c:if>
      <input type="hidden"
             name="${_csrf.parameterName}"
             value="${_csrf.token}"/>
    <table border="0" cellspacing="0" cellpadding="2" width="100%">
      <tr>
        <td class="fieldKey">E-Mail Address:</td>
        <td class="fieldValue"><input type="text" name="j_username" /></td>
      </tr>
      <tr>
        <td class="fieldKey">Password:</td>
        <td class="fieldValue"><input type="password" name="j_password" maxlength="40" /></td>
      </tr>
    </table>

    <p><a href="http://shadowfax/oscommerce2/password_forgotten.php?osCsid=02u6jhirboe8cn159l65kc0ea1">Password forgotten? Click here.</a></p>

    <p align="right"><span class="tdbLink"><button id="tdb5" type="submit">Sign In</button></span><script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-key"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script></p>

    </form>
  </div>
</div>