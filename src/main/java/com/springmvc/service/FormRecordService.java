package com.springmvc.service;

import com.springmvc.model.FormRecord;

import java.util.List;

public interface FormRecordService {
    FormRecord findById(int id);

    List<FormRecord> findAll();

    void saveFormRecord(FormRecord formRecord);
}
