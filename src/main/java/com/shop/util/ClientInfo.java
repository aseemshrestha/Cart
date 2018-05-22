package com.shop.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;

public class ClientInfo
{

    public static String getClientIp(HttpServletRequest request)
    {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

    public static String getClientDevice(Device device)
    {
        String deviceType = null;
        if (device.isMobile()) {
            deviceType = "Mobile";
        } else if (device.isTablet()) {
            deviceType = "Tablet";
        } else {
            deviceType = "Desktop";
        }

        return deviceType;
    }

}
