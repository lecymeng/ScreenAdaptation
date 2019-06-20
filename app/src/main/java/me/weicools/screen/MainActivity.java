package me.weicools.screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.btn_non_adapt).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick (View v) {
        //startActivity(new Intent(MainActivity.this, NonAdaptActivity.class));
        startActivity(new Intent(MainActivity.this, ImmersiveActivity.class));
      }
    });
    findViewById(R.id.btn_small_width).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick (View v) {
        //startActivity(new Intent(MainActivity.this, SmallWidthActivity.class));
        startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
      }
    });
    findViewById(R.id.btn_width_height).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick (View v) {
        startActivity(new Intent(MainActivity.this, WidthHeightActivity.class));
      }
    });
  }
}
