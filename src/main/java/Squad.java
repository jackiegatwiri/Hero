import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String mName;
    private static List<Squad> instances = new ArrayList<Squad>(); //list of category objects
    private int mid;
    private int mSize;
    private String mMission;
    private List<Hero> mHeroes; // a certain squad will have a list of heroes

    public Squad(String name, int size, String mission){
        this.mName = name;
        mSize = size;
        mMission = mission;
        instances.add(this);
        mid = instances.size();
        mHeroes = new ArrayList<Hero>();

    }
    public String getName() {
        return mName;
    }
    public String getMission(){
        return mMission;
    }
    public int getSize() {
        return mSize;
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
    public static Squad find(int id){
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
    public List<Hero> getHeroes(){ //returns Squad's list of heroes
        return mHeroes;
    }
    public void addHero(Hero hero){
        mHeroes.add(hero); //a hero is added to the mHeroes property
    }
    public static boolean heroAlreadyExists(Hero newHero) {
        boolean exists = false;
        for(Squad squad: instances){
            for(Hero hero: squad.getHeroes()){
                if (hero.getName().equals(newHero.getName())) {
                    exists = true;
                }
            }
        }
        return exists;
    }

}
