
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {

    /**
     * 将现在的时间转换为自己定义的标准的形式
     */
    public static String nowFormat(){
        String res;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        res = sdf.format(new Date());
        return res;
    }

    /**
     * 将时间形如"2018-10-17 10:35:00" 转换为long类型的时间戳形式1539743700000
     */
    public static long date2LongTimeFormat(String datetime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(datetime);
            long longTime = date.getTime();
            return longTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     *  将形为long类型的时间戳形式1539743700000 转换为形如"2018-10-17 10:35:00"的格式
     */
    public static String longTimeFormat2Date(String longtime){
        String res;
        long lt = new Long(longtime);
        Date date = new Date(lt);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        res = sdf.format(date);
        return res;
    }

    public static void test(Date time){
        String res;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        res = sdf.format(time);
        System.out.println(res);
    }

    /**
     * 只保留日期的时间格式
     */
    public static String longTimeFormat2Date2(long longtime){
        String res;
        Date date = new Date(longtime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        res = sdf.format(date);
        return res;
    }

    public static void main(String[] args){
//        System.out.println(date2LongTimeFormat(MyUtils.nowFormat()));
//        longTimeFormat2Date("1539747300000");
//        System.out.println(longTimeFormat2Date2(1539848712000l));
//        test(new Date());
        System.out.println(t(null,"a"));
    }

    public static boolean t(Object obj1,Object obj2){

        //不相同返回true
        if(obj1 == null || obj1.equals("") || obj2 == null || obj2.equals("")){
            return false;
        }
        String o1 = (String)obj1;
        String o2 = (String)obj2;
        if(!o1.equals(o2)){
            return true;
        }
        return false;
    }
}
