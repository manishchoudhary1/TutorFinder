package com.cg.onlinetutorfinder.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	Long userId;
	String password;
	String fName;
	String lName;
	String userType;
	String active;
	Date updateTime;
	String updatedBy;
	String userEmail;
	
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonManagedReference(value = "user")
	List<TutorSubjectMapping> subjectList;
    
    @OneToMany(
            mappedBy = "tutorSubjectMap",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonIgnore	
	List<DemoRequest> demoRequestList;
    
    @OneToMany(
            mappedBy = "tutorSubjectMap",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    @JsonIgnore	
	List<TutorRegister> tutorRegisterList;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@JsonManagedReference
	public List<TutorSubjectMapping> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<TutorSubjectMapping> subjectList) {
		this.subjectList = subjectList;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", fName=" + fName + ", lName=" + lName
				+ ", userType=" + userType + ", active=" + active + ", updateTime=" + updateTime + ", updatedBy="
				+ updatedBy + ", userEmail=" + userEmail + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

	
	
}
