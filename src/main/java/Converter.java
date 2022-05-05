public class Converter {

    private GeneralConverter generalConverter;
    private TemperatureConverter temperatureConverter;

    Converter() {
        generalConverter = new GeneralConverter();
        temperatureConverter = new TemperatureConverter();
    }

    public Double convert (Double value, String fromUnit, String toUnit) {
        if( toUnit == "F" || toUnit == "C" || toUnit == "K" ) return temperatureConverter.convert(value, fromUnit.charAt(0), toUnit.charAt(0));
        return generalConverter.convert(value, fromUnit.charAt(0), toUnit.charAt(0));
    }

    public Double calculate (Double value1, String unit1, Double value2, String unit2, String toUnit, Character operation) {
        return generalConverter.calculate(value1, unit1.charAt(0), value2, unit2.charAt(0), toUnit.charAt(0), operation);
    }

}
