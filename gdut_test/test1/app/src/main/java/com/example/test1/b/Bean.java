package com.example.test1.b;

/**
 * @author :yinxiaolong
 * @describe : com.example.test1.b
 * @date :2023/4/15 18:23
 */
public class Bean {
    private int imagineUrl;

    public int getImagineUrl() {
        return imagineUrl;
    }

    public void setImagineUrl(int imagineUrl) {
        this.imagineUrl = imagineUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String name;
    private String price;

    public Bean(int imagineUrl, String name, String price) {
        this.imagineUrl = imagineUrl;
        this.name = name;
        this.price = price;
    }
}
