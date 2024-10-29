package edu.icet.pms.service.impl;

import edu.icet.pms.dao.ReservationDao;
import edu.icet.pms.dto.Reservation;
import edu.icet.pms.entity.ReservationEntity;
import edu.icet.pms.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao repository;
    private final ModelMapper mapper;

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
    public List<Reservation> getReservationsByCustomerID(String customerId) {
        return repository.findByCustomerId(customerId).stream().map(reservationEntity -> mapper.map(reservationEntity, Reservation.class)).toList();
    }

    @Override
    public List<Reservation> getReservationsByStatus(String status) {
        return repository.findByStatus(status).stream().map(reservationEntity -> mapper.map(reservationEntity, Reservation.class)).toList();
    }

    @Override
    public List<Reservation> getReservationsByPaymentMethod(String paymentMethod) {
        return repository.findByPaymentMethod(paymentMethod).stream().map(reservationEntity -> mapper.map(reservationEntity, Reservation.class)).toList();
    }
}
