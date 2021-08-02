package com.cg.onlinetutorfinder.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long subjectId;
	
	String subjectName;
	
	String active;
	
	Date updateTime;
	
	String updatedBy;
	
    @OneToMany(
            mappedBy = "subject",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonManagedReference(value = "subject")
	List<TutorSubjectMapping> tutorList;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	public List<TutorSubjectMapping> getTutorList() {
		return tutorList;
	}
	public void setTutorList(List<TutorSubjectMapping> tutorList) {
		this.tutorList = tutorList;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Subject subject = (Subject) o;
        return Objects.equals(subjectId, subject.subjectId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(subjectId);
    }
	
}
