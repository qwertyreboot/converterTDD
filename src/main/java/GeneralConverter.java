public class GeneralConverter {
    public Double convert (Double value, Character fromUnit, Character toUnit) {
        Double valueInMeasuringUnit = convertToMeasuringUnit(value, fromUnit);
        return convertFromMeasuringUnit(valueInMeasuringUnit, toUnit);
    }


    public Double convertToMeasuringUnit(Double value, Character fromUnit) {
        switch(fromUnit) {
            case 'c':
                return value / 100;
            case 'k':
                return value * 1000;
            default:
                return value;
        }
    }

    public Double convertFromMeasuringUnit(Double value, Character toUnit) {
        switch(toUnit) {
            case 'c':
                return value * 100;
            case 'k':
                return value / 1000;
            default:
                return value;
        }
    }

    public Double calculate (Double value1, Character unit1, Double value2, Character unit2, Character toUnit, Character operation) {
        Double value1InToUnit = this.convert(value1, unit1, toUnit);
        Double value2InToUnit = this.convert(value2, unit2, toUnit);

        switch (operation) {
            case '+':
                return value1InToUnit + value2InToUnit;
            case '-':
                return value1InToUnit - value2InToUnit;
            default:
                return 0d;
        }
    }
}
