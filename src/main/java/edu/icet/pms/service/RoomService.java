package edu.icet.pms.service;

import edu.icet.pms.model.Room;

import java.util.List;

public interface RoomService {
    String addRoom(Room room);
    void deleteRoom(String id);
    List<Room> getAllRooms();
    Room getRoomById(String id);
    List<Room> getRoomsByFiltering(String type, Integer capacity, String bedType, String view, Boolean internetAccess, Boolean television, Integer rating, Boolean available);
}
