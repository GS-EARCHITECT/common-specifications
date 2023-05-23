package specs_mgmt.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import specs_mgmt.model.dto.SpecificationFormatMasterDTO;
import specs_mgmt.model.master.SpecificationFormatMaster;
import specs_mgmt.model.repo.SpecificationFormatMasterRepo;

@Service("specFormatServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class SpecificationFormatMasterService implements I_SpecificationFormatMasterService {
	@Autowired
	private SpecificationFormatMasterRepo specFormatRepo;

	public SpecificationFormatMasterDTO newSpecificationFormatMaster(SpecificationFormatMasterDTO lDTO) 
	{
		Optional<SpecificationFormatMaster> specMaster = specFormatRepo.findById(lDTO.getSpecificationFormatSeqNo());
		SpecificationFormatMaster specMaster2 = null;
		
		if(!specMaster.isPresent())
		{
		specMaster2 = this.setSpecificationFormatMaster(lDTO);		
		specFormatRepo.save(specMaster2);
		}
		return lDTO;
	}

	public ArrayList<SpecificationFormatMasterDTO> getAllSpecificationFormatMaster() {
		ArrayList<SpecificationFormatMaster> worklistWorkList = (ArrayList<SpecificationFormatMaster>) specFormatRepo.findAll();
		ArrayList<SpecificationFormatMasterDTO> lMasterss = new ArrayList<SpecificationFormatMasterDTO>();
		lMasterss = worklistWorkList != null ? this.getSpecificationFormatMasterDTOs(worklistWorkList) : null;
		return lMasterss;
	}

	public SpecificationFormatMasterDTO getSpecificationFormatMasterById(Long specSeqNo) 
	{
		Optional<SpecificationFormatMaster> SpecificationFormatMaster = specFormatRepo.findById(specSeqNo);
		SpecificationFormatMasterDTO lDTO2 = null;
		if (SpecificationFormatMaster.isPresent()) {
			lDTO2 = SpecificationFormatMaster != null ? this.getSpecificationFormatMasterDTO(SpecificationFormatMaster.get()) : null;
		}
		return lDTO2;
	}

	public void updSpecificationFormatMaster(SpecificationFormatMasterDTO lDTO) 
	{
		Optional<SpecificationFormatMaster> id = specFormatRepo.findById(lDTO.getSpecificationFormatSeqNo());
		SpecificationFormatMaster specMaster = null;
		
		if (id.isPresent()) 
		{		
		specMaster = setSpecificationFormatMaster(lDTO);				
		specMaster.setSpecificationFormatSeqNo(lDTO.getSpecificationFormatSeqNo());
		specFormatRepo.save(specMaster);			
		}
		return;
	}

	public void delSpecificationFormatMaster(Long specSeqNo)
	{
		Optional<SpecificationFormatMaster> id = specFormatRepo.findById(specSeqNo);
		SpecificationFormatMaster specMaster = null;
		
		if (id.isPresent()) 
		{
		specFormatRepo.deleteById(specSeqNo);
		}
		return;
	}

	public void delAllSpecificationFormatMaster() {
		specFormatRepo.deleteAll();
	}
	
	private ArrayList<SpecificationFormatMasterDTO> getSpecificationFormatMasterDTOs(ArrayList<SpecificationFormatMaster> lMasters) {
		SpecificationFormatMasterDTO lDTO = null;
		ArrayList<SpecificationFormatMasterDTO> lMasterDTOs = new ArrayList<SpecificationFormatMasterDTO>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getSpecificationFormatMasterDTO(lMasters.get(i));									
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private SpecificationFormatMasterDTO getSpecificationFormatMasterDTO(SpecificationFormatMaster lMaster) 
	{		
		SpecificationFormatMasterDTO lDTO = new SpecificationFormatMasterDTO();
		lDTO.setSpecificationFormatSeqNo(lMaster.getSpecificationFormatSeqNo());
		lDTO.setSpecification_format(lMaster.getSpecification_format());							
		return lDTO;
	}

	private SpecificationFormatMaster setSpecificationFormatMaster(SpecificationFormatMasterDTO lDTO) {
		SpecificationFormatMaster lMaster = new SpecificationFormatMaster();
		lMaster.setSpecification_format(lDTO.getSpecification_format());						
		return lMaster;
	}
}