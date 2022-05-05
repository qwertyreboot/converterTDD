public class TemperatureConverter {
    public Double convert (Double value, Character from, Character to) {
        Double tempInC = convertToCelsius(value, from);
        return convertFromCelsius(tempInC, to);
    }

    public Double convertToCelsius(Double value, Character from) {
        switch (from) {
            case 'F':
                return fahrenheitToCelsius(value);
            case 'K':
                return kelvinToCelsius(value);
            default:
                return value;
        }
    }

    public Double convertFromCelsius(Double value, Character to) {
        switch (to) {
            case 'F':
                return celsiusToFahrenheit(value);
            case 'K':
                return celsiusToKelvin(value);
            default:
                return value;
        }
    }

    public Double celsiusToFahrenheit(Double tempInC) {
        return (tempInC * 9 / 5) + 32;
    }

    public Double fahrenheitToCelsius(Double tempInF) {
        return (tempInF - 32) * 5 / 9;
    }

    public Double celsiusToKelvin(Double tempInC) {
        return tempInC + 273;
    }

    public Double kelvinToCelsius(Double tempInK) {
        return tempInK - 273;
    }
}
