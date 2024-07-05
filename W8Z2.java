import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate nextWorkingDay = today.with(następny(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println("Today: " + today);
        System.out.println("Next working day: " + nextWorkingDay);
    }

    public static TemporalAdjuster następny(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(date -> {
            LocalDate nextDate = date.plusDays(1);
            while (!predicate.test(nextDate)) {
                nextDate = nextDate.plusDays(1);
            }
            return nextDate;
        });
    }
}