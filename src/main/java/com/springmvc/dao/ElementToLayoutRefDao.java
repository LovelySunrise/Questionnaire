package com.springmvc.dao;

import com.springmvc.model.ElementToLayoutRef;

import java.util.List;

public interface ElementToLayoutRefDao {

    ElementToLayoutRef findById(int id);

    List<ElementToLayoutRef> findAllByLayoutId(int id);
}
