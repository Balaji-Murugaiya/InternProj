package com.internproject.notificationsystem.service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmailDetails {
    String emailID ;
    String ipAddress ;
    String city ;
    String latitude ;
    String longitude ;
    String encodedSessionID ;

    EmailDetails(String emailID,GeoIP geoIP,String encodedSessionID)
    {
        this.emailID = emailID ;
        this.ipAddress = geoIP.getIpAddress() ;
        this.city = geoIP.getCity();
        this.latitude = geoIP.getLatitude();
        this.longitude = geoIP.getLongitude() ;
        this.encodedSessionID = encodedSessionID ;
    }
}
