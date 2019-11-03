package com.petOcare.security.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;
import javax.persistence.JoinColumn;

@Entity
@Data
@ToString
@NamedQuery(name = "User.findByFirstNameLength",
    query = "SELECT u FROM User u WHERE CHAR_LENGTH(u.firstName) =:length")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String emailId;
  private String firstName;
  private String lastName;
  @Column(length = 70)
  private String password;
  private Integer age;
  private String sex;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
  private Address address;

  private Date birthDate;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") ,
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") )
  private Collection<Role> roles;
}
