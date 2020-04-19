package com.msglc.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.msglc.entites.Administrateur;
import com.msglc.entites.Categorie;
import com.msglc.entites.Client;
import com.msglc.entites.Commande;
import com.msglc.entites.Ligne_Commande;
import com.msglc.entites.Produit;
import com.msglc.entites.Promotion;
import com.msglc.module.DetailleFacture;

@Local
public interface VenteDaoLocal extends VenteDaoRemote{

	public Client addClient(Client c);
	public Client getClient(Long id);
	public List<Client> findClientByMC(String mc);
	
	
	public Administrateur addAdministrateur(Administrateur admin);
	public Administrateur getAdministrateur(Long id);
	public Administrateur addPrivileges(Long id, int privileges);

	public Categorie addCategorie(Categorie c);
	public Categorie getCategorie(Long idCategorie);
	public List<Categorie> getAllCategorie();
	
	public Produit addProduit(Produit p);
	public Produit addProduit(Produit p,Long idCategorie);
	public Produit getProduit(Long idProd);
	public List<Produit> findProduitByCategorie(Long idCategorie);
	public Produit updatePrixProduit(Long idProd, double nvPrix);
	
	
	public Promotion addPromotion(Promotion p, Long idProd);
	public List<Promotion> findPromotionByProduit(Long idProd);
	public double produitIsOnPromotion(Long idProd, Date date);
	
	
	public Commande addCommande(Commande c,Long IdClient);
	public Commande getCommande(Long idCommande);
	public List<Commande> findCommandeByClient(Long id);
	
	public void addLigne_commande(Long idCommande, Long idProd, int quantite);
	public void deleteLigne_commande(Long idCommande, Long idProd);
	public Ligne_Commande getLigne_Commande(Long idCommande, Long idProd);
	public List<Ligne_Commande> findLigne_CommandeByIdCommande(Long idCommande);
	
	
	public DetailleFacture getDetailleFacture(Long idCommande);
	public void addConsultation(Long idClient, Long idCategorie);
	public void addProduitToCategorie(Long idPro, Long idCategorie);
	public List<Categorie> findCategorieConsultedByClient(Long id);
	
	
	

}
