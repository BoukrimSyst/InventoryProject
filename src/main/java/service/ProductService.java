package service;

import com.example.demo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ProductRepository;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findByProductId(id)
                .orElseThrow(() -> new RuntimeException("User by ID "+ id + "was not found !"));
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteProductById(id);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);

    }
}
