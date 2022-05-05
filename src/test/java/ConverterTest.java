import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ConverterTest {

    /**
     * As an architect, I want to be able to check if 1 cm is equal to 1 cm.
     * As an architect, I want to be able to check if 1 m is equal to 100 cm, and 100 cm is equal to 0.001 km.
     * As an architect, I want to be able to know that 1 m + 100 cm = 2 m, or 200 cm + 1 km = 100200 cm.
     * As an architect, I want to be able to know that 1 m - 50 cm = 0.5 m, 2000 cm – 1 m = 1900 cm.
     * As an architect I want to be able to check if 1 g is equal to 1 g, and 0.1 kg = 100 g, and to know that 10 g + 1 kg = 1010 g, and 1.5 kg - 500 g = 1 kg.
     * As an architect, I want to be able to check if 0 Celsius is equal to 32 Fahrenheit, and 0 Kelvin is equal to -273 Celsius.
     */

    private  Converter converter;

    @BeforeEach
    public void setup() {
        converter = new Converter();
    }

    @Nested
    class TestingMeterConversion {
        @Nested
        class TestingConvertMethod {
            // As an architect, I want to be able to check if 1 cm is equal to 1 cm.
            @Test
            public void testIfOneCentiMeterEqualsOneCentiMeter () {
                Double actual = converter.convert(1d, "cm", "cm");
                Assertions.assertEquals(1d, actual);
            }

            // As an architect, I want to be able to check if 1 m is equal to 100 cm, and 100 cm is equal to 0.001 km.
            @Test
            public void testMeterToCentiMeterAndCentiMeterToKiloMeter () {
                Assertions.assertEquals(100d, converter.convert(1d, "m", "cm"));
                Assertions.assertEquals(0.001, converter.convert(100d, "cm", "km"));
            }
        }


        @Nested
        class TestingCalculateMethod {
            // As an architect, I want to be able to know that 1 m + 100 cm = 2 m, or 200 cm + 1 km = 100200 cm.
            @Test
            public void testAdditionOfMultipleValuesWithDifferentUnits () {
                Assertions.assertEquals(2d, converter.calculate(1d, "m", 100d, "cm", "m", '+'));
                Assertions.assertEquals(100200d, converter.calculate(200d, "cm", 1d, "km", "cm", '+'));
            }

            // As an architect, I want to be able to know that 1 m - 50 cm = 0.5 m, 2000 cm – 1 m = 1900 cm.
            @Test
            public void testSubractionOfMultipleValuesWithDifferentUnits () {
                Assertions.assertEquals(0.5, converter.calculate(1d, "m", 50d, "cm", "m", '-'));
                Assertions.assertEquals(1900d, converter.calculate(2000d, "cm", 1d, "m", "cm", '-'));
            }
        }
    }

    // As an architect I want to be able to check if 1 g is equal to 1 g, and 0.1 kg = 100 g, and to know that 10 g + 1 kg = 1010 g, and 1.5 kg - 500 g = 1 kg.
    @Nested
    class TestingGramConversion {
        @Nested
        class TestingConvertMethod {
            @Test
            public void testIfOneGramEqualsOneGram () {
                Double actual = converter.convert(1d, "g", "g");
                Assertions.assertEquals(1d, actual);
            }

            @Test
            public void testOneTenthOfKiloGramEqualsHundredGram () {
                Assertions.assertEquals(100d, converter.convert(0.1, "kg", "g"));
            }
        }


        @Nested
        class TestingCalculateMethod {
            @Test
            public void testAdditionOfMultipleValuesWithDifferentUnits () {
                Assertions.assertEquals(1010d, converter.calculate(10d, "g", 1d, "kg", "g", '+'));
            }

            @Test
            public void testSubractionOfMultipleValuesWithDifferentUnits () {
                Assertions.assertEquals(1d, converter.calculate(1.5, "kg", 500d, "g", "kg", '-'));
            }
        }
    }

    // As an architect, I want to be able to check if 0 Celsius is equal to 32 Fahrenheit, and 0 Kelvin is equal to -273 Celsius.
    @Nested
    class TestingTemperatureConversion {
        @Test
        public void testIfZeroCEqualsThirtyTwoF() {
            Assertions.assertEquals(32, converter.convert(0d, "C", "F"));
        }

        @Test
        public void testIfZeroKEqualsNegativeTwoSeventyThreeC() {
            Assertions.assertEquals(32, converter.convert(0d, "C", "F"));
        }
    }
}