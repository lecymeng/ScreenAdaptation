package me.weicools.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FullscreenActivity extends AppCompatActivity {

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fullscreen);
    // 全屏显示
    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
  }
}
