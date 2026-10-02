package com.zys.gestion.eventos.api.mapper;

import com.zys.gestion.eventos.api.domain.Event;
import com.zys.gestion.eventos.api.dto.EventRequestDto;
import com.zys.gestion.eventos.api.dto.EventResponseDto;
import com.zys.gestion.eventos.api.dto.EventSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "speakers", ignore = true)
    @Mapping(target = "attendedUsers", ignore = true)
    Event toEntity(EventRequestDto eventRequestDto);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "speakers", source = "speakers")
    EventResponseDto toResponseDto(Event event);

    List<EventResponseDto> toEventResponseDtoList(List<Event> events);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "speakers", ignore = true)
    @Mapping(target = "attendedUsers", ignore = true)
    void updateEventFromDto(EventRequestDto dto, @MappingTarget Event event);

    EventSummaryDto toSummuryDto(Event event);

    List<EventSummaryDto> toSummuryDto(List<Event> events);
}
