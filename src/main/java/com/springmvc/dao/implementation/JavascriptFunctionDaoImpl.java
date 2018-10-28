package com.springmvc.dao.implementation;

import com.springmvc.dao.AbstractDao;
import com.springmvc.dao.JavascriptFunctionDao;
import com.springmvc.model.JavascriptFunction;
import org.springframework.stereotype.Repository;

@Repository("javascriptFunctionDao")
public class JavascriptFunctionDaoImpl extends AbstractDao<Integer, JavascriptFunction> implements JavascriptFunctionDao {

    public JavascriptFunction findById(int id) {
        return getByKey(id);
    }
}
