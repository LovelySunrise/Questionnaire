package com.springmvc.service.implementation;

import com.springmvc.dao.LayoutDao;
import com.springmvc.model.Layout;
import com.springmvc.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("layoutService")
@Transactional
public class LayoutServiceImpl implements LayoutService {

    @Autowired
    private LayoutDao dao;

    public Layout findById(int id) {
        return dao.findById(id);
    }

    public Layout findByName(String name) {
        return dao.findByName(name);
    }
}
