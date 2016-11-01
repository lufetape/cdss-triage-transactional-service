package dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Model;

@Entity
@Table(name = "patient")
public class Patient extends Model implements Serializable {

	private static final long serialVersionUID = -5492716707364182429L;
	
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	private Long id;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "document_type_id")
	private Long documentType;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "identification")
	private String identification;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "second_name")
	private String secondName;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "second_last_name")
	private String secondLastName;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "email")
	private String email;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	public Patient() {
		super();
	}

	public Patient(Long id) {
		super();
		this.id = id;
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
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", documentType=" + documentType + ", identification=" + identification
				+ ", firstName=" + firstName + ", secondName=" + secondName + ", lastName=" + lastName
				+ ", secondLastName=" + secondLastName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	public static Finder<Long, Patient> find = new Finder<Long, Patient>(Patient.class);
	
	
	
	
	
	
	
  
  

}
