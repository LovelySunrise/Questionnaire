package com.springmvc.dao;

import com.springmvc.model.FormRecord;

import java.util.List;

public interface FormRecordDao {

    FormRecord findById(int id);

    List<FormRecord> findAll();

    void saveFormRecord(FormRecord formRecord);
}
