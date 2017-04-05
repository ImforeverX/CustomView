package com.example.lining.self;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 李宁 on 2017/3/16.
 */
public class MyAttributeView extends View {

    private  int mMyAge;
    private  String mMyName;
    private  Bitmap mMyBg;

    /**
     * 自定义属性
     *
     * @param context
     * @param attrs
     */
    public MyAttributeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取属性三种方式
        //1.用命名空间获取
        String my_name = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "my_name");
        String my_age = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "my_age");
        String my_bg = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "my_bg");

        //2.遍历属性集合

        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            System.out.print(attrs.getAttributeName(i) + "----------" + attrs.getAttributeValue(i));
        }

        //3.使用系统工具，获取属性

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyAttributeView);
        for (int i = 0; i < typedArray.getIndexCount(); i++) {

            int index = typedArray.getIndex(i);
            switch (index) {
                case R.styleable.MyAttributeView_my_age:
                    mMyAge = typedArray.getInt(index, 0);
                    break;
                case R.styleable.MyAttributeView_my_name:
                    mMyName = typedArray.getString(index);
                    break;
               /* case R.styleable.MyAttributeView_my_bg:
                    Drawable drawable = typedArray.getDrawable(index);
                    BitmapDrawable drawable1 = (BitmapDrawable) drawable;
                    Bitmap myBg = drawable1.getBitmap();
                    break;*/
                case R.styleable.MyAttributeView_my_bg:
                    Drawable drawable = typedArray.getDrawable(index);
                    BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
                    mMyBg = bitmapDrawable.getBitmap();
                    break;
            }
        }

        // 记得回收

        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        canvas.drawText(mMyName+"----"+mMyAge,50,50,paint);

        canvas.drawBitmap(mMyBg,50,50,paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                break;

        }
        return  true;
    }

    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:


                Intent intent=new Intent();
                getContext().startActivity(intent);
                System.out.println("aaaaaaaaaaaaaaa");
                break;

            case MotionEvent.ACTION_MOVE:
                System.out.println("bbbbbbbbbbbbbbbbb");
                break;

            case MotionEvent.ACTION_UP:
                System.out.println("cccccccccccccccccc");
                break;
        }

        return true;

    }
}
