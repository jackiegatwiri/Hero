import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String mName;
    private static List<Squad> instances = new ArrayList<Squad>(); //list of category objects
    private int mid;
    private List<Hero> mHeroes; // a certain squad will have a list of heroes

    public Squad(String name ){
        this.mName = name;
        instances.add(this);
        mid = instances.size();
        mHeroes = new ArrayList<Hero>();
    }
    public String getName() {
        return mName;
    }
    public static List<Squad> all() {
        return instances;
    }
    public static void clear(){
        instances.clear();
    }
    public int getId(){
        return mid;
    }
    public static Squad find(int id){ //finds instancs of the Squd
        return instances.get(id -1);
    }
    public List<Hero> getHeroes(){ //returns Squad's list of heroes
        return mHeroes;
    }
    public void addHero(Hero hero){
        mHeroes.add(hero); //a hero is added to the mHeroes property
    }

}
