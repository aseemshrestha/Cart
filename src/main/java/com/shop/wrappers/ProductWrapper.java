package com.shop.wrappers;

import java.util.List;

public class ProductWrapper
{

    private int totalCount;
    private List<ProductModelWrapper> details;

    public ProductWrapper(int totalCount, List<ProductModelWrapper> list)
    {
        this.totalCount = totalCount;
        this.details = list;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public List<ProductModelWrapper> getList()
    {
        return details;
    }

}
