package pages;

import com.microsoft.playwright.Page;

public class ComparePage {

    Page page;

    public ComparePage(Page page) {
        this.page = page;
    }

    private String compareBtn = "input[value='Add to compare list']";
    private String compareLink = "text=product comparison";
    private String compareTable = ".compare-products-table";

    public void addProductsToCompare() {


        page.locator(".product-title a").first().click();

        page.waitForSelector("h1");

        page.getByText("Add to compare list").click();

        page.goBack();
        page.waitForSelector(".product-title");

   
        page.locator(".product-title a").nth(1).click();

        page.waitForSelector("h1");

        page.getByText("Add to compare list").click();
    }

    public void openComparePage() {

        page.locator("a[href='/compareproducts']").click();

      
        page.waitForSelector(".compare-products-table");
    }

    public boolean isCompareTableVisible() {
        return page.locator(compareTable).isVisible();
    }
}