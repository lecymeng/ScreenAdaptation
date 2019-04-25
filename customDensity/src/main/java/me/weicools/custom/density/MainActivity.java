package me.weicools.custom.density;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.e("CustomDensity", "MainActivity onCreate: ");
    DisplayUtils.setDensityBaseOnWidth(this, getApplication());
    setContentView(R.layout.activity_main);
  }
}
