package me.weicools.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NonAdaptActivity extends AppCompatActivity {

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_non_adapt);
  }
}
