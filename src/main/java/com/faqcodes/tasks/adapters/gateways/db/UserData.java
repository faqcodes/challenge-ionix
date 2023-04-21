package com.faqcodes.tasks.adapters.gateways.db;

import java.time.LocalDateTime;
import java.util.List;

import com.faqcodes.tasks.models.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserData {
  @Id
  @Column(name = "id")
  // @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "lastlogin")
  private LocalDateTime lastlogin;

  @Column(name = "role")
  private String role;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @Column(name = "tasks")
  private List<TaskData> tasks;

  public UserData() {
    super();
  }

  public UserData(String id, String name, String email, String password, LocalDateTime lastlogin, Role role,
  List<TaskData> tasks) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.lastlogin = lastlogin;
    this.role = role.toString();
    this.tasks = tasks;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public LocalDateTime getLastlogin() {
    return lastlogin;
  }

  public String getRole() {
    return role;
  }

  public List<TaskData> getTasks() {
    return tasks;
  }
}