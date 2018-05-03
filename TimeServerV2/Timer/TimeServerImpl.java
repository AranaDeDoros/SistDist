// TimeServerImpl.java
package Timer;
import static java.util.Calendar.*;
public class TimeServerImpl extends TimeServerPOA {
public int hours() {
return getInstance().get(HOUR_OF_DAY);
}
public int minutes() {return getInstance().get(MINUTE);
}
public int seconds() {
return getInstance().get(SECOND);
}
}