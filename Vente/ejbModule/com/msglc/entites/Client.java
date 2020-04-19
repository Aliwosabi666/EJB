package com.msglc.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQuery(name="Client.findByMC",
query="SELECT c FROM Client c where c.nom LIKE ?1")
@Entity
public class Client extends Personne{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length = 50)
	private String adresse;
	@Column(length = 15)
	private String cp;
	@Column(length = 20)
	private String ville;
	@Column(length = 20)
	private String pays;
	
	@OneToMany(mappedBy = "client")
	private List<Commande> commmande;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Consultation",joinColumns = @JoinColumn(name="idClient"),
	inverseJoinColumns = @JoinColumn(name="idCategorie"))
	private List<Categorie> categorie;
	
	
	public Client() {
		super();
	}
	
	
	public Client(String nom, String pernom, String email, String tel, String password,String adresse, String cp, String ville, String pays) {
		super(nom,pernom, email, tel, password);
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}


	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}


	public List<Commande> getCommmande() {
		return commmande;
	}


	public void setCommmande(List<Commande> commmande) {
		this.commmande = commmande;
	}


	public List<Categorie> getCategorie() {
		return categorie;
	}


	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}
	
	
	
	

}
