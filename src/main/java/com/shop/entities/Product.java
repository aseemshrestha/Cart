package com.shop.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table( name = "PRODUCTS" )
public class Product implements Serializable
{

    private static final long serialVersionUID = 1742520836253601601L;

    private Long product_id;
    @Column( nullable = false )
    @NotEmpty
    private String productName;
    @Column( nullable = false )
    @NotEmpty
    private String productDescription;
    @Column( nullable = false )
    @Min( value = 0L, message = "The value must be positive" )
    private double price;
    @Column( nullable = false )
    @Min( value = 0L, message = "The value must be positive" )
    private int quantity;
    @Column( nullable = false )
    @NotEmpty
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
    private Date uploadedDate;
    private Date lastUpdated;
    private String status;
    private Category category;

    public Product()
    {}

    public Product(String productName, String productDescription, double price, int quantity, String image1Loc,
        String image2Loc, String image3Loc, String image4Loc, String image5Loc, String image1Thumb, String image2Thumb,
        String image3Thumb, String image4Thumb, String image5Thumb, Date uploadedDate, Date lastUpdated,
        Category category, String status)
    {
        super();
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
        this.image1Loc = image1Loc;
        this.image2Loc = image2Loc;
        this.image3Loc = image3Loc;
        this.image4Loc = image4Loc;
        this.image5Loc = image5Loc;
        this.image1Thumb = image1Thumb;
        this.image2Thumb = image2Thumb;
        this.image3Thumb = image3Thumb;
        this.image4Thumb = image4Thumb;
        this.image5Thumb = image5Thumb;
        this.uploadedDate = uploadedDate;
        this.lastUpdated = lastUpdated;
        this.category = category;
    }
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public Long getProduct_id()
    {
        return product_id;
    }

    public void setProduct_id(Long product_id)
    {
        this.product_id = product_id;
    }

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

    public Date getUploadedDate()
    {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate)
    {
        this.uploadedDate = uploadedDate;
    }

    public Date getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    @ManyToOne
    @JoinColumn( name = "CATEGORY_ID" )
    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
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

}
