package projet_NF20;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Chemin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// choix du fichier
		System.out.println("Veuillez choisir le fichier à lire");
		String file = sc.nextLine();

		Graphe g = new Graphe(file);
		g.affiche();

		// Lecture du fichier

		int tab[][] = new int[4][4];
		tab[0][0] = 0;
		tab[0][1] = 5;
		tab[0][2] = 2;
		tab[0][3] = 0;

		tab[1][0] = 5;
		tab[1][1] = 0;
		tab[1][2] = 1;
		tab[1][3] = 5;

		tab[2][0] = 2;
		tab[2][1] = 1;
		tab[2][2] = 0;
		tab[2][3] = 2;

		tab[3][0] = 0;
		tab[3][1] = 5;
		tab[3][2] = 2;
		tab[3][3] = 0;

		int chemin[][] = new int[4][4];
		int sommetVisite[] = new int[4];
		int sommetCourant = 0;
	}
}

