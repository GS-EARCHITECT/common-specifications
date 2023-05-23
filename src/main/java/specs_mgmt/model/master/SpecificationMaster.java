package specs_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SPECIFICATION_MASTER database table.
 * 
 */
@Entity
@Table(name="SPECIFICATION_MASTER")
public class SpecificationMaster implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 131907838333130266L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPECIFICATION_SEQ")
	@SequenceGenerator(name="SPECIFICATION_SEQ", sequenceName="SPECIFICATION_SEQ", allocationSize = 1)
	@Column(name="SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name="SPECIFICATION")
	private String specification;

	@Column(name="SPECIFICATION_FORMAT_SEQ_NO")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((specification == null) ? 0 : specification.hashCode());
		result = prime * result + ((specificationFormatSeqNo == null) ? 0 : specificationFormatSeqNo.hashCode());
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecificationMaster other = (SpecificationMaster) obj;
		if (specification == null) {
			if (other.specification != null)
				return false;
		} else if (!specification.equals(other.specification))
			return false;
		if (specificationFormatSeqNo == null) {
			if (other.specificationFormatSeqNo != null)
				return false;
		} else if (!specificationFormatSeqNo.equals(other.specificationFormatSeqNo))
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		return true;
	}

	public SpecificationMaster(Long specificationSeqNo, String specification, Long specificationFormatSeqNo) {
		super();
		this.specificationSeqNo = specificationSeqNo;
		this.specification = specification;
		this.specificationFormatSeqNo = specificationFormatSeqNo;
	}

	public SpecificationMaster() {
		super();
	}

	}