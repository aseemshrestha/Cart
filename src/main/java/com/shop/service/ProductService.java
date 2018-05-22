package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.shop.entities.Category;
import com.shop.entities.Product;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public void save(Category products)
    {
        categoryRepo.save(products);
    }

    public int getTotalProductsCount()
    {
        return productRepo.countAllProducts();
    }

    public Page<Product> getAllProducts(int start, int end, String order, String sortColumn)
    {

        Page<Product> productList =
            productRepo.findAll(new PageRequest(start, end, Direction.fromString(order), sortColumn));
        return productList;
    }

    public void deleteProductById(Long id)
    {
        productRepo.deleteByProductId(id);
    }

    public Product findProductById(Long id)
    {
        return productRepo.findOne(id);
    }

}
