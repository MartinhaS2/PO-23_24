package hva.core;

import java.io.Serializable;
import java.util.*;


//add serializable
public abstract class Employee extends HotelEntity implements Serializable{
    private String _type;
    private List<String> _responsabilities;

    protected Employee(String id, String name, String type) {
        super(id, name);
        this._type = type;
        this._responsabilities = new ArrayList<>();
    }

    public List<String> getResponsabilities() {
        return _responsabilities;
    }

    public void addResponsability(String responsability) {
        _responsabilities.add(responsability);
    }

    public String getType() {
        return _type;
    }

    
}
