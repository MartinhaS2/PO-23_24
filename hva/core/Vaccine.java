package hva.core;

import java.util.*;

public class Vaccine extends HotelEntity {
    private int _numApplications;
    private List<String> _species;

    public Vaccine(String id, String name, List<String> species) {
        super(id, name);
        this._species = species;

    }


    public List<String> getSpecies() {
        return _species;
    }

    public int getNumApplications() {
        return _numApplications;
    }

    public void Apply() {
        _numApplications++;
    }
}
