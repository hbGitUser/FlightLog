package flightLog.entities;

public class Pilot {

	private Long id;
	private String surname;
	private String forename;
	private String medical;
	private String radioComLicence;

	public Pilot(Long id, String surname, String forename) {
		this.id = id;
		this.surname = surname;
		this.forename = forename;
	}

	public Pilot(Long id, String surname, String forename, String medical,
			String radioComLicence) {
		this.id = id;
		this.surname = surname;
		this.forename = forename;
		this.medical = medical;
		this.radioComLicence = radioComLicence;
	}

	public Pilot() {
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getRadioComLicence() {
		return radioComLicence;
	}

	public void setRadioComLicence(String radioComLicence) {
		this.radioComLicence = radioComLicence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", surname=" + surname + ", forename="
				+ forename + ", medical=" + medical + ", radioComLicence="
				+ radioComLicence + "]";
	}
}
