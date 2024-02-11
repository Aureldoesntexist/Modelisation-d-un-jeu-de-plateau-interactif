package exploration;
import exploration.Cases.*;


public class Categorie {

    // Attributs
    private int pourcentage;
    private String nom;

    // Getter.
    public int getPourcentage() { return this.pourcentage; }
    public String getNom() { return this.nom; }

    // Setter.
    private void setPourcentage(int pourcentage) { this.pourcentage = pourcentage; }
    private void setNom(String nom) { this.nom = nom; }

    // Constructeur.
    public Categorie(int pourcentage, String categorie) {
        this.setPourcentage(pourcentage);
        this.setNom(categorie);
    }

    // Récupération d'une case et placement d'une case spéciale.
    public Case getCase(Plateau p, int lig, int col) {
        switch (this.getNom()) {
            case "Obstacle":
                return new Obstacle(p, lig, col);
            case "Mine":
                return new Mine(p, lig, col);
            case "Transfert":
                return new Passage(p, lig, col);
            case "Simple":
                return new Simple(p, lig, col);
            case "Pierres":
                return new Pierres(p, lig, col);
        }
        System.out.println("Échec pour la catégorie " + this);
        return null;
    }
}
