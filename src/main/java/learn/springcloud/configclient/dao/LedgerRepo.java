package learn.springcloud.configclient.dao;
   
import org.springframework.data.repository.CrudRepository;

import learn.springcloud.configclient.model.Ledger;

public interface LedgerRepo extends CrudRepository<Ledger, Long> {
  
}