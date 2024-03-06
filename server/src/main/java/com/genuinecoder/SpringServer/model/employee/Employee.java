package com.genuinecoder.SpringServer.model.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
  name = "Employee",
  // unique constraint on the database that prevents two identical name + location added (single source of truth)
  uniqueConstraints = @UniqueConstraint(columnNames = {"name", "location"})
)
public class Employee {

  @Id // this will make id a primary key index
  @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto increment the id
  private int id;
  private String name;
  private String location;
  private String branch;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }
  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", branch=" + branch + "]";
  }
  
}
