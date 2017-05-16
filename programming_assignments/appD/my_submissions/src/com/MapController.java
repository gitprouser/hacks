package com;

import java.net.Inet4Address;
import java.util.Map;

/**
 * A controller which decides which regions of the map should light up when.
 */
public class MapController {

    /**
     * Represents a range of some ordered type.
     */
    public static class Range<T> {
        public final T from;
        public final T until;

        public Range(T from, T until) {
            this.from = from;
            this.until = until;
        }
    }

    /**
     * @param regions mapping of ip address ranges to regions on the map
     *                The ranges include both the from and until ip address
     *
     * @param userExperiences mapping of response time (in milliseconds) ranges to
     *                        user experience categories. The ranges include the from
     *                        time, but not the until time.
     *
     * @param view the MapView which needs to be updated.
     */
    public MapController (Map<Range<Inet4Address>, Region> regions, Map<Range<Long>, UserExperience> userExperiences,
                          MapView view) {
        // TODO
    }

    /**
     * Update the view to record a hit.
     *
     * @param ipAdress an ip address string
     *
     * @param responseTime the response time, in milli second, experienced by the user with
     *                     the given IP address.
     */
    public void hit(String ipAddress, long responseTime) {
        // TODO
    }
}
