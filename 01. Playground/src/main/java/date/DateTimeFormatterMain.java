package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterMain {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date1 = LocalDate.of(2020, 8, 2);
        String formattedDate = date1.format(formatter);
        System.out.println("Formatted Date = " + formattedDate);

        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
        System.out.println("LocalDate = " + date2);
    }
}
