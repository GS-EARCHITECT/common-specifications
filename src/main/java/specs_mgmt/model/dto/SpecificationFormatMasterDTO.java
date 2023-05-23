package specs_mgmt.model.dto;

import java.io.Serializable;

public class SpecificationFormatMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7976950701238735962L;

	private long specificationFormatSeqNo;
	private String specification_format;

	public long getSpecificationFormatSeqNo() {
		return specificationFormatSeqNo;
	}

	public void setSpecificationFormatSeqNo(long specificationFormatSeqNo) {
		this.specificationFormatSeqNo = specificationFormatSeqNo;
	}

	public String getSpecification_format() {
		return specification_format;
	}

	public void setSpecification_format(String specification_format) {
		this.specification_format = specification_format;
	}

	public SpecificationFormatMasterDTO(long specificationFormatSeqNo, String specification_format) {
		super();
		this.specificationFormatSeqNo = specificationFormatSeqNo;
		this.specification_format = specification_format;
	}

	public SpecificationFormatMasterDTO() {
		super();
	}

}