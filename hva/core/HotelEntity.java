package hva.core;
import java.io.Serializable;
import java.io.Serial;

public abstract class HotelEntity implements Serializable {

    @Serial
    private static final long serialVerssionUID = 202407081733L;

    private String _id;
    private String _name;

    public HotelEntity(String id, String name) {
        this._id = id;
        this._name = name;
    }

    public String getName() {
        return _name;
    }

    public String getId() {
        return _id;
    }

    @Override
    public int hashCode() {
        return _id.hashCode() + _name.hashCode(); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HotelEntity)) return false;
        HotelEntity other = (HotelEntity) obj;
        return this._id.equals(other.getId()) && this._name.equals(other.getName());
    }
}