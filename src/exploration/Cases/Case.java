package exploration.Cases;

import exploration.Direction;
import exploration.Joueur;
import exploration.Plateau;

public abstract class Case {

    // Attributs.
    protected Plateau plateau;
    protected int col;
    protected int lig;
    protected int pierre;
    protected boolean caseVisible;
    protected boolean active;
    protected boolean posJoueur;

    // Setter.
    private static char getNumChar(int num) { return (char) ('A' + num - 1); }
    private void setPlateau(Plateau plateau) { this.plateau = plateau; }
    protected void setCol(int col) { this.col = col; }
    protected void setPierre(int i) { this.pierre = i; }
    protected void setLig(int lig) { this.lig = lig; }

    // Getter.
    public Plateau getPlateau() { return this.plateau; }
    public int getLig() { return this.lig; }
    public char getLigchar() { return Case.getNumChar(this.getLig()); }
    public int getCol() { return this.col; }
    public char getColchar() { return Case.getNumChar(this.getCol()); }
    public int getPierre() { return this.pierre; }

    // Boolean.
    public void setVisible() { this.caseVisible = true; }
    public boolean isVisible() { return caseVisible; }
    public void setInactive() { this.active= false; }
    public boolean isActive() { return active; }
    public void setPosJoueur(boolean bool) { this.posJoueur = bool; }
    public boolean isPosJoueur(){ return posJoueur; }

    
    // Méthode de propagation de la pierre et de l'arrivée du joueur sur une case.
    public void arrive(Joueur j) {
        this.setPosJoueur(true);
        this.setVisible();
        this.isActive();
        j.setMouvementJoueur(true);
       
    }

    public void propage(Joueur j, Direction d) {
        this.setVisible();
    }

    // Récupération des coordonées d'une case sous une chaîne de caractère.
    public String getCoord() { return "(" + this.getLigchar() + "," + this.getColchar() + ")";}

    // Classe abstraite pour obtenir la case suivante.
    public abstract Case getSuivante(Direction d);
    
    // Constructeur de la case.
    public Case(Plateau plateau, int lig, int col) {
        this.setPlateau(plateau);
        this.setLig(lig);
        this.setCol(col);
        this.caseVisible = false;
        this.active = true;
        this.posJoueur = false;

    }

}
