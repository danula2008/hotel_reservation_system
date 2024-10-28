package edu.icet.pms.service.impl;

import edu.icet.pms.dao.RoomDao;
import edu.icet.pms.dto.Room;
import edu.icet.pms.entity.RoomEntity;
import edu.icet.pms.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomDao repository;
    private final ModelMapper mapper;

    @Override
    public String addRoom(Room room) {
        return repository.save(mapper.map(room, RoomEntity.class)).getId();
    }

    @Override
    public void deleteRoom(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return repository.findAll().stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public Room getRoomById(String id) {
        return mapper.map(repository.getReferenceById(id), Room.class);
    }

    @Override
    public List<Room> getRoomsByType(String type) {
        return repository.findByType(type).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public List<Room> getRoomsByCapacity(Integer capacity) {
        return repository.findByCapacity(capacity).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public List<Room> getRoomsByBedType(String bedType) {
        return repository.findByBedType(bedType).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public List<Room> getRoomsByView(String view) {
        return repository.findByView(view).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public List<Room> getRoomsByInternetAccess(Boolean internetAccess) {
        return repository.findByInternetAccess(internetAccess).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public List<Room> getRoomsByTelevision(Boolean television) {
        return repository.findByTelevision(television).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }

    @Override
    public List<Room> getRoomsByStatus(String status) {
        return repository.findByStatus(status).stream().map(roomEntity -> mapper.map(roomEntity, Room.class)).toList();
    }
}
