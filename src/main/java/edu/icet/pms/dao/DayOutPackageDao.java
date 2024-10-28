package edu.icet.pms.dao;

import edu.icet.pms.entity.DayOutPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface DayOutPackageDao extends JpaRepository<DayOutPackageEntity, String> {
    List<DayOutPackageEntity> findByDuration(String duration);
    List<DayOutPackageEntity> findByTimeOfDay(String timeOfDay);
    List<DayOutPackageEntity> findByStatus(String status);
}
