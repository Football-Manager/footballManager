package com.remi.footballmanager.scrapper;

import org.jsoup.nodes.Element;

public class ScrapperUtil {
    public static Integer getIntegerFromElement(Element element){
        return Integer.valueOf(element.childNode(0).toString());
    }

    public static String getStringFromElement(Element element) {
        return element.childNode(0).toString();
    }
}
