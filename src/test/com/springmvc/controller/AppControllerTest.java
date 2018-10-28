package com.springmvc.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.springmvc.model.FormRecord;
import com.springmvc.service.FormRecordService;
import com.springmvc.service.LayoutService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppControllerTest {

    @Mock
    FormRecordService service;

    @Mock
    LayoutService layoutService;

    @InjectMocks
    AppController appController;

    @Spy
    List<FormRecord> records = new ArrayList<>();

    @Spy
    ModelMap model;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        records = getEmployeeList();
    }

    @Test
    public void listEmployees(){
        when(service.findAll()).thenReturn(records);
        Assert.assertEquals(appController.listElements(model), "list");
        Assert.assertEquals(model.get("records"), records);
        verify(service, atLeastOnce()).findAll();
    }

    @Test
    public void newEmployee(){
        when(layoutService.findByName("startPage")).thenReturn(null);
        Assert.assertEquals(appController.saveEmployee("testName","testSurname","testNickname","testDay"), "0");
    }

    public List<FormRecord> getEmployeeList(){
        FormRecord formRecord1 = new FormRecord();
        formRecord1.setId(1);
        formRecord1.setLayoutId(1);
        formRecord1.setValue("test1");

        FormRecord formRecord2 = new FormRecord();
        formRecord2.setId(2);
        formRecord2.setLayoutId(1);
        formRecord2.setValue("test2");

        records.add(formRecord1);
        records.add(formRecord2);
        return records;
    }
}