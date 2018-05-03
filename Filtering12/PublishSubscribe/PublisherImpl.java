// PublisherImpl.java
package PublishSubscribe;
import java.util.*;
public class PublisherImpl extends PublisherPOA {
private List<Filter> filters = new ArrayList<Filter>();
public synchronized void add(Filter f) {
filters.add(f);
}
public List<Filter> getFilters() {
return filters;
}
}