import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class RangeIterator implements Iterator<Integer> {

    private int min;
    private final int max;

    public RangeIterator ( int min, int max){
        if (min > max){
            throw new UnsupportedOperationException();
        }
        this.min = min;
        this.max = max;
    }




    @Override
    public boolean hasNext() {
        return min  < max;
    }

    @Override
    public Integer next() {
        if ( min >= max){
            throw new NoSuchElementException();
        }

        min ++;
        return min;


    }


}
