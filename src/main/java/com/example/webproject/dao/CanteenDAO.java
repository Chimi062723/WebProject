package com.example.webproject.dao;

import com.example.webproject.model.Canteen;
import com.example.webproject.util.JDBCHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanteenDAO implements com.example.webproject.dao.Impl.CanteenDAOImpl {
    private static final String GET_ALL_CANTEENS_SQL = "SELECT * FROM Canteens";
    private static final String GET_CANTEEN_BY_ID_SQL = "SELECT * FROM Canteens WHERE CanteenID = ?";
    private static final String ADD_CANTEEN_SQL = "INSERT INTO Canteens (Name, Location, OpenTime, ManagerID) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CANTEEN_SQL = "UPDATE Canteens SET Name = ?, Location = ?, OpenTime = ?, ManagerID = ? WHERE CanteenID = ?";
    private static final String DELETE_CANTEEN_SQL = "DELETE FROM Canteens WHERE CanteenID = ?";

    @Override
    public List<Canteen> getAllCanteens() {
        List<Canteen> canteens = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CANTEENS_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Canteen canteen = new Canteen();
                canteen.setCanteenId(rs.getInt("CanteenID"));
                canteen.setName(rs.getString("Name"));
                canteen.setLocation(rs.getString("Location"));
                canteen.setOpenTime(rs.getString("OpenTime"));
                canteen.setManagerId(rs.getInt("ManagerID"));
                canteens.add(canteen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canteens;
    }

    @Override
    public Canteen getCanteenById(int canteenId) {
        Canteen canteen = null;
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CANTEEN_BY_ID_SQL)) {

            preparedStatement.setInt(1, canteenId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                canteen = new Canteen();
                canteen.setCanteenId(rs.getInt("CanteenID"));
                canteen.setName(rs.getString("Name"));
                canteen.setLocation(rs.getString("Location"));
                canteen.setOpenTime(rs.getString("OpenTime"));
                canteen.setManagerId(rs.getInt("ManagerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canteen;
    }

    @Override
    public void addCanteen(Canteen canteen) {
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CANTEEN_SQL)) {

            preparedStatement.setString(1, canteen.getName());
            preparedStatement.setString(2, canteen.getLocation());
            preparedStatement.setString(3, canteen.getOpenTime());
            preparedStatement.setInt(4, canteen.getManagerId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCanteen(Canteen canteen) {
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CANTEEN_SQL)) {

            preparedStatement.setString(1, canteen.getName());
            preparedStatement.setString(2, canteen.getLocation());
            preparedStatement.setString(3, canteen.getOpenTime());
            preparedStatement.setInt(4, canteen.getManagerId());
            preparedStatement.setInt(5, canteen.getCanteenId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCanteen(int canteenId) {
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CANTEEN_SQL)) {

            preparedStatement.setInt(1, canteenId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}