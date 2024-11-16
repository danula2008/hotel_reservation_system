package edu.icet.pms.service.impl;

import edu.icet.pms.dao.ReservationDateDao;
import edu.icet.pms.dto.ReservationDate;
import edu.icet.pms.entity.ReservationDateEntity;
import edu.icet.pms.service.ReservationDateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationDateServiceImpl implements ReservationDateService {

    private final ReservationDateDao repository;
    private final ModelMapper mapper;

    @Override
    public void addReservationDate(ReservationDate reservationDate) {
        repository.save(mapper.map(reservationDate, ReservationDateEntity.class));
    }

    @Override
    public void deleteReservationDate(String reservationId) {
        repository.deleteByReservationId(reservationId);
    }

    @Override
    public ReservationDate getReservationDateByReservationId(String reservationId) {
        return mapper.map(repository.findByReservationId(reservationId), ReservationDate.class);
    }

    @Override
    public List<ReservationDate> getReservationDateResourceId(String resourceId) {
        return repository.findByResourceId(resourceId).stream().map(reservationDateEntity -> mapper.map(reservationDateEntity, ReservationDate.class)).toList();
    }

    @Override
    public List<ReservationDate> getAllReservationDates() {
        return repository.findAll().stream().map(reservationDateEntity -> mapper.map(reservationDateEntity, ReservationDate.class)).toList();
    }
}
