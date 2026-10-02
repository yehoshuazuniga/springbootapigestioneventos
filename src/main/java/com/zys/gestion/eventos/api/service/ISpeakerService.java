package com.zys.gestion.eventos.api.service;

import com.zys.gestion.eventos.api.domain.Speaker;
import com.zys.gestion.eventos.api.dto.SpeakerRequestDto;

import java.util.List;

public interface ISpeakerService {
    Speaker save(SpeakerRequestDto requestDto);
    Speaker findById(Long id);
    List<Speaker> findAll();
    Speaker update(Long id, SpeakerRequestDto requestDto);
    void deleteById(Long id);
}
