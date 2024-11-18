package edu.icet.pms.service.impl;

import edu.icet.pms.dao.ReservationDateDao;
import edu.icet.pms.dto.ReservationDate;
import edu.icet.pms.dto.ReservationDateForPost;
import edu.icet.pms.entity.ReservationDateEntity;
import edu.icet.pms.service.ReservationDateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationDateServiceImpl implements ReservationDateService {

    private final ReservationDateDao repository;
    private final ModelMapper mapper;

    @Override
    public void addReservationDate(ReservationDateForPost reservationDateForPost) {
        repository.saveAll(Arrays.stream(reservationDateForPost.getDates())
                .map(date -> new ReservationDateEntity(
                        reservationDateForPost.getResourceId(),
                        date,
                        reservationDateForPost.getReservationId()
                )).toList()
        );
    }

    @Override
    @Transactional
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

    @Override
    public Boolean checkAvailability(String resourceId, LocalDate[] dates) {
        // Fetch all reserved dates for the given resource and store in a HashSet for fast lookup
        Set<LocalDate> reservedDates = repository.findByResourceId(resourceId)
                .stream()
                .map(ReservationDateEntity::getDate)
                .collect(Collectors.toSet());

        // Check if any of the input dates conflict with reserved dates
        return Arrays.stream(dates)
                .noneMatch(reservedDates::contains);
    }

}
