package com.example.administrator.liwushuo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.HomeAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.TabModel;
import com.example.administrator.liwushuo.ui.fragments.homefragments.HomeItemFragment;
import com.example.administrator.liwushuo.ui.fragments.homefragments.HomeItemFragmentOne;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener {
    public static final String TAG = HomeFragment.class.getSimpleName();
    private EditText mSearch;
    private ImageView mSignin;
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private HomeAdapter mAdapter;
    private CheckBox mIsOpen;
    private GridView mChannel;
    private List<TabModel.DataBean.ChannelsBean> titles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        setupView();
        return layout;
    }

    private void initView() {
        mSearch = ((EditText) layout.findViewById(R.id.home_search));
        mSignin = ((ImageView) layout.findViewById(R.id.home_signin));
        mTablayout = ((TabLayout) layout.findViewById(R.id.home_tablayout));
        mViewPager = ((ViewPager) layout.findViewById(R.id.home_viewpager));
        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mAdapter = new HomeAdapter(getChildFragmentManager(),null);
        mViewPager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        mIsOpen = (CheckBox)layout.findViewById(R.id.home_isextend);
        mIsOpen.setOnCheckedChangeListener(this);
    }

    private void setupView() {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_TABLAYOUT);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                TabModel tabModel = gson.fromJson(result, TabModel.class);
                titles = tabModel.getData().getChannels();
                mAdapter.setTitles(titles);
                int size = titles.size();
                List<Fragment> data = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        HomeItemFragmentOne fragmentOne = new HomeItemFragmentOne();
                        Bundle args = new Bundle();
                        args.putInt("id",titles.get(i).getId());
                        fragmentOne.setArguments(args);
                        data.add(fragmentOne);
                    }else {
                        HomeItemFragment fragment = new HomeItemFragment();
                        Bundle args = new Bundle();
                        args.putInt("id",titles.get(i).getId());
                        fragment.setArguments(args);
                        data.add(fragment);
                    }
                }
                mAdapter.upData(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });

    }
    private View pop;
    private PopupWindow  popupWindow ;
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (pop == null) {
            pop = LayoutInflater.from(getActivity()).inflate(R.layout.home_popupwindow, null);
        }
        setpopView(pop);
        if (popupWindow ==null) {
            popupWindow = new PopupWindow(pop);
        }
        if (isChecked) {
            if (!popupWindow.isShowing()) {
                Toast.makeText(getActivity(), "展开", Toast.LENGTH_SHORT).show();
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int widthPixels = displayMetrics.widthPixels;
                int heightPixels = displayMetrics.heightPixels;
                popupWindow.setWidth(widthPixels);
                popupWindow.setHeight(heightPixels/3);
                popupWindow.setAnimationStyle(R.style.home_popup);
                popupWindow.showAsDropDown(mTablayout);
            }
        }else if(!isChecked){
            popupWindow.dismiss();
        }
    }

    private void setpopView(View pop) {
        mChannel = ((GridView) pop.findViewById(R.id.home_popupwindow_channel));
        mChannel.setOnItemClickListener(this);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            String name = titles.get(i).getName();
            list.add(name);
        }
        mChannel.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mViewPager.setCurrentItem(position);
        popupWindow.dismiss();
    }
}
