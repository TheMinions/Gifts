package com.example.administrator.liwushuo.model.homemodel;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class ItemsBean {
    /**
     * avatar_url : http://img01.liwushuo.com/image/160902/pkwjxp8s1.jpg
     * avatar_webp_url : null
     * created_at : 1472785251
     * id : 39
     * nickname : 上上签
     */

    private AuthorBean author;
    /**
     * banner_image_url : http://img02.liwushuo.com/image/160902/9u68tzum1.jpg-w300
     * category : 美物
     * cover_image_url : http://img02.liwushuo.com/image/160902/gsscbi494.jpg-w720
     * created_at : 1472785741
     * description : 把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。
     * id : 96
     * order : 0
     * post_published_at : 1474254000
     * status : 0
     * subtitle :
     * title : 日复一签
     * updated_at : 1474336857
     */

    private ColumnBean column;
    private int content_type;
    private String content_url;
    private String cover_image_url;
    private String cover_webp_url;
    private int created_at;
    private int editor_id;
    private boolean hidden_cover_image;
    private int id;
    private String introduction;
    private boolean liked;
    private int likes_count;
    private Object limit_end_at;
    private int published_at;
    private String share_msg;
    private String short_title;
    private int status;
    private String template;
    private String title;
    private String type;
    private int updated_at;
    private String url;
    private List<?> ad_monitors;
    private List<?> feature_list;
    private List<?> labels;

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public ColumnBean getColumn() {
        return column;
    }

    public void setColumn(ColumnBean column) {
        this.column = column;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
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

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }

    public boolean isHidden_cover_image() {
        return hidden_cover_image;
    }

    public void setHidden_cover_image(boolean hidden_cover_image) {
        this.hidden_cover_image = hidden_cover_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public Object getLimit_end_at() {
        return limit_end_at;
    }

    public void setLimit_end_at(Object limit_end_at) {
        this.limit_end_at = limit_end_at;
    }

    public int getPublished_at() {
        return published_at;
    }

    public void setPublished_at(int published_at) {
        this.published_at = published_at;
    }

    public String getShare_msg() {
        return share_msg;
    }

    public void setShare_msg(String share_msg) {
        this.share_msg = share_msg;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getAd_monitors() {
        return ad_monitors;
    }

    public void setAd_monitors(List<?> ad_monitors) {
        this.ad_monitors = ad_monitors;
    }

    public List<?> getFeature_list() {
        return feature_list;
    }

    public void setFeature_list(List<?> feature_list) {
        this.feature_list = feature_list;
    }

    public List<?> getLabels() {
        return labels;
    }

    public void setLabels(List<?> labels) {
        this.labels = labels;
    }

    public static class AuthorBean {
        private String avatar_url;
        private Object avatar_webp_url;
        private int created_at;
        private int id;
        private String nickname;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public Object getAvatar_webp_url() {
            return avatar_webp_url;
        }

        public void setAvatar_webp_url(Object avatar_webp_url) {
            this.avatar_webp_url = avatar_webp_url;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

    public static class ColumnBean {
        private String banner_image_url;
        private String category;
        private String cover_image_url;
        private int created_at;
        private String description;
        private int id;
        private int order;
        private int post_published_at;
        private int status;
        private String subtitle;
        private String title;
        private int updated_at;

        public String getBanner_image_url() {
            return banner_image_url;
        }

        public void setBanner_image_url(String banner_image_url) {
            this.banner_image_url = banner_image_url;
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
