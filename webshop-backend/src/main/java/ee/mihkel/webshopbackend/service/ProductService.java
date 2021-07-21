package ee.mihkel.webshopbackend.service;

import ee.mihkel.webshopbackend.model.Product;
import ee.mihkel.webshopbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getOneProduct(long id) {
        return productRepository.findById(id);
    }

    public void editProduct(Product product) {
        productRepository.save(product);
    }
}
