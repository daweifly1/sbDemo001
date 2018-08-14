package com.devi;

import org.apache.commons.lang.StringUtils;

/**
 * Created by hzchendawei on 2018/4/12.
 */
public class BBTest {

    private static final String key = "f3wEtRrV6q0=";

    private static final String sepator = "_______";

    public static void main(String[] args) {

        String ss = "<dubbo:reference interface=\"com.netease.health.facade.msconfig.MSConfigParamTabFacade\"id=\"mSConfigParamTabFacadeImpl\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\ty\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.wapmapping.WapUrlMappingServiceFacade\"id=\"wapUrlMappingServiceFacadeImpl\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\ty\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.frontpage.OnlineNoticeServiceFacade\"\tid=\"onlineNoticeServiceFacade\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"rebuildCacheFacade\" interface=\"com.netease.haitao.cache.facade.RebuildCacheFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.cacheindex.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"searchPharseServiceFacade\" interface=\"com.netease.health.facade.SearchPharseServiceFacade\"\tversion=\"1.1\" group=\"#{disconfPropertiesReader['dubbo.online.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"brandRecommendServiceFacade\"\tinterface=\"com.netease.health.facade.brandrecommend.BrandRecommendServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"nationalRecommendServiceFacade\"interface=\"com.netease.health.facade.nationalrecommend.NationalRecommendServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"categoryTabServiceFacade\"interface=\"com.netease.health.facade.category.CategoryTabServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"nameValueServiceFacade\" interface=\"com.netease.health.facade.NameValueServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/> y\n" +
                "\n" +
                "<dubbo:reference id=\"nameValueFacadeImpl\" interface=\"com.netease.health.facade.NameValueFacade\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\\\n" +
                "\n" +
                "<dubbo:reference id=\"evaluationSwitchServiceFacadeImpl\"interface=\"com.netease.health.facade.EvaluationSwitchServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\ty\n" +
                "\n" +
                "<dubbo:reference id=\"searchHotlistsServiceFacadeImpl\"interface=\"com.netease.health.facade.SearchHotlistsServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.giftbag.GiftBagServiceFacade\" id=\"giftBagServiceFacadeImpl\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.giftbag.GiftBagOptimizationServiceFacade\"\tid=\"giftBagOptimizationServiceFacade\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/> y\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.giftbag.GiftBagOuterDispatchCfgServiceFacade\"id=\"giftBagOuterDispatchCfgServiceFacadeImpl\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\\\n" +
                "\n" +
                "<dubbo:reference id=\"msAdServiceFacade\" interface=\"com.netease.health.facade.MsAdServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>  y\n" +
                "\n" +
                "<dubbo:reference id=\"appBottomNavigationServiceFacadeImpl\"\tinterface=\"com.netease.health.facade.AppBottomNavigationServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"shoppingCartGuideServiceFacadeImpl\"\tinterface=\"com.netease.health.facade.ShoppingCartGuideServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/> y\n" +
                "\n" +
                "<dubbo:reference id=\"springModuleServiceFacadeImpl\" interface=\"com.netease.health.facade.SpringModuleServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\t?\n" +
                "\n" +
                "<dubbo:reference id=\"guidanceServiceFacade\" interface=\"com.netease.health.facade.guidance.GuidanceServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\t?\n" +
                "\n" +
                "<dubbo:reference id=\"appRecommendServiceFacade\" interface=\"com.netease.health.facade.AppRecommendServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"goodsSampleServiceFacade\" interface=\"com.netease.health.facade.GoodsSampleServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.online.group']}\"/> y\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.attractInvestment.AttractInvestmentInfoServiceFacade\"id=\"attractInvestmentInfoServiceFacade\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.CountryCodeServiceFacade\" id=\"countryCodeFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.warehouse.WarehouseServiceFacade\" id=\"warehouseFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/>\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.activity.ActivityShowEditServiceFacade\"\tid=\"activityShowEditServiceFacade\" group=\"#{disconfPropertiesReader['dubbo.ms.group']}\"timeout=\"30000\"/>\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.GoodsDetailServiceFacade\" id=\"onlineGoodsDetailServiceFacade\"group=\"#{disconfPropertiesReader['dubbo.online.group']}\"/>\n" +
                "\n" +
                "<dubbo:reference id=\"emailReceiverServiceFacade\" interface=\"com.netease.health.facade.EmailReceiverServiceFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\" timeout=\"30000\"/> y\n" +
                "\n" +
                "<dubbo:reference interface=\"com.netease.health.facade.OperateLogServiceFacade\" id=\"operateLogFacade\"\tgroup=\"#{disconfPropertiesReader['dubbo.ms.group']}\"/>";

        String[] s = ss.split("\n");
        for (String sss : s) {
            if (StringUtils.isNotBlank(sss) && sss.contains("interface")) {
                String s1 = sss.substring(sss.indexOf("interface")+11);
                String s2 = s1.substring(0, s1.indexOf("\""));
                System.out.println(s2);
            }
        }

    }

}
