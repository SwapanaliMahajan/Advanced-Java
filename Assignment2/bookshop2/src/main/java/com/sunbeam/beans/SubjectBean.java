package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.BookDao;


public class SubjectBean {
	private List<String> subjectList;
	public SubjectBean() {
		this.subjectList = new ArrayList<>();
	}
	public List<String> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}
	public void fetchSubjects() {
		try(BookDao bookDao = new BookDao()) {
			this.subjectList = bookDao.getSubjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







