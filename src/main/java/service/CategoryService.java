package service;

import com.example.demo.Category;
import com.example.demo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repo.CategoryRepository;
import repo.ProductRepository;

import java.util.List;
import java.util.UUID;

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category by ID "+ id + "was not found !"));
    }

    public Category addCategory(Category category) {
        category.setCategoryID(Long.valueOf(UUID.randomUUID().toString()));
        return categoryRepository.save(category);
    }


    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }

    public void removeCategory(Long id) {
        categoryRepository.deleteCategoryById(id);
    }





}
