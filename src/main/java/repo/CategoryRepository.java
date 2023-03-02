package repo;

import com.example.demo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    void deleteCategoryById(Long id);
}
