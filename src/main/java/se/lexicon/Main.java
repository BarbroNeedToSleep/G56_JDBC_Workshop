package se.lexicon;

import se.lexicon.dao.CityDao;
import se.lexicon.dao.CityDaoImpl;
import se.lexicon.model.City;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Represents the entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Needs completion

        CityDaoImpl cityIdNum = new CityDaoImpl();

        int testId = 9;

            Optional<City> cityOptional = cityIdNum.findById(testId);

            if (cityOptional.isPresent()) {
                System.out.println("✅ The city was found:");
                System.out.println(cityOptional.get());
            } else {
                System.out.println("❌ No city with ID " + testId + " was found.");

            }

    CityDaoImpl cityCode = new CityDaoImpl();

        String testCode = "SWE";

        List<City> cityList01 = cityCode.findByCode(testCode);

        if (!cityList01.isEmpty()) {
            System.out.println("✅ Cities found for country code " + testCode + ":");
            for (City city : cityList01) {
                System.out.println(city);
            }
        } else {
            System.out.println("❌ No cities found for country code " + testCode);
        }

    }
}
