package specs_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import specs_mgmt.model.dto.SpecificationDataDTO;
import specs_mgmt.model.dto.SpecificationMasterDTO;
import specs_mgmt.service.I_SpecificationMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/specManagement")
public class SpecificationMaster_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(SpecificationMaster_Controller.class);

	@Autowired
	private I_SpecificationMasterService specMasterService;

	@PostMapping("/new")
	public ResponseEntity<SpecificationMasterDTO> newSpecificationMaster(@RequestBody SpecificationMasterDTO specDTO) 
	{
		SpecificationMasterDTO specDTO2 = specMasterService.newSpecificationMaster(specDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(specDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSpecificationMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SpecificationMasterDTO>> getAllSpecificationMasters() {
		ArrayList<SpecificationMasterDTO> specDTOs = specMasterService.getAllSpecificationMasters();
		return new ResponseEntity<>(specDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSpecificationMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SpecificationMasterDTO>> getSelectSpecificationMasters(@RequestBody ArrayList<Long> specSeqNos) {
		ArrayList<SpecificationMasterDTO> specDTOs = specMasterService.getSelectSpecifications(specSeqNos);
		return new ResponseEntity<>(specDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSpecsByFormats", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SpecificationMasterDTO>> getSpecsByFormats(@RequestBody ArrayList<Long> fmSeqNos) {
		ArrayList<SpecificationMasterDTO> specDTOs = specMasterService.getSpecificationsByFormats(fmSeqNos);
		return new ResponseEntity<>(specDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{specSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpecificationMasterDTO> getSpecificationMasterById(@PathVariable Long specSeqNo) {
		SpecificationMasterDTO specAccNoDTOs = specMasterService.getSpecificationMasterById(specSeqNo);
		return new ResponseEntity<>(specAccNoDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSpecData/{specSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SpecificationDataDTO>> getSpecData(@PathVariable Long specSeqNo)
	{
		ArrayList<SpecificationDataDTO> specDTOs = specMasterService.getSpecifications(specSeqNo);
		return new ResponseEntity<>(specDTOs, HttpStatus.OK);
	}

	@PutMapping("/updSpecificationMaster")
	public void updateSpecificationMaster(@RequestBody SpecificationMasterDTO specDTO) {
		specMasterService.updSpecificationMaster(specDTO);
		return;
	}
	
	@PutMapping("/updSpecificationDataFromStrings/{specSeqNo}")
	public void updSpecificationDataFromStrings(@PathVariable Long specSeqNo, @RequestBody String[] strings)
	{
		specMasterService.updSpecificationDataFromStrings(specSeqNo, strings);
		return;
	}
	
	@PutMapping("/updSpecificationMaster/{specSeqNo}/{specString}")
	public void updSpecificationData(@PathVariable Long specSeqNo, @PathVariable String specString)
	{
		specMasterService.updSpecificationData(specSeqNo, specString);
		return;
	}
	
	@DeleteMapping("/delSpecificationMaster/{SpecificationMasterSeqNo}")
	public void deleteSpecificationMaster(@PathVariable Long SpecificationMasterSeqNo) {
		specMasterService.delSpecificationMaster(SpecificationMasterSeqNo);
	}

	@DeleteMapping("/delSelectSpecificationMasters")
	public void deleteSelectSpecificationMasters(@RequestBody ArrayList<Long> SpecificationMasterSeqNoList) {
		specMasterService.delSelectSpecificationMasters(SpecificationMasterSeqNoList);
		return;
	}

	@DeleteMapping("/delAllSpecificationMaster")
	public void deleteAllSpecificationMasters() {
		specMasterService.delAllSpecificationMasters();
		;
		return;
	}
}