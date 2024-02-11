package exploration.Cases;

import exploration.Direction;
import exploration.Joueur;
import exploration.Plateau;

public class Pierres extends Case {

    public Pierres(Plateau plateau, int lig, int col, int quantiteMax) {
        super(plateau, lig, col);
        this.setPierre((int) (Math.random() * quantiteMax) + 1);
    }

    public Pierres(Plateau plateau, int lig, int col) {
        this(plateau, lig, col, 4);
    }

    
    public void arrive(Joueur j) {
        if (this.isActive()) {
            System.out.println("Vous avez obtenu : " + this.getPierre() + " pierres");
            j.incNbPierres(this.getPierre());
            this.setInactive();
            this.setPosJoueur(true);
            this.setVisible();
            j.setMouvementJoueur(true);
        } 
    }

    @Override
    public void propage(Joueur j, Direction d) {

        System.out.println("La pierre a heurté un stock");
        j.decNbPierres();
        this.setPierre(this.getPierre() + 1);
        j.setMouvementPierre(false);
    }

    @Override
    public Case getSuivante(Direction d) {
        int nL = this.getLig() + d.getdLig();
        int nC = this.getCol() + d.getdCol();
        return this.plateau.get(nL, nC);

    }


    @Override
    public String toString() {
        return "o";
    }
}
