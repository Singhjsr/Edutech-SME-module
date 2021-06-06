package edutech.sme.models;

import java.util.Date;

public class Appointment {
	private int studId;
	private int smeId;
	private Date dateOfAppointment;

	private boolean isApproved;
	
	private boolean isCancelled;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public int getSmeId() {
		return smeId;
	}

	public void setSmeId(int smeId) {
		this.smeId = smeId;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	
	
}
