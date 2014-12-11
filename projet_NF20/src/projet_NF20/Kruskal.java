package projet_NF20;

import java.util.ArrayList;


public class Kruskal {
	
	public int[][] Kruskal(Graphe g, ArrayList<ArrayList<ArrayList<Integer>>> gr){
		
		ArrayList<Integer> sommetParcouru = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		
		int[][] temp1 = new int[poids.length][];
		
		int tmp1 = 0; 
		int tmp2 = 0;
		int tmpPoids = -1;
		
		for(int l = 0; l<g.nbAretes; l++){
			//trouve la plus petite arête
			for (int i = 0; i < gr.size();i++){
				for (int j = 0; j < gr.get(i).size();j++){
					if(tmpPoids==-1 || tmpPoids>gr.get(i).get(j).get(1)){
						tmpPoids = gr.get(i).get(j).get(1);
						tmp1 = i;
						tmp2 = j;				
					}
				}
			}
			
			temp1[tmp1][tmp2] = poids[tmp1][tmp2];
			poids[tmp1][tmp2]=-1;
			
			//regarder si dans temp il y a un sommet qui est maintenant dans SommetParcouru
			//si oui, ajouter le sommet manquant
			if(!temp.isEmpty()){
				for (int i = 0; i < temp.size(); i++){
					for (int j = 0; j < temp.get(i).size(); j++){
						for(int k = 0; k < sommetParcouru.size(); k++){
							if(temp.get(i).get(j)==sommetParcouru.get(k)){
								sommetParcouru.addAll(temp.get(i));
							}
						}
					}
				}
			} 

			sommetParcouru.add(tmp1);
			sommetParcouru.add(tmp2);
			
			for(int i = 0; i < sommetParcouru.size(); i++){
				
			}
			
			//regarder si tmp1 est déjà dans sommetParcouru
			//si oui, ajouter juste j à la liste 
			//si tmp2 est déjà dans la liste ajouter i
			//si ni i ni j ne sont dans la liste alors les ajouter dans temp
			//supprimer les doublons dans la liste sommetParcouru
			/*
			ArrayList list = new ArrayList() ;
	        Set set = new HashSet() ;
	        set.addAll(list) ;
	        ArrayList distinctList = new ArrayList(set) ;
			 */
		}
		return temp1;

		/*int[][] temp1 = new int[g.gr.length][];
		int[][] temp2 = g.gr;

		int nb1 = -1;
		int nb2 = -1;
		boolean test;
		
		//je remplie la matrice avec la valeur -1
		for(int i = 0; i<g.gr.length; i++){
			for(int j = 0; j<g.gr[i].length; j++){
				temp1[i][j] = -1;
			}
		}
		
		for(int i = 0; i<g.nbAretes; i++){
			for(int j = 0; j<g.nbAretes-1; j++){
				for(int k = 0; k<g.nbAretes-1; k++){
					if(temp2[j][k]<temp2[j+1][k+1]){
						nb1=j;
						nb2=k;
					}
				}
			}
			temp1[nb1][nb2]=g.gr[nb1][nb2];
			temp2[nb1][nb2]=-1;
			
			test = rechercheCycle(temp1);
			if (test == true){
				temp1[nb1][nb2]=-1;
			}
		}
		return temp1;*/
	}
	
	public boolean rechercheCycle(int[][] tmpGr){
		boolean b = true;
		
		return b;
	}
}
