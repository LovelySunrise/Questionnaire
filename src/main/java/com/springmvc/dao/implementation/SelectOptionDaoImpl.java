package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.SelectOptionDao;
import com.springmvc.model.SelectOption;
import org.springframework.stereotype.Repository;

@Repository("selectOptionDao")
public class SelectOptionDaoImpl extends AbstractDao<Integer, SelectOption> implements SelectOptionDao {

    public SelectOption findById(int id) {
        return getByKey(id);
    }
}
