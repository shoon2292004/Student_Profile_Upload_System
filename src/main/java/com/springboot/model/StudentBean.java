package com.springboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentBean {
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String email;
	private String photo;

}
