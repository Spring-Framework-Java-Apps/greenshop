<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<script type="text/javascript" src="resources/includes/general.js"></script>
<script type="text/javascript"><!--
function check_form() {
    var error_message = "Errors have occured during the process of your form.\n\nPlease make the following corrections:\n\n";
    var error_found = false;
    var error_field;
    var keywords = document.advanced_search.keywords.value;
    var dfrom = document.advanced_search.dfrom.value;
    var dto = document.advanced_search.dto.value;
    var pfrom = document.advanced_search.pfrom.value;
    var pto = document.advanced_search.pto.value;
    var pfrom_float;
    var pto_float;

    if ( ((keywords == '') || (keywords.length < 1)) && ((dfrom == '') || (dfrom.length < 1)) && ((dto == '') || (dto.length < 1)) && ((pfrom == '') || (pfrom.length < 1)) && ((pto == '') || (pto.length < 1)) ) {
        error_message = error_message + "* At least one of the fields in the search form must be entered.\n";
        error_field = document.advanced_search.keywords;
        error_found = true;
    }

    if (dfrom.length > 0) {
        if (!IsValidDate(dfrom, 'mm/dd/yyyy')) {
            error_message = error_message + "* Invalid From Date.\n";
            error_field = document.advanced_search.dfrom;
            error_found = true;
        }
    }

    if (dto.length > 0) {
        if (!IsValidDate(dto, 'mm/dd/yyyy')) {
            error_message = error_message + "* Invalid To Date.\n";
            error_field = document.advanced_search.dto;
            error_found = true;
        }
    }

    if ((dfrom.length > 0) && (IsValidDate(dfrom, 'mm/dd/yyyy')) && (dto.length > 0) && (IsValidDate(dto, 'mm/dd/yyyy'))) {
        if (!CheckDateRange(document.advanced_search.dfrom, document.advanced_search.dto)) {
            error_message = error_message + "* To Date must be greater than or equal to From Date.\n";
            error_field = document.advanced_search.dto;
            error_found = true;
        }
    }

    if (pfrom.length > 0) {
        pfrom_float = parseFloat(pfrom);
        if (isNaN(pfrom_float)) {
            error_message = error_message + "* Price From must be a number.\n";
            error_field = document.advanced_search.pfrom;
            error_found = true;
        }
    } else {
        pfrom_float = 0;
    }

    if (pto.length > 0) {
        pto_float = parseFloat(pto);
        if (isNaN(pto_float)) {
            error_message = error_message + "* Price To must be a number.\n";
            error_field = document.advanced_search.pto;
            error_found = true;
        }
    } else {
        pto_float = 0;
    }

    if ( (pfrom.length > 0) && (pto.length > 0) ) {
        if ( (!isNaN(pfrom_float)) && (!isNaN(pto_float)) && (pto_float < pfrom_float) ) {
            error_message = error_message + "* Price To must be greater than or equal to Price From.\n";
            error_field = document.advanced_search.pto;
            error_found = true;
        }
    }

    if (error_found == true) {
        alert(error_message);
        error_field.focus();
        return false;
    } else {
        return true;
    }
}

function popupWindow(url) {
    window.open(url,'popupWindow','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,copyhistory=no,width=450,height=280,screenX=150,screenY=150,top=150,left=150')
}
//--></script>

<h1>Advanced Search</h1>


<form:form commandName="advancedSearchBean">
    <div class="contentContainer">
        <h2>Search Criteria</h2>

        <div class="contentText">
            <div>
                <form:input path="searchKeywords" style="width: 100%" />
                <input type="hidden" name="search_in_description" value="1" />
            </div>

            <br />

            <div>
                <span><a href="http://shadowfax/oscommerce2/popup_search_help.php" target="_blank" onclick="$('#helpSearch').dialog('open'); return false;"><u>Search Help</u> [?]</a></span>
                <span style="float: right;">
                    <span class="tdbLink">
                        <button id="tdb4" type="submit">Search</button>
                    </span>
                    <script type="text/javascript">$("#tdb4").button({icons:{primary:"ui-icon-search"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script>
                </span>
            </div>

            <div id="helpSearch" title="Search Help">
                <p>Keywords may be separated by AND and/or OR statements for greater control of the search results.<br /><br />For example, <u>Microsoft AND mouse</u> would generate a result set that contain both words. However, for <u>mouse OR keyboard</u>, the result set returned would contain both or either words.<br /><br />Exact matches can be searched for by enclosing keywords in double-quotes.<br /><br />For example, <u>"notebook computer"</u> would generate a result set which match the exact string.<br /><br />Brackets can be used for further control on the result set.<br /><br />For example, <u>Microsoft and (keyboard or mouse or "visual basic")</u>.</p>
            </div>

            <script type="text/javascript">
                $('#helpSearch').dialog({
                    autoOpen: false,
                    buttons: {
                        Ok: function() {
                            $(this).dialog('close');
                        }
                    }
                });
            </script>

            <br />

            <table border="0" width="100%" cellspacing="0" cellpadding="2">
                <tr>
                    <td class="fieldKey">Categories:</td>
                    <td class="fieldValue">
                        <select name="categories_id">
                            <option value="" selected="selected">All Categories</option>
                            <c:forEach var="category" items="${categoriesBean.categories}">
                               <option value="${category.category.id}">
                                   <c:forEach begin="1" end="${categoriesBean.category2level.get(category)}">&nbsp;&nbsp;</c:forEach>
                                   ${category.name}
                               </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">&nbsp;</td>
                    <td class="smallText">
                        <form:checkbox path="includeSubcategories" value="1" checked="checked"/> Include Subcategories
                        <!--<input type="checkbox" name="inc_subcat" value="1" checked="checked" />-->
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">Manufacturers:</td>
                    <td class="fieldValue">
                        <!--<select name="manufacturers_id">-->
                        <form:select path="manufacturer">
                            <option value="" selected="selected">All Manufacturers</option>
                            <c:forEach var="manufacturer" items="${manufacturers.manufacturers}">
                                <option value="${manufacturer.id}">${manufacturer.name}</option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">Price From:</td>
                    <td class="fieldValue">
                        <!--<input type="text" name="pfrom" />-->
                        <form:input path="priceFrom"/>
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">Price To:</td>
                    <td class="fieldValue">
                        <!--<input type="text" name="pto" />-->
                        <form:input path="priceTo"/>
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">Date From:</td>
                    <td class="fieldValue">
                        <!--<input type="text" name="dfrom" id="dfrom" />-->
                        <form:input path="dateFrom" id="dfrom"/>
                        <script type="text/javascript">$('#dfrom').datepicker({dateFormat: 'mm/dd/yy', changeMonth: true, changeYear: true, yearRange: '-10:+0'});</script>
                    </td>
                </tr>
                <tr>
                    <td class="fieldKey">Date To:</td>
                    <td class="fieldValue">
                        <!--<input type="text" name="dto" id="dto" />-->
                        <form:input path="dateTo" id="dto"/>
                        <script type="text/javascript">$('#dto').datepicker({dateFormat: 'mm/dd/yy', changeMonth: true, changeYear: true, yearRange: '-10:+0'});</script>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</form:form>