package org.woehlke.greenshop.admin;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.woehlke.greenshop.admin.entities.*;
import org.woehlke.greenshop.admin.model.OrderAdminBean;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.Special;
import org.woehlke.greenshop.catalog.model.ReviewProduct;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderStatusId;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.entities.Zone;
import org.woehlke.greenshop.customer.model.CustomerBean;

import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
public interface AdminService extends UserDetailsService {

    List<Manufacturer> getAllManufacturers();

    int countProductsOfThisManufacturer(Manufacturer thisManufacturer);

    Manufacturer getManufacturerById(long manufacturerId);

    void updateSpecial(Special special);

    ReviewProduct getReviewById(long reviewId, Language language);

    List<Administrator> findAllAdministrators();

    Administrator findAdministratorById(long administratorId);

    List<TaxClass> findAllTaxClasses();

    TaxClass findTaxClassById(long taxClassId);

    List<TaxRate> findAllTaxRates();

    TaxRate findTaxRateById(long taxRateId);

    List<TaxZone> findAllTaxZones();

    TaxZone findTaxZoneById(long taxZoneId);

    List<Language> findAllLanguages();

    Language findLanguageById(long languageId);

    List<OrderStatus> findAllOrderStatuses(Language language);

    OrderStatus findOrderStatusById(OrderStatusId ordersStatusId);

    List<CustomerBean> findAllCustomers();

    int getNumberOfReviewsForCustomer(Customer customer);

    CustomerBean getCustomerById(long customerId);

    List<OrderAdminBean> getAllOrders(Language language);

    OrderAdminBean findOrderById(long orderId, Language language);

    List<ProductDescription> findProductsViewed(Language language);

    List<ProductDescription> findProductsByCategoryId(long categoryId, Language language);

    void setProductActive(long productId);

    void setProductInactive(long productId);

    List<TaxZone2Zone> findZonesByTaxZone(TaxZone thisTaxZone);

    TaxZone2Zone findTaxZone2ZoneById(long zoneId);

    int getNumberOfZonesForTaxZone(TaxZone thisTaxZone);
}
