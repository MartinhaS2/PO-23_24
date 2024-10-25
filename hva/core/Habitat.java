package hva.core;
import java.util.ArrayList;
import java.util.List;

public class Habitat extends HotelEntity {
    private int _area;
    private List<Animal> _animals;
    private List<Tree> _trees;

    public Habitat(String id, String name, int area) {
        super(id, name);
        this._area = area;
        _animals = new ArrayList<>();
        _trees = new ArrayList<>();
}

    public int getArea() {
        return _area;
    }

    public List<Animal> getAnimals() {
        return _animals;
    }

    void add(Animal animal) {
        _animals.add(animal);
    }


    public int getNumTrees() {
        return _trees.size();
    }
}

