package org.woehlke.greenshop.oodm.customer.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.customer.entities.AddressFormat;
import org.woehlke.greenshop.oodm.customer.repository.AddressFormatRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("addressFormatService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class AddressFormatServiceImpl implements AddressFormatService {

    @Inject
    private AddressFormatRepository addressFormatRepository;

    @Override
    public List<AddressFormat> findAllAddressFormat() {
        return addressFormatRepository.findAll();
    }
}
