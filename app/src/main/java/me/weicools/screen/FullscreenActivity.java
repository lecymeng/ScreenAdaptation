package me.weicools.screen;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.List;

/**
 * @author zhengwei.zhang
 */
public class FullscreenActivity extends AppCompatActivity {

  @Override
  protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fullscreen);

    // 全屏显示
    getWindow().getDecorView()
        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      WindowManager.LayoutParams lp = getWindow().getAttributes();
      // 仅当缺口区域完全包含在状态栏之中时，才允许窗口延伸到刘海区域显示
      // lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT;
      // 永远不允许窗口延伸到刘海区域
      // lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER;
      // 始终允许窗口延伸到屏幕短边上的刘海区域
      lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
      getWindow().setAttributes(lp);
    }

    getNotchParams();
  }

  /**
   * 获得刘海区域信息
   */
  @TargetApi(28)
  public void getNotchParams () {
    final View decorView = getWindow().getDecorView();
    decorView.post(new Runnable() {
      @Override
      public void run () {
        WindowInsets windowInsets = decorView.getRootWindowInsets();
        if (windowInsets != null) {
          // 当全屏顶部显示黑边时，getDisplayCutout()返回为null
          DisplayCutout displayCutout = windowInsets.getDisplayCutout();
          if (displayCutout == null) {
            Log.e("ZZW", "看不见刘海");
            return;
          }
          Log.e("ZZW", "安全区域距离屏幕左边的距离 SafeInsetLeft:" + displayCutout.getSafeInsetLeft());
          Log.e("ZZW", "安全区域距离屏幕右部的距离 SafeInsetRight:" + displayCutout.getSafeInsetRight());
          Log.e("ZZW", "安全区域距离屏幕顶部的距离 SafeInsetTop:" + displayCutout.getSafeInsetTop());
          Log.e("ZZW", "安全区域距离屏幕底部的距离 SafeInsetBottom:" + displayCutout.getSafeInsetBottom());
          // 获得刘海区域
          List<Rect> rectList = displayCutout.getBoundingRects();
          if (rectList == null || rectList.size() == 0) {
            Log.e("ZZW", "不是刘海屏");
          } else {
            Log.e("ZZW", "刘海屏数量:" + rectList.size());
            for (Rect rect : rectList) {
              Log.e("ZZW", "刘海屏区域:" + rect);
            }
          }
        }
      }
    });
  }
}
