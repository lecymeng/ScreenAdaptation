package me.weicools.screen.autosize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onStart () {
    super.onStart();

    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(dm);
    float density = dm.density;
    float dpi = dm.densityDpi;
    Toast.makeText(this, String.format("density: %1$s, densityDpi: %2$s", density, dpi), Toast.LENGTH_SHORT).show();
  }
}
