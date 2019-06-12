package lesson12;

import core.BrowserFactory;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BrowserFactory {
    @Test
    public void search(){
        SearchForm searchForm = new GoogleSearch();
        List<String> result1 = searchForm.search("Jack Sparrow");
        System.out.println(result1);

        searchForm = new BingSearch();
        result1 = searchForm.search("Jack Sparrow");
        System.out.println(result1);
    }
}
