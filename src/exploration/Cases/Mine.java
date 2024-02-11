package exploration.Cases;

import exploration.Direction;
import exploration.Jeu;
import exploration.Joueur;
import exploration.Plateau;

public class Mine extends Case {

    public Mine(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);        
    }
    
    @Override
    public void arrive(Joueur j) {
        //super.arrive(j);
        if(this.isActive()){
            j.perd();
            this.setVisible();
            System.out.println(Jeu.black+"--------------------");
            System.out.println("Vous avez explosé sur une mine. Game Over!");
            System.out.println("--------------------"+Jeu.white);
        }
    }

    @Override
    public void propage(Joueur j, Direction d) {  
            if(this.isActive()){
                this.setVisible();
                this.setInactive();
                System.out.println("La pierre a heurté une mine, vous perdez une pierre.");
                j.setMouvementPierre(false);
                j.decNbPierres();
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
        return "*";
    }

}
