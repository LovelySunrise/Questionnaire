package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.FormRecordDao;
import com.springmvc.model.FormRecord;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("formRecordDao")
public class FormRecordDaoImpl  extends AbstractDao<Integer, FormRecord> implements FormRecordDao {

    public FormRecord findById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<FormRecord> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<FormRecord>) criteria.list();
    }

    public void saveFormRecord(FormRecord formRecord){
        persist(formRecord);
    }
}
