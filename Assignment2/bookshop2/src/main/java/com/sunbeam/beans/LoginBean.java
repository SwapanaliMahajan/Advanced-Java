package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;


public class LoginBean {
	private String email;
	private String passwd;
	private boolean status;
	public LoginBean() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void authenticate() {
		try(UserDao userDao = new UserDao()) {
			User user = userDao.findByEmail(this.email);
			if(user != null && user.getPassword().equals(this.passwd))
				status = true;
			else
				status = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}








