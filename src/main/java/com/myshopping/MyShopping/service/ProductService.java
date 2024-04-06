package com.myshopping.MyShopping.service;

import com.myshopping.MyShopping.exceptions.ResourceNotFound;
import com.myshopping.MyShopping.exceptions.UnAuthorized;
import com.myshopping.MyShopping.models.AppUser;
import com.myshopping.MyShopping.models.Product;
import com.myshopping.MyShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    //make a logic to save the product
@Autowired
    UserService userService;
@Autowired
ProductRepository productRepository;
    public void registerProduct(Product product, UUID sellerId){
        AppUser user=userService.getUserById(sellerId);
        if(user==null){
            throw new ResourceNotFound(String.format("Seller with sellerId %s doesnot exists", sellerId.toString()));
        }
        if(!user.getUserType().equals("SELLER")){
            throw new UnAuthorized(String.format("User with id %s does not authorized",sellerId.toString()));
        }
        product.setUser(user);
        productRepository.save(product);
    }
}
