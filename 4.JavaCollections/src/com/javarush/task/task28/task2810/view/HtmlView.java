package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    //private final String filePath =  "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";
    private final String filePath =  "D:\\Projects\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task28\\task2810\\view\\vacancies.html";

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document;
        try {
            document = getDocument();
            Element tempFile = document.getElementsByClass("template").first();
            Element temp = tempFile.clone();
            temp.removeClass("template");
            temp.removeAttr("style");
            document.select("tr[class=vacancy]").remove();
            for (Vacancy vacancy : vacancies) {
                Element ttemp = temp.clone();
                ttemp.getElementsByClass("city").first().text(vacancy.getCity());
                ttemp.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                ttemp.getElementsByClass("salary").first().text(vacancy.getSalary());
                ttemp.select("a").attr("href", vacancy.getUrl());
                ttemp.select("a").first().text(vacancy.getTitle());
                tempFile.before(ttemp);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.toString();
    }

    private void updateFile(String document) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)))) {
            bw.write(document);
        } catch (IOException e) {
        }
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        String doc = getUpdatedFileContent(vacancies);
        updateFile(doc);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Нижний Новгород");
    }
}
