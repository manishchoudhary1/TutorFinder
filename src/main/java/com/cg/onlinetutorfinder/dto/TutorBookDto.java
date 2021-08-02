package com.cg.onlinetutorfinder.dto;

public class TutorBookDto {
	


	 private String registerId;
    private String parentId;
    private TutorSubjectDto tutorSubject;
    private String dateTime;
    private String status;
    private String active;
    private String updateTime;
    private String updatedBy;
    
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public TutorSubjectDto getTutorSubject() {
		return tutorSubject;
	}
	public void setTutorSubject(TutorSubjectDto tutorSubject) {
		this.tutorSubject = tutorSubject;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
