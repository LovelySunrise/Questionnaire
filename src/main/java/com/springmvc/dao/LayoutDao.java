package com.springmvc.dao;

import com.springmvc.model.Layout;

public interface LayoutDao {

    Layout findById(int id);

    Layout findByName(String name);
}
