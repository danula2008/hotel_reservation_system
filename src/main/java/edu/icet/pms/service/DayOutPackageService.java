package edu.icet.pms.service;

import edu.icet.pms.dto.DayOutPackage;
import java.util.List;

public interface DayOutPackageService {
    String addDop(DayOutPackage dop);
    void deleteDop(String id);
    List<DayOutPackage> getAllDop();
    DayOutPackage getDopById(String id);
    List<DayOutPackage> getDopByDuration(String duration);
    List<DayOutPackage> getDopByTimeOfDay(String timeOfDay);
    List<DayOutPackage> getDopByStatus(String status);
}
