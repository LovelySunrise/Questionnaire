package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.ElementDao;
import com.springmvc.model.Element;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("elementDao")
public class ElementDaoImpl extends AbstractDao<Integer, Element> implements ElementDao {

    public Element findById(int id) {
        return getByKey(id);
    }
}
