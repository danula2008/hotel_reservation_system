package edu.icet.pms.service.impl;

import edu.icet.pms.dao.RoomReservationDao;
import edu.icet.pms.dto.RoomReservation;
import edu.icet.pms.entity.RoomReservationEntity;
import edu.icet.pms.service.RoomReservationService;
import edu.icet.pms.util.composite_keys.RoomReservationPK;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<RoomReservation> getRoomReservationByReservationId(String id) {
        return repository.findByReservationId(id).stream().map(roomReservationEntity -> mapper.map(roomReservationEntity, RoomReservation.class)).toList();
    }

    @Override
    public List<RoomReservation> getRoomReservationByRoomId(String roomId) {
        return repository.findByRoomId(roomId).stream().map(roomReservationEntity -> mapper.map(roomReservationEntity, RoomReservation.class)).toList();
    }

    @Override
    public List<RoomReservation> getRoomReservationByArrivalDate(LocalDate date) {
        return repository.findByArrivalDate(date).stream().map(roomReservationEntity -> mapper.map(roomReservationEntity, RoomReservation.class)).toList();
    }

    @Override
    public List<RoomReservation> getRoomReservationByDepartureDate(LocalDate date) {
        return repository.findByDepartureDate(date).stream().map(roomReservationEntity -> mapper.map(roomReservationEntity, RoomReservation.class)).toList();
    }
}
