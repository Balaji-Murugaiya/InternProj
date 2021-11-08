package com.internproject.notificationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionAttributesService {

    @Autowired
    LocationDetailsService locationDetailsService ;

    @Autowired
    RequestServiceImpl requestService ;

    GeoIP geoIP ;


}
