package com.springmvc.service;

import com.springmvc.model.Layout;

public interface LayoutService {

    Layout findById(int id);

    Layout findByName(String name);

    String getHtmlViewById(int id);

    String getHtmlViewByName(String name);
}
