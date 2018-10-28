package com.springmvc.service;

import com.springmvc.model.Element;

import java.util.List;

public interface ElementService {

    Element findById(int id);

    String getHtmlViewById(int id);
}
