package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.User;


public class UserDao implements AutoCloseable {
private Connection con;

public UserDao() throws Exception {
con = DbUtil.getConnection();
}

@Override
public void close() {
try {
if (con != null)
con.close();
} catch (Exception e) {
}
}

public User findByEmail(String email) throws Exception {
String sql = "SELECT * FROM users WHERE email=?";
try(PreparedStatement stmt = con.prepareStatement(sql)) {
stmt.setString(1, email);
try(ResultSet rs = stmt.executeQuery()) {
if(rs.next()) {
int id = rs.getInt("id");
String name = rs.getString("name");
String password = rs.getString("password");
String mobile = rs.getString("mobile");
email = rs.getString("email");
String address = rs.getString("address");
Date birth = rs.getDate("birth");
int enabled = rs.getInt("enabled");
String role = rs.getString("role");
User u = new User(id, name, password, mobile, email, address, birth, enabled, role);
return u;
}
} // rs.close();
} // stmt.close();
return null;
}

public int save(User u) throws Exception {
String sql="Insert into users values(?,?,?,?,?,?,?,?,? )";
try(PreparedStatement stmt=con.prepareStatement(sql)) {
stmt.setInt(1,u.getId());
stmt.setString(2,u.getName());
stmt.setString(3,u.getPassword());
stmt.setString(4,u.getMobile());
stmt.setString(5, u.getEmail());
stmt.setString(6, u.getAddress());
stmt.setDate(7, u.getBirth());
stmt.setInt(8, u.getEnabled());
stmt.setString(9, u.getRole());
int count=stmt.executeUpdate();
return count;
}//stmt.close()
}



public int update(User u) throws Exception {

String sql="Update books set name=?,author=?,subject=?,price=? where id=?";
try(PreparedStatement stmt=con.prepareStatement(sql)) {

stmt.setInt(1,u.getId());
stmt.setString(2,u.getName());
stmt.setString(3,u.getPassword());
stmt.setString(4,u.getMobile());
stmt.setString(5, u.getEmail());
stmt.setString(6, u.getAddress());
stmt.setDate(7, u.getBirth());
stmt.setInt(8, u.getEnabled());
stmt.setString(9, u.getRole());
int count=stmt.executeUpdate();
return count;
}//stmt.close()
}


public int deleteById(int id) throws Exception {
String sql= "Delete from users where id=?";
try(PreparedStatement stmt=con.prepareStatement(sql)) {
stmt.setInt(1, id);
int count=stmt.executeUpdate();
return count;
}//stmt.close()
}

public List<User> findAll() throws Exception {
List<User> List=new ArrayList<> ();
String sql="Select * from users";
try(PreparedStatement stmt= con.prepareStatement(sql)) {
try(ResultSet rs=stmt.executeQuery()) {
while (rs.next()) {
int id=rs.getInt("id");
String name=rs.getString("name");
String password = rs.getString("password");
String mobile = rs.getString("mobile");
String email = rs.getString("email");
String address = rs.getString("address");
Date birth = rs.getDate("birth");
int enabled = rs.getInt("enabled");
String role = rs.getString("role");
User u = new User(id, name, password, mobile, email, address, birth, enabled, role);
List.add(u);
}

}//rs.close
}//stmt.close()
return List;
}
}