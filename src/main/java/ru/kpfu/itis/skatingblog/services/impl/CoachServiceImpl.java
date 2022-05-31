package ru.kpfu.itis.skatingblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.dto.CoachDto;
import ru.kpfu.itis.skatingblog.models.Coach;
import ru.kpfu.itis.skatingblog.repositories.ArticleRepository;
import ru.kpfu.itis.skatingblog.repositories.CoachRepository;
import ru.kpfu.itis.skatingblog.repositories.CommentRepository;
import ru.kpfu.itis.skatingblog.services.CoachService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository, ModelMapper modelMapper) {
        this.coachRepository = coachRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<CoachDto> getAllCoaches() {
        return coachRepository
                .findAll().stream()
                .map(coach -> modelMapper.map(coach, CoachDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<CoachDto> getCoachById(Long id) {
        return coachRepository
                .findById(id)
                .map(coach -> modelMapper.map(coach, CoachDto.class));
    }

    @Override
    @Transactional
    public List<Coach> findCoachesBySpeciality(String specName) {
        return coachRepository.findCoachesBySpeciality(specName);
    }
}
