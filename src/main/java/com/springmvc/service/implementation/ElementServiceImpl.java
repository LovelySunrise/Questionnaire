package com.springmvc.service.implementation;

import com.springmvc.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.ElementDao;
import com.springmvc.model.Element;

import java.util.List;

@Service("elementService")
@Transactional
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementDao dao;

    public Element findById(int id) {
        return dao.findById(id);
    }

    public List<Element> findAll() {
        return dao.findAll();
    }
}
