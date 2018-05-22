package com.shop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shop.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Query( value = "select count(product_id) from Products", nativeQuery = true )
    public int countAllProducts();

    @Transactional
    @Modifying
    @Query( value = "delete from Products where product_id=?1", nativeQuery = true )
    void deleteByProductId(Long id);
   
}
