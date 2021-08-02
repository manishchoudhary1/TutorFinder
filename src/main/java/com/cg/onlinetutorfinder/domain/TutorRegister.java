package com.cg.onlinetutorfinder.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TutorRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long registerId;
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("tutorSubjectMapId")
	private TutorSubjectMapping tutorSubjectMap;
	private Date dateTime;
	private String status;
	private String active;
	private Date updateTime;
	private String updatedBy;
	
	@Column(name ="tutor_subject_map_tutor_subject_map_id")
	@JsonIgnore
	private Long tutorSupjectMapId;
	
	@Column(name ="user_user_id")
	@JsonIgnore
	private Long parentId;
	
	public Long getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TutorSubjectMapping getTutorSubjectMap() {
		return tutorSubjectMap;
	}
	public void setTutorSubjectMap(TutorSubjectMapping tutorSubjectMap) {
		this.tutorSubjectMap = tutorSubjectMap;
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
	public Long getTutorSupjectMapId() {
		return tutorSupjectMapId;
	}
	public void setTutorSupjectMapId(Long tutorSupjectMapId) {
		this.tutorSupjectMapId = tutorSupjectMapId;
	}
	public Long getParentId() {
		return this.parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	
}
