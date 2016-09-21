package com.example.administrator.liwushuo.model.classifymodel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class StrtegyHead {
    /**
     * code : 200
     * data : {"columns":[{"author":"资优生","banner_image_url":"http://img02.liwushuo.com/image/160608/okz87zmtn.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/okz87zmtn.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/d4vtwm69h.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/d4vtwm69h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501863,"description":"完美卸妆的正确步骤，每片面膜的成分功效，这里都知道。","id":21,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"更新至第67期","title":"完美护肤指南","updated_at":1472226660},{"author":"Dr.Bag","banner_image_url":"http://img03.liwushuo.com/image/160608/0gc251s33.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/0gc251s33.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501739,"description":"没有什么是一个包包解决不了的，如果有，那就两个。","id":16,"order":0,"post_published_at":1472202000,"status":0,"subtitle":"更新至第56期","title":"包治百病","updated_at":1472211605},{"author":"灰姑娘","banner_image_url":"http://img02.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1472007600,"status":0,"subtitle":"更新至第59期","title":"靠脸吃饭","updated_at":1472208565},{"author":"鹿欧尼","banner_image_url":"http://img01.liwushuo.com/image/160630/npssjj3yc.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img03.liwushuo.com/image/160713/l0nb4kpud.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467265951,"description":"无论是山珍海味还是街边小吃，\r\n无论是飞禽走兽还是五谷香料，\r\n美食不分贵贱没有国界\r\n我们都犯着一种罪，叫做\u201c食宗最\u201d","id":83,"order":0,"post_published_at":1472256000,"status":0,"subtitle":"","title":"吃货俱乐部","updated_at":1472208410},{"author":"小礼君","banner_image_url":"http://img03.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501381,"description":"如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？","id":5,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"","title":"不打烊的礼物店","updated_at":1472208293},{"author":"lazy宝宝","banner_image_url":"http://img01.liwushuo.com/image/160608/vbhuxvg2v.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/vbhuxvg2v.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img02.liwushuo.com/image/160713/7q5f167fe.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/7q5f167fe.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501575,"description":"给我一篇文章的时间，告诉你不再费心搭配的秘密，每天1分钟搞定完美穿搭。","id":9,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"更新至第100期","title":"懒人穿搭术","updated_at":1472205564},{"author":"爱因烧钱","banner_image_url":"http://img01.liwushuo.com/image/160608/17r75edcn.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/17r75edcn.jpg?imageView2/2/w/300/q/85/format/webp","category":"数码","cover_image_url":"http://img02.liwushuo.com/image/160713/4bbshlkvr.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/4bbshlkvr.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501635,"description":"爱科技爱创新爱开放源码，要智能要有范要异军突起。不止于全息影像虚拟现实，数码控们不要最贵只要Geek！","id":11,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"更新至第71期","title":"数码家","updated_at":1472202232},{"author":"Miss. talk ","banner_image_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462771521,"description":"同一件事，你怎么想，他怎么看，平行生活里的你我他，也许正经历同样的情绪，分享着类似的槽点，不管你是围观的吃瓜群众，还是森森被困扰的当事人甲，在shall we talk里，和Miss. talk一起聚众吐槽吧~  ","id":24,"order":0,"post_published_at":1472299200,"status":0,"subtitle":"更新至第113期","title":"Shall we talk","updated_at":1472201942},{"author":"美物娘","banner_image_url":"http://img01.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1472169600,"status":0,"subtitle":"更新至第82期","title":"美物收割机","updated_at":1472201922},{"author":"凹凸曼","banner_image_url":"http://img01.liwushuo.com/image/160708/or81k6fea.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160708/or81k6fea.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160720/xdt9kjriy.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160720/xdt9kjriy.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467970933,"description":"会买不一定\u201c惠\u201d买，每日10款超低价，举双手奉上。\u2014\u2014from亚马逊良心出品","id":90,"order":0,"post_published_at":1472256000,"status":0,"subtitle":"更新至第49期","title":"省钱大总攻","updated_at":1472201237},{"author":"淘局长","banner_image_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg?imageView2/2/w/300/q/85/format/webp","category":"海淘","cover_image_url":"http://img02.liwushuo.com/image/160713/5cbekga4c.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/5cbekga4c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462500836,"description":"你想要的全世界，我都有！","id":3,"order":0,"post_published_at":1472029200,"status":0,"subtitle":"更新至第67期","title":"海淘情报局","updated_at":1472201010}],"paging":{"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}}
     * message : OK
     */

    private int code;
    /**
     * columns : [{"author":"资优生","banner_image_url":"http://img02.liwushuo.com/image/160608/okz87zmtn.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/okz87zmtn.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/d4vtwm69h.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/d4vtwm69h.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501863,"description":"完美卸妆的正确步骤，每片面膜的成分功效，这里都知道。","id":21,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"更新至第67期","title":"完美护肤指南","updated_at":1472226660},{"author":"Dr.Bag","banner_image_url":"http://img03.liwushuo.com/image/160608/0gc251s33.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/0gc251s33.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/u0me31re7.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501739,"description":"没有什么是一个包包解决不了的，如果有，那就两个。","id":16,"order":0,"post_published_at":1472202000,"status":0,"subtitle":"更新至第56期","title":"包治百病","updated_at":1472211605},{"author":"灰姑娘","banner_image_url":"http://img02.liwushuo.com/image/160608/qojypq4pe.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/qojypq4pe.jpg?imageView2/2/w/300/q/85/format/webp","category":"美护","cover_image_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/en5n83z34.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501946,"description":"好看就行。\u2014\u2014玛丽莲·赫本·千颂伊","id":23,"order":0,"post_published_at":1472007600,"status":0,"subtitle":"更新至第59期","title":"靠脸吃饭","updated_at":1472208565},{"author":"鹿欧尼","banner_image_url":"http://img01.liwushuo.com/image/160630/npssjj3yc.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160630/npssjj3yc.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img03.liwushuo.com/image/160713/l0nb4kpud.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/l0nb4kpud.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467265951,"description":"无论是山珍海味还是街边小吃，\r\n无论是飞禽走兽还是五谷香料，\r\n美食不分贵贱没有国界\r\n我们都犯着一种罪，叫做\u201c食宗最\u201d","id":83,"order":0,"post_published_at":1472256000,"status":0,"subtitle":"","title":"吃货俱乐部","updated_at":1472208410},{"author":"小礼君","banner_image_url":"http://img03.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501381,"description":"如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？","id":5,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"","title":"不打烊的礼物店","updated_at":1472208293},{"author":"lazy宝宝","banner_image_url":"http://img01.liwushuo.com/image/160608/vbhuxvg2v.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/vbhuxvg2v.jpg?imageView2/2/w/300/q/85/format/webp","category":"穿搭","cover_image_url":"http://img02.liwushuo.com/image/160713/7q5f167fe.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/7q5f167fe.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501575,"description":"给我一篇文章的时间，告诉你不再费心搭配的秘密，每天1分钟搞定完美穿搭。","id":9,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"更新至第100期","title":"懒人穿搭术","updated_at":1472205564},{"author":"爱因烧钱","banner_image_url":"http://img01.liwushuo.com/image/160608/17r75edcn.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/17r75edcn.jpg?imageView2/2/w/300/q/85/format/webp","category":"数码","cover_image_url":"http://img02.liwushuo.com/image/160713/4bbshlkvr.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/4bbshlkvr.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501635,"description":"爱科技爱创新爱开放源码，要智能要有范要异军突起。不止于全息影像虚拟现实，数码控们不要最贵只要Geek！","id":11,"order":0,"post_published_at":1472266800,"status":0,"subtitle":"更新至第71期","title":"数码家","updated_at":1472202232},{"author":"Miss. talk ","banner_image_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160712/3c1fj1dq6.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462771521,"description":"同一件事，你怎么想，他怎么看，平行生活里的你我他，也许正经历同样的情绪，分享着类似的槽点，不管你是围观的吃瓜群众，还是森森被困扰的当事人甲，在shall we talk里，和Miss. talk一起聚众吐槽吧~  ","id":24,"order":0,"post_published_at":1472299200,"status":0,"subtitle":"更新至第113期","title":"Shall we talk","updated_at":1472201942},{"author":"美物娘","banner_image_url":"http://img01.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1472169600,"status":0,"subtitle":"更新至第82期","title":"美物收割机","updated_at":1472201922},{"author":"凹凸曼","banner_image_url":"http://img01.liwushuo.com/image/160708/or81k6fea.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160708/or81k6fea.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img02.liwushuo.com/image/160720/xdt9kjriy.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160720/xdt9kjriy.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467970933,"description":"会买不一定\u201c惠\u201d买，每日10款超低价，举双手奉上。\u2014\u2014from亚马逊良心出品","id":90,"order":0,"post_published_at":1472256000,"status":0,"subtitle":"更新至第49期","title":"省钱大总攻","updated_at":1472201237},{"author":"淘局长","banner_image_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/rcmok6bpq.jpg?imageView2/2/w/300/q/85/format/webp","category":"海淘","cover_image_url":"http://img02.liwushuo.com/image/160713/5cbekga4c.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/5cbekga4c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462500836,"description":"你想要的全世界，我都有！","id":3,"order":0,"post_published_at":1472029200,"status":0,"subtitle":"更新至第67期","title":"海淘情报局","updated_at":1472201010}]
     * paging : {"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}
     */

    private DataEntity data;
    private String message;

    public static StrtegyHead objectFromData(String str) {

        return new Gson().fromJson(str, StrtegyHead.class);
    }

    public static StrtegyHead objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), StrtegyHead.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<StrtegyHead> arrayWanMeiBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<StrtegyHead>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<StrtegyHead> arrayWanMeiBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<StrtegyHead>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataEntity {
        /**
         * next_url : http://api.liwushuo.com/v2/columns?limit=11&offset=11
         */

        private PagingEntity paging;
        /**
         * author : 资优生
         * banner_image_url : http://img02.liwushuo.com/image/160608/okz87zmtn.jpg-w300
         * banner_webp_url : http://img02.liwushuo.com/image/160608/okz87zmtn.jpg?imageView2/2/w/300/q/85/format/webp
         * category : 美护
         * cover_image_url : http://img01.liwushuo.com/image/160713/d4vtwm69h.jpg-w720
         * cover_webp_url : http://img01.liwushuo.com/image/160713/d4vtwm69h.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1462501863
         * description : 完美卸妆的正确步骤，每片面膜的成分功效，这里都知道。
         * id : 21
         * order : 0
         * post_published_at : 1472266800
         * status : 0
         * subtitle : 更新至第67期
         * title : 完美护肤指南
         * updated_at : 1472226660
         */

        private List<ColumnsEntity> columns;

        public static DataEntity objectFromData(String str) {

            return new Gson().fromJson(str, DataEntity.class);
        }

        public static DataEntity objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataEntity.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataEntity> arrayDataEntityFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataEntity>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataEntity> arrayDataEntityFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataEntity>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public PagingEntity getPaging() {
            return paging;
        }

        public void setPaging(PagingEntity paging) {
            this.paging = paging;
        }

        public List<ColumnsEntity> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsEntity> columns) {
            this.columns = columns;
        }

        public static class PagingEntity {
            private String next_url;

            public static PagingEntity objectFromData(String str) {

                return new Gson().fromJson(str, PagingEntity.class);
            }

            public static PagingEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), PagingEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<PagingEntity> arrayPagingEntityFromData(String str) {

                Type listType = new TypeToken<ArrayList<PagingEntity>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<PagingEntity> arrayPagingEntityFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<PagingEntity>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ColumnsEntity {
            private String author;
            private String banner_image_url;
            private String banner_webp_url;
            private String category;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private int id;
            private int order;
            private int post_published_at;
            private int status;
            private String subtitle;
            private String title;
            private int updated_at;

            public static ColumnsEntity objectFromData(String str) {

                return new Gson().fromJson(str, ColumnsEntity.class);
            }

            public static ColumnsEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ColumnsEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ColumnsEntity> arrayColumnsEntityFromData(String str) {

                Type listType = new TypeToken<ArrayList<ColumnsEntity>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ColumnsEntity> arrayColumnsEntityFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ColumnsEntity>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getBanner_webp_url() {
                return banner_webp_url;
            }

            public void setBanner_webp_url(String banner_webp_url) {
                this.banner_webp_url = banner_webp_url;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPost_published_at() {
                return post_published_at;
            }

            public void setPost_published_at(int post_published_at) {
                this.post_published_at = post_published_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }

}
