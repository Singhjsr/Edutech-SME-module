package edutech.sme.dto;



import javax.validation.constraints.NotEmpty;

import edutech.sme.entities.Sme;

public class SmeDTO {
	
	@NotEmpty(message="NAME cannot be empty")
	private String name;
	
	@NotEmpty(message="EMAIl cannot be empty")
	private String email;
	
	@NotEmpty(message="PHONE cannot be empty")
	private String phone;
	
	@NotEmpty(message="SUBJECT cannot be empty")
	private String subject;
	
	@NotEmpty(message="USERNAME cannot be empty")
	private String username;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public Sme convertToSmeEntity() {
		Sme sme=new Sme();
		sme.setEmail(email);
		sme.setName(name);
		sme.setPhone(phone);
		sme.setSubject(subject);
		sme.setUsername(username);
		
		return sme;
		
	}
	
	
}
