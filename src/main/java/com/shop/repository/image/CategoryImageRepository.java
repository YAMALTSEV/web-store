package com.shop.repository.image;

import com.shop.model.image.CategoryImage;
import com.shop.model.image.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryImageRepository extends JpaRepository<CategoryImage, Integer> {
}
