package com.example.webproject.dao.Impl;

import com.example.webproject.model.Canteen;
import java.util.List;

public interface CanteenDAOImpl {
    List<Canteen> getAllCanteens();
    Canteen getCanteenById(int canteenId);
    void addCanteen(Canteen canteen);
    void updateCanteen(Canteen canteen);
    void deleteCanteen(int canteenId);
}