package xinyi.com.myapplication

import android.content.Context
import android.support.v4.view.ViewCompat
import android.support.v4.widget.ViewDragHelper
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout


/**
 * Created by jiajun.wang on 2018/3/29.
 */

class MyLayout : FrameLayout {
    private lateinit var viewDragHelper: ViewDragHelper

    private var w: Int = 0
    private var h: Int = 0
    private lateinit var mContext: AppCompatActivity

    constructor(context: Context) : super(context) {
        this.mContext = context as AppCompatActivity
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.mContext = context as AppCompatActivity
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.mContext = context as AppCompatActivity
        init()
    }


    fun init() {
        viewDragHelper = ViewDragHelper.create(this, 0.5f, DragCallBack())
        val resources = this.resources
        val dm = resources.displayMetrics
        val density = dm.density
        w = dm.widthPixels
        h = dm.heightPixels

    }

    inner class DragCallBack : ViewDragHelper.Callback() {
        override fun tryCaptureView(child: View?, pointerId: Int): Boolean {
            if (pointerId != 0) return false else return true

        }

        override fun clampViewPositionVertical(child: View?, top: Int, dy: Int): Int {
            return 0
        }

        override fun clampViewPositionHorizontal(child: View?, left: Int, dx: Int): Int {
            if (left >= 0) {
                return left
            }
            else{
                return 0
            }
        }

        override fun onViewReleased(releasedChild: View?, xvel: Float, yvel: Float) {
            viewDragHelper.continueSettling(true)
            if (releasedChild!!.left < w / 2) {
                //关闭菜单
                //相当于Scroller的startScroll方法
                viewDragHelper.smoothSlideViewTo(releasedChild, 0, 0);
                ViewCompat.postInvalidateOnAnimation(this@MyLayout);
                postInvalidate();
            } else {
                //打开菜单
                viewDragHelper.smoothSlideViewTo(releasedChild, w, 0);
                ViewCompat.postInvalidateOnAnimation(this@MyLayout);
                //invalidate();
                this@MyLayout.mContext.finish()
            }
        }

    }

    override fun onInterceptHoverEvent(event: MotionEvent?): Boolean {
        return viewDragHelper.shouldInterceptTouchEvent(event);
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        viewDragHelper.processTouchEvent(event);
        return true
    }


    override fun computeScroll() {
        if(viewDragHelper.continueSettling(true))
        {
            Log.d("4577155","left:  "+this.getChildAt(0).left+"  right:"+this.getChildAt(0).top)
           invalidate();
        }
    }
}
