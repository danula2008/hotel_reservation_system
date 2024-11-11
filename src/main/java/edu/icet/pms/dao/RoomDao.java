package edu.icet.pms.dao;

import edu.icet.pms.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity, String> {
}