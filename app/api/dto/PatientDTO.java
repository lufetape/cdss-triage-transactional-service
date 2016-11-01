package api.dto;

import java.io.Serializable;
import java.util.Date;

public class PatientDTO implements Serializable{
	
	private static final long serialVersionUID = -3168360840803747200L;
	
	private Long id;
	private Long documentType;
	private String identification;
	private String firstName;
	private String secondName;
	private String lastName;
	private String secondLastName;
	private String phoneNumber;
	private String email;
	private Date dateOfBirth;
	
	
	public PatientDTO(Long id) {
		super();
		this.id = id;
	}


	public PatientDTO() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getDocumentType() {
		return documentType;
	}


	public void setDocumentType(Long documentType) {
		this.documentType = documentType;
	}


	public String getIdentification() {
		return identification;
	}


	public void setIdentification(String identification) {
		this.identification = identification;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSecondLastName() {
		return secondLastName;
	}


	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PatientDTO other = (PatientDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", documentType=" + documentType + ", identification=" + identification
				+ ", firstName=" + firstName + ", secondName=" + secondName + ", lastName=" + lastName
				+ ", secondLastName=" + secondLastName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
	
	
	
	
	
	

}
