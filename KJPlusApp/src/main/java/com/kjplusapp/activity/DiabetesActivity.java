package com.kjplusapp.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.kjplusapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiabetesActivity extends Activity {

    @Bind(R.id.tv_title_content)
    TextView tvTitleContent;
    @Bind(R.id.tv_title_save)
    TextView tvTitleSave;
    @Bind(R.id.iv_photo)
    ImageView ivPhoto;
    @Bind(R.id.ll_information)
    LinearLayout llInformation;
    @Bind(R.id.tv_qiehuan)
    TextView tvQiehuan;
    @Bind(R.id.tv_xinjian)
    TextView tvXinjian;

    private PopupWindow mMenuPop;
    private ImageView mImageView;

    private int PopWidth;
    private int PopHeight;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes);
        ButterKnife.bind(this);
        mImageView = (ImageView) findViewById(R.id.iv_menu);

        //ImageView点击事件
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLevitateMenu();
            }
        });
    }
    /**
     * 显示悬浮菜单
     */
    private void showLevitateMenu(){

        //动画
        mRotate(mImageView);

        //创建popwindow
        getPopMenu();

        //获取ImageView控件在手机屏幕的位置
        int[] location = new int[2];
        mImageView.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];

        /**
         * popwindow显示的位置
         * 参数一：基于某控件，一般在popupWindow.showAsDropDown()中比较有用，该处作用不大
         * 参数二：见名知意，写默认即可
         * 参数三：popupWindow在屏幕上显示位置的x坐标
         * 参数四：popupWindow在屏幕上显示位置的y左边
         */
        mMenuPop.showAtLocation(mImageView, Gravity.NO_GRAVITY, mImageView.getLeft()-PopWidth+mImageView.getWidth()/4, y+mImageView.getHeight()/2-PopHeight/2);

    }

    //当前旋转的度数
    private int rotate = 0;
    //每次旋转的度数
    private int rotation = 225;
    //判断顺时针转还是逆时针转
    private boolean rotateDirection = true;

    /**
     * 悬浮菜单动画效果
     * @param v
     */
    private void mRotate(View v) {

        ObjectAnimator animator;

        //判断是顺时针旋转还是逆时针旋转
        if(rotateDirection){
            animator = ObjectAnimator.ofFloat(v, "rotation", rotate,rotate-rotation);
            rotate = rotate+rotation;

        }else{
            animator = ObjectAnimator.ofFloat(v, "rotation", rotate,rotate+rotation);
            rotate = rotate-rotation;
        }

        //持续时间
        animator.setDuration(350);
        animator.start();
        rotateDirection = !rotateDirection;
    }


    /**
     * 获取PopupWindow实例 .分类
     */
    private void getPopMenu() {

        if (mMenuPop != null) {

            //动画
            mRotate(mImageView);
            //关闭
            mMenuPop.dismiss();
//            mMenuPop = null;
            return;
        } else {
            //初始化popupWindow弹窗
            initMenuPop();
        }
    }
    /**
     * 初始化popWindow
     */
    private void initMenuPop() {
        // 获取自定义布局文件pop.xml的视图
        View view = View.inflate(DiabetesActivity.this, R.layout.item_pop_levitate_menu, null);

        //测量view的宽高，由于popupwindow没有测量的方法，只能测量内部view的宽高
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        PopWidth = view.getMeasuredWidth();
        PopHeight = view.getMeasuredHeight();

        //下面这两个必须有！！
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        // PopupWindow(布局，宽度，高度) 注意，此处宽高应为-2也就是wrap_content
        mMenuPop = new PopupWindow(view, -2, -2, true);

        // 重写onKeyListener,按返回键消失
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {

                    mRotate(mImageView);
                    mMenuPop.dismiss();
                    mMenuPop = null;
                    return true;
                }
                return false;
            }
        });

        //点击其他地方消失
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mMenuPop != null && mMenuPop.isShowing()) {
                    mRotate(mImageView);
                    mMenuPop.dismiss();
                    mMenuPop = null;
                    return true;
                }
                return false;
            }
        });

        TextView tv_newClue = (TextView) view.findViewById(R.id.tv_newClue);
        TextView tv_Edit = (TextView) view.findViewById(R.id.tv_edit);

        //新建线索
        tv_newClue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mRotate(mImageView);
                mMenuPop.dismiss();
                mMenuPop = null;

            }
        });

        //编辑
        tv_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mRotate(mImageView);
                mMenuPop.dismiss();
                mMenuPop = null;

            }
        });

    }


    @OnClick({R.id.tv_title_save, R.id.tv_qiehuan, R.id.tv_xinjian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title_save:
                break;
            case R.id.tv_qiehuan:
                break;
            case R.id.tv_xinjian:
                break;
        }
    }
}
