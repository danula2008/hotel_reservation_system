package edu.icet.pms.service.impl;

import edu.icet.pms.dao.DayOutPackageDao;
import edu.icet.pms.dto.DayOutPackage;
import edu.icet.pms.entity.DayOutPackageEntity;
import edu.icet.pms.service.DayOutPackageService;
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
public class DayOutPackageServiceImpl implements DayOutPackageService {

    private final DayOutPackageDao repository;
    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Override
    public String addDop(DayOutPackage dop) {
        return repository.save(mapper.map(dop, DayOutPackageEntity.class)).getId();
    }

    @Override
    public void deleteDop(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<DayOutPackage> getAllDop() {
        return repository.findAll().stream().map(dayOutPackageEntity -> mapper.map(dayOutPackageEntity, DayOutPackage.class)).toList();
    }

    @Override
    public DayOutPackage getDopById(String id) {
        return mapper.map(repository.getReferenceById(id), DayOutPackage.class);
    }

    @Override
    public List<DayOutPackage> getDopByFiltering(String duration, String timeOfDay, Integer rating, Boolean available) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DayOutPackageEntity> criteriaQuery = criteriaBuilder.createQuery(DayOutPackageEntity.class);
        Root<DayOutPackageEntity> root = criteriaQuery.from(DayOutPackageEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (duration != null) {
            predicates.add(criteriaBuilder.equal(root.get("duration"), duration));
        }
        if (timeOfDay != null) {
            predicates.add(criteriaBuilder.equal(root.get("timeOfDay"), timeOfDay));
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
        return entityManager.createQuery(criteriaQuery).getResultList().stream().map(dayOutPackageEntity -> mapper.map(dayOutPackageEntity, DayOutPackage.class)).toList();
    }
}
