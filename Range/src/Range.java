import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Range implements Iterable<Integer>{

    private int max;
    private int min;


    public Range(int min, int max){
        this.min = min - 1;
        this.max = max;
        iterator();

    }



    @Override
    public Iterator iterator() {
        return new RangeIterator(this.min, this.max);
    }


}
