package com.adamdrsinc.StoreSpringBoot.product;

import com.adamdrsinc.StoreSpringBoot.product.exceptions.ProductAlreadyExistsException;
import com.adamdrsinc.StoreSpringBoot.product.exceptions.ProductNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepo;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductController(ProductRepository productRepo, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.productRepo = productRepo;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @GetMapping("/all")
    List<Product> findAll() { return productRepo.findAll(); }

    @GetMapping("/id/{id}")
    Product findById(@PathVariable Integer id){
        var oProduct = productRepo.findById(id);
        if(oProduct.isEmpty()){
            throw new ProductNotFoundException("Product with ID {" + id + "} not found.");
        }
        return oProduct.get();
    }

    @GetMapping("/name/{name}")
    Product findByName(@PathVariable String name){
        var oProduct = productRepo.findProductByName(name.toLowerCase());
        if(oProduct.isEmpty()){
            throw new ProductNotFoundException("Product with name {" + name + "} not found.");
        }
        return oProduct.get();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Product newProduct){
        Product copy = new Product(
                null,
                newProduct.name().toLowerCase(),
                newProduct.price(),
                newProduct.description(),
                newProduct.stockCount(),
                null
        );

        var oProduct = productRepo.findProductByName(copy.name());
        if(oProduct.isPresent()){
            throw new ProductAlreadyExistsException("Product with name {" + copy.name() + "} already exists.");
        }
        productRepo.save(copy);
    }

    @PutMapping("/update/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProductById(@PathVariable Integer id, @Valid @RequestBody Product newProduct) {
        var oProduct = productRepo.findById(id);
        if (oProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with ID {" + id + "} not found. Product not updated.");
        }

        productRepo.updateProductById(
                id, newProduct.name().toLowerCase(), newProduct.price(),
                newProduct.description(), newProduct.stockCount()
        );
    }

    @PutMapping("/update/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateByName(@PathVariable String name){
        var oProduct = productRepo.findProductByName(name);
        if(oProduct.isEmpty())
            throw new ProductNotFoundException("Product with name {" + name + "} not found. Stock not updated.");
        productRepo.save(oProduct.get());
    }

    @PutMapping("/update/price")

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id){
        var oProduct = productRepo.findById(id);
        if(oProduct.isEmpty())
            throw new ProductNotFoundException("Product with ID {" + id + "} not found. No product was deleted.");
        productRepo.delete(oProduct.get());
    }

    @DeleteMapping("/delete/many")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMany(@RequestBody List<Integer> listOfIds){
        for(Integer id : listOfIds){
            var prod = productRepo.findById(id);
            if(prod.isPresent()){
                productRepo.delete(prod.get());
                listOfIds.remove(id);
            }
        }

        if(!listOfIds.isEmpty()){
            logger.warn("The following IDs were not deleted: " + listOfIds);
        }
    }
}
