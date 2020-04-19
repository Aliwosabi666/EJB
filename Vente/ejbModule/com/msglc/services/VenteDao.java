package com.msglc.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.msglc.entites.Administrateur;
import com.msglc.entites.Categorie;
import com.msglc.entites.Client;
import com.msglc.entites.Commande;
import com.msglc.entites.Ligne_Commande;
import com.msglc.entites.Ligne_CommandePK;
import com.msglc.entites.Produit;
import com.msglc.entites.Promotion;
import com.msglc.module.DetailleFacture;

/**
 * Session Bean implementation class VenteDao
 */
@Stateless
public class VenteDao implements VenteDaoRemote, VenteDaoLocal {

	@PersistenceContext(unitName = "Vente")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public VenteDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Client getClient(Long id) {
		Client c = em.find(Client.class, id);
		if (c == null)
			throw new RuntimeException("Client introuble !!");
		return c;
	}

	@Override
	public List<Client> findClientByMC(String mc) {
		Query req = em.createNamedQuery("Client.findByMC").setParameter(1, "%"+mc +"%");
		return req.getResultList();
	}

	@Override
	public Administrateur addAdministrateur(Administrateur admin) {
		em.persist(admin);
		return admin;
	}

	@Override
	public Administrateur getAdministrateur(Long id) {
		Administrateur admin = em.find(Administrateur.class, id);
		if (admin == null)
			throw new RuntimeException("Administrateur introuvable !!");
		return admin;
	}

	@Override
	public Administrateur addPrivileges(Long id, int privileges) {
		Administrateur admin = getAdministrateur(id);
		admin.setPrivileges(privileges);
		return admin;
	}

	@Override
	public Categorie addCategorie(Categorie cat) {
		em.persist(cat);
		return cat;
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		Categorie c = em.find(Categorie.class, idCategorie);
		if (c == null)
			throw new RuntimeException("Categorie introuble !!");
		return c;
	}

	@Override
	public List<Categorie> getAllCategorie() {
		Query req = em.createNamedQuery("Categorie.findAll");
		return req.getResultList();
	}

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public Produit addProduit(Produit p, Long idCategorie) {
		Categorie c = em.find(Categorie.class, idCategorie);
		if (c == null)
			throw new RuntimeException("Categorie  introubable !!");
		p.setCategorie(c);
		em.persist(p);
		return p;
	}

	@Override
	public Produit getProduit(Long idProd) {
		Produit p = em.find(Produit.class, idProd);
		if (p == null)
			throw new RuntimeException("Produit  introubable !!");
		return p;
	}

	@Override
	public List<Produit> findProduitByCategorie(Long idCategorie) {
		Query req = em.createNamedQuery("Produit.findByCategorie").setParameter("id", idCategorie);
		return req.getResultList();
	}

	@Override
	public Produit updatePrixProduit(Long idProd, double nvPrix) {
		Produit p = em.find(Produit.class, idProd);
		if (p == null)
			throw new RuntimeException("Produit introuvable !!");
		p.setPu(nvPrix);
		p.setDateModification(new Date());
		return p;
	}

	@Override
	public Promotion addPromotion(Promotion p, Long idProd) {
		Produit prod=em.find(Produit.class,idProd);
		if(prod==null)
			throw new RuntimeException("Produit introuvable !!");
		p.setProduit(prod);
		em.persist(p);
		return p;
	}

	@Override
	public List<Promotion> findPromotionByProduit(Long idProd) {
		Query req = em.createNamedQuery("Promotion.findByproduit").setParameter("id", idProd);
		return req.getResultList();
	}

	@Override
	public double produitIsOnPromotion(Long idProd, Date date) {
		Query req = em.createQuery("SELECT p.tauxR FROM Promotion " 
				+ "p WHERE p.produit.idProd = ?1 AND P.dateDebut <= ?2 AND P.dateFin >= ?3");
		req.setParameter(1, idProd).setParameter(2, date).setParameter(3, date);
		//Number n = ((Number) req.getSingleResult()).doubleValue();
		Number n =(Number)req.getSingleResult();
		if (n == null)
			return 0;
		else
			return n.doubleValue();

	}

	@Override
	public Commande addCommande(Commande c, Long IdClient) {
		Client cli = em.find(Client.class, IdClient);
		if (cli==null)
			throw new RuntimeException("Client introuble !!");
		c.setClient(cli);
		em.persist(c);
		return c;
	}

	@Override
	public Commande getCommande(Long idCommande) {
		Commande co = em.find(Commande.class, idCommande);
		if (co == null)
			throw new RuntimeException("Commande introuble !!");
		co.getClient();
		return co;
	}

	@Override
	public List<Commande> findCommandeByClient(Long id) {
		Query req = em.createNamedQuery("Commande.findByCommandeJPQL", Commande.class).setParameter(1, id);
		return req.getResultList();
	}

	@Override
	public void addLigne_commande(Long idCommande, Long idProd, int quantite) {
		Commande c = em.find(Commande.class, idCommande);
		Produit p = em.find(Produit.class, idProd);
		if (c==null || p==null)
			throw new RuntimeException("Commande ou produit introvable !!");
		Ligne_Commande lc = new Ligne_Commande(quantite);
		lc.setCommande(c);
		lc.setProduit(p);
		em.persist(lc);

	}

	@Override
	public void deleteLigne_commande(Long idCommande, Long idProd) {
		Ligne_CommandePK lcpk = new Ligne_CommandePK(idCommande, idProd);
		Ligne_Commande lc = em.find(Ligne_Commande.class, lcpk);
		if (lc==null)
			throw new RuntimeException("cette ligne de commande n'exeiste pas dans la base de donnes!!");
		em.remove(lc);

	}

	@Override
	public Ligne_Commande getLigne_Commande(Long idCommande, Long idProd) {
		Ligne_CommandePK lcpk = new Ligne_CommandePK(idCommande, idProd);
		Ligne_Commande lc = em.find(Ligne_Commande.class, lcpk);
		if (lc==null)
			throw new RuntimeException("cette ligne de commande n'exeiste pas dans la base de donnes!!");
		return lc;
	}

	@Override
	public List<Ligne_Commande> findLigne_CommandeByIdCommande(Long idCommande) {
		Query req = em.createNamedQuery("Ligne_Commande.findByIdCommandeJPQL", Ligne_Commande.class)
				.setParameter(1,idCommande);
		return req.getResultList();
	}

	@Override
	public DetailleFacture getDetailleFacture(Long idCommande) {
		DetailleFacture df = new DetailleFacture();
		Commande c = getCommande(idCommande);
		df.setCommande(c);
		df.setClient(c.getClient());
		df.setLigneCommande(findLigne_CommandeByIdCommande(idCommande));
		df.calculTotal();
		return df;
	}

	@Override
	public void addConsultation(Long idClient, Long idCategorie) {
		Client cli = em.find(Client.class, idClient);
		Categorie cat = em.find(Categorie.class, idCategorie);
		if (cli == null || cat == null)
			throw new RuntimeException("Client ou Categorie introuvable !!");
		cli.getCategorie().add(cat);
		cat.getClient().add(cli);
	}

	@Override
	public void addProduitToCategorie(Long idProd, Long idCategorie) {
		Produit p = em.find(Produit.class, idProd);
		Categorie c = em.find(Categorie.class, idCategorie);
		if (p != null && c != null) {
			p.setCategorie(c);
			em.persist(p);
		} else
			throw new RuntimeException("produit ou categorie introuvable !!");

	}

	@Override
	public List<Categorie> findCategorieConsultedByClient(Long id) {
		Client cli = em.find(Client.class, id);
		List<Categorie> l = cli.getCategorie();
		for(Categorie c:l)
			c.getDescription();
		return l;
	}

}
