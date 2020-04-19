package com.msglc.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Ligne_CommandePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCommande;
	private Long idProd;
	
	
	public Ligne_CommandePK() {
		super();
	}
	public Ligne_CommandePK(Long idCommande, Long idProd) {
		super();
		this.idCommande = idCommande;
		this.idProd = idProd;
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Long getIdProd() {
		return idProd;
	}
	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCommande == null) ? 0 : idCommande.hashCode());
		result = prime * result + ((idProd == null) ? 0 : idProd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ligne_CommandePK other = (Ligne_CommandePK) obj;
		if (idCommande == null) {
			if (other.idCommande != null)
				return false;
		} else if (!idCommande.equals(other.idCommande))
			return false;
		if (idProd == null) {
			if (other.idProd != null)
				return false;
		} else if (!idProd.equals(other.idProd))
			return false;
		return true;
	}
	
	
	
}
