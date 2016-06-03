package com.yuyife.flyui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * UI主界面
 * Created by yuyife on 16-5-31.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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

    @OnClick({R.id.fly_left_image_car})
    public void onViewClick(View v){
        switch (v.getId()){
            case R.id.fly_left_image_car:
                Snackbar.make(v,"I am yuyife [FlyAudio coder]",Snackbar.LENGTH_SHORT).show();
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
        if (isFirst) {
            firstValue();
        } else {
            switch (view.getId()) {
                case R.id.vehicle_layout_normal:
                case R.id.vehicle_layout_change:
                    index = 0;
                    break;
                case R.id.sound_layout_normal:
                case R.id.sound_layout_change:
                    index = 1;
                    break;
                case R.id.radio_layout_normal:
                case R.id.radio_layout_change:
                    index = 2;
                    break;
                case R.id.media_layout_normal:
                case R.id.media_layout_change:
                    index = 3;
                    break;
                case R.id.telephone_layout_normal:
                case R.id.telephone_layout_change:
                    index = 4;
                    break;
                case R.id.settings_layout_normal:
                case R.id.settings_layout_change:
                    index = 5;
                    break;
            }
        }
        if (index == 0) {
            isChangeLayout = false;
            isUpdate = true;
        } else if (index == 5) {
            isChangeLayout = true;
            isUpdate = true;
        } else {
            isUpdate = false;
        }

        Log.e(TAG, "this index:" + index);
        setViewStatus();
    }

    @OnClick({R.id.btn_pre, R.id.btn_next})
    public void onBtnClick(View view) {
        if (isFirst) {
            firstValue();
        } else {
            switch (view.getId()) {
                case R.id.btn_pre:

                    if (index == 0) {
                        //当 光标已经停在 vehicle 再点击pre 不再移动光标
                        MyAnimation.startAnimationsIn(menuItemLayout[index], 200);
                        return;
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
                    }

                    break;
                case R.id.btn_next:
                    if (index == 5) {
                        //当 光标已经停在 settings 再点击next 不再移动光标
                        MyAnimation.startAnimationsIn(menuItemLayout[index], 200);
                        return;
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
                    }

                    break;
            }

        }

        Log.e(TAG, "this index:" + index);
        setViewStatus();
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

    private void setViewStatus() {
        initWidget();
        for (int i = 0; i < count; i++) {
            textLayouts[i].setBackgroundDrawable(null);
            imageViews[i].setImageDrawable(normalImages[i]);

        }

        viewBg.setBackgroundResource(carBGColors[index]);
        textLayouts[index].setBackgroundDrawable(menuShapeDrawables[index]);
        imageViews[index].setImageDrawable(selectImages[index]);

        MyAnimation.startAnimationsIn(menuItemLayout[index], 200);


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

    private boolean isFirst = true;
    private boolean isChangeLayout = false;//默认不改变布局
    private boolean isUpdate = false;//

    private int index = 0;
    private int count = 6;

    private View view0, view1, view2, view3, view4, view5;
    private LinearLayout[] menuItemLayout = new LinearLayout[count];
    private ImageView[] imageViews = new ImageView[count];
    private Drawable[] normalImages = new Drawable[count];
    private Drawable[] selectImages = new Drawable[count];
    private TextView[] textViews = new TextView[count];
    private LinearLayout[] textLayouts = new LinearLayout[count];
    private String[] menuText = new String[count];
    private int[] carBGColors = new int[count];
    private Drawable[] menuShapeDrawables = new Drawable[count];
    private LayoutInflater inflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fly_main_layout);
        ButterKnife.bind(this);

        initData();
        initWidget();

        prepare();
    }

    private void prepare() {

        normalViewsUpdate();
    }

    private void firstValue(){
        index = 0;
        isChangeLayout = false;
        isUpdate = false;
        isFirst = false;
    }
    private void initData() {
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

        inflater = LayoutInflater.from(this);

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
                    textViews[0].setText(menuText[0]);
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
                    textViews[5].setText(menuText[5]);
                    break;
            }
        }

    }
}
