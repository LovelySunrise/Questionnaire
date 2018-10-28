package com.springmvc.service.implementation;

import com.springmvc.dao.*;
import com.springmvc.model.*;
import com.springmvc.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("elementService")
@Transactional
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementDao elementDao;

    @Autowired
    private CssClassDao cssClassDao;

    @Autowired
    private SelectOptionDao selectOptionDao;

    @Autowired
    private SelectElementToSelectOptionRefDao selectElementToSelectOptionRefDao;

    @Autowired
    private ElementToEventRefDao elementToEventRefDao;

    @Autowired
    private EventTypeDao eventTypeDao;

    @Autowired
    private JavascriptFunctionDao javascriptFunctionDao;

    public Element findById(int id) {
        return elementDao.findById(id);
    }

    public String getHtmlViewById(int id) {
        String htmlResultString = "";

        //for select options
        String selectHtmlSubstring = "";

        Element element = elementDao.findById(id);
        if (element!=null) {
            // TEXT considered to be without properties
            if(!element.getType().equals("TEXT")) {
                htmlResultString += "<" + element.getType() + " ";
                if (element.getClassId() != 0) {
                    CssClass cssClass = cssClassDao.findById(element.getClassId());
                    //adding css class to element
                    htmlResultString += " class=\"" + cssClass.getName() + "\" ";
                }
                if (element.getStyle() != null) {
                    //adding customized style to element
                    htmlResultString += " style=\"" + element.getName() + "\" ";
                }
                if (element.getName() != null) {
                    htmlResultString += " name=\"" + element.getName() + "\" ";
                    //to simplify program name (it's unique in existing form) will be used as html id property
                    htmlResultString += " id=\"" + element.getName() + "\" ";
                }
                // adding mouse events with javascript handler functions
                List<ElementToEventRef> elementToEventRefs = elementToEventRefDao.findAllByElementId(element.getId());
                if (elementToEventRefs != null) {
                    for (ElementToEventRef elementToEventRef : elementToEventRefs) {
                        EventType eventType = eventTypeDao.findById(elementToEventRef.getEventId());
                        JavascriptFunction javascriptFunction = javascriptFunctionDao.findById(elementToEventRef.getFunctionId());
                        htmlResultString += eventType.getName() + "=\"" + javascriptFunction.getValue() + "\" ";
                    }
                }
                // if element is of select type - we should add options in output html string
                if (element.getType().equals("select")) {
                    List<SelectElementToSelectOptionRef> selectElementToSelectOptionRefs = selectElementToSelectOptionRefDao.findAllBySelectElementId(element.getId());
                    for (SelectElementToSelectOptionRef selectElementToSelectOptionRef : selectElementToSelectOptionRefs) {
                        SelectOption selectOption = selectOptionDao.findById(selectElementToSelectOptionRef.getSelectId());
                        selectHtmlSubstring += "<option> " + selectOption.getName() + " <//option>";
                    }
                }
                // adding closing tag
                htmlResultString += "> " + selectHtmlSubstring + " </" + element.getType() + ">";
            }
            else {
                //as there's no need in tag for a text chunk simply putting it in result string
                htmlResultString +=element.getName()+" ";
            }
        }
        return htmlResultString;
    }
}
