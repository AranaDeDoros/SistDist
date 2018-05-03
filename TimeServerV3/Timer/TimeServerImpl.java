// TimeServerImpl.java
package Timer;
import static java.util.Calendar.*;
import org.omg.CORBA.*;
public class TimeServerImpl extends TimeServerPOA {
public void get_time(IntHolder hours,
IntHolder minutes, IntHolder seconds) {
hours.value = getInstance().get(HOUR_OF_DAY);
minutes.value = getInstance().get(MINUTE);
seconds.value = getInstance().get(SECOND);
}
}