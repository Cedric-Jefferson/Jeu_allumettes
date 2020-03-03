import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Debut d'initialisation des variables
        int m = 20; // Nombre initial d'allumettes
        int m_current = 0; // Nombre d'allumettes réel
        int k = 3; // Nombre max d'allumettes enlevables
        int determinerJoueur = 0; // Jeton de définition du joueur
        char reponse = ' '; // réponse de reprise ou non d'une partie
        String joueur = new String();  
        // Fin d'initialisation des variables
        
        System.out.println("Le nombre initial d'allumettes est de "+ m +"!");
        System.out.println("Le but du jeu est tout simple, vous devez enlever "+ k +" allumettes par tour!");
        System.out.println("Le joueur prenant la dernière allumette perdra la partie!");
        System.out.println("--------------------------------------------------------------------------------");
        do{ // Tant que l'utilisateur envoie le char 'O', on exécute cette boucle
            do{ // Tant que le nbre d'allumettes est > que O on exécute cette boucle
                if (determinerJoueur % 2 == 0 || determinerJoueur == 0) // Permet de switcher les joueurs
                    joueur = "Joueur 1";
                else
                    joueur = "Joueur 2";
                determinerJoueur++;
                
                System.out.println(joueur+" combien d'allumettes souhaitez vous retirer?");
                Scanner sc = new Scanner(System.in);
                int nbreaenlever = sc.nextInt(); 
                
                if (nbreaenlever > 3 || nbreaenlever < 1)
                {
                    nbreaenlever = 0;
                    System.out.println("Impossible d'effectuer cette opération (le nombre d'allumettes à enlever est erroné)");
                    System.out.println(joueur+" passe son tour!");
                }
                if (determinerJoueur == 1) // L'incrementation a déjà eu lieu ci-dessus donc la variable vaut 1 au départ
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
            if (joueur == "Joueur 1" )
                joueur = "Joueur 2";
            else
                joueur = "Joueur 1";
            System.out.println(joueur+" a gagné la partie!");
            System.out.println("--------------------------");
            System.out.println("Voulez vous rejouer? (O/N)");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            reponse = str.charAt(0);

        }while(reponse == 'O');
        System.out.println("Au revoir!");
    }
}