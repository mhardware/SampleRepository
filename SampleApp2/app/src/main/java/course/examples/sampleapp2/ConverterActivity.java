package course.examples.sampleapp2;

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
        
        TextView tvInputValue = (TextView) findViewById(R.id.tbxInputValue);
        double dblInputValue = Double.parseDouble(tvInputValue.getText().toString());
        double dblConvertedValue;
        Spinner spnConvert = (Spinner) findViewById(R.id.spnConvertTo);
        TextView tvConvertedValue = (TextView) findViewById(R.id.txtConvertedValue);
        switch (String.valueOf(spnConvert.getSelectedItem())) {
            case "MilesToKm" :
                dblConvertedValue = dblInputValue * 1.60934;
                tvConvertedValue.setText(String.valueOf(dblConvertedValue));
                break;
            default :
                tvConvertedValue.setText("Not implemented");
        }
    }

}
