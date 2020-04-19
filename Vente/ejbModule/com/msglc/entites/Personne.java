package com.msglc.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract  class Personne  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.TABLE)
	@Column(name = "idPersonne")
	private Long id;
	@Column(name = "nom", length = 30)
	private String nom;
	@Column(length = 30)
	private String pernom;
	@Column(length = 50)
	private String email;
	@Column(length = 11)
	private String tel;
	@Column(length = 15)
	private String password;
	public Personne() {
		super();
	}
	public Personne(String nom, String pernom, String email, String tel, String password) {
		super();
		this.nom = nom;
		this.pernom = pernom;
		this.email = email;
		this.tel = tel;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPernom() {
		return pernom;
	}
	public void setPernom(String pernom) {
		this.pernom = pernom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	

}
