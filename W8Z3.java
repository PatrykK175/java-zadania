import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class Cal {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Cal <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDayOfMonth = yearMonth.atDay(1);
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek();
        int daysInMonth = yearMonth.lengthOfMonth();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        int dayOfWeekValue = firstDayOfWeek.getValue();
        for (int i = 1; i < dayOfWeekValue; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + dayOfWeekValue - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}