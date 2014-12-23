<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="ui-widget infoBoxContainer">  <div class="ui-widget-header infoBoxHeading">Manufacturers</div>
    <div class="ui-widget-content infoBoxContents"><form name="manufacturers" action="../manufacturer/" method="get"><select name="manufacturers_id" onchange="this.form.submit();" size="1" style="width: 100%">
    <c:choose>
        <c:when test="${manufacturers.manufacturerId == 0}">
            <option value="0" selected="selected">Please Select</option>
        </c:when>
        <c:otherwise>
            <option value="0">Please Select</option>
        </c:otherwise>
    </c:choose>
    <c:forEach items="${manufacturers.manufacturers}" var="manufacturer">
        <c:choose>
            <c:when test="${manufacturers.manufacturerId == manufacturer.id}">
                <option value="${manufacturer.id}" selected="selected">${manufacturer.name}</option>
            </c:when>
            <c:otherwise>
                <option value="${manufacturer.id}">${manufacturer.name}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>
</form>
</div>
</div>