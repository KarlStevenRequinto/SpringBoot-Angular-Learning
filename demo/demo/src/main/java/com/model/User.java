package com.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String userName;
	@NonNull 
	private String passWord;
	@NonNull
	private String profileName;
	@NonNull
	private String country;
	@NonNull
	private Integer age;
	@NonNull
	private String gender;
	
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String country, String userName, String passWord, String profileName, Integer age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.userName = userName;
		this.passWord = passWord;
		this.profileName = profileName;
		this.age = age;
		this.gender = gender;
	
		
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, country, firstName, gender, id, lastName, passWord, profileName, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(age, other.age) && Objects.equals(country, other.country)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(passWord, other.passWord) && Objects.equals(profileName, other.profileName)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", passWord=" + passWord + ", profileName=" + profileName + ", country=" + country + ", age=" + age
				+ ", gender=" + gender + "]";
	}

	public Long getId() {
		return id;
	}
	
}
