package com.msglc.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;
	@Column(length = 30)
	private String designation;
	private double pu;
	@Temporal(TemporalType.DATE)
	private Date dateModification;
	
	
	@OneToMany(mappedBy = "produit" , fetch = FetchType.LAZY)
	private List<Ligne_Commande> ligneCommande;
	
	@OneToMany(mappedBy = "produit") 
	private List<Promotion> promotion;
	
	@ManyToOne
	@JoinColumn(name ="idCategorie")
	private Categorie categorie;
	
	public Produit() {
		super();
	}
	public Produit(String designation, double pu, Date dateModification) {
		super();
		this.designation = designation;
		this.pu = pu;
		this.dateModification = dateModification;
	}
	public Long getIdProd() {
		return idProd;
	}
	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPu() {
		return pu;
	}
	public void setPu(double pu) {
		this.pu = pu;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public List<Ligne_Commande> getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(List<Ligne_Commande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	public List<Promotion> getPromotion() {
		return promotion;
	}
	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
	
	
}
