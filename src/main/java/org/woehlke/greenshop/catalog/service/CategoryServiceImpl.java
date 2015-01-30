package org.woehlke.greenshop.catalog.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * Created by tw on 30.01.15.
 */
@Named("categoryService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {
}
