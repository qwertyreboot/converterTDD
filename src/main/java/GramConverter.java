public class GramConverter {
    public Double convert (Double value, String fromUnit, String toUnit) {
        Double valueInGram = convertToGram(value, fromUnit);
        return convertFromGram(valueInGram, toUnit);
    }


    public Double convertToGram(Double value, String fromUnit) {
        switch(fromUnit) {
            case "cg":
                return value / 100;
            case "kg":
                return value * 1000;
            default:
                return value;
        }
    }

    public Double convertFromGram(Double value, String toUnit) {
        switch(toUnit) {
            case "cg":
                return value * 100;
            case "kg":
                return value / 1000;
            default:
                return value;
        }
    }

    public Double calculate (Double value1, String unit1, Double value2, String unit2, String toUnit, Character operation) {
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
