package specs_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import specs_mgmt.model.master.SpecificationMaster;

@Repository("specMasterRepo")
public interface SpecificationMasterRepo extends CrudRepository<SpecificationMaster, Long> 
{
	@Query(value = "SELECT * FROM SPECIFICATION_MASTER a WHERE a.SPECIFICATION_FORMAT_SEQ_NO in :fmSeqNos order by SPECIFICATION_SEQ_NO", nativeQuery = true)
	ArrayList<SpecificationMaster> getSpecificationsByFormats(@Param("fmSeqNos") ArrayList<Long> fmSeqNos);

	@Query(value = "SELECT * FROM SPECIFICATION_MASTER a WHERE a.SPECIFICATION_SEQ_NO in :specSeqNos order by SPECIFICATION_SEQ_NO", nativeQuery = true)
	ArrayList<SpecificationMaster> getSelectSpecifications(@Param("specSeqNos") ArrayList<Long> specSeqNos);

	@Query(value = "update SPECIFICATION_MASTER set specification = :specString WHERE a.SPECIFICATION_SEQ_NO = :specSeqNo", nativeQuery = true)
	ArrayList<SpecificationMaster> updSpecificationData(@Param("specSeqNo") Long specSeqNo, @Param("specString") String specString);
	
	@Query(value = "DELETE FROM SPECIFICATION_MASTER a WHERE a.spec_seq_no in :ids", nativeQuery = true)
	void delSelectSpecifications(@Param("ids") ArrayList<Long> ids);
}
