package edu.icet.pms.service.impl;

import edu.icet.pms.controller.ReservationController;
import edu.icet.pms.dao.*;
import edu.icet.pms.entity.ReservationDateEntity;
import edu.icet.pms.model.ReservationDate;
import edu.icet.pms.model.Stat;
import edu.icet.pms.service.StatService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {

    private final ModelMapper mapper;
    private final CustomerDao customerDao;
    private final RoomDao roomDao;
    private final HallDao hallDao;
    private final ReservationController reservationController;
    private final DayOutPackageDao dopDao;
    private final ReservationDateDao reservationDateDao;

    @Override
    public Stat getStats() {
        List<ReservationDateEntity> todayReservationsEntities = reservationDateDao.findByDate(LocalDate.now());
        List<ReservationDate> todayReservations = todayReservationsEntities.stream()
                .map(reservationDateEntity -> mapper.map(reservationDateEntity, ReservationDate.class))
                .toList();

        List<ReservationDateEntity> rangeReservations = reservationDateDao.findByDateBetween(
                LocalDate.now().minusDays(15),
                LocalDate.now().plusDays(15)
        );

        List<Integer> roomReservationsCount = new ArrayList<>(Collections.nCopies(31, 0));
        List<Integer> hallReservationsCount = new ArrayList<>(Collections.nCopies(31, 0));
        List<Integer> dopReservationsCount = new ArrayList<>(Collections.nCopies(31, 0));

        for (ReservationDateEntity reservation : rangeReservations) {
            int dayIndex = reservation.getDate().getDayOfMonth() - 1;

            if (reservation.getReservationId().startsWith("R")) {
                roomReservationsCount.set(dayIndex, roomReservationsCount.get(dayIndex) + 1);
            } else if (reservation.getReservationId().startsWith("H")) {
                hallReservationsCount.set(dayIndex, hallReservationsCount.get(dayIndex) + 1);
            } else if (reservation.getReservationId().startsWith("DOP")) {
                dopReservationsCount.set(dayIndex, dopReservationsCount.get(dayIndex) + 1);
            }
        }

        return new Stat(
                LocalDateTime.now(),
                List.of(roomDao.count(), hallDao.count(), dopDao.count()),
                todayReservations,
                todayReservations.stream()
                        .map(reservation -> reservationController.getReservationById(reservation.getReservationId()))
                        .toList(),
                roomReservationsCount,
                hallReservationsCount,
                dopReservationsCount,
                customerDao.count()
        );
    }
}
