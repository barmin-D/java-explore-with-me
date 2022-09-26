package ru.practicum.explore.category.mapper;

import ru.practicum.explore.category.dto.CategoryDto;
import ru.practicum.explore.category.model.Category;

public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);

    Category toCategory(CategoryDto categoryDto);
}
