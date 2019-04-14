import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String mName;
    private static List<Squad> instances = new ArrayList<Squad>(); //list of category objects

    public Squad(String name ){
        this.mName = name;
        instances.add(this);
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

}
