package com;

import java.util.Date;

/**
 * An implementation we use for now; it simply prints to console. A more realistic 
 * implementation will use some GUI toolkit to render the map and shade the appropriate
 * region with the appropriate color.
 */
class MapViewImpl implements MapView {
    public void lightUp(Region region, UserExperience userExperience) {
        System.out.println(new Date()  + ": show " + region.getName() + " in color for " + userExperience );
    }
}
