package exploration;
public class Exploration {
    public static void main(String[] args) {
        Categorie pierres = new Categorie(5, "Pierres");
        Categorie mines = new Categorie(8, "Mine");
        Categorie transferts = new Categorie(7, "Transfert");
        Categorie obstacles = new Categorie(1, "Obstacle");
        Jeu jeu = new Jeu(5, 5, 8, pierres, mines, transferts, obstacles);
        jeu.joue();
    }
}
