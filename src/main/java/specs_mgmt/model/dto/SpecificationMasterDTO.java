package specs_mgmt.model.dto;

import java.io.Serializable;

public class SpecificationMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1990608323271034112L;
	private Long specificationSeqNo;
	private String specification;
	private Long specificationFormatSeqNo;
	
	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}
	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Long getSpecificationFormatSeqNo() {
		return specificationFormatSeqNo;
	}
	public void setSpecificationFormatSeqNo(Long specificationFormatSeqNo) {
		this.specificationFormatSeqNo = specificationFormatSeqNo;
	}
	public SpecificationMasterDTO(Long specificationSeqNo, String specification, Long specificationFormatSeqNo) {
		super();
		this.specificationSeqNo = specificationSeqNo;
		this.specification = specification;
		this.specificationFormatSeqNo = specificationFormatSeqNo;
	}
	public SpecificationMasterDTO() {
		super();
	}
}