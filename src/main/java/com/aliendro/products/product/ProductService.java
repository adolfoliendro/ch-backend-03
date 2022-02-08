package com.aliendro.products.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final static Logger logger = LogManager.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        if(productRepository.count() != 0)
            logger.info("Se presentan " + productRepository.count() + " productos.");
        else
            logger.info("No hay productos cargados.");
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        logger.info("Se agregó un producto.");
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        logger.info("Se presenta el producto.");
        return productRepository.findProductById(id);
    }

    public Optional<Product> deleteProduct(Long id) {
        if(productRepository.existsById(id)) {
            Optional<Product> product = productRepository.findProductById(id);
            productRepository.deleteById(id);
            logger.info("Se ha borrado el producto.");
            return product;
        } else {
            logger.error("No existe el producto.");
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<Product> updateProduct(
            Long id,
            Product newProduct,
            String newName,
            String newDescription,
            Integer newPrice,
            String newThumbnail) {
        Optional<Product> product = productRepository.findProductById(id);
        if(product.isPresent()) {
            if(newProduct != null)
                product.get().setData(newProduct);
            if(newName != null)
                product.get().setName(newName);
            if(newDescription != null)
                product.get().setDescription(newDescription);
            if(newPrice != null)
                product.get().setPrice((newPrice));
            if(newThumbnail != null)
                product.get().setPrice(newPrice);
            logger.info("Se realizaron cambios en el producto.");
        } else {
            logger.error("No existe el producto.");
        }
        return product;
    }
}
