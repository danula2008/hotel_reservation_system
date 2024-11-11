package edu.icet.pms.dao;

import edu.icet.pms.entity.DayOutPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DayOutPackageDao extends JpaRepository<DayOutPackageEntity, String> {
}
