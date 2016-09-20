package com.example.administrator.liwushuo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.ui.fragments.ClassifyFragment;
import com.example.administrator.liwushuo.ui.fragments.HomeFragment;
import com.example.administrator.liwushuo.ui.fragments.MineFragment;
import com.example.administrator.liwushuo.ui.fragments.TopListFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private FragmentManager mFragmentManager;
    private Fragment mShowFragment;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mShowFragment = new HomeFragment();
        transaction.add(R.id.main_frame, mShowFragment,HomeFragment.TAG);
        transaction.commit();

    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_tab_radiogroup);
        mRadioGroup.setOnCheckedChangeListener(this);
    }
    private void switchPager(String tag, Class<? extends Fragment> cls) {
//        先将现在显示的页面碎片隐藏
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(mShowFragment);
//        根据TAG去FragmentManager中查找
        mShowFragment = fragmentManager.findFragmentByTag(tag);
//        判断是否找到TAG标记的页面碎片
                if (mShowFragment!=null) {
//            找到就让碎片显示
                    transaction.show(mShowFragment);
                }else{
//            没找到就添加,并设置标记
                    try {
//            利用反射将Fragment实例化
                mShowFragment = cls.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.main_frame,mShowFragment,tag);
        }
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                switchPager(HomeFragment.TAG,HomeFragment.class);
                break;
            case R.id.rb_toplist:
                switchPager(TopListFragment.TAG,TopListFragment.class);
                break;
            case R.id.rb_classify:
                switchPager(ClassifyFragment.TAG,ClassifyFragment.class);
                break;
            case R.id.rb_mine:
                switchPager(MineFragment.TAG,MineFragment.class);
                break;
        }
    }
}
