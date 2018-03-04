package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";

    private Vacancy getV(Element element) {
        Vacancy vacancy = new Vacancy();

        String title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
        String salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
        String city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
        String companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
        String siteName = URL_FORMAT;
      //  String url = element.select("a").attr("href");
        String url = element.getElementsByClass("vacancy-serp-item__title").select("a").attr("href");

        vacancy.setTitle(title);
        if (salary == null || salary.length() == 0) vacancy.setSalary("");
            else vacancy.setSalary(salary);
        vacancy.setCity(city);
        vacancy.setCompanyName(companyName);
        vacancy.setSiteName(siteName);
        vacancy.setUrl(url);
        return vacancy;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();
        int page = 0;
        while (true) {
            try {
                Document document = getDocument(searchString, page++);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) break;
                for (Element element : elements) {
                    list.add(getV(element));
                }
            } catch (IOException e) {
            }
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                //.proxy("223.254.254.9", 3128)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")
                .referrer("")
                .get();
    }
}
