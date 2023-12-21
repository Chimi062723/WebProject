package com.example.webproject.dao.Impl;

import com.example.webproject.model.Canteen;

import java.sql.SQLException;
import java.util.List;

public interface CanteenDAOImpl {
    List<Canteen> getAllCanteens() throws SQLException;
    Canteen getCanteenById(int canteenId) throws SQLException;
    void addCanteen(Canteen canteen) throws SQLException;
    void updateCanteen(Canteen canteen) throws SQLException;
    void deleteCanteen(int canteenId) throws SQLException;
}