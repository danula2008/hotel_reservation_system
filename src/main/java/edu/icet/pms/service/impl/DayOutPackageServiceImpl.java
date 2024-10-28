package edu.icet.pms.service.impl;

import edu.icet.pms.dao.DayOutPackageDao;
import edu.icet.pms.dto.DayOutPackage;
import edu.icet.pms.entity.DayOutPackageEntity;
import edu.icet.pms.service.DayOutPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DayOutPackageServiceImpl implements DayOutPackageService {

    private final DayOutPackageDao repository;
    private final ModelMapper mapper;


    @Override
    public String addDop(DayOutPackage dop) {
        return repository.save(mapper.map(dop, DayOutPackageEntity.class)).getId();
    }

    @Override
    public void deleteDop(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<DayOutPackage> getAllDop() {
        return repository.findAll().stream().map(dayOutPackageEntity -> mapper.map(dayOutPackageEntity, DayOutPackage.class)).toList();
    }

    @Override
    public DayOutPackage getDopById(String id) {
        return mapper.map(repository.getReferenceById(id), DayOutPackage.class);
    }

    @Override
    public List<DayOutPackage> getDopByDuration(String duration) {
        return repository.findByDuration(duration).stream().map(dayOutPackageEntity -> mapper.map(dayOutPackageEntity, DayOutPackage.class)).toList();
    }

    @Override
    public List<DayOutPackage> getDopByTimeOfDay(String timeOfDay) {
        return repository.findByTimeOfDay(timeOfDay).stream().map(dayOutPackageEntity -> mapper.map(dayOutPackageEntity, DayOutPackage.class)).toList();
    }

    @Override
    public List<DayOutPackage> getDopByStatus(String status) {
        return repository.findByStatus(status).stream().map(dayOutPackageEntity -> mapper.map(dayOutPackageEntity, DayOutPackage.class)).toList();
    }
}
