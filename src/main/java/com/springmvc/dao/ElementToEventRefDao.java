package com.springmvc.dao;

import com.springmvc.model.ElementToEventRef;

import java.util.List;

public interface ElementToEventRefDao {

    ElementToEventRef findById(int id);

    List<ElementToEventRef> findAllByElementId(int id);
}
