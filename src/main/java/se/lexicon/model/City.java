package se.lexicon.model;

/**
 * Represents a City entity based on the 'city' table in the 'world' database.
 */
public class City {
    // TODO: Needs completion

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public City(String name, String countryCode, String district, int population){
        this.name =name;
        this.countryCode =countryCode;
        this.district =district;
        this.population =population;

    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    // Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City:" +
                " id=" + id + ", name=" + name + ", countryCode=" + countryCode +
                ", district=" + district + " population =" + population;
    }
}
