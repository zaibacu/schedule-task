import java.util.List;
import java.util.Random;

public class Utils {
    private static Random rand = new Random();

    public static<T> T getRandom(List<T> collection){
        int r = rand.nextInt(collection.size());
        return collection.get(r);
    }
}
