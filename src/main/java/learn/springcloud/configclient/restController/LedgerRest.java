package learn.springcloud.configclient.restController;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.springcloud.configclient.dao.LedgerRepo;
import learn.springcloud.configclient.model.Category;
import learn.springcloud.configclient.model.Ledger;

@RestController
@RequestMapping("ledgerApi")
@CrossOrigin
public class LedgerRest {
    
    @Autowired
    LedgerRepo ledgerRepoImpl;

    @PostMapping("addLedger")
    public String addLedger(@RequestParam Long categoryId, @RequestParam Long amount) {
        Ledger entity = new Ledger();
        entity.setAmount(amount);
        Category category=new Category();
        category.setId(categoryId);
        entity.setCategory(category);
        entity=  ledgerRepoImpl.save(entity);
         
        return "success with Id : " +entity.getId();
    }

    @DeleteMapping("deleteLedger")
    public String deleteLedger(@NotNull @RequestParam Long id) { 
         ledgerRepoImpl.deleteById(id); 
        return "success with Id : " +id;
    }
    
}