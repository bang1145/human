package com.human.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerDto {
	private Integer id;
	private String name;
	private Double height;
	private LocalDateTime birthday;
	
	@Override
	public int hashCode() {
		return Objects.hash(birthday, height, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(height, other.height)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", height=" + height + ", birthday=" + birthday + "]";
	}
	public CustomerDto() {}
	public CustomerDto(Integer id, String name, Double height, LocalDateTime birthday) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.birthday = birthday;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public LocalDateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
}
