package specs_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import specs_mgmt.model.dto.SpecificationDataDTO;
import specs_mgmt.model.dto.SpecificationMasterDTO;
import specs_mgmt.model.master.SpecificationFormatMaster;
import specs_mgmt.model.master.SpecificationMaster;
import specs_mgmt.model.repo.SpecificationFormatMasterRepo;
import specs_mgmt.model.repo.SpecificationMasterRepo;

@Service("specMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class SpecificationMasterService implements I_SpecificationMasterService {

	@Autowired
	private SpecificationMasterRepo specMasterRepo;

	@Autowired
	private SpecificationFormatMasterRepo specFormatMasterRepo;
	
	public SpecificationMasterDTO newSpecificationMaster(SpecificationMasterDTO lMasters) {
		SpecificationMaster specMaster = specMasterRepo.save(this.setSpecificationMaster(lMasters));
		lMasters = getSpecificationMasterDTO(specMaster);
		return lMasters;
	}

	public ArrayList<SpecificationMasterDTO> getAllSpecificationMasters() {
		ArrayList<SpecificationMaster> specList = (ArrayList<SpecificationMaster>) specMasterRepo.findAll();
		ArrayList<SpecificationMasterDTO> lMasterss = new ArrayList<SpecificationMasterDTO>();
		lMasterss = specList != null ? this.getSpecificationMasterDTOs(specList) : null;
		return lMasterss;
	}

	public ArrayList<SpecificationMasterDTO> getSelectSpecifications(ArrayList<Long> specSeqNos) {
		ArrayList<SpecificationMaster> lMasters = specMasterRepo.getSelectSpecifications(specSeqNos);
		ArrayList<SpecificationMasterDTO> SpecificationMasterDTOs = new ArrayList<SpecificationMasterDTO>();
		SpecificationMasterDTO SpecificationMasterDTO = null;

		if (lMasters!=null) {
			for (int i = 0; i < lMasters.size(); i++) {
				SpecificationMasterDTO = this.getSpecificationMasterDTO(lMasters.get(i));
				SpecificationMasterDTOs.add(SpecificationMasterDTO);
			}
		}
		return SpecificationMasterDTOs;
	}
	
	public SpecificationMasterDTO getSpecificationMasterById(Long specSeqNo) {
		Optional<SpecificationMaster> specMaster = specMasterRepo.findById(specSeqNo);
		SpecificationMasterDTO lMasters = null;
		if (specMaster.isPresent()) {
			lMasters = specMaster != null ? this.getSpecificationMasterDTO(specMaster.get()) : null;
		}
		return lMasters;
	}


	public ArrayList<SpecificationMasterDTO> getSpecificationsByFormats(ArrayList<Long> fmSeqNos) 
	{
		ArrayList<SpecificationMaster> lMasters = specMasterRepo.getSpecificationsByFormats(fmSeqNos);
		ArrayList<SpecificationMasterDTO> SpecificationMasterDTOs = new ArrayList<SpecificationMasterDTO>();
		SpecificationMasterDTO SpecificationMasterDTO = null;

		if (lMasters!=null) {
			for (int i = 0; i < lMasters.size(); i++) {
				SpecificationMasterDTO = this.getSpecificationMasterDTO(lMasters.get(i));
				SpecificationMasterDTOs.add(SpecificationMasterDTO);
			}
		}
		return SpecificationMasterDTOs;
	}

	public ArrayList<SpecificationDataDTO> getSpecifications(Long specSeqNo) 
	{
		Optional<SpecificationMaster> lMaster = specMasterRepo.findById(specSeqNo);
		Optional<SpecificationFormatMaster> lFormatMaster = null;
		ArrayList<SpecificationDataDTO> specificationDataDTOs = null;
		SpecificationDataDTO specificationDataDTO = null;
		Long formSeqNoLong =(long) 0;
		String specFormat = null;
		String[] strLabels = null;
		String[] strData = null;
		
		if(lMaster.isPresent())
		{
		formSeqNoLong = lMaster.get().getSpecificationFormatSeqNo();
		strData = lMaster.get().getSpecification().split(","); 
		lFormatMaster = specFormatMasterRepo.findById(formSeqNoLong);
		if((lFormatMaster.isPresent()))
		{
		specFormat = lFormatMaster.get().getSpecification_format();
		strLabels = specFormat.split(",");
		specificationDataDTOs = new ArrayList<SpecificationDataDTO>();
		
		for (int i = 0; i < strLabels.length; i++) 
		{
		specificationDataDTO = new SpecificationDataDTO();	
		specificationDataDTO.setSpecLabel(strLabels[i]);
		specificationDataDTO.setSpecData(strData[i]);
		specificationDataDTOs.add(specificationDataDTO);
		}
		}		
		}		
		return specificationDataDTOs;
	}
	
	public void updSpecificationMaster(SpecificationMasterDTO lMaster) 
	{
		SpecificationMaster specMaster = this.setSpecificationMaster(lMaster);
		if (specMasterRepo.existsById(lMaster.getSpecificationSeqNo())) {
			specMaster.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());
			specMasterRepo.save(specMaster);
		}
		return;
	}
	
	public void updSpecificationDataFromStrings(Long specSeqNo, String[] strings) 
	{
		String specData = null;
		if(specMasterRepo.existsById(specSeqNo))
		{
		specData = String.join(",", strings);
		specMasterRepo.updSpecificationData(specSeqNo, specData);
		}				
		return;
	}
	
	public void updSpecificationData(Long specSeqNo, String specString) 
	{
		Optional<SpecificationMaster> specMaster = specMasterRepo.findById(specSeqNo);
		
		if(specMaster.isPresent())
		{		
		specMasterRepo.updSpecificationData(specSeqNo, specString);
		}		
		return;
	}
	
	public void delSpecificationMaster(Long specSeqNo) {
		if (specMasterRepo.existsById(specSeqNo)) {
			specMasterRepo.deleteById(specSeqNo);
		}
		return;
	}

	public void delAllSpecificationMasters() {
		specMasterRepo.deleteAll();
	}

	public void delSelectSpecificationMasters(ArrayList<Long> specSeqNos) {
		if (specSeqNos != null) {
			specMasterRepo.delSelectSpecifications(specSeqNos);
		}
	}

	
	private ArrayList<SpecificationMasterDTO> getSpecificationMasterDTOs(ArrayList<SpecificationMaster> lMasters) {
		SpecificationMasterDTO lDTO = null;
		ArrayList<SpecificationMasterDTO> lMasterDTOs = new ArrayList<SpecificationMasterDTO>();
		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getSpecificationMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private SpecificationMasterDTO getSpecificationMasterDTO(SpecificationMaster lMaster) 
	{		
		SpecificationMasterDTO lDTO = new SpecificationMasterDTO();
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());
		lDTO.setSpecificationFormatSeqNo(lMaster.getSpecificationFormatSeqNo());
		lDTO.setSpecification(lMaster.getSpecification());
		return lDTO;
	}

	private SpecificationMaster setSpecificationMaster(SpecificationMasterDTO lDTO) {
		SpecificationMaster lMaster = new SpecificationMaster();		
		lMaster.setSpecificationFormatSeqNo(lDTO.getSpecificationFormatSeqNo());
		lMaster.setSpecification(lDTO.getSpecification());
		return lMaster;
	}

}