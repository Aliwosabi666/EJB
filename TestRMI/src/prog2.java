import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.msglc.entites.Categorie;
import com.msglc.entites.Client;
import com.msglc.entites.Commande;
import com.msglc.entites.Ligne_Commande;
import com.msglc.entites.ModePaiement;
import com.msglc.entites.Produit;
import com.msglc.entites.Promotion;
import com.msglc.module.DetailleFacture;
import com.msglc.services.VenteDaoRemote;



public class prog2 {

	public static void main(String[] args) {
		Context ctx;
		VenteDaoRemote remote;
		try {
			ctx = new InitialContext();
			remote = (VenteDaoRemote) ctx.lookup("ejb:/Vente/VenteDao!com.msglc.services.VenteDaoRemote");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			Date d = new Date();
			
		
			Client c1 = new Client("Ali", "Mohammed", "Ali@gmail.com", "0639847483", "193848", "Address1", "cp", "kénitra", "Maroc");
			Client c2 = new Client("khaled", "Salamn", "khaled@gmail.com", "0639847483", "193848", "Address1", "cp", "kénitra", "Maroc");
			c1=remote.addClient(c1);
			c2=remote.addClient(c2);

			List<Client> liste_1 = remote.findClientByMC("");
			for (Client c : liste_1) {
				System.out.println(
						"NomClient :" + c.getNom() + " EmailClient:" + c.getEmail());
			}
			
			
			Categorie Categorie_1 = new Categorie("Bureautique");
			Categorie_1 = remote.addCategorie(Categorie_1);
			
			Categorie Categorie_2 = new Categorie("Informatique");
			Categorie_2 = remote.addCategorie(Categorie_2);
			
			List<Categorie> liste_2 = remote.getAllCategorie();
				for (Categorie c : liste_2) {
					System.out.println(
							"Id Categorie :" + c.getIdCategorie() + " Description Categorie:" + c.getDescription());
				}
				
			
			Categorie Categorie_3 = remote.getCategorie(Categorie_2.getIdCategorie());
			System.out.println(Categorie_3.getIdCategorie()+" "+Categorie_3.getDescription());
			
			
			remote.addConsultation(c1.getId(), Categorie_1.getIdCategorie());
			remote.addConsultation(c2.getId(), Categorie_2.getIdCategorie());
			
			Produit Produit_1 = new Produit("Table", 1000,d);
			Produit_1 = remote.addProduit(Produit_1);
			
			Produit Produit_2 = new Produit("Table", 1000,d);
			Produit_2 = remote.addProduit(Produit_2);
			
			
			remote.addProduitToCategorie(Produit_2.getIdProd(), Categorie_1.getIdCategorie());
			
			List<Produit> list_3 = remote.findProduitByCategorie(Categorie_1.getIdCategorie());
			for (Produit p : list_3) {
				System.out.println(
						"Id Produit:" + p.getIdProd() + " Designation Produit:" + p.getDesignation());
			}
			
			
			Promotion Promotion_1 = new Promotion(d,sdf.parse("17/04/2020"),0.05);
			remote.addPromotion(Promotion_1, Produit_1.getIdProd());
			
			//System.out.println(remote.produitIsOnPromotion(Produit_2.getIdProd(), d));
			
			Commande Commande_1 = new Commande(d, false, ModePaiement.CarteBancaire);
			Commande_1=remote.addCommande(Commande_1, c1.getId());
			
			
			List<Commande> list_4 =remote.findCommandeByClient(c1.getId());
			for (Commande p : list_4) {
				System.out.println(
						"id Commande :" + p.getIdCommande() + " Date Commande:" + p.getDateC());
			}
			
			remote.addLigne_commande(Commande_1.getIdCommande(), Produit_1.getIdProd(), 4);
			remote.addLigne_commande(Commande_1.getIdCommande(), Produit_2.getIdProd(), 10);
			
			
			Ligne_Commande lc =remote.getLigne_Commande(Commande_1.getIdCommande(), Produit_1.getIdProd());
			System.out.println(lc.getQuantite());
			
			remote.deleteLigne_commande(Commande_1.getIdCommande(), Produit_1.getIdProd());
			
			DetailleFacture df=remote.getDetailleFacture(Commande_1.getIdCommande());
			System.out.println("-------------------------Facture---------------------------");
			System.out.println(df.getClient().getId()+" "+df.getClient().getNom()+" "+df.getClient().getEmail());
			System.out.println("----------------------Fin Facture---------------------------");
			
			
			
			for(Ligne_Commande ligne:df.getLigneCommande())
			{
				System.out.println(ligne.getProduit().getIdProd()+ " "+ligne.getProduit().getDesignation()
						+ligne.getProduit().getPu()+" "+ligne.getQuantite());
			}
			
			System.out.println("----------------------------------------------------------------");
			System.out.println("Total de la facture :"+df.getTotal());
			System.out.println("----------------------------------------------------------------");
			
			List<Categorie> list_5 =remote.findCategorieConsultedByClient(c1.getId());
			for(Categorie c: list_5) {
				
				System.out.println(c.getDescription());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
