package hva.core;

public abstract class Tree extends HotelEntity{
    private Season _season;
    private int _age;
    private int _dificultyCleaning;

    public Tree(String id, String name, int diff){
        super(id,name);
        _dificultyCleaning = diff;
        _age = 0;
    }

    public abstract int cleaningEffort();

    public void skipSeason(){
        _season.skipSeason();
    }
}