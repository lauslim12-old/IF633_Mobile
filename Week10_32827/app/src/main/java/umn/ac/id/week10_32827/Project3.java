package umn.ac.id.week10_32827;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Project3 extends AppCompatActivity {
    private Button serviceBtn, timeBtn;
    CustomBoundService customBoundService;
    boolean isBound = false;

    private ServiceConnection serviceConnection =
            new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name,
                                               IBinder service) {
                    CustomBoundService.CustomLocalBinder binder =
                            (CustomBoundService.CustomLocalBinder) service;
                    customBoundService = binder.getService();
                    isBound = true;
                }
                @Override
                public void onServiceDisconnected(ComponentName name) {
                    isBound = false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project3);

        Intent servIntent = new Intent(this, SimpleIntentService.class);
        startService(servIntent);

        serviceBtn = findViewById(R.id.main_button_startservice);

        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Project3.this, CustomService.class);
                startService(intent);
            }
        });

        Intent intent2 = new Intent(this, CustomBoundService.class);
        bindService(intent2, serviceConnection, Context.BIND_AUTO_CREATE);

        timeBtn = findViewById(R.id.main_button_showtime);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentTime = customBoundService.getCurrentTime();
                Toast.makeText(getApplicationContext(), currentTime, Toast.LENGTH_LONG).show();
            }
        });
    }
}