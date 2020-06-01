package learn.springcloud.configclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springcloud.configclient.dao.CategoryRepo;
import learn.springcloud.configclient.model.Category;

@Controller 
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepoImpl;

    @RequestMapping("/list")
    public String getCategoryList(Model m,@Autowired Authentication authentication) {
        Iterable<Category> iterator = categoryRepoImpl.findAll();
       
        List<Category> lst =  new ArrayList<>();
        iterator.forEach(e->lst.add(e));

        m.addAttribute("categoryList", lst);
        m.addAttribute("userName",authentication.getName());
        // name of view 
        return "categoryList";
    }
}