package com.myshopping.MyShopping.controller;

import com.myshopping.MyShopping.exceptions.ResourceNotFound;
import com.myshopping.MyShopping.exceptions.UnAuthorized;
import com.myshopping.MyShopping.models.Product;
import com.myshopping.MyShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    ProductService productService;
@PostMapping("/product/add")
    public String addProduct(@RequestBody Product product, @RequestParam UUID sellerId){
     try{
         productService.registerProduct(product,sellerId);
     }catch(ResourceNotFound resourceNotFound){
        return resourceNotFound.getMessage();
     }catch (UnAuthorized unAuthorized){
        return unAuthorized.getMessage();
     }
        return "Product got saved successfully";
    }
}
