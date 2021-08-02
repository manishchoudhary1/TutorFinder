package com.cg.onlinetutorfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinetutorfinder.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	 Subject findBySubjectName(String subjectName);
}
