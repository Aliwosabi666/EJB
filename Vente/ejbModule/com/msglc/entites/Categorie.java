package com.msglc.entites;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.facelets.Facelet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

@Entity

public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	@Column(length = 30, nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produit;
	
	
	@ManyToMany(mappedBy = "categorie")
	private List<Client>  client;
	
	public Categorie() {
		super();
	}
	public Categorie(String description) {
		super();
		this.description = description;
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	public List<Client> getClient() {
		return client;
	}
	public void setClient(List<Client> client) {
		this.client = client;
	}
	
	
	
	
	
}
