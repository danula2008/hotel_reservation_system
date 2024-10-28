package edu.icet.pms.service.impl;

import edu.icet.pms.dao.HallDao;
import edu.icet.pms.dto.Hall;
import edu.icet.pms.entity.HallEntity;
import edu.icet.pms.service.HallService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallDao repository;
    private final ModelMapper mapper;

    @Override
    public String addHall(Hall hall) {
        return repository.save(mapper.map(hall, HallEntity.class)).getId();
    }

    @Override
    public void deleteHall(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Hall> getAllHalls() {
        return repository.findAll().stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }

    @Override
    public Hall getHallById(String id) {
        return mapper.map(repository.getReferenceById(id), Hall.class);
    }

    @Override
    public List<Hall> getHallsByCapacity(Integer capacity) {
        return repository.findByCapacity(capacity).stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }

    @Override
    public List<Hall> getHallsByInternetAccess(Boolean internetAccess) {
        return repository.findByInternetAccess(internetAccess).stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }

    @Override
    public List<Hall> getHallsByClimateControl(Boolean climateControl) {
        return repository.findByClimateControl(climateControl).stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }

    @Override
    public List<Hall> getHallsByDecoratorStyle(String decoratorStyle) {
        return repository.findByDecoratorStyle(decoratorStyle).stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }

    @Override
    public List<Hall> getHallsByType(String type) {
        return repository.findByType(type).stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }

    @Override
    public List<Hall> getHallsByStatus(String status) {
        return repository.findByStatus(status).stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();
    }
}
