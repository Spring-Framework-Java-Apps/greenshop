package org.woehlke.greenshop.oodm.admin.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.admin.entities.Administrator;
import org.woehlke.greenshop.oodm.admin.model.AdministratorBean;
import org.woehlke.greenshop.oodm.admin.repository.AdministratorRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("administratorService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class AdministratorServiceImpl implements AdministratorService {

    @Inject
    private AdministratorRepository administratorRepository;

    @Inject
    private PasswordEncoder encoder;

    @Override
    public List<Administrator> findAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator findAdministratorById(long administratorId) {
        return administratorRepository.findOne(administratorId);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void update(Administrator thisAdministrator) {
        Administrator original = administratorRepository.findOne(thisAdministrator.getId());
        if(original.getUserPassword().compareTo(thisAdministrator.getUserPassword())!=0){
            thisAdministrator.setUserPassword(encoder.encode(thisAdministrator.getUserPassword()));
        }
        thisAdministrator = administratorRepository.save(thisAdministrator);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void create(Administrator thisAdministrator) {
        thisAdministrator.setUserPassword(encoder.encode(thisAdministrator.getUserPassword()));
        thisAdministrator = administratorRepository.save(thisAdministrator);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void delete(Administrator thisAdministrator) {
        administratorRepository.delete(thisAdministrator);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUserName(username);
        if(administrator == null) throw new UsernameNotFoundException(username);
        return new AdministratorBean(administrator);
    }

    /*
    private String md5(String input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(input.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
    */
}
