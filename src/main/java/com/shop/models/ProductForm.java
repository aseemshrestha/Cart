package com.shop.models;

import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

public class ProductForm
{

    private Long product_id;

    @NotEmpty( message = "Product name is required." )
    private String productName;

    @NotEmpty( message = "Product description cannot be empty." )
    private String productDescription;

    @Min( value = 0L, message = "Price must be a number and  positive value." )
    private double price;

    @Min( value = 0L, message = "The value must be positive" )
    private int quantity;

    @NotEmpty( message = "Atleast one image is required." )
    private String image1Loc;

    private String image2Loc;
    private String image3Loc;
    private String image4Loc;
    private String image5Loc;
    private String image1Thumb;
    private String image2Thumb;
    private String image3Thumb;
    private String image4Thumb;
    private String image5Thumb;

    @NotEmpty( message = "Product category is required." )
    private String category;

    @NotEmpty( message = "Status is required." )
    private String status;

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getImage1Loc()
    {
        return image1Loc;
    }

    public void setImage1Loc(String image1Loc)
    {
        this.image1Loc = image1Loc;
    }

    public String getImage2Loc()
    {
        return image2Loc;
    }

    public void setImage2Loc(String image2Loc)
    {
        this.image2Loc = image2Loc;
    }

    public String getImage3Loc()
    {
        return image3Loc;
    }

    public void setImage3Loc(String image3Loc)
    {
        this.image3Loc = image3Loc;
    }

    public String getImage4Loc()
    {
        return image4Loc;
    }

    public void setImage4Loc(String image4Loc)
    {
        this.image4Loc = image4Loc;
    }

    public String getImage5Loc()
    {
        return image5Loc;
    }

    public void setImage5Loc(String image5Loc)
    {
        this.image5Loc = image5Loc;
    }

    public String getImage1Thumb()
    {
        return image1Thumb;
    }

    public void setImage1Thumb(String image1Thumb)
    {
        this.image1Thumb = image1Thumb;
    }

    public String getImage2Thumb()
    {
        return image2Thumb;
    }

    public void setImage2Thumb(String image2Thumb)
    {
        this.image2Thumb = image2Thumb;
    }

    public String getImage3Thumb()
    {
        return image3Thumb;
    }

    public void setImage3Thumb(String image3Thumb)
    {
        this.image3Thumb = image3Thumb;
    }

    public String getImage4Thumb()
    {
        return image4Thumb;
    }

    public void setImage4Thumb(String image4Thumb)
    {
        this.image4Thumb = image4Thumb;
    }

    public String getImage5Thumb()
    {
        return image5Thumb;
    }

    public void setImage5Thumb(String image5Thumb)
    {
        this.image5Thumb = image5Thumb;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Long getProduct_id()
    {
        return product_id;
    }

    public void setProduct_id(Long product_id)
    {
        this.product_id = product_id;
    }

}
