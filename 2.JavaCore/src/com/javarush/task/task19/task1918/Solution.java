//package com.javarush.task.task19.task1918;
//
///*
//Знакомство с тегами
//*/
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.parser.Parser;
//import org.jsoup.select.Elements;
//
//import java.io.*;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.readLine()));
//        filePath.close();
//        StringBuilder stringBuilder = new StringBuilder();
//        String str;
//        while ((str = bufferedReader.readLine()) != null) {
//            stringBuilder.append(str);
//        }
//        bufferedReader.close();
//        Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
//        Elements elements = document.getElementsByTag(args[0]);
//        for (Element element:elements) {
//            System.out.println(element);
//        }
//    }
//}
