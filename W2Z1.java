import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int number;

    public DigitSequence(int number) {
        this.number = number;
    }

    @Override
    public boolean hasNext() {
        return number != 0;
    }

    @Override
    public Integer next() {
        int result = number % 10;
        number /= 10;
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public static void main(String[] args) {
        DigitSequence sequence = new DigitSequence(12345);
        try {
            sequence.remove();
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}