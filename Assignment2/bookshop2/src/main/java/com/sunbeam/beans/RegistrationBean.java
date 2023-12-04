package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;

public class RegistrationBean {
private String name;
private String mobile;
private String email;
private String address;
private String birth;
private String password;
private int count;
public RegistrationBean() {
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getMobile() {
return mobile;
}
public void setMobile(String mobile) {
this.mobile = mobile;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getAddress() {
return address;
}
public void setAddress(String address) {
this.address = address;
}
public String getBirth() {
return birth;
}
public void setBirth(String birth) {
this.birth = birth;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}

public int getCount() {
return count;
}
public void setCount(int count) {
this.count = count;
}
public void registerUser() {
try(UserDao userDao = new UserDao()) {
Date birthDate = Date.valueOf(birth);
User u = new User(0, name, password, mobile, email, address, birthDate, 1, "ROLE_CUSTOMER");
count = userDao.save(u);
}
catch (Exception e) {
e.printStackTrace();
}
}
}