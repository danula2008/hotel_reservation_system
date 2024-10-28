package edu.icet.pms.service;

import edu.icet.pms.dto.Room;

import java.util.List;

public interface RoomService {
    String addRoom(Room room);
    void deleteRoom(String id);
    List<Room> getAllRooms();
    Room getRoomById(String id);
    List<Room> getRoomsByType(String type);
    List<Room> getRoomsByCapacity(Integer capacity);
    List<Room> getRoomsByBedType(String bedType);
    List<Room> getRoomsByView(String view);
    List<Room> getRoomsByInternetAccess(Boolean internetAccess);
    List<Room> getRoomsByTelevision(Boolean television);
    List<Room> getRoomsByStatus(String status);
}
