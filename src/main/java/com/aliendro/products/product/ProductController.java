package com.aliendro.products.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    public Optional<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(path ="/{id}")
    public Optional<Product> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody(required = false) Product newProduct,
            @RequestParam(required = false) String newName,
            @RequestParam(required = false) String newDescription,
            @RequestParam(required = false) Integer newPrice,
            @RequestParam(required = false) String newThumbnail) {
        return productService.updateProduct(
                id,
                newProduct,
                newName,
                newDescription,
                newPrice,
                newThumbnail);
    }
}
