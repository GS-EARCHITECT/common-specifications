package specs_mgmt.service;

import java.util.ArrayList;

import specs_mgmt.model.dto.SpecificationDataDTO;
import specs_mgmt.model.dto.SpecificationMasterDTO;

public interface I_SpecificationMasterService
{
    abstract public SpecificationMasterDTO newSpecificationMaster(SpecificationMasterDTO SpecificationMasterDTO);
    abstract public ArrayList<SpecificationMasterDTO> getSpecificationsByFormats(ArrayList<Long> fmSeqNos);
    abstract public ArrayList<SpecificationMasterDTO> getSelectSpecifications(ArrayList<Long> specSeqNos);
    abstract public ArrayList<SpecificationDataDTO> getSpecifications(Long specSeqNo);
    abstract public ArrayList<SpecificationMasterDTO> getAllSpecificationMasters();       
    abstract public SpecificationMasterDTO getSpecificationMasterById(Long documentSeqNo);    
    abstract public void updSpecificationMaster(SpecificationMasterDTO SpecificationMasterDTO);
    abstract public void updSpecificationData(Long specSeqNo, String specString);
    abstract public void updSpecificationDataFromStrings(Long specSeqNo, String[] strings);    
    abstract public void delSpecificationMaster(Long SpecificationSeqNo);
    abstract public void delAllSpecificationMasters();
    abstract public void delSelectSpecificationMasters(ArrayList<Long> SpecificationSeqNos);        
}