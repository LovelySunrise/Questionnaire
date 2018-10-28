package com.springmvc.controller;

import java.util.List;

import com.springmvc.model.FormRecord;
import com.springmvc.model.Layout;
import com.springmvc.service.FormRecordService;
import com.springmvc.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    FormRecordService formRecordService;

    @Autowired
    LayoutService layoutService;

    @Autowired
    MessageSource messageSource;

    /**
     * Main form, sql scripts for creating this form stored in db folder in fill_schema file (tested on MySql)
     * Generates form and put it into the index.jsp page
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String startPage(ModelMap model) {
        String layout = layoutService.getHtmlViewByName("startPage");
        model.addAttribute("generatedHtmlLayout", layout);
        return "index";
    }

    /**
     * Url for saving records from the main form
     * Accepts post requests with form filled parameters
     * @param name - Name input of the main form
     * @param surname - Surname input of the main form
     * @param nickname - Nickname input of the main form
     * @param day - Day select input of the main form
     * @return 1 - if record has been saved, 0 - if not
     */
    @RequestMapping(value = { "/saveStartPageFormData" }, method = RequestMethod.POST)
    public @ResponseBody String saveEmployee(@RequestParam("name") String name,
                                             @RequestParam("surname") String surname,
                                             @RequestParam("nickname") String nickname,
                                             @RequestParam("day") String day){
        FormRecord formRecord = new FormRecord();
        Layout layout = layoutService.findByName("startPage");
        if(layout!=null) {
            formRecord.setLayoutId(layout.getId());
            formRecord.setValue("Name: "+name+"; Surname: "+surname+"; Nickname: "+nickname+"; Favourite day: "+day);
            formRecordService.saveFormRecord(formRecord);
            return "1";
        }
        return "0";
    }

    /**
     * Shows all stored records (form submitted data)
     */
    @RequestMapping(value = { "/list", "/show" }, method = RequestMethod.GET)
    public String listElements(ModelMap model) {
        List<FormRecord> formRecords = formRecordService.findAll();
        model.addAttribute("records", formRecords);
        return "list";
    }
}
