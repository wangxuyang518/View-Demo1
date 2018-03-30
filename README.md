
这个小demo涉及到的知识点：
最开始以为只是移动DecorView，给DecorView做动画处理，于是看了下Activity的层次图：
![image.png](https://upload-images.jianshu.io/upload_images/2837456-d2b4b696afc63f42.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

这里我私下在熟悉熟悉Activity view加载过程，找几篇博客看看，巩固复习阶段，就需要由点到面的复习。


最后参考网上的例子：原来还有一个ViewDragHelp类，自定义一个Layout。根绝ViewDragHelp 提供的api 很容易 很方面的实现了滑动。。
### computeScroll() 方法
view 自带方法，用于计算滑动的。每滑动一下就会调用下这个方法，我们可以在这个方法中获取view的 left/top/ 等点位信息。进而可以额外做处理。

重要的一点是：  viewDragHelper.smoothSlideViewTo(releasedChild, w, 0); 并不能产生滑动，必须在computeScroll() 中在进一步的重新绘制，这样才能产生持续不间断的 动画

最终效果图：
![GIF.gif](https://upload-images.jianshu.io/upload_images/2837456-e731bada19eb5c0c.gif?imageMogr2/auto-orient/strip)
