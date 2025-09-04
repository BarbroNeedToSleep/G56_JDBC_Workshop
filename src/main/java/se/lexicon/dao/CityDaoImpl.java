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

        List<City> cityList01 = new ArrayList<>();
        String sql = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE Name = ?";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );

                    cityList01.add(city);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL error in findByName(" + name + "): " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }


        return cityList01;
    }

    @Override
    public List<City> findAll() {

        List<City> cityList03 = new ArrayList<>();
        String sql = "SELECT * FROM City";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );

                    cityList03.add(city);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL error in findAll: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }


        return cityList03;

    }

    @Override
    public City save(City city) {

        String sql = "INSERT INTO city (name, CountryCode, District, Population) VALUES (?, ?, ?, ?)";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                try (ResultSet key = preparedStatement.getGeneratedKeys()) {
                    if (key.next()) {
                        city.setId(key.getInt(1));
                    }
                }
            }

        }catch (SQLException e) {
            System.err.println("❌ SQL error in save: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }

        return city;
    }

    @Override
    public void update(City city) {

        String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getId());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ City with ID " + city.getId() + " updated successfully.");
            } else {
                System.out.println("❌ No city found with ID " + city.getId());
            }

        }catch (SQLException e) {
            System.err.println("❌ SQL error in update: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }

    }

    @Override
    public void deleteById(int id) {

        String sql = "DELETE FROM city WHERE ID = ?";

        try (Connection connection = MySQLDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ City with ID " + id + " deleted successfully.");
            } else {
                System.out.println("❌ No city found with ID " + id);
            }

        } catch (SQLException e) {
            System.err.println("❌ SQL error in deleteById: " + e.getMessage());
            System.err.println("SQL state: " + e.getSQLState());
            System.err.println("Error code: " + e.getErrorCode());
        }
    }

}
