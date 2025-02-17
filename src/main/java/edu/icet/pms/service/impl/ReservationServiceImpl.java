package edu.icet.pms.service.impl;

import edu.icet.pms.dao.ReservationDao;
import edu.icet.pms.model.Reservation;
import edu.icet.pms.model.Room;
import edu.icet.pms.entity.ReservationEntity;
import edu.icet.pms.entity.RoomEntity;
import edu.icet.pms.service.ReservationService;
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
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao repository;
    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Override
    public String addReservation(Reservation reservation) {
        return repository.save(mapper.map(reservation, ReservationEntity.class)).getId();
    }

    @Override
    public void deleteReservation(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return repository.findAll().stream().map(reservationEntity -> mapper.map(reservationEntity, Reservation.class)).toList();
    }

    @Override
    public Reservation getReservationById(String id) {
        return mapper.map(repository.getReferenceById(id), Reservation.class);
    }

    @Override
    public List<Reservation> getReservationsByFiltering(String status, String customerId, Boolean paymentCompleted,String resourceType) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ReservationEntity> criteriaQuery = criteriaBuilder.createQuery(ReservationEntity.class);
        Root<ReservationEntity> root = criteriaQuery.from(ReservationEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (status != null) {
            predicates.add(criteriaBuilder.equal(root.get("status"), status));
        }
        if (customerId != null) {
            predicates.add(criteriaBuilder.equal(root.get("customerId"), customerId));
        }
        if (paymentCompleted != null) {
            predicates.add(criteriaBuilder.equal(root.get("bedType"), paymentCompleted));
        }
        if (resourceType != null) {
            predicates.add(criteriaBuilder.equal(root.get("resourceType"), resourceType));
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList().stream().map(reservationEntity -> mapper.map(reservationEntity, Reservation.class)).toList();
    }
}
