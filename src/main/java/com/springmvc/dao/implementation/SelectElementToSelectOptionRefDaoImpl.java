package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.SelectElementToSelectOptionRefDao;
import com.springmvc.model.SelectElementToSelectOptionRef;
import com.springmvc.model.SelectOption;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("selectElementToSelectOptionRefDao")
public class SelectElementToSelectOptionRefDaoImpl extends AbstractDao<Integer, SelectElementToSelectOptionRef> implements SelectElementToSelectOptionRefDao {

    public SelectElementToSelectOptionRef findById(int id){
        return getByKey(id);
    }

    public List<SelectElementToSelectOptionRef> findAllBySelectElementId(int id){
        Session session = getSession();
        Criteria criteria = session.createCriteria(SelectElementToSelectOptionRef.class);
        criteria.add(Restrictions.eq("elementId", id));
        return (List<SelectElementToSelectOptionRef>) criteria.list();
    }
}
