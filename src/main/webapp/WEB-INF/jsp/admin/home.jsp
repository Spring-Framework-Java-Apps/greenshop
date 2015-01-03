<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<table border="0" width="100%" cellspacing="0" cellpadding="2">
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="2" height="40">
            <tr>
                <td class="pageHeading">Greenshop</td>


            </tr>
        </table></td>
    </tr>
    <tr>
        <td><table border="0" width="100%" cellspacing="0" cellpadding="2">
            <tr>
                <td width="50%" valign="top">
                    <div id="d_total_revenue" style="width: 100%; height: 150px;"></div>
                    <script type="text/javascript">
                        $(function () {
                            var plot30 = [[1417734000000, 0],[1417820400000, 0],[1417906800000, 0],[1417993200000, 0],[1418079600000, 0],[1418166000000, 0],[1418252400000, 0],[1418338800000, 0],[1418425200000, 0],[1418511600000, 0],[1418598000000, 0],[1418684400000, 0],[1418770800000, 0],[1418857200000, 0],[1418943600000, 0],[1419030000000, 0],[1419116400000, 0],[1419202800000, 0],[1419289200000, 0],[1419375600000, 0],[1419462000000, 0],[1419548400000, 0],[1419634800000, 0],[1419721200000, 0],[1419807600000, 0],[1419894000000, 504.9900],[1419980400000, 0],[1420066800000, 2759.9600],[1420153200000, 0],[1420239600000, 0]];
                            $.plot($('#d_total_revenue'), [ {
                                label: 'Total Revenue',
                                data: plot30,
                                lines: { show: true, fill: true },
                                points: { show: true },
                                color: '#66CC33'
                            }], {
                                xaxis: {
                                    ticks: 4,
                                    mode: 'time'
                                },
                                yaxis: {
                                    ticks: 3,
                                    min: 0
                                },
                                grid: {
                                    backgroundColor: { colors: ['#fff', '#eee'] },
                                    hoverable: true
                                },
                                legend: {
                                    labelFormatter: function(label, series) {
                                        return '<a href="http://shadowfax/oscommerce2/admin/orders.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">' + label + '</a>';
                                    }
                                }
                            });
                        });

                        function showTooltip(x, y, contents) {
                            $('<div id="tooltip">' + contents + '</div>').css( {
                                position: 'absolute',
                                display: 'none',
                                top: y + 5,
                                left: x + 5,
                                border: '1px solid #fdd',
                                padding: '2px',
                                backgroundColor: '#fee',
                                opacity: 0.80
                            }).appendTo('body').fadeIn(200);
                        }

                        var monthNames = [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ];

                        var previousPoint = null;
                        $('#d_total_revenue').bind('plothover', function (event, pos, item) {
                            if (item) {
                                if (previousPoint != item.datapoint) {
                                    previousPoint = item.datapoint;

                                    $('#tooltip').remove();
                                    var x = item.datapoint[0],
                                            y = item.datapoint[1],
                                            xdate = new Date(x);

                                    showTooltip(item.pageX, item.pageY, y + ' for ' + monthNames[xdate.getMonth()] + '-' + xdate.getDate());
                                }
                            } else {
                                $('#tooltip').remove();
                                previousPoint = null;
                            }
                        });
                    </script>            </td>
                <td width="50%" valign="top">
                    <div id="d_total_customers" style="width: 100%; height: 150px;"></div>
                    <script type="text/javascript">
                        $(function () {
                            var plot30 = [[1417734000000, 0],[1417820400000, 0],[1417906800000, 0],[1417993200000, 0],[1418079600000, 0],[1418166000000, 0],[1418252400000, 0],[1418338800000, 0],[1418425200000, 0],[1418511600000, 0],[1418598000000, 0],[1418684400000, 0],[1418770800000, 0],[1418857200000, 0],[1418943600000, 0],[1419030000000, 0],[1419116400000, 0],[1419202800000, 0],[1419289200000, 0],[1419375600000, 0],[1419462000000, 0],[1419548400000, 0],[1419634800000, 0],[1419721200000, 0],[1419807600000, 0],[1419894000000, 4],[1419980400000, 17],[1420066800000, 19],[1420153200000, 0],[1420239600000, 3]];
                            $.plot($('#d_total_customers'), [ {
                                label: 'Total Customers',
                                data: plot30,
                                lines: { show: true, fill: true },
                                points: { show: true },
                                color: '#FF9966'
                            }], {
                                xaxis: {
                                    ticks: 4,
                                    mode: 'time'
                                },
                                yaxis: {
                                    ticks: 3,
                                    min: 0
                                },
                                grid: {
                                    backgroundColor: { colors: ['#fff', '#eee'] },
                                    hoverable: true
                                },
                                legend: {
                                    labelFormatter: function(label, series) {
                                        return '<a href="http://shadowfax/oscommerce2/admin/customers.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">' + label + '</a>';
                                    }
                                }
                            });
                        });

                        function showTooltip(x, y, contents) {
                            $('<div id="tooltip">' + contents + '</div>').css( {
                                position: 'absolute',
                                display: 'none',
                                top: y + 5,
                                left: x + 5,
                                border: '1px solid #fdd',
                                padding: '2px',
                                backgroundColor: '#fee',
                                opacity: 0.80
                            }).appendTo('body').fadeIn(200);
                        }

                        var monthNames = [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ];

                        var previousPoint = null;
                        $('#d_total_customers').bind('plothover', function (event, pos, item) {
                            if (item) {
                                if (previousPoint != item.datapoint) {
                                    previousPoint = item.datapoint;

                                    $('#tooltip').remove();
                                    var x = item.datapoint[0],
                                            y = item.datapoint[1],
                                            xdate = new Date(x);

                                    showTooltip(item.pageX, item.pageY, y + ' for ' + monthNames[xdate.getMonth()] + '-' + xdate.getDate());
                                }
                            } else {
                                $('#tooltip').remove();
                                previousPoint = null;
                            }
                        });
                    </script>            </td>
            </tr>
            <tr>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent">Orders</td>    <td class="dataTableHeadingContent">Total</td>    <td class="dataTableHeadingContent">Date</td>    <td class="dataTableHeadingContent">Status</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/orders.php?oID=3&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">JavaTest</a></td>    <td class="dataTableContent">$1254.98</td>    <td class="dataTableContent">01/01/2015</td>    <td class="dataTableContent">Pending</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/orders.php?oID=2&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">JavaTest</a></td>    <td class="dataTableContent">$1504.98</td>    <td class="dataTableContent">01/01/2015</td>    <td class="dataTableContent">Pending</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/orders.php?oID=1&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">JavaTest</a></td>    <td class="dataTableContent">$504.99</td>    <td class="dataTableContent">12/30/2014</td>    <td class="dataTableContent">Pending</td>  </tr></table>            </td>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent">Customers</td>    <td class="dataTableHeadingContent" align="right">Date</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/customers.php?cID=4&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Java Test</a></td>    <td class="dataTableContent" align="right">12/30/2014</td>  </tr></table>            </td>
            </tr>
            <tr>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent" width="20">&nbsp;</td>    <td class="dataTableHeadingContent">Last Administrator Logins</td>    <td class="dataTableHeadingContent" align="right">Date</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?module=ar_admin_login&aID=18&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">admin</a></td>    <td class="dataTableContent" align="right">01/03/2015</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?module=ar_admin_login&aID=17&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">admin</a></td>    <td class="dataTableContent" align="right">01/01/2015</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?module=ar_admin_login&aID=16&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">admin</a></td>    <td class="dataTableContent" align="right">01/01/2015</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/cross.gif" border="0" alt="" /></td>    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?module=ar_admin_login&aID=15&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">dgsvcgsvdchgds</a></td>    <td class="dataTableContent" align="right">12/31/2014</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?module=ar_admin_login&aID=14&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">admin</a></td>    <td class="dataTableContent" align="right">12/31/2014</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent" align="center"><img src="resources/admin/images/icons/tick.gif" border="0" alt="" /></td>    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?module=ar_admin_login&aID=13&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">admin</a></td>    <td class="dataTableContent" align="right">12/31/2014</td>  </tr></table>            </td>
                <td width="50%" valign="top">
                    <div class="secWarning"><p class="smallText">I am able to write to the configuration file: /opt/local/apache2/htdocs_typo3_62/oscommerce2/includes/configure.php. This is a potential security risk - please set the right user permissions on this file.</p><p class="smallText">Installation directory exists at: /opt/local/apache2/htdocs_typo3_62/oscommerce2/install. Please remove this directory for security reasons.</p></div>            </td>
            </tr>
            <tr>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent">Lastest News</td>    <td class="dataTableHeadingContent" align="right">Date</td>  </tr>  <tr class="dataTableRow">    <td class="dataTableContent" colspan="2">Could not connect to the osCommerce News feed. The next attempt will be performed within 24 hours.</td>  </tr>  <tr class="dataTableRow">    <td class="dataTableContent" align="right" colspan="2"><a href="http://www.oscommerce.com/newsletter/subscribe" target="_blank"><img src="resources/admin/images/icon_newsletter.png" border="0" alt="Sign-Up for the osCommerce Newsletter" title="Sign-Up for the osCommerce Newsletter" /></a>&nbsp;<a href="http://www.facebook.com/pages/osCommerce/33387373079" target="_blank"><img src="resources/admin/images/icon_facebook.png" border="0" alt="Become an osCommerce Fan on Facebook" title="Become an osCommerce Fan on Facebook" /></a>&nbsp;<a href="http://twitter.com/osCommerce" target="_blank"><img src="resources/admin/images/icon_twitter.png" border="0" alt="Follow osCommerce on Twitter" title="Follow osCommerce on Twitter" /></a>&nbsp;<a href="http://feeds.feedburner.com/osCommerceNewsAndBlogs" target="_blank"><img src="resources/admin/images/icon_rss.png" border="0" alt="Subscribe to the osCommerce News RSS Feed" title="Subscribe to the osCommerce News RSS Feed" /></a></td>  </tr></table>            </td>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent">Lastest Add-Ons</td>    <td class="dataTableHeadingContent" align="right">Date</td>  </tr>  <tr class="dataTableRow">    <td class="dataTableContent" colspan="2">Could not connect to the osCommerce Add-Ons feed. The next attempt will be performed within 24 hours.</td>  </tr>  <tr class="dataTableRow">    <td class="dataTableContent" align="right" colspan="2"><a href="http://feeds.feedburner.com/osCommerce_Contributions" target="_blank"><img src="resources/admin/images/icon_rss.png" border="0" alt="Subscribe to the osCommerce Add-Ons RSS Feed" title="Subscribe to the osCommerce Add-Ons RSS Feed" /></a></td>  </tr></table>            </td>
            </tr>
            <tr>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent">Version Check</td>    <td class="dataTableHeadingContent" align="right">Last Checked On</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/version_check.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Check Now</a></td>    <td class="dataTableContent" align="right">Never</td>  </tr></table>            </td>
                <td width="50%" valign="top">
                    <table border="0" width="100%" cellspacing="0" cellpadding="4">  <tr class="dataTableHeadingRow">    <td class="dataTableHeadingContent">Reviews</td>    <td class="dataTableHeadingContent">Date</td>    <td class="dataTableHeadingContent">Reviewer</td>    <td class="dataTableHeadingContent">Rating</td>    <td class="dataTableHeadingContent">Status</td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/reviews.php?rID=2&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Samsung Galaxy Tab</a></td>    <td class="dataTableContent">12/30/2014</td>    <td class="dataTableContent">Java Test</td>    <td class="dataTableContent"><img src="http://shadowfax/oscommerce2/images/stars_1.gif" border="0" alt="" /></td>    <td class="dataTableContent"><img src="resources/admin/images/icon_status_green.gif" border="0" alt="Active" title="Active" width="10" height="10" /></td>  </tr>  <tr class="dataTableRow" onmouseover="rowOverEffect(this);" onmouseout="rowOutEffect(this);">    <td class="dataTableContent"><a href="http://shadowfax/oscommerce2/admin/reviews.php?rID=1&action=edit&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">There's Something About Mary</a></td>    <td class="dataTableContent">12/27/2014</td>    <td class="dataTableContent">John Doe</td>    <td class="dataTableContent"><img src="http://shadowfax/oscommerce2/images/stars_5.gif" border="0" alt="" /></td>    <td class="dataTableContent"><img src="resources/admin/images/icon_status_green.gif" border="0" alt="Active" title="Active" width="10" height="10" /></td>  </tr></table>            </td>
            </tr>
        </table></td>
    </tr>
</table>