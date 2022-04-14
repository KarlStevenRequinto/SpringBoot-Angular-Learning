package com.model;

import java.util.Objects;

public class User {
	private String firstName;
	private String lastName;
	private Integer age;
	private String country;
	private String nickName;
	private String profileName;
	private Integer numFriends;
	
	
	// CONSTRUCTORS
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String firstName, String lastName, Integer age, String country, String nickName, String profileName,
			Integer numFriends) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
		this.nickName = nickName;
		this.profileName = profileName;
		this.numFriends = numFriends;
	}

	//GETTERS AND SETTERS
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public Integer getNumFriends() {
		return numFriends;
	}
	public void setNumFriends(Integer numFriends) {
		this.numFriends = numFriends;
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, country, firstName, lastName, nickName, numFriends, profileName);
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
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(nickName, other.nickName) && Objects.equals(numFriends, other.numFriends)
				&& Objects.equals(profileName, other.profileName);
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", country=" + country
				+ ", nickName=" + nickName + ", profileName=" + profileName + ", numFriends=" + numFriends + "]";
	}
	
	
	
}
