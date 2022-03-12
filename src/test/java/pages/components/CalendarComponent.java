package pages.components;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String data) {
        String[] dataArray = data.split("\\.");
        $(".react-datepicker__year-select").selectOption(dataArray[2]);
        $(".react-datepicker__month-select").selectOptionByValue
                (Integer.toString(Integer.parseInt(dataArray[1]) - 1));
        if (Integer.parseInt(dataArray[0]) < 10) {
            $(".react-datepicker__day--00" + dataArray[0] + " ").click();
        } else {
            $(".react-datepicker__day--0" + dataArray[0] + " ").click();
        }
    }

    public String converterDate(String date) {
        String[] dateArray = date.split("\\.");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);

        calendar.set(Calendar.DATE, Integer.parseInt(dateArray[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1])-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[2]));

        return  formatter.format( calendar.getTime());

    }

}
