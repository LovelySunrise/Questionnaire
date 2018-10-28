package com.springmvc.dao;

import com.springmvc.model.Element;

import java.util.List;

public interface ElementDao {

    Element findById(int id);

    List<Element> findAll();
}
