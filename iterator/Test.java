import java.time.*;
import java.util.*;

public class Test
{
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();

        map.put("Banana", "Yellow");
        map.put("Apple", "Red");
        map.put("Cucumber", "Green");
        map.put("Potato", "Yellow");
        map.put("Sea", "Blue");
        MapIterator<String, String> it = new MapIterator<String, String>(map);
        while(it.hasNext())
        {
            System.out.println(it.next());
        }


    }
}
