package fr.niavlys.dev.lpvperso.calculateur;

public enum Prix {

    BASE(9.9, 1000),
    NICO(7.5, 100);

    private final double prix;
    private final int quantite;

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

}
