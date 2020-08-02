package date;

import java.time.LocalDate;
import java.time.Period;

public class PeriodMain {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2020, 7, 23);
        LocalDate date2 = LocalDate.of(2020, 8, 02);
        Period period = Period.between(date1, date2);
        System.out.println(date1 + " ~ " + date2 + ", " + period.getDays() + "days");
    }
}
