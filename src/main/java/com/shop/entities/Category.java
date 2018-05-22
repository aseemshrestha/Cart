package com.shop.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table( name = "CATEGORY" )
public class Category
{

    private int category_id;
    private String categoryName;
    private String categoryDescription;
    private String catImage;
    private Set<Product> products;

    public Category()
    {}

    public Category(String categoryName, String categoryDescription, String catImage, Set<Product> products)
    {
        super();
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.catImage = catImage;
        this.products = products;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public int getCategory_id()
    {
        return category_id;
    }

    public void setCategory_id(int category_id)
    {
        this.category_id = category_id;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription()
    {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription)
    {
        this.categoryDescription = categoryDescription;
    }

    public String getCatImage()
    {
        return catImage;
    }

    public void setCatImage(String catImage)
    {
        this.catImage = catImage;
    }

    @OneToMany( mappedBy = "category", cascade = CascadeType.ALL )
    public Set<Product> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }

}
