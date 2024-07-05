public interface IntSequence {
    boolean hasNext();
    int next();
}

public class IntSequenceClass implements IntSequence {
    private int[] sequence;
    private int currentIndex = 0;

    private IntSequenceClass(int... sequence) {
        this.sequence = sequence;
    }

    public static IntSequenceClass of(int... sequence) {
        return new IntSequenceClass(sequence);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sequence.length;
    }

    @Override
    public int next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return sequence[currentIndex++];
    }

    public static void main(String[] args) {
        IntSequenceClass seq = IntSequenceClass.of(3, 1, 4, 1, 5, 9);
        while (seq.hasNext()) {
            System.out.print(seq.next() + " ");
        }
    }
}

public class Main {
    public static IntSequence of(int... sequence) {
        return new IntSequence() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < sequence.length;
            }

            @Override
            public int next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return sequence[currentIndex++];
            }
        };
    }

    public static void main(String[] args) {
        IntSequence seq = Main.of(3, 1, 4, 1, 5, 9);
        while (seq.hasNext()) {
            System.out.print(seq.next() + " ");
        }
    }
}