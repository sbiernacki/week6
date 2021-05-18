package pl.writech.week6.model;

public class Movie {

    private String name;
    private int yearOfProduction;
    private String director;

    public Movie(String name, int yearOfProduction, String director) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
