package com.carl.carlapp.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Subscriber {
		@NotEmpty( message="username can't be null") 
	    private String name;
	     
	    @NotEmpty ( message="mail can't be null") 
	    @Email( message="not a email") 
	    private String email;
	     
	    @NotNull 
	    @Min(13) @Max(110)
	    private Integer age;
	     
	    @Size(min=10)
	    private String phone;
	     
	     
	    @DateTimeFormat(pattern="MM/dd/yyyy")
	    @NotNull @Past
	    private Date birthday;


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


		public Integer getAge() {
			return age;
		}


		public void setAge(Integer age) {
			this.age = age;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public Date getBirthday() {
			return birthday;
		}


		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}


	    
}
