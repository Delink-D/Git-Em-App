package com.example.delink.messageintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSendAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSendAlert = (Button) findViewById(R.id.sendAlert);

        mSendAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSendAlert) {
            sendIntentSMS();
        }
    }

    private void sendIntentSMS() {
        String seperator = ";";
        if(android.os.Build.MANUFACTURER.equalsIgnoreCase("samsung")){
            seperator = ", ";
        }
        try {

            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.putExtra("address", "0718425075"+seperator+"0711809296"+seperator+"0728048896");
            sendIntent.putExtra("sms_body", "Hey am in danger! please help");
            sendIntent.setType("vnd.android-dir/mms-sms");
            startActivity(sendIntent);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
