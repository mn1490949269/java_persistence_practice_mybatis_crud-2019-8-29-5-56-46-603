package tws.dto;

import tws.entity.Employee;

public class EmployeeDto extends Employee{
	private String name;
	private String id;
	private String age;
	private String desc;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public EmployeeDto() {
	}

	public String getDesc() {
		desc = "name:" +this.name+"age:"+this.age;
		return desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
