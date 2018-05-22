package com.shop.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.entities.Category;
import com.shop.entities.Product;
import com.shop.service.ProductService;
import com.shop.util.Categories;
import com.shop.util.Constants;
import com.shop.util.Status;
import com.shop.wrappers.ProductModelWrapper;
import com.shop.wrappers.ProductWrapper;

@Controller
public class ProductController
{

    @Autowired
    private ProductService productService;

    private static final Logger LOG = LogManager.getLogger(ProductController.class);

    @RequestMapping( value = "/secure/delete/products-listing/{id}", method = RequestMethod.GET )
    public String deleteProduct(@PathVariable( "id" ) Long id, Model model, HttpSession session,
        HttpServletRequest request)
    {
        try {
            productService.deleteProductById(id);
            session.removeAttribute(Constants.TOTAL_PRODUCTS_COUNT);
        } catch (Exception ex) {
            LOG.debug("[ProductController][delete user] Error deleting product  with id:", id);
        }
        model.addAttribute("msg", "Product Deleted Successfully.");
        return "redirect:/secure/product-listing";
    }

    @RequestMapping( value = "/secure/edit/products-listing/{id}", method = RequestMethod.GET )
    public String editProduct(@PathVariable( "id" ) Long id, Model model, HttpSession session,
        HttpServletRequest request)
    {
        try {
            Product product = productService.findProductById(id);
            com.shop.models.ProductForm productForm = new com.shop.models.ProductForm();
            productForm.setProduct_id(product.getProduct_id());
            productForm.setProductName(product.getProductName());
            productForm.setProductDescription(product.getProductDescription());
            productForm.setPrice(product.getPrice());
            productForm.setQuantity(product.getQuantity());
            productForm.setImage1Loc(product.getImage1Loc());
            productForm.setImage2Loc(product.getImage2Loc());
            productForm.setImage3Loc(product.getImage3Loc());
            productForm.setImage4Loc(product.getImage4Loc());
            productForm.setImage5Loc(product.getImage5Loc());
            productForm.setImage1Thumb(product.getImage1Thumb());
            productForm.setImage2Thumb(product.getImage2Thumb());
            productForm.setImage3Thumb(product.getImage3Thumb());
            productForm.setImage4Thumb(product.getImage4Thumb());
            productForm.setImage5Thumb(product.getImage5Thumb());
            productForm.setCategory(product.getCategory().getCategoryName());
            productForm.setStatus(product.getStatus());
            model.addAttribute("productCategories", Categories.getCategories());
            model.addAttribute("productForm", productForm);
            model.addAttribute("productStatus", Status.getStatus());

        } catch (Exception ex) {
            LOG.debug("[ProductController][delete user] Error deleting product  with id:", id);
        }
        return "cart_edit_product";
    }

    @GetMapping( "/secure/addproduct" )
    public String addProducts(HttpSession session, HttpServletRequest request, Model model)
    {
        com.shop.models.ProductForm productForm = new com.shop.models.ProductForm();
        model.addAttribute("productCategories", Categories.getCategories());
        model.addAttribute("productForm", productForm);
        model.addAttribute("productStatus", Status.getStatus());
        return "cart_add_product";
    }

    @RequestMapping( value = "/secure/addNewProduct", method = RequestMethod.POST )
    public String createNewProduct(@Valid @ModelAttribute( "productForm" ) com.shop.models.ProductForm productForm,
        BindingResult result,
        Model model, HttpSession session, HttpServletRequest request, final RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()) {
            model.addAttribute("productCategories", Categories.getCategories());
            model.addAttribute("productForm", productForm);
            model.addAttribute("productStatus", Status.getStatus());
            return "cart_add_product";
        }
        boolean isUpdate = false;
        Product product = null;
        Category cat = new Category();
        if (productForm.getProduct_id() != null) {
            product = productService.findProductById(productForm.getProduct_id());
            isUpdate = true;
        } else {
            product = new Product();
            isUpdate = false;
        }
        cat.setCategoryName(productForm.getCategory());
        product.setProductName(productForm.getProductName());
        product.setProductDescription(productForm.getProductDescription());
        product.setPrice(productForm.getPrice());
        product.setQuantity(productForm.getQuantity());
        product.setImage1Loc(productForm.getImage1Loc());
        product.setImage2Loc(productForm.getImage2Loc());
        product.setImage3Loc(productForm.getImage3Loc());
        product.setImage4Loc(productForm.getImage4Loc());
        product.setImage5Loc(productForm.getImage5Loc());
        product.setImage1Thumb(productForm.getImage1Thumb());
        product.setImage2Thumb(productForm.getImage2Thumb());
        product.setImage3Thumb(productForm.getImage3Thumb());
        product.setImage4Thumb(productForm.getImage4Thumb());
        product.setImage5Thumb(productForm.getImage5Thumb());
        product.setUploadedDate(new Date());
        product.setLastUpdated(new Date());
        product.setStatus(productForm.getStatus());

        Set<Product> products = new HashSet<Product>();
        products.add(product);
        try {
            cat.setProducts(products);
            product.setCategory(cat);
            productService.save(cat);
            model.addAttribute("msg", "Product added Successfully.");
            if (session.getAttribute(Constants.TOTAL_PRODUCTS_COUNT) != null) {
                session.removeAttribute(Constants.TOTAL_PRODUCTS_COUNT);
            }
        } catch (Exception ex) {
            LOG.debug("[AdminController][CreateNewProduct] Error creating new user from admin:", ex);
        }
        model.addAttribute("productCategories", Categories.getCategories());
        model.addAttribute("productForm", productForm);
        model.addAttribute("productStatus", Status.getStatus());
        if(isUpdate) {
            return "redirect:/secure/product-listing";
        }
        return "cart_add_product";
    }

    @GetMapping( "/secure/product-listing" )
    public String getProductsListing(HttpSession session, HttpServletRequest request, Model model)
    {
        return "cart_products_listing";
    }

    @SuppressWarnings( "unchecked" )
    @RequestMapping( value = "/secure/productslist", method = RequestMethod.GET )
    public @ResponseBody ProductWrapper showProducts(
        @RequestParam( value = "from", required = true ) int from,
        @RequestParam( value = "to", required = true ) int to,
        @RequestParam( value = "order", required = false ) String order,
        @RequestParam( value = "columnName", required = false ) String columnName,
        HttpSession session,
        HttpServletRequest request, HttpServletResponse response)
    {
        if (StringUtils.isBlank(order)) {
            order = "desc";
        }
        if (StringUtils.isBlank(columnName)) {
            columnName = "uploadedDate";
        }
        List<Product> productList = Collections.emptyList();
        List<ProductModelWrapper> productModelList = new ArrayList<>();
        int totalResults = 0;
        String key = from + "-" + to + "-" + order + "-" + columnName;

        /* spring sessions - jdbc in memory storage ( not tomcat session ) */

        if (session.getAttribute(Constants.TOTAL_PRODUCTS_COUNT) == null) {
            session.removeAttribute(key);
        }
        if (session.getAttribute(key) != null && session.getAttribute(Constants.TOTAL_PRODUCTS_COUNT) != null) {
            return new ProductWrapper((int)session.getAttribute(Constants.TOTAL_PRODUCTS_COUNT),
                                      (List<ProductModelWrapper>)session.getAttribute(key));
        }
        try {
            totalResults = productService.getTotalProductsCount();
            Page<Product> page = productService.getAllProducts(from, to, order, columnName);
            productList = page.getContent();

            for (Product product : productList) {
                ProductModelWrapper productWrapper = new ProductModelWrapper();
                productWrapper.setProductId(product.getProduct_id());
                productWrapper.setProductName(product.getProductName());
                productWrapper.setProductDescription(product.getProductDescription());
                productWrapper.setPrice(product.getPrice());
                productWrapper.setQuantity(product.getQuantity());
                productWrapper.setCategory(product.getCategory().getCategoryName());
                productWrapper.setCategoryDescription(product.getCategory().getCategoryDescription());
                productWrapper.setCategoryImage(product.getCategory().getCatImage());
                productWrapper.setImage1Loc(product.getImage1Loc());
                productWrapper.setImage2Loc(product.getImage2Loc());
                productWrapper.setImage3Loc(product.getImage3Loc());
                productWrapper.setImage4Loc(product.getImage4Loc());
                productWrapper.setImage5Loc(product.getImage5Loc());
                productWrapper.setImage1Thumb(product.getImage1Loc());
                productWrapper.setImage1Thumb(product.getImage2Loc());
                productWrapper.setImage1Thumb(product.getImage3Loc());
                productWrapper.setImage1Thumb(product.getImage4Loc());
                productWrapper.setImage1Thumb(product.getImage5Loc());
                productWrapper.setStatus(product.getStatus());
                productModelList.add(productWrapper);
            }
            session.setAttribute(key, productModelList);
            session.setAttribute(Constants.TOTAL_PRODUCTS_COUNT, totalResults);
        } catch (Exception ex) {
            LOG.debug("[Product Controller][showProducts]: Error in getting products" + ex);
        }

        return new ProductWrapper(totalResults, productModelList);
    }

}
