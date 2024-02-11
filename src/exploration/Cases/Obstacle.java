package exploration.Cases;

import exploration.Direction;
import exploration.Jeu;
import exploration.Joueur;
import exploration.Plateau;

public class Obstacle extends Case {

    public Obstacle(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
        
    }
    @Override
    public void arrive(Joueur j){
        this.setVisible();
        System.out.println(Jeu.red+"Vous ne pouvez pas vous déplacer sur une case obstacle."+Jeu.white); 
        j.setPassage(true);
        j.setMouvementJoueur(false);
    }

    @Override
    public void propage(Joueur j, Direction d) {
        System.out.println(Jeu.red+"La pierre a heurté un obstacle"+Jeu.white);
        j.decNbPierres();
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
        return "#";
    }
}
