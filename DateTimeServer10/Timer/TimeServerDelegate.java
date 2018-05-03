// TimeServerDelegate.java
package Timer;
import Timer.TimeServerPackage.*;
import static java.util.Calendar.*;
public class TimeServerDelegate
implements TimeServerOperations {
public Time get_time() {
return new Time(getInstance().get(HOUR_OF_DAY),
getInstance().get(MINUTE),
getInstance().get(SECOND));
}
}