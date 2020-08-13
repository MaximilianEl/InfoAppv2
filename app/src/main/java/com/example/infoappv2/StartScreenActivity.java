package com.example.infoappv2;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;

public final class StartScreenActivity extends AppCompatActivity {

        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                this.setContentView(R.layout.activity_startscreen);
                this.openInfoActivity();
        }

        private void openInfoActivity() {
                Timer var1 = new Timer();
                var1.schedule(getApplicationContext(startActivity(Intent())), 3000);
        }
}