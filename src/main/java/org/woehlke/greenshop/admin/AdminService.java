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
import org.woehlke.greenshop.customer.entities.AddressFormat;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.entities.Zone;
import org.woehlke.greenshop.customer.model.CustomerBean;

import java.util.List;
import java.util.Map;

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

}
