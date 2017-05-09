package com.example.game_assistent;

import java.util.ArrayList;
import java.util.List;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.UtilsTools.DiglogUtil;
import com.example.fragment.GiftFragment;
import com.example.fragment.HuoDong;
import com.example.fragment.WoDe;
import com.example.fragment.XiaoGame;
import com.example.fragment.ZhuanQian;

public class MainActivity extends FragmentActivity implements
        OnCheckedChangeListener {
    private int count;
    private RadioGroup rg_main;
    // 记录oncheckedchange监听被调用的标识变量
    private boolean isChanged;
    private int index;
    private boolean first;
    private RadioButton rbtn_gift;
    private RadioButton rbtn_my;
    private List<Fragment> list;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                count = 0;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbtn_my = (RadioButton) findViewById(R.id.rbtn_my);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        rbtn_gift = (RadioButton) findViewById(R.id.rbtn_gift);
        list = new ArrayList<Fragment>();
        rg_main.setOnCheckedChangeListener(this);
        rbtn_gift.performClick();
        addFragment();

    }

    public void addFragment() {
        list.add(new GiftFragment());
        list.add(new HuoDong());
        list.add(new XiaoGame());
        list.add(new ZhuanQian());
        list.add(new WoDe());
        for (int i = 0; i < list.size(); i++) {
            Fragment f = list.get(i);
            if (i == 0) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flayout_main_fragment, f).show(f).commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.flayout_main_fragment, f).hide(f).commit();

            }

        }

    }

    public void showFragment(int num) {
        for (int i = 0; i < list.size(); i++) {
            Fragment f = list.get(i);
            if (i == num) {
                getSupportFragmentManager().beginTransaction().show(f).commit();

            } else {
                getSupportFragmentManager().beginTransaction().hide(f).commit();

            }
        }

    }

    @Override
    public void onBackPressed() {
        count++;
        if (count == 2) {
            super.onBackPressed();
        }
        Toast.makeText(getApplicationContext(), "再点击一次即将退出", 0).show();
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    /**
     * 参数1：单选组 参数2：选中按钮的id 注意:反复点击已经选中的button，不会触发 解决方法：注册onClick点击事件，另外去写逻辑
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // 1.循环找出所有的单选按钮
        // 2.如果该单选按钮选中，隐藏文字
        // 3.其他没有选中的单选按钮全部显示文字
        if (first) {
            RadioButton pre = (RadioButton) group.getChildAt(index);
            scaleAnimtorRest(pre);
        }
        for (int i = 0; i < group.getChildCount(); i++) {
            RadioButton rbtn = (RadioButton) group.getChildAt(i);
            if (rbtn.getId() == checkedId) {
                // 选中的情况
                scaleAnimtorFirst(rbtn);
                isChanged = true;
                index = i;
            }

        }
        first = true;
        showFragment(index);
    }

    public void btn(View v) {

        if (!isChanged) {
            if (v.getId() != R.id.detail_wd
                    && v.getId() != R.id.fragment4_image1)
                scaleAnimtor(v);
        }
        isChanged = false;
        if (v.getId() == R.id.detail_wd || v.getId() == R.id.fragment4_image1) {
            rbtn_my.performClick();
        }
    }

    private void scaleAnimtor(View v) {
        ObjectAnimator oax = ObjectAnimator.ofFloat(v, View.SCALE_X, 1.3f,
                0.5f, 1.2f, 0.6f, 1.1f, 0.7f, 1.0f, 0.8f, 0.9f, 1.3f);
        ObjectAnimator oay = ObjectAnimator.ofFloat(v, View.SCALE_Y, 1.3f,
                0.5f, 1.2f, 0.6f, 1.1f, 0.7f, 1.0f, 0.8f, 0.9f, 1.3f);

        oax.setDuration(1000);
        oay.setDuration(1000);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(oax, oay);
        set.start();
    }

    private void scaleAnimtorFirst(View v) {

        ObjectAnimator oax = ObjectAnimator
                .ofFloat(v, View.SCALE_X, 1.0f, 1.3f);
        ObjectAnimator oay = ObjectAnimator
                .ofFloat(v, View.SCALE_Y, 1.0f, 1.3f);
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, 0,
                12);
        ObjectAnimator oa4 = ObjectAnimator.ofFloat(v, View.ROTATION_Y, 0, 360);
        oa4.setDuration(500);
        oa3.setDuration(500);
        oax.setDuration(500);
        oay.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(oax, oay, oa3, oa4);
        set.start();

    }

    private void scaleAnimtorRest(View v) {
        ObjectAnimator oax = ObjectAnimator
                .ofFloat(v, View.SCALE_X, 1.3f, 1.0f);
        ObjectAnimator oay = ObjectAnimator
                .ofFloat(v, View.SCALE_Y, 1.3f, 1.0f);
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, 12,
                0);
        oa3.setDuration(500);
        oax.setDuration(500);
        oay.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(oax, oay, oa3);
        set.start();

    }

}
