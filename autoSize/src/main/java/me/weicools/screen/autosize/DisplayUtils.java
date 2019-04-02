package me.weicools.screen.autosize;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * @author Weicools Create on 2019.04.02
 *
 * desc:
 */
public class DisplayUtils {
  private static float sNonCompatDensity;
  private static float sNonCompatScaledDensity;

  /**
   * 修改设备密度 density
   */
  public static void setCustomDensity (@NonNull Activity activity, @NonNull final Application application) {
    final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
    if (sNonCompatDensity == 0) {
      sNonCompatDensity = appDisplayMetrics.density;
      sNonCompatScaledDensity = appDisplayMetrics.scaledDensity;
      // 防止系统切换后不起作用，例如在系统设置中切换字体
      application.registerComponentCallbacks(new ComponentCallbacks() {
        @Override
        public void onConfigurationChanged (Configuration newConfig) {
          if (newConfig != null && newConfig.fontScale > 0) {
            sNonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
          }
        }

        @Override
        public void onLowMemory () { }
      });
    }

    final float targetDensity = appDisplayMetrics.widthPixels / 360.0f;
    // 防止字体变小
    final float targetScaleDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
    final int targetDensityDpi = (int) (160 * targetDensity);

    appDisplayMetrics.density = targetDensity;
    appDisplayMetrics.scaledDensity = targetScaleDensity;
    appDisplayMetrics.densityDpi = targetDensityDpi;

    final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
    activityDisplayMetrics.density = targetDensity;
    activityDisplayMetrics.scaledDensity = targetScaleDensity;
    activityDisplayMetrics.densityDpi = targetDensityDpi;
  }
}
