package br.com.digital_hoteis.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ratings")
    private RatingEnum ratings;

    @Column(nullable = false)
    private String description;

    private String image_url;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", ratings=" + ratings +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }

    public static Category newCategory(
            RatingEnum ratings,
            String description,
            String image_url) {
        Category category = new Category();
        category.setRatings(ratings);
        category.setDescription(description);
        category.setImage_url(image_url);
        return category;
    }
}
