package exploration.Cases;

import exploration.Direction;
import exploration.Joueur;
import exploration.Plateau;

public class Simple extends Case {

    public Simple(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
    }

    @Override
    public void arrive(Joueur j) {
        super.arrive(j);
        j.setMouvementJoueur(false);
        j.setPosition(this);
    }

    @Override
    public void propage(Joueur j, Direction d) {
        if (this.getSuivante(d) != null) {
            this.getSuivante(d).propage(j, d);
        } else {
            super.propage(j, d);
            j.setMouvementPierre(false);
            System.out.println("La pierre touche le bord");
        }
    }

    @Override
    public Case getSuivante(Direction d) {
        int nL = this.getLig() + d.getdLig();
        int nC = this.getCol() + d.getdCol();
        return this.plateau.get(nL, nC);
    }
    

    @Override
    public String toString() {
        return ".";
    }


}
