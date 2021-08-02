package com.cg.onlinetutorfinder.dto;

import java.util.Date;

public class DemoRequestDto {

	private Long demoId;
	private Long parentId;
	private TutorSubjectDto tutorSubject;
	private Date dateTime;
	private String status;
	private String active;
	private Date updateTime;
	private String updatedBy;
	
	public Long getDemoId() {
		return demoId;
	}
	public void setDemoId(Long demoId) {
		this.demoId = demoId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public TutorSubjectDto getTutorSubject() {
		return tutorSubject;
	}
	public void setTutorSubject(TutorSubjectDto tutorSubject) {
		this.tutorSubject = tutorSubject;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
