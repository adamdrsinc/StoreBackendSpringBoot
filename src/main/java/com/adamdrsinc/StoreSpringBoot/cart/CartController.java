package com.adamdrsinc.StoreSpringBoot.cart;

import com.adamdrsinc.StoreSpringBoot.product.Product;
import com.adamdrsinc.StoreSpringBoot.product.ProductRepository;
import com.adamdrsinc.StoreSpringBoot.cart.exceptions.CartNotFoundException;
import com.adamdrsinc.StoreSpringBoot.product.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public CartController(CartRepository cartRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    //TODO: Implement Cart.addProductToCart
    @PutMapping("/addProduct/{cartId}/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addProductToCart(@PathVariable Integer cartId, @PathVariable Integer productId) {
        var oCart = cartRepo.findById(cartId);
        if (oCart.isEmpty()) {
            throw new CartNotFoundException("Cart with ID {" + cartId + "} not found.");
        }

        var oProduct = productRepo.findById(productId);
        if (oProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with ID {" + productId + "} not found.");
        }

        Cart cart = oCart.get();
        Product product = oProduct.get();
        //cart.addProduct(product);
        cartRepo.save(cart);
    }
}