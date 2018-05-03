// DateTimeServerImpl.java
package Timer;
import Timer.DateTimeServerPackage.*;
import Timer.TimeServerPackage.*;
import static java.util.Calendar.*;
public class DateTimeServerImpl
extends DateTimeServerPOA {
public Time get_time() {
return new Time(getInstance().get(HOUR_OF_DAY),
getInstance().get(MINUTE),
getInstance().get(SECOND));
}
public DateTime get_date_time() {
return new DateTime(getInstance().get(DAY_OF_MONTH),
getInstance().get(MONTH) + 1,
getInstance().get(YEAR),
get_time());
}
}