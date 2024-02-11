package exploration;

import exploration.Cases.Arrivee;
import exploration.Cases.Case;
import exploration.Cases.Depart;
import exploration.Cases.Simple;

public class Plateau {

    // Attributs
    private Case[][] grille;
    private int nbCol;
    private int nbLig;

    // Setter.
    public void set(int lig, int col, Case c) { this.grille[lig][col] = c; }
    private void setNbLig(int nbLig) { this.nbLig = nbLig; }
    private void setNbCol(int nbCol) { this.nbCol = nbCol; }

    // Getter.
    public int getNbCol() { return this.nbCol; }
    public int getNbLig() { return this.nbLig; }

    public Case get(int lig, int col) {
        if (lig < 0 || lig > this.getNbLig() + 1 || col < 0 || col > this.getNbCol() + 1) {
            return null;
        } else {
            return this.grille[lig][col];
        }
    }

    // Méthode pour remplir le plateau et placement des cases spéciales selon un
    private void initContenu(Categorie[] liste) {
        double ratio = (double) this.getNbLig() * this.getNbCol() / 100;
        this.set(1, 1, new Depart(this, 1, 1));
        this.set(nbLig, nbCol, new Arrivee(this, nbLig, nbCol));
        for (Categorie courante : liste) {
            int nbAPlacer = (int) (courante.getPourcentage() * ratio);
            for (int cpte = 1; cpte <= nbAPlacer; cpte++) {
                boolean vide;
                do {
                    int col = (int) (Math.random() * this.getNbCol() + 1);
                    int lig = (int) (Math.random() * this.getNbLig() + 1);
                    vide = this.get(lig, col) == null;
                    if (vide) {
                        this.set(lig, col, courante.getCase(this, lig, col));
                    }
                } while (!vide);
            }
        }
        for (int lig = 1; lig <= this.getNbLig(); lig++) {
            for (int col = 1; col <= this.getNbCol(); col++) {
                if (this.get(lig, col) == null) {
                    this.set(lig, col, new Simple(this, lig, col));
                }

            }
        }
    }

    private String affichePlateau() {
        String affichePlateau = "";
        // Numérotation des colonnes.
        String colonnes = "";
        for (int i = 1; i <= this.getNbCol(); i++) { colonnes += "  " + this.get(i, i).getColchar(); }
        affichePlateau += colonnes + "\n";
        // Bord fictif nord du plateau.
        for (int i = 1; i <= this.getNbCol(); i++) { affichePlateau += "  " + "-"; }
        affichePlateau += "\n";
        // Bord fictif nord du plateau.
        for (int i = 1; i <= this.getNbCol(); i++) {
            if (i == 1) {
                affichePlateau += "" + ">";
            } else {
                affichePlateau += "|";
            }
            // Caractère spéficifique à chaque case.
            String ligne = "";
            for (int j = 1; j <= this.getNbCol(); j++) {
                if (this.get(i, j).isVisible() && !(this.get(i, j).isPosJoueur())) {
                    ligne += " " + this.get(i, j).toString() + " ";
                } else if (this.get(i, j).isPosJoueur()) {
                    ligne += " " +Jeu.green+ "$" +Jeu.white+ " ";
                } else {
                    ligne += "   ";
                }
            }
            // Numérotations des lignes.
            if (i == this.getNbLig()) 
                ligne += "> " + this.get(i, 1).getLigchar();
            else  
                ligne += "| " + this.get(i, 1).getLigchar();
            
            affichePlateau += ligne + "\n";
        }
        // Bord fictif sud du plateau.
        for (int i = 1; i <= this.getNbCol(); i++) { affichePlateau += "  " + "-"; }
        affichePlateau += "\n";
        // Affichage du plateau.
        return affichePlateau;
    }

    // Affichage du plateau et de ses bords.
    @Override
    public String toString() {
        return affichePlateau();
    }

    // Constructeur du plateau et création des cases selon le ratio.
    public Plateau(int nbCol, int nbLig, Jeu jeu, Categorie... liste) {
        this.setNbCol(nbCol);
        this.setNbLig(nbLig);
        this.grille = new Case[nbLig + 2][nbCol + 2];
        this.initContenu(liste);
    }

}
