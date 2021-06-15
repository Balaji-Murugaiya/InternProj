package com.internproject.notificationsystem.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class LocationDetailsService {
    private DatabaseReader dbReader ;

    public LocationDetailsService() throws IOException {
        File database = new File("/Users/bamurugaiya/Downloads/GeoLite2-City_20210608/GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public GeoIP getLocation(String ip) throws IOException , GeoIp2Exception
    {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude =
                response.getLocation().getLatitude().toString();
        String longitude =
                response.getLocation().getLongitude().toString();

        return new GeoIP(ip, cityName , latitude , longitude) ;
    }
}
