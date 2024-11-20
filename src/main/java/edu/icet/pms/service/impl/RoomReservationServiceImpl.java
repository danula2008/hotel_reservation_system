package edu.icet.pms.service.impl;

import edu.icet.pms.dao.RoomReservationDao;
import edu.icet.pms.model.RoomReservation;
import edu.icet.pms.entity.RoomReservationEntity;
import edu.icet.pms.service.RoomReservationService;
import edu.icet.pms.util.composite_keys.RoomReservationPK;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoomReservationServiceImpl implements RoomReservationService {

    private final RoomReservationDao repository;
    private final ModelMapper mapper;

    @Override
    public void addRoomReservation(RoomReservation roomReservation) {
        repository.save(mapper.map(roomReservation, RoomReservationEntity.class));
    }

    @Override
    public void deleteRoomReservation(RoomReservationPK id) {
        repository.deleteById(id);
    }

    @Override
    public List<RoomReservation> getAllRoomReservations() {
        return repository.findAll().stream().map(roomReservationEntity -> mapper.map(roomReservationEntity, RoomReservation.class)).toList();
    }

    @Override
    public RoomReservation getRoomReservationByReservationId(String id) {
        return mapper.map(repository.findByReservationId(id), RoomReservation.class);
    }

    @Override
    public List<RoomReservation> getRoomReservationByRoomId(String roomId) {
        return repository.findByRoomId(roomId).stream().map(roomReservationEntity -> mapper.map(roomReservationEntity, RoomReservation.class)).toList();
    }
}
