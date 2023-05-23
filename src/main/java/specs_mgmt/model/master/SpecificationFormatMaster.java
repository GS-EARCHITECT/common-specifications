package specs_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SPECIFICATION_FORMAT_DETAILS database table.
 * 
 */
@Entity
@Table(name="SPECIFICATION_FORMAT_MASTER")
public class SpecificationFormatMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPECIFICATION_FORMAT_SEQ")
	@SequenceGenerator(name="SPECIFICATION_FORMAT_SEQ", sequenceName="SPECIFICATION_FORMAT_SEQ", allocationSize = 1)
	@Column(name="SPECIFICATION_FORMAT_SEQ_NO")
	private long specificationFormatSeqNo;

	@Column(name="SPECIFICATION_FORMAT")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (specificationFormatSeqNo ^ (specificationFormatSeqNo >>> 32));
		result = prime * result + ((specification_format == null) ? 0 : specification_format.hashCode());
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
		SpecificationFormatMaster other = (SpecificationFormatMaster) obj;
		if (specificationFormatSeqNo != other.specificationFormatSeqNo)
			return false;
		if (specification_format == null) {
			if (other.specification_format != null)
				return false;
		} else if (!specification_format.equals(other.specification_format))
			return false;
		return true;
	}

	public SpecificationFormatMaster(long specificationFormatSeqNo, String specification_format) {
		super();
		this.specificationFormatSeqNo = specificationFormatSeqNo;
		this.specification_format = specification_format;
	}

	public SpecificationFormatMaster() {
		super();
	}
	
}