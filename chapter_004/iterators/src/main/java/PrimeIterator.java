import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {

    private int[] numbers;
    private int index = 0;

    public PrimeIterator(final int[] aNumbers) {
        numbers = aNumbers;
    }

    @Override
    public boolean hasNext() {
        return findElement() != null;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index += findElement();
        Integer count = numbers[index];
        index++;
        return count;
    }

    boolean isItPrimeNumber(int i) {
        boolean result = true;
        int count = 2;
        if (i == 1) {
            result = false;
        } else {
            while (count < i) {
                if (i % count == 0) {
                    result =  false;
                    break;
                }
                count++;
            }
        }
        return result;
    }

    private Integer findElement() {
        Integer result  = null;
        int count = 0;
        while (index + count < numbers.length) {
            if (isItPrimeNumber(numbers[index + count])) {
                result = count;
                break;
            }
            count++;
        }
        return result;
    }
}
