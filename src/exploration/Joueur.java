package exploration;


import exploration.Cases.*;


public class Joueur {

    // Attributs
    private String nom;
    private Case position;

    private int nbPierres;
    private boolean gagnant;
    private boolean perdant;
    // bool pour la pierre
    private boolean movePierre;
    // bool pour le mouvement du joueur
    private boolean moveJoueur;
    private boolean passage;

    // Setter.
    public void setNom(String nom) { this.nom = nom; }
    public void setNbPierres(int nbPierres) { this.nbPierres = nbPierres; }
    public void setPosition(Case position) { this.position = position; }

    // Getter.
    public String getNom() { return nom;}   
    public Case getPosition() { return position;}
    public int getNbPierres() { return this.nbPierres; }

    // Boolean pour les conditions de victoire ou de défaite
    public boolean isGagnant() { return this.gagnant; }
    private void setGagnant(boolean gagnant) { this.gagnant = gagnant; }
    public boolean isPerdant() { return this.perdant; }
    private void setPerdant(boolean perdant) { this.perdant = perdant; }
    public void perd() { this.setPerdant(true); }
    public void gagne() { this.setGagnant(true); }

    // Méthodes pour le mouvement de la pierre
    public void setMouvementPierre(boolean m) { this.movePierre= m; }
    public Boolean enMouvementPierre() { return movePierre; }
    // Méthode pour le mouvement du joueur, savoir si le joueur peut se deplacer sur la case
    public void setMouvementJoueur(boolean m) { this.moveJoueur= m; }
    public Boolean enMouvementJoueur() { return moveJoueur; }

    public Boolean isPassage() { return passage; }
    public void setPassage(boolean p) { this.passage = p; }

    // Ajout ou suppression d'une pierre de l'inventare du joueur.
    public void incNbPierres(int n) { this.setNbPierres(this.getNbPierres() + n); }
    public void decNbPierres() { this.setNbPierres(this.getNbPierres() - 1); }

    // Déplacement du joueur.
    public void deplace(Direction d) {
        // Position du joueur
        Case caseActuelle = this.getPosition();
        // Position de la case suivante par rapport à la direction
        Case caseSuivante = caseActuelle.getSuivante(d);
        this.setMouvementJoueur(true);
        if (caseSuivante!=null) {
            // Mine ou pierre active
            if (caseSuivante.isActive() ){
                // Méthode arrive.
                caseSuivante.arrive(this);
                // Si ce n'est ni un passage ni un obstacle.
                if(!isPassage()){
                    // On met la position du joueur à la case suivante.
                    this.setPosition(caseSuivante);
                }
            // Si mine ou pierre désactivée.
            } else {
                // On met la position du joueur à la case suivante.
                this.setPosition(caseSuivante);
                // On active l'affichage du joueur sur la nouvelle case.
                caseSuivante.setPosJoueur(true);
                // On désactive l'affichage du joueur de son ancienne position.
                caseActuelle.setPosJoueur(false); 
            }
            // On désactive l'affichage du joueur de son ancienne position.
            if(this.getPosition()!= caseActuelle) {
                caseActuelle.setPosJoueur(false);
            }
        // L joueur ne peut pas aller au déla du plateau
        } else {
            System.out.println(Jeu.red+"Vous ne pouvez pas être sur les bords du plateau."+Jeu.white);
        }
        
    }
    
    // Lancement de la pierre
    public void lancePierre(Direction d) {
        // Si le joueur possède des pierres
        if(this.getNbPierres()>0){
            // La pierre est lancée et en mouvement
            this.setMouvementPierre(true);
            // On récupère les informations de la case ou est le joueur
            Case caseActuelle = this.getPosition();
            // Boucle tant que la pierre est en mouvement
            while (enMouvementPierre()) {
                // La case de la pierre est la case suivante dans la direction choisie
                caseActuelle = caseActuelle.getSuivante(d);
                // Methode propage
                caseActuelle.propage(this, d);
            }
        } else  
            System.out.println(Jeu.red+"Vous n'avez plus de pierres"+Jeu.white);
    }
   
    // Constructeur.
    public Joueur(String nom, Case depart, int nbPierres) {
        this.setNom(nom);
        this.setPosition(depart);
        this.setNbPierres(nbPierres);
        this.setGagnant(false);
        this.setPerdant(false);
        
    }

    // Affichage du joueur sur le plateau.
    @Override
    public String toString() { return "$"; }


}
