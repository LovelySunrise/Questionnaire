package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.CssClassDao;
import com.springmvc.model.CssClass;
import org.springframework.stereotype.Repository;

@Repository("cssClassDao")
public class CssClassDaoImpl extends AbstractDao<Integer, CssClass> implements CssClassDao {

    public CssClass findById(int id) {
        return getByKey(id);
    }
}
