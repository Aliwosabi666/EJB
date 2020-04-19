	package com.msglc.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	@Temporal(TemporalType.DATE)
	private Date dateC;
	private boolean payee;
	@Enumerated(EnumType.STRING)
	@Column(length = 13)
	private ModePaiement modepaiement;
	
	@ManyToOne
	@JoinColumn(name ="IdClient")
	private Client client;
	
	
	@OneToMany(mappedBy = "commande")
	List<Ligne_Commande> ligneCommande;
	
	public Commande() {
		super();
	}
	public Commande(Date dateC, boolean payee, ModePaiement modepaiement) {
		super();
		this.dateC = dateC;
		this.payee = payee;
		this.modepaiement = modepaiement;
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateC() {
		return dateC;
	}
	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	public boolean isPayee() {
		return payee;
	}
	public void setPayee(boolean payee) {
		this.payee = payee;
	}
	public ModePaiement getModepaiement() {
		return modepaiement;
	}
	public void setModepaiement(ModePaiement modepaiement) {
		this.modepaiement = modepaiement;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Ligne_Commande> getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(List<Ligne_Commande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	
}
