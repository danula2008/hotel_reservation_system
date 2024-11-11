package edu.icet.pms.service.impl;

import edu.icet.pms.dao.RoomDao;
import edu.icet.pms.dto.Room;
import edu.icet.pms.entity.RoomEntity;
import edu.icet.pms.service.RoomService;
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
public class RoomServiceImpl implements RoomService {

    private final RoomDao repository;
    private final ModelMapper mapper;
    private final EntityManager entityManager;

    @Override
    public String addRoom(Room room) {
        return repository.save(mapper.map(room, RoomEntity.class)).getId();
    }

    @Override
    public void deleteRoom(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return repository.findAll().stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public Room getRoomById(String id) {
        return mapper.map(repository.getReferenceById(id), Room.class);
    }

    @Override
    public List<Room> getRoomsByFiltering(String type, Integer capacity, String bedType, String view, Boolean internetAccess, Boolean television, Integer rating, Boolean available) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RoomEntity> criteriaQuery = criteriaBuilder.createQuery(RoomEntity.class);
        Root<RoomEntity> root = criteriaQuery.from(RoomEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (type != null) {
            predicates.add(criteriaBuilder.equal(root.get("type"), type));
        }
        if (capacity != null) {
            predicates.add(criteriaBuilder.equal(root.get("capacity"), capacity));
        }
        if (bedType != null) {
            predicates.add(criteriaBuilder.equal(root.get("bedType"), bedType));
        }
        if (view != null) {
            predicates.add(criteriaBuilder.equal(root.get("view"), view));
        }
        if (internetAccess != null) {
            predicates.add(criteriaBuilder.equal(root.get("internetAccess"), internetAccess));
        }
        if (television != null) {
            predicates.add(criteriaBuilder.equal(root.get("television"), television));
        }
        if (rating != null) {
            predicates.add(criteriaBuilder.equal(root.get("rating"), rating));
        }
        if (available != null) {
            predicates.add(criteriaBuilder.equal(root.get("available"), available));
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(criteriaQuery).getResultList().stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }
}
