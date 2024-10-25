package hva.core;

class Animal extends HotelEntity {
    private String _species;
    private String _healthHistory;

    public Animal(String id, String name, String species) {
        super(id, name);
        this._species = species;
    }

    public String getSpecies() {
        return _species;
        
    }

    public String getHealthHistory() {
        return _healthHistory;
    }

}