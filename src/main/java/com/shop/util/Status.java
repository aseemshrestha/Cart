package com.shop.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Status
{
    private static final String DRAFT = "Draft";
    private static final String PUBLISHED = "Published";

    public static Map<String, String> getStatus()
    {
        return loadStatus();
    }

    private static Map<String, String> loadStatus()
    {
        Map<String, String> statusMap = new LinkedHashMap<>();
        statusMap.put(DRAFT, DRAFT);
        statusMap.put(PUBLISHED, PUBLISHED);
        return statusMap;

    }

}
