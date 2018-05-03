// DateTimeServerDelegate.java
package Timer;
import Timer.DateTimeServerPackage.*;
import Timer.TimeServerPackage.*;
import static java.util.Calendar.*;
public class DateTimeServerDelegate
extends TimeServerDelegate
implements DateTimeServerOperations {
public DateTime get_date_time() {
return new DateTime(getInstance().get(DAY_OF_MONTH),
getInstance().get(MONTH) + 1,
getInstance().get(YEAR),
get_time());
}
}