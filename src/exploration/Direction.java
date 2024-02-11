package exploration;

public class Direction {

    // Attributs.
    private int dCol;
    private int dLig;
    
    // Setter.
    public void setdLig(int dLig) { this.dLig = dLig; }
    public void setdCol(int dCol) { this.dCol = dCol; }
    // Getter.
    public int getdCol() { return this.dCol; }
    public int getdLig() { return this.dLig; }


    // Récupération de la direction choisie par le joueur.
    public static Direction getDirectionJoueur(String invite) {
        Direction retour;
        do {
            String choix = Lire.S(invite + " ( g ; d ; h ; b )");
            retour = getDirection(choix);
        } while (retour == null);
        return retour;
    }

    // Stockage de la direction choisie par le joueur.
    public static Direction getDirection(String choix) {
        Direction retour;
        switch (choix) {
            case "h":
                retour = new Direction(-1, 0);
                break;
            case "g":
                retour = new Direction(0, -1);
                break;
            case "d":
                retour = new Direction(0, +1);
                break;
            case "b":
                retour = new Direction(+1, 0);
                break;
            default:
                retour = null;
        }
        return retour;
    }

    // Constructeur.
    public Direction(int dLig, int dCol) {
        this.setdLig(dLig);
        this.setdCol(dCol);
    }
}
