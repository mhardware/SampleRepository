package course.examples.sampleapp2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
    }

    public void convertValue(View v) {

        double dblInputValue = 0;
        double dblConvertedValue = 0;

        TextView tvInputValue = (TextView) findViewById(R.id.tbxInputValue);
        TextView tvConvertedValue = (TextView) findViewById(R.id.txtConvertedValue);
        Spinner spnConvert = (Spinner) findViewById(R.id.spnConvertTo);
        
        try {
            dblInputValue = Double.parseDouble(tvInputValue.getText().toString());
        } catch (Exception e) {
            tvConvertedValue.setText(R.string.error_input_value_invalid);
            return ;
        }
        
        switch (spnConvert.getSelectedItemPosition()) {
            case  ConversionUtility.MILES_TO_KM_POSITION :
                dblConvertedValue = ConversionUtility.convertMilesToKm(dblInputValue);
                break;
            case ConversionUtility.KM_TO_MILES_POSITION :
                dblConvertedValue = ConversionUtility.convertKmToMiles(dblInputValue);
                break;
            case ConversionUtility.CENTIGRATE_TO_FAHRENHEIT_POSITION :
                dblConvertedValue = ConversionUtility.convertCentigradeToFahrenheit(dblInputValue);
                break;
            case ConversionUtility.FAHRENHEIT_TO_CENTRIGRATE_POSITION :
                dblConvertedValue = ConversionUtility.convertFahrenheitToCentigrade(dblInputValue);
                break;
            case ConversionUtility.INCHES_TO_CM_POSITION :
                dblConvertedValue = ConversionUtility.convertInchesToCm(dblInputValue);
                break;
            case ConversionUtility.CM_TO_INCHES_POSITION :
                dblConvertedValue = ConversionUtility.convertCmToInches(dblInputValue);
                break;
            case ConversionUtility.PINT_TO_LITRE_POSITION :
                dblConvertedValue = ConversionUtility.convertPintToLitre(dblInputValue);
                break;
            case ConversionUtility.LITRE_TO_PINT_POSITION :
                dblConvertedValue = ConversionUtility.convertLitreToPint(dblInputValue);
                break;
            default :
                // throw error
        }
        
        tvConvertedValue.setText(String.valueOf(dblConvertedValue));
    }

}
