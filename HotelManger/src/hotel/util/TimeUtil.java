package hotel.util;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间格式化工具类
 * @author Administrator
 *
 */
public class TimeUtil {
	public static String formatTime(){
		Date nowTime=new Date(); 
		System.out.println(nowTime); 
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String NewTime = time.format(nowTime);
		return NewTime;
	}
}
