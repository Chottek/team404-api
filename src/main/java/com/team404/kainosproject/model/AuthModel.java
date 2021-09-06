package com.team404.kainosproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class AuthModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "mail")
  private String mail;

  @Column(name = "pass")
  private String pass;

  @Column(name = "op")
  private boolean isOp;

  public AuthModel(String mail, String pass, boolean isOp) {
    this.mail = mail;
    this.pass = pass;
    this.isOp = isOp;
  }

  public AuthModel(){

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPass(){
    return pass;
  }

  public void setPass(String pass){
    this.pass = pass;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public boolean isOp() {
    return isOp;
  }

  public void setOp(boolean op) {
    isOp = op;
  }
}
