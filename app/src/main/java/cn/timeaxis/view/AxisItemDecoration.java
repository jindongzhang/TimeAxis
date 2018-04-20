package cn.timeaxis.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by apple on 2018/4/18.
 * 实例化对象，传入RecyclerView
 */

public class AxisItemDecoration extends RecyclerView.ItemDecoration {

    private Context context;

    //存放图片资源id的集合
    private List<Integer> imgResIdList = null;

    //默认时间轴线条颜色
    private int axis_color = Color.RED;

    //默认时间轴线条宽度
    private int axis_stroke = 4;

    //画线的笔
    private Paint axisPaint = null;

    //画图的笔
    private Paint bitmapPaint = null;

    //左侧偏移长度
    private int leftInterval = 180;

    public AxisItemDecoration(Context context, List<Integer> imgResIdList) {
        this.context = context;
        this.imgResIdList = imgResIdList;
        init();
    }

    //初始化
    private void init() {
        bitmapPaint = new Paint();
        axisPaint = new Paint();
        axisPaint.setColor(axis_color);
        axisPaint.setStrokeWidth(axis_stroke);
    }

    //设置线条颜色
    public void setAxisColor(int color) {
        axisPaint.setColor(color);
    }

    //设置线条宽度
    public void setAxisStroke(int width) {
        axisPaint.setStrokeWidth(width);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //设置左侧偏移
        outRect.set(leftInterval, 0, 0, 0);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        //获取item数量
        int childCount = parent.getChildCount();

        for (int i=0; i<childCount; i++){
            View child = parent.getChildAt(i);
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imgResIdList.get(i));
            c.drawBitmap(bitmap, (leftInterval - bitmap.getWidth()) / 2, child.getTop(), bitmapPaint);
            //最后一条Item不绘制线条
            if (i == childCount - 1)
                return;

            //下半部分 线条起点 x,y
            float bottom_line_up_x = leftInterval / 2;
            float bottom_line_up_y = child.getTop() + bitmap.getHeight();

            //下半部分 线条终点 x,y
            float bottom_line_b_x = leftInterval / 2;
            float bottom_line_b_y = child.getBottom();

            //画出线条
            c.drawLine(bottom_line_up_x, bottom_line_up_y, bottom_line_b_x, bottom_line_b_y, axisPaint);

        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }


}
