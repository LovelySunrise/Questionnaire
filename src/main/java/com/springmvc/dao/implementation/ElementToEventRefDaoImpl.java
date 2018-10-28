package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.ElementToEventRefDao;
import com.springmvc.model.ElementToEventRef;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("elementToEventRefDao")
public class ElementToEventRefDaoImpl extends AbstractDao<Integer, ElementToEventRef> implements ElementToEventRefDao {

    public ElementToEventRef findById(int id){
        return getByKey(id);
    }

    public List<ElementToEventRef> findAllByElementId(int id){
        Session session = getSession();
        Criteria criteria = session.createCriteria(ElementToEventRef.class);
        criteria.add(Restrictions.eq("elementId", id));
        return (List<ElementToEventRef>) criteria.list();
    }
}
