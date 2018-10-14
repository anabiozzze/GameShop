package app.entities;

public class StandartGame {
    // общий класс-предок для всех будущих игр

    private String name = "Game";
    private double price = 0;
    private String genre = "RPG";

    public StandartGame(String name, double price, String genre) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public StandartGame() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        return hashCode() + (int)(Math.random()*20) + name.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) return false;
        if (obj==null) return false;
        return (this.toString().equals(obj.toString())) ? true : false;
    }

    @Override
    public String toString() {
        String str = genre + " " + name + " " + price + ";";
        return str;
    }
}
