package com.springmvc.service.implementation;

import com.springmvc.dao.FormRecordDao;
import com.springmvc.model.FormRecord;
import com.springmvc.service.FormRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("formRecordService")
@Transactional
public class FormRecordServiceImpl implements FormRecordService {

    @Autowired
    private FormRecordDao formRecordDao;

    public FormRecord findById(int id){
        return formRecordDao.findById(id);
    }

    public List<FormRecord> findAll(){
        return formRecordDao.findAll();
    }

    public void saveFormRecord(FormRecord formRecord){
        formRecordDao.saveFormRecord(formRecord);
    }
}
