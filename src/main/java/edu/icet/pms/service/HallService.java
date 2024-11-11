package edu.icet.pms.service;

import edu.icet.pms.dto.Hall;

import java.util.List;

public interface HallService {
    String addHall(Hall hall);
    void deleteHall(String id);
    List<Hall> getAllHalls();
    Hall getHallById(String id);
    List<Hall> getHallsByFiltering(String type, Integer capacity, Boolean internetAccess, Boolean climateControl, Boolean decoratorStyle, Integer rating, Boolean available);
}