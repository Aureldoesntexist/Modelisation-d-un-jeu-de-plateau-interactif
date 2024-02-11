package exploration;

public class Jeu {

    // Méthode pour coloriser le texte de l'invite de commande
    public final static String white = "\u001B[0m";
    public static final String yellow = "\u001B[33m";
    public static final String purple =  "\u001B[35m";
    public static final String green   =  "\u001B[32m";
    public static final String red   =  "\u001B[31m";
    public static final String blue   = "\u001B[34m";
    public static final String black =  "\u001b[30m";
    public static final String cyan = "\u001B[36m";

    // Attributs.
    private Joueur joueur;
    private Plateau grille;

    // Setter.
    public void setJoueur(Joueur joueur) { this.joueur = joueur; }
    public void setGrille(Plateau grille) {this.grille = grille;}
    public void setPlateau(Plateau plateau) { this.grille = plateau;}

    // Getter
    public Joueur getJoueur() { return this.joueur; }
    public Plateau getGrille() {return grille; }
    public Plateau getPlateau() { return grille;}

    //Boolean
    public boolean isFini() { return this.getJoueur().isGagnant() || this.getJoueur().isPerdant();}

    public void joue() {
        System.out.println("Le joueur est symbolisé par : "+this.joueur.toString());
        // Affiche Plateau
        System.out.println(this.getPlateau().toString());
        while (!isFini()) {
            // Demande direction
            Direction direction = Direction.getDirectionJoueur(yellow+"Choisissez une direction"+white);
            // Lancer une pierre ou se déplacer
            String choixAction = Lire.S(yellow+"Voulez-vous avancer ou lancer une pierre ? (a/p)"+white);
            switch (choixAction) {
                case "a":
                    // On déplace le joueur dans la direction choisie
                    this.joueur.deplace(direction);
                    // Affiche position
                    System.out.println(cyan+"Position du joueur : "+this.joueur.getPosition().getCoord());
                    // Affiche nombre de pierres
                    System.out.println("Le joueur a "+this.joueur.getNbPierres()+ " pierres."+white);
                    // Affiche plateau
                    System.out.println(this.getPlateau().toString());

                    break;
                case "p":
                    // On lance une pierre dans la direction choisie
                    this.joueur.lancePierre(direction);
                    System.out.println("Le joueur a "+this.joueur.getNbPierres()+ " pierres.");
                    System.out.println(this.getPlateau().toString());   
                    break;
            }
        }
        
    }

    public Jeu(int nbLig, int nbCol, int nbPierres, Categorie... liste) {
        this.setPlateau(new Plateau(nbCol, nbLig, this, liste));
        this.setJoueur(new Joueur(Lire.S("Nom du joueur"), this.getPlateau().get(1, 1), nbPierres * nbCol * nbLig / 100));     
    }

}
