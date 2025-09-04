package se.lexicon.dao;

import se.lexicon.db.MySQLDatabaseConnection;
import se.lexicon.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents the implementation of CityDao for interacting with the 'city' table in the database.
 */
public class CityDaoImpl implements CityDao {



    @Override
    public Optional<City> findById(int id) {
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE ID = ?";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );
                    return Optional.of(city);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL error in findById(" + id + "): " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }

        return Optional.empty();
    }




    @Override
    public List<City> findByCode(String code) {

        List<City> cityList = new ArrayList<>();
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE CountryCode = ?";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, code);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );

                    cityList.add(city);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL error in findByCode(" +code + "): " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }


        return cityList;
    }

    @Override
    public List<City> findByName(String name) {
        return List.of();
    }

    @Override
    public List<City> findAll() {
        return List.of();
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void deleteById(int id) {

    }

}
