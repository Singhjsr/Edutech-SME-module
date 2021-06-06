package edutech.sme.models;

import org.springframework.http.HttpStatus;

public class SuccessInfo {
	private HttpStatus status;
	 
	private String successMessage;
	
	public SuccessInfo (String successMessage,HttpStatus status) {
		super();
		this.successMessage=successMessage;
		this.status=status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
