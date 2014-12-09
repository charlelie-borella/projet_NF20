package projet_NF20;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Graphe {

	int[][] gr;
	boolean estOriente;
	
	public Graphe(String file){
		String chaine = lireFichier(file);
	}
	
	public void affiche(){
		for(int i = 0; i<gr.length;i++){
			for(int j = 0 ; j< gr[i].length;j++ ){
				System.out.println(i+" "+j+" "+gr[i][j]);
			}
		}
	}
	
	
	public int[][] getGraphe()
	{
		return this.gr;
	}
	
	public  String lireFichier(String file){
		String chaine="";
		try{
			
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				lireLigne(ligne);
				if(ligne.startsWith("LIST_OF")){
					// On va écrire les lignes suivantes dans une chaine de caractère jusqu'a tomber sur "END"
					while ((ligne=br.readLine())!=null && (!ligne.equals("END"))){
						this.ajoutLigne(ligne);
					}
				}
			}
			br.close(); 
		}	
		catch (Exception e){
			System.out.println(e.toString());
		}
		return chaine;	
	}
	
	// Récupération du nombre de noeuds et d'arrêtes et vérifie si le graphe est orienté ou non
	public void lireLigne(String ligne){
		if(ligne.startsWith("NB_NODES")){ // repere la ligne commencant par NB_NODES
			int nb = ligne.lastIndexOf('\t'); // nb devient le num de la place du caractère de tabulation
			System.out.println(ligne.substring(nb+1)+" nombre de sommets"); //nb+1 pour prendre le caractère après la tabulation
			int nbs=Integer.parseInt(ligne.substring(nb+1));
			this.gr = new int[nbs][nbs];
		}
		else if(ligne.startsWith("NB_EDGES")){
			int nb = ligne.lastIndexOf('\t');
			System.out.println(ligne.substring(nb+1)+" nombre d'arretes");
		}
		else if(ligne.startsWith("UNDIRECTED")){
			//graphe.setOriente(false);
			System.out.println("Le graphe n'est pas orienté");
			estOriente = false;
		}
		else if(ligne.startsWith("DIRECTED")){
			
			System.out.println("Le graphe est orienté");
			estOriente = true;
		}	
	}
	
	public void ajoutLigne(String chaine){
			String noeud1 = "";
			String noeud2 = "";
			String poids = "";
			int cpt = 0; 
			noeud1="";
			noeud2="";
			poids="";
			while(chaine.charAt(cpt)!='\t'){
				noeud1 += chaine.charAt(cpt);
				cpt++;
			}
			cpt++;
			while(chaine.charAt(cpt)!='\t'){
				noeud2 += chaine.charAt(cpt);
				cpt++;
			}
			cpt++;
			while(chaine.charAt(cpt)!='\n'){
				poids += chaine.charAt(cpt);
				if (cpt<chaine.length()-1)cpt++;
				else break;
			}
			// On met les Strings dans des Integer
			int noeud1Int = Integer.parseInt(noeud1);
			//System.out.println(noeud1Int);
			int noeud2Int = Integer.parseInt(noeud2);
			//System.out.println(noeud2Int);
			int poidsInt = Integer.parseInt(poids);
			//System.out.println(poidsInt);
			this.gr[noeud1Int][noeud2Int] = poidsInt;
			if(this.estOriente==false)
			this.gr[noeud2Int][noeud1Int] = poidsInt;	
	}
}