package specs_mgmt.service;

import java.util.ArrayList;
import specs_mgmt.model.dto.SpecificationFormatMasterDTO;

public interface I_SpecificationFormatMasterService 
{
	abstract public SpecificationFormatMasterDTO newSpecificationFormatMaster(SpecificationFormatMasterDTO emailFormatMasterDTO);
	abstract public ArrayList<SpecificationFormatMasterDTO> getAllSpecificationFormatMaster();
	abstract public SpecificationFormatMasterDTO getSpecificationFormatMasterById(Long specSeqNo);
	abstract public void updSpecificationFormatMaster(SpecificationFormatMasterDTO SpecificationFormatMasterDTO);
	abstract public void delSpecificationFormatMaster(Long id);
	abstract public void delAllSpecificationFormatMaster();
}