package hva.core;
import java.util.List;
import java.util.ArrayList;

public class DeciduousTree extends Tree{
    
    public DeciduousTree (String id, String name, int diff){
        super(id, name, diff);
    }

    @Override
    public int cleaningEffort (){
        return 0; //FIX ME
    }
}