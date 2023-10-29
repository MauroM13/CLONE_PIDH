package br.com.digital_hoteis;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryControllerTest {

    private CriteriaBuilder.Case<R> Mockito;

    @Test
    public void testFindCategories() {

        CategoryService categoryService = Mockito.mock(CategoryService.class);
        CategoryController categoryController = new CategoryController(categoryService);


        Page<Category> dummyPage = // criar uma página de exemplo;
                Mockito.when(categoryService.listAllCategories(Mockito.any(Pageable.class))).thenReturn(dummyPage);


        ResponseEntity<Page<CategorySummaryResponse>> response = categoryController.findCategories(Mockito.mock(Pageable.class));


        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
