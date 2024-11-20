package edu.icet.pms.service.impl;

import edu.icet.pms.dao.HallDao;
import edu.icet.pms.model.Hall;
import edu.icet.pms.entity.HallEntity;
import edu.icet.pms.service.HallService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallDao repository;
    private final ModelMapper mapper;
    private final EntityManager entityManager;

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
    public List<Hall> getHallsByFiltering(String type, Integer capacity, Boolean internetAccess, Boolean climateControl, Boolean decoratorStyle, Integer rating, Boolean available) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HallEntity> criteriaQuery = criteriaBuilder.createQuery(HallEntity.class);
        Root<HallEntity> root = criteriaQuery.from(HallEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (type != null) {
            predicates.add(criteriaBuilder.equal(root.get("type"), type));
        }
        if (capacity != null) {
            predicates.add(criteriaBuilder.equal(root.get("capacity"), capacity));
        }
        if (internetAccess != null) {
            predicates.add(criteriaBuilder.equal(root.get("internetAccess"), internetAccess));
        }
        if (climateControl != null) {
            predicates.add(criteriaBuilder.equal(root.get("climateControl"), climateControl));
        }
        if (decoratorStyle != null) {
            predicates.add(criteriaBuilder.equal(root.get("decoratorStyle"), decoratorStyle));
        }
        if (rating != null) {
            predicates.add(criteriaBuilder.equal(root.get("rating"), rating));
        }
        if (available != null) {
            predicates.add(criteriaBuilder.equal(root.get("available"), available));
        }

        if (!predicates.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        }
        return entityManager.createQuery(criteriaQuery).getResultList().stream().map(hallEntity -> mapper.map(hallEntity, Hall.class)).toList();

    }
}
