import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, 2, 29);
        LocalDate newDate = date.plusYears(1);
        System.out.println("Original date: " + date);
        System.out.println("Date after adding one year: " + newDate);
    }
}