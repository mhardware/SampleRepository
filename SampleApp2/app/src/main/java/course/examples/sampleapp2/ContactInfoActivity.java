package course.examples.sampleapp2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContactInfoActivity extends AppCompatActivity {

    static final String FCI_API_KEY = "1c8901b80a486576";
    static final String FCI_API_URL = "https://api.fullcontact.com/v2/person.json?";

    EditText etxEmailAddress;
    TextView tvwContactInfo;
    ProgressBar pbContactInfo;
    String emailAddr;
    int responseCode = 0;

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

        emailAddr = etxEmailAddress.getText().toString();
        new CntInfoTask().execute();
    }

    class CntInfoTask extends AsyncTask<Void, Void, String> {


        private Exception exception;

        protected void onPreExecute() {
            pbContactInfo.setVisibility(View.VISIBLE);
            tvwContactInfo.setText("");
        }

        protected String doInBackground(Void... urls) {

            try {
                URL url = new URL(FCI_API_URL + "email=" + emailAddr + "&apiKey=" + FCI_API_KEY);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                responseCode = urlConnection.getResponseCode();
                try {
                    BufferedReader bufferedReader =
                            new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                if (responseCode != 0) {
                    return Integer.toString(responseCode);
                }
                else{
                    return null;
                }
            }
        }

        protected void onPostExecute(String response) {

            if (response == null) {
                response = "THERE WAS AN ERROR";
            }
            pbContactInfo.setVisibility(View.GONE);
            Log.i("INFO", response);
            tvwContactInfo.setText(response);

        }
    }
}
