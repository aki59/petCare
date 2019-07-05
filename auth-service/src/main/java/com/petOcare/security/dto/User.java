package com.petOcare.security.dto;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;

import javax.persistence.JoinColumn;

@Entity
@Data
@ToString
public class User {
	
@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

private String emailId;
private String firstName;
private String lastName;
@Column(length = 70)
private String password;
private Integer age;
private String sex;
private Date birthDate;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
private Collection<Role> roles;
}