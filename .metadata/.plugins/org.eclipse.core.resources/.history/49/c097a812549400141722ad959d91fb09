package projet_NF20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Cycle {

		
		//mettre accesseur mutateur aprËs
		int[][] gr;
		boolean estOriente;
		boolean estFaisable = true;
		int nbAretes = 0;
		int nbNodes = 0;
		ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<ArrayList<Integer>>> list3D = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<ArrayList<Integer>>> grapheConstruction = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<Integer> sommetVisite = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> cycle = new ArrayList<ArrayList<Integer>>();
		String erreur;
		private long[] grapheComplexite;

		public Graphe(String file) {
			String chaine = lireFichier(file);
		}
		
		public void afficheMatrice() {
			long debut = System.currentTimeMillis();
			System.out.println("Affichage de la matrice \br");
			for (int i = 0; i < gr.length; i++) {
				for (int j = 0; j < gr[i].length; j++) {
					System.out.println(i + " " + j + " " + gr[i][j]);
				}
			}
			System.out.println("\n \n Temps d'√©x√©cution: ");
			System.out.println((System.currentTimeMillis() - debut) / 1000);
		}
		public void recupererGraphe(){

			  File f = new File ("primComplexite1000.txt");
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
			      System.out.println("Graphe rÈcupÈrÈ");
			      fw.close();
			  }
			  catch (IOException exception)
			  { 
			   System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			  }
			 }
		
		public void affichageList2D() {
			long debut = System.currentTimeMillis();
			System.out.println("Affichage de l'ArrayList " + this.nbNodes);
			for (int i = 0; i < this.list2D.size(); i++) {
				String affichage = "S " + i + " A : ";
				for (int j = 0; j < this.list2D.get(i).size(); j++) {
					affichage += list2D.get(i).get(j) + " ";
				}
				System.out.println(affichage);
			}
			System.out.println("\n \n Temps d'√©x√©cution: ");
			System.out.println((System.currentTimeMillis() - debut) / 1000);

		}
		
		public void affichagecycle() {
			long debut = System.currentTimeMillis();
			System.out.println("Affichage du cycle ");
			for (int i = 0; i < this.cycle.size(); i++) {
				String affichage = "S " + i + " A : ";
				for (int j = 0; j < this.cycle.get(i).size(); j++) {
					affichage += cycle.get(i).get(j) + " ";
				}
				System.out.println(affichage);
			}
			

		}

		/*
		 * Pour avoir un sommet 0 = this.list3D.get(0)
		 * Pour avoir les sommets adjacents au sommet et poid 0 = 
		 * for(int i=0 ; i< this.list3D.get(0).size(); i++)
		 * {
		 *		 this.list3D.get(0).get(i).get(O); //num√©ro du sommet adjacent
		 *		 this.list3D.get(0).get(i).get(1); //poid du sommet 
		 * }
		 * 
		 */
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
			System.out.println("\n \n Temps d'√©x√©cution: ");
			System.out.println((System.currentTimeMillis() - debut) / 1000);

		}
		
		public void affichageGrapheElimination() {
			long debut = System.currentTimeMillis();
			System.out.println("Affichage de l'ArrayList ");
			for (int i = 0; i < this.grapheConstruction.size(); i++) {
				String affichage = "S " + i + " A : ";
				for (int j = 0; j < this.grapheConstruction.get(i).size(); j++) {
					for (int j2 = 0; j2 < this.grapheConstruction.get(i).get(j).size(); j2++) {
						affichage += this.grapheConstruction.get(i).get(j).get(j2) + " ";
					}

				}
				System.out.println(affichage);
			}
			System.out.println("\n \n Temps d'√©x√©cution: ");
			System.out.println(erreur);
			System.out.println((System.currentTimeMillis() - debut) / 1000);

		}

		public int[][] getMatriceGraphe() {
			return this.gr;
		}

		public ArrayList<ArrayList<Integer>> getListGraphe() {
			return this.list2D;
		}
		
		public void EliminationDeCycle(int actu, int pred){
			boolean dejaViste=false;
			if(sommetVisite.isEmpty()==false){
				for(int i = 0; i<sommetVisite.size();i++){
					if(sommetVisite.get(i)==actu){
					dejaViste=true;
				
					}
				}
			}
			boolean dejapresente=false;
			for(int n = 0;n<= grapheConstruction.get(actu).size()-1;n++){
				if(grapheConstruction.get(actu).get(n).get(0)==pred){
					dejapresente=true;
					
				}
			}
			if(pred != -1 && dejapresente==false){
				grapheConstruction.get(actu).add(new ArrayList<Integer>());
				grapheConstruction.get(actu).get(grapheConstruction.get(actu).size()-1).add(pred);
				grapheConstruction.get(pred).add(new ArrayList<Integer>());
				grapheConstruction.get(pred).get(grapheConstruction.get(pred).size()-1).add(actu);
				
			
			for(int j = 0 ; j<= list3D.get(actu).size()-1;j++){
				if(list3D.get(actu).get(j).get(0)==pred){
					
					grapheConstruction.get(actu).get(grapheConstruction.get(actu).size()-1).add(list3D.get(actu).get(j).get(1));
					grapheConstruction.get(pred).get(grapheConstruction.get(pred).size()-1).add(list3D.get(actu).get(j).get(1));
				}
			}
			}
			if(dejaViste!=true){
				sommetVisite.add(actu);
					
				for(int k = 0; k<= list3D.get(actu).size()-1;k++){
				
					if(list3D.get(actu).get(k).get(0) != pred){
						EliminationDeCycle(list3D.get(actu).get(k).get(0), actu);
					}
				}
			
			}
			else if(dejaViste && dejapresente==false){
				
				
				cycle.removeAll(cycle);
				//affichageGrapheElimination();
				if(detectionCycle(actu,pred,actu,0)==false){
					erreur="erreur dans la detection";
					System.out.println("error");
					//affichageGrapheElimination();
				}
			}
		}
		
		public boolean detectionCycle(int actu, int pred, int cible, int numInstance){
		
		
		if( numInstance == 0){
			for(int k =0; k<= grapheConstruction.get(actu).size()-1;k++){				
				  
					if(detectionCycle(grapheConstruction.get(actu).get(k).get(0), actu, cible,1)){
						return true;
					
					}	
				
			}
			
			return false;
		}
		else if(actu!=cible){
				if(grapheConstruction.get(actu).size()!=1){
					for(int u =0; u<= grapheConstruction.get(actu).size()-1;u++){	
						if(grapheConstruction.get(actu).get(u).get(0)==pred){
							cycle.add(new ArrayList<Integer>());
							cycle.get((cycle.size()-1)).add(actu);
							cycle.get((cycle.size()-1)).add(pred);
							cycle.get((cycle.size()-1)).add(grapheConstruction.get(actu).get(u).get(1));
						}
					}
					for(int j =0; j<= grapheConstruction.get(actu).size()-1;j++){				
						if(grapheConstruction.get(actu).get(j).get(0)!=pred && grapheConstruction.get(actu).get(j).get(0)==cible){ 
							
							if(detectionCycle(grapheConstruction.get(actu).get(j).get(0), actu, cible,1)){
								return true;
							}
						}
					}
					for(int j =0; j<= grapheConstruction.get(actu).size()-1;j++){				
						if(grapheConstruction.get(actu).get(j).get(0)!=pred){ 
							
							if(detectionCycle(grapheConstruction.get(actu).get(j).get(0), actu, cible,1)){
								return true;
							}
						}
					}
				cycle.remove(cycle.size()-1);
				return false;
				}return false;
			}
			else{
				
				for(int u =0; u<= grapheConstruction.get(actu).size()-1;u++){	
					if(grapheConstruction.get(actu).get(u).get(0)==pred){
						cycle.add(new ArrayList<Integer>());
						cycle.get((cycle.size()-1)).add(actu);
						cycle.get((cycle.size()-1)).add(pred);
						cycle.get((cycle.size()-1)).add(grapheConstruction.get(actu).get(u).get(1));
					}
				}
				
				int max=-1;
				int numMax=-1;
				int numMax2=-1;
				for(int i=0; i<= cycle.size()-1;i++){
					if(cycle.get(i).get(2)>max){
						max = cycle.get(i).get(2);
						numMax=cycle.get(i).get(0);
						numMax2=cycle.get(i).get(1);
					}				
				}
				for(int v = 0; v <= grapheConstruction.get(numMax).size()-1;v++){
					if(grapheConstruction.get(numMax).get(v).get(0)==numMax2){
						grapheConstruction.get(numMax).remove(v);
					}
				}
				for(int b = 0; b <= grapheConstruction.get(numMax2).size()-1;b++){
						if(grapheConstruction.get(numMax2).get(b).get(0)==numMax){
							grapheConstruction.get(numMax2).remove(b);
							
						}
					
				}
				return true;
				
			}
		}
		public void affichepoid(){
			int cout = 0;
			//parcours de la liste o˘ se trouvent les sommets et les arrÍtes
			for(int j=0 ; j<= this.grapheConstruction.size()-1; j++){
			 //parcours de la sous liste avec les sommets principaux
			 for(int i=0 ; i<= this.grapheConstruction.get(j).size()-1; i++){
			  cout+= this.grapheConstruction.get(j).get(i).get(1); //poids de l'arÍte 
			 }
			}
			System.out.println(" poid = "+cout/2);
		}
		
		
		

		public String lireFichier(String file) {
			String chaine = "";
			try {

				InputStream ips = new FileInputStream(file);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
				String ligne;
				while ((ligne = br.readLine()) != null) {
					lireLigne(ligne);
					if (ligne.startsWith("LIST_OF")) {
						// On va √©crire les lignes suivantes dans une chaine de
						// caract√®re jusqu'a tomber sur "END"
						while ((ligne = br.readLine()) != null
								&& (!ligne.equals("END"))) {
							this.ajoutLigne(ligne);
						}
					}
				}
				br.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return chaine;
		}

		// R√©cup√©ration du nombre de noeuds et d'arr√™tes et v√©rifie si le graphe est
		// orient√© ou non
		public void lireLigne(String ligne) {
			if (ligne.startsWith("NB_NODES")) { // repere la ligne commencant par
												// NB_NODES
				int nb = ligne.lastIndexOf('\t'); // nb devient le num de la place
													// du caract√®re de tabulation
				System.out.println(ligne.substring(nb + 1) + " nombre de sommets"); // nb+1
																					// pour
																					// prendre
																					// le
																					// caract√®re
																					// apr√®s
																					// la
																					// tabulation
				int nbs = Integer.parseInt(ligne.substring(nb + 1));
				this.nbNodes = nbs;
				this.initialisationArrayList2D();
				this.initialisationArrayList3D();
				this.gr = new int[nbs][nbs];
			} else if (ligne.startsWith("NB_EDGES")) {
				int nb = ligne.lastIndexOf('\t');
				System.out.println(ligne.substring(nb + 1) + " nombre d'arretes");
				nbAretes=Integer.parseInt(ligne.substring(nb+1));
			} else if (ligne.startsWith("UNDIRECTED")) {
				// graphe.setOriente(false);
				System.out.println("Le graphe n'est pas orientÈ");
				estOriente = false;
			} else if (ligne.startsWith("DIRECTED")) {

				System.out.println("Le graphe est orientÈ");
				estOriente = true;
			}
		}

		public void initialisationArrayList2D() {
			for (int i = 0; i < this.nbNodes; i++) {
				this.list2D.add(new ArrayList<Integer>());
			}
		}

		public void initialisationArrayList3D() {
			for (int i = 0; i < this.nbNodes; i++) {
				this.list3D.add(new ArrayList<ArrayList<Integer>>());
			}
			
			for (int i = 0; i < this.nbNodes; i++) {
				this.grapheConstruction.add(new ArrayList<ArrayList<Integer>>());
			}
		}

		public void ajoutLigne(String chaine) {

			String noeud1 = "";
			String noeud2 = "";
			String poids = "";
			int cpt = 0;
			noeud1 = "";
			noeud2 = "";
			poids = "";
			while (chaine.charAt(cpt) != '\t') {
				noeud1 += chaine.charAt(cpt);
				cpt++;
			}
			cpt++;
			while (chaine.charAt(cpt) != '\t') {
				noeud2 += chaine.charAt(cpt);
				cpt++;
			}
			cpt++;
			while (chaine.charAt(cpt) != '\n') {
				poids += chaine.charAt(cpt);
				if (cpt < chaine.length() - 1)
					cpt++;
				else
					break;
			}
			// On met les Strings dans des Integer
			int noeud1Int = Integer.parseInt(noeud1);
			// System.out.println(noeud1Int);
			int noeud2Int = Integer.parseInt(noeud2);
			// System.out.println(noeud2Int);
			int poidsInt = Integer.parseInt(poids);
			// System.out.println(poidsInt);

			this.list2D.get(noeud1Int).add(noeud2Int);

			this.list3D.get(noeud1Int).add(new ArrayList<Integer>());
			// System.out.println(this.list3D.get(noeud1Int).size()-1);
			this.list3D.get(noeud1Int).get(this.list3D.get(noeud1Int).size() - 1)
					.add(noeud2Int);
			this.list3D.get(noeud1Int).get(this.list3D.get(noeud1Int).size() - 1)
					.add(poidsInt);

			this.gr[noeud1Int][noeud2Int] = poidsInt;
			if (this.estOriente == false) {
				this.gr[noeud2Int][noeud1Int] = poidsInt;
				this.list2D.get(noeud2Int).add(noeud1Int);

				this.list3D.get(noeud2Int).add(new ArrayList<Integer>());
				this.list3D.get(noeud2Int)
						.get(this.list3D.get(noeud2Int).size() - 1).add(noeud1Int);
				this.list3D.get(noeud2Int)
						.get(this.list3D.get(noeud2Int).size() - 1).add(poidsInt);

			}
			
			//vÈrifie si le noeud 1 et le noeud 2 sont positifs
			if(poidsInt< 0){
				System.out.println("Le graphe ne peut Ítre ÈtudiÈ, certains poids sont nÈgatifs.");
				this.estFaisable = false;
			}

		}
	}
}
