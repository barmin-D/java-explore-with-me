package ru.practicum.explore.category.mapper;

import org.mapstruct.MappingTarget;
import ru.practicum.explore.category.dto.CategoryDto;
import ru.practicum.explore.category.dto.NewCategoryDto;
import ru.practicum.explore.category.model.Category;

public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);

    Category toCategory(NewCategoryDto newCategoryDto);

    public void updateCategoryFromCategoryDto(CategoryDto categoryDto, @MappingTarget Category category);
}
