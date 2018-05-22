package com.shop.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Categories
{
    private static final String CATEGORY1 = "Category1";
    private static final String CATEGORY2 = "Category2";
    private static final String CATEGORY3 = "Category3";
    private static final String CATEGORY4 = "Category4";
    private static final String CATEGORY5 = "Category5";

    private static final String CATEGORY1_DESCRIPTION = "Category1 Description";
    private static final String CATEGORY2_DESCRIPTION = "Category2 Description";
    private static final String CATEGORY3_DESCRIPTION = "Category3 Description";
    private static final String CATEGORY4_DESCRIPTION = "Category4 Description";
    private static final String CATEGORY5_DESCRIPTION = "Category5 Description";

    public static Map<String, String> getCategories()
    {
        return loadCategories();
    }

    public static Map<String, String> getCategoriesDescription()
    {
        return loadCategoriesDescription();
    }

    private static Map<String, String> loadCategories()
    {
        Map<String, String> categoriesMap = new LinkedHashMap<>();
        categoriesMap.put(CATEGORY1, CATEGORY1);
        categoriesMap.put(CATEGORY2, CATEGORY2);
        categoriesMap.put(CATEGORY3, CATEGORY3);
        categoriesMap.put(CATEGORY4, CATEGORY4);
        categoriesMap.put(CATEGORY5, CATEGORY5);
        return categoriesMap;

    }

    private static Map<String, String> loadCategoriesDescription()
    {
        Map<String, String> categoriesDescriptionMap = new LinkedHashMap<>();
        categoriesDescriptionMap.put(CATEGORY1, CATEGORY1_DESCRIPTION);
        categoriesDescriptionMap.put(CATEGORY2, CATEGORY2_DESCRIPTION);
        categoriesDescriptionMap.put(CATEGORY3, CATEGORY3_DESCRIPTION);
        categoriesDescriptionMap.put(CATEGORY4, CATEGORY4_DESCRIPTION);
        categoriesDescriptionMap.put(CATEGORY5, CATEGORY5_DESCRIPTION);
        return categoriesDescriptionMap;

    }
}
