package com.internproject.notificationsystem.service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GeoIP {
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;

    public GeoIP() {
        super();
    }

    public GeoIP(String ipAddress, String city, String latitude, String longitude) {
        super();
        this.ipAddress = ipAddress;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
