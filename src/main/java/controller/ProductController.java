package controller;

import com.example.demo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

public class ProductController {


    private final ProductService productService;



    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/find/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add/product")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/Delete/product/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Long id){

        productService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/product")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }
}
