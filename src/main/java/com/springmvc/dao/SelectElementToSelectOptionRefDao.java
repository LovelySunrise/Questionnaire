package com.springmvc.dao;

import com.springmvc.model.SelectElementToSelectOptionRef;

import java.util.List;

public interface SelectElementToSelectOptionRefDao {

    SelectElementToSelectOptionRef findById(int id);

    List<SelectElementToSelectOptionRef> findAllBySelectElementId(int id);
}
