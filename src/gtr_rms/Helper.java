package gtr_rms;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author W22079254
 */
public class Helper {

    public static Boolean checkStringIsNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * 
     * @param i
     * @param number
     * @return
     */
    public static String getCheckBoxConstraints(int i, int number){
        return i % number == 0 ? BorderLayout.WEST : i % number == 1 ? BorderLayout.CENTER : BorderLayout.EAST;
    }

    public static List<Date> getMonthList(String str_date, String end_date){
        List<Date> dates = new ArrayList<Date>();

        DateFormat formatter;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        try 
        {
            startDate = (Date) formatter.parse(str_date);
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        Date endDate = null;
        try 
        {
            endDate = (Date) formatter.parse(end_date);
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }

        long interval = 24 * 1000 * 60 * 60;
        long endTime = endDate.getTime();
        long curTime = startDate.getTime();
        while (curTime <= endTime) 
        {
            dates.add(new Date(curTime));
            curTime += interval;
        }

        return dates;
    }

    public static int getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static boolean checkDateIsWeekDay(Date date, int dateNumberList[]){
        int day = getDay(date);
        for(int number:dateNumberList){
            if(number == day){
                return false;
            }
        }
        return true;
    }

    public static String generalDateStr(LocalDate dateTime){
        return dateTime.getDayOfMonth() + "/" + dateTime.getMonthValue() + "/" + dateTime.getYear();
    }

}
