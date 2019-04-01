## 屏幕适配

### Android屏幕介绍
主流机型设备信息: https://material.io/tools/devices/

[Google Play 安装统计数据](https://developer.android.com/about/dashboards/): 平台版本统计、屏幕尺寸和密度统计

友盟硬件趋势-分辨率 https://compass.umeng.com/trend#appList
![](https://blog-1251678165.cos.ap-chengdu.myqcloud.com/2019-04-01-110544.jpg)

adb获取屏幕信息

```bash
❯ adb shell wm size
Physical size: 1440x2880

❯ adb shell wm density
Physical density: 480

# 如果使用命令修改过，那输出可能是：
Physical density: 480
Override density: 360
```

### smallestWidth适配方式

### 今日头条适配方式