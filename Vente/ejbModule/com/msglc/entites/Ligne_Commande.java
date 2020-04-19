package com.msglc.entites;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Ligne_Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Ligne_CommandePK lcpk;
	private int quantite;
		
	
	@ManyToOne
	@MapsId("idCommande")
	@JoinColumn(name ="idCommande")
	private Commande commande;
	
	
	@ManyToOne
	@MapsId("idProd")
	@JoinColumn(name ="idProd")
	private Produit produit;
	
	public Ligne_Commande() {
		super();
		this.lcpk =new Ligne_CommandePK();
	}
	

	public Ligne_Commande(Ligne_CommandePK lcpk, int quantite) {
		super();
		this.lcpk = lcpk;
		this.quantite = quantite;
	}
	
	
	public Ligne_Commande(int quantite) {
		super();
		this.quantite = quantite;
		this.lcpk =new Ligne_CommandePK();
	}
	
	
	
	
	
	
	public Ligne_CommandePK getLcpk() {
		return lcpk;
	}

	public void setLcpk(Ligne_CommandePK lcpk) {
		this.lcpk = lcpk;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
	
}
