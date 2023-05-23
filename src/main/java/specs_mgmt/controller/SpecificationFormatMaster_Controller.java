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
import specs_mgmt.model.dto.SpecificationFormatMasterDTO;
import specs_mgmt.service.I_SpecificationFormatMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/specFormatManagement")
public class SpecificationFormatMaster_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(SpecificationFormatMaster_Controller.class);

	@Autowired
	private I_SpecificationFormatMasterService specFormatServ;

	@PostMapping("/new")
	public ResponseEntity<SpecificationFormatMasterDTO> newSpecificationFormatMaster(@RequestBody SpecificationFormatMasterDTO emailDTO) {
		SpecificationFormatMasterDTO emailDTO2 = specFormatServ.newSpecificationFormatMaster(emailDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(emailDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSpecificationFormatMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<SpecificationFormatMasterDTO>> getAllSpecificationFormatMaster() {
		ArrayList<SpecificationFormatMasterDTO> emailDTOs = specFormatServ.getAllSpecificationFormatMaster();
		return new ResponseEntity<>(emailDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{fmSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpecificationFormatMasterDTO> getSpecificationFormatMasterById(@PathVariable Long fmSeqNo) {
		SpecificationFormatMasterDTO emailAccNoDTOs = specFormatServ.getSpecificationFormatMasterById(fmSeqNo);
		return new ResponseEntity<>(emailAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updSpecificationFormatMaster")
	public void updateSpecificationFormatMaster(@RequestBody SpecificationFormatMasterDTO emailDTO) {
		specFormatServ.updSpecificationFormatMaster(emailDTO);
		return;
	}

	@DeleteMapping("/delSpecificationFormatMaster/{fmSeqNo}")
	public void deleteSpecificationFormatMaster(@PathVariable Long fmSeqNo)
	{
		specFormatServ.delSpecificationFormatMaster(fmSeqNo);
	}

	@DeleteMapping("/delAllSpecificationFormatMaster")
	public void deleteAllSpecificationFormatMaster() {
		specFormatServ.delAllSpecificationFormatMaster();		
		return;
	}
}