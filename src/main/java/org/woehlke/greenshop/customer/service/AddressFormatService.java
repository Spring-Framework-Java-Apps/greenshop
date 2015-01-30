package org.woehlke.greenshop.customer.service;

import org.woehlke.greenshop.customer.entities.AddressFormat;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface AddressFormatService {

    List<AddressFormat> findAllAddressFormat();
}
