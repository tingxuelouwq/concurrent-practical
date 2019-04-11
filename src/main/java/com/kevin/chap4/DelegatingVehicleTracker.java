package com.kevin.chap4;

import com.kevin.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类名: DelegatingVehicleTracker<br/>
 * 包名：com.kevin.chap4<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/21 16:42<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@ThreadSafe
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiedMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiedMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiedMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }

    public Map<String, Point> getLocations2() {
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    public static void main(String[] args) {
        Point point = new Point(1, 1);
        Map<String, Point> map = new HashMap<>();
        map.put("bi", point);
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(map);
        Map<String, Point> locations = tracker.getLocations();
        locations.values().forEach(System.out::println);
        tracker.setLocation("bi", 1, 2);
        locations.values().forEach(System.out::println);

        Map<String, Point> locations2 = tracker.getLocations2();
        locations2.values().forEach(System.out::println);
        tracker.setLocation("bi", 1, 3);
        locations2.values().forEach(System.out::println);
    }
}
