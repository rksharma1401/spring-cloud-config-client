package learn.springcloud.configclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springcloud.configclient.dao.CategoryRepo;
import learn.springcloud.configclient.model.Category;

@Controller 
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepoImpl;

    @RequestMapping("/category/list")
    public String getCategoryList(Model m) {
        Iterable<Category> iterator = categoryRepoImpl.findAll();
       
        List<Category> lst =  new ArrayList<>();
        iterator.forEach(e->lst.add(e));

        m.addAttribute("categoryList", lst);
        // name of view 
        return "categoryList";
    }
}