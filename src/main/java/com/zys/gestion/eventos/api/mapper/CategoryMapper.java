package com.zys.gestion.eventos.api.mapper;

import com.zys.gestion.eventos.api.domain.Category;
import com.zys.gestion.eventos.api.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}