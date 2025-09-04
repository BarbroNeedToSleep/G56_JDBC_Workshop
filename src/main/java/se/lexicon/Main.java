package se.lexicon;

import se.lexicon.dao.CityDao;
import se.lexicon.dao.CityDaoImpl;
import se.lexicon.model.City;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        CityDaoImpl cityIdNum = new CityDaoImpl();

        int testId = 9;

            Optional<City> cityOptional = cityIdNum.findById(testId);

            if (cityOptional.isPresent()) {
                System.out.println("✅ The city was found:");
                System.out.println(cityOptional.get());
            } else {
                System.out.println("❌ No city with ID " + testId + " was found.");

            }

//    CityDaoImpl cityCode = new CityDaoImpl();
//
//        String testCode = "SWE";
//
//        List<City> cityList01 = cityCode.findByCode(testCode);
//
//        if (!cityList01.isEmpty()) {
//            System.out.println("✅ Cities found for country code " + testCode + ":");
//            for (City city : cityList01) {
//                System.out.println(city);
//            }
//        } else {
//            System.out.println("❌ No cities found for country code " + testCode);
//        }

//        CityDaoImpl cityName = new CityDaoImpl();
//
//        String testName = "London";
//
//        List<City> cityList02 = cityName.findByName(testName);
//
//        if (!cityList02.isEmpty()) {
//            System.out.println("✅ Cities found for Name " + testName + ":");
//            for (City city : cityList02) {
//                System.out.println(city.getName() + " — " + city.getCountryCode() + " — " + city.getDistrict());
//            }
//        } else {
//            System.out.println("❌ No cities found with that name" + testName);
//        }

//        CityDaoImpl cityAll = new CityDaoImpl();
//        List<City> allCities = cityAll.findAll();
//
//        System.out.println("✅ All cities in the DB: " + allCities.size());
//
//        for (City city : allCities) {
//            System.out.println(city.getId()+ " — " + city.getName() + " — " + city.getCountryCode() + " — " + city.getDistrict());
//        }


//            CityDaoImpl nameCity = new CityDaoImpl();
//
//            City savedCity = nameCity.save(new City("Mora", "SWE", "Dalarnas län", 12830));
//
//            System.out.println("✅ Saved city:");
//            System.out.println(savedCity);


//        CityDaoImpl cityUpdate = new CityDaoImpl();
//
//        City newCity = new City("Mora", "SWE", "Dalarnas län", 12830);
//        City savedCityUpdate = cityUpdate.save(newCity);
//
//        System.out.println("✅ Before update:");
//        System.out.println(savedCityUpdate);
//
//        savedCityUpdate.setPopulation(13000);
//        savedCityUpdate.setDistrict("Mora District");
//
//        cityUpdate.update(savedCityUpdate);
//
//        System.out.println("✅ After update:");
//        System.out.println(savedCityUpdate);

//        CityDaoImpl cityDao = new CityDaoImpl();
//
//        int idToDelete = 4082;
//
//        cityDao.deleteById(idToDelete);
//
//        Optional<City> deletedCity = cityDao.findById(idToDelete);
//        if (deletedCity.isEmpty()) {
//            System.out.println("✅ City with ID " + idToDelete + " was successfully deleted.");
//        } else {
//            System.out.println("❌ City with ID " + idToDelete + " still exists!");
//        }

    }
}
