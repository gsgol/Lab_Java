import java.util.Iterator;
import java.util.Map;
public class MapIterator<K, V> implements Iterator<V>
{
    private  Iterator<Map.Entry<K, V>> it;
    public MapIterator(Map <K, V> map)
    {
        this.it = map.entrySet().iterator();
    }

    @Override
    public boolean hasNext()
    {
        return it.hasNext();
    }
    @Override
    public V next()
    {
        return it.next().getValue();
    }
    public void remove()
    {
        it.remove();
    }
}
