package hva.core;

import java.util.ArrayList;

public class Vaccination {
    
    private static Vaccination _vaccination;

    private ArrayList<Vaccine> _vaccines;
    private ArrayList<Veterinarian> _veterinarians;
    private ArrayList<Animal> _animals;
    private ArrayList<Integer> _damage;

    public Vaccination () {
        _vaccines = new ArrayList<Vaccine>();
        _veterinarians = new ArrayList<Veterinarian>();
        _animals = new ArrayList<Animal>();
        _damage = new ArrayList<Integer>();
    }

    public static Vaccination getVaccination() {
        if (_vaccination == null) {
            _vaccination = new Vaccination();
        }
        return _vaccination;
    }
}