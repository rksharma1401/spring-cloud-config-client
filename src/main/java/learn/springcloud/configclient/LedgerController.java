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
    LedgerRepo ledgerRepoImpl;

    @RequestMapping("/ledgerList")
    public String getCategoryList(Model m) {
        Iterable<Ledger> iterator = ledgerRepoImpl.findAll();

        List<Ledger> lst = new ArrayList<>();
        long totalAdded =0; 
        long totalWithdrawn =0; 
        String category="";
        for(Ledger e : iterator) {
            lst.add(e) ;
            category=e.getCategory().getCategoryName();
            if(e.getAmount()>=0){
             totalAdded+=e.getAmount();
            }else{ 
              totalWithdrawn+= (Math.abs(e.getAmount()));
            }
        }
        m.addAttribute("ledgerList", lst);

        m.addAttribute("totalAdded", "Added to "+category+" : "+ totalAdded);
        m.addAttribute("totalWithdrawn","Added back to bank : " + totalWithdrawn);
        // name of view
        return "ledgerList";
    }
 
}