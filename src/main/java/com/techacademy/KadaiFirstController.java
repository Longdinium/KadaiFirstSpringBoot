package com.techacademy;

// import java.text.SimpleDateFormat;
// import java.time.LocalDate;
import java.util.Calendar;
// import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    
    // 仕様1：指定日の曜日を算定する
    @GetMapping("/dayofweek/{designatedDay}")
    public String dispDayOfWeek(@PathVariable String designatedDay) {
        /*
        SimpleDateFormat sdFormat = new SimpleDateFormat(”yyyyMMdd”);
        Date date = sdFormat.parse(designatedDay);
                // 文字列だった指定日をDate型にしてdateに格納
        Calendar calendar = Calendar.getInstance(); // Calendarインスタンスを取得
        calendar.setTime(date); // dateをCalendarにセット
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 曜日を取得
        return dayOfWeek;
        */
        
        // substringメソッドで年、月、日を抜き出す
        String year = designatedDay.substring(0, 4);
        int yearInt = Integer.parseInt(year); // Stringからintへの型変換
        String month = designatedDay.substring(4, 6);
        int monthInt = Integer.parseInt(month); 
        String day = designatedDay.substring(6, 8);
        int dayInt = Integer.parseInt(day); 

        Calendar cl = Calendar.getInstance();
        cl.set(yearInt, monthInt, dayInt);
        int dayOfWeek = cl.get(Calendar.DAY_OF_WEEK);
        String res = null;
        switch(dayOfWeek) {
            case Calendar.SUNDAY: res = "Sunday"; break;
            case Calendar.MONDAY: res = "Monday"; break;
            case Calendar.TUESDAY: res =  "Tuesday"; break;
            case Calendar.WEDNESDAY: res = "Wednesday"; break;
            case Calendar.THURSDAY: res = "Thursday"; break;
            case Calendar.FRIDAY: res = "Friday"; break;
            case Calendar.SATURDAY: res =  "Saturday"; break;
        }
        return res;
                
    }
    
    // 仕様2：四則演算を行なう
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果:" + res;
    }
    
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果:" + res;
    }
    
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果:" + res;
    }
    
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果:" + res;
    }

}

/*
仕様1：指定日の曜日を算定する
以下のようにURLにアクセスすると指定日の曜日を画面に表示する。

http://localhost:8080/dayofweek/指定日

「指定日」は任意の日付（形式：yyyymmdd）
メソッド名：dispDayOfWeek
実行結果：Tuesday（指定日が20191231の場合）
*/