package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";

    private Vacancy getV(Element element) {
        Vacancy vacancy = new Vacancy();

        String title = element.getElementsByClass("title").text();
        String salary = element.getElementsByClass("salary").text();
        String city = element.getElementsByClass("location").text();
        String companyName = element.getElementsByClass("company_name").text();
        String siteName = URL_FORMAT;
        String url = "https://moikrug.ru" + element.getElementsByClass("title").select("a").attr("href");

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
                Elements elements = document.getElementsByClass("job");
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
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")
                .referrer("")
                .get();
    }
}
