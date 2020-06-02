package learn.springcloud.configclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import learn.springcloud.configclient.dao.CategoryRepo;
import learn.springcloud.configclient.model.Category;

@Controller 
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepoImpl;

    @RequestMapping("/addCategory")
    public String addCategory(Model m,@RequestParam String categortyId,@RequestParam String categoryName) {
        Category entity=new Category(Long.parseLong(categortyId), categoryName);
        categoryRepoImpl.save(entity);
        // name of view 
    return "categoryList";
    }
    @RequestMapping("/list")
    public String getCategoryList(Model m,@Autowired Authentication authentication) {
        Iterable<Category> iterator = categoryRepoImpl.findAll();
       
        List<Category> lst =  new ArrayList<>();
        iterator.forEach(e->lst.add(e));

        m.addAttribute("categoryList", lst);
        if(authentication!=null)
            m.addAttribute("userName",authentication.getName());
        // name of view 
        return "categoryList";
    }
}