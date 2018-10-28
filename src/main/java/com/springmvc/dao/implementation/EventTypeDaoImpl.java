package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.EventTypeDao;
import com.springmvc.model.EventType;
import org.springframework.stereotype.Repository;

@Repository("eventTypeDao")
public class EventTypeDaoImpl extends AbstractDao<Integer, EventType> implements EventTypeDao{

    public EventType findById(int id) {
        return getByKey(id);
    }
}
