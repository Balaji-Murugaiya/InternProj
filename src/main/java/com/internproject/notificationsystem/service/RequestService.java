package com.internproject.notificationsystem.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {
    String getClientIp(HttpServletRequest httpServletRequest) ;
}
