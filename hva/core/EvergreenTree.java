package hva.core;
import java.util.List;
import java.util.ArrayList;

public class EvergreenTree extends Tree{
    
    public EvergreenTree (String id, String name, int diff){
        super(id, name, diff);
    }

    @Override
    public int cleaningEffort (){
        return 0; //FIX ME
    }
}