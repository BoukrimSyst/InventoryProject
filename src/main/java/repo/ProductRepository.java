package repo;

import com.example.demo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteProductById(Long id);

    Optional<Product> findByProductId(Long id);
}
