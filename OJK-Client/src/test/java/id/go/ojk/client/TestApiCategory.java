package id.go.ojk.client;

import id.go.ojk.client.constant.EApiUsageCategory;
import id.go.ojk.client.constant.EReportApiUsage;
import org.junit.Test;
import org.junit.Assert;

public class TestApiCategory {

    private final EApiUsageCategory noneCategory = EReportApiUsage.getApiCategoryUsage("");
    private final EApiUsageCategory loginCategory = EReportApiUsage.getApiCategoryUsage("RBDPK");
    private final EApiUsageCategory allCategory = EReportApiUsage.getApiCategoryUsage("LABPTK");

    @Test
    public void testNoneCategory() {
        Assert.assertSame(EApiUsageCategory.NONE, noneCategory);
    }

    @Test
    public void testLoginCategory() {
        Assert.assertSame(EApiUsageCategory.LOGIN, loginCategory);
    }

    @Test
    public void testAllCategory() {
        Assert.assertSame(EApiUsageCategory.ALL, allCategory);
    }

}
