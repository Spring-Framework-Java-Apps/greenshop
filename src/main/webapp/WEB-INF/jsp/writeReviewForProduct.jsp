<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div>
    <h1 style="float: right;">$<c:out value="${product.product.price}"/></h1>
    <h1><c:out value="${product.name}"/><br /><span class="smallText">[<c:out value="${product.product.model}"/>]</span></h1>
</div>

<form:form commandName="writeReviewBean" method="post">
    <div class="contentContainer">


        <div style="float: right; width: 120px; text-align: center;">
            <a href="<c:url value="/product/${product.product.id}"/>">
                <img src="images/<c:out value="${product.product.image}"/>" alt="<c:out value="${product.name}"/>" title="<c:out value="${product.name}"/>" width="100" height="80" hspace="5" vspace="5" />
            </a>
            <p>
                <span class="tdbLink">
                    <a id="tdb5" href="<c:url value="/shoppingCart/add/${product.product.id}"/>">Add to Cart</a>
                </span>
                <script type="text/javascript">$("#tdb5").button({icons:{primary:"ui-icon-cart"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
            </p>
        </div>


        <div class="contentText">
            <table border="0" cellspacing="0" cellpadding="2">
                <tr>
                    <td class="fieldKey">From:</td>
                    <td class="fieldValue"><c:out value="${customer.firstname}"/> <c:out value="${customer.lastname}"/></td>
                </tr>
                <tr>
                    <td class="fieldKey" valign="top">Your Review:</td>
                    <td class="fieldValue"><form:textarea path="reviewText" cols="60" rows="15"/><br />
                        <form:errors path="reviewText"/>
                        <span style="float: right;"><small><font color="#ff0000"><strong>NOTE:</strong></font></small>&nbsp;HTML is not translated!</span>
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">Rating:</td>
                    <td class="fieldValue">
                        <small><font color="#ff0000"><strong>BAD</strong></font></small>
                        <form:radiobutton path="rating" value="1" />
                        <form:radiobutton path="rating" value="2" />
                        <form:radiobutton path="rating" value="3" />
                        <form:radiobutton path="rating" value="4" />
                        <form:radiobutton path="rating" value="5" />
                        <form:errors path="rating"/>
                        <small><font color="#ff0000"><strong>GOOD</strong></font></small>
                    </td>
                </tr>
            </table>
        </div>

        <div class="buttonSet">
            <span class="buttonAction">
                <span class="tdbLink">
                    <button id="tdb6" type="submit">Continue</button>
                </span>
                <script type="text/javascript">$("#tdb6").button({icons:{primary:"ui-icon-triangle-1-e"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script>
            </span>

            <span class="tdbLink">
                <a id="tdb7" href="<c:url value="/product/${product.product.id}"/>">Back</a>
            </span>
            <script type="text/javascript">$("#tdb7").button({icons:{primary:"ui-icon-triangle-1-w"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script>
        </div>
    </div>

</form:form>