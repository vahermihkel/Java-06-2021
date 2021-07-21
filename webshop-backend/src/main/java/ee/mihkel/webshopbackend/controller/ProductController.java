package ee.mihkel.webshopbackend.controller;

import ee.mihkel.webshopbackend.model.Product;
import ee.mihkel.webshopbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// anda kaasa parameetrid, et limiteerida päringuid

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

//    localhost:8080/items (get päring)
    @GetMapping("items")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    //    localhost:8080/add-item (post päring)
    @PostMapping("add-item" )
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("delete-item/{id}" )
    public void deleteItem(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("item/{id}")
    public Optional<Product> getOneProduct(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(2000);
        return productService.getOneProduct(id);
    }

//    id ära võtta
    @PostMapping("edit-item/{id}")
    public void getOneProduct(@RequestBody Product product) {
        productService.editProduct(product);
    }

}
