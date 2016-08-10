package course.examples.sampleapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ContactInfoActivity extends AppCompatActivity {

    EditText etxEmailAddress;
    TextView tvwContactInfo;
    ProgressBar pbContactInfo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        
        tvwContactInfo = (TextView) findViewById(R.id.txtContactInfo);
        etxEmailAddress = (EditText) findViewById(R.id.tbxEmailAddress);
        pbContactInfo = (ProgressBar) findViewById(R.id.pbContactInfo);
    }
    
    public void getContactInfo(View v) {
        
//        TextView tvEmailAddress = (TextView) findViewById(R.id.tbxEmailAddress);
//        TextView tvContactInfo = (TextView) findViewById(R.id.txtContactInfo);
//        tvContactInfo.setText("GetContactInfo button has been clicked with " + tvEmailAddress.getText());


    }
}
