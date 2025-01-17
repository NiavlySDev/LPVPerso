package fr.niavlys.dev.lpvperso.calculateur;

public enum Prix {

    BASE(9.9, 1000),
    NICO(7.5, 100);

    private double prix;
    private int quantite;

    Prix(double prix, int quantite) {
        this.prix = prix;
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }


    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
