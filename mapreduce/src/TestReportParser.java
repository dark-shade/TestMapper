// Standalone code to parse html code coverage report
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.PrintWriter;


public class TestReportParser {
    //public void reportParser(){
    public static void main(String[] args){
        try {
            String finalData = "";

            File[] reportFiles = new File("TestReports").listFiles();

            for(File input: reportFiles) {
                if (input.isFile()) {
                    Document doc = Jsoup.parse(input, "UTF-8", "");

                    Elements lineNosFC = doc.select("b.fc");
                    for (Element lineNo : lineNosFC) {
                        finalData = finalData + " " + removeExt(input.getName()) + "-" + lineNo.child(0).childNode(0).toString();
                    }

                    Elements lineNosPC = doc.select("b.pc");
                    for (Element lineNo : lineNosPC) {
                        finalData = finalData + " " + removeExt(input.getName()) + "-" + lineNo.child(0).childNode(0).toString();
                    }
                }
            }

            PrintWriter writer = new PrintWriter("input/input.txt", "UTF-8");
            writer.println(finalData);
            writer.close();
        }
        catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public static String removeExt(String s) {
        int pos = s.lastIndexOf(".");
        if (pos == -1) return s;
        return s.substring(0, pos);
    }
}
