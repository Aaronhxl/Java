package com.hellobike.es.entiry;

/**
 * Package: com.hellobike.es.entiry
 * Description： Article的实体类
 * Author: huanglong
 * Date: Created in 2019/6/25 16:34
 * Version: 0.0.1
 */

public class Article {

    private long id;
    private String title;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
