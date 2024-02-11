package exploration.Cases;

import exploration.Direction;
import exploration.Jeu;
import exploration.Joueur;
import exploration.Plateau;

public class Arrivee extends Case {
    public Arrivee(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
        this.setVisible();    
    }

    
    public void arrive(Joueur j) {
        super.arrive(j);
        System.out.println(Jeu.green+"-----------------------------------");
        System.out.println("Vous avez atteint la sortie! Bravo.");
        System.out.println("-----------------------------------"+Jeu.white);
        j.gagne();
    }

    public void propage(Joueur j, Direction d) {
        super.propage(j,d);
        System.out.println(Jeu.green+"La pierre a touché la case d'arrivée"+Jeu.white);
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
        return Jeu.green+"}"+Jeu.white; 
    }
}
