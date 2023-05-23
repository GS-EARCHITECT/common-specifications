package specs_mgmt.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import specs_mgmt.model.master.SpecificationFormatMaster;

@Repository("specFormatRepo")
public interface SpecificationFormatMasterRepo extends CrudRepository<SpecificationFormatMaster, Long> 
{      
 } 
