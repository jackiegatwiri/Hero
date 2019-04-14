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
    public int getId(){
        return mId;
    }
    public static List<Hero> all(){
        return instances;
    }
    public static Hero find(int id) {
        return instances.get(id - 1);
    }
    public static void clear() {
        instances.clear();
    }




}

