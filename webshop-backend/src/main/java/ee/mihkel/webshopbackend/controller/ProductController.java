package ee.mihkel.webshopbackend.controller;

import ee.mihkel.webshopbackend.model.Product;
import ee.mihkel.webshopbackend.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// anda kaasa parameetrid, et limiteerida päringuid

@Api(value = "Products API endpoints")
@RestController()
@CrossOrigin( origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

//    localhost:8080/items (get päring)
    @ApiOperation("Gets all products from webshop")
    @GetMapping("items")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    //    localhost:8080/add-item (post päring)
    @ApiOperation("Add new product")
    @PostMapping("add-item" )
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @ApiOperation("Delete product")
    @DeleteMapping("delete-item/{id}" )
    public void deleteItem(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @ApiOperation("Get one single product")
    @GetMapping("item/{id}")
    public Optional<Product> getOneProduct(@PathVariable Long id) throws ProductNotFoundException, InterruptedException {
        Thread.sleep(2000);
        if (productService.getOneProduct(id).isEmpty()) {
            throw new ProductNotFoundException("Product not found, ID provided: " + id);
        }
        return productService.getOneProduct(id);
    }

//    id ära võtta
    @ApiOperation("Edit product")
    @PostMapping("edit-item/{id}")
    public void getOneProduct(@RequestBody Product product) {
        productService.editProduct(product);
    }
}
