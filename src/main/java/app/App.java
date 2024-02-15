package app;

import app.data.DataProvider;
import app.exceptions.TemperatureException;
import app.utils.AppValidator;

public class App {

    public static void main(String[] args) {
        getOutput(handleData());
    }

    private static String handleData() {
        DataProvider provider = new DataProvider();
        try {
            int temperature = provider.getTemperature();
            AppValidator validator = new AppValidator();
            return validator.validateTemperature(temperature);
        } catch (TemperatureException ex) {
            return ex.getMessage();
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
