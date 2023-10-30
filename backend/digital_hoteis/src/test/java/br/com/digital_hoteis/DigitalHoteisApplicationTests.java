package br.com.digital_hoteis;

import br.com.digital_hoteis.app.api.dto.ConfiguracaoJdbc.H2Dao.CategoryH2IDao;
import br.com.digital_hoteis.app.api.dto.ConfiguracaoJdbc.H2Dao.CategoryIDaoInMemory;
import br.com.digital_hoteis.model.entity.Category;
import br.com.digital_hoteis.model.entity.RatingEnum;
import br.com.digital_hoteis.model.exception.CategoryNotFoundException;
import br.com.digital_hoteis.model.repository.CategoryRepository;
import br.com.digital_hoteis.model.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.junit.jupiter.api.Test;
import br.com.digital_hoteis.app.api.dto.ConfiguracaoJdbc.H2Dao.CategoryH2IDao;
import br.com.digital_hoteis.model.entity.Category;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Assertions;
import org.junit.Assert;


import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DigitalHoteisApplicationTests {
//
//	@InjectMocks
//	private CategoryServiceImpl categoryService;
//
//	@Mock
//	private CategoryRepository categoryRepository;
//
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.openMocks(this);
//	}
//
//
////	@Test
////	void createCategory() {
////		Category inputCategory = mock(Category.class);
////
////		Set<RatingEnum> ratings = new HashSet<>();
////		ratings.add(RatingEnum.FIVE_STARS);
////		when(inputCategory.getRatings()).thenReturn(ratings);
////
////		when(inputCategory.getDescription()).thenReturn("Description here");
////		when(inputCategory.getImage_url()).thenReturn("https://image.com.here");
////
////		when(categoryRepository.save(inputCategory)).thenReturn(inputCategory);
////
////		Category result = categoryService.createCategory(inputCategory);
////
////		assertEquals(inputCategory, result);
////	}
//
//	@Test
//	void createCategory() {
//		Category inputCategory = new Category();
//
//		inputCategory.setDescription("Description here");
//		inputCategory.setImage_url("https://image.com.here");
//		Category result = categoryService.createCategory(inputCategory);
//		when(categoryRepository.save(inputCategory)).thenReturn(inputCategory);
//
//		assertEquals(inputCategory, result);
//	}
//
//	@Test
//	void findAllCategories() {
//		// Create a mock Category for this test
//		Category category1 = new Category();
//		category1.setId(UUID.randomUUID());
//		category1.setRatings(RatingEnum.FIVE_STARS);
//		category1.setDescription("Category 1");
//		category1.setImage_url("http://unsplash.com/category1");
//
//		Category category2 = new Category();
//		category2.setId(UUID.randomUUID());
//		category2.setRatings(RatingEnum.FOUR_STARS);
//		category2.setDescription("Category 2");
//		category2.setImage_url("http://unsplash.com/category2");
//
//		Page<Category> expectedPage = new PageImpl<>(List.of(category1, category2));
//
//		when(categoryRepository.findAll(any(Pageable.class))).thenReturn(expectedPage);
//
//		Page<Category> result = categoryService.listAllCategories(mock(Pageable.class));
//
//		assertEquals(expectedPage, result);
//	}
//
//	@Test
//	void findCategoryById() {
//		// Create a mock Category for this test
//		Category expectedCategory = new Category();
//		UUID id = UUID.randomUUID();
//		expectedCategory.setId(id);
//		expectedCategory.setRatings(RatingEnum.FIVE_STARS);
//		expectedCategory.setDescription("Category by ID");
//		expectedCategory.setImage_url("http://unsplash.com/categoryById");
//
//		when(categoryRepository.findById(id)).thenReturn(Optional.of(expectedCategory));
//
//		Category result = categoryService.findCategoryById(id);
//
//		assertEquals(expectedCategory, result);
//	}
//
//	@Test
//	void atualizarCategory() {
//		// Create a mock Category for this test
//		Category existingCategory = new Category();
//		UUID id = UUID.randomUUID();
//		existingCategory.setId(id);
//		existingCategory.setRatings(RatingEnum.FIVE_STARS);
//		existingCategory.setDescription("Existing Category");
//		existingCategory.setImage_url("http://unsplash.com/existingCategory");
//
//		Map<String, Object> fields = new HashMap<>();
//		fields.put("description", "Updated Description");
//
//		when(categoryRepository.findById(id)).thenReturn(Optional.of(existingCategory));
//		when(categoryRepository.save(existingCategory)).thenReturn(existingCategory);
//
//		Category result = categoryService.updateCategoryById(id, fields);
//
//		assertEquals(existingCategory, result);
//	}
//
//	@Test
//	void excluirCategory() {
//		// Create a mock Category for this test
//		Category existingCategory = new Category();
//		UUID id = UUID.randomUUID();
//		existingCategory.setId(id);
//		existingCategory.setRatings(RatingEnum.FIVE_STARS);
//		existingCategory.setDescription("Category to delete");
//		existingCategory.setImage_url("http://unsplash.com/categoryToDelete");
//
//		when(categoryRepository.findById(id)).thenReturn(Optional.of(existingCategory));
//
//		categoryService.deleteCategoryById(id);
//	}

	// Create an instance of CategoryH2IDao
	// Create an instance of CategoryIDaoInMemory
	private CategoryIDaoInMemory categoryDao = new CategoryIDaoInMemory(new ArrayList<>());

	@Test
	public void testCategoryCRUDOperations() {

		Category newCategory = new Category();
		newCategory.setId(UUID.randomUUID());
		newCategory.setRatings(RatingEnum.THREE_STARS);
		newCategory.setDescription("Teste");
		newCategory.setImage_url("www.google.com/img");

		// Save newCategory to the database
		Category createdCategory = categoryDao.create(newCategory);

		// Generate a random UUID and assign it to foundCategory
		UUID randomUUID = UUID.randomUUID();
		createdCategory.setId(randomUUID);
		// Read
		Category foundCategory = categoryDao.findById(createdCategory.getId());
		foundCategory.setId(randomUUID);
		assertNotNull(foundCategory);
		assertEquals(newCategory.getId(), foundCategory.getId());

		// Updating
		Category updatedCategory = new Category(/* updated category details */);
		updatedCategory.setId(randomUUID);
		Category result = categoryDao.update(createdCategory.getId(), updatedCategory);
		assertNotNull(result);
		assertEquals(updatedCategory.getDescription(), result.getDescription());
		// Asserting it exists
		assertNotNull(categoryDao.findById(foundCategory.getId()));

		// Deleting
		categoryDao.delete(createdCategory.getId());
	}
}
