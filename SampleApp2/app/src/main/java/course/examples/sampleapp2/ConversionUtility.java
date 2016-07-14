package course.examples.sampleapp2;

/**
 * Created by hards on 12/07/2016.
 */
public class ConversionUtility {
    
    static final int MILES_TO_KM_POSITION = 0;
    static final int KM_TO_MILES_POSITION = 1;
    static final int CENTIGRATE_TO_FAHRENHEIT_POSITION = 2;
    static final int FAHRENHEIT_TO_CENTRIGRATE_POSITION = 3;
    static final int INCHES_TO_CM_POSITION = 4;
    static final int CM_TO_INCHES_POSITION = 5;
    static final int PINT_TO_LITRE_POSITION = 6;
    static final int LITRE_TO_PINT_POSITION = 7;

    static final double MILES_TO_KM_RATIO = 1.60934;
    static final double INCHES_TO_CM_RATIO = 2.54;
    static final double PINT_TO_LITRE_RATIO = 0.568261;
    
    static double convertMilesToKm (double dblMiles) {
        return (dblMiles * MILES_TO_KM_RATIO);
    }
    
    static double convertKmToMiles (double dblKm) {
        return (dblKm / MILES_TO_KM_RATIO);
    }
    
    static double convertCentigradeToFahrenheit (double dblCentigrade) {
        return (((dblCentigrade * 9) / 5) + 32);
    }
    
    static double convertFahrenheitToCentigrade (double dblFahrenheit) {
        return (((dblFahrenheit - 32) * 5) / 9);
    }

    static double convertInchesToCm (double dblInches) {
        return (dblInches * INCHES_TO_CM_RATIO);
    }

    static double convertCmToInches (double dblCm) {
        return (dblCm / INCHES_TO_CM_RATIO);
    }
    
    static double convertPintToLitre (double dblPint) {
        return (dblPint * PINT_TO_LITRE_RATIO);
    }
    
    static double convertLitreToPint (double dblLitre) {
        return (dblLitre / PINT_TO_LITRE_RATIO);
    }


}
