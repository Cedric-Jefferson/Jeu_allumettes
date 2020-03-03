package test;

import java.util.Scanner;

public class App {
	
    public static void main(String[] args) {
        // Debut d'initialisation des variables
        int m = 20; // Nombre initial d'allumettes
        int m_current = 0; // Nombre d'allumettes reel
        int k = 3; // Nombre max d'allumettes enlevables
        int determinerJoueur = 0; // Jeton de definition du joueur
        char reponse = ' '; // reponse de reprise ou non d'une partie
        Joueur joueur1 = new Joueur(1,"Joueur 1");
        Joueur joueur2 = new Joueur(2,"Joueur 2");
        String joueur = new String();
        // Fin d'initialisation des variables
        
        System.out.println("Le nombre initial d'allumettes est de "+ m +"!");
        System.out.println("Le but du jeu est tout simple, vous pouvez enlever au max "+ k +" allumettes par tour!");
        System.out.println("Le joueur prenant la derniere allumette perdra la partie!");
        System.out.println("--------------------------------------------------------------------------------");
        do{ // Tant que l'utilisateur envoie le char 'O', on execute cette boucle
        	m_current = m;
            do{ // Tant que le nbre d'allumettes est > que O on execute cette boucle
                if (determinerJoueur % 2 == joueur1.getNumber()-1 || determinerJoueur == joueur1.getNumber()-1) // Permet de switcher les joueurs
                    joueur = joueur1.getNom();
                else
                    joueur = joueur2.getNom();
                determinerJoueur++;
                
                System.out.println(joueur+" combien d'allumettes souhaitez vous retirer?");
                Scanner sc = new Scanner(System.in);
                int nbreaenlever = sc.nextInt(); 
                
                if (nbreaenlever > 3 || nbreaenlever < 1)
                {
                    nbreaenlever = 0;
                    System.out.println("Impossible d'effectuer cette operation (le nombre d'allumettes a enlever est errone)");
                    System.out.println(joueur+" passe son tour!");
                }
                if (determinerJoueur == 1) // L'incrementation a deja  eu lieu ci-dessus donc la variable vaut 1 au dÃ©part
                {
                    m_current = m - nbreaenlever;
                }
                if (determinerJoueur > 1)
                {
                    m_current = m_current - nbreaenlever;
                }
                System.out.println("Il reste donc "+m_current+" allumettes!");
                System.out.println("--------------------------------------------");

            }while(m_current > 0);
            if (joueur == joueur1.getNom() )
                joueur = joueur2.getNom();
            else
                joueur = joueur1.getNom();
            System.out.println(joueur+" a gagne la partie!");
            System.out.println("--------------------------");
            System.out.println("Voulez vous rejouer? (O/N)");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            reponse = str.charAt(0);

        }while(reponse == 'O');
        System.out.println("Au revoir!");
    }
}