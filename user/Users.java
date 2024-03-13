package com.insuagg1.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
	public class Users {
	    @Id
	   
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    private String name;
	    private String email;
	    private String password;
	    
	    private String phonenumber;
	    
	    public Users() {
	    }
		public Users(int id, String name, String email, String password,  String phonenumber) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			
			this.phonenumber = phonenumber;
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		
	    

}