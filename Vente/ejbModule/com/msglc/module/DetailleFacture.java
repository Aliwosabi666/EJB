package com.msglc.module;

import java.io.Serializable;
import java.util.List;

import com.msglc.entites.Client;
import com.msglc.entites.Commande;
import com.msglc.entites.Ligne_Commande;

public class DetailleFacture  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client client;
	private Commande commande;
	private List<Ligne_Commande> ligneCommande;
	private double total;
	public DetailleFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetailleFacture(Client client, Commande commande, List<Ligne_Commande> ligneCommande, double total) {
		super();
		this.client = client;
		this.commande = commande;
		this.ligneCommande = ligneCommande;
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public List<Ligne_Commande> getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(List<Ligne_Commande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public void calculTotal()
	{
		this.total=0;
		for(Ligne_Commande lc:this.ligneCommande) {
			total+=(lc.getQuantite()*lc.getProduit().getPu());
		}
	}
	
	

}
