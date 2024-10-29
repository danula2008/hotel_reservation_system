package edu.icet.pms.dao;

import edu.icet.pms.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationDao extends JpaRepository<ReservationEntity, String> {
    List<ReservationEntity> findByCustomerId(String customerId);
    List<ReservationEntity> findByStatus(String status);
    List<ReservationEntity> findByPaymentMethod(String paymentMethod);
}
