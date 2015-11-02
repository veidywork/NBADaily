package com.nbadaily_api.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : JsoupFactory
 * @Create Date  : 2015/11/2  16:15
 */
public class JsoupFactory {

    private static JsoupFactory mInstance;

    public static synchronized JsoupFactory getInstance() {
        if (mInstance == null) {
            mInstance = new JsoupFactory();
        }
        return mInstance;
    }

    /**
     * 解析和遍历一个HTML文档
     *
     * @param html
     * @return
     */
    public Document getHtmlData(String html) {

        Document doc = Jsoup.parse(html);


        return doc;
    }

    /**
     * 解析一个body片断
     *
     * @param html
     * @return
     */
    public Element getBodyFrament(String html) {
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();

        return body;
    }

    /**
     * 从一个URL加载一个Document
     *
     * @param url
     * @return
     */
    public Document getDocument(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        return doc;
    }

    public void getListLinks() {

    }

    /**
     * 从一个URL加载一个Document
     *
     * @return
     */
    public Elements getDiv(String classname, String tag) {
        Elements links = null;
        Document doc  = getDocument(classname);
        if (null!=doc) {
            String  itemTag = "div[class="+tag+"]";
            links=  doc.select(itemTag);
        }
        return links;
    }

    private Elements getById(String id,Document document){
        Elements links = null;
        if (null!=document) {
            String  itemTag = "form[id="+id+"]";
            links = document.select(itemTag);
        }
        return links;
    }
}
