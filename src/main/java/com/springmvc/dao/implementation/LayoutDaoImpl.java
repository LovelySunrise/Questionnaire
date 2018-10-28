package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.LayoutDao;
import com.springmvc.model.Layout;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("layoutDao")
public class LayoutDaoImpl extends AbstractDao<Integer, Layout> implements LayoutDao {

    public Layout findById(int id) {
        return getByKey(id);
    }

    public Layout findByName(String name) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Layout.class);
        criteria.add(Restrictions.eq("name", name));
        return (Layout) criteria.uniqueResult();
    }
}
