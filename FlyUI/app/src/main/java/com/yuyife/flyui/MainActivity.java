package com.yuyife.flyui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuyife.flyui.anim.MyAnimation;
import com.yuyife.flyui.util.Dip2Px;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * UI主界面
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Bind(R.id.root_layout)
    RelativeLayout rootLayout;

    @Bind(R.id.fly_left_image_car)
    ImageView imageCar;

    @Bind(R.id.fly_left_view_bg)
    View viewBg;
    @Bind(R.id.vehicle_layout_change)
    LinearLayout vehicleLayoutChange;
    @Bind(R.id.sound_layout_change)
    LinearLayout soundLayoutChange;
    @Bind(R.id.radio_layout_change)
    LinearLayout radioLayoutChange;
    @Bind(R.id.media_layout_change)
    LinearLayout mediaLayoutChange;
    @Bind(R.id.telephone_layout_change)
    LinearLayout telephoneLayoutChange;
    @Bind(R.id.settings_layout_change)
    LinearLayout settingsLayoutChange;


    @Bind(R.id.vehicle_layout_normal)
    LinearLayout vehicleLayoutNormal;
    @Bind(R.id.sound_layout_normal)
    LinearLayout soundLayoutNormal;
    @Bind(R.id.radio_layout_normal)
    LinearLayout radioLayoutNormal;
    @Bind(R.id.media_layout_normal)
    LinearLayout mediaLayoutNormal;
    @Bind(R.id.telephone_layout_normal)
    LinearLayout telephoneLayoutNormal;
    @Bind(R.id.settings_layout_normal)
    LinearLayout settingsLayoutNormal;

    @Bind(R.id.fly_change)
    LinearLayout changeLayout;
    @Bind(R.id.fly_normal)
    LinearLayout normalLayout;

    @Bind(R.id.view_normal)
    View viewNormal;
    @Bind(R.id.view_change)
    View viewChange;


    @OnClick({R.id.fly_left_image_car})
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.fly_left_image_car:
                Snackbar.make(v, "I am yuyife [FlyAudio coder]", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    @OnClick({R.id.vehicle_layout_normal, R.id.vehicle_layout_change,
            R.id.sound_layout_normal, R.id.sound_layout_change,
            R.id.radio_layout_normal, R.id.radio_layout_change,
            R.id.media_layout_normal, R.id.media_layout_change,
            R.id.telephone_layout_normal, R.id.telephone_layout_change,
            R.id.settings_layout_normal, R.id.settings_layout_change})
    public void onMenuItemClick(View view) {
        //在 normal 的情况下，点击settings 切换到change
        //在 change 的情况下，点击vehicle 切换到normal
        isUpdate = false;
        isFirst = false;
        float toX = 0.0f, fromX = 0.0f, toY = 0.0f, fromY = 0.0f;
        switch (view.getId()) {

            case R.id.vehicle_layout_change:
                index = 0;
                isChangeLayout = false;
                isUpdate = true;

                fromX = viewEntity.getVehicleNormalX() - additionalValue;
                toX = viewEntity.getVehicleNormalX();
                fromY = viewEntity.getVehicleNormalY() - additionalValue;
                toY = viewEntity.getVehicleNormalY();
                break;


            case R.id.vehicle_layout_normal:
                index = 0;

                fromX = viewEntity.getVehicleNormalX() - additionalValue;
                toX = viewEntity.getVehicleNormalX();
                fromY = viewEntity.getVehicleNormalY() - additionalValue;
                toY = viewEntity.getVehicleNormalY();
                break;
            case R.id.sound_layout_change:
                index = 1;

                fromX = viewEntity.getVehicleNormalX() - additionalValue;
                toX = viewEntity.getVehicleNormalX();
                fromY = viewEntity.getVehicleNormalY() - additionalValue;
                toY = viewEntity.getVehicleNormalY();
                break;
            case R.id.sound_layout_normal:
                index = 1;

                fromX = viewEntity.getSoundNormalX() - additionalValue;
                toX = viewEntity.getSoundNormalX();
                fromY = viewEntity.getSoundNormalY() - additionalValue;
                toY = viewEntity.getSoundNormalY();
                break;
            case R.id.radio_layout_change:
                index = 2;

                fromX = viewEntity.getSoundNormalX() - additionalValue;
                toX = viewEntity.getSoundNormalX();
                fromY = viewEntity.getSoundNormalY() - additionalValue;
                toY = viewEntity.getSoundNormalY();
                break;
            case R.id.radio_layout_normal:
                index = 2;
                fromX = viewEntity.getRadioNormalX() - additionalValue;
                toX = viewEntity.getRadioNormalX();
                fromY = viewEntity.getRadioNormalY() - additionalValue;
                toY = viewEntity.getRadioNormalY();
                break;
            case R.id.media_layout_change:
                index = 3;
                fromX = viewEntity.getRadioNormalX() - additionalValue;
                toX = viewEntity.getRadioNormalX();
                fromY = viewEntity.getRadioNormalY() - additionalValue;
                toY = viewEntity.getRadioNormalY();
                break;
            case R.id.media_layout_normal:
                index = 3;
                fromX = viewEntity.getMediaNormalX() - additionalValue;
                toX = viewEntity.getMediaNormalX();
                fromY = viewEntity.getMediaNormalY() - additionalValue;
                toY = viewEntity.getMediaNormalY();
                break;

            case R.id.telephone_layout_change:
                index = 4;
                fromX = viewEntity.getMediaNormalX() - additionalValue;
                toX = viewEntity.getMediaNormalX();
                fromY = viewEntity.getMediaNormalY() - additionalValue;
                toY = viewEntity.getMediaNormalY();
                break;
            case R.id.telephone_layout_normal:
                index = 4;
                fromX = viewEntity.getPhoneNormalX() - additionalValue;
                toX = viewEntity.getPhoneNormalX();
                fromY = viewEntity.getPhoneNormalY() - additionalValue;
                toY = viewEntity.getPhoneNormalY();
                break;
            case R.id.settings_layout_change:
                index = 5;
                fromX = viewEntity.getPhoneNormalX() - additionalValue;
                toX = viewEntity.getPhoneNormalX();
                fromY = viewEntity.getPhoneNormalY() - additionalValue;
                toY = viewEntity.getPhoneNormalY();
                break;

            case R.id.settings_layout_normal:
                index = 5;
                isChangeLayout = true;
                isUpdate = true;
                fromX = viewEntity.getPhoneNormalX() - additionalValue;
                toX = viewEntity.getPhoneNormalX();
                fromY = viewEntity.getPhoneNormalY() - additionalValue;
                toY = viewEntity.getPhoneNormalY();
                break;

        }
        clickViewStatus(fromX, toX, fromY, toY);
    }

    @OnClick({R.id.btn_pre, R.id.btn_next})
    public void onBtnClick(View view) {
        if (isFirst) {
            resetValue();
            String tag = view.getTag().toString();
            if (tag.equals(getResources().getString(R.string.pre_tag))) {
                isPre = true;
                isNext = false;
            } else if (tag.equals(getResources().getString(R.string.next_tag))) {
                isPre = false;
                isNext = true;
            }
            setViewStatus();
        } else {
            switch (view.getId()) {
                case R.id.btn_pre:
                    functionPre();

                    break;
                case R.id.btn_next:
                    functionNext();

                    break;
            }

        }

        Log.e(TAG, "this index:" + index);

    }

    private void functionPre() {
        isPre = true;
        isNext = false;
        if (index == 0) {
            //当 光标已经停在 vehicle 再点击pre 不再移动光标
            MyAnimation.moveAnimTop(this, menuItemLayout[index]);
        } else {
            //  5 4 3 2 1
            //光标从1 -》 0 isChangeLayout = false;
            if (index == 1) {
                isChangeLayout = false;
                isUpdate = true;
            } else {
                isUpdate = false;
            }
            index -= 1;
            setViewStatus();
        }
    }

    private void functionNext() {
        isNext = true;
        isPre = false;
        if (index == 5) {
            //当 光标已经停在 settings 再点击next 不再移动光标
            MyAnimation.moveAnimTop(this, menuItemLayout[index]);
        } else {
            // 0 1 2 3 4
            //光标从4 -》 5 isChangeLayout = true;
            if (index == 4) {
                isChangeLayout = true;
                isUpdate = true;
            } else {
                isUpdate = false;
            }
            index += 1;
            setViewStatus();
        }
    }

    private void cleanViews() {
        vehicleLayoutChange.removeAllViews();
        soundLayoutChange.removeAllViews();
        radioLayoutChange.removeAllViews();
        mediaLayoutChange.removeAllViews();
        telephoneLayoutChange.removeAllViews();
        settingsLayoutChange.removeAllViews();

        vehicleLayoutNormal.removeAllViews();
        soundLayoutNormal.removeAllViews();
        radioLayoutNormal.removeAllViews();
        mediaLayoutNormal.removeAllViews();
        telephoneLayoutNormal.removeAllViews();
        settingsLayoutNormal.removeAllViews();

    }

    private void normalViewsUpdate() {
        cleanViews();
        vehicleLayoutNormal.addView(menuItemLayout[0]);
        soundLayoutNormal.addView(menuItemLayout[1]);
        radioLayoutNormal.addView(menuItemLayout[2]);
        mediaLayoutNormal.addView(menuItemLayout[3]);
        telephoneLayoutNormal.addView(menuItemLayout[4]);
        settingsLayoutNormal.addView(menuItemLayout[5]);

    }

    private void changeViewsUpdate() {
        cleanViews();
        vehicleLayoutChange.addView(menuItemLayout[0]);
        soundLayoutChange.addView(menuItemLayout[1]);
        radioLayoutChange.addView(menuItemLayout[2]);
        mediaLayoutChange.addView(menuItemLayout[3]);
        telephoneLayoutChange.addView(menuItemLayout[4]);
        settingsLayoutChange.addView(menuItemLayout[5]);
    }


    private View animView;

    private void clickViewStatus(float fromX, float toX, float fromY, float toY) {
        initWidget();
        for (int i = 0; i < count; i++) {
            textLayouts[i].setBackgroundDrawable(null);
            imageViews[i].setImageDrawable(normalImages[i]);

        }
        viewBg.setBackgroundResource(carBGColors[index]);
        //textLayouts[index].setBackgroundDrawable(menuShapeDrawables[index]);
        imageViews[index].setImageDrawable(selectImages[index]);

        //0 -> 1
        viewAnimPrepare(index);


        MyAnimation.viewAnim(animView, fromX, toX, fromY, toY);
        if (isUpdate) {
            if (isChangeLayout) {
                normalLayout.setVisibility(View.GONE);
                changeLayout.setVisibility(View.VISIBLE);
                changeViewsUpdate();
            } else {
                changeLayout.setVisibility(View.GONE);
                normalLayout.setVisibility(View.VISIBLE);
                normalViewsUpdate();
            }
        } else {
            if (isChangeLayout) {
                changeViewsUpdate();
            } else {
                normalViewsUpdate();
            }
        }
        Log.e(TAG, "isChangeLayout:" + isChangeLayout);
        Log.e(TAG, "isUpdate:" + isUpdate);
    }

    private void setViewStatus() {
        initWidget();
        for (int i = 0; i < count; i++) {
            textLayouts[i].setBackgroundDrawable(null);
            imageViews[i].setImageDrawable(normalImages[i]);

        }
        viewBg.setBackgroundResource(carBGColors[index]);
        //textLayouts[index].setBackgroundDrawable(menuShapeDrawables[index]);
        imageViews[index].setImageDrawable(selectImages[index]);


        if (isNext) {
            //0 -> 1
            viewAnimPrepare(index);
            switch (index) {
                case 0:
                    //初始化好activity，第一次  把光标移动到 normalLayout  vehicle
                    if (isFirst) {
                        isFirst = false;
                        MyAnimation.viewAnim(animView,
                                viewEntity.getVehicleNormalX() - additionalValue,
                                viewEntity.getVehicleNormalX(),
                                viewEntity.getVehicleNormalY() - additionalValue,
                                viewEntity.getVehicleNormalY());
                    } else {
                        if (isChangeLayout) {

                        } else {
                            MyAnimation.viewAnim(animView,
                                    viewEntity.getVehicleNormalX() - additionalValue,
                                    viewEntity.getVehicleNormalX(),
                                    viewEntity.getVehicleNormalY() - additionalValue,
                                    viewEntity.getVehicleNormalY());
                        }
                    }

                    break;
                case 1:
                    if (isChangeLayout) {

                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getVehicleNormalX(),
                                viewEntity.getSoundNormalX(),
                                viewEntity.getVehicleNormalY(),
                                viewEntity.getSoundNormalY());
                    }
                    break;
                case 2:
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getSoundChangeX(),
                                viewEntity.getRadioChangeX(),
                                viewEntity.getSoundChangeY(),
                                viewEntity.getRadioChangeY());
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getSoundNormalX(),
                                viewEntity.getRadioNormalX(),
                                viewEntity.getSoundNormalY(),
                                viewEntity.getRadioNormalY());
                    }
                    break;
                case 3:
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getRadioChangeX(),
                                viewEntity.getMediaChangeX(),
                                viewEntity.getRadioChangeY(),
                                viewEntity.getMediaChangeY()
                        );
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getRadioNormalX(),
                                viewEntity.getMediaNormalX(),
                                viewEntity.getRadioNormalY(),
                                viewEntity.getMediaNormalY()
                        );
                    }
                    break;
                case 4:
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getMediaChangeX(),
                                viewEntity.getPhoneChangeX(),
                                viewEntity.getMediaChangeY(),
                                viewEntity.getPhoneChangeY()
                        );
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getMediaNormalX(),
                                viewEntity.getPhoneNormalX(),
                                viewEntity.getMediaNormalY(),
                                viewEntity.getPhoneNormalY()
                        );
                    }
                    break;
                case 5:
                    if (isChangeLayout) {
                        //在 change页 settings  原地动画
                        MyAnimation.viewAnim(animView,
                                viewEntity.getPhoneChangeX(),
                                viewEntity.getSettingChangeX(),
                                viewEntity.getPhoneChangeY(),
                                viewEntity.getSettingChangeY()
                        );
                    } else {
                        //从 false -> true  normal4 -> change5
                    }

            }
        }

        if (isPre) {
            //5 -> 4
            viewAnimPrepare(index);
            switch (index) {
                case 0:
                    if (isFirst) {
                        isFirst = false;

                        MyAnimation.viewAnim(animView,
                                viewEntity.getVehicleNormalX() + additionalValue,
                                viewEntity.getVehicleNormalX(),
                                viewEntity.getVehicleNormalY() + additionalValue,
                                viewEntity.getVehicleNormalY());
                    } else {
                        if (isChangeLayout) {
                            // 从change1 - normal0
                            MyAnimation.viewAnim(animView,
                                    viewEntity.getSoundChangeX(),
                                    viewEntity.getVehicleNormalX(),
                                    viewEntity.getSoundChangeY(),
                                    viewEntity.getVehicleNormalY()
                            );
                        } else {
                            MyAnimation.viewAnim(animView,
                                    viewEntity.getSoundNormalX(),
                                    viewEntity.getVehicleNormalX(),
                                    viewEntity.getSoundNormalY(),
                                    viewEntity.getVehicleNormalY()
                            );
                        }
                    }
                    break;
                case 1:
                    //2 -> 1
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getRadioChangeX(),
                                viewEntity.getSoundChangeX(),
                                viewEntity.getRadioChangeY(),
                                viewEntity.getSoundChangeY()
                        );
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getRadioNormalX(),
                                viewEntity.getSoundNormalX(),
                                viewEntity.getRadioNormalY(),
                                viewEntity.getSoundNormalY()
                        );
                    }
                    break;
                case 2:
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getMediaChangeX(),
                                viewEntity.getRadioChangeX(),
                                viewEntity.getMediaChangeY(),
                                viewEntity.getRadioChangeY());
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getMediaNormalX(),
                                viewEntity.getRadioNormalX(),
                                viewEntity.getMediaNormalY(),
                                viewEntity.getRadioNormalY());
                    }
                    break;
                case 3:
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getPhoneChangeX(),
                                viewEntity.getMediaChangeX(),
                                viewEntity.getPhoneChangeY(),
                                viewEntity.getMediaChangeY()
                        );
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getPhoneNormalX(),
                                viewEntity.getMediaNormalX(),
                                viewEntity.getPhoneNormalY(),
                                viewEntity.getMediaNormalY()
                        );
                    }
                    break;
                case 4:
                    if (isChangeLayout) {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getSettingChangeX(),
                                viewEntity.getPhoneChangeX(),
                                viewEntity.getSettingChangeY(),
                                viewEntity.getPhoneChangeY()
                        );
                    } else {
                        MyAnimation.viewAnim(animView,
                                viewEntity.getSettingNormalX(),
                                viewEntity.getPhoneNormalX(),
                                viewEntity.getSettingNormalY(),
                                viewEntity.getPhoneNormalY()
                        );
                    }
                    break;

            }

        }


        if (isUpdate) {
            if (isChangeLayout) {
                normalLayout.setVisibility(View.GONE);
                changeLayout.setVisibility(View.VISIBLE);
                changeViewsUpdate();
            } else {
                changeLayout.setVisibility(View.GONE);
                normalLayout.setVisibility(View.VISIBLE);
                normalViewsUpdate();
            }
        } else {
            if (isChangeLayout) {
                changeViewsUpdate();
            } else {
                normalViewsUpdate();
            }
        }
        Log.e(TAG, "isChangeLayout:" + isChangeLayout);
        Log.e(TAG, "isUpdate:" + isUpdate);
    }

    private void viewAnimPrepare(int index) {
        if (isChangeLayout) {
            animView = viewChange;
        } else {
            animView = viewNormal;
        }
        animView.setVisibility(View.VISIBLE);
        float w = textLayoutWidthArray[index];
        float h = textLayoutHeightArray[index];
        ViewGroup.LayoutParams params = animView.getLayoutParams();
        params.height = (int) h;
        params.width = (int) w;
        animView.setLayoutParams(params);
        animView.setBackgroundDrawable(menuShapeDrawables[index]);
    }

    private boolean isFirst = true;
    private boolean isChangeLayout = false;//默认不改变布局
    private boolean isUpdate = false;//
    private boolean isPre = false;
    private boolean isNext = false;

    private int index = 0;
    private int count = 6;

    private View view0, view1, view2, view3, view4, view5;//《1级》
    private LinearLayout[] menuItemLayout = new LinearLayout[count];//《2级》
    private ImageView[] imageViews = new ImageView[count];//《2级 图标》
    private Drawable[] normalImages = new Drawable[count];//《2级 图标的 正常模式》
    private Drawable[] selectImages = new Drawable[count];//《2级 图标的 选择模式》
    private LinearLayout[] textLayouts = new LinearLayout[count];//《2级 文字 Layout》
    private TextView[] textViews = new TextView[count];//《2级 文字 textView》
    private String[] menuText = new String[count];//《2级 文字内容》
    private int[] carBGColors = new int[count];//标示car的变化
    private Drawable[] menuShapeDrawables = new Drawable[count];//每个 菜单 文字Layout 的背景框
    private LayoutInflater inflater;

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fly_main_layout);
        ButterKnife.bind(this);
        context = this;
        viewEntity = new ViewEntity();
        initData();
        initWidget();
        prepare();
    }

    private float touchLayoutX_down, touchLayoutY_down, touchLayoutX_up, touchLayoutY_up,
            differenceX, differenceY;
    private float distance = 150f;

    private void touchPre() {
        if (isFirst) {
            resetValue();
            isPre = true;
            isNext = false;
            setViewStatus();
        } else {
            functionPre();
        }
    }

    private void touchNext() {
        if (isFirst) {
            resetValue();
            isNext = true;
            isPre = false;
            setViewStatus();
        } else {
            functionNext();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchLayoutX_down = event.getX();
                touchLayoutY_down = event.getY();
                Log.e(TAG, "touchLayoutX_down" + touchLayoutX_down);
                Log.e(TAG, "touchLayoutY_down" + touchLayoutY_down);
                break;
            case MotionEvent.ACTION_UP:
                touchLayoutX_up = event.getX();
                touchLayoutY_up = event.getY();

                differenceX = touchLayoutX_up - touchLayoutX_down;
                differenceY = touchLayoutY_up - touchLayoutY_down;

                Log.e(TAG, "touchLayoutX_up" + touchLayoutX_up);
                Log.e(TAG, "touchLayoutY_up" + touchLayoutY_up);
                Log.e(TAG, "x的差" + differenceX);
                Log.e(TAG, "y的差" + differenceY);

                float valueX = Math.abs(differenceX);
                float valueY = Math.abs(differenceY);
                if (differenceX >= distance) {
                    //从左往右  对应 next
                    if (differenceY < 0) {
                        // 从左往右 并且 y轴 偏上   左上 负数
                        if (differenceY > -distance) {
                            //正常的偏差
                            touchNext();
                        } else {
                            if (valueX > valueY) {
                                //横向的 距离 大于 纵向的距离   有效
                                touchNext();
                            } else {
                                //横向的 距离 小于或等于 纵向的距离
                                //走这说明 是从下 往上 了。
                                Log.e(TAG, "这是左上，手势无效：横向的 距离 小于或等于 纵向的距离");
                                touchPre();
                            }
                        }
                    } else {
                        // 从左往右 并且 y轴 偏下，或者y 轴不变  左下 正数
                        if (differenceY < distance) {
                            //正常的偏差
                            touchNext();
                        } else {
                            if (valueX > valueY) {
                                //横向的 距离 大于 纵向的距离   有效
                                touchNext();
                            } else {
                                //横向的 距离 小于或等于 纵向的距离
                                //走这说明 是从上 往下了。
                                Log.e(TAG, "这是左下，手势无效：横向的 距离 小于或等于 纵向的距离");
                                touchNext();
                            }
                        }
                    }

                } else if (differenceX < distance) {
                    //当 横向滑动的距离 小于 150 的情况
                    if (differenceX <= -distance) {
                        //当 横向滑动的距离 小于等于  -150 的情况

                        if (differenceY < 0) {
                            // y轴 偏上   右上 负数
                            if (differenceY > -distance) {
                                //正常范围的 从右往左
                                touchPre();
                            } else {
                                if (valueX > valueY) {
                                    //横向的 距离 大于 纵向的距离   有效
                                    touchNext();
                                } else {
                                    //横向的 距离 小于或等于 纵向的距离
                                    //走这说明 是从下 往上 了。
                                    Log.e(TAG, "这是右上，手势无效：横向的 距离 小于或等于 纵向的距离");
                                    touchPre();
                                }
                            }
                        } else {
                            // y轴 偏下，或者y 轴不变  右下 正数
                            if (differenceY < distance) {
                                touchPre();
                            } else {
                                if (valueX > valueY) {
                                    //横向的 距离 大于 纵向的距离   有效
                                    touchNext();
                                } else {
                                    //横向的 距离 小于或等于 纵向的距离
                                    //走这说明 是从上 往下了。
                                    Log.e(TAG, "这是右下，手势无效：横向的 距离 小于或等于 纵向的距离");
                                    touchNext();
                                }
                            }
                        }

                    } else {
                        //当 横向滑动的距离 大于  -150   小于 150 的情况
                        // x 的差值在 -distance - distance以内，判断为无效操作
                        Log.e(TAG, "这是右往左 x 的差值在 -distance -> distance以内，判断为无效操作");
                        //在这里判断上下的操作

                        if (differenceY >= distance) {
                            Log.e(TAG, "这是從上往下 differenceY >= distance");
                            //從上往下
                            if (differenceX > 0) {
                                //往下 偏右  正数
                                if (differenceX < distance) {
                                    //正常的偏差范围
                                    touchNext();
                                } else {

                                }
                            } else {
                                if (valueY > valueX) {
                                    //纵向的 距离 大于 横向的距离   有效
                                    touchNext();
                                } else {
                                    //纵向的 距离 小于 横向的距离   有效
                                    Log.e(TAG, " 從上往下 valueY < valueX");
                                    touchNext();
                                }
                            }
                        } else {
                            if (differenceY < -distance) {
                                //从下往上
                                Log.e(TAG, "这是从下往上 differenceY < -distance");
                                if (valueX > distance) {
                                    touchPre();
                                    Log.e(TAG, "这是从下往上 valueX > distance");
                                } else {
                                    if (valueY > valueX) {
                                        //纵向的 距离 大于 横向的距离   有效
                                        Log.e(TAG, "这是从下往上 valueY > valueX");
                                        touchPre();
                                    } else {
                                        //纵向的 距离 小于 横向的距离
                                        Log.e(TAG, " 從下往上 valueY < valueX");
                                        touchPre();
                                    }
                                }
                            } else {
                                // 上下滑动的距离太短  无效
                                Log.e(TAG, "这是上下 y 的差值在 -distance -> distance以内，判断为无效操作");
                            }
                        }
                    }

                }

                break;
        }
        return super.dispatchTouchEvent(event);
    }


    @Override
    protected void onResume() {
        super.onResume();
        getViewParams();
    }

    private float[] textLayoutWidthArray = new float[count];
    private float[] textLayoutHeightArray = new float[count];
    //因为得到的是，menu菜单的父 控件（LinearLayout）,需要排除子控件图标的宽度
    private float menuIconWidth = 50.0f;
    private float menuIconHeight = 12.0f;
    private float additionalValue = 80.0f;//在第一个 和最后一个 加入偏移量

    private ViewEntity viewEntity;

    private void getViewParams() {
        textLayouts[0].post(new Runnable() {
            @Override
            public void run() {
                textLayoutWidthArray[0] = textLayouts[0].getWidth();
                textLayoutHeightArray[0] = textLayouts[0].getHeight();
            }
        });
        textLayouts[1].post(new Runnable() {
            @Override
            public void run() {
                textLayoutWidthArray[1] = textLayouts[1].getWidth();
                textLayoutHeightArray[1] = textLayouts[1].getHeight();
            }
        });
        textLayouts[2].post(new Runnable() {
            @Override
            public void run() {
                textLayoutWidthArray[2] = textLayouts[2].getWidth();
                textLayoutHeightArray[2] = textLayouts[2].getHeight();
            }
        });
        textLayouts[3].post(new Runnable() {
            @Override
            public void run() {
                textLayoutWidthArray[3] = textLayouts[3].getWidth();
                textLayoutHeightArray[3] = textLayouts[3].getHeight();
            }
        });
        textLayouts[4].post(new Runnable() {
            @Override
            public void run() {
                textLayoutWidthArray[4] = textLayouts[4].getWidth();
                textLayoutHeightArray[4] = textLayouts[4].getHeight();
            }
        });
        textLayouts[5].post(new Runnable() {
            @Override
            public void run() {
                textLayoutWidthArray[5] = textLayouts[5].getWidth();
                textLayoutHeightArray[5] = textLayouts[5].getHeight();
            }
        });
        //------------------------------------------------------------------------
        vehicleLayoutNormal.post(new Runnable() {
            @Override
            public void run() {

                viewEntity.setVehicleNormalX(vehicleLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setVehicleNormalY(vehicleLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

                viewEntity.setSoundChangeX(vehicleLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setSoundChangeY(vehicleLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

            }
        });
        soundLayoutNormal.post(new Runnable() {
            @Override
            public void run() {

                viewEntity.setSoundNormalX(soundLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setSoundNormalY(soundLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

                viewEntity.setRadioChangeX(soundLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setRadioChangeY(soundLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));
            }
        });
        radioLayoutNormal.post(new Runnable() {
            @Override
            public void run() {

                viewEntity.setRadioNormalX(radioLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setRadioNormalY(radioLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

                viewEntity.setMediaChangeX(radioLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setMediaChangeY(radioLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));
            }
        });
        mediaLayoutNormal.post(new Runnable() {
            @Override
            public void run() {

                viewEntity.setMediaNormalX(mediaLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setMediaNormalY(mediaLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

                viewEntity.setPhoneChangeX(mediaLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setPhoneChangeY(mediaLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));
            }
        });

        telephoneLayoutNormal.post(new Runnable() {
            @Override
            public void run() {

                viewEntity.setPhoneNormalX(telephoneLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setPhoneNormalY(telephoneLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

                viewEntity.setSettingChangeX(telephoneLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setSettingChangeY(telephoneLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));
            }
        });
        settingsLayoutNormal.post(new Runnable() {
            @Override
            public void run() {
                viewEntity.setSettingNormalX(settingsLayoutNormal.getX() + Dip2Px.dip2px(context, menuIconWidth));
                viewEntity.setSettingNormalY(settingsLayoutNormal.getY() + Dip2Px.dip2px(context, menuIconHeight));

            }
        });


    }

    private void prepare() {

        normalViewsUpdate();
    }

    private void resetValue() {
        index = 0;
        isChangeLayout = false;
        isUpdate = false;
        //isFirst = false;
    }

    private void initData() {
        inflater = LayoutInflater.from(context);

        menuText[0] = "Vehicle";
        menuText[1] = "Sound";
        menuText[2] = "Radio";
        menuText[3] = "Media";
        menuText[4] = "Phone";
        menuText[5] = "Settings";

        carBGColors[0] = R.color.carBGColorVehicle;
        carBGColors[1] = R.color.carBGColorSound;
        carBGColors[2] = R.color.carBGColorRadio;
        carBGColors[3] = R.color.carBGColorMedia;
        carBGColors[4] = R.color.carBGColorPhone;
        carBGColors[5] = R.color.carBGColorSettings;

        menuShapeDrawables[0] = getResources().getDrawable(R.drawable.shape_item_text_vehicle_bg);
        menuShapeDrawables[1] = getResources().getDrawable(R.drawable.shape_item_text_sound_bg);
        menuShapeDrawables[2] = getResources().getDrawable(R.drawable.shape_item_text_radio_bg);
        menuShapeDrawables[3] = getResources().getDrawable(R.drawable.shape_item_text_media_bg);
        menuShapeDrawables[4] = getResources().getDrawable(R.drawable.shape_item_text_phone_bg);
        menuShapeDrawables[5] = getResources().getDrawable(R.drawable.shape_item_text_settings_bg);

        normalImages[0] = getResources().getDrawable(R.drawable.channel2_press);
        normalImages[1] = getResources().getDrawable(R.drawable.channel1_press);
        normalImages[2] = getResources().getDrawable(R.drawable.channel5_press);
        normalImages[3] = getResources().getDrawable(R.drawable.channel6_press);
        normalImages[4] = getResources().getDrawable(R.drawable.channel4_press);
        normalImages[5] = getResources().getDrawable(R.drawable.channel7_press);

        selectImages[0] = getResources().getDrawable(R.drawable.channel2_selected);
        selectImages[1] = getResources().getDrawable(R.drawable.channel1_selected);
        selectImages[2] = getResources().getDrawable(R.drawable.channel5_selected);
        selectImages[3] = getResources().getDrawable(R.drawable.channel6_selected);
        selectImages[4] = getResources().getDrawable(R.drawable.channel4_selected);
        selectImages[5] = getResources().getDrawable(R.drawable.channel7_selected);

    }

    private void initWidget() {

        for (int i = 0; i < count; i++) {
            switch (i) {
                case 0:
                    view0 = inflater.inflate(R.layout.fly_right_item_layout, null);
                    menuItemLayout[0] = (LinearLayout) view0.findViewById(R.id.menu_item_layout);
                    textLayouts[0] = (LinearLayout) view0.findViewById(R.id.text_layout);
                    imageViews[0] = (ImageView) view0.findViewById(R.id.image);
                    textViews[0] = (TextView) view0.findViewById(R.id.text);
                    imageViews[0].setImageDrawable(normalImages[0]);
                    if (isChangeLayout) {
                        //textViews[0].setText("");
                        textViews[0].setText(menuText[0]);
                    } else {
                        textViews[0].setText(menuText[0]);
                    }
                    break;
                case 1:
                    view1 = inflater.inflate(R.layout.fly_right_item_layout, null);
                    menuItemLayout[1] = (LinearLayout) view1.findViewById(R.id.menu_item_layout);
                    textLayouts[1] = (LinearLayout) view1.findViewById(R.id.text_layout);
                    imageViews[1] = (ImageView) view1.findViewById(R.id.image);
                    textViews[1] = (TextView) view1.findViewById(R.id.text);
                    imageViews[1].setImageDrawable(normalImages[1]);
                    textViews[1].setText(menuText[1]);
                    break;
                case 2:
                    view2 = inflater.inflate(R.layout.fly_right_item_layout, null);
                    menuItemLayout[2] = (LinearLayout) view2.findViewById(R.id.menu_item_layout);
                    textLayouts[2] = (LinearLayout) view2.findViewById(R.id.text_layout);
                    imageViews[2] = (ImageView) view2.findViewById(R.id.image);
                    textViews[2] = (TextView) view2.findViewById(R.id.text);
                    imageViews[2].setImageDrawable(normalImages[2]);
                    textViews[2].setText(menuText[2]);
                    break;
                case 3:
                    view3 = inflater.inflate(R.layout.fly_right_item_layout, null);
                    menuItemLayout[3] = (LinearLayout) view3.findViewById(R.id.menu_item_layout);
                    textLayouts[3] = (LinearLayout) view3.findViewById(R.id.text_layout);
                    imageViews[3] = (ImageView) view3.findViewById(R.id.image);
                    textViews[3] = (TextView) view3.findViewById(R.id.text);
                    imageViews[3].setImageDrawable(normalImages[3]);
                    textViews[3].setText(menuText[3]);
                    break;
                case 4:
                    view4 = inflater.inflate(R.layout.fly_right_item_layout, null);
                    menuItemLayout[4] = (LinearLayout) view4.findViewById(R.id.menu_item_layout);
                    textLayouts[4] = (LinearLayout) view4.findViewById(R.id.text_layout);
                    imageViews[4] = (ImageView) view4.findViewById(R.id.image);
                    textViews[4] = (TextView) view4.findViewById(R.id.text);
                    imageViews[4].setImageDrawable(normalImages[4]);
                    textViews[4].setText(menuText[4]);
                    break;
                case 5:
                    view5 = inflater.inflate(R.layout.fly_right_item_layout, null);
                    menuItemLayout[5] = (LinearLayout) view5.findViewById(R.id.menu_item_layout);
                    textLayouts[5] = (LinearLayout) view5.findViewById(R.id.text_layout);
                    imageViews[5] = (ImageView) view5.findViewById(R.id.image);
                    textViews[5] = (TextView) view5.findViewById(R.id.text);
                    imageViews[5].setImageDrawable(normalImages[5]);
                    if (isChangeLayout) {
                        textViews[5].setText(menuText[5]);
                    } else {
                        //textViews[5].setText("");
                        textViews[5].setText(menuText[5]);
                    }
                    break;
            }
        }

    }
}
