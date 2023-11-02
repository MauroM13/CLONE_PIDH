package br.com.digital_hoteis.app.api.runner;

import br.com.digital_hoteis.model.entity.Category;
import br.com.digital_hoteis.model.entity.RatingEnum;
import br.com.digital_hoteis.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Profile("dev")
@Component
public class PopulateCategoryRunner implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public PopulateCategoryRunner(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private Category createCategoryWithDetails(RatingEnum ratings, String description, String imageUrl) {
        Category category = new Category();
        category.setRatings(ratings);
        category.setDescription(description);
        category.setImage_url(imageUrl);
        return category;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Category> categories = new ArrayList<>();

        // Hotel Category
        Category hotels = createCategoryWithDetails(
                RatingEnum.FIVE_STARS,
                "A five-star hotel perfect for a family's vacation",
                "http://unsplash.com/img_test"
        );
        categories.add(hotels);

        // Hostel Category
        Category hostels = createCategoryWithDetails(
                RatingEnum.THREE_STARS,
                "A three-star hostel comfortable enough for short trips",
                "http://unsplash.com/img_test"
        );
        categories.add(hostels);

        // Apartments Category
        Category apartments = createCategoryWithDetails(
                RatingEnum.FIVE_STARS,
                "Perfect place to feel at home on trips",
                "http://unsplash.com/img_test"
        );
        categories.add(apartments);

        // Bed & Breakfast Category
        Category bedAndBreakfast = createCategoryWithDetails(
                RatingEnum.FIVE_STARS,
                "Economic and comfortable option for long trips",
                "http://unsplash.com/img_test"
        );
        categories.add(bedAndBreakfast);

        categoryRepository.saveAll(categories);
    }
}
