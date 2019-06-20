### 不同设备引用dimens值的时候的查找过程

xxxhdpi设备: xxxhdpi --> xxhdpi --> xhdpi --> hdpi --> mdpi --> default
xxhdpi设备: xxhdpi --> xxxhdpi --> xhdpi --> hdpi --> mdpi --> default
xhdpi设备: xhdpi --> xxhdpi --> xxxhdpi --> hdpi --> mdpi --> default
hdpi设备: hdpi --> xhdpi --> xxhdpi --> xxxhdpi --> mdpi --> default
mdpi设备: mdpi --> default --> hdpi --> xhdpi --> xxhdpi --> xxxhdpi