package edu.icet.pms.service.impl;

import edu.icet.pms.dao.DopReservationDao;
import edu.icet.pms.dto.DopReservation;
import edu.icet.pms.entity.DopReservationEntity;
import edu.icet.pms.service.DopReservationService;
import edu.icet.pms.util.composite_keys.DopReservationPK;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DopReservationServiceImpl implements DopReservationService {

    private final DopReservationDao repository;
    private final ModelMapper mapper;

    @Override
    public void addDopReservation(DopReservation dopReservation) {
        repository.save(mapper.map(dopReservation, DopReservationEntity.class));
    }

    @Override
    public void deleteDopReservation(DopReservationPK dopReservationPK) {
        repository.deleteById(dopReservationPK);
    }

    @Override
    public List<DopReservation> getAllDopReservations() {
        return repository.findAll().stream().map(dopReservationEntity -> mapper.map(dopReservationEntity, DopReservation.class)).toList();
    }

    @Override
    public List<DopReservation> getDopReservationByReservationId(String id) {
        return repository.findByReservationId(id).stream().map(dopReservationEntity -> mapper.map(dopReservationEntity, DopReservation.class)).toList();
    }

    @Override
    public List<DopReservation> getDopReservationByDopId(String dopId) {
        return repository.findByDopId(dopId).stream().map(dopReservationEntity -> mapper.map(dopReservationEntity, DopReservation.class)).toList();
    }

    @Override
    public List<DopReservation> getDopReservationByStartingDate(LocalDate date) {
        return repository.findByDate(date).stream().map(dopReservationEntity -> mapper.map(dopReservationEntity, DopReservation.class)).toList();
    }
}
