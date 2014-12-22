package projet_NF20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Prim {
	
	private ArrayList<ArrayList<ArrayList<Integer>>> list3D = new ArrayList<ArrayList<ArrayList<Integer>>>();
	private ArrayList<Integer> sommetVisite;
	private  ArrayList<ArrayList<ArrayList<Integer>>> resultat = new ArrayList<ArrayList<ArrayList<Integer>>>();
	private long[] grapheComplexite;
	private int coupTotal;
	
	public Prim(Graphe g)
	{
		this.list3D = g.getList3D();
		this.sommetVisite = new ArrayList<Integer>();
		this.grapheComplexite = new long[this.list3D.size()];
		this.coupTotal = 0;
	}
	
	public int getCoupTotal(){
		return this.coupTotal;
	}
		
	public void supCycle(int sommetAdj, int sommet)
	{
		this.list3D.get(sommet).remove(0);
		for (int i = 0; i < this.list3D.get(sommetAdj).size(); i++) {
			if(this.list3D.get(sommetAdj).get(i).get(0) == sommet){
				this.list3D.get(sommetAdj).remove(i);
				break;
			}
		}
	}
	
	public ArrayList<Integer> getSommetMinPoids(int sommet)
	{
		//System.out.println("Sommet: " + sommet + " Sommet adj: "+ this.list3D.get(sommet).get(0).get(0)+ " Poids: " +this.list3D.get(sommet).get(0).get(1));
		return this.list3D.get(sommet).get(0);
	}
	
	public ArrayList<Integer> getCompareToutLesMin()
	{
		ArrayList<ArrayList<Integer>> listeComparaison = new ArrayList<ArrayList<Integer>>();//Stock tout les minimums de tout les sommets
		ArrayList<Integer> minimum = new ArrayList<Integer>();//Stock le minimun 

		for (int i = 0; i < this.sommetVisite.size(); i++) {
			listeComparaison.add(getSommetMinPoids(this.sommetVisite.get(i)));
			//System.out.println("Sommet: "+ listeComparaison.get(i).get(0) + " Poids: " + listeComparaison.get(i).get(1));
		}
		int sommet=0;
		for (int i = 0; i < listeComparaison.size(); i++) {
			
			if(i==0){
				minimum = listeComparaison.get(i);
				sommet=i;
			}
			else if(listeComparaison.get(i).get(1).intValue() < minimum.get(1))
			{
				minimum = listeComparaison.get(i);
				sommet=i;
			}
		}
		this.supCycle(minimum.get(0), sommet);
		return minimum;
		
	}
	
	public void affichage(){
		String res = "";
		for (int i = 0; i < sommetVisite.size(); i++) {
			res+= this.sommetVisite.get(i) + "; ";
		}
		System.out.println("Résultat : \n" + res);
	}
	
	public void triCroissant()
	{
		boolean trie;
	  
		long debut = System.currentTimeMillis();
		for (int i = 0; i < this.list3D.size() ; i++) {
			int taille = this.list3D.get(i).size();
			do
			{
				trie = false;
			    for(int j=0 ; j < taille-1 ; j++)
			    {
			        if(this.list3D.get(i).get(j).get(1) > this.list3D.get(i).get(j+1).get(1))
			        {
			          	int tempoSommet = this.list3D.get(i).get(j).get(0).intValue();
			            int tempoPoids = this.list3D.get(i).get(j).get(1).intValue();
			            this.list3D.get(i).get(j).set(0, this.list3D.get(i).get(j+1).get(0).intValue());
			            this.list3D.get(i).get(j).set(1, this.list3D.get(i).get(j+1).get(1).intValue());
			            this.list3D.get(i).get(j+1).set(0, tempoSommet);
			            this.list3D.get(i).get(j+1).set(1, tempoPoids);
			            trie = true;
			        }			       
			    }
			    taille--;
			}while(trie);
		}
		System.out.println("\n \n Temps d'éxécution tri Croissant: " + ((System.currentTimeMillis() - debut)/1000 ) + "\n");
	}
	
	public void Prim()
	{
		triCroissant();
		long debut = System.currentTimeMillis();
		long dureeDeTraitement = 0;
		for (int i = 0; i < this.list3D.size()-1 ; i++) {
			ArrayList<Integer> resultat;
			if(i==0){
				this.sommetVisite.add(i);				
				resultat=getSommetMinPoids(i);
				this.supCycle(resultat.get(0), i);
				this.coupTotal+=resultat.get(1);
				//System.out.println("Sommet ajouté: " + i );
			}else{
				resultat = this.getCompareToutLesMin();
				this.coupTotal+=resultat.get(1);
			}		
			//System.out.println("Coup: "+ this.coupTotal);
			this.sommetVisite.add(resultat.get(0));
			dureeDeTraitement = (System.currentTimeMillis()-debut);
			//System.out.println(dureeDeTraitement);
			this.grapheComplexite[i] = dureeDeTraitement;
			//System.out.println("Sommet ajouté:" + resultat.get(0) );
			//System.out.println("Nombre de sommet visités: " + this.sommetVisite.size());
		}
		System.out.println("\n \n Temps d'éxécution Prim: " + ((System.currentTimeMillis() - debut) / 1000) + " \n");
	}
	
	public void affichageList3D() {
		long debut = System.currentTimeMillis();
		System.out.println("Affichage de l'ArrayList ");
		for (int i = 0; i < this.list3D.size(); i++) {
			String affichage = "S " + i + " A : ";
			for (int j = 0; j < this.list3D.get(i).size(); j++) {
				for (int j2 = 0; j2 < this.list3D.get(i).get(j).size(); j2++) {
					affichage += this.list3D.get(i).get(j).get(j2) + " ";
				}
			}
			System.out.println(affichage);
		}
		System.out.println("\n \n Temps d'éxécution affichage liste3D: " + ((System.currentTimeMillis() - debut) / 1000) + "\n");

	}
	
	public void recupererGraphe(){

		File f = new File ("primComplexite.txt");
		try
		{
		    FileWriter fw = new FileWriter (f);
		 
		    for (int i = 0; i < this.grapheComplexite.length; i++) {
		    		fw.write(i + "\n");	
		    }		    
		    fw.write("------------\n");		    
		    for (int i = 0; i < this.grapheComplexite.length; i++) {
	    			long valeur = this.grapheComplexite[i];
	    			fw.write(valeur + "\n"); 		
	    }
		    System.out.println("Graphe récupéré");
		    fw.close();
		}
		catch (IOException exception)
		{	
			System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}


	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// choix du fichier
		//System.out.println("Veuillez choisir le fichier à lire");
		//String file = sc.nextLine();

		//Graphe g = new Graphe("graphe_k5.dat");
		Graphe g = new Graphe("inst_v1000.dat");
		Prim p = new Prim(g);
		//p.affichageList3D();
		//long debut = System.currentTimeMillis();
		//p.triCroissant();
		//p.affichageList3D();
		p.Prim();
		System.out.println("Poids total: "+ p.getCoupTotal());
		//p.affichage();
		//p.affichageList3D();
		//System.out.println("\n \n Temps d'éxécution global: ");
		//System.out.println((System.currentTimeMillis() - debut) / 1000);
		p.recupererGraphe();
	}
	
}