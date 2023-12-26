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
    public List<Canteen> getAllCanteens() throws SQLException {
        List<Canteen> canteens = new ArrayList<>();
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CANTEENS_SQL)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Canteen canteen = new Canteen();
                canteen.setCanteenID(rs.getInt("CanteenID"));
                canteen.setName(rs.getString("Name"));
                canteen.setLocation(rs.getString("Location"));
                canteen.setOpenTime(rs.getString("OpenTime"));
                canteen.setManagerID(rs.getInt("ManagerID"));
                canteen.setNotice(rs.getString("Notice"));
                canteens.add(canteen);
            }
        }
        return canteens;
    }

    @Override
    public Canteen getCanteenByID(int canteenID) throws SQLException{
        Canteen canteen = null;
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CANTEEN_BY_ID_SQL)) {

            preparedStatement.setInt(1, canteenID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                canteen = new Canteen();
                canteen.setCanteenID(rs.getInt("CanteenID"));
                canteen.setName(rs.getString("Name"));
                canteen.setLocation(rs.getString("Location"));
                canteen.setOpenTime(rs.getString("OpenTime"));
                canteen.setManagerID(rs.getInt("ManagerID"));
                canteen.setNotice(rs.getString("Notice"));
            }
        }
        return canteen;
    }

    @Override
    public void addCanteen(Canteen canteen) throws SQLException{
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_CANTEEN_SQL)) {

            preparedStatement.setString(1, canteen.getName());
            preparedStatement.setString(2, canteen.getLocation());
            preparedStatement.setString(3, canteen.getOpenTime());
            preparedStatement.setInt(4, canteen.getManagerID());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateCanteen(Canteen canteen) throws SQLException{
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CANTEEN_SQL)) {

            preparedStatement.setString(1, canteen.getName());
            preparedStatement.setString(2, canteen.getLocation());
            preparedStatement.setString(3, canteen.getOpenTime());
            preparedStatement.setInt(4, canteen.getManagerID());
            preparedStatement.setInt(5, canteen.getCanteenID());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteCanteen(int canteenID) throws SQLException{
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CANTEEN_SQL)) {

            preparedStatement.setInt(1, canteenID);
            preparedStatement.executeUpdate();
        }
    }

//    @Override
    public Canteen getCanteenByManagerID(int ManagerID) throws SQLException{
        Canteen canteen = null;
        try (Connection connection = JDBCHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Canteens WHERE ManagerID = ?")) {
            preparedStatement.setInt(1, ManagerID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                canteen = new Canteen();
                canteen.setCanteenID(rs.getInt("CanteenID"));
                canteen.setName(rs.getString("Name"));
                canteen.setLocation(rs.getString("Location"));
                canteen.setOpenTime(rs.getString("OpenTime"));
                canteen.setManagerID(rs.getInt("ManagerID"));
                canteen.setNotice(rs.getString("Notice"));
            }
        }
        return canteen;
    }
}