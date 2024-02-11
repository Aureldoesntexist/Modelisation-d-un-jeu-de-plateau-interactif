package exploration.Cases;

import exploration.Direction;
import exploration.Jeu;
import exploration.Joueur;
import exploration.Plateau;

public class Passage extends Case {
    private int newlig, newcol;


    public Passage(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
        this.newcol= (int) (Math.random()*this.getPlateau().getNbCol())+1;
        this.newlig = (int) (Math.random()*this.getPlateau().getNbLig())+1;
        
    }
    
    @Override
    public void arrive(Joueur j) {
        j.setPassage(true);
        while (this.plateau.get(this.newlig, this.newcol) instanceof Passage || this.plateau.get(this.newlig, this.newcol) instanceof Obstacle ) {
            this.newcol= (int) (Math.random()*this.getPlateau().getNbCol())+1;
            this.newlig = (int) (Math.random()*this.getPlateau().getNbLig())+1;
        }
        if (this.plateau.get(this.newlig, this.newcol)!= null) {
            this.plateau.get(this.newlig, this.newcol).setPosJoueur(true); 
            this.plateau.get(this.newlig, this.newcol).setVisible();
            System.out.println(Jeu.blue+"Vous êtes téléporté ailleurs."+Jeu.white);
            j.setPosition(this.plateau.get(this.newlig, this.newcol));
            this.plateau.get(this.newlig, this.newcol).arrive(j);
            this.setVisible();
            this.plateau.get(lig, col).setPosJoueur(false);
        }
    }
    @Override
    public void propage(Joueur j, Direction d) {
        while (this.plateau.get(this.newlig, this.newcol) instanceof Passage || this.plateau.get(this.newlig, this.newcol) instanceof Obstacle ) {
            this.newcol= (int) (Math.random()*this.getPlateau().getNbCol())+1;
            this.newlig = (int) (Math.random()*this.getPlateau().getNbLig())+1;
        }
        System.out.println(Jeu.cyan+"La pierre a été téléporté"+Jeu.white);
        plateau.get(newlig, newcol).propage(j, d);
    }

    @Override
    public Case getSuivante(Direction d) {
        int nL = this.getLig() + d.getdLig();
        int nC = this.getCol() + d.getdCol();
        return this.plateau.get(nL, nC);
    }
    
    @Override
    public String toString() {
        return "¤";
    }
}
