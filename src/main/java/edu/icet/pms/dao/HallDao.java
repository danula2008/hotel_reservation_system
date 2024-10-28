package edu.icet.pms.dao;

import edu.icet.pms.entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HallDao extends JpaRepository<HallEntity, String> {
    List<HallEntity> findByCapacity(Integer capacity);
    List<HallEntity> findByInternetAccess(Boolean internetAccess);
    List<HallEntity> findByClimateControl(Boolean climateControl);
    List<HallEntity> findByDecoratorStyle(String decoratorStyle);
    List<HallEntity> findByType(String type);
    List<HallEntity> findByStatus(String status);
}
