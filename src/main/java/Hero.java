import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mName;
    private int mAge;
    private String mPower;
    private String mWeakness;
    private LocalDateTime mCreatedAt;
    private int mId;
    private static List<Hero> instances = new ArrayList<>();

    public Hero(String name, int age, String power, String weakness) {
        this.mName = name;
        this.mAge = age;
        this.mPower = power;
        this.mWeakness = weakness;
        mCreatedAt = LocalDateTime.now();
        instances.add(this); //This logic resides in the constructor because the constructor is called every time we create a Task. This ensures every new Task will be included in instances.
        mId = instances.size();

    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getPower() {
        return mPower;
    }

    public String getWeakness() {
        return mWeakness;
    }
    public LocalDateTime getCreatedAt() {
        return mCreatedAt;
    }

    public static List<Hero> all(){
        return instances;
    }

    public static void clear() {
        instances.clear();
    }
    public int getId()
    {
        return mId;
    }
    public static Hero find(int id) { //this helps to locate an object or instance using the id
        return instances.get(id-1);//So, if a method's functionality must access all instances of a class, like our find() method above, it needs to be declared static.
    }




}

