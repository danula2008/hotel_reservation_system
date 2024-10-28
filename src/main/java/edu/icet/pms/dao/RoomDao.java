package edu.icet.pms.dao;

import edu.icet.pms.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomDao extends JpaRepository<RoomEntity, String> {
    List<RoomEntity> findByType(String type);
    List<RoomEntity> findByCapacity(Integer capacity);
    List<RoomEntity> findByBedType(String bedType);
    List<RoomEntity> findByView(String view);
    List<RoomEntity> findByInternetAccess(Boolean access);
    List<RoomEntity> findByTelevision(Boolean television);
    List<RoomEntity> findByStatus(String status);
}
