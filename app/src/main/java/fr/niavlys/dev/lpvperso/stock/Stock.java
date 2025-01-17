package fr.niavlys.dev.lpvperso.stock;

public class Stock {

    private Integer base;
    private Integer nico;
    private Integer fiole100;
    private Integer fiole250;
    private Integer fiole500;

    public void setBase(Integer base) {
        this.base = base;
    }

    public void setNico(Integer nico) {
        this.nico = nico;
    }

    public void setFiole100(Integer fiole100) {
        this.fiole100 = fiole100;
    }

    public void setFiole250(Integer fiole250) {
        this.fiole250 = fiole250;
    }

    public void setFiole500(Integer fiole500) {
        this.fiole500 = fiole500;
    }

    public Stock() {
        this.base = 0;
        this.nico = 0;
        this.fiole100 = 0;
        this.fiole250 = 0;
        this.fiole500 = 0;
    }

    public Integer getBase() {
        return base;
    }

    public Integer getNico() {
        return nico;
    }

    public Integer getFiole100() {
        return fiole100;
    }

    public Integer getFiole250() {
        return fiole250;
    }

    public Integer getFiole500() {
        return fiole500;
    }


    public void addBase() {
        this.base++;
    }

    public void removeBase() {
        if (this.base > 0) {
            this.base--;
        }
    }

    public void resetBase() {
        this.base = 0;
    }

    public void addNico() {
        this.nico++;
    }

    public void removeNico() {
        if (this.nico > 0) {
            this.nico--;
        }
    }

    public void resetNico() {
        this.nico = 0;
    }

    public void addFiole100() {
        this.fiole100++;
    }

    public void removeFiole100() {
        if (this.fiole100 > 0) {
            this.fiole100--;
        }
    }

    public void resetFiole100() {
        this.fiole100 = 0;
    }

    public void addFiole250() {
        this.fiole250++;
    }

    public void removeFiole250() {
        if (this.fiole250 > 0) {
            this.fiole250--;
        }
    }

    public void resetFiole250() {
        this.fiole250 = 0;
    }

    public void addFiole500() {
        this.fiole500++;
    }

    public void removeFiole500() {
        if (this.fiole500 > 0) {
            this.fiole500--;
        }
    }

    public void resetFiole500() {
        this.fiole500 = 0;
    }
}
