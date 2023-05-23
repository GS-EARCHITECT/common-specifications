package specs_mgmt.model.dto;

import java.io.Serializable;

public class SpecificationDataDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7568982144928982932L;
	private String specLabel;
	private String specData;

	public String getSpecLabel() {
		return specLabel;
	}

	public void setSpecLabel(String specLabel) {
		this.specLabel = specLabel;
	}

	public String getSpecData() {
		return specData;
	}

	public void setSpecData(String specData) {
		this.specData = specData;
	}

	public SpecificationDataDTO(String specLabel, String specData) {
		super();
		this.specLabel = specLabel;
		this.specData = specData;
	}

	public SpecificationDataDTO() {
		super();
	}
}