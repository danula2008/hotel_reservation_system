package edu.icet.pms.service;

import edu.icet.pms.dto.Hall;

import java.util.List;

public interface HallService {
    String addHall(Hall hall);
    void deleteHall(String id);
    List<Hall> getAllHalls();
    Hall getHallById(String id);
    List<Hall> getHallsByCapacity(Integer capacity);
    List<Hall> getHallsByInternetAccess(Boolean internetAccess);
    List<Hall> getHallsByClimateControl(Boolean climateControl);
    List<Hall> getHallsByDecoratorStyle(String decoratorStyle);
    List<Hall> getHallsByType(String type);
    List<Hall> getHallsByStatus(String status);
}