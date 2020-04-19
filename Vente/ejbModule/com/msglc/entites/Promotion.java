package com.msglc.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPromotion;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private double tauxR;
	
	
	@ManyToOne()
	@JoinColumn(name = "idProduit")
	private Produit produit;
	
	public Promotion() {
		super();
	}
	public Promotion(Date dateDebut, Date dateFin, double tauxR) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tauxR = tauxR;
	}
	public Long getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public double getTauxR() {
		return tauxR;
	}
	public void setTauxR(double tauxR) {
		this.tauxR = tauxR;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	
}
