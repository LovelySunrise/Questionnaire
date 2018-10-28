package com.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.springmvc.model.Layout;
import com.springmvc.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Element;
import com.springmvc.service.ElementService;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    ElementService service;

    @Autowired
    LayoutService layoutService;

    @Autowired
    MessageSource messageSource;

    /*
     * This method will list all existing elements.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listElements(ModelMap model) {

//        List<Element> elements = service.findAll();
//        model.addAttribute("elements", elements);

        Layout layout = layoutService.findByName("hello");
        model.addAttribute("elements", layout);
        return "index";
    }


}
