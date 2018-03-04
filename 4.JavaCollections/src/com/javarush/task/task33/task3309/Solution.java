package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);

            String s = writer.toString();
            String reg = "<" + tagName;

            String coment = "<!--" + comment + "-->\n";
            List<String> list = Arrays.asList(s.split("\n"));
            list.set(0, list.get(0).replace("yes", "no"));
            StringBuilder sb = new StringBuilder(list.get(0)).append("\n");
            for (int i = 1; i < list.size(); i++) {
                String ss = list.get(i);

                int f = ss.indexOf(reg);
                if (f >= 0) {
                    sb.append(ss.substring(0, f)).append(coment);
                }

                int n = ss.indexOf(">");
                int k = ss.lastIndexOf("<");
                String sd = "";
                if (k > n) sd = ss.substring(n + 1, k);

                if (!sd.equals("")) {
                    if (sd.matches((".*(&amp;|&lt;|&gt;|'|\").*"))) {
                        sd = sd.replaceAll("&amp;", "&");
                        sd = sd.replaceAll("&lt;", "<");
                        sd = sd.replaceAll("&gt;", ">");
                        sd = "<![CDATA[" + sd + "]]>";
                        ss = ss.substring(0, n + 1) + sd + ss.substring(k);
                    }
                }
                sb.append(ss).append("\n");
            }
            s = sb.toString();
            s = s.replaceAll("<!\\[CDATA\\[<!\\[CDATA\\[", "<![CDATA[");
            s = s.replaceAll("]]>]]>", "]]>");
            return s;
        } catch (JAXBException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        //System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
        //System.out.println(Solution.toXmlWithComment(new FirstSecondObject(), "second", "it's a comment"));
        System.out.println(Solution.toXmlWithComment(new FirstSecondObject2(), "second", "it's a comment"));
    }

    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }

    @XmlRootElement(name = "first")
    public static class FirstSecondObject {
        @XmlElement(name = "second")
        public List<String> seconds = new ArrayList<String>() {
            {
                add("some string");
                add("some string");
            }
        };
    }

    @XmlRootElement(name = "first")
    public static class FirstSecondObject2 {

        @XmlJavaTypeAdapter(XmlAdapterCDATA.class)
        @XmlElement(name = "second")
        public List<String> seconds = new ArrayList<String>() {
            {
                add("<second>");
                add("some string");
            }
        };

        @XmlJavaTypeAdapter(XmlAdapterCDATA.class)
        public String line = "<second>";
    }

    public static class XmlAdapterCDATA extends XmlAdapter<String, String> {
        @Override
        public String marshal(String value) throws Exception {
            return "<![CDATA[" + value + "]]>";
        }
        @Override
        public String unmarshal(String value) throws Exception {
            return value;
        }
    }
}
