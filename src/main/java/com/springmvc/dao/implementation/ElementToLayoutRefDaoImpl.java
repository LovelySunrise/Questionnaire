package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.ElementToLayoutRefDao;
import com.springmvc.model.ElementToLayoutRef;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("elementToLayoutRefDao")
public class ElementToLayoutRefDaoImpl extends AbstractDao<Integer, ElementToLayoutRef> implements ElementToLayoutRefDao {

    public ElementToLayoutRef findById(int id) {
        return getByKey(id);
    }

    public List<ElementToLayoutRef> findAllByLayoutId(int id) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(ElementToLayoutRef.class);
        criteria.add(Restrictions.eq("layoutId", id));
        return (List<ElementToLayoutRef>) criteria.list();
    }
}
