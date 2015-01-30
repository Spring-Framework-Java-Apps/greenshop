package org.woehlke.greenshop.admin;

import org.woehlke.greenshop.admin.model.OrderAdminBean;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Special;
import org.woehlke.greenshop.catalog.model.ReviewProduct;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderStatusId;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.model.CustomerBean;

import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
public interface AdminService {

    void updateSpecial(Special special);

    ReviewProduct getReviewById(long reviewId, Language language);

    List<Language> findAllLanguages();

    Language findLanguageById(long languageId);

    List<OrderStatus> findAllOrderStatuses(Language language);

    OrderStatus findOrderStatusById(OrderStatusId ordersStatusId);

    List<CustomerBean> findAllCustomers();

    int getNumberOfReviewsForCustomer(Customer customer);

    CustomerBean getCustomerById(long customerId);

    List<OrderAdminBean> getAllOrders(Language language);

    OrderAdminBean findOrderById(long orderId, Language language);

}
