package ee.mihkel.webshopbackend.controller;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
