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
	     
	   /* @NotEmpty 
	    @Email
	    private String email;
	     
	    @NotNull @Min(13) @Max(110)
	    private Integer age;
	     
	    @Size(min=10)
	    private String phone;
	     
	     
	    @DateTimeFormat(pattern="MM/dd/yyyy")
	    @NotNull @Past
	    private Date birthday;*/


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


	    
}
