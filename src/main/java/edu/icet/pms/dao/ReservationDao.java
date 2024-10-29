package edu.icet.pms.dao;

import edu.icet.pms.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDao extends JpaRepository<ReservationEntity, String> {
    List<ReservationEntity> getReferenceByCustomerId(String customerId);
    List<ReservationEntity> getReferenceByStatus(String status);
    List<ReservationEntity> getReferenceByPaymentMethod(String paymentMethod);
}
