package com.springmvc.service.implementation;

import com.springmvc.dao.ElementToLayoutRefDao;
import com.springmvc.dao.LayoutDao;
import com.springmvc.model.ElementToLayoutRef;
import com.springmvc.model.Layout;
import com.springmvc.service.ElementService;
import com.springmvc.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("layoutService")
@Transactional
public class LayoutServiceImpl implements LayoutService {

    @Autowired
    private LayoutDao layoutDao;

    @Autowired
    private ElementToLayoutRefDao elementToLayoutRefDao;

    @Autowired
    private ElementService elementService;

    public Layout findById(int id) {
        return layoutDao.findById(id);
    }

    public Layout findByName(String name) {
        return layoutDao.findByName(name);
    }

    public String getHtmlViewById(int id) {
        String htmlResultString = "";
        Layout layout = layoutDao.findById(id);
        if (layout!=null) {
            boolean isForm = layout.getIsForm();
            if (isForm)
                htmlResultString += "<form";
            else
                htmlResultString += "<div";
            if (layout.getName()!=null)
                htmlResultString += " id=\""+layout.getName()+"\"> ";
            else
                htmlResultString += ">";
            List<ElementToLayoutRef> elementToLayoutRefs = elementToLayoutRefDao.findAllByLayoutId(id);
            for (ElementToLayoutRef elementToLayoutRef : elementToLayoutRefs) {
                htmlResultString += elementService.getHtmlViewById(elementToLayoutRef.getElementId());
            }
            if (isForm)
                htmlResultString += " </form>";
            else
                htmlResultString += " </div>";
        }
        return htmlResultString;
    }

    public String getHtmlViewByName(String name) {
        String htmlResultString = "";
        Layout layout = layoutDao.findByName(name);
        if (layout!=null) {
            boolean isForm = layout.getIsForm();
            if (isForm)
                htmlResultString += "<form";
            else
                htmlResultString += "<div";
            if (layout.getName()!=null)
                htmlResultString += " id=\""+layout.getName()+"\"> ";
            else
                htmlResultString += ">";
            if (layout != null) {
                List<ElementToLayoutRef> elementToLayoutRefs = elementToLayoutRefDao.findAllByLayoutId(layout.getId());
                for (ElementToLayoutRef elementToLayoutRef : elementToLayoutRefs) {
                    htmlResultString += elementService.getHtmlViewById(elementToLayoutRef.getElementId());
                }
            }
            if (isForm)
                htmlResultString += " </form>";
            else
                htmlResultString += " </div>";
        }
        return htmlResultString;
    }
}
