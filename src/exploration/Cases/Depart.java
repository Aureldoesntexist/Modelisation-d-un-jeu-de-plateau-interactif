package exploration.Cases;

import exploration.Direction;
import exploration.Jeu;
import exploration.Joueur;
import exploration.Plateau;

public class Depart extends Case {
    public Depart(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
        this.setVisible();
        this.setPosJoueur(true);
    }
 
    public void arrive(Joueur j) {
        super.arrive(j);
        System.out.println("Vous êtes à la case départ");
    }
    public void propage(Joueur j, Direction d) {
        super.propage(j,d);
        System.out.println("La pierre a touché la case départ.");
        j.setMouvementPierre(false);
        j.decNbPierres();
    }

    @Override
    public Case getSuivante(Direction d) {
        int nL = this.getLig() + d.getdLig();
        int nC = this.getCol() + d.getdCol();
        return this.plateau.get(nL, nC);
    }

    @Override
    public String toString() {
        if(this.posJoueur){
            return "$";
        } else {
            return Jeu.green+"{"+Jeu.white;
        }
         
    }
}
