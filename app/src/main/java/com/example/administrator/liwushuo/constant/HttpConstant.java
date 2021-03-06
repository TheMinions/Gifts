package com.example.administrator.liwushuo.constant;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class HttpConstant {
//    首页的接口
    public static final String HOME_URL="";
    //首页的tablayout
    public static final String HOME_TABLAYOUT="http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";
    //首页的碎片接口
    public static final String HOME_FRAGMENT="http://api.liwushuo.com/v2/channels/";
    //viewpager
    public static final String HOME_VIEWPAGER="http://api.liwushuo.com/v2/banners";
    //viewpager的跳转
    public static final String HOME_VIEWPAGER_LIST="http://api.liwushuo.com/v2/collections/";
    //横向scroll
    public static final String HOME_SCROLL="http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2";

//    榜单的接口
    public static final String TOPLIST_URL="";
    //榜单的tablayout
    public static final String TOPLIST_TAB="http://api.liwushuo.com/v2/ranks_v2/ranks";
    //榜单的接口VIEWPAGER
    public static final String TOPLIST_FRAGMENT="http://api.liwushuo.com/v2/ranks_v2/ranks/";
    //榜单的二级接口
    public static final String TOPLIST_SKIP_SINGLE="http://api.liwushuo.com/v2/items/";
//    分类的接口
    //攻略
    public static final String CLASSIFY_STRTEGY_HEAD="http://api.liwushuo.com/v2/columns";
    public static final String CLASSIFY_STRTEGY_END="http://api.liwushuo.com/v2/channel_groups/all";
   //单品
    public static final String ONEBRAND="http://api.liwushuo.com/v2/item_categories/tree";

    //搜索
    public static final String SEEKMORE="http://api.liwushuo.com/v2/search/hot_words";

    //    我的的接口
    public static final String MINE_URL="";
}
