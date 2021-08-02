package com.cg.onlinetutorfinder.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TutorSubjectMapping  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tutorSubjectMapId;

	
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
	@JsonBackReference(value = "user")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @MapsId("subjectId")
	@JsonBackReference(value = "subject")
	private Subject subject;
	
	private String cronExpression;
	
	@Column(name = "user_user_id")
	@JsonIgnore
	private Long userId;
	
	@Column(name = "subject_subject_id")
	@JsonIgnore
	private Long subjectId;
	
    @OneToMany(
            mappedBy = "tutorSubjectMap",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonIgnore	
	private List<DemoRequest> demoRequestList;
    
    @OneToMany(
            mappedBy = "tutorSubjectMap",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonIgnore	
	private List<TutorRegister> tutorRegisterList;
	
	@Transient
	@JsonInclude
	private String name;
	
	@Transient
	@JsonInclude
	private String subjectName;

	
	public Long getTutorSubjectMapId() {
		return tutorSubjectMapId;
	}

	public void setTutorSubjectMapId(Long tutorSubjectMapId) {
		this.tutorSubjectMapId = tutorSubjectMapId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.userId = this.user.getUserId();
		this.name = this.user.fName +","+this.user.lName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		this.subjectId = this.subject.getSubjectId();
		this.subjectName = this.subject.getSubjectName();
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Long getUserId() {
		
		if(this.user !=null)
		{
			this.userId = this.user.getUserId();
		}
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSubjectId() {
		
		if(this.subject !=null)
		{
			this.subjectId = this.subject.getSubjectId();
		}
		return this.subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		if(this.user !=null)
		{
			this.name = this.user.fName +","+this.user.lName;
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectName() {
		
		if(this.subject !=null)
		{
			this.subjectName = this.subject.getSubjectName();
		}
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<DemoRequest> getDemoRequestList() {
		return demoRequestList;
	}

	public void setDemoRequestList(List<DemoRequest> demoRequestList) {
		this.demoRequestList = demoRequestList;
	}

	public List<TutorRegister> getTutorRegisterList() {
		return tutorRegisterList;
	}

	public void setTutorRegisterList(List<TutorRegister> tutorRegisterList) {
		this.tutorRegisterList = tutorRegisterList;
	}

	
}
