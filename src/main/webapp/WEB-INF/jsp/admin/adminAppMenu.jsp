<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div id="adminAppMenu">

    <h3><a href="#">Configuration</a></h3>
    <div>
    <ul>
        <li><a href="<c:url value="/admin/administrators"/>">Administrators</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/store_logo.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Store Logo</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=1&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">My Store</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=2&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Minimum Values</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=3&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Maximum Values</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=4&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Images</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=5&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Customer Details</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=7&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Shipping/Packaging</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=8&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Product Listing</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=9&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Stock</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=10&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Logging</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=11&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Cache</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=12&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">E-Mail Options</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=13&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Download</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=14&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">GZip Compression</a></li>
        <li><a href="http://shadowfax/oscommerce2/admin/configuration.php?gID=15&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Sessions</a></li>
    </ul>
    </div>
    <h3><a href="#">Catalog</a></h3>
    <div>
        <ul>
            <li><a href="<c:url value="/admin/categories"/>">Categories/Products</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/products_attributes.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Products Attributes</a></li>
            <li><a href="<c:url value="/admin/manufacturers"/>">Manufacturers</a></li>
            <li><a href="<c:url value="/admin/reviews"/>">Reviews</a></li>
            <li><a href="<c:url value="/admin/specials"/>">Specials</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/products_expected.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Products Expected</a></li>
        </ul>
    </div>
    <h3><a href="#">Modules</a></h3>
    <div>
        <ul>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=action_recorder&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Action Recorder</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=boxes&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Boxes</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=dashboard&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Dashboard</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=header_tags&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Header Tags</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=order_total&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Order Total</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=payment&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Payment</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=shipping&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Shipping</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/modules.php?set=social_bookmarks&osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Social Bookmarks</a></li>
        </ul>
    </div>
    <h3><a href="#">Customers</a></h3>
    <div>
        <ul>
            <li><a href="<c:url value="/admin/customers"/>">Customers</a></li>
            <li><a href="<c:url value="/admin/orders"/>">Orders</a></li>
        </ul>
    </div>
    <h3><a href="#">Locations / Taxes</a></h3>
    <div>
        <ul>
            <li><a href="<c:url value="/admin/countries"/>">Countries</a></li>
            <li><a href="<c:url value="/admin/zones"/>">Zones</a></li>
            <li><a href="<c:url value="/admin/taxZones"/>">Tax Zones</a></li>
            <li><a href="<c:url value="/admin/taxClasses"/>">Tax Classes</a></li>
            <li><a href="<c:url value="/admin/taxRates"/>">Tax Rates</a></li>
        </ul>
    </div>
    <h3><a href="#">Localization</a></h3>
    <div>
        <ul>
            <li><a href="<c:url value="/admin/currencies"/>">Currencies</a></li>
            <li><a href="<c:url value="/admin/languages"/>">Languages</a></li>
            <li><a href="<c:url value="/admin/ordersStatus"/>">Orders Status</a></li>
        </ul>
    </div>
    <h3><a href="#">Reports</a></h3>
    <div>
        <ul>
            <li><a href="<c:url value="/admin/productsViewed"/>">Products Viewed</a></li>
            <li><a href="<c:url value="/admin/productsPurchased"/>">Products Purchased</a></li>
            <li><a href="<c:url value="/admin/customerOrdersTotal"/>">Customer Orders-Total</a></li>
        </ul>
    </div>
    <h3><a href="#">Tools</a></h3>
    <div>
        <ul>
            <li><a href="http://shadowfax/oscommerce2/admin/action_recorder.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Action Recorder</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/backup.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Database Backup</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/banner_manager.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Banner Manager</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/cache.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Cache Control</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/define_language.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Define Languages</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/mail.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Send Email</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/newsletters.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Newsletter Manager</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/sec_dir_permissions.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Security Directory Permissions</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/server_info.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Server Info</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/version_check.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Version Checker</a></li>
            <li><a href="http://shadowfax/oscommerce2/admin/whos_online.php?osCAdminID=i3qmbf2bulfaigi6pvm3i2urp1">Who's Online</a></li>
        </ul>
    </div>

</div>

<script type="text/javascript">
    $('#adminAppMenu').accordion({
        autoHeight: false,
        icons: {
            'header': 'ui-icon-plus',
            'headerSelected': 'ui-icon-minus'
        }
        ,active: <c:out value="${menuCategory}"/>
    });
</script>