package learn.springcloud.configclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.springcloud.configclient.dao.LedgerRepo;
import learn.springcloud.configclient.model.Category;
import learn.springcloud.configclient.model.Ledger;

@Controller
@RestController
public class LedgerController {
    @Autowired
    LedgerRepo ledgerRepoImpl;

    @RequestMapping("/ledgerList")
    public String getCategoryList(Model m) {
        Iterable<Ledger> iterator = ledgerRepoImpl.findAll();

        List<Ledger> lst = new ArrayList<>();
        iterator.forEach(e -> lst.add(e));

        m.addAttribute("ledgerList", lst);
        // name of view
        return "ledgerList";
    }

    @PostMapping("/addLedger")
    public String addLedger(@RequestParam Long categoryId, @RequestParam Long amount) {
        Ledger entity = new Ledger();
        entity.setAmount(amount);
        Category category=new Category();
        category.setId(categoryId);
        entity.setCategory(category);
        entity=  ledgerRepoImpl.save(entity);
        
        // name of view 
        return "success with Id : " +entity.getId();
    }
}