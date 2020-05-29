package learn.springcloud.configclient;
 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springcloud.configclient.dao.LedgerRepo;
import learn.springcloud.configclient.model.Ledger;
 

@Controller
public class LedgerController {
    @Autowired
    LedgerRepo LedgerRepoImpl;

    @RequestMapping("/categoryList")
    public String getCategoryList(Model m) {
        Iterable<Ledger> iterator = LedgerRepoImpl.findAll();
       
        List<Ledger> lst =  new ArrayList<>();
        iterator.forEach(e->lst.add(e));

        m.addAttribute("ledgerList", lst);
        // name of view 
        return "ledgerList";
    }
}