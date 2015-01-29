<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<script type="text/javascript"><!--
function resetZoneSelected(theForm) {
    if (theForm.state.value != '') {
        theForm.zone_id.selectedIndex = '0';
        if (theForm.zone_id.options.length > 0) {
            theForm.state.value = '-- Select Above --';
        }
    }
}

function update_zone(theForm) {
    var NumState = theForm.zone_id.options.length;
    var SelectedCountry = "";

    while(NumState > 0) {
        NumState--;
        theForm.zone_id.options[NumState] = null;
    }

    SelectedCountry = theForm.zone_country_id.options[theForm.zone_country_id.selectedIndex].value;

    if (SelectedCountry == "14") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        theForm.zone_id.options[1] = new Option("Burgenland", "102");
        theForm.zone_id.options[2] = new Option("Kärnten", "99");
        theForm.zone_id.options[3] = new Option("Niederösterreich", "96");
        theForm.zone_id.options[4] = new Option("Oberösterreich", "97");
        theForm.zone_id.options[5] = new Option("Salzburg", "98");
        theForm.zone_id.options[6] = new Option("Steiermark", "100");
        theForm.zone_id.options[7] = new Option("Tirol", "101");
        theForm.zone_id.options[8] = new Option("Voralberg", "103");
        theForm.zone_id.options[9] = new Option("Wien", "95");
    } else if (SelectedCountry == "38") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        theForm.zone_id.options[1] = new Option("Alberta", "66");
        theForm.zone_id.options[2] = new Option("British Columbia", "67");
        theForm.zone_id.options[3] = new Option("Manitoba", "68");
        theForm.zone_id.options[4] = new Option("New Brunswick", "70");
        theForm.zone_id.options[5] = new Option("Newfoundland", "69");
        theForm.zone_id.options[6] = new Option("Northwest Territories", "72");
        theForm.zone_id.options[7] = new Option("Nova Scotia", "71");
        theForm.zone_id.options[8] = new Option("Nunavut", "73");
        theForm.zone_id.options[9] = new Option("Ontario", "74");
        theForm.zone_id.options[10] = new Option("Prince Edward Island", "75");
        theForm.zone_id.options[11] = new Option("Quebec", "76");
        theForm.zone_id.options[12] = new Option("Saskatchewan", "77");
        theForm.zone_id.options[13] = new Option("Yukon Territory", "78");
    } else if (SelectedCountry == "81") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        theForm.zone_id.options[1] = new Option("Baden-Württemberg", "80");
        theForm.zone_id.options[2] = new Option("Bayern", "81");
        theForm.zone_id.options[3] = new Option("Berlin", "82");
        theForm.zone_id.options[4] = new Option("Brandenburg", "83");
        theForm.zone_id.options[5] = new Option("Bremen", "84");
        theForm.zone_id.options[6] = new Option("Hamburg", "85");
        theForm.zone_id.options[7] = new Option("Hessen", "86");
        theForm.zone_id.options[8] = new Option("Mecklenburg-Vorpommern", "87");
        theForm.zone_id.options[9] = new Option("Niedersachsen", "79");
        theForm.zone_id.options[10] = new Option("Nordrhein-Westfalen", "88");
        theForm.zone_id.options[11] = new Option("Rheinland-Pfalz", "89");
        theForm.zone_id.options[12] = new Option("Saarland", "90");
        theForm.zone_id.options[13] = new Option("Sachsen", "91");
        theForm.zone_id.options[14] = new Option("Sachsen-Anhalt", "92");
        theForm.zone_id.options[15] = new Option("Schleswig-Holstein", "93");
        theForm.zone_id.options[16] = new Option("Thüringen", "94");
    } else if (SelectedCountry == "195") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        theForm.zone_id.options[1] = new Option("A Coruña", "130");
        theForm.zone_id.options[2] = new Option("Alava", "131");
        theForm.zone_id.options[3] = new Option("Albacete", "132");
        theForm.zone_id.options[4] = new Option("Alicante", "133");
        theForm.zone_id.options[5] = new Option("Almeria", "134");
        theForm.zone_id.options[6] = new Option("Asturias", "135");
        theForm.zone_id.options[7] = new Option("Avila", "136");
        theForm.zone_id.options[8] = new Option("Badajoz", "137");
        theForm.zone_id.options[9] = new Option("Baleares", "138");
        theForm.zone_id.options[10] = new Option("Barcelona", "139");
        theForm.zone_id.options[11] = new Option("Burgos", "140");
        theForm.zone_id.options[12] = new Option("Caceres", "141");
        theForm.zone_id.options[13] = new Option("Cadiz", "142");
        theForm.zone_id.options[14] = new Option("Cantabria", "143");
        theForm.zone_id.options[15] = new Option("Castellon", "144");
        theForm.zone_id.options[16] = new Option("Ceuta", "145");
        theForm.zone_id.options[17] = new Option("Ciudad Real", "146");
        theForm.zone_id.options[18] = new Option("Cordoba", "147");
        theForm.zone_id.options[19] = new Option("Cuenca", "148");
        theForm.zone_id.options[20] = new Option("Girona", "149");
        theForm.zone_id.options[21] = new Option("Granada", "150");
        theForm.zone_id.options[22] = new Option("Guadalajara", "151");
        theForm.zone_id.options[23] = new Option("Guipuzcoa", "152");
        theForm.zone_id.options[24] = new Option("Huelva", "153");
        theForm.zone_id.options[25] = new Option("Huesca", "154");
        theForm.zone_id.options[26] = new Option("Jaen", "155");
        theForm.zone_id.options[27] = new Option("La Rioja", "156");
        theForm.zone_id.options[28] = new Option("Las Palmas", "157");
        theForm.zone_id.options[29] = new Option("Leon", "158");
        theForm.zone_id.options[30] = new Option("Lleida", "159");
        theForm.zone_id.options[31] = new Option("Lugo", "160");
        theForm.zone_id.options[32] = new Option("Madrid", "161");
        theForm.zone_id.options[33] = new Option("Malaga", "162");
        theForm.zone_id.options[34] = new Option("Melilla", "163");
        theForm.zone_id.options[35] = new Option("Murcia", "164");
        theForm.zone_id.options[36] = new Option("Navarra", "165");
        theForm.zone_id.options[37] = new Option("Ourense", "166");
        theForm.zone_id.options[38] = new Option("Palencia", "167");
        theForm.zone_id.options[39] = new Option("Pontevedra", "168");
        theForm.zone_id.options[40] = new Option("Salamanca", "169");
        theForm.zone_id.options[41] = new Option("Santa Cruz de Tenerife", "170");
        theForm.zone_id.options[42] = new Option("Segovia", "171");
        theForm.zone_id.options[43] = new Option("Sevilla", "172");
        theForm.zone_id.options[44] = new Option("Soria", "173");
        theForm.zone_id.options[45] = new Option("Tarragona", "174");
        theForm.zone_id.options[46] = new Option("Teruel", "175");
        theForm.zone_id.options[47] = new Option("Toledo", "176");
        theForm.zone_id.options[48] = new Option("Valencia", "177");
        theForm.zone_id.options[49] = new Option("Valladolid", "178");
        theForm.zone_id.options[50] = new Option("Vizcaya", "179");
        theForm.zone_id.options[51] = new Option("Zamora", "180");
        theForm.zone_id.options[52] = new Option("Zaragoza", "181");
    } else if (SelectedCountry == "204") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        theForm.zone_id.options[1] = new Option("Aargau", "104");
        theForm.zone_id.options[2] = new Option("Appenzell Ausserrhoden", "106");
        theForm.zone_id.options[3] = new Option("Appenzell Innerrhoden", "105");
        theForm.zone_id.options[4] = new Option("Basel-Landschaft", "108");
        theForm.zone_id.options[5] = new Option("Basel-Stadt", "109");
        theForm.zone_id.options[6] = new Option("Bern", "107");
        theForm.zone_id.options[7] = new Option("Freiburg", "110");
        theForm.zone_id.options[8] = new Option("Genf", "111");
        theForm.zone_id.options[9] = new Option("Glarus", "112");
        theForm.zone_id.options[10] = new Option("Graubünden", "113");
        theForm.zone_id.options[11] = new Option("Jura", "114");
        theForm.zone_id.options[12] = new Option("Luzern", "115");
        theForm.zone_id.options[13] = new Option("Neuenburg", "116");
        theForm.zone_id.options[14] = new Option("Nidwalden", "117");
        theForm.zone_id.options[15] = new Option("Obwalden", "118");
        theForm.zone_id.options[16] = new Option("Schaffhausen", "120");
        theForm.zone_id.options[17] = new Option("Schwyz", "122");
        theForm.zone_id.options[18] = new Option("Solothurn", "121");
        theForm.zone_id.options[19] = new Option("St. Gallen", "119");
        theForm.zone_id.options[20] = new Option("Tessin", "124");
        theForm.zone_id.options[21] = new Option("Thurgau", "123");
        theForm.zone_id.options[22] = new Option("Uri", "125");
        theForm.zone_id.options[23] = new Option("Waadt", "126");
        theForm.zone_id.options[24] = new Option("Wallis", "127");
        theForm.zone_id.options[25] = new Option("Zug", "128");
        theForm.zone_id.options[26] = new Option("Zürich", "129");
    } else if (SelectedCountry == "223") {
        theForm.zone_id.options[0] = new Option("All Zones", "");
        theForm.zone_id.options[1] = new Option("Alabama", "1");
        theForm.zone_id.options[2] = new Option("Alaska", "2");
        theForm.zone_id.options[3] = new Option("American Samoa", "3");
        theForm.zone_id.options[4] = new Option("Arizona", "4");
        theForm.zone_id.options[5] = new Option("Arkansas", "5");
        theForm.zone_id.options[6] = new Option("Armed Forces Africa", "6");
        theForm.zone_id.options[7] = new Option("Armed Forces Americas", "7");
        theForm.zone_id.options[8] = new Option("Armed Forces Canada", "8");
        theForm.zone_id.options[9] = new Option("Armed Forces Europe", "9");
        theForm.zone_id.options[10] = new Option("Armed Forces Middle East", "10");
        theForm.zone_id.options[11] = new Option("Armed Forces Pacific", "11");
        theForm.zone_id.options[12] = new Option("California", "12");
        theForm.zone_id.options[13] = new Option("Colorado", "13");
        theForm.zone_id.options[14] = new Option("Connecticut", "14");
        theForm.zone_id.options[15] = new Option("Delaware", "15");
        theForm.zone_id.options[16] = new Option("District of Columbia", "16");
        theForm.zone_id.options[17] = new Option("Federated States Of Micronesia", "17");
        theForm.zone_id.options[18] = new Option("Florida", "18");
        theForm.zone_id.options[19] = new Option("Georgia", "19");
        theForm.zone_id.options[20] = new Option("Guam", "20");
        theForm.zone_id.options[21] = new Option("Hawaii", "21");
        theForm.zone_id.options[22] = new Option("Idaho", "22");
        theForm.zone_id.options[23] = new Option("Illinois", "23");
        theForm.zone_id.options[24] = new Option("Indiana", "24");
        theForm.zone_id.options[25] = new Option("Iowa", "25");
        theForm.zone_id.options[26] = new Option("Kansas", "26");
        theForm.zone_id.options[27] = new Option("Kentucky", "27");
        theForm.zone_id.options[28] = new Option("Louisiana", "28");
        theForm.zone_id.options[29] = new Option("Maine", "29");
        theForm.zone_id.options[30] = new Option("Marshall Islands", "30");
        theForm.zone_id.options[31] = new Option("Maryland", "31");
        theForm.zone_id.options[32] = new Option("Massachusetts", "32");
        theForm.zone_id.options[33] = new Option("Michigan", "33");
        theForm.zone_id.options[34] = new Option("Minnesota", "34");
        theForm.zone_id.options[35] = new Option("Mississippi", "35");
        theForm.zone_id.options[36] = new Option("Missouri", "36");
        theForm.zone_id.options[37] = new Option("Montana", "37");
        theForm.zone_id.options[38] = new Option("Nebraska", "38");
        theForm.zone_id.options[39] = new Option("Nevada", "39");
        theForm.zone_id.options[40] = new Option("New Hampshire", "40");
        theForm.zone_id.options[41] = new Option("New Jersey", "41");
        theForm.zone_id.options[42] = new Option("New Mexico", "42");
        theForm.zone_id.options[43] = new Option("New York", "43");
        theForm.zone_id.options[44] = new Option("North Carolina", "44");
        theForm.zone_id.options[45] = new Option("North Dakota", "45");
        theForm.zone_id.options[46] = new Option("Northern Mariana Islands", "46");
        theForm.zone_id.options[47] = new Option("Ohio", "47");
        theForm.zone_id.options[48] = new Option("Oklahoma", "48");
        theForm.zone_id.options[49] = new Option("Oregon", "49");
        theForm.zone_id.options[50] = new Option("Palau", "50");
        theForm.zone_id.options[51] = new Option("Pennsylvania", "51");
        theForm.zone_id.options[52] = new Option("Puerto Rico", "52");
        theForm.zone_id.options[53] = new Option("Rhode Island", "53");
        theForm.zone_id.options[54] = new Option("South Carolina", "54");
        theForm.zone_id.options[55] = new Option("South Dakota", "55");
        theForm.zone_id.options[56] = new Option("Tennessee", "56");
        theForm.zone_id.options[57] = new Option("Texas", "57");
        theForm.zone_id.options[58] = new Option("Utah", "58");
        theForm.zone_id.options[59] = new Option("Vermont", "59");
        theForm.zone_id.options[60] = new Option("Virgin Islands", "60");
        theForm.zone_id.options[61] = new Option("Virginia", "61");
        theForm.zone_id.options[62] = new Option("Washington", "62");
        theForm.zone_id.options[63] = new Option("West Virginia", "63");
        theForm.zone_id.options[64] = new Option("Wisconsin", "64");
        theForm.zone_id.options[65] = new Option("Wyoming", "65");
    } else {
        theForm.zone_id.options[0] = new Option("All Zones", "");
    }

}
//--></script>

<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td width="100%"><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td class="pageHeading">Tax Zones</td>
                <td class="pageHeading" align="right"><img src="resources/admin/images/pixel_trans.gif" border="0" alt="" width="57" height="40" /></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="dataTableHeadingRow">
                            <td class="dataTableHeadingContent">Country</td>
                            <td class="dataTableHeadingContent">Zone</td>
                            <td class="dataTableHeadingContent" align="right">Action&nbsp;</td>
                        </tr>
                        <c:forEach items="${zones}" var="zone">
                            <c:if test="${zone.id == thisZone.id}">
                                <tr id="defaultSelected" class="dataTableRowSelected" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>'">
                                    <td class="dataTableContent">${zone.zoneCountry.name}</td>
                                    <c:choose>
                                        <c:when test="${zone.zone == null}">
                                            <td class="dataTableContent">All Zones</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="dataTableContent"><c:out value="${zone.zone.name}"/></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td class="dataTableContent" align="right"><img src="resources/admin/images/icon_arrow_right.gif" border="0" alt="" />&nbsp;</td>
                                </tr>
                            </c:if>
                            <c:if test="${zone.id != thisZone.id}">
                                <tr class="dataTableRow" onmouseover="rowOverEffect(this)" onmouseout="rowOutEffect(this)" onclick="document.location.href='<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>'">
                                    <td class="dataTableContent">${zone.zoneCountry.name}</td>
                                    <c:choose>
                                        <c:when test="${zone.zone == null}">
                                            <td class="dataTableContent">All Zones</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="dataTableContent"><c:out value="${zone.zone.name}"/></td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td class="dataTableContent" align="right"><a href="<c:url value="/admin/taxZone/${thisTaxZone.id}/zone/${zone.id}"/>"><img src="resources/admin/images/icon_info.gif" border="0" alt="Info" title="Info" /></a>&nbsp;</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <td colspan="3"><table border="0" width="100%" cellspacing="0" cellpadding="2">
                                <tr>
                                    <td class="smallText" valign="top">Displaying <strong>1</strong> to <strong>3</strong> (of <strong>3</strong> countries)</td>
                                    <td class="smallText" align="right">Page 1 of 1</td>
                                </tr>
                            </table></td>
                        </tr>
                        <tr>
                            <td class="smallText" align="right" colspan="3"></td>
                        </tr>
                    </table>
                </td>
                <td width="25%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="2">
                        <tr class="infoBoxHeading">
                            <td class="infoBoxHeading"><strong>Edit Sub Zone</strong></td>
                        </tr>
                    </table>
                    <form:form modelattribute="newSubZoneInfo" method="post">
                        <table border="0" width="100%" cellspacing="0" cellpadding="2">
                            <tr>
                                <td class="infoBoxContent">Please make any necessary changes</td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Country:<br /><select name="zone_country_id" onchange="update_zone(this.form);"><option value="">All Countries</option><option value="1">Afghanistan</option><option value="2">Albania</option><option value="3">Algeria</option><option value="4">American Samoa</option><option value="5">Andorra</option><option value="6">Angola</option><option value="7">Anguilla</option><option value="8">Antarctica</option><option value="9">Antigua and Barbuda</option><option value="10">Argentina</option><option value="11">Armenia</option><option value="12">Aruba</option><option value="13">Australia</option><option value="14">Austria</option><option value="15">Azerbaijan</option><option value="16">Bahamas</option><option value="17">Bahrain</option><option value="18">Bangladesh</option><option value="19">Barbados</option><option value="20">Belarus</option><option value="21">Belgium</option><option value="22">Belize</option><option value="23">Benin</option><option value="24">Bermuda</option><option value="25">Bhutan</option><option value="26">Bolivia</option><option value="27">Bosnia and Herzegowina</option><option value="28">Botswana</option><option value="29">Bouvet Island</option><option value="30">Brazil</option><option value="31">British Indian Ocean Territory</option><option value="32">Brunei Darussalam</option><option value="33">Bulgaria</option><option value="34">Burkina Faso</option><option value="35">Burundi</option><option value="36">Cambodia</option><option value="37">Cameroon</option><option value="38">Canada</option><option value="39">Cape Verde</option><option value="40">Cayman Islands</option><option value="41">Central African Republic</option><option value="42">Chad</option><option value="43">Chile</option><option value="44">China</option><option value="45">Christmas Island</option><option value="46">Cocos (Keeling) Islands</option><option value="47">Colombia</option><option value="48">Comoros</option><option value="49">Congo</option><option value="50">Cook Islands</option><option value="51">Costa Rica</option><option value="52">Cote D&#039;Ivoire</option><option value="53">Croatia</option><option value="54">Cuba</option><option value="55">Cyprus</option><option value="56">Czech Republic</option><option value="57">Denmark</option><option value="58">Djibouti</option><option value="59">Dominica</option><option value="60">Dominican Republic</option><option value="61">East Timor</option><option value="62">Ecuador</option><option value="63">Egypt</option><option value="64">El Salvador</option><option value="65">Equatorial Guinea</option><option value="66">Eritrea</option><option value="67">Estonia</option><option value="68">Ethiopia</option><option value="69">Falkland Islands (Malvinas)</option><option value="70">Faroe Islands</option><option value="71">Fiji</option><option value="72">Finland</option><option value="73">France</option><option value="74">France, Metropolitan</option><option value="75">French Guiana</option><option value="76">French Polynesia</option><option value="77">French Southern Territories</option><option value="78">Gabon</option><option value="79">Gambia</option><option value="80">Georgia</option><option value="81" selected="selected">Germany</option><option value="82">Ghana</option><option value="83">Gibraltar</option><option value="84">Greece</option><option value="85">Greenland</option><option value="86">Grenada</option><option value="87">Guadeloupe</option><option value="88">Guam</option><option value="89">Guatemala</option><option value="90">Guinea</option><option value="91">Guinea-bissau</option><option value="92">Guyana</option><option value="93">Haiti</option><option value="94">Heard and Mc Donald Islands</option><option value="95">Honduras</option><option value="96">Hong Kong</option><option value="97">Hungary</option><option value="98">Iceland</option><option value="99">India</option><option value="100">Indonesia</option><option value="101">Iran (Islamic Republic of)</option><option value="102">Iraq</option><option value="103">Ireland</option><option value="104">Israel</option><option value="105">Italy</option><option value="106">Jamaica</option><option value="107">Japan</option><option value="108">Jordan</option><option value="109">Kazakhstan</option><option value="110">Kenya</option><option value="111">Kiribati</option><option value="112">Korea, Democratic People&#039;s Republic of</option><option value="113">Korea, Republic of</option><option value="114">Kuwait</option><option value="115">Kyrgyzstan</option><option value="116">Lao People&#039;s Democratic Republic</option><option value="117">Latvia</option><option value="118">Lebanon</option><option value="119">Lesotho</option><option value="120">Liberia</option><option value="121">Libyan Arab Jamahiriya</option><option value="122">Liechtenstein</option><option value="123">Lithuania</option><option value="124">Luxembourg</option><option value="125">Macau</option><option value="126">Macedonia, The Former Yugoslav Republic of</option><option value="127">Madagascar</option><option value="128">Malawi</option><option value="129">Malaysia</option><option value="130">Maldives</option><option value="131">Mali</option><option value="132">Malta</option><option value="133">Marshall Islands</option><option value="134">Martinique</option><option value="135">Mauritania</option><option value="136">Mauritius</option><option value="137">Mayotte</option><option value="138">Mexico</option><option value="139">Micronesia, Federated States of</option><option value="140">Moldova, Republic of</option><option value="141">Monaco</option><option value="142">Mongolia</option><option value="143">Montserrat</option><option value="144">Morocco</option><option value="145">Mozambique</option><option value="146">Myanmar</option><option value="147">Namibia</option><option value="148">Nauru</option><option value="149">Nepal</option><option value="150">Netherlands</option><option value="151">Netherlands Antilles</option><option value="152">New Caledonia</option><option value="153">New Zealand</option><option value="154">Nicaragua</option><option value="155">Niger</option><option value="156">Nigeria</option><option value="157">Niue</option><option value="158">Norfolk Island</option><option value="159">Northern Mariana Islands</option><option value="160">Norway</option><option value="161">Oman</option><option value="162">Pakistan</option><option value="163">Palau</option><option value="164">Panama</option><option value="165">Papua New Guinea</option><option value="166">Paraguay</option><option value="167">Peru</option><option value="168">Philippines</option><option value="169">Pitcairn</option><option value="170">Poland</option><option value="171">Portugal</option><option value="172">Puerto Rico</option><option value="173">Qatar</option><option value="174">Reunion</option><option value="175">Romania</option><option value="176">Russian Federation</option><option value="177">Rwanda</option><option value="178">Saint Kitts and Nevis</option><option value="179">Saint Lucia</option><option value="180">Saint Vincent and the Grenadines</option><option value="181">Samoa</option><option value="182">San Marino</option><option value="183">Sao Tome and Principe</option><option value="184">Saudi Arabia</option><option value="185">Senegal</option><option value="186">Seychelles</option><option value="187">Sierra Leone</option><option value="188">Singapore</option><option value="189">Slovakia (Slovak Republic)</option><option value="190">Slovenia</option><option value="191">Solomon Islands</option><option value="192">Somalia</option><option value="193">South Africa</option><option value="194">South Georgia and the South Sandwich Islands</option><option value="195">Spain</option><option value="196">Sri Lanka</option><option value="197">St. Helena</option><option value="198">St. Pierre and Miquelon</option><option value="199">Sudan</option><option value="200">Suriname</option><option value="201">Svalbard and Jan Mayen Islands</option><option value="202">Swaziland</option><option value="203">Sweden</option><option value="204">Switzerland</option><option value="205">Syrian Arab Republic</option><option value="206">Taiwan</option><option value="207">Tajikistan</option><option value="208">Tanzania, United Republic of</option><option value="209">Thailand</option><option value="210">Togo</option><option value="211">Tokelau</option><option value="212">Tonga</option><option value="213">Trinidad and Tobago</option><option value="214">Tunisia</option><option value="215">Turkey</option><option value="216">Turkmenistan</option><option value="217">Turks and Caicos Islands</option><option value="218">Tuvalu</option><option value="219">Uganda</option><option value="220">Ukraine</option><option value="221">United Arab Emirates</option><option value="222">United Kingdom</option><option value="223">United States</option><option value="224">United States Minor Outlying Islands</option><option value="225">Uruguay</option><option value="226">Uzbekistan</option><option value="227">Vanuatu</option><option value="228">Vatican City State (Holy See)</option><option value="229">Venezuela</option><option value="230">Viet Nam</option><option value="231">Virgin Islands (British)</option><option value="232">Virgin Islands (U.S.)</option><option value="233">Wallis and Futuna Islands</option><option value="234">Western Sahara</option><option value="235">Yemen</option><option value="236">Yugoslavia</option><option value="237">Zaire</option><option value="238">Zambia</option><option value="239">Zimbabwe</option></select></td>
                            </tr>
                            <tr>
                                <td class="infoBoxContent"><br />Zone:<br /><select name="zone_id"><option value="">All Zones</option><option value="80" selected="selected">Baden-Württemberg</option><option value="81">Bayern</option><option value="82">Berlin</option><option value="83">Brandenburg</option><option value="84">Bremen</option><option value="85">Hamburg</option><option value="86">Hessen</option><option value="87">Mecklenburg-Vorpommern</option><option value="79">Niedersachsen</option><option value="88">Nordrhein-Westfalen</option><option value="89">Rheinland-Pfalz</option><option value="90">Saarland</option><option value="91">Sachsen</option><option value="92">Sachsen-Anhalt</option><option value="93">Schleswig-Holstein</option><option value="94">Thüringen</option></select></td>
                            </tr>
                            <tr>
                                <td align="center" class="infoBoxContent"><br /><span class="tdbLink"><button id="tdb1" type="submit">Save</button></span><script type="text/javascript">$("#tdb1").button({icons:{primary:"ui-icon-disk"}}).addClass("ui-priority-primary").parent().removeClass("tdbLink");</script><span class="tdbLink"><a id="tdb2" href="http://localhost/oscommerce2/admin/geo_zones.php?zpage=1&zID=13&action=list&spage=1&sID=12">Cancel</a></span><script type="text/javascript">$("#tdb2").button({icons:{primary:"ui-icon-close"}}).addClass("ui-priority-secondary").parent().removeClass("tdbLink");</script></td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
        </table></td>
    </tr>
</table>