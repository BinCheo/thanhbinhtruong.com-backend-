package blog.com.admin.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.com.entity.Category;
import blog.com.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/admin/api")
public class AdminCategoryApi {

	@Autowired
	private CategoryService categoryService;
	

	
	
	@GetMapping(value = "/category")
	public List<Category> getCategory() {
		return categoryService.findAll();		 
	}
	
	@GetMapping(value = "/category/{id}")
	public Category getNewsOne(@PathVariable("id") Long id) {
		return categoryService.findById(id);
	}
	
	@PostMapping(value = "/category")
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}	
	@DeleteMapping(value = "/category")
	public void deleteCategory(@RequestBody long[] ids) {
		categoryService.delete(ids);
	}
	@PutMapping(value = "/category/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
		category.setId(id);
		return categoryService.save(category);
	}
}
