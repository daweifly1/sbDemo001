//package com.devi.txt;
//
//import com.devi.tool.util.FastJsonUtil;
//import org.apache.commons.lang.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.BufferedWriter;
//import java.io.FileOutputStream;
//import java.io.OutputStreamWriter;
//import java.net.URL;
//import java.util.List;
//
//public class XgEmails {
//
//    public static void main(String[] args) throws Exception {
//        String emailsJson="[{\n" +
//                "\t\"id\": \"137edd6c9d565ee87e185674510aa442\",\n" +
//                "\t\"name\": \"徐工集团\",\n" +
//                "\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapk@xcmg.com\",\n" +
//                "\t\"ou\": [{\n" +
//                "\t\t\t\"id\": \"137eddc3c2e8ecabdfcdf2347edb2851\",\n" +
//                "\t\t\t\"name\": \"集团领导\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0shyvuxdegwulgisjkgxhgujiyvrhf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c4d79a1cc2d38a04643b00b2\",\n" +
//                "\t\t\t\"name\": \"集团本部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0ugxmtgrffjvetydikawutuikqeshf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25a91230ec3b33d54fadbc4d7\",\n" +
//                "\t\t\t\t\t\"name\": \"武装保卫部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkrdzrjjoqhfjumttgkkxidguukugxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25a9cc18603515934d0b9065e\",\n" +
//                "\t\t\t\t\t\"name\": \"国际战略部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejk3dzfuiyywqjkirvzjkngqemimwvhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25b925ef63b5fe7a419ead520\",\n" +
//                "\t\t\t\t\t\"name\": \"资产财务综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkzezskvriwtuklihxtkmrzhtvivsqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"141ac0b4c7aca5085b059ee419facb28\",\n" +
//                "\t\t\t\t\t\"name\": \"品牌与文化发展部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruitvfqeku4xdftkaqyvuimvzhvk2rzitujesyhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c3d5392f6f2d90b4797b67b0\",\n" +
//                "\t\t\t\"name\": \"徐工机械本部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0tgvjmcsiwwjbgzqukaxzxulkxeqhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25b96e9c86dac4c841c8aa965\",\n" +
//                "\t\t\t\t\t\"name\": \"审计督查研究室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkzezwvmrfywvtffufmk0rfyttizwvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25c8f79fb3094408455e978e8\",\n" +
//                "\t\t\t\t\t\"name\": \"证券部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejk3fyilmtietimauuqmk2vvhmlkyhyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25c85fefe2ae8b6547568218e\",\n" +
//                "\t\t\t\t\t\"name\": \"战略规划部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkrfyvwv1ihstvkyewkkaxvwmjmryhhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"163b4442356c1a158be0b7243a09892c\",\n" +
//                "\t\t\t\t\t\t\"name\": \"铸造公司项目组\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwjuquuujj2vwfitqrvyuvcqexjkktdqmmmzsfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25d856ba7c87654747998720e\",\n" +
//                "\t\t\t\t\t\"name\": \"财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkbgyvluvdxfmliwvulkqxzzmlmsqhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25d814c4748de6be4ddab954d\",\n" +
//                "\t\t\t\t\t\"name\": \"科技质量部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkrgyrkuauxumvnhwevkxggdummvughf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25d833f5414f2ac34700bab2a\",\n" +
//                "\t\t\t\t\t\"name\": \"经营管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkjgytjwavurkwosdfjkqxqqutnesdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab260778a73dbdc93f45689e246\",\n" +
//                "\t\t\t\t\t\"name\": \"安全环保部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvhhdejlqqxxmtextguvbfztwkyvwymvisuwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25e8d15a047a77104f9e8712e\",\n" +
//                "\t\t\t\t\t\"name\": \"市场部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejk3hygikzdqultaxxrikvizhmlmrshhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"13f3b40d82fb5e97df04aef4477acc9b\",\n" +
//                "\t\t\t\t\t\t\"name\": \"营销总公司\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwjbeuqvm4siekvezxgwigudhwkyuxxtunfzehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1466ebbfaf3a23331f975eb42a7a5b9b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"沈阳公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprullxheewtvitdjjqttrwmexvhuk0sdxtknezehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25e8223d81beeaa74685ac048\",\n" +
//                "\t\t\t\t\t\"name\": \"信息化管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkrhysjjrgyruvphddlkywyvtuiquyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"160c07c86c77587b16e6fc94433b76b1\",\n" +
//                "\t\t\t\t\t\t\"name\": \"临时\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwiueqxfmljfxxkmsxerlvowifmkquttulkwerhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25e8b3c4768c45c7445dadabc\",\n" +
//                "\t\t\t\t\t\"name\": \"人力资源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejk3hyejuquxwmumuvflkmuvgtvpdefhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"156b57b50852780704c2433411cb8087\",\n" +
//                "\t\t\t\t\t\t\"name\": \"国际金融管培生\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvlumvxekiiyvslmqqxqkuisutjkerrfumiqyxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25f7d85e97b7c82948b2b2cae\",\n" +
//                "\t\t\t\t\t\"name\": \"行政管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkvixgmkrhzxuljfysmkcyesujpfdhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25f76eed324dbd344b7ca0592\",\n" +
//                "\t\t\t\t\t\"name\": \"法务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkzixwvvbgtskvdegtkknexftiivzshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1505f3ec591f19ce1a7a1ad416190ca6\",\n" +
//                "\t\t\t\t\t\"name\": \"军工部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvik3ithuk2zriim1fhrtlfdrdvkirwrmilfdwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15b4bb186c9f8fa884598fd4daca3bfe\",\n" +
//                "\t\t\t\t\t\"name\": \"备件监督管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvukdeermlffzimwrdyykkezyivk5gdftjpeihhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab25f701021d4830394125b9e1c\",\n" +
//                "\t\t\t\t\t\"name\": \"集团工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvxhdejkjixqiiesrgkmitqtmkqrsvumnhrfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab260739040986bee24b1f9b6ba\",\n" +
//                "\t\t\t\t\t\"name\": \"集团纪委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvhhdejliqxtmiauqzmlhehhjknerimuowedhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eeab26073a5eed01a5c94df080975\",\n" +
//                "\t\t\t\t\t\"name\": \"集团团委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvhhdejlyqxttkxhhgiindvfmkdgiqmiizxvhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"15c6179dc9edca4d8fd4f834766aa454\",\n" +
//                "\t\t\t\"name\": \"徐工起重机械事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvulqrxzvu4zhgutcugywvkuiyjkyxwwttiuvuhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137ef252d595e7f0a0f8bb74821931ab\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工建机(履带吊)\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvyvzvvlfiqdiwoyeelkyysrmjordehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d59c488a6ea023441ba99c5e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvevzfkm0ydwvtaqstkk4redmmnfvhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d59f964e04f96504c57a1796\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带财务管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvmvzimlcuhqkwazwvikzfvxtiixzwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d68ed62223fb4f64d5f9f309\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带成品分厂--停用\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvewyhvlisssjwfeuilkngvimwitqzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d688ec8646234a34fc4b1e0d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvywyyvuaywuljmtudjktifuuinhqghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d68a0313c3435614c11a81d8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvuwydijmrtfjkitvwikjfrrtmkrgyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1422ad5ddb0dd039f035b914c349547a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带新产业开发部-停用\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprujjddgvvvfeqgviutziijkvezikzftumkmuxdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d873d46984f6de44314b6e9b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带起重机营销公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvayxtvkawzykwgwghkkatruulnhzehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef252d97de9d45417cf24f7fbe134\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"履带销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjv2zxgvmrguvkigxfijkvixiuvirtuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13874c09f531a524c0cd3834fff8ad17\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"履带营销公司综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmlkufqmwyvtrtkusufiujgtyjkxiiimtjgrxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1531d07ca166b877de0d2614e2b8d773\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"履带资产管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjizgqxutarwwummxxgvijgswikfhsemvixxthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d9780e3dbd64b2e492d957b9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带客户服务中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvqzxyivgtgevlkuesvk2zsgmkkxezhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d978650e6008f2a42d5a5846\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvqzxylkcqhwiikyistk0sgvtkiyuwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252da7f23698d416f640c48f2ec\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带品质控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvvdxijjawzyvkerwilkcqfumwoshfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252db670cfc1d39a66468cbe752\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带工程制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvrewxiutifrvjczdwlkuwyfuvixvshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14543df6800658b0ba87ac54ce1b4fbf\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带采购部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukkgtgilmiqqwkmneqetmoxdfkkdfhrukpieihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252db68d034da7e46f4d0e87cdb\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带涂装分厂--停用\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvbewyvi2tugtlbhuwwkvgqhmlpfgehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14309a3650d83bd30bfcf6140e8bbf8c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带法务与风险控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprujiszdtlkkqgyjubgtquwlfiwikcqhyuuniyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14544252836953a3bcd6aa746999e32b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带安全环保部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukkausvjmytwzkjndteuvowddlkywzzmvmtsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15dcfe74e0debe1239be3d74099be6cf\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvutihxkvwqghuvirstmunhtglkqqzzuvowfihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef252d873256845d4713494f979e6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"履带产品技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvqyxtjkiwyukviuxrjk2zuimlkzhwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef252d8727fe70e1b62a4c8191712\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"履带工艺技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjviyxslwzhxqvijewstkzfyrmiixrshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef252d78a992f5be864244aa9cbb9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"履带技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjv2xydmmssivuvaywujk4uddmuleezhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eddc3c5d8ce4fe4247c64b83b85e7\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工重型\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0vgyuvguihkjeuxflkbeytumkvhxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138feff401ff1f07f4475514b049a3a4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwhhiikioriiiweqxikkixvvikzequmtktduhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09141c0820292e83e147ff9d06e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型党政工作部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikcrfqmjqqszjvmythikoxiimvmqwhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09145a1ed96106a98246d993c3e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikkvdrvvazwrilbdzyjk0wgzmjnfthhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef0913fd9e6abc30cba941139678d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型人力资源与管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijligzvlpdefjipfedmkirrtmlmxyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09144b1d654dc870344902960f8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikcuervlmvugumaxqtkkizqsmlkqiyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09145a89361899a522468a9b171\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型经营计划部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzik0vdymjywrymmbdvsjkmwydmuirxrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15084299eb4ea85d763535241989e7c6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型预算计划部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvimyuszmvneuhtmsvgxljavtvjkyrzymvkxfwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09140cb12bd19f2a934f638b379\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型品质控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikoqfeijlegrmwksdzjkbiwtmuitxzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09141c7953eb4d0b424c9aa4423\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型信息化管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzik0rfxmkgthekvcqeujknfzdtkiusthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138b67eb4c341a81412adb64f74a973f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型监察部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmuewxhukzftuitiyruijhdgelkzixutmmxtihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09142bbf3ee4b9c5a04079b33fa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型纪委\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikwseewjthhuumffvdikqqxzujotidhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09141c40e09485ff914415b08f0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型工会\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqziksrfuivqqzumkliizikaurvuikyiqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09142bebfa27be8d194e79b5825\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型团委\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikgsehuwrdsxuvkygrmkrhxzukiysvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09140c5064cd39610e4dc089bd2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型武装保卫部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikcqfvil4ufgjmiwrqvktgfqmmlegshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09133148801ba79efe403e85126\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型营销公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijatrumm2qretlozhivkuqthmkirswhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138ffc70b9d3d1b8036858f4a0abeff9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型营销公司领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwdifxiuszgtvijeyqjlayvywkvdqduvliizhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138ffe540733e5d5083c21d4a978f6d7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwdihvkiyxttvkrgvqmjbfsrvkbdzxmwkwgxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138ffe574388623450bb3d44983b7555\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwlihvlkatyyljatuviufetgkkqzytulivvvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138ffe776c472566050cea743bbbe523\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型融资业务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwlihxllrfuxjkiwwqkipfhdlkwteeuvivsthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138ffe806865d39d6ee9dab46b0807db\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型经销商管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwdihyilqywvvj0zgwvvgzgdukcweqmioxgehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1564a7d0596470b5ad12a0d4089b6860\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型客户发展部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvlkvdxgikizwulivevdvicsdqvkaqyzuliywqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138ffe9413739e391e4c65444cfb2d3c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型军品部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwtihzkiytxtmvitzrvkbfwvkkgufiujngtfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1564aa374f9b31dab906e9549e6894d3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型港口机械销售部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvlklddtlk3izejipgdemikwhzkkszhwmmkugthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1564aa43b0fc6b4125f51124e5f9f78c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型电商运营部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvlklddujugqifluiurskwavrrjknhvimwmxyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15e0386d481c1637bf9e20245cda221e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型销售中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvviatywvkmyrfilutxewmbhsqjkovfgtjmsrhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16513123a718c00e5dd3d35472db714c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型营销公司办公室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkiytrsjtixryuicqhvvvktgtkkuxsgulmrufhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09136005bd3f6bbfab48a487b4f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijiwqqkufgtiluheiduksydumlneuihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14c59ce0f560536fc43d98740d0be451\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型海外业务发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruukgzfhiwyvwqkjwwifkjjgzylksqgquviuvrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138ffa635257cbb4f26e8d5475cb3f11\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型法务与风险控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmw1idwjkisvxuufeuijlnhygkkuxvfujjirrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138ffa69d3fb2f0fe2ddc7741dc9cec7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型资产管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwlidwmvgtiejwgqihjvlgfxlk4rgfmulhfxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"146190dfecd30733060946a424da9b7c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型二手车业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruliuzqgwvtfgtilattqliizuwtk2sugtmnexfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef091360c3ae53b090a2436aba3e0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型客服中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij2wqfjtbhvtuiezqdjkutwdutkthqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09134159a2070041bf4cf4bf548\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijyurvmtasqxiieurewkdfiuuwivuyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913aeca13ece3ff53468b8b7eb\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型技术中心领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij5dhfti4thfvjliivjkewyemuoxhehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913dd7a0b0f67417d45cbae3fe\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijlggxtiveqillaurxvk4vfetvotihhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913edfc33bc6bef3440d5a3abc\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型产品战略规划所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij5hgiujgtefludhitkk0qgvtjpdefhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913ae91ca8d3407d24015b7c23\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型起重机研究一所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij1dhziundygjkeqxgjkqqrvuljfsthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913becce373b6a3994bb79a5ff\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型起重机研究二所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij5ehfuvatxtuljdtzmk1eexmtoviihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913be0fa57e0062bb407ca2516\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型底盘研究一所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijtehqwtevxhiiewseukmqxftjivrwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913bed4abc0b1431348fc8d385\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型底盘研究二所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijxehgkttefquiiutrjkgyifmvityvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913ddeceee522cde7476699594\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型特种起重机研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij5gghuvdhhvjjpfghlkyxwwmmivzuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913ce73ffe1b81e0a4c41af29f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型标准认证研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijlfhxjwdihrumkrhqtkjfurtwmszihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913ce0b50574c2460407082130\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型应用工程研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijtfhqukqqvxkuasuwikaqxqmjirtqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913ede9509ec71212454c9525f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型控制研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzij5hghmk2qzhularsrjk2vufmkmsvihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913fda9dd7c16798b49cda0daf\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型零部件研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijpigdmvngxfilaxzyukozfgtipgdihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913edaf132c7ead2241adab8aa\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型工业设计所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijxhgdwi2tsflvddgsjkordgtuoyddhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"139009aae3fcc72cb9767cc46e08654f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型工程中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmi2qzdtv4tiful4sfemlmwxfukcwhqmlmvuihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef0913ce5767824beca9491bb8326\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型消防车研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijlfhvllaxyskuphfdmkezreumitswhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1443dd4878a661a6f5b3a4f42acb04f3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型军品项目组\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprukjtggumlsydwlindwikuctduwkgsdfuikuithf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1443dd4f6e0678cde09406b415582e0a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型海外产品项目组\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprukjdgguwljhqwlmxfghimauqwukarvvmjnhqdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14df6399ceab84a47e4d3614abaab5c5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型综合档案室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvwywtzmuhhdemkjduxvkjgtwikpdedtukvfvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef091370c76ce0b15d1b401b88553\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型备件公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijmxqflltfhquicvgrukeqremmivvthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef0913fddf02fa1b297f428e99fed\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型工艺技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijhiggwiosidiuaszxwk2syhmmpihghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900ac0063b5c3233e4a1b4dc79da0e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型工艺技术部负责人\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmigqdfii2wtekuytstjvcudruklgfxmvndqhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900ac7c555d683b76c4d0444193411\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型规划工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmi4qdfluavvvvlmytellffugikyuurmjiurrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900acdfcc7262abf15200421f9fedd\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型结构工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmigqdfvwdffxjlwsdewiavsqikmsrimwphgghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900acf3b2c156ae3208aa40e8b713a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型装配工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmiwqdfwj3esfikowdhjjmqydtksqhyulmrtdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900ad2d37a9104d5d521340f99c94c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型工装工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmigqdgjv2txdmimqugkvivsrjk0qizmumzufhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900ad6d0bf65ce901e30c46d6afc5c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型涂装工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmigqdglvwqeilktfhziijhtqukkwgwtwnfvfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900adcd5f5e7bb4bf11dd4100a1a7b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型机加工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmioqdguv0vivvldeeuuwerrgvkyrqqtindxehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13900ade4b65eaf540e64944a458e79a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型工艺管理室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmioqdgvkzewvvtrivuivawuzkkrduvmvmxzdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1546132bd177e784d6f8457480084918\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重型工艺信息室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvklartsuvyrxxvleyuglwiyuvlkayqqmkizryhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16993b3949c2b06d0b2d6eb4aa1b3a33\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型招标办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwmmktetmkczfsuicwgqujfgwhuktddrujjdtthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09137054f9b04e16ba4e279161e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型工程制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijaxqvkwszeqkvmrwetkzhsxmimwrhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"148a02ea6e56e57bfb676bc4f609941a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型精益推进办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumtmqshtlzhvwvkgxeiulmxweukziwqmmmurdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef0913804db2651bb4b64d738d9f2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型设备能源部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijayquvuiswviufeuelkbgxtmvkzishf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef091370098786d14a3f4970bbbf2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型物资管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijixqqmmqxywvicudtwkazxquuleishf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09140c1af3c89ef5c245dfb8333\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型安全环保部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjiqzikkqfrtw0tfymvfivfjkgvgiumittthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef09138055ccd3536d7d4ba797a86\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型采购部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvziqzijyyqvku1fgtkjcwgxvk1edxmljdywhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e694d44288bcec4df0d542b283b65\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型下料分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvivawzuvkausymuhfhfkvniqgkkssesmjjewvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e699c29ff5e78fb9556d49c98005d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviviwzzuj4ziikvuxyiumavvwvkczfzmimqvghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e69a30a3182421775065435081f42\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型底盘分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvivmwzdjibdtrmjyusrllivqwkkqtvqmijiushf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e69a8526345647d8cee042f6a29f5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型总装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvivuwzdmkqswtkkawuxvmhfhhikksiwtjkzivhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e69ac121eb424c0fd3ad4c8390a18\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型零部件分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviv2wzduiesrhukesufiwfgtdvkjfytmijdryhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e69af9d90aa7660335694a759d804\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型涂装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvivuwzdwmzgzqttqxwwijitvwmkjdxvmviyquhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151e69b248c120e81e1a1604f3497f7b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型维修再制造分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvivewzejkcyfrjizhyrvibdrwikzitumlnixehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152877cbe2205e31ff524a44493bf860\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"重型电气分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvjmuxxfuvyssqkvutriwkesudkkauztuwiywqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eddc3c7c492a0c2ba64c4166ad7ec\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工塔机\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjukxfumjfdqfjujdwuukirwwtvoxhfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10522c0932543250d64ff9b5644\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工塔机领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj0sfqmjisvujjevqglktiizukiwuuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1389df468c57677a42d1d83435f9c7a9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmdgiulmrfvxllcxdujvkrgyjk2tvimukxdzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10523c1138ed37e37441f082cfa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj0tfrij4yhgjlbhtxkkcriqmjpfidhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10527bced508e6d09742298b415\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机品质保证部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkjoxefvvivqyvljgqzlkasszmuiurvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14bc98eac0272028e926c2844df957ef\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机信息化管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruuu2zyhtuaqsxjimsyhmjcwfsmk4ugimkoxhihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10523cb352e6a345544b57ac4c4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机营销公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj4tfejk0shwtjauvvkkzevxtukufuhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"154be212e4d4bae3e8a027946e39567a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销公司领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvkurhsrjvsuguutvhthmtiqsxmk0whtmkmwxdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef10525b99a7c5794e184963a0967\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj0vezmt0xfvlmcuhrmkizwttiizwxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef10526be13c4d0106d44799bd1ea\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销服务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj4wehijvfugiieqwgkkaxzzuvorhdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef10528a9128efa1b9e64d0faa0ce\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkjkydzij4yhitifezhlk3gqittoqfhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"160d0400c7bc1ed0139207e4e38849dd\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销市场支持部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwivqquqiu4xefivzgqrjmisqxvkbhtymkozgghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef10525b68be9b29ca804e4f96af2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销出口支持部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkjcvewmuvhzejmdfdyiknhuimlldishf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a17e5985a66147018470f4fc98a8d2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销大客户部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtikxhvmmsvdwliiuxqimauxqwktifzmtkygshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef10528a0c7082ec329c45cba7354\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机营销南区南京代表处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj0ydqulyqysvuitszuk4vfetlitvuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1543823783d9f758d0c9001426885fd4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机法务与资产管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkjiystlmstgzwluvygiuizqqikqswymkliguhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10524cc17e7f1ccff14f52ad717\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkj4uffil3hxiiupfiiikjivstvixrxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"160d8c7735779e54c2679054e1280edf\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机技术中心领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiv0yfxljyvxxmvevufjlixzqkkbhrsmiphgihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13a86a5ff77ed853ee4cc0c4683897cd\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmcwdvwwexxhvmmvthvklffqukqwytmmoxfghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1466430d4d033de158bb9af4fabae6c8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"升降机研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprullautqvkjgqtjvbhrvmufezdwk5idetvkwfyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138acd0617de380cf9d58bd4670b51af\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"技术管理办公室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmttfgqlioxghjmoqfimvevyevkqwxqukordihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a86afc5679ea0e2279eb9475392bb2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机工艺技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttm4wdiukywxzvtsqhsjlozhemkixvtmjleeshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15c7bb1b05151c80f055ac44fd08f2b3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机安全环保部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuldeeruiyvrviuuyqiikgvdfkkdigqmwksethf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10528af062a8022711430aa5608\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机工程制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkjgydiilcsdyijisxrik2tqdtkiwqyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"139715dede1ca2f9ace38654877bf7e4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机钢结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtmlmrvgvvnhrftj3izduvitywkkayxxuwkxhuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1390a303cb7b2b3d40c15d64e62a8e41\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机涂装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmizdtqjufexejustguiuervglkjhwstmjhurhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef10529a55467f718c0d45fcb08f7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机成品分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjirqkjkzdvkk2wxilicyfqvkgvifuikyixhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13966dac5a0df2be70c518f4614b421c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机东北分公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtml4wgdukfdqgwjtehxiuavrywkawruukmsrfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13966e2f018b1138dd049d240f1a51a2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机东北分公司领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmlcwhswi2ryeiietygvieuzgjk0qirtkkrdshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13966dc493f81a908b5335f4c6eb236a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机东北分公司综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmlwwgfkm0tiyitqzqyukattvwkffwhujmtwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13966dcb865b1c51337850042ba8da3d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机东北分公司技术质量部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmlgwgfum2wveiuyvrtjlayvqikgsedmvndtghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13966dbf4b8074e26f29f97429198c63\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机东北分公司生产管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmlgwgewkjeyqlkbhswwjkzizlkiszrmmjfwthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13e16b478e438baca787ab9499289ccf\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtvikweulmbhutmupdfdlmoxdemkqzzsmmpffihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14795dfaf30654a590f6ca446a980cd6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司公司领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulmovgitwitqwkkbdvziwgwfdkkcwdzmilfgwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1436b3deabe99ef2380d8c94189851e9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprujl3etgvt1ehzmvbistmingyfmkqryzmkkrhzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14544647c8e6f7c60cc239247c9909ee\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司技术质量部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukkyuwulusyhwwlzfwquuastzjkkxfzmiozhhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"145448d0cb1ee76ce86b00e4bce89914\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司工程制造部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukkuuygiu3erhvlgwfhmljeqqvkxefhmmizruhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"145446a6a32dc0bf205e4f045248f5e8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司销售服务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukkuuwdltmtsguiteisikfhuiikavsumwkvhyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1456d9c368b5b40361213a74bef8446e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司钢结构车间\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruklngzfjlcyevukiqtwijmrtdlkhehimkmuwhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1626100b28d566d0a75c18c456499950\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机重庆分公司成品车间\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjlarqqujcygvll3gqdlkjfryukyvwummizvqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15438115daa12d5451001884db9857be\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"塔机广信公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkjiyrrkvdddrjvivuviiaqrymktgezmkoxehhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"162412fbd550ecb963c2ab14c0c950a7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机广信公司领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjkersiuvyvvqvuzezwjuosdeik3fqfmkkqdxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15438141f62491e56780d634babad8c3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"塔机广信公司业务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkjiyruiwywsumijhvwlmkqgwjkpedetvkyfthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"13c02ed9963801e73dfff824835a9e10\",\n" +
//                "\t\t\t\"name\": \"徐工铲运机械事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtui4shgmmqwtyiibhxtvwdiiyjkyytvtmjhrqhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"13c0830f70162d32e983a4f45f2970e4\",\n" +
//                "\t\t\t\t\t\"name\": \"铲运机械事业部领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqytqwlaqrwjvmtshmmctduwk0vismlkqhuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13c0832765929c18d1a2025461db8f40\",\n" +
//                "\t\t\t\t\t\"name\": \"铲运部属机构\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiiytsllyvzsmu2rygitisqskkewrgumjiuqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1438aafa8ce6d9fc54d3b3c476fb2fd5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"海外发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprujmpdditmtfhwvmdifvkvktetukexwiujligvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083480b14379a7b80b534783a1884\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运战略经营部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiaytumizerujlczdxumkqevjkyxyttiiyyuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08362c4ad7cd4a2e87c3404d8d071\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运人力资源部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqytwju4udgluvgudjvmyxfjkequgmviqxrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08369d3e410f8e23c2d34af986236\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运资产财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiiytwmvkthuiiviyhjjnfsgjkddizmlistwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0837019487ae12bf5e04424e95634\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运党政工作部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqytxiiyzuyltbhrsuwcvhqkk2suhmkiwtuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08373391b5eb0e4e7db4402bb4721\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运武装保卫部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiyytxjj2zrekvveqhkvgxgekkeqseukixsrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0835bff3e61614e9933d4d0b9a980\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运法务风控部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiaytvuwvithliywruvmazttvk3gqemtizyqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08356745457e821887e74577abfda\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运市场管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqytvllyuvukljhysimmyxhlkivxxtupigdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083971fae6b4fbe12dd040a48db1d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运质量保证部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiyytzlihidhlu4uievigsggikcqdumvnerghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"15b21d08a749fb4a2bf17a3443eba91d\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"可靠性办公室\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvujsrgqmtaxuzwucudsuwmrxdjkuuthutmzrghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"148b0c958344ae9f536a8ec4a8bbdcb8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运安全环保部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprumukqfzkmytuutvkzivjlndyhukfdyeuvlfeyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0839d386d9535beb8ccc4985be498\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运供方发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqytzvj2ywgmkmtvevuoyffukqzyvuviuzyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15f6b56282ca024a1715add473b8e92b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"特种机械发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwlbevwjmgsfdij0udrligvdgvkuxtemvmzsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161d01883b2bcaa5b031629402e80d71\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运审计监察部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivqqrymj3eseutvdveijirwsmkeqshmijgxrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c286cebd094dc71bacdc544dabdf17\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运工会\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtujmywfvubgqzkvrfxrutpfgfkkgugduvjirxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c287086dc6e9cc9167d58417596f61\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运纪委\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtujayxqml1gfwvmlffzilcxgvmkirxvmljiwrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13f8357d9f31cbf836cea38417cbbce7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运卫生所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtwmqtvxvmjitruuriytludhdtmkerxfuulfhxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152e412cbdcb4d021bac63f4a399228d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运计划物流部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjviursuuhgfekvqqsrutbfwtwkjdtzmjmsyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166f7594c0762d9037225c04c908d3c3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运军品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlwqxvzkuaqxwjvizqtljesvfikbfzqmvktfthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13c08414c40aeed54bd738e4daa800fb\",\n" +
//                "\t\t\t\t\t\"name\": \"铲运技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqyurku2uqdvvbgvuuvixtyvkhgddmioqiehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0841c6050609a8182cd14ffe89465\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiiyurulaqvqlikzdyimosfgikxiihmmiuwvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1614af48bf900c1a33b9b4844b38228c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"标准化及材料研究室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwikddiumurizqiukrdtjuczeumkcuetmjmsyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1614af4d9009e1fceacf536478ab25e2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"档案室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiktdiuvmyqqzvi5ifhtubivtlkexydujkvhshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08422f5f412d24b1a9af471f944b1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心第一研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiayusjwkviuijrgsuuifdzdwkmxrimkkuerhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08425d7a07b7fcad42dd44cd82cc4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心第二研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiiyuskvkxdqluoxiftveusgvkgufgmjlffuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08428d2eae7694041eaa479e8383e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心第三研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiayusmv4shdvlawzuikorhdtkuxzhmjmythhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c084316a19dbf5aac2cb14e7c8539d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心CAE研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiiyutilbdrzvu3ivdtuosfeikvhxfmkmtzghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08437340f6f7420e5c4d4bdcbee15\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心工业设计研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiyyutljeuqilwqxusivcvfuvkxegfuvjhrvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1614aed33139565a5608eaf444b8c814\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心液压研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwik5dhgjjirtzklcvdvligyhdwkuuuemuiyruhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15aa1a61768477b524c05df4103ab4ba\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心电器及控制技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtt0rdwilywyullrevskueqvgwkirqttuouedhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15aa1a76151b53b9562df134dc8a9de0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心机具研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvttsrdxli2vrekjbezvljlgirjk1gfytmlghqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152e4115163cc1603ba625d4a62b8953\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心动力传动研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjvyurrki2wtfuiqwqtutawsvvkbdwsumizvthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161468b7285fde007807ad54b9ba8e12\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心信息化研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwikmwyeljuyvivvaqqxmioxdgkknezetmjhrshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0841fc88c9c81ea75824462199dd7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心试验中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqyurwu2yyfmu2yrhtlavyskkywsrmmlggxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1621e9cecd65b09bf6650f04b4fbfc6c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运技术中心特种机械研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwji3hzfvubgwvuigzeillevqiikfeuiuwnfwfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13c083b369b4e31e5708e3e44329a0e0\",\n" +
//                "\t\t\t\t\t\"name\": \"铲运营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuimytejl0zeuvjkrhvlikyhtvkyutsmtkqhqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1438aae0250b94771240f5145158b54f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprujmhddhijmvqemkaxxrjkkqivikavrvmumvuihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083f42557597fe66b5124ef8b8596\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司商务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuieytikjyvvxkmgxihllbevrjkdhiyumivzwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083f73ca1bf280a65c59431cb895b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtui2ytiljdfdruwisyqtlkvfvmketrfummzvehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083bc68531248ffab0c044489bda3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司大客户部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuimyteuliyvtijuuyiwtfeqfikiuuymulgdthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c6a049fdb6c29ce391d764935b9bb8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司销中心主任\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuljdqumwlgewuj4zfhjmcrgxlkqztvumleeyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15c5c234e70377f361873384bf99447f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukrfstkvyxqtlljitwimaxttmkleizmkmuxihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2901393b644930d61a465196ff8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心西南大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukrfsziiatztuliuuzjijgwrtkiwvrmlliiyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2ab4dedc327e48458e41ca98df5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"昆明营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukffsduk5ghgujesxhkmiuvyvkorfdmmlgivhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2ae447aad3ed6bf95d44548e765\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"重庆营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuknfsdvkmuxdtvgthglubizvvkquvumvixwvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2b09a13582a6b447724b2ba0ba2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"成都营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukvfseimjdrtkmcsdwukauxxjknesetiledshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2b84f8bf4619dd8baa473ebdcb6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"拉萨营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukffsemkfiyewkawrzvvoyedtkexthuvlfewhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2ba9e5d3ef6575d27a4de9a9c53\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"贵阳营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fsetm3hvgjvziwvlkjgsxtk1ghztmjfvthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2935ef4f39d7af53494829a005b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心华中大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukzfszjkthiuwjkzgxtwivtumkiysztimqvehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2bef0072ab194a29a546849c2de\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"武汉营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuknfsevwqqqxjtrerzktmszdkkywyumuosghhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2c284811079e6d88124466ba6bb\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"长沙营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukffsfjmiuyriiexzhlvayyrjkquwwutoweehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2c569847faac7c4e39406cbc64f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"南昌营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuknfsfklizyulw5ddflukuhtmkuqwfuumwuihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c295f8e7f5c7c50772140099341b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心华北大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukjfszkwsyhxwknfxfkiixxsikyqqzmjmurehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2c93d673673f23060045cbb629b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"济南营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fsfmjjgwxjluxtijjaqwqikgvfeulmszehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2cbc5c5955bb4058bf4ecd8f0c6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"天津营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukvfsfuu0vfvmkgveekievyewkhhfgmwkqfwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2cd2c993a9dacdd6564f9e8723e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"石家庄营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukffsfvjzfzzjtozgduvbgwvlkvizhmlmsthhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c298da01f39701516664578b5e7c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心中原大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukbfszmvrdqrwjyzxqikarwwlkqvxyuknhxfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2d334fd6553b9144d74afcb482a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"太原营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fsgjjwuiglk2vtemimuuglkhdifukmysdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2d57fed88d906722a047078c0ee\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"包头营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fsgklhihgmmrgzqllessdikqxqxmuoqhhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2d7954c052692f74dd4e7397728\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"郑州营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fsglmuvufikaswzjwexugvkzhxtmlixsyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c29aa34c957f8e6a91e429d9d1a5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心东北大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukzfsztt2tufmkkxiyvljdzrvkmszgmvkrdvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2dc4099e51979d17b04bb88ee22\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"长春营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuknfsgukyqzzvkirzxmverxeikteeymvjhsshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2ded796531e3c1c85a45a294474\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"哈尔滨营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuknfsgvvyxzwkj0rhtuijfyvtkkvdsmkiuxuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2e03a8adeb8bbc09f84ed784878\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"沈阳营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukvfshijvdydvvveyeuueqzimkdhgxmkiyxyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2e5e26c85ffa2ba3664fc699485\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"锡林浩特营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fshkvuswfmkhiidjubdtwlk1ifwmmiuyvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c29cf128d499e556e1b4b6580967\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心西北大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukjfszuwarsyvk2zzhkkcwhrukbewvmiizwxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2e9a6a0ab63248f8dd44729fce5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"兰州营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fshmtkwdqtuawtskmfiygvkiuxsmwlfhvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2f170856ce009dab3b4f41b8409\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"西安营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuk3fsiilqqyvlujhqqmvddetukbiurumiuqzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2f4ecaa64191187ff34fd2ad857\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"乌鲁木齐营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukvfsikvhfddlkirzrimoxiijkligstviyvxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c29e9c33b67f5c8eca04713be690\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心华南大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukzfszvmbfttulkxivumhhfdikqxrtuviwzqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c35576089bf1e2af8e7443c86a76\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"广州营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukzftvkliwqymuvirhjtniyhlkeutfmljdxwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c35c9733703cdf4e0f5456bbc88c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"南宁营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukzftvumixttligtfgwknhqikkuvweuumyyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c35f737ce6fe6ac9bd242d182c7c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"福州营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukrftvwlmtxfvl1ihwtugzegjkcsgrmjnfxfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c5c2a0a6ceac3a590c2cc4bffbbffa\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"铲运营销公司营销中心华东大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukvfsdit4wfhtuktdvminfsfukheiiuupiidhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c364f83b219c136ca064a94a6604\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"南京营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukbftwkwuytejikzfrjldfdqlkjdzutliwquhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c367b927946838c66b4454b8979e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"合肥营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukjftwluizsxmkqwytmuewwekkuvuemmmxzhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15c5c36948e5133422c70534edda3f97\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"杭州营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvukjftwmk0yhvijqtusjuixqvjk5hggtjjizxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15d4fd7d45e02a3c5b535d04b5c8f55a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司风控债权部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvvkdigxvksvhqjtstfvuketvgikfevfmwmvvdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1628466ef3312022c6d87d14bb690477\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运营销公司电商与小装部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjmiuwwvwattrjiessflvmyxgikleewmiiuxxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14e9635269a2fe3ea9666c242639f8da\",\n" +
//                "\t\t\t\t\t\"name\": \"铲运服务备件公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruvmawtvjlszdswvothdmlewwfjkiswtmwoygdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083bff80adae82bc29ae4de08bac4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运服务备件公司服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuieytewwuyqdvtrhysuumszdvkdghqmuldfuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14e9641f7e2ba711bf8bac54d0a8e166\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运服务备件公司再制造\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruvmqwurwl3hsetlerrewmpedfkkvgqdmvirwwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1621e9ed9f1ed2eaa136ea84f00a3b04\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运服务备件公司运营监督部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwjivhzhvmfirhvj5hddijgwhdmkziqqtjjequhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16284769cb0d39458d2b30a4bb3babcd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铲运服务备件公司备件部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjmyuxwmu3eqgjmauvyvjjetqtkteetutpefghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1614abb5c31c8237e69aa2045fdaa0f7\",\n" +
//                "\t\t\t\t\t\"name\": \"科技分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwik5deekuetrfmjutxhlmdddsik4vigttkqixhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0838ee60e44271c56ccf48c3a2a92\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司工艺技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiyytyvvewqhkkysxrukgwffwkkyfttjjdzshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1614ae1de619a27df37b2474c4ca4b6a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司制造管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiktdhrvviwrztj4xgijljesulknfuftknewdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c083a20c754d63a6ea012444886492\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司设备管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuieytdjibfxvkvuwtdlvbdqrjkauuymliuzshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1614ae25786677c0afbd00e40429743f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司物资采购部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwik1dhsklyywwllffqdwujgqqvkyqusmlmutihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1614ad5f1c55c74a74f3acd4c568f966\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司下料分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiktdgvwizfvvulcudxkwgtdfvkbfvwmwizwwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0847357fcaee9243ba3b4d949eb54\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiyyuxjk4xiftvrhzskjdedtukzgzumvjevuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08478dbb295ef6607a6b411ca6141\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司薄板件分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiayuxmv1eesmkdhiwlicxdwukmrrftlirurhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c084765adbcb1df3da312472381cb6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiqyuxlkpdgeuuorgijvbdtrjkqxstmilfewhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16464a3fccdc6bb0ac973db482ca2552\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"科技分公司结构一分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwklsudtwuhfgflu3eqdumextgukmysftjivvshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152e4179818393ebc3cc3cd4edfa733f\",\n" +
//                "\t\t\t\t\t\"name\": \"铲运油箱分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjviurxmmyrytmj5hefjufftfvk5hgitlmttihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15456936756454ce04b8ab244f59a746\",\n" +
//                "\t\t\t\t\t\"name\": \"广东徐工\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkkqwztllivwukkdfhqkugydejk0uivmtixuwhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15456966296626bb7639af1494f98a38\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广东徐工销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkkawzwljazwwjlteexljozdiikmzuimmjdtyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15456979667f2953a35b0e84688a07f2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广东徐工服务备件部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkkiwzxmluwxijm2vtdjkfeqhmkiwyytikxishf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15456988f710797c6a7a03344b29cfa7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广东徐工财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkkawzymwyxrqlm0xfwtljdqtjk0uesmulidxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1545699b3993353085db6024d7b9ecbf\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广东徐工行政部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkkqwzzujyzztjkitqykvbewqjk3gxemvpfeihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"154800856a191513fb13c014ec087759\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广东徐工风险控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvkmiqqyklzdrzikurtiuiktfqikthfqmlixvzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"162b77f7d6cb0625411426f4993a3c82\",\n" +
//                "\t\t\t\t\t\"name\": \"陕西徐工鲲鹏\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjumxxilvgwfeilysvuiiauswwkyzzttjjfyshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a20b26fcfc42e988a4840473c888a2\",\n" +
//                "\t\t\t\t\t\"name\": \"宁夏徐工\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtjcqeslwhfifkjrhzymtauyuikextfmmkydshf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b9d87df26e9df1b64f9194e6283165\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"宁夏徐工销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvumbgyxvwmswhmvfirelkjizrmkrhwsmjirwvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b9d885c786f02d94893ed45ceb3ab0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"宁夏徐工后市场业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvumzgyykuaxywwicsgzkmezthvkwvfhujldeqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b9d89029c1738d435c0264352a2c65\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"宁夏徐工财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvumbgyzij0zfrlj0ygujkbfqslkitvstjjfwvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b9d895fcbf3ecfeb75c2d4cbebfa79\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"宁夏徐工行政部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvumjgyzkw5feijvxfihulcvfsvkhfehuwjdxzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"168eb115c29260dccca9ae24d0fb3960\",\n" +
//                "\t\t\t\t\t\"name\": \"贵州徐工鲲鹏\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmvzerrkuaszsli5gffutgzdhjkvgqiujizwqhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3bc01d47f93e560a49b79dad7\",\n" +
//                "\t\t\t\"name\": \"徐工挖掘机械事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvpggfjubfqrvk0xizjvivwqtkkzexmvldgxhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"16188a53c28fc110c595cc047aba8695\",\n" +
//                "\t\t\t\t\t\"name\": \"挖机公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwim0ydvju2syiui2rqfkmgvffikoxdetmiwzvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee381230ad047f61ed48425d99bbf\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijetqdviuuxilidhgumk2svgmmpeeihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee381240966c55a6d27d41dbada5f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机营销公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijauqzlljfvvtlbgsxvkorgetvndvihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15f9a88a035aec447cbab3b474f8553f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司领导\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwmjdyyti2tvdvuiuuxuuddetukuxuimkmvtihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee38128e4578ccc63eef4bc2978e8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司服务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij0yhukloyffulgthhwk1efsmlkyhyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee38129ed5aea9c117c146c081b13\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司备件部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij4zhgkt1hdzuimrxfikswfqmijerthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812ccc3466a619b3144f39c509\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司销售计划部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijpfffjkuwwdlikzetik0uitmuivqzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812cce06b1878c5ba4c8d88696\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司市场渠道部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijhffhiljerylmnfvetkffygmmiwzwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812ec0ba2a0d93f1f4b1184cf3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司营销管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijthfqutssdqvmctirwkberrmklfithf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d94046d25352ad0c20fc241d2a9d9e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司销售人员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruvmauqulvisvtkjldgqujgqifjk0rgstmngzhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15f9a92906b4027314887814fa1a2ab6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司大客户部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwmjdzsmicweuijaxtrkmiyxyiklidrtjldewhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1604dd580531dfa7443b35f429196692\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司营销党支部书记\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwikdggvmiavtrvwrdxukjbetvwkiszrmliwzshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"164350308969be84d5fa23e4b3ca6dcf\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司技术支持部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwkjavqtimqzwzuvmyugkwjdstvknetftlpgfihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1646dac896f8064da2c2d914441933fc\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机营销公司融资业务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwklxgdfmmcwiyilwugdjuksgzikyuurmjotifhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"166c8bb0c4efdfe03fe8cf443a9b6263\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"东北营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwluwyeeiuguhivwrhqtwvgyfikkctdzuliswthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"166c8bbae21aaa2fcf32ed9418f83d65\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"西北营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlu4yeetv2srdttwsifwjoshgmkuryimjjgwvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"166c8bbede102b6547ceacf44dab51e2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"中南营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwluoyeevvbhrqjuywvuluhhdfwkwugdukkrhshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"166c8bc19cd3d9cac9577f840bdae07c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"华东营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlu4yefimtfgtvm5fdfmkexximk4qegtvmqxfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"166c8bc4ad7f5b15849b132431f8ad14\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"西南营销中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwluwyefktngxikuqrvykmbertjkutrimtjgruhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee3812409610a454775748ed8f5cd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijquqzlikqdukkixxvlkgyhgmwovfghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812ad0a17f546e925405190b1c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机技术中心大挖研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij1dgqticxivkljhzskkiqvrminerfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812ade7fe6a8bb95d4f88a2327\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机技术中心小挖研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijpdghlwfhwdmubezvvkjiyytjitsxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"14608412ed77313e8916da24e1091aa5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"挖机轮挖组\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruliqyurjvzgxxji0thymigwgdjkzhrqmilddvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812bdd2d71b90390d46a792db0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机技术中心智能控制研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijheggjvmxremiatzqvkkwdxmjlgeqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812bd085fc1a6b7ef4f318f181\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机技术中心测试研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijtegqmklifrtlfexhwkbitrmwiryrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee3812bd0aab2f94eb6e43faa6a0d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机技术中心信息所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij1egqttnesimklhewvkotidtlndqghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee38129e842da0de67c4441a8c14a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机技术中心技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijczhykjtgdqvvewxfkkuurdmumrudhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"139bd32391214cce5b7eca042e388f7f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机海外研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmuzgtsjmqrsrkutfhvulhhfdikcshtmmnixihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13c89fd333fdd97d56bdaa7449daf988\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工作装置所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtum4zigjjwtigvmcxgvlupgddlkmuzgtwizyyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"141487cb9143dbb32d9134d48958d11a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机标准化所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruikuyxfumarutvuretsvmartuvkayzvmvmrrdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"165d0b6901301d66f71e9f0456398c12\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"技术中心中挖研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwkvkqewmiirtqiv2wwilifhziikivwtmmjfrshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee381240552b9fa726be4d6f95321\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijiuqvkj3ezitlmswevk3gwimkitsrhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a3f606d12fdeeaf7056774dac9b46a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部焊接工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjbiwqlvursivvphdiliivwxlkpgdfmumuwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"154745e084e15fa03fc6cca4104bb460\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部装配工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkleuvhimkuhrkwrdqtwuowfftkarquuuiuwqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a3f612cd2ff81264888114daa882ad\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部加工工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjriwrjufgsiwmarswkmiyyrikhgddmmosdghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"154745f84f8749651da623843ce9a8df\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部涂装工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkleuvimkriyxkmqwvrvtawstmk4tfhmtoygihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"154745f254e798209afc7a24189816e1\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部技改工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkluuvijkkuhxmmisqztwffxdjkqryzmikwhrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a3f61e986c87fefea22204258bc9ec\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部再制造工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjziwrvmuywfml5ihivtasssikqsvyuuozhfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16067c1ba9e6c3df508a74a41fc96770\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖机工艺技术部智能制造室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwilsxfrut0zhwujdgivimjdxutkorifmlixxqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38124f084b6b6a958944269b418\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机党委工作部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijcuiqmkveweltizvymkiuswmuiuryhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16883aa82bf54e76cd3f03f44c3ab4ab\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"组织宣传\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmmgtddmjteivkvuxwfvjbiqtwkkufttuoudehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16883ab018cfbba528748f3408587b15\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"行政保卫\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmmwtdeiigyfiuurdvsmlmuyijkqqyvmljervhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16883ab47c115d47af80e9a4707b4088\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"食堂后勤\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmmwtdekljfrrkveuxdwmkqhztkaxqxukiqyyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16883abcc8782b3ed89d2b1446982c0a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"工会\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmm4tdeuuayxyjuwthgmmngseikauwzmjnfqdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38124f378d6a04943944978d9f4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijkuitlmfgwdikizutmkauzxmvkziuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38127e96be73f2ec474dcf821a1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机装配一厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijcxhzlubhxtwjlhfulkhgfimjkrdrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38124f2a5234c8799a416eaf604\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机装配二厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij0uistkistuumixzztkmrwhtwiwquhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38125fce05751112fd4a189f764\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机制造管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijovifviyvxviiersivkjdrymwixwuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38125f58a6bba78f4d4f13a011c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机结构二厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijsvivmt4weetlcyiuvkjirttimrrfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38125f6bb04f3297c74271bbfd5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机质量保证部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijcviwuumquijjmzxflkasxruuligvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"153a17286b490cce9fef3c641ff9c00f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机人力资源部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjtarxsmlreuziutfhzwvfitflk4riimumqqihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161650f4b1577f1444183ba49bc9a68d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机经营管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwilevqikuirvxlwqruukimytetk4zefmtmwyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38126fe5b676e825174d0289b9f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机采购物流部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijowihkuiwxwvmisvrlkrgqsmmnezihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38127e51e23f177d494c8c9bf82\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机安环设备部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij0xhviv2stiilkxgumknfyfmujiyshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee38128e8c3bec3522044a388622f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机涂装厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyij0yhyuj5ehfjkassqkkbdtymlmssihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee3812cc7845f7323de9475489070\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机风险管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijdffxmkkvixjjotghmkqxvummiqxqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15a06ed2caae3e3b778bce84345a7703\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机法务审计部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtiwwhgju5ddhjvktexlmhefhmkytuvtlixqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15a8c70e466e086acb093a84d07a270b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机海外发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmjfxqvkewwhimgwdfuieztdmkjgqxtjmxqehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"164edfdf2668305d39f74074f44b9b09\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机供方发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwkvhgigwjiwwyjikvgtmwixuqlkriuuumjeqzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16343d08847b72a871661f84faebbff1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机经营管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwjkctgqmmmuxeljjdyxilewrimkhidhuuliirhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1645f1f3465bbd0b63264ad4a01b46e2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"挖机结构一厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwkknirijkewveuvkqewjjewudvkbdqrukkwhshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1684033bb1297168e2aff5b47179e52b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"监察部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmkaqttuuyrszliuwyhjtdiivukyxrxmvmvsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a070a49433eaccfe473274971931ae\",\n" +
//                "\t\t\t\t\t\"name\": \"矿山公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtiuxqdkmyuttvtpffivkixtslkyzxrmjordhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"151193bcdf546836cd8d1aa4addb9d01\",\n" +
//                "\t\t\t\t\t\"name\": \"履带底盘公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviimzteuvbivulmetwfvmngrdtkxdggumjgqrhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1612c99ba91143a3e2c8e954f619c049\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"履带底盘公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwijrfzzutqzrrkjvdthjukyhzkkziwrmuiquzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1511d9989252c26fa0cab4d4775a19c1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘市场营销部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviirgzzmmisvsujwwidiuddeuvkyxxvtikzfrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1511d99c6a09981c240f23e4dc1af6ec\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘技术开发部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviijgzzuljdqzmmcrfskijistvklgfrtwowhfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1511d9974ebc5f13208ded440aa986cd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘资产财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviijgzzlkphefkwartsimhghgkkoqddmmowfghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1511d99f87ca6de72c239664b0b96994\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘生产制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviibgzzwmgxfdlvjhxsujatzwlkneqemlizzuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1513840b09f240cc8415c3f455284de9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘采购物流部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvijayuquicziskitffykicvftwkavvsmklghzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1511d9935374c62839440be45aaba41f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘综合管理办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprviizgzzjkitxuulisytmkmuqevkwvddutmurihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1604dbebd774bf7fabaa1ad481bb7b90\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"底盘质量保证部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwikhgehuvaxxuuwwxidutfdrdvkuyreuljezqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1556bb738c98df473f6dbea4bf99c150\",\n" +
//                "\t\t\t\t\t\"name\": \"经营租赁公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvklleexjmbfzyvwauxtwlpgehtk1eizmuirvqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1556bbb75ee5c782054d255478aac207\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"租赁业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvkl5eeelk1hhvuliysqkkjgsvkk2xydtuisqxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1556bbc568ed78d6ae2995140f89fc7b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"债权管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvklpeefkloyhglmngwdvjizzvikkqiymwnfxehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15f9ab71b336422930536c142e7b36ae\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"资产财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwmldexiuattwkjqsztikmtwfiksshxujowdhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"13bf410b6765369529a616e409ab073f\",\n" +
//                "\t\t\t\"name\": \"徐工道路机械事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwaurqulixwvjlyzvsmtiwrwvkeqzduimxtihf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"13bf43224661848f346f10742bb9a050\",\n" +
//                "\t\t\t\t\t\"name\": \"道路机械事业部领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautsjkawwrmkcyitkljirqlk4seemtiqvqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"147edc9740546822815ce504d1c955d8\",\n" +
//                "\t\t\t\t\t\"name\": \"道路公共平台(虚拟)\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulvlgfzlkaqvulmyssyikdfhvik3grfmkkvgyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf432247cb3d4d5cf9bca422c915aa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路党政工作部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautsjkoxfejvkugvuwozeftk2ssfmiovddhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348c7ffb5534590cad4a3e83fe4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路工会\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumuwxiiukyvtukmgqfdvkvdthmjlihuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348c869e1a6bb9ba294df684851\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路纪委\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumuyywzvivdweumledsmkdgiwmkiyvrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13ca847db18122dfc40063b4fd7a3d90\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"精益智能制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtutayuxvuaryrjjhgifkiaqwtuk1igxtjjgzqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348c95e3a1852b0f7d46a99bca9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路人力资源与管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumu2zvhjtaryvjucqixvkkwdzmulfdzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"141fd8278e854162506c9b14d28b8776\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"分厂劳工员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruiwjgyslmrhyvkiawsvilnfzeikbgsyumixxwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"141fd86641fc5284062f46c4dd99faa5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"实习-人力资源\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruiwbgywlkorifkjayuqljjiuwuklggzmwlddvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"163ed2aeb00d8e60cfc5388412daff2b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"其他\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjvngsdvuuqqgmvuwqfwuavtymkmrsgtwnisehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348cc5c8bb2a4ac5974e7cb36ad\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路战略经营部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumuffvfmuvesdktjfvzlkvhxfujowdghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348caa4ea6799c183f4257827a1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路安全环保部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumu1dduvtywxzmuarytwkasvxmjkxdrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348cb052a5f75710f54c1f96c00\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路军品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumureqvjt0vixklmrqikknfrimljfqqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bffb8e8de54b40027e3294f0bb4f9b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路军品部-军品研究室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwlieyvmdghvkuquqqjljhtsmkfiqeuknizehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bffb9661343c18d1433bb4bffb3eae\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路军品部-军品工段\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwdiezllyrtujumrygiketteukxeiiujphdhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"161df3dece43ec315283649424a90eae\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路军品部-工程中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiv3itgvuzhutvuatrvjmitwumkmsudmiphdhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348ca0d0b4bd9615034318bea91\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路质量与供方管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumufdqgiuouegmlirvqjkqtryuvjdzrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13e0b4cbcdcdbc71569c3c347b999d13\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路海外支持部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtviveufuuxgfguuqxrvlmnftfjk0xezmmjgrthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"143c2e9b7ce08c19740df96458193afd\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"巴西项目\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujusshzultfhqmuarzxkidgizlkyvyrmjpdighf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348ccbbf9e031ea92e416592943\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路营销公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumuxfeewmzhqtivjdzsvkirwvmjizuthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348cd156f6688ece7742c4b0ea0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumubgrvlwqwwymvlfhxlkcsfuuilhdqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348ce98da3a7ef32fc4a3eb3043\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-市场与客户发展部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumurhzyvtktdxvwmtsiukvdthujiquthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d12db085ddb404a44ab9cbfa\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-服务备件管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumversguieyvgvuiuqutk4udemupeidhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d2519e9e5630e9c4d668f08d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"道路服务备件-再制造部(待调整)\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvysvrmvszhvljkqhzukbgwwmwmqyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13c7f3f846f338b292479c54369a57ed\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-营销大区管理\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtulfitimkkwitjmbeszjkmxzfkkytwztkoxhghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1460281a8d2f374de81012946d3b209e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-道路驻外-主任\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruliisyrtm3gsijlwughmiiqrsmkcwgtujmqzhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1604b6b7b1ba67e8441cbb8487a81d45\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-筑路驻外-主任\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwikneweluwredllrhyukihfeemkuyxdmijguvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"145eddd3275127a1f4dad7b410990bb1\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-服务备件主任\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprukvpgggjjqxvrjlfdrikvddgxukirqzmileerhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1400a42e9f66dfac90db6b1418e97710\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-驻外-风控主任\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruiizdusvmbiwwvwddfzivneweik2ryhmlixrqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1460282486930b3e683fc1a41ff8e51a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-驻外-管理员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruliasyskmawztiusthwmjlifrtkwriimvmvrdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"14602828850dfb7a519f7a643a38e1c9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-道路驻外-销售代表\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruliasysmmevqgwu0xdvimfixdlkstdtmvkrfzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1604b6a9e25cbe62a4229bd4085a8e42\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-筑路驻外-销售代表\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwik3ewdmvusvfuvewsdkjeszevkiqyvtmjhushf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"16462ff5013ae656c93507147f4a1830\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-道路驻外-服务人员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwklosiikimrtdvl2vwfmjivqxik0xiutiiytqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"164630221a0adb15cde46f24b3b8fef3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-筑路驻外-服务人员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwklqtqsjifdqdvuurvfvveuwijkfetemwlhithf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348ce3dd51e699407845ad91b1d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路风控中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumuvhtgvk0rhwmmauqxmk4vdgminerghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"13bf4348cdd43c29bfb4f9545c1a733f\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"道路风控与法务部\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumu1ggujueszewukuizkk0vfrtlmttihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348d2b6ee5d2119f05421a85772\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv0sewvv0vgsiikziqkkusrdmkixxshf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d31f29cef0cc8a64d1aa9780\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路技术中心-技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvutrijmxfhiiuffydlk3grdtmixyqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d3e61f91e6d59fc45af86cc9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路技术中心-工程试验中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvkthwiwezrhlvmvziukgvdimllffzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cf0c4cbd911fa51ef35b04c0ea4cd5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路技术中心-标准化与原辅材料研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwkqfuuujgzriwjdvrvwetveiknfqhtklfgvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1404c2233b1390aa4c39c574e41bea2b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路技术中心-CAE研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruikzfssjjjertmi1dduujkzfvlkrhuruvndsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13bf4348d863e6a966dc62545c5b755c\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工道路分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumviywtvlbdzwlvjfwskksvfvulmvvfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348cba5decb7a6e22d4506a1b0f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路分公司-资产财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumutedvvvlfextlbhssvkyvqwtineqihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bf4348d93b66788b8b8234445b39a2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路分公司-工艺技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumveztellaxyyumjeysjkquuvujkzdshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160003ce7df743e7c85bac7436abb433\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路分公司-技术中心(虚拟)\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwii2qtfvltgixkjvhxfmkpedflketwduuiutthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d4b801dd146affb49c5b669a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-压路机研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvsueyiidggrklhdiiukczfvulmwzdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d51accc3b166b094811b7e30\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-摊铺机研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv2vrduunfteilkweqmkqyrruljhtqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d44ecc318ff2bda4987943d6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-智能控制技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv2uuhuuatrywwosegtkizyxmkktgwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cf0c406105215b9f1c1bf48c7a4318\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-动力传动与工业设计研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwcqfuilqrqvjisvezwiffrewkkyfxtkitryhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160004bba88320dc00e9bda435fa82e4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路分公司-营销公司(虚拟)\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiiuqueutayytjitgfqivozegtkmtvitmkshuhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d00f5738a2e6a51430aaf75a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-道路机械营销部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv2qqiklutydjvkwdvikmtqdtwmxvdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d1fe9c3d4f553294ce9baddf\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-服务备件部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv4rihmustguwkivtsmktfhzutpggihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"16164786dc295a2e9412bde4452baf15\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路机械租赁部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwilauxylvzfszktsshzkiosegvkquvsutjirvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1642a4b11ff334fb57ccc8a4dcca3825\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路分公司-品质控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkj3dueiiliitjk1ievlulffytk5gfftjiysvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c085e286fac8f53fe22b74b9e97979\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"道路-制造中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuieyvhjmowidumrivtwvmsselk3ezhmlizxzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d9a4a879eb2fde4478d810e7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-计划物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvkzdutmexzhujhighkkuxygmikqhxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348da98996c6758d3f4409b8a79\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvzdzymm0wfwlkcygtwkauqzumjdxzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348db0f1cd4e9eba79420ea0520\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-零部件分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv3eqiiu3guhmvledxmkmsqhtiivsqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348dbe20c471081f174f5498555\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-薄板件分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvtehsiuauxrimkrirlkjivummivvvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348db742768dc31d4940c190ae7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-压路机分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvrexujl2wygujkrgumkkqfrmildhxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d7f65790fd5b9ae45d7892a7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-摊铺机分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumv0xiwkluzqivknezdvksvgxmmksdxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13e916b0653249bdb2223624dcf87616\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工筑路\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtvmerweilqvtskmhegejjastwjkxgfimliwrwhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14106609d3afebb71edde534443b732b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路-综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruiiiwwqmvotdivujexrvvlghvjkquutulmtsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fedc7bcbc415f3edf67144d3b9ea6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路-资产财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwphgfluxfefkikvitvvjiwxiksugtumlhdwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13cfa595e295bb61653d1614ba8a75e3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路-技术质量部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwzdvzkvaszvuuywrwkjjgrwik1edytlkvhthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160001268d561f0da867c284cf48f214\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路-营销中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiiaqrslmjgvwiwgqgdmlcxfsmkdfiumwisruhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa628d419f5d9dd96ded4cc0bdb8d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-租赁再制造部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwbdwsmvqurzwkvgzgvmgwghvkdffquvneyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d0cf3ba73a98ab44555b9b68\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-产品营销部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvoqfijuzdxttmgydekkqvvvumjewyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"16000270444aa042a8ad1414258858c6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"筑路营销-驻外\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiiaqsxikmuudtiuusdmtjgruikqsvymkkyfwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d1965a96fa113c544dab3399\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-服务备件部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvyrzwkt2zwitimrtfkkwugdujitzzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1670c557d012e503105dbab4ba5830fe\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-营销管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlijfvvlvyqrsvkqqtrikhgeduktedvmjoqihhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1670c57ecfdf10085e7f40842c78c7de\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-海外支持部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlizfvxvupigiiiyqyvvlbiuqmkssfxmuoxghhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16000281209808f3f8ec3174a68b919c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路-技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiiiqsyijaqzyimvitimvjftrlkrdwyummrzfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d588c62c0d681af4c5a8e9b4\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-平地机研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvivyyulcsfqvleyrdwkvfvdmvkzeuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d6cf2a2f6da330f4e7d82844\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-铣刨机械研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvwwfijtssiwvtattqwkfhxgmjiyuuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13fc69b97d2b38570884ad3413c9496f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-电气液压技术研究所 \",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwu2wzemlngsejmavxqmmoudgjkmrtfmkmzwihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d38ba6f166109ff456abef01\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-工业设计研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvmtyetlrirwlieqziwkuvwduvjiqrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1670c69b9280aedaf2089014e6390e9c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlirfwzumysyqtvhgdijiiyzqikjhwtminhzfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13cfa3aaa56a57d7d2f6e02471794fe3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路-制造中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuw3dtdtt2vwdklfgxgjwcwhqjkixrxmklihthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa621d8b2064c09071d84ba098f64\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-计划物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwjdwsivcyesilkufqmiexrgmkledqmmjiwuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa65bd44ba80c0d467c44640aa038\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-结构件分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwbdwvuvmuuetmcqfqvkewxfkkywuqttiqtyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa64e70a270a103d68ed4a9e9222e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-平地机分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwzdwuvlkqdslijdrqjvewyhvkndzhmjmsshhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa655dfa0d4fe35af8a94e52811ab\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-铣刨机分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwjdwvkvdidqvk1ihtktniydmkrhvsmiordehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa662b4cd73f2677803b4836b97ef\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路-涂装分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwbdwwju4ufgljziswllayqtukqytwumoxhihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fedc7cb5a5b356f4144d467280a2c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"筑路实习\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlw5hgflunevdkuatvwwkaruuvkawxsmindsfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"147eddf266a8d68bfa1254b4048b2e95\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工养护\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulvhggijlcwdyvl4yeitiasvuukaquyujjhzvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15e7523f4e8cde59e60d10144ce8cf51\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护-综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvvlavstwkvhyfvvevzhlijgrqikwufhmujivrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bff7e2f52c41866a99ab14071be61f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护-工艺技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwfixhjwuvsfkiyywwtmozdeikqqxruvmwrihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160005234b45b8ec6d230bd4b829f6c6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护-营销中心(虚拟)\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiiiqvsjkbeuvumdhfwvjetqevkjeysmwkwfwhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348cf5ec3a941fae8b48e88c194\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护机械营销部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumu3ivhujjdzuiwddhyuksyhymuirzuhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1499dea5ccabf6a0042dfcb4c049f54f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护营销-营销管理处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprumm5ghdkuhfdewlbdqqkjhgifukjfqumwmvuihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1499df911345e87b3f1807a4359a634a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护营销-驻外主任\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprumm1giziiituvvmsxetwiiyqxtkitvztlmtudhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1499df98cdb49656d060efe4f589eb8c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护营销-驻外销售员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprummtgizmulgeumlevwgiloqhivkzivymvneyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"143b79d59415fb4bf448d524367a7843\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护服务备件部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruju2xzgkmaurvwugueikkcygvjkytwxtliyuthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1499df9db7ab4b8529c5a814c3aae816\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护服务备件-服务处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprummdgizvugxdekuyyvsmukvdyik3ftdtviyrwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1499dfab7704b6d2e4f428f402ebe313\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护服务备件-备件处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprummxgidulaxquulfgshkwausywkuqshuvitrthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1499dfb26fd9e8d025e69854121a201a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护服务备件-安装调试处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprummhgiejlligzvmzgqskviwzykkirsrtjmqrdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"14fcfef9325eadb8d22c5ae4f1b9c897\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护机械服务驻外\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruwu5ihimjmsvhtvfeygjjnfvdvk3iremuiyzxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"id\": \"14fd55ebb8c5e1566be12a744f590565\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护机械服务驻外-区域经理\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwvevvhuu0yfvviqvwwuvmrsdlkkuivmiivwvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"id\": \"14fd55ee6e1d2c4b161b67d4331afde8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"养护机械服务驻外-服务人员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwvmvvhvlvhrgjusuerlibewxvkittrtwlghyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16000566c4dafaaef6d38fd4acdab9d0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护-技术中心(虚拟）\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiiqqvwluwugdwthdhilvetyivkpdfgtukzgqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d6543289901115c4b518b543\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护-养护机械研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumviwvujjqyzziiirrvukbevrmuivuthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d5f2cf0f30c98dc421fab118\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护-拌和站研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvkvisuwsqitiumzygukmsrituirryhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13bff8337bbab562fe70cc64a43b9bd6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护-制造中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwziytjlxeeduk2wsivlgqfflkrdutumlegwhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"143b799423356539583abab4af484699\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护制造中心--计划物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprujuaxzzkjqttvlkqtzvmjhdedukddiumkiwzzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"160006a7e140356fa3ba1c24cbd9ee9f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护制造中心-拌合装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwii2qwdlvyruqjkowidjufdrfjk5fegmvnhzihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"160006e3d6bfe92ef31d8684d70a1e52\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护制造中心-养护装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiimqwhjv4weivm4shijibgywmkzgxqtijhvshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"160006f335d24bf190a939c40aba07b0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护制造中心-结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwii2qwijjcvgskurirzitiztzukoqdetikxeqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"168f5666a9f45c9f1bfc743451390574\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护-品质控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmwqvwwlt0ziukucziruwjfxujkivrtmiivxuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"140dcb9a685a4fe3857387d4c4baee08\",\n" +
//                "\t\t\t\t\t\"name\": \"江苏集萃道路公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruivlfeztleyvdkwzhtyklatyxvk3fuetvjhqyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"147ede2128d4f8ca1e92b9a4b538ea62\",\n" +
//                "\t\t\t\t\t\"name\": \"其他-封存及测试部门\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulvlghsijcyguwm1fdrvmkseztkrevtmvjdwshf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"141b6131da7ee0be9813fba415f93405\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"测试部门\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruiuiwrtivndxhvitehzmiotietk2rvimjiuqvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"1430e2b19e44a6c5e81c11a4ea88aa61\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"测试部门01\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruji3hseimjhuutlvfvhmijfrrtkthdymtjdwrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14fd0133e49febc605e5bce40acb45b7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"养护机械服务驻外-组长\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwvyqrtjvmuzivuzfwqkvovefvkgqdfukkvexhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15becb60e2949518a248e5249478e8f1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"封存部门\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvtfewivyszumkerydjkcyhvjkqzuxmvkyirhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348c8b8d304861aa2244568660e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司-综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumusyeyvjqquylidddsjkauvwmlmwqhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1410661054dac5e58c27555461b89ba7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路经营部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruiiqwwrik4ugdukjhvyujixvvkkuwremmledxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"142a171ce5b81aba6197fdc40c2bcde5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路制造中心-采购部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprujtyrxruv0veyit1edwimoxiguksqfsuulghvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cfa584f74b56d97b29f3c420092e03\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"筑路公司安环设备部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwbdvykwmxueklbgzxujkzitukisqqmjjhqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"147edd866d04b4f4c22bf5b48a48c061\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销服务(虚拟)\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulvdggyllbgquukfiufjjdeivuksydumuiqwrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348cb577acc8149621497393aa0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路财务中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumuzevxltlffyikizwsikyzxtmjlddqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1404c2597825295006f8b1646699e7e9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"路机中心-涂装分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruikzfsvmlqysvjmavqqlwcyerlkywwzmvkxhzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d72764f8b21c09e4685aa29c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路采购中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvaxsxlkviyejijfqzvkywyvttmszfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d798416e5f1bfd04773be91d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"道路采购中心-供应商发展部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvqxzykiswhvwiheigikqxxtuvmzrghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348cd776164143a9754175b9f0f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-商务部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumurgxxliqwurkjjdzxkkqrxvumniqihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348cefd7752c656dae4f10a53d7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-拌和站营销部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumu5higlluvsflkowgdvkzirqtkktgxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348cfbcce642f40a5042da9216b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-铣刨机械营销部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumu5iefuvawuswkcqdvikosgdmjmrwehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d065d03a555b4ce4164a759c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路营销-摊铺机营销部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvaqwvvi0tdvkkneufvkyrwutlmvzfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348d8dfbbb1e280ef34cf3be9a9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"道路分公司安环设备部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvgygiuuferhjmoqhijktfituvkzdzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348da2e07145a2f2e944869580e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"徐工路机中心-检验部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvvdshiliruvtjnishmkyuywmkmyqhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"143b79d17ad6c26d617c6c94225b8dc0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护中心-检验部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruju2xzgilldgwuj0wgwilnfwfmkassvumlgfqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348df7bcb66c286aa4406c9dac3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护中心-养护机械分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwautumvnixeuuewwfjmgwddkkmqwfmvldfthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13bf4348e0d5f7ab8b6ae9c42379e25a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护中心-拌和站分厂\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtuwqutumvsqgvwlddeyulldhzukystxmvmsvdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14fd013621edcb12a2f8ce04e7ba7580\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"养护机械服务驻外-服务人员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwvaqrtljorhguuersdjwgyfhik3hxetlivyqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"163aa07437a70e4c50cbb034e96a86f3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"封存账户\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjtrdqxkjsxdxivsufviuleeqjkjhzwtmkwithf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15f58c14fe0841ee6427ac34153af0a1\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"道路出门管理(虚拟)\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwkcyfrkwrhqykidhhwkjoxdfjkirvttwkqdrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"15f58c27c4caf51c463f3504794acddb\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"筑路出门管理(虚拟)\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwk0yfsluwufdwksrfuljbitvikyxzutupggehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3bffd33240fb85ab48afbefce\",\n" +
//                "\t\t\t\"name\": \"徐工进出口\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvpggfju5iigjjasuqwueyvdukwydiuvpifhhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"1389dcfc7438f6cbe3a25dc40df977b2\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmm5gfiulautywl5fehjtmsvguk4qgimlkxeshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f470e84fb62ee5104e9d81b4c\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口党政与人力资源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkexqhmktiewjvbhvrikvhzgmineufhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14f7353dec7e7f1cdaba5d34fd786678\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口法务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruwlqtvtvvnfxhlworfgtundvgjkdigxmliwxyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4701e5da1a031004fc593900\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkyxqrvklgdrtiatrqik1ifvmjizqqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f48038f63770144d4fb6acd6e\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口信息化管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkayqtmwiwtxliaruuvk1iewtungwhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f48056aa4dfd7b4942799bdca\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口经营管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkqyqvltfdugwvkxeumkisxzmupgfdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"164a6e067887cd40651a4274988b1830\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口金融服务与信用管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwktswhqlliyyxuvyuqwkijduslkqzyyuiiytqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f490f084b21fe9dd480cb0b28\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口市场部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkezqiimkuesiwfhzgvkeyqfuijesyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f490d05791e1b6de480d940bd\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口服务与备件部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkuzqgikyxzrvinewgvkmyqgmkoqeghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f49f07e3b6bf41c44bfab0269\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口中亚部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwk0ziqlvctewuweurfkkheiduiiswzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f49fae9fdcb3321a4665a104f\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口西亚北非部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwk4zidvmxigfujitsrtkywwvtimquihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f49f58e6bf01a2184efab872c\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口亚太部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkszivmvwweiiibdsrmkhhidummxsfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4afba454e1bbfce4563a91fd\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口美洲部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkpdietkmvuhiupeifvkyvwttmorighf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4af065b2bf5eaa343d892885\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口欧洲部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwktdiqlkvesewkphddjkktgymjiyyvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4afe453d41336bd475ca674e\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口非洲部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkxdihkk0tguijetwevkmxvftlmxuhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1397081163dc508308710f3438e9c595\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口北京代表处\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtmliqyrilotgfkiqytqmlmrqijk2tyhmuivzvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4be6dfc838a2f6b42f2a1b1a\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口混凝土机械出口部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkdehwvwrfytmtcsiwuk0sistinerdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4ce1bc4931eb07a4b679ceb0\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwktfhruuyuztivjeqxtkzewxmulheqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4cea5f4473f795545f2a8c04\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口纪委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkpfhdkwiuuxjwixzvkkkvistmjfquhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efe4f4cecf3e115c6cd34a079129a\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口团委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdihuwkxfhfwjzhrrkuowfgjkzdqxmimszdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13af799714f1bde319ec94e4c928a0e0\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口车辆出口部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttwyxzzlicuiruvzhtrmvjfzuvkrfzsmtkqhqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13de8f480c9deff0b616e9e426997c99\",\n" +
//                "\t\t\t\t\t\"name\": \"进出口塔机出口部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtvvcyiuminfzgvwviqelikwhzvkyswzmljfzzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15e11fc65f63f29a966e12840698bcfc\",\n" +
//                "\t\t\t\t\t\"name\": \"西亚北非-M9项目经理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvviwriflkbiwtwjczdzllbhrsmkaqwzmupfifhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3bef72ad813c3d454eb9ada15\",\n" +
//                "\t\t\t\"name\": \"徐工施维英\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvpggfjuthixjtzgyrjuktgukklheztvjdrvhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137ef252c7e310d62a406054a8992d80\",\n" +
//                "\t\t\t\t\t\"name\": \"XS公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjukxhtiijgwstkiqwqkkjdyzmjjgyqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ef252c7e9f0df9d7590b4c5895657\",\n" +
//                "\t\t\t\t\t\"name\": \"XS技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjucxhzwitgizvlavzqukzfvymkiwvxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252c8dd24f711778874a85a3307\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS技术管理办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjugyggjkzixrilixyylkzdyvtjitqxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252c8d9e6506e3f19e4da598981\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS泵送机械研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjukygzvlyvqwvjjirzvklgdvmmizyrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252c8d7c2e4baa346f4fbfabec6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS制造技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjukygxuj3huettatuwwkpieitulhfwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252c9dd5c36709196d469484a3c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS搅拌机械研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvju4zggkuqtwximarzwvkawzumkndtfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252ccc2f50cdacc3aa4bdd8ba74\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS智能控制研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjutffswk4qfgtunftdtkheggmujdxuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c0f0b5647813160213d2140a091912\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS物流装备研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiniqeklyuxyijqrwqjiktgsik0qdqmiizrshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"164a2823cabaeeb2751f8f8497a990ed\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS泵送机械研究二所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwktysysju5dedvvzesxkifiyimk2zxdmmoqhghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"164a2804825db2aa9b96dde4ece920d1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS标准与测试技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwktasyqkmesvgujtddzumowggvkphfhmjkqgrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ef252cadfb0aca18b97b4f52ac98e\",\n" +
//                "\t\t\t\t\t\"name\": \"XS制造中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjuhdgiuipdfdimbezxukzivstumzyhhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252cbc825f005cf64941a9a6362\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjutefyjkziqqkujiwumkkrdztlitwshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252cbcc627b9702ef64cc9aa5a1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjuheffljkxezligshilk1ffzttkvdrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166d425be5cc07e7fe3889940cb8d570\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS涂装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlvqusvuvwvffil3hxivjiyyzmkgqfemvivxqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ef252cdc52961929bafb4c15ad973\",\n" +
//                "\t\t\t\t\t\"name\": \"XS营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjutgfvjmqwrzjmhediukjfrvtvizxthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252ceba7771112e2474332ac89b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS营销中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvju5hedllixrrijjhsulkyttstumyzehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252cebe556f0f0dab84e7f9bd29\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvju5hehkkcwiqwihgdemknhximujgszhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252ceb62c5e07aa2ac43cc8e07f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjuthewju0vhqltndsdukwtffmvmqxihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1582835002a0536b613090443c79a452\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS信用资产部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvmjaytvii0sdqkj0wewijaqzqkk0tfxmtiuvshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252cfb334d2ef5e90a49c48e8d4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjulietjkvgshwkjhzqtkszfumvkyguhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d0a294f1ba6d99e4e14b9400\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS客服中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvkqdsmkniretljgzzvkrhruumiuqqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"137ef252cfb81a85b2c28f64d34a657a\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"XS工程项目部\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvju1ieyituyvejuesyilkjgtutlmvxdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1540d4fed7ba7b4a8c4b9184fdc8f907\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS出口部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvkinguivvoxedlukudyukbezrmkhigfmwizqxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16329b1d799a46b646ee2a548ee89bff\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS备件中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwjjszervlezzdklrewulvnhsdkkwyhhmmpeiihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16329b34fdbbe751835645947fa99889\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS大客户部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwjjczetkw5geevlyvryjkiwuvmk4xidmmiyyzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a87456e4dcd9435be07ce40aa8dd58\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS销售大区\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmqxuvlvwugfvmqutvuvmqxfvkgqddmvjgvyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13a874b2655ed001d85ee034004923c4\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS销售东北区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmexuejlevvhviuqrgmklhhqjkiqqumjktfuhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"13a876e675073ae3913ea8b445282731\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"建机哈尔滨代表处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmuxwhllyvqxjtzhtzijdhdyukauvsmjixtrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"13a8b151aca190d0dd41bc4485893fb8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"建机长春代表处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmzervitlfdrmifgqgvkgrefkkyyvymjlieyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13a874c47dc8624d401a07341f7af98d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS销售华北区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmuxufkldgfyljsuguiijdqxjkkrixtwmzyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ef252ccc3e1188f03ce0489991084\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS西南销售大区\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvju1fftviaryywigtfhikyyzzmiiqyuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15cbf4bedfa2fc239035f9b4b51a3c65\",\n" +
//                "\t\t\t\t\t\"name\": \"XS职能部室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvuuniuevvtidswuqstzijcvizukzevrtjjfwvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252ccc96c75e5f36c945b4a98f1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjutffzlumxvhkwmtwfmk0veutmkyirhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252cdcd6fd625a420c4165a680d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS风险管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrisvjuhgfglwzgwsktiusqukirwvtlmyqghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d0a5a610cc7f5014b5f8f1b9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS党政与人力资源部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjvkqdvtl2rqfuljivqikfevimwkrezhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1440b1b5bbf4a1ec39b8d114b94b0fb3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS公司办公室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprukinereku1eiutilhftmukygrikbezuuiliethf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"147d20a4a965f7543274c3d471898569\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS团委\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprulvusqdktqzwvwlqvutjlcuftvkixrymmivwzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"147d20b9816befaf39b73974af59d0f5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS工会\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprulvmsqemmmrwevwlditmuixtzlkldivmvkqivhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"147d20c10378b7598d8345b427690c32\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS纪委\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprulvmsqfiiqtxyulavzyvmatuvukisxwmijftshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"147d20c49affeb1439d28284d2ab6936\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS组织\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprulvusqfkmpdiivuirutmvasysmkfgsduliztwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"147d20c7fe2541906a3cfae4c05b365a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"XS宣传\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprulvmsqflwrhsvkiyzqwtjpfidvkrfqvujmwvdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d1a9ca7f4189db24616a7efc\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS经营管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjv0rdzutkxiuimgzgejkywrwtlphifhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d49ff22517ce710442eb598a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS生产制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjveuziwjysvrlubhxrikuushukmzydhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"13d3e7f059065cc0c105e2d4f56a8ac3\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"XS设备能源管理\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtvjvhxiikyzqwkunfqfiicvhsvkjivwtmldfthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d490cd7a4def2bc4c2593559\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS安全环保督察室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjviuzquvsxduvvniseukzfsvmjivvzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d49ddba444f620647f0a8839\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS采购部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjveuzgvubduukwawsqlkkxiqtmiytzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ef252d0aba5b8657a86549699ee60\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS品质管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbisvjv4qdetkzeywkljdywkkyzwzmvjhwqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13b31b0a477284bf35d58184f0ab7d0b\",\n" +
//                "\t\t\t\t\t\"name\": \"XS施维英租赁\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtujkreqtkaxxsmkleitkvavyrmkviqdulngqehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"166f2c5bead7d6a02cfd84f4cb7b120a\",\n" +
//                "\t\t\t\t\t\"name\": \"XS公信\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlwssfvuvddgxvljdqsuwbgyuwktfexuimsqdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166f2c905aa9e094ba8a60843c1845b0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS债权部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlwssfziklddzvimzuetmbdwqmkctfrmkkveqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166f2ca178fcc3454bac6ae4ee5b686c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS清收部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlw4sfdil4yifujquvuutnfwdvkdhhvulmywfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166f2ca84041bbe547b195549faa3346\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"XS资产部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlwgsfdmkaquruujhvuluirzvkk4zidtjituwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13ff5084238ea4e11e61ee0410188c8b\",\n" +
//                "\t\t\t\t\t\"name\": \"XS上海施维英\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtwwavqykjmtyhtkjhrrvlgrhhikarqrmmnfyehf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"14bd82f55abcea365c9030a4ca5a4c12\",\n" +
//                "\t\t\t\"name\": \"徐工金融服务事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruuv2ysikk5defvtytwvumiqtqtklfdvtkjfrshf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137eddc3c9b1bb9d09f0bb145578566f\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工租赁\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjuczeruukzgqmwoqeeikqvvxmkmwwihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efb3e934fe48ae26122142359598b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ietvmmtuivkgydhjlirssikystvmkmzyehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efb3e9432ba684fa0eab4380920fd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ietvmqutsutqwyuwtgqhdukityqmjoqighf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efb3e9532918e28ed1de46f4acc64\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁融资业务一部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ietvmyvtsmisyhsmvngrgvk0wiutujfwuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efb3e953ce1807fd3f1e4ce59490f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁融资业务二部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ietvm2vtfviayqxwvktirvklfhvmkmzqihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15ab1ed803dc812cf83cf504154a1489\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁融资业务三部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtugrhgmiwtgfmiwsfimjdfivikyrvutiiuyzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1687d4171bd2d24d2df80a1436e85006\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁融资业务四部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmlzgurlidegsvjcugsvwmyqdikutwhmkiqqwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efb3e963b7109d9f2a954e79837a5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁风险控制部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ietvm2wtelimqzgmwksdzkkrhxzmjkxdvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efb3e96361b6da23b9e04f6abfaa4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁资产法务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ietvmiwtwiuwwgdjjfezhikfiwduwldduhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c36d3e567d04bebdc7b9f4fc8be4b3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁党政工作部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtuj0wgtvkewxgikxehevucxezwktifyuvkuethf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160bb08cad3f4d35474621348ebb4bed\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁财务计划部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiuzeqyutfgtikvitvulkiwsrjkgyheukpehghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160c3c359cc2307282f9fde4902a3663\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁资金运营部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwiu0tftkmlffsjiaxsyjwozigvkyzqstjiwwthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"163067fbb91d1e50a1c7f934654ad99a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwjiewxiuu2zrgiv2vqdiukxizjkiwvutvmzzdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16426844d1b58a611c7fd6e4079aa2b8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁资产管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkjawyukvsrevmtywrrulligwvkyqxzttkseyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1687d4bd51ce513d4b658714bfeb5767\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐工租赁融资业务五部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmlvguevk4rfhkictguulivyxikxeihukixwxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eddc3c5d43343181e48a4328bba82\",\n" +
//                "\t\t\t\t\t\"name\": \"广联租赁\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0vgujjqutrmijhuytkatsyuujdyshf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efd46bd5f1bd9413e3124275aee96\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdigulungviiuzgzuijbhtrjkysxvtvjhzwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efd46be50cc943e65406464aa4ede\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联设备管理中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdiguluzhvquuizutvlavuqlkmwudtkphghhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efd46bd509a0215cfa9e411fbdf6a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvdiguluzgvqmtyqsrkulidzvkerriuvniwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"164251acb24d86d4bcbda95415799f6f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联党支部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkjmvrduuesugmlngueuulgdzkkyrvxmmniwihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161f4e9bc3414ea44e238244725a598e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联财务审计部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiwsuhzuuqturkvjduuvjatyskkyxsvtkmzyhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14331894456834623fb217b4cdeab317\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联法务资产部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujjaryzkkivwyjkawstwuasrxukpfghtuitrxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"153f4bc516bc2d55726b6774641987fa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"广联经营租赁部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvjw4uefkigwefjvavvxjljewxlkiwurmmoxidhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f0b048987410439052423481494\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"业务管理室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtkcziquiquyzmlqurqkjazqvjkqstumiiuzuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49ec0a9af0eb99d10daf4268b0d51\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"资源管理室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtkwzhfitwzdiivrezzvigqgdwkaswyuijgvrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"153f4d4b52c2761fdb0c12048a28164b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"大项目管理室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvjwsuguukksfsllgriguibfrsiksydsmimwuehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f340fd7a6c00780073425584387\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"淮海区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtkczitkiligxtljfqqlmiqqxjkasvvmkityxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"154047fefbbbf5c77ef239d43aca9c87\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"二手管理室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvkimuxivwxeeewkjfxxvwastzvk4tdftmjfyxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f40482e6ef0e415f3440e1adc9d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"华东区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtkcziuikuyshlvviqhkicvitkkkqhrtvnfzghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f44e417ef7833a05684cafb6f20\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"华中区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtksziukviurxvwyxytjtaqvwmkhfdiuljisqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f4897499257a9f810d4a399b15a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"西北区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtksziummixuzmjmvxdmwayrqvkjdtzmumrvdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f5299fdbee926b93b64214a82e6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"西南区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtkszivjmwziguvbhzslueztelkisrutmkshwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f5f3640e803da29f8b45c29cbf8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"华北区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtkszivwjiwuqvmmqtgtjcziyuk0vfsmuleiyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a49f65554cab178aff63c42518eddd\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"华南区域\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtk0ziwkkmvuftuirxytwjiwtukqsvrmvpggghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15d11cf5ab7e968661896d64e7682471\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"市场室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvi4rfiktnexhmliywwimezwglkbhxwmjiuxrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1643ecb3bce0a786d4345b2466782283\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"信息化管理室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwkjphfeju1fhqtluywgkjeuvejkawwxmjisythf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137eddc3bd067fa4cd9e7cc4cfe9202c\",\n" +
//                "\t\t\t\t\t\"name\": \"江苏公信\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvpggfjujgqwlwvdufvmnhxfukpfihmjmqsfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efcda99c0e5b5f04913e435a8dc03\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ifgtm0zfqvkfeviikizrtvketvdmvjfqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efcda9acd47984068014449cb8f1c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"执行业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ifgtmxdfgklazyuilayqrkkeuzfumnirfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15f0a8fe5a6d2368020acec43a59dc97\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"诉讼业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwi3dyivkvdwgjjawyqjipdfhukktdvmvjfzxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138eb2cb080138293e0fc8e42d982265\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信资产管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmvfesfuiiyqrjmisztvilifyvkcsgzmjiswvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efcda99c4ef6b5576c154d48b631e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信经营管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ifgtmkzfuvw0wevklkwfrkkbguyulmtrhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efcda9ac89aead5604ab444da6203\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信财务计划部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ifgtm1dfymtphdgklequdukmuugtlisqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1497a1c91bcb5780270513c41fe8fe55\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruml3drfmi5efekliyqsliivrtukgrihmwjhvvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1497a1f05e3f2eb3606d8a2451fa4d19\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信公司总监\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprumlvdriikvhtijvbetwilfgydjkmvritkjgrzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138eb25689f2041f6f7ce204bc5becbb\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公信金融服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmvbesvlmczisiksriwwldfhsiktefvuvpfeehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"146fa4f8e748eb28ec0c7e443ae91c8a\",\n" +
//                "\t\t\t\"name\": \"徐工汽车事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprulwvduimvixuyvumsyhuiffxhkk4tdhminfydhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"14d45c03a3431702b8d19ba4c76b6f59\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvk0vfqjtytutileqsemvmrzetkbfxwuljivzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45eb106e2d681a476eaa4bcd9b432\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部办公室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovheiicwhsvluyrdklowhdtkpefgmuiutshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45e73ee37158256fdcb444529768e\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部党政工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvk0vhxjvzhtxikaysvlwhgfekkyuvsmlmwyhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45eabbd058ed10f829314285a08a9\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部管理信息部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkgvhduurgqvmvbgrqwmisztikisyvtikydzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1575b11dc3ba3811eee381e47388e2f4\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvlkrerrvuotedjm2rrhvvityrvkqxtymvksiuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45eead684cde95111a7e477ea49bd\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部资产财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovhhtviwyuuvzhzviikrdxvkmxxhtkozeghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45eb7305a48d53f01fd443d3bc61f\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部技改规划部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvk4vheljeqvdkmbgvtwigrigkkstgtuumwrihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45e64dee965df0e1f36f4991998d0\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkcvhwkvthhzlk1giqvibitwwkyzzrmmkygqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152e7aea37cee831c2069dd45e68b2b5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司漢風销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjv4xdhtjoxfhvmetrfjiewzgvkcvhwmuksevhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152e7ae53432277d358825249bbbc848\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司专用车销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjv4xdhkjqutsjlkxgtkmaysvjkwzeeuuiyuyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d4611fedf43b66e1adc2e44df8bc1c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkqwrrwvlgiuju2wwhitlgfsvkgugimunfrfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d46124fddc314ceea4d9646749c42c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawrskw5ggfji4ufhvtcugzlkywxumumusfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d4612832688413169869148929fe13\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司市场发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkqwrsmjaswymkqrtrlmiywzikiyzsmwjhrthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d461327fd4f1c3c1874ea4f1bbf933\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司服务支持部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkqwrtjltiguwinftfimmxuhtkfireuwiztthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d4613a22c77488689da974b2585803\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司备件供应公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkiwrttjksfxlkqyywmmlgdzlkresvmkiyqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157e107b7bfe045d817a825415589419\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐州营销中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvlvqrqxulheihik0vgyiljdyskkqrvvmmiurzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15a7e57bd3218ea23674daa4a96b6a20\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"汽车事业部营销公司搅拌车销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtlbhvxuvqtsrmvrdstllougdtkbdzwuljdsqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15adeeeffea73135b4288df4ab0a026f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"应收账款办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtvhhhhww1hdxjietvekjeyygwkldeqtimswihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45ef5d3be9448ce5a1c34f968bd38\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部徐工汽车研究院\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovhikvotehmk2uyfvkndrfjkbizwmujgtyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d462026015070cd311f90489b933cc\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"徐州技术应用中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawsqjlqqrvil4qfgjicrizik2yzemjotffhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d46214e848b25f78296de463baafc2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"车身研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkqwsrkvayuyujcvixmjmzwgvk2wtettlifshf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cef5121d84eacc0e1004654a397b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"商用车身所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk5fhikiesrgmkphdfuibhrqikywvutjmzxehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cef6fe618e64fb7208747718875c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"工业造型所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkhfhilwrhwrmvuwuiulisqylkaxxrmmmxvfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cefa39d3d3f9fdf23534fd3a84bc\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"工程机械车身所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk5fhitjszgtvjfizivwistvjkligttmouefhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d462204240c1a9966862740cca9cd7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"工艺装备部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawssikysuquibdzzlliywslk4qfftmlfgxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1555bf04833f2989e07b0314136bb4a4\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"工艺所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvkkdeiqkmuttijmuyzhiljeqtikartwuukuduhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf00301db53349a8e1a47738b2c5\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"工艺技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlktfiqijuqrgukyttumtkyhrtkaxxtmuksfvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf01bfe94cbdd68613b4de7a179f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"生产工艺所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlklfiqiutihzkuhegglmawrtuk1ghxtimxzihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf049a3cf0ffdbbc7bc4a6981314\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"装备所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlktfiqkmfdtfwihiiguunfxeukrdwzmiitruhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf06d7f29afc909d97e406c86201\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"产品数据所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkdfiqlv0xismttifzimjgzxvkeqwfmlisqrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d46222cf7985f0f3432d444059e4d3\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"车型所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkqwssjurixzmkniqijketsgkkyuqvmvkugthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d46225528a6729c5323a34e90bfb0c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"底盘所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywsskkusydll2szfkjmstdjkbhzquwneqfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d462275b1c7d9a4dff2c34afbbfd09\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"电器所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywsslknerflvczduvwnisfjkhdieuwjgqzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d462291dbd1b6bec100ad4c9da8efc\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywssmipgegiu4wehuieqqdvknfzgtmphifhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf0ee8ef97902c3f37e4828a596c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"标准法规所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk1fiqvv4yhimlyzqsujjitxvkyysytkmzwfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d4622b4ce70b04bfd60124193b016a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"精益开发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawssukdfhxiuequewvawqrjkarztuimrwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1555c033fe958ed6d7a00af40d6b7b8e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"矿车所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvkkjfqtjwrhzvmv3gwglteqqdwksqgwulneyhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"157570f99cb7e6d35869960497690419\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"零部件公司工程机械驾驶室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvlk2xqimmlfexvlbgtvmlazzwikizxwmiiurzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15aaecd4deb8bbe21addabb4f7686537\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"新能源车辆研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtthhfgkvdheyuujhsrtvhgdeukbixwmlivtxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf2a2173c3b080252f34dc7a4b1d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"新能源车辆所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlklfistjyrxtujbeqyijmvsijklgfxtknerghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15aaece94cadcbcd79efe3d4bbdbe62d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智能电器部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvttphfhmkpfdguu1fgxmvdihtvkxeeguvmwsghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf3114080c14789425a40a2b9db8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"电子所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk1fitiiquqyiuqruxmmiusvtksqdsumlgeyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf32c70182ae86a116249029c790\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"电器所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlktfitjuaxqrmjtdhyltarrwjkyzqsmuixzqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf3472249e0d733dd62419a99e0e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"电子电器架构所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlktfitklyssumv0qgxjjdggwjk2rzdmmnhqhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15aaecf34a48702973024cd42f3b0fc9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"产品工程部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvttphfijkjduyliiszxjiesufvkcsituilifzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cea35ccdc405b0790484e64988b4\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"认证试验所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk5fhdjkpffgukuqveilazqumkjhwummkyeuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cee8b9729f018d023e04b99bb32b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"试制车间\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkhfhhmuizxsmwaqryviesthikbezzuumtsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675ceec843dea9c086afce4438b5ead\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"应用工程所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkpfhhum2utgvtczfqmlpdifvkqutyukphdghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15aaed00415b9f4f4f285da41dbb3e1d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"工程机械车身研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvttdhgqikmrvemwcuiuwjmyvgtkwrgeujnhrghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1675ce571568d9040e4ff6d4d55a24a0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"技术研究部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk1fhvliqvwyvmiquqvkdiiwvkjgvvtjkudqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf1df5117118eae740646abaa706\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"性能研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkdfirvwyvrrli2ryhtvaxuqlk4wdettixqwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf2045a3381d2d74b1a4aa9ab55c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"仿真分析所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkdfisikkvdtjmsrgsvlkuertklddztumvvfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1675ce7540ca680d22081ef4686b4bfa\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"产品企划部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlklfhxkkgqfdlmcqgsjieyrhwkawywukpeidhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1675ce96643b198c2b7a18c46d8bc180\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"重卡研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkdfhzll2uteimsyfsuljdryukswgyuuiryqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf3aa59e8c6ffb9f31044c69478a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"车型所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlk1fitttuvzhmuwwiiumbitrikkufwmkmxydhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf3c41a339dc043ecc241d0b007b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"底盘所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlklfituk0rdtjmtgfqkjhhffjkcrgquimqxehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"id\": \"1675cf3ef57c9c6e172b25e496c8934b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"动力传动所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlklfitvw2vxfmukwhrljjesvvkuzwfmmmtuehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d462069fc7711d8004bc94658b407f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京技术研究中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkqwsqlm1ifxlicrgyiiouefmkawvyukmqxihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d46230f8c3347721a07a9427d9380c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"车身研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawstiwkyftjkyxxsitmqxdmk2sxgmjmyqfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d462362053cba735208eb43b2be3c7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"底盘研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawstljiqvtuujdxtkjeqyhukstesuvktfxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d4624ca2bf2ca8aa8e502405e8a053\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"电器智能化所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywsuutwseijundydtmbhvqjkuqvhmtiqvthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14d4625040797431109ef064b56bad6f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"工艺研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkawsvikiqxzlkqtrrimdhiqlkrevwutngwihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45ed9b628396936a4c2f43aaa452c\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部产品企划部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovhgmuywsyjmqwztltcufswkotddtkmvsfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45ee7b451dbd74fb04d543ad81d4b\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部品质管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovhhluauvrvubgxuwumqugkkwtdgminguehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1526c91cb81058e1d218f4a42a4b3f3b\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部人力资源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvjljfzruuiyrqkmvhrgjikyiutkssduujnitehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45edf94927a9784a6d884e6f8e8df\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部法务审计部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkwvhgwmyuzsltqzxyktcwgymkvhwimvoygihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45ee304ed3b7f9e3a4f3481e9a6f7\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部生产制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovhhjiouhgju0xizvjnduijk2yrhmtkwixhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45ee59efe41b41602c5a4da897524\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部采购物流部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvk4vhhkmxhihkibeurliksfvtk1gdymlivsuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4617ccf8aab6988507e745be947ab\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部安环设备部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywrxuuniydtuqwzymkmqxhlkovehmkoxdehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d46137e9ced2b5c172a27448c873a7\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部出口支持部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywrtlvgzfhvj3evfilksdslkuuyfmlktdxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4612e789aa060c7e08044ba1a5140\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部金融服务公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkywrsvlmyzdti2wqflvaqyqkk1edrtkiruqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167060e1c32f5f30559cbf54592b1a5f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"业务运营中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwli2wqhiumtsikwytqvkmpfeikkqvzsuindvihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167060fa24be42c28c95b9c44aca98bc\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"风险运营中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlimwqitjguehkjzfsyumkvezuk4udftmoyefhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16706104aecade886b696f548709116d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"二手车运营中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwliqwrqktxhfdvvayywulmzwikkyyxqmimrwghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1526c92e92fb99cb023e6a14d038f3f6\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部零部件公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvjlzfzsvm4siemmtfeqjjnhwdikbgqtmwktiwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1528adb993c8bc1a489c52b458b80a65\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部工程车辆公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvjm5dgemmstfyuusrdummbfvsukevyemijdwvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"1675d278391fd0e811129024eb5bf7bb\",\n" +
//                "\t\t\t\t\t\t\"name\": \"矿车所\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlkrgsxmjezrivizhyriiaszqjkdhevuwoxeehf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1515b325281847aa595cf7340b394166\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部徐工物流公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvikjetskjqyrykl1ddvmklfixjkkqetmkirwwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4c16c5ce54c323abd05a434091a67\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部总装分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkzfrwuktfhvkuitsttujgqvtkytuqmijdwxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1532fbdc23b20e90513048648d4b2568\",\n" +
//                "\t\t\t\t\t\"name\": \"徐州徐工汽车制造有限公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvjjpiegujstesivyzqvijaquylkcyguujivwyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"14d4c16f324228d3add2bb544bba8260\",\n" +
//                "\t\t\t\t\t\t\"name\": \"汽车事业部车架分厂\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkrfrwwjasusjmfgtdvvoseekkoueetmiswqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d45ef3b676538533499f04203ad656\",\n" +
//                "\t\t\t\t\t\"name\": \"南京徐工汽车制造有限公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkovhijuywxwkjiyvtjkezziikisqttviwvwhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad72437133c65e22b2954a60a22c8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltrgxskjyxrtjuewvhjjjeszkkjdwqtjksfyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad7318a8c2d7056b38c346c3bc8d0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车营销公司综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltjgxtimfdyfjvaxqvlumtyfjkswftuukygqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efc761e2aa1d592b9cda431b8d495\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车公司资产财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvtifxli3hsdtibgvzjuozfgtketremviuzvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137efc761d225eaa026cdac4e8ca599d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车生产制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvtifxlizgsskvdddqjlpfgduk3hyftkmzzghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad7601e86fca90dfe5a94e728b803\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车技术质量部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltrgxwiirhywwubdzqvwnhvdmkbhxsmuiyqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad787dba5ccae9afee274be88be13\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车机加工分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltjgxylv1edvuuldhztwlhhslkdehymujhrthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad7a18721bb43172392f40c38cf5c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车总装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltngxdimaxsruuiutrljatzswksqftmunivfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad7a872fe67733f980454b6da87ad\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车冲压分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltvgxdmlwsihllqxttwmiyqukknewgtmoxdghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad7acd06d69628aebf51456bb497a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车焊装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvltngxduvuqwglmywsytvleivikevweukmzxdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157ad7b1ce0376c534245794225b6b5b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"南京徐工汽车涂装分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvlt3gxeiujhqtllbfvtkjiuvxmkassvulnevehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4c17a7e283542e8b3c5342e58aaf7\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部冲压分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkzfrxtlzhsyjkeushmuktfvjksshvmtldixhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4c17df9f6d41ca49cb284855bd27c\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部焊装分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkbfrxvwcziwvkwrfdkmdfesmkayvvuvmsxfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4c195de853aa570bb88a46e18f990\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部涂装分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkjfrzkvzhyvjtbdvxiujeyytkcwhrmwizzqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14d4c1834e5252c0d7d74724104850d1\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部矿卡分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkjfryjkjhvskjnfqglvaxuxjkqrqumkkqgrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15aae3047c59ff34c4dbf994f35bc188\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部新能源车辆公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvttrhtqklbfvzwwetufkvleizmkritvuuiryyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15aae31f24bd73b133242fc4c64948e9\",\n" +
//                "\t\t\t\t\t\"name\": \"汽车事业部工程施工公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvttbhtrwj4uegljjertjjmusiukjfwumkkyhzhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"152aaf26b97e37d3951fdfd4ffdb12c9\",\n" +
//                "\t\t\t\"name\": \"徐工消防\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjtddislu2zxhjlzgtzkihigivkxiiguiksfzhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"152cee4c80ee2b2375f727f489989e8b\",\n" +
//                "\t\t\t\t\t\"name\": \"消防公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjulhhuumgqhhjuistxkwaxsxwkqyzzmmnhyehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cee5762ecc5df6e5cc8642409c0ad\",\n" +
//                "\t\t\t\t\t\"name\": \"消防综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjulhhvll4shfuk1giwvkdffylkysuqmuoqdghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe67f4c25c062ce23cbf54605be513\",\n" +
//                "\t\t\t\t\t\"name\": \"消防党政工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvuwxikuesvfilwsfhjjpfeikkqwqvuvivrthf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe6b86f114729b46281b248d4b655a\",\n" +
//                "\t\t\t\t\t\"name\": \"消防人力资源与管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvcweylwirruljczeuljeyrejkcyguulmvvdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cee5c97e22ff6490368342a899b8e\",\n" +
//                "\t\t\t\t\t\"name\": \"消防计划财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvju1hhvumcxhsjwjiwumiitwyjk0sdymmneyhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152ceeebac5e9194a534ae24a6fadb81\",\n" +
//                "\t\t\t\t\t\"name\": \"消防工艺技术部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjuxhhhut3fvhmi2zudkjgudhjkndwitvjeyrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152ceee2d2474bf0e71bf3e4da186193\",\n" +
//                "\t\t\t\t\t\"name\": \"消防技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjuhhhhjvasuxku3iqhlileitvkdgdrmlirzthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf1e05c69988548c85714ae1a17a9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防技术管理办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjuvirhikjfwzmmqyvumuiyvxik1dhrtikxdzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf1e7c62e962d7cf12874cb796987\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防车研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvju3irhlumwshmlksgxuwirsylklfexmlizyxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fe6a5f037fa75003430e048df82d02\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防信息化管理室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvcwdvwi2txitlivqqjketqhikgygimjjgqshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf1ebbff15d8746bec934f6aab176\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防高空作业平台研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjufirhuuliirkvayxululhfzjkniwdtuirxwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157e4bc1b2b671e7c5f105d4950a1b48\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防车研究一所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvlvouefiu0sewlinhxfkwarqvvkyzvqtijeuyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"157e4bcd92085536727a8e4411c996a4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防车研究二所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvlvwuefvmysqykkqtwxjlfdyhkk2rrfmmkwduhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166d7546911f7d095bdd0d9471db3d8b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防应用技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlvqxvulmmrrilvaqzvuvngqgmkuxrgujngyehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1689e328543ee6595ec9f6a458da0f1d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防数字化室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmmrhtsmkmuthvlyvzvvukziwtkmvygtinirghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15d496009bf1c199c552efd471fbcf88\",\n" +
//                "\t\t\t\t\t\"name\": \"消防安全环保部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvvkqzwqim1eirui2zzfkkgshivkuxriuujiyyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cf1016be17639c6d6ab34c68af5c5\",\n" +
//                "\t\t\t\t\t\"name\": \"消防工程制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjujirqillehrlletzflvowdejkjfwytwkvfvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cf10d46e2701de275872440da2c69\",\n" +
//                "\t\t\t\t\t\"name\": \"消防营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjubirqvkkwhsliwrghjlavyxjkmuqgtjjfwzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf1ff4c28be4363311d848bdaa0d2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjufiriwkrfsyuvyutwjjerrgmk4yegttkqgshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf20e61c0a29e97fd0e24257aab85\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防高空作业平台销售业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjujisqvlkrfqtjkzhzlwfgqhjkysvxttjeyvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf229f4b22b8a2fb01e84f1982bc2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防营销综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjujissmwcuesjucydswueqrhmkbirzmjlefshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf239f8a87e54add96d8408083af9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjujistmw0ydylvevudvvezwgmkqqyqmjldizhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf23dfdb0ccf15cef0b24ef0bec3e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防服务备件部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjubistvw1gequuzirvuvfiqejkthiquvnfthhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"152cf248570e7709ff0fbad42228730d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防海外业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjurisumk2xqhlleqziwihiedvkqsssmlmtqghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b235ce65df58878d93268454ab8101\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防成品储运部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvujmtvfvlovgikmqyxyvmatswmkevudumirqrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fe6d56818a2683740770d4831913c0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防营销备件管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvcwgvlmerydjlaytxkiaxxqvkyytrmiktfqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fe6d667aa7e33d2b3820c48659e4d5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防营销法务与资产管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvswgwll1ddxvjstgsujiysqukyywvmvkugvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fe78d6b5740dad556ffeb47c4ac060\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防营销客户服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvexygluavxuivldgvklhiihuk0xfutuiqwqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1689e36088dde75eeab32c04d5b8560a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防电商运营管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmmbhtwim4yggvlovhhtuetsfikvgvemkmwqdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1689e366287ba271a60765e4a5e9d899\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"消防军品及大客户部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmmbhtwljmyxetjexrdliixwvvkndvhmviyzzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cf11dd7bb418549d6e714650aca02\",\n" +
//                "\t\t\t\t\t\"name\": \"消防车装配分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjubirrvvwxeekiiyvumvkwhxikywvqtujdqshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16126ea4aeed038cb01a70146af813b1\",\n" +
//                "\t\t\t\t\t\"name\": \"消防高空作业平台装配分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwijwwhdktxhhgijwyfeiijdxqikwwdimikterhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16126e82d33b1b4de19db2c462292084\",\n" +
//                "\t\t\t\t\t\"name\": \"消防采购部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwijcwhyjvmtteiu4ughimlgesukiwssmjiqyuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cf1157956d85cd69cadd47578c612\",\n" +
//                "\t\t\t\t\t\"name\": \"消防结构分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjuzirrklazvwvmwvfglmhfdgvkqxvxmuiwrshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"152cf10780e71bc94c27d98424c9d505\",\n" +
//                "\t\t\t\t\t\"name\": \"消防品质控制部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjujirqlmkqhxiujfzuujcxgzmkmsufmvivqvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16951c8d2b4ab3e1689cc6846899e962\",\n" +
//                "\t\t\t\t\t\"name\": \"消防涂装分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwmkcrfyvjveudujrhrwmmdffwmkywyzmvizwshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1635dc083c34c6ffde5ed214274a0da8\",\n" +
//                "\t\t\t\t\t\"name\": \"消防市场部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjktgfqmjjftuul5iigvklhgsikisxutilgdyhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c4d3ec02146812f4205a6bf0\",\n" +
//                "\t\t\t\"name\": \"徐工液压事业部\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0ugtvuaqsrklayrswkisqvtlleiqhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308da16ca536c81d8244fb8cc04\",\n" +
//                "\t\t\t\t\t\"name\": \"液压领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvzdrwutivtwumcrgyjkwuiemujfquhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308e0eef36da644fa94258aabca\",\n" +
//                "\t\t\t\t\t\"name\": \"徐州阿马凯液压技术有限公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvwqhhwjgwgdlkouidmkysvyttpefdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167299488c536a2af8568cf454face9a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阿马凯 制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwljazzummrfvtltwsdimkewyfwk2vuitunhzdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16729a45a8241bcd30a4f2c41ab9d113\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阿马凯 质量部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlj0zduktiysuiutfgtitkuisukordemvirrthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16729a5aa8ea517d4eff86e4794b4d85\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阿马凯 营销部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlj0zdvtt4yhdkikxguvwjiywvkaxzuukjgyvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16729a62fe6dbf47a5b796747bf9b777\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阀产品所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwljczdwjwfhwguwmuxdkuixzwlkoxeimuixxxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16729ec19cc51d12507c75f4a94a455b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阿马凯 综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlj4zhfimlffvivqrsvilbfxvwkjdzutkmvvehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1672aa53901809b0a14f756462f9712d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阀工艺所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlj1ddvjmqqryimneqdikbixvlk2wsimlmrsghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16970b91ca73c82405df4fc479fa6943\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"阿马凯  财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwml0qeziujdxtumisuqkvniuiukmxzitlizuthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308e1e93ebf3cd7a7043a9b544f\",\n" +
//                "\t\t\t\t\t\"name\": \"附件分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmv0rhzjvleituvcxdxikstdzukmuuihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e1e345503ec118f4e499a17e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvsrhtkkyvqtvuarrywkzhuzmtmrxhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e1e63b78030b8d346da939bd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件综合管理处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvkrhwjuixyqjineygjk4wgdmjozeghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e2de63151d2ec7f4a2599b5f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件生产处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvwsghljarvrvjdhfxwkzdsvmmnevihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e2d88cd062c4e6940c2ba7e9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件采购处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvssgymurgqwjukuhwmksqfsutkxhzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13f89daf8a602681d08579e4d549614e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件物资管理处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtwmgzgdwmbdwqjleyrgimivxzvkjgvumlmruhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e2d03b253603ddb44c396b30\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件销售处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvksgqjuasvtligtggukkuftmljetqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e4d389531419b4c4acaaa3ad\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件软管工段\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvsugtmmqvtrkikzeuuk5dfdttotdghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e4dd0e3cb680e5f4e2caeb0d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件硬管工段\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvwuggivgtfelmcqhvwk3hsftvneqghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e4de2141aa2e7084881bd79c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"附件品质保障处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvwughjimurdtjbhxqmkayyruvmxzfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308da159603d087e384a738bf95\",\n" +
//                "\t\t\t\t\t\"name\": \"液压党政工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvjdrvmleqtgimcxhtmkbdxtmujizvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308db0a0589f8f3cbd42d8a7518\",\n" +
//                "\t\t\t\t\t\"name\": \"液压管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvveqdikeyzimwgtfevk0sgytlivryhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308dfee21f6b964edb457cb5657\",\n" +
//                "\t\t\t\t\t\"name\": \"液压工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvxihhjiniwemlguhgukuvxfukiwvxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1419ab87953fd0aa6b20bc44937ab31b\",\n" +
//                "\t\t\t\t\t\"name\": \"液压纪委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruim1deylmevtividddwujgqefkkiztxtumtrehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308dfedd54cb5a68064f2380382\",\n" +
//                "\t\t\t\t\t\"name\": \"液压挖机缸运营部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvxihgvk4ufektawyqlkbistmiityshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"138f9baf7eed2b52df800a24593b62ef\",\n" +
//                "\t\t\t\t\t\"name\": \"液压技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwwzedwlhhhgjuevsgwmeqqdjkavztuloshihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138f9e28db48b998e8e5f9c43e5b4ea4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwczhsmvreuyumuzyhmvkvizukcthvuklhduhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14b4d84f9b1ad84054b3e36444ca04a9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术管理\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruukrgyuwmferdvmauqvkucthtlkmuuftikudzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14b4d871191c4e396792c964191970ce\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压档案室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruukzgyxiiuzrfkvytzwlmcsfzlkyrzrmloqfhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1533a786f7c2b286ad556f04e199a45d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技改规划室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjjbdxylwcxfsujuywdvkevwiikzhrzmtmuvghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138f9df49c5240c77fa995d46519234b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心油缸产品所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwwzgikmbfvskirfxxwtazzvvkiwvrmjmtuehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee308e6cee3c6abf5f624b169c93e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/起重机油缸室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmv4wfhvjffwduwcviwjkzerwmumzthhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee308e7b2ac0ac374bfd4649b0e22\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/特种机械油缸室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmv0xestu4qdfjlgueivkawuzuijhsshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee308e7bd13f490d5d4a4f74ac91c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/混凝土机械油缸室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmv4xegijbiuzivkvgutkzixutumzrfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14f67642aa329931e2863cc4952828f2\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/市场开拓室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwlqxwujtzdtsmmetrhjmmwtfukazvsmjkyishf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14f6767147f667493f272b54bf8a9785\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/系统数据维护室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwlixwxiksxiwllauztwjmxsekk1eiytmixyvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138f9e02e8b4ef9c446249e4b43a4003\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心应用研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwszhqjvkyeuvwczfuklisuzvkjeuttkiqqthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13e0c49d86dcf692acf01dc4306a8c35\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/产品验证室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtvibfuzvmgwgfwlmzsduwmqrgukitqwtmjftvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13e0c4b9f4e162d4338ec784f98bdbad\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术/产品优化室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtvinfuemwcuhrljjgutjmdhfxmkbizyuvpedghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13e7c7d9815dd747fb2d2ce48a49d965\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心制造技术所 \",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtvlnfxgmmurvgvleuxiujngsfvkkydumvizwvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138fa44d7ac7d4464428108449598f16\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术中心/加工装配研究室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwrduuvlddfxvkauwukjayrqmkiuzvmmjirwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"138fa44109e13aa085bdf5f4e1f874f8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术中心/表面技术研究室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtmwjduuii0zhrjtjdqykudgivwkvhrimlkuiyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137ee308eaa1ced6b2dc22047cf9a297\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术中心/材料焊接研究室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmv1ddruvfgwejvbfssik4xfimtiszxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15310c7b91986dfe85f055d434893a3b\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"液压技术中心/工装刀具研究室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjisqfxumarzylvlihykwaqvvvkytuymjndtehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"155e3c267fcf79e15ab0e0d4dab8038c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心系统产品所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvkvstfsll5ifilmjhrvtucqhqvkhgdemimtyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13dfcf71cb57e2d60be0a964648aca33\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心阀产品所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtvw1fixiujevxvjrgwquvcqdzlkywuytujdtthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14b4e169b261f602f2240c24dafab562\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"产品设计室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruukjhrwmuaswrwleqsijjeuqfjkpgdituivwshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14b4e17771d78d4b998143d4b38b7abe\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"产品工艺室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruukzhrxllcrgxmvkuezmmarutvkretyulpdehhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15285a6cc5e5477c196807b405fa36d6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心附件产品所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvjm0vdwuusvhvklkxfrmlayqxuk2qvitjkwgwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"158bce20827cb08a676ebca4725944c9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压挖机缸运营部技术\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvmudfhsimesxfuikydwllpheftkixsvmkkufzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15e4b384bd6fc1ea3323c834cb78e574\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心实习大学生\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvvkbetyku3gwiuilhdtjjktfyjktfexmvivxuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15f480c91b5fa4f5c5c1b5947f294fa8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术中心产品工艺所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwk2yqfminevitk3ivfkukrevmkkxismklidyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"15bf13b9b9a5219244d36ba410da9abe\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"液压技术中心/创新工作室\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvuwmrtemuszdvjiazsukvmtwetk2rqgtmpdehhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1587a0fd3e65fb950a174db4fccb8fee\",\n" +
//                "\t\t\t\t\t\"name\": \"液压装卸缸运营部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvmlvdqivjbhwvwuyzvqtiexugukhiffumpihhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"162b248b166b50f5f730040433f97783\",\n" +
//                "\t\t\t\t\t\"name\": \"智能制造与信息化部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjuqsuyuimwweki3iviljaqquik2ttimlixythf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308ddfc7df2e24c66c47f38b485\",\n" +
//                "\t\t\t\t\t\"name\": \"液压财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvpgiflvfishjkjfwwukcxitmuiuyvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308db0721ef65404fa42588ec43\",\n" +
//                "\t\t\t\t\t\"name\": \"液压营销中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvreqxjilhiwkkmquitkqsvymvjfuthf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308dd021d1bb5022f04e41b531d\",\n" +
//                "\t\t\t\t\t\"name\": \"液压品质保障部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvjgqsivoreekiessiikrhurukmtrghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fdcec0e0792b421f013634b5792b9f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压品质保障部质量管理\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwvxfhfivaqxzjuausrwiirtwjkjevxmjnezihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fdceacee56913d6f8068147b49b305\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压品质保障部质量检验\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwv5fhduvzhvwmictgwwmiqwyikkxeumuitqvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fdcec594912120daf84704dacabf47\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压品质保障部计量化验\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwv5fhfkmquzrjimsqgtwayuxikpgdftujiuxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16025da92baf3b4396370ba402aaffe0\",\n" +
//                "\t\t\t\t\t\"name\": \"液压表面处理分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwijovgdmjpedijuqutzljmxqetkmqsdtwlihqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16025dc025cc849e16f2e03440d8bfd2\",\n" +
//                "\t\t\t\t\t\"name\": \"液压中长缸分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwijgvgfijgvffmkczhrlwkshqjkeuqgmuligshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16025dcc4b0dafff17c5b684981a0d3c\",\n" +
//                "\t\t\t\t\t\"name\": \"液压短缸分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwijovgfukneqgtw1iirlucvewmkizyrtingtfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a16036dbe65a7105f1e7b4eed81574\",\n" +
//                "\t\t\t\t\t\"name\": \"液压供方发展部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtiawqtlv1ehwktixrqkwcrhxukxhhgmiivxuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee308dc0f189a8058cef43248b0fd\",\n" +
//                "\t\t\t\t\t\"name\": \"液压计划物流部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvbhtqmvnfqiimszdyikgyfhwkatsumuoqighf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14d2702d6f88a6976e6639e4d5589c86\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压计划物流部计划室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvjaxqsvljiyytlizxwvliwtzvkrgvvmmjfywhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e5c168fa7ad01eb47aca25ba\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压计划物流部物资室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvcvfrlmlidxtveqrhukoxdftjovedhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee308e5c70934832575e46a099ed7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压计划物流部配送中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmvsvfximituyjjivxvvk0wdqmmlhgxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1442f1159465b39e8ad8c8847638e1ac\",\n" +
//                "\t\t\t\t\t\"name\": \"液压设备能源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprukjzirrkmquwvujkzhytvcyfymkqxwtmvordfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"137ee308ed9f792cc91029645d5a448c\",\n" +
//                "\t\t\t\t\t\t\"name\": \"液压设备能源室\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvrhtqmv3gzilm4sffmiaqszlkkvgvtkmuyfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15d1c8ac3e71d60c3ba8c5c4faf91090\",\n" +
//                "\t\t\t\t\t\"name\": \"液压安全环保部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvi3fydujbhxrvlsqftutkyfvuk5idimiiqzqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"159430f5c9b8b0ef2f52a564f82b02d9\",\n" +
//                "\t\t\t\t\t\"name\": \"液压后市场服务中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvmk2tqikuczeyuithiswkcsdvlkbiysuiksgzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"159431946ad753714ab6864405a83b48\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压再制造业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvmkatrzkl1dgxkjixrutuawywkkuqvdmjjeuyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1594393a053db9d9f3df4e649b880e01\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压客户服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvmkitzttiuvtgumngzijvfiuhlkczeymijhqrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"139421c3f9d48f18449ba744bfb8b8e5\",\n" +
//                "\t\t\t\t\t\"name\": \"液压测试权限组织\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtmkmsrfjwczgumwqryukmdedxkkheiemukyhvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1651833217135115c3fda7d464f8e814\",\n" +
//                "\t\t\t\t\t\"name\": \"生产准备中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkiqyttjiyxrtkimrvfjwdgdxvkuwuimviyruhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3bef54f46d8a46224baf8c72f\",\n" +
//                "\t\t\t\"name\": \"徐工随车\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvpggfjudhivkwuuwgmtauwsjkxedimumxsihf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137fd975544cccbb7924596447ebd0eb\",\n" +
//                "\t\t\t\t\t\"name\": \"随车公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkk2uufuuleexmjauvzlkeuxhuvoqhehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd9755d1122d2448f55e48e195ea1\",\n" +
//                "\t\t\t\t\t\"name\": \"随车技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkkbgrrjjbgsukmjivvvk0yhrmklhdrhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a8b587ac73046026c874145b1bc2e6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车技术中心办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmzevyltbfxtikqwqsluiyxuiksveruukshwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a8b5c276eb06a62d2ef394695aa639\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车清障车研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmvevfjlgwheilbdwsvjlhitmkywzvttiwtzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a8b5c51af1cd19d78b0c34f09af6b1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车高空作业车研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttm3evfkildiruvmrzglmneqfjkjiqztwkwerhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a8b5c743f2bf3377f667e443e8f672\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车起重机研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmnevflkctisuwittxlwiwwxvkeuthmwiwxshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a8b5d071494bd3dadeeb64a148912e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车桥检检测车研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttmvevgilaruzkungtgtvhhhelkrdrummmrshhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13a8b5d396fe2497fa1511947219d516\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车控制与传动研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprttm3evgjmgwihjk2zxitiivrrmkixsrmvivrwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151a952ce37c3b583adc0604fc091875\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车产品工艺所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvityzvsuvmtxfjuivyttvbfqwik1ifqmiiyxvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151a9528ce95390fd75fdab499ca7fed\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车制造工艺所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvitqzvsmuzhzvjm4qiglkhigduk2zzftlpihghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151a95aade01b412854448348a98797a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车军品研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvitmzvdtvbhqrukirsykkiuuyjksydzmlmzxdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14908ae4dc546140d3699f74c57ade2e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车工程中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprumigydhkvrfvulimuqgjlmzzilkjfvxtvnhshhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15fb90750e119fc33a870864bf18bbe8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车档案室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvwuizqxkijhrrmwjftttmaxqylkdeirmulehyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd9755e16c796d158a6444f6a05b0\",\n" +
//                "\t\t\t\t\t\"name\": \"随车生产制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkkzhrwul2zwgikcydwkkkuiwtikveqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd9755e11f07fbcf44624dfe8b527\",\n" +
//                "\t\t\t\t\t\"name\": \"随车品质管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkkbhrrwioxieuwauuwjkhgihmuivsxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd9755e1247c7826cc30461a85553\",\n" +
//                "\t\t\t\t\t\"name\": \"随车人力资源与管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkkrhrsklbfxyjldfftikuwrdmkivvthf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd9755f06161f2392ae348bcb8a37\",\n" +
//                "\t\t\t\t\t\"name\": \"随车财务预算部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkkjiqwil0risjmosdhjkgyefumjdtxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd975600983c02f662a943e687c9a\",\n" +
//                "\t\t\t\t\t\"name\": \"随车采购物流部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklqqqzmjbfqswlmwsdmksthwmlnfzdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97560f0197b905f3b848db9f8f0\",\n" +
//                "\t\t\t\t\t\"name\": \"随车机加工分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxkl0qiqimsxezikfitemkoygemwkyiqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97561ff394a7342f1842888b9ae\",\n" +
//                "\t\t\t\t\t\"name\": \"随车结构分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxkl4riijmkudxjkcsirmkasyymuozdhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97561f77dd38b2addd48a188e32\",\n" +
//                "\t\t\t\t\t\"name\": \"随车随车分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklkrixlvbgtyujhdggvkcydrmmjhtshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15dabcfe9c98d66a4bb75d0467dabd14\",\n" +
//                "\t\t\t\t\t\"name\": \"随车装配分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvt5efivmbfzyvlcwduuuexvgikmwxgtujgruhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97562fbc4eb8edfb9b4f0c9f3a1\",\n" +
//                "\t\t\t\t\t\"name\": \"随车专用车分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklosieuklheyvvdiezukniqfmwktdrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97562f9c244fa95c6a421ab76ba\",\n" +
//                "\t\t\t\t\t\"name\": \"随车营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklksizuj2uuitmkvfwtkusrdulowedhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15da6aba45cd19fb5f30c054c519f35f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"营销公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvtowdetk4vfgimtievwjkqfqkkjfvrmwmtvihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fd97565e4afb2d5313b44b958e932\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车市场管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklkvhutw3esgkjertekkrezvmviztshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fd97566d68fb11f3860344d7b0cbc\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklcwgwmwrerrwjiywqjkcugxuipfefhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fd97566d27d3d4b578004237a8f05\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车客服中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklkwgslvstguukaxyqikistxtmjiqvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"146a2bbafe88c03a0f3d097433aabf34\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"技术支持部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprultoseetwjhyyuistdqwjjgqzlkmttdtujituhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14fa575d3cac8b4cf8d187f4601adb09\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"后市场技术服务中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruwtqvxvvjhfdfmugufimvaryxwkiwqrtvjeqzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15dabcd267c1eb2b4e66d0e42809f003\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"随车起重机产品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvthefgjlkxfrvukseuvlkwgqvkisyqmwiqqthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15dabcd804dfe2e87efb09c44498a254\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"高空桥检部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvthefgmiougivjjhyxvwjeqzukquuzmtisvuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15dabcdc3e0e3eef5d277f544dba7220\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"城市运营专用车辆产品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvt5efguj3hqhjvdhivvjmxxikk4ugetlissqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15dabce71d9947f2c0fde484b7b9058e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"出口部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvt5efhlirgzzklfisfiwdghumknexemimvyhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd9755c1c541666b8cae4e459499c\",\n" +
//                "\t\t\t\t\t\"name\": \"随车公司工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwzgzxkknfrfkkarwwluoyfdvkjhuvmkmzzfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a01a66a2140ba80639be5408f89cd1\",\n" +
//                "\t\t\t\t\t\"name\": \"随车公司纪委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtisrdwltasruiurdyqljozehkkuqyimmlfgrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1410ae0efab0513c1df0ed54099aa8cc\",\n" +
//                "\t\t\t\t\t\"name\": \"随车公司团委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruiildhqvw1deqkictfrvwoqhgkkyqzzttoyffhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15da6a71868c144731495db456c8ecf5\",\n" +
//                "\t\t\t\t\t\"name\": \"安全环保督查室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvtkwdximmwyfikiuxtikezvgukuvwfmvlfivhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15dc606b6d913dc55107e9a43519651d\",\n" +
//                "\t\t\t\t\t\"name\": \"随车法务办公室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvuawqwuljgzrjvjfvviikxhztkitvrmlmvrghf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137fd97563eaf8aa01f2d5f417694266\",\n" +
//                "\t\t\t\"name\": \"徐工环境\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxklgthdwmlddqiwcsgvwkirxwmkiswwhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"14d4b6650e8c59053113e8d487897212\",\n" +
//                "\t\t\t\t\t\"name\": \"环境公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruvkjewwki3hyfkmyqvtiicthyvkyyxymlisrshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97563e637884faf1034308855b9\",\n" +
//                "\t\t\t\t\t\"name\": \"环境技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxkl0thwjlqyyuwtjirqjkqtqymkkvezhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14ff3d9c6a8b7d51d462c424afca1f67\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境技术管理所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruwwktgzulndyelvevrgklcsfujk5diftijiwxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15012dc8030f91508fd9f2046d684c0e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品技术研究一所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprviigsgfmi2tqimiavqywvczisikcwgwmknfqhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15012e27284a721240b7478476c93554\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品技术研究三所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprviikshsljmyudljarsuiuaxuxmk2xwfmjivvuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15012e3d0b1dd8cbe5ff8384b6bb57a6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品技术研究二所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprviicshtvifergvmpfehkwbiytmkveweukkxdwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15012e45fcab434e3119e25423c822a6\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境控制技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprviikshukwxfdekj0uhtiikzhskkestfmjksdwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15012e4f398e3e03e8c9e36450580cb5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境工艺技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprviisshuwj2zyhjvuqthmuczhtlkavqvmilfevhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b3c29f2b920dbb48fdd3c4267a650c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品技术研究四所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvujbfszwjbezsivdeeumwlggtukiswxtlmvqfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167aa1d2fb5f1ddee9b7d6c4755a64ec\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境信息化技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwltfdrgjwneviivpghhmukxgwukixvvtlouhfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167aa1dfd9b5a388d034d7748dea036d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境测试与分析技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwltfdrgwv0zevtjuyygijkugxlkoyghtimtwghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97564e49af71b6c6334150adaa8\",\n" +
//                "\t\t\t\t\t\"name\": \"环境制造中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxkl0uhumtbixruljfwtjkirvqtvlddyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15a93a6cb3414f2eb8a9d784a1eb2248\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境制造工艺所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtmktdwuuaturkwwshemtczgxmkfdrhujisuyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15a93a77d047df4740756e24b329ca51\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境制造中心采购物流部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtmktdxlvaquxvwquxuilevwhjkzetsmujdvrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e16b38bd24b5d06092124be8862aa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境制造中心制造管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvmrwejmdegskucvgqliazsrjkdehymlosddhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e16bd6b71203a8b9b2dc4aa2b9b90\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境制造中心结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlverwevlbexrjistdyumnesguktddsumjezqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e16c7519d354414fac964892b4e71\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境制造中心装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlv2rwflk2rzgjkauurkwddfzlkayzsukjhxrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e16d0f1d218e9025b31346ed9bb13\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境制造中心工程中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlverwgiwkrgsimrhzqjkjetrjkowhgmujerthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fd97565e41af083055fc41bfa6ea4\",\n" +
//                "\t\t\t\t\t\"name\": \"环境产品营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwjgzxkl0vhuitjiqyjimvviukoreitllhduhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14f5f11846d59be986593b54d27835e9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境营销驻外人员\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruwkbirrmkkwgvmurhzylkmztekkrgsxmjkvhzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"150210760be7e142b12e05d47d9bdb89\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品营销公司销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvijarqxli1ehxvimuseijbhqvvkcxgzuvjeyzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"150210afa329405790ea18a4003bdf7f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品营销公司市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvijurqdwtatszkiqvxzivjdrytkaqqtuvnixihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161c1d7286e0e2354243984436d8134b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品营销公司综合管理部 \",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwiucrgxjmkwhqvjatvujkatzykkutwgmimtuehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161c1e629e1d13a29a4f70f4afe98c80\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"环境产品营销公司工程项目部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwiusrhwjm3hrgijjdsztkbixqwkpdihmmjfyqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14e009571556b3398bf4e6a4cbaaebb2\",\n" +
//                "\t\t\t\t\t\"name\": \"环境财务预算部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruviyqzvliqvvwujatzyuwkuhwtk5fedtvleeshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14e00dbaf5e802f5466218a4d5294239\",\n" +
//                "\t\t\t\t\t\"name\": \"环境人力资源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruvioqgetwcvhyijbivullisrytkjgvsmkistzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14e00daea356024e87dd881481f9c2e2\",\n" +
//                "\t\t\t\t\t\"name\": \"环境品质管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruvi4qgdvtatvwijkuhylvjgyyik2yrimukshshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1562effa80d3f1b76092db64694a9776\",\n" +
//                "\t\t\t\t\t\"name\": \"环境环境服务公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvljphiitmsqgtwirexwimgsgelkywzutmixxwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a01f76d6d5ab1ac21024741508edd8\",\n" +
//                "\t\t\t\t\t\"name\": \"环境环卫运营公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvticrixlvkwgvtuwrdfjiiqsulkqrvqmvlggyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13fa75d856d86b5d3ef8d71406f8daff\",\n" +
//                "\t\t\t\t\t\"name\": \"环境客户服务中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwtuxvgmkcwgylukvgtvwkygxikeqwimvpdiihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"162fc3e05be4217e895cdf2462091277\",\n" +
//                "\t\t\t\t\t\"name\": \"环境安全环保部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjwvfthiktehuji0xhymkhfgijkywsqmiisxxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15cd377dbd202496c38c72049219326f\",\n" +
//                "\t\t\t\t\t\"name\": \"环境安全环保部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvuvatxxvubgsqjkmzwfjmbfxsikyzsrmjmswihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1602aabf788bafe0f8dfbaf4a62b6559\",\n" +
//                "\t\t\t\t\t\"name\": \"环境投资管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwijxddewlmyyetwfhqimvhiedwkbdwsulivvzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"166d3acf7a932d5d21790494018b7059\",\n" +
//                "\t\t\t\t\t\"name\": \"环境综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlvwtdfwlbdztjv0vgsilizqumkqqryuliqvzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"160969b163ef0874c73eb014b538d89d\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工湖北\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwimmwzeilgthiim2xufljlheqikbevtmvmyzghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16101aff3c4b15083ea320c4d8182549\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"湖北制造中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiiwrdiwj3fueikyqytvtitsqukbgyrmjivuzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16101b051ea8d14763f213843c2a599b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"湖北营销部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwii0reqkithdyviiuxwjwasrtmk0tfstkmzzehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16101b075bfe677717f000841a698be2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"湖北项目运营部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwii0reqlkxeihllixxrlwaqqqmkkrdwmmlehshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16101b08cc88117fdb6ba3d49878ca5f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"湖北人力资源与管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiisreqmuzfyyiigxiguldedtvkqzyxmundvihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16101b0a4ca4fd8b533e38b4e8abad95\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"湖北技术质量部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiikreqtkdfduwv0yevjjbhtyukvhydutjgzvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16101b0c6ac8c7cf624015343f1a8d59\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"湖北财务预算部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiikrequl1dfyuldfiwjkiqrvjkktirtmjgvzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"153213bd78b102d5359807a414381919\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工辽宁\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvjjurtevlcyerijzgvtkmiyqxtkqrutmiizrzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161d1ab184381236dfe425b46fa87c80\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivordeimiutyijutwgwvausvukwwidmljfyqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161d51662e133b5064c168746d099be5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁研发中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivavrwljjhrtjuqvqwkuirwylk0wgqmmlehvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161d516bb7ba8b1c64fc2d54507acc5b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁营销公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivavrwuugxedmucrfwkwnfsgkkyvqxtunfvehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161d51727c43b66edac49e44d908fb4c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁质量部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivqvrxjlbfutul4whgtueuzhkkbgzqmwneufhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161d517857da9dd136d47714d62a93ea\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivqvrxmkoxgdmvbgrtlviuxxikzgwstmothdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"162089cb3b956d52499546d4609a113f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁结构分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjiuyzfujbezvlvyvsummavuwvkywqztimrtihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"162089d2bf467b6be9b54c847ad9adfc\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁装配分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjieyzgjujiuwluowehmuevufmk4xdgmtpgifhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1621ce0cfa1e1d5f9ebbd9d4d709927f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwjilfhquwndrhivkvizvudegzvkzgxqmmmsxihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16652f21d7f96a1f7f1c37745fa85a49\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"辽宁综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlkksisivsxizltsrixwijftxlkwvidmkjduzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16657720ba35b57ae87b4b948e1a1224\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工博德尔\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlkaxxsiurdtvukwxdhmlneuemk0yhrtiissuhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"16395fda888494a89e82fd645ab9521a\",\n" +
//                "\t\t\t\"name\": \"徐工研究院\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjmovigtmiyyumkjdyzvmgsiglk4vdemkmsrdhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137eddc3c6c7f1b36e29f2643f09841e\",\n" +
//                "\t\t\t\t\t\"name\": \"江苏徐工工程机械研究院有限公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjuswfxwijetwvjczislkktiqmmmurhhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f32088ee04ebec334ee14717b39e9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院院领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatsqmmthhqkv5ehfjjouhhikqxrxujkzhzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f32089e8cab30916da344e7da379f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院综合管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmmnhyftuitqzildgdtkk3hxgtjmxzihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f32089f719bc9fe9db0e41af9d669\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmmjixrmu3fzivmlgeqvkordimviwwzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3208a07f0a275c8861b43258ef56\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院标准研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtuqxiitisxvumaywrukqtsvmvjivwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3208a4528351f7c5e1a4602ae83b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院工程技术中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtquvsmj2vrilukvhrtkywqstvmytehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1537d302de5d891df5aedf442b2b69c1\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"技术应用部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjlbgtqjvvhvgmm4rgikthhgikkcsesulkzfrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1537d2e6e97880536ace3c34ed59e9e8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"先进制造技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjlvgshlvazxymiyvtwtunhtfjk1hgvmvkzhyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1537d2f5568303868f0493f4150aee99\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"工艺技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjl3gsikkqwytijaywywiauztwkyrvqtvjhzzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c32c6a6d1cd9ddbf49da7466cbb53c\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"先进制造\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvujksfwtlvgrfvmhggewkozgdlkewwfuumvtfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15c32c7e00d5fad619c415f4e1495653\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"焊接实验室\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvujksfxvisqgvwtzgwrmuaurvwkzhrumkiwvthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"142e4711e045cff5df291204e09b3502\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院实验中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprujvyuxriviquvuwfivgwjazrsikrhqzujivqshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"143aeab91ec3ccd639cdb6144fd842bf\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院研发管理中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujt5hdemi1hftuuzgwtmulgewikguigmkoseihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f32089f70b41a6c5a7ab462fa90aa\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院技术管理部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmmbixquk0rdwukfdxduk2wsitmoqddhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"14e1e32b94b672a968e60ae429abc9f0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院数字化研发部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruvirhtsumkuewljrdzwmvmwqdvkuszduukziqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"143aebae91bb2e590f81b194ad1a79a0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院产品研发中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujt5hedvmwreejvavzqwmkrermk1dgrtlkzdqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a36a34c3d00737740b19988a\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院产品研发一所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtmtwdjkfftgiiixtxlk0qermmmyydhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a458a045f686b744b6298dcb\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院产品研发二所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtiuvytieuvilmcwexkkjewsmmpgfehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15373026804db9f5d48c094485b86e36\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院产品研发三所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjlatqslmuqugumfivgkmbfqzkkeyvemljhtwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15ea3166739070808f8d99d4414b78ce\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"挖装机研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvvtqtrwllitzqliayqywmbgzzvkquruuloyfhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"143aebc8bab63372f6c64664deabdf49\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院技术研究中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujthhefmu1dewjjuxsiluawuwlkhghduvjiuzhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a07ae2b1f55f4e84140b9526\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院液压技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtmqxdvj3erikkfiuhmkqruqumivswhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a16175e9422fa7c465b89444\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院智能控制技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtyrwrlkbhzujjlidxukuwvemmiuuuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a163caf947b239c4adc9cb66\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院传动技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtyrwtutjizuluistzuk5dgfmujewwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a262d5480dc25ca4d179b1fb\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院结构技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmtqswsvkquyqvumsvftkjgrxmuoriehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137f3208a36d3715759d2c54dc0b8a60\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院整机技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwqtsqmt2twgjlyrvxkmngsfkkdgfqumjdwqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"id\": \"15caed789215a404474101245818252f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"name\": \"综合试验场\",\n" +
//                "\t\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvutthgxmmisrvtkiquulkarqrjkavyrmjmvsihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cf57e429e6735ed14642c4a72b00e6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院材料技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwevxhkj0zhwljovhgikiwusukbdxsuikqhwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"13cf57fbe54e3fbe36403d2411d9d789\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院油品技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuwuvxiuvmvuhjwdehtlkeqtgjkmrrgmvixyzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"143ae551b53b1a0c0c4b6f74feeaf581\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院施工技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujtjhvviu2vteitkqfquknewilkpihhtwivyrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14c72da6b77fa327f5c8ebc4af98958d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"研究院工业设计中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulgsgdlu2xxitj2sxikuoyheuktdizmmmvyghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"143ae756b1238f352c561154148bd817\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院工业设计研究所（徐州）\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujtbhxvluarstmwytvsukiwrrkkaruyuviyrxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"143ae7ed16729233d6d4f3c4bc0a8741\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"研究院工业设计研究所（上海）\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprujtvhxhviiwxsmjettglvkuituklefqtmixurhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14fcfe6f6847f4dfdba540340afa31cd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"美国研发中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruwudihwwlayuxwkxgigutivuqjk4qditjorfghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15bd69f1b3d3cb44605ff1248849741a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"高端工程机械智能制造国家重点实验室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvuvmwziiuktgtuuquuwikdiirjkyyyumlmurdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1633d4c4dd8dc210dd9d72e4595a3b61\",\n" +
//                "\t\t\t\t\t\"name\": \"汇智创新中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjfgufkvngygujurqgvmjgxsvkyvzvtjjewrhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d4f65b89257000b355d457b8e076\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjvguilkreyzjkaxqqiuatvvvkuvxemviqxwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d56a669dc0ba6382d794599812ab\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjjgvwtlmwzguiledwjmksgxmkqvzzmiosdehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d58102a1267367fc9e44f74aee9a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"技术管理与合作部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjjgvyiicsdrjlixtwlwffzhkkzixutvnhzdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d57e0eded0f9ed90f4d46f7985d8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"人力资源部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjjgvxvihhghvivizhvmcqiuvkkwixmmkvgyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d583ba0d568a0dc7c714d3dbe844\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"战略发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjjgvyjundqgklsydqvukxfxikvgtguviyuuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d58b7f42e1d581abe314f2cbfa11\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"传动技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjrgvyulziusvizgvyitlehtikfisfuwjdrrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d5873888246611ab86a4aaa9d847\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"控制技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjzgvyljayyyjkywwritjeywtkpdddmviyuxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1633d58949d54bb6b402a6548ceb4ac3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjjjgvymkczgvkufewekiksdwkkgyfhukldfthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13e49012e74a66e47e1b700484794276\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工欧研中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtvkqzqrjvexudllzhuxvibexqikiyuxmkisxwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"163960e3ed790e8d6d09b2e42e1905da\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工美研中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjm2wqhjvrgxzivcygwvikzesvkkshrmiovgdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1648845af8a37c5654132024472a0ef2\",\n" +
//                "\t\t\t\t\t\"name\": \"高端工程机械智能制造国家重点实验室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkmiyuvtw0ydtluqvwvkiatsqjkiuxstilhishf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"166f74c4fdba7b3ceef704b499da6a91\",\n" +
//                "\t\t\t\t\t\t\"name\": \"综合管理部\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlwexufkwpgedluotfhvwaxquukmzzgtljdzrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1679b01a6124b49c78dd0f948e78bcce\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工集团工程机械股份有限公司江苏徐州工程机械研究院\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlmjeqrtlarsuukczfxmvngqimkcyhxmupffhhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c1e09a2903cb7d14b1fb7a34\",\n" +
//                "\t\t\t\"name\": \"徐工技师学院\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju0rhqmtyszqjunexgikveriuljdtuhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052e0818b3083c49b4eed8ea84\",\n" +
//                "\t\t\t\t\t\"name\": \"学院院领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkjjhqyimretqmjbfuzukxhhgmvjdyuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15372b94bbf5a11de32bbd3498da3122\",\n" +
//                "\t\t\t\t\t\"name\": \"学院综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvjlcsezku1eivtiorghjjpeegjk2zygtjirsshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052e035f96e2312ad46b185b86\",\n" +
//                "\t\t\t\t\t\"name\": \"学院招生就业办公室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkjjhqtkwuzwhjjersdvkswermkjeywhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052e03ed7fce28a204d24a0ac0\",\n" +
//                "\t\t\t\t\t\"name\": \"学院财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkjjhqtvvoxifvjcydsikjgsutildfqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052ffed09bfe93a994a8da1fd1\",\n" +
//                "\t\t\t\t\t\"name\": \"学院教学研究部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkjhiihvi4zeivmktdzmk3dygtiligrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052ff0fe7b2dd50f54404bc4ec\",\n" +
//                "\t\t\t\t\t\"name\": \"学院教学督导与评价中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkjtiiqwvcxesvvmvqikkququuuouhfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052ff23528a80cceb405bb4447\",\n" +
//                "\t\t\t\t\t\"name\": \"学院学生管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkj1iisjkesydmihffhukeqveukiuuxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc052ffb5f0659ebf684758a466a\",\n" +
//                "\t\t\t\t\t\"name\": \"学院团委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvlifqkjpiiekwyqwvmvdeiwmkixvytkmwwdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc0530f72eb90764aff4abc846cc\",\n" +
//                "\t\t\t\t\t\"name\": \"学院培训鉴定部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ifqkjsqixjvjezqllgudiwkhdefmkowffhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137efc0530fa7a590d6b36d4a27b3972\",\n" +
//                "\t\t\t\t\t\"name\": \"学院后勤保障部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv1ifqkj4qidltavzqvlbetwvkrdsxujizxshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16391581d60513581c6bae94d2091f8c\",\n" +
//                "\t\t\t\t\t\"name\": \"学院组织宣传部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjmirvyivywqvijivyrulpedhmkzgsqminiyfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16627dfa0dcd7c05ef8be584256a6ab8\",\n" +
//                "\t\t\t\t\t\"name\": \"学院学生工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwljoxgiti5gfglueqvhwmdehvmkisvwtlldeyhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c1e0e45d47ea2324842bbb94\",\n" +
//                "\t\t\t\"name\": \"徐工重庆\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjukrhqvk0vgulvbdstjkayusuujezuhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137ee3ea51cc00b6121093a4ccca82a6\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv3hthtkgrffiirewrjiiqzttkpffftmksdwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137ee3ea51cc5fd3ad2c79740a2b71a2\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆党政工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv3hthtkorffkwfgtdvjjfxzlksqdsulkrdshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13c774a5ed381b975770cfa4cf79a625\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆财务管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtul2xudkvjgtyiuyzxvlloqfitk1fixmtiwsvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15281e5298a9befb9a52fb04fe892364\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvjmsrhvjmsydzuv1ieztkgsieiklihymjitwuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15f9e435a25ff9f29de485b46f6ad23d\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆质量部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwmzhutktusviwmriszvvauyvukkwiwtvmstghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1543baf616e86cc3f58b20249f5b1e5a\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆生产制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvkjxediliswhylunftikmbesqjkszivuinhvdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"167ed88baa91e4c6557a405476f8a4c7\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆采购部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwlvrgyyutjdzrvkzfwvkljduqkkuxwimtkufxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1648d70e5c05ab02dd53b8841b2a7182\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆安全环保部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkmzgxqvkjfqvtuuqsgvkcteymk0restliryshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"149985ae285b2b5503379d54698b46ef\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆市场管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprummmyvdvjeyvejuyvvqjjmxzgkkawzyukowhihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15f9e4859b353bf8e2578884c3eaaabc\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆装配分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwmzhuykmjetvjuviyhjkaxyymk3fthttpdefhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1648d76df0b535751391b6a438b8caf0\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆结构分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkmbgxwvw0qevjkyxvrjmkrewtkutyemuldiqhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"165402cab32086c16f623614981ae302\",\n" +
//                "\t\t\t\"name\": \"徐工矿机\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwkkmqsftuatsqmlbfrwwlistwikyzyrtvitqshf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"15f9a8feef0305576cf1e12498997cf3\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwm3dyivvriqtikivxwuwcrhrjkyzyzmllfithf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a070c0e4339d8985c6ccd400281400\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtiuxqfiviuttmvyyzykugwffvkqqqsmiiuqqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a070daf7f137e8b35fd1f48ad969fc\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机结构厂 \",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtimxqgtw0xirjl3hyejkdigrwkoydgmlozifhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a070eb4d7470dbfe78bb34f20b632b\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机装配厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtiexqhukjgxuli5geivloyeejkbisqulmtsehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15cb026db81a1eaf512092a4b0a9df01\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机质量部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvuuaqswvu2yrdivldivijiqzstkneqdmvjiqrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"168a7b17204efbd3835a72f47b5b962a\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmtkxerljequhwuzgtyjkbdxswksxevummwsdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15d5dda4a1df0f8867a57974e8d8321a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvkxggdktgrgiiwyyywltivxzlkvhygmjmsrdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161548a570432555b9447a745fd8a8a3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwik2uydklqqutjkmvvemkmuxdlkwvigmtkydthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16912d3bd4d9f59d9accd404ccc9442a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwmicsgtuvsugzwk0zgztudfguikpfffmkmusdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16033e1ab3c4d8ed007885848cfbed5a\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwijkthrtuctfuvmthgqilayyvmkwyfiuvngvdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137ee3812adf7bf807180f5465fb0bc0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机技术中心矿挖研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvjhtyijpdgiluziyqlimyqikkewviuilefqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14084be5b612e3323080a454fd78262d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机技术中心矿车所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruimouehkuywrsvjatstimkqdukkdigxmjmwsghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1600b73124ba302a506c8ed4648998fe\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机技术中心破碎筛分机械研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwiijextijouedjicsdvilffyhvkywuymmoyihhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16033f8a6072bcf96c832f44832b6d7c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机技术中心控制与测试所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwijktiytlqqxsuujizwumetsikkaytsulngxfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\"id\": \"165c26c562ad3ea89bb15ff43b0b5668\",\n" +
//                "\t\t\t\t\t\t\t\t\"name\": \"矿机技术中心测试所\",\n" +
//                "\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkumswfkl4sdgjvbdyzuuerviwkstequkiwwyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t}]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16033f8ff29d45d811820674597bb0a3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机技术中心工艺所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwijctiywwuszgkkjgyrimisqwlkavzxuukqdthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1651c479b22b2ad235019f746b3bba9b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机信息所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkijfuxmuussejtjgstkimrzilkcwetuundzehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1671602aca22de35c314041434b8b0fd\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿山机械建设项目组\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwliywqsturdssvv2tvfjiiuquiketuemuoqighf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16912d6d9adee5780a4281945cfb5022\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"仿真技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwmissgwvm5dghvkixyqtkisyrmkwvfiukiqsshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161688d3cc12661e3dc212c485f99e78\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwil2yygjubfrsllsrhtvuisrsuk2yvimmjhxyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161f8e8acc8e999bee166ee4164ac104\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiw0yhytu3fyhmm4zehvimwwhvkyrwutuirquhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"165616da6c24a3fdbf1ae1847d481a35\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机海外发展部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwklmrwgtlzfsutjxigewiddhrmksxgumijdtvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"168a7b008c6778f6ddd3923406b90905\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机党委工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmtcxeqimjfwxlmfiwgvvitzsjkmqwemiizqvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"168a7b102830d4d7d0dbec64a3999d2d\",\n" +
//                "\t\t\t\t\t\"name\": \"矿机监察部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmtcxerijaytqvkfgxgivhehflkzdtzmmngsghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"162fae35203d5e14213415b46f6a5452\",\n" +
//                "\t\t\t\t\t\"name\": \"矿山公司党总支\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjwldhtkj2qtgkvyrusijaurvuk0wiwtkiuvshf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c2ee389b7f9808f48849623d\",\n" +
//                "\t\t\t\"name\": \"徐工基础\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjuoshhjmszexwmayqywkiyyumlmstghf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137fe368edd0e3b63f26d6b4ebcaeb48\",\n" +
//                "\t\t\t\t\t\"name\": \"基础公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwrhtwmv1ggqvjbewtwjcwgwuk5heftvjeuyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fe368eddaa21b3d6e3154a579914d\",\n" +
//                "\t\t\t\t\t\"name\": \"基础综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwrhtwmvpggdtjcretvljhtrkkzdvxmmmrughf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138998afa74761152f6de1c4614b5ca0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础组织人事处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmuzydwtqxuxliarvswllghrukqwruuklfdqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138998b21ada367ebedebd343fb98ab0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础商务处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmuzyejipdgdjloxhevvphegjkotiemmldeqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161f39c2b7ea8b68819db9c45da95b6d\",\n" +
//                "\t\t\t\t\t\"name\": \"基础党政工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiwetzfjugxhdmuywyyimlgezuk4vgdmknewghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13899891bdd5462d325a9334a208ec21\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础宣传处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmizyziudggvklssgtjkjdztjkrdsqmvjfsrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138998b4f1657ba88acfc6b42d0b4893\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmezyekwirwvluzdyytudifwukcsgqukiyzthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138998b79c0a432c24f376e4f729ede1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础后勤处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmm2zyelmvfqdkjcsfskwitxwvkzixsmvlghrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138998bda32c33bf5aecbac46d8a88ff\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础保卫处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmuzyevt2tsfjj1eivtvpfedukkwgytmoyiihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fe368f0c52a13ecc2e234eefa10b9\",\n" +
//                "\t\t\t\t\t\"name\": \"基础财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwsqfvjt2rthuukshsjk5hhitikqezhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fe368f2bc031d9982ba74a33b7225\",\n" +
//                "\t\t\t\t\t\"name\": \"基础质量部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwwsefijkrgzmmosedlkrdttulissvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f3b98cbedca89854286af948\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础质管处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwstezmu5ehgutiyzykkisywtwizuyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f3be14bc59b5ab34a589a3f5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础检验处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwotehiklefvmuovdejkzdvymtktivhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fe368f4ab7ad67d384044df6824f0\",\n" +
//                "\t\t\t\t\t\"name\": \"基础技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmw4udeltrgwxvjayuqkkdgiwmjkuiqhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f4a582131fa8f3c47d18cc25\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"技术管理处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwcudvmjqrtrwtkyituksxgrmujfsvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f5ad3d7d677aa42452d8b695\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"工艺及标准化研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwovdgjv0xgwlldddujkevsgmuiwzvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15ca4ab46da334527ba19b8422bb380c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"工艺技改处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvutgudekllgdtjkqvsxuterzemkusseujmyqfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15165639c0b6b7d589943eb42238fcbe\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \" 电气控制研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvilyvwtmusqewulzgvymmeuthukasstmwpfehhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15165647373dad55494591245e0be1b7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"煤机研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvilyvwuljmxtgtvivvumkavzrjksvhquvkrexhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15165668c643373aaa9a2264de29266e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"非开挖研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvilqvwwmuywutjl4tddtmbdsslklghsmjmwwhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15165671bc2add95f4ab42449c4ad36a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"桩工研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvilivwxiuffsdvvuzviktbeuskkkzfutvmtwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1516567a27be06b9c7744fe4b3c89e28\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"新品研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvilivwxtjgxehil3ezfllmuuivkvetfmmjhsyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"151656825714f93d64016bf4b2084678\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"工法研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvilqvwyjkqxruwmctgwkierwewkbesqmkiwxyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"165a2046a5a401253a0d2084a45a32bc\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"液压传动研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwktqsqultsvduiiisvttibgsqmkzduvtjosefhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137fe368f5a6463800348cf4c04ba31a\",\n" +
//                "\t\t\t\t\t\"name\": \"基础营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwcvdwklqtyqijeuyfwkrfquutmtrdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f99b0a0972beaac458fbbab0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础备件部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwuzzeitaqzxjuphddukevyiuuldeqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"146b204bf61149c41a19b8a44bb99cc1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"再制造业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjapruluasquuwqwrrkmzfurtikzeytk4ueemmlffrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15ca5ff3c3124d6469818754e7d86af7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvut4viijuatrskviwuwmmiryxkkfhxgmlldixhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f79ee893143390e408bb53e7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础服务支持处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwmxzhvmqztrkjitzqvkuqyeukkthxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f896e63ee897dee4b17b97e8\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础服务人员\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwiyzwvlwthhmmoxghvkrerxumkxhyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f8917d952100ee441c08dcc6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础服务及培训管理处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwiyzrlvizvsiigqhhkkcrfqmvlffwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f8944bde9b0858049a784062\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础服务区长\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwayzukudghzuiayvyikczdxmkiqwshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1425563daa92ad8f7a7f5c4444bb0d5f\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础成品发运处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprujkqvwtvtjdzstv0yixtlfivfkkeuueuingvihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f5a024f07d6025b4817a5dc9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"市场策划部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwcvdqjkbiqxvlaqsvukyyrxtklgfzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f6ae2a83eb61ce9489babb8b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"钻机产品销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwwwdhjteythulorfhmkmyzetuneyehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f6aa147829676cb4bdf9506a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"矿机产品销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwowddikixysmlexwfuk5egimkmqwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f6ab2e48223b7d24ed9b083c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"海外市场及新品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwwwdejvquysjjfexgjkdhgzuimytfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f793ad55e07ce97427fa6ac7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"营销管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwixzttvuvvhillfhzlkmsxitlldfxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f79957b8a5487474b8d9fe46\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础驻外营销人员\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwyxzzklneydkkiyxulkneygmwjhuwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"138998bb67a71154a732f8e488483f86\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础应收账款及风控处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmezyeul0xdxii2vudljksiyvkqyyumjjiywhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161f3c3c238989275bd80db4d27a35f8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"大客户及新品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiwktftujqtyzmmasxvuveyqgukzgsxtjkviyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"150f93c00bda78f3500d52040e19f8ba\",\n" +
//                "\t\t\t\t\t\"name\": \"基础法务及资产安全部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprviweztfiipegdlmbitviibgvsikkqhrmwoyedhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"150f93df073da19c89716b644a6ab7a0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"应收账款管理及清欠处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprviweztgwi2xtgti0zfymlerwelkkudwtukxdqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"150f93f5cd368869e270fba4a2681a2e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"法务及信审处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprviw2ztikubgtwmmuwzhjloqietkrdswmindshhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"150f940247dc5e5983a8b2b4ebca552b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"审计处\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprviwazuqjk4xgfkvyvzyjtcyesuk5heftkmvsehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15514e8eb3af8e0be03446e4d408b336\",\n" +
//                "\t\t\t\t\t\"name\": \"基础信息化管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvkikuhyvuwtdimvwqehijiuuwvkbguqmuittwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1554dc85309d337e0c0c88f475f851bb\",\n" +
//                "\t\t\t\t\t\"name\": \"基础制造中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvkk1gfykj2qzgjjkxhquibfyywkuxvimkoreehf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1628a92728bd73ff8a7b2854658a22ea\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础制造支部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjmjdzslj4yeglj1iiytljesykkiwvytjoshdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f1c70e2984186e14e13a2317\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础采购物流部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwsrfxivqszykimywhikjhrttjitrxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f1ca03f36964b084311b02c4\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础采购处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwwrfdijjitwmlcueqmkatrruiksfuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f2b8070c131ef0b47cead2c0\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础物资处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwsseyil0qfrjidhiqukoxfhtvksfqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f2b80737c4491144bbcb9c66\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础安环督查室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwsseyiletxfkkazrrkkxeefumjfwwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13ff45f649aa9d42390e32246baa457f\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础再制造分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprtwweuvilkozddmviustmibhtsjkowedtkmvxihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f9997b0b38e7f384d7ab3e92\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础桩工分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwizzzlusqetmvcxitmkvgxdujjhzshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368f995a956b21c0044853a345e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础非开挖分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwyzzvtmuvwejibfqqkkyyvttjmuvhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368fa81ba3c24f0faa439fb27f9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础煤机分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwrdyrutctfskwoqidtketziujkxizhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137fe368fa8bdc9164f0e3644ef96a51\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础零部件分厂\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwvdyevuazrwkwcqhtlkouhimljdvrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1554dce88eae012a420370d4ce99e303\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"基础工程部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvkkhgfhmmxhdhiicsdujiatxqvk1fhzmvitqthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"137fe368f1cebaf49a47b6c410eabfd7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础生产处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwbhtwmwwrfhutjiuztkkxewukmrqhtuligxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1628a3b4614b41dc176d34f40649f6ef\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"基础设备能源处\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjmfdtekluruekilgfrllbgtuwkiqwumwowhihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"制造支部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprpf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"138998bfcfc984938365a844a9a8f496\",\n" +
//                "\t\t\t\t\t\"name\": \"基础工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmuzyewudifzmkiztyjlcvdykkfdzdmwiuzwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15d5841b3e5d40d53dead834f6aad869\",\n" +
//                "\t\t\t\t\t\"name\": \"基础纪委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvkqyurujfhvgkirgvtvvldgyjkniwdtviywzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"138998c289843f8820ec248432b9b1f1\",\n" +
//                "\t\t\t\t\t\"name\": \"基础团委\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmezyfjmizyujwqyysivbfsumkmtsemukrirhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"148cedf987b9c4f33cc4e8e41b5b8d40\",\n" +
//                "\t\t\t\"name\": \"徐工传动\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumuphgimmkxezukzittuukuhyvkcrevumjguqhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"148cee470a1bb98638305044bd584ac2\",\n" +
//                "\t\t\t\t\t\"name\": \"传动公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumulhhulivdreumqywtmjaqvqkkdegvmkldfshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"148ceec65d1155c6145b8ce4753842a2\",\n" +
//                "\t\t\t\t\t\"name\": \"传动党政工作部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumuxhhflkzgrrkkrfwrkkneyfvkaxvtmkksdshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"148ceed4c9d09fd46cc95d64b8a86800\",\n" +
//                "\t\t\t\t\t\"name\": \"传动质量保证部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumuxhhgkukzgqmwzguwuuezvglkfeydmliyqqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"148ceef66c3a992e4fb13ac49daacdf8\",\n" +
//                "\t\t\t\t\t\"name\": \"传动技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumuhhhill3ftdmmcshuwumrtduk4zgdtulgiyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c08433ff36f23a5e9cb9f47bf95af8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"传动产品研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuiiyutjwbitwwj0tdvvmdfezwk4xeimkldiyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c084a50f825d8b6a759104233b9b8a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"传动工艺技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtuimyudkijiyskv0yewtlavzrikqsttumneydhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"148cef3487f1e890f96fe4d442eab304\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"传动技术管理部 \",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumudhitkmkxirvmmzqimldihuvkmushtuitquhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"148ceedc13d94f5c5ee6ec04dfb8fa88\",\n" +
//                "\t\t\t\t\t\"name\": \"传动资产财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumu5hhguictgzkw0vfvvvgwhfikhgiemwjdyyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"148ceee25325590130965f3470c90397\",\n" +
//                "\t\t\t\t\t\"name\": \"传动生产制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprumuxhhhjkytsvkmqqrtimmwvijkmxqfmiitzxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15ea277f3d27b0e80dc0faa433eaf84b\",\n" +
//                "\t\t\t\t\t\"name\": \"传动供方管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvvtqsxxwjbgsxuirhyqvuoqidtkmtthtwmyuehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"168e465be0c0cecba321d444488b1b0b\",\n" +
//                "\t\t\t\t\t\"name\": \"传动销售管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmvquwvuv0qfquvpfedjjcrgukkquyyuineqehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13c084b5163dd1a09250f3e4e3598354\",\n" +
//                "\t\t\t\t\t\"name\": \"传动机加工分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtui2yuekiuwtgvirdqzjkkqitvkjhtvmmitvuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13c084b73ec1251d63a5f2a4234ac9d1\",\n" +
//                "\t\t\t\t\t\"name\": \"传动装配分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtui2yueljthfrjk0rgwjtkvistkystutukzgrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a5eb1eb958e3e9409aa30427f922a6\",\n" +
//                "\t\t\t\t\t\"name\": \"临时\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtklhervuyzvyvjrhzuimdddtikmsximjksdwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16415ac9a9aefb7badfa3e14821b6ae6\",\n" +
//                "\t\t\t\t\t\"name\": \"测试\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwki4vdfmtgzdhwugxedvwndthikaysrulldhwhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3cabb9376e7678304153ae376\",\n" +
//                "\t\t\t\"name\": \"徐工铁装\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju5deemjmxwhllaxytikyrvttvitxwhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"137f38484f06e0598fcbafe48d1b0f95\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumkjiqwviqvzywupedivkcygruijizvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137f38486573820313c37f045babb288\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumlavxtmjyqtrjuetxiikgveduuisyyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13d100f4b2d0fec3fc514ca4450ba2ae\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装技术中心领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtvieqqikussgqwv3ftiukmruftkquvqutosdhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f38486a50754d95345c6424bba57a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装技术管理办公室\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumlzdvqlk0ugzkjeuvflkusueutmvxdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3848696f4b47b5015554893ab99c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装铁路施工技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumlezwikumuxekiirvvkkiyzttumzzfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3848696c0f68212456e45fc8673c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装隧道及地下空间技术研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumlezwfiwiwysijiuvwvkgvifmlmxtfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137f3848667a08658a8f2d64a13995bf\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装营销中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumlewxdimiwvytmfisglkzdrtmmoveihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15bed0fe7f93d1dcf1115b0484daf874\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuv3gqivlriztvi5gfiiierveikmyugtwiyxuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15bed15574d850a5efa870a40f48ed67\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装服务备件部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvzgrvklkugykivdvhwtiyxqtksqiumvjgwxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167074d5d52c4d6858dba40438197fd3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装再制造部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlimxugkvevsfkvawyvmvdeduikytyrmlligthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1681c0572e881f007b102a240feb9179\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmijfqvljjhyyiwqqqxuieqsdjkwqihumirxzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1681c05d5c71966016d801541f4b35e0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"铁装大客户部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmirfqvvkjfxrmlawqrlviyqrkksriuujkvhqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137f38486769b972ff3a8ba4c6782a6c\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装资产财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyumlqxwzumuxsiwjndyetkbfwxmjndwfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"16203adc0081a628f60a17f4d18947d2\",\n" +
//                "\t\t\t\t\t\t\"name\": \"铁装财务与预算部领导\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjiotdguiiqyrtlesyilibdrxwkjgrymkkxgshf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137f3848686a99e60965b1246af884d2\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装装配分厂\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwatyuml2ywdmmjhwqmlcverjkgwdimmkugshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15bed1930e8f0423a4878464de5915e7\",\n" +
//                "\t\t\t\t\t\"name\": \"重庆隧道公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvjgrzjifhyiikestdkmaxyulk1ghvmikvhxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"15bed0fb324bdb5ca136055422884ec9\",\n" +
//                "\t\t\t\t\t\t\"name\": \" 工程管理部\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvvgqiujesuevu4vfdijiwqvkkassymklhfzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1467439c496f8b98cc910b04145816fe\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprulliutzukezwimu2zyfumerqeikqruvmiowihhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15bed133665d68cc3c73fd04da98e8ba\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装安全监察室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvjgrtjlewvglm1fftulgtigiktgdzmvoyedhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15bed154533376b6d2cbb784122bbfc0\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装技术质量部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvrgrvkkitttllvewgjudeexmkarssuulifqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15bed1584177d1e02a8846247efaf6f3\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装计划物流部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvbgrvmkqrxxvijhqstmayuwjkoxhitwkwithf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1665b644abda60cf706cf6e4b6b8f429\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装采购管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlkrewukthegdlidfixillfiwvkfewemwiuszhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1681bff6eb2ae44997fef4a47a58e6b3\",\n" +
//                "\t\t\t\t\t\"name\": \"铁装预算管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwmixeiilvnesdvkiuzzlwlhiutksxdvmvkwethf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3be05eb09b88df754f518f9f5\",\n" +
//                "\t\t\t\"name\": \"徐工供应&徐工智联\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlvpggfjujhqvvueqzemmlgixkkbivrmwkzivhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"15d5a4d43ce945214552f4945a18384f\",\n" +
//                "\t\t\t\t\t\"name\": \"公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvkvdugkjtfhzkkysrukkksiumksvdrmjmyuihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"166ced7ff281e860db36d8b42918ef00\",\n" +
//                "\t\t\t\t\t\"name\": \"战略规划部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwludhgxwwisyrvmuwqgujcwgyukqszrmvjiqqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15ca10cd5cf071fb17041ed404ea6415\",\n" +
//                "\t\t\t\t\t\"name\": \"经营管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuturqfvk1fiqlilierlieurhvkmquhtliurvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"137f34714f85553d5e9dfaa4d81ac81d\",\n" +
//                "\t\t\t\t\t\"name\": \"综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwituxikziyvkk0tgvvmpgidtkzgyrtumyrghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1647e2355bacca273ceddff44efa4c98\",\n" +
//                "\t\t\t\t\t\"name\": \"组织人事部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwklzhstkk5edfutysxtuvhggiwkouhitkjfzyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a6e2bc346998a3baeb5404f68a7484\",\n" +
//                "\t\t\t\t\t\"name\": \"信息化部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtl3hseujiuwzmm3dtetvbevuikziwytliuyuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"166ced8db4f637cb7b0cb4c405b8c3e0\",\n" +
//                "\t\t\t\t\t\"name\": \"安环设备办公室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwludhgyvu0uiwjldfexuilfeuukuqvemukthqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"166e8164f255cf51b1f6da24795b24d8\",\n" +
//                "\t\t\t\t\t\"name\": \"纪检监察室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvayrwkwisvvuwmvreiwgwgdjkaxzvujkugyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15d5d83c7c091cf82157c154f6db8bf6\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工供应\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvkzgytulzfqziuziysikkxfrkkfiwgumleiwhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f347150863bc3ce17ef44d08adcab\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxikiqywju3ftfvigxhikkjgqytvpfdehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3471537df829864770f48b993400\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应保税公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxiketxgwmaszylkaxxqwk0yezmjiuqqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3471518051e452ba8264229a1515\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应技术支持部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxikyryqkibhuvjubdyslkyssztiivrvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3471518333ab3ee699642f2a8fc3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应供应商发展部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxikyrytjj1detvvawzzlkksistmlifthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1403d08aca204bc898a63b1411cacc98\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应欧洲采购中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruijzgqytubdsqkurfyzmtmwteik2rrftujfzyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16402c5c3ecf4a8e08c33554f708aece\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应招标管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwki0sfvujxhfiktsyhqmuittvkkrixqmtphfhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f347151856a4c63c47d544a8a83da\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应起重机械采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxikqryvlt0ufwjumuxgkkkudytmotgdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3471527d9bb9dc718df464eb5da5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应铲运机械采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxikmsxgmu3ezgulerygwkuwuhuklgdvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c13a4acf08b875834200149bab2a32\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应道路机械采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtui0tdutubiqyumixvyjkisqqikgzedujjdtshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"137f3471527f941c8cf9d9d440a8e7b1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应施维英采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtlwytuxikmsximkkrfyuwczgzvkuuqdmvkxerhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c13a55f9d0ed8f619d28e4af4a8ed7\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应随车、环境采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtuiktdvkwkzgqvv0yiwimjgsyvkldiutmlhgxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"13c8568aa2757899708972c40b98369c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应挖掘机械采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprtumyvwyttisxvlmazzximizxsuksqezmjmwzfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"150a1e10810fea0790ec1264cd6a1ab0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应基础采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvitcrhrim2rqivtqqxzivbfrslk1fgwtildeqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15cca08fa987aa70ccfc0ed4c5686419\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应塔机采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvuurdqywtyzyxttmxqfuwffqhvkbfvwmliurzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15bed04b13407ba6eac90014ed7b42b5\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应消防车采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvrgquuiituqlu3dwhtuizqqikdhgxukksevhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1645983890c249de78143ae4cff8a4fa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应矿山采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwkkqzytmmsqfskmtghxmimutdvkxfiimtouidhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"167631d345069e6b26d466c434286291\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"供应筑路采购业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwllmtrgjkyvqwmvcweslviuwwukatusmliszrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15d5d83ff9143d1d3d5cf6d4d6199aca\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工智联\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvkbgytwwizrujvsrgtvkdfiwvkzgwrmmpdfdhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15a65914feed50918572558463584da1\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtlavzrkwphhgkiyzryklasvvmkawtvmklgdrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e820c658e9f0e14bb8de4cdfa21e0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联客服中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlviysqulmvyhmwcqhrkuneygvkpfgitjkrhqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"165a8268bca1c9d060f3ca541fc93d15\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联国际物流部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwktayswmu1fdrumbgqwiwotfdkk4rifmjjgrvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e82269e3b8b7ca2b07c74dd68efc9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联市场一部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvqysslmfhtemugxfdjumqxflktggwmvlifzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e822d5b5bf1f4b28ef6643949c4a4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联运输管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvqyssvkvevewifiuejmdhiwlkytzumukuduhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e82617d7b7845ccf655046879612e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联承运商管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvyyswilngxelmmuvfuwawvvikiwyxmlmrshhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e82666af9e070552606d421eb1490\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联生态业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvayswllldizviixqvkjawqwvkusrhuiiuzqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e826b034157ebcd9d4004e3391729\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联市场二部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvayswuiyturklxhefvmbguqikzhttmiixszhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e827094054e60ea6ab334dffbb88d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联零部件业务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvqysximquqvkvmwqhtlldetjkhgiiuumyyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"166e827d6f62a8d9c89bb0a4ed283efa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联生产物流中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvaysxvljiwstmvgzfmmleeqtkthgsmjphidhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"166e82bfadacfd5a07695f24f53bd673\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联生产物流中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwlvuysewthgdfwvkvdqllezvijkbivtuviwxthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a6591989ab3ea9edfbe1e435d84f25\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联集配中心\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtlivzrmm4zdejvfdzhvwlehrvketvgmkjisvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a84535c50114247381ea848bab1331\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联重型物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmyuvtkuivqrikisuxjmgrhdmkwyeduiittrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a8455a82b85cb746a1dfa49ce9d4c1\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联铲运物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmiuvvtm0seykurexultorgitkozfhmvkufrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a845a2a79a390b251eaf7477d8f3cf\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联道路物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmuuvdjt2xzdjm0qeskiphdilkexxgmwotfihf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a84554acc0b513986c488478385a1d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联挖机物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmquvvkttffqukartzmlbfuymkqxytmkndrghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a844c1d00fde665422f604324b8e00\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联汽车物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmmuufivuqqivvawwvkjcsiwikatsuumjhqqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a844e75cc3fca5aaa029a44c5b39ba\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联基础物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtm2uuhlktfftwu3dvdttiqsztksufvujozedhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a844f859a7ff046bfbb8a4f78acf8d\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联履带吊物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmuuuimkczdxwwaquwuwleeytkzixytuniyghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a844f0dbd1ffb8330083d41fe9f9ae\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联传动物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmeuuiivdegrwwjeytjiaqytvkorihmwozdhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a845b12b697a270298873491e82dba\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联筑路物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmmuveijzewzltqsxqjmiyyxjkezrhmjpgedhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a8450208953928c35d5a44464ba90e\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联施维英物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmauvqjiyyzvjm2syfjkfgvdkkquwuutmzqhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a8452ea4a6ab848c3580449a1b9217\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联液压件物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmyuvsvtkudwtuyyuyujavyqkkszdrumisrxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a8451fa6edac5900377e44d858da86\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联随车物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmquvrwt4whgtuqvzqijexxhkkbgyvmvjdywhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a8452773a3d5dddda21cd49789cac7\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联环境物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmyuvsllstdtvkxgggvtesrfvkyzxymuldfxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"15a845105caec81e7a09fd841e6977bc\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联塔机物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtmquvrikpfdhumkrhxtigzigmk0rhwmloxefhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"165854249f6817214c2cd484c82a7894\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联矿机物流部\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwkmqvuskmziwyilisruujdfgumkzfystliyzuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1670b0d9f55b6bbacf270eb41e88365d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"智联整机运输项目组\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlineqgmwevveluhedfwjexqhuksrhymjmwvghf@xcmg.com\",\n" +
//                "\t\t\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1670ce9b9fc61bd1e1da413498f895a6\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联（道路）整机运输项目组\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlitfhzumlifwiungrhivjdurjkuzyimmkvdwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1670cea38d919abded756544f74a5a35\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联（基础）整机运输项目组\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlipfhdjmzgzrmtxeghvlavwvkkzixutkjdtvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\t\t\"id\": \"1670cea72d77ccb37ba2b5741e19f2f9\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"name\": \"智联（汽车）整机运输项目组\",\n" +
//                "\t\t\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwlipfhdljzgxxuuretxutksevlkkrhrmwksizhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t\t\t]\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161eb27aa708ccf964fa0d04dd3a2fc4\",\n" +
//                "\t\t\t\t\t\"name\": \"公司工会\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwivzesxttyxqyuubizwkwfdqgiklggttjlifuhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"1477f8972baca9a0625e28041c48eb8e\",\n" +
//                "\t\t\t\"name\": \"徐工信息\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulljiyzlj5edftmrdqwjkbhsyiksrfumvneyhhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"14acc6bcf58daa9f05533c046a1aa0fb\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprutunfweuw2vygtt0ziqkkettfik0wdrttoqiehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1477f8c5eb252dc93ca9e39450d8f750\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司行政管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprull3iyfkvbesvjvzfztutkzhtmkevqgmwixvqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14ac39aeba2672ba30c7a7c453798ce8\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司营销公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprutumtzdvujdswljtedtiukxdxukivtxmmlfhyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"159af54768e31a57890ae1c40debfc52\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司营销公司 大客户部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvmtjivull0yhtitivxymildhrukgqghuwjfvshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15f771ea2198645df525abd449fa9cfb\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 营销公司徐州销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwlmxrhtjarzylkovgikjgvdevk2uzitmpfiehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1655c0c95a3663861c6099d4d54b1211\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司  营销公司销售管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkk3fqfmkrdtwljiywrulaqzzvkrgvuuiisrrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16680068149ab9c37e4826b43bfa35f3\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 苏州分公司\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlmqqqwmiuuzdumjftxvkayswuk4teitjkvithf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1655c0d58dd2fe83afb11cc4c7ab6ea8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 营销公司合肥销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkknfqgkmtggswveytdwumrrfukffxdullhdyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1655c0d85064b0e0f40e7c6496fbf943\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 营销公司宁波销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkkvfqgmkaqwuuifhqikifhxflkezwiuwizuthf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1477f8ce2677d705486d8584e4bb3534\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司系统实施部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprullniyfvjqwxxvlaqvumlbgyvmkvhueujivtuhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14e535236f653aab1974f724bb39d228\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 系统实施部ERP部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruvkitvsjlziwvjt1dermlcuixjkleetmvissyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1628a560859a36e861aecd945eabbf6a\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 系统实施部备件系统创新小组\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwjmbdvwimmvzdjlzhywitphfgmkgvhduuniwdhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"147ec300e72f72b4e9b90b14995a880f\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司车联网事业部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprulvrftqivmxsiljneuhmumzqeikizzvtmmyqihf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"158c930151ed9592871de3c4ab198df4\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司车联网事业部 硬件研发部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvmuyztqik4rhgmkyzsylilghtukldermmlgiuhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"158c931044db207c4466d3a4b109cf70\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司车联网事业部 服务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvmuaztrikgugejicxfuklkwgttkzerqmujixqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"158c9316e2084715eb733d443a4851b9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司车联网事业部 生产线\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvmuqztrlvqsqyklurvhulettgkkstdumkkrezhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"158ddd5976545fb86044f1047c7a9999\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司车联网事业部 产品部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvmv1ggvmliwvukwbeywikcuirik0xfxtmizzzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15b23b653b2044a242ad56e4be0b7891\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司车联网事业部 销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprvuj0tewkjbesqkkrdsujtjgvwvktehquliyzrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"168f004de64f81604a6b6bd459f9f0fb\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司车联网事业部 软件开发\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwmwqqquvvuwuimiiwqutlfewevkmvzimwoqiehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1477f8d1bc2c296f3b45af8465aaaf6c\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司软件研发部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprullniygiuvfsfjmcwitukgvdimk2wvdttniwfhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16402f949661d5b85a94e8440bf9318c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 工程机械共享租赁平台创新小组\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkissizkmqwwrvkzeyvtmcuhykk4qeimjmryfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"164ea78248e7976df0cfb5645448ecad\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司软件研发部-应届试用期虚拟部门\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwkvbdxyjk0yhxmlwwgiiudievlkqvuumvpfdghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1601f37b3b3da91eeecf97c442db6ca6\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司工业互联网事业部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwiiritxuj3etgtm4rhhvujizxukeusgullfdwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"16402f043136c53883cb82843138c7de\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司自动化技术事业部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkissiqkjyrtwukytyyjubeysmkqtrtmuoxghhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"14b398468f2ade821a9e8994e62b380c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司自动化技术事业部 两化融合部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqpruujazyulmvisdvvyysrtmjhyzmkrhwsujmyqfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1477f8d8326043895895be940968e056\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司自动化技术事业部 MES部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprullviygmjqswqkjqyzvmmovehmkqqzwmviqvwhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"165ac9df2d92d496479e7a942f48c5c8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司自动化技术事业部 智能控制研究所\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwktffzgwjbgzsvkyzwulmnhxdmkssiumukvfyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"169467609a77f9e5d77e8ae4c4eabf58\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司自动化技术事业部 先进技术部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwmkqwxwimrdxxwm3hvgllnhydvknfuhtujivyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16994a4cefbd565976fffeb432c93b72\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司自动化技术事业部 自动化部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwmm0uduuvpiegklavzxlwhiihuk2tsfmjjexshf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1477f8caae7dce69e1bda3346b199e03\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司财务管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprull3iyftt3hxguvmwzhiulgdtjk0wermmjhqthf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15ab5ced8e53679cae1d03a4854b0908\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司战略与技术管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtugvfhvmrhvtll4zfdvijgqttkayvuuiizqyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15635f08d1ab40a92bb20ad4d76ba82e\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司采购部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvljcviqmvgrdekibdzsuuesqdvkrgxwutmyshhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1618e07141b33086a1167c041569054f\",\n" +
//                "\t\t\t\t\t\"name\": \"徐工信息市场部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwimjhqxikkretji2ywdiiewxfikirvwmimvuihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1477f8d3ec5d10b0c481ea44a7085648\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司系统集成部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprull3iygjvnfvgiifeqfkmgrhdkkrdxqmkiwuyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161f4dd49b7ea0e52a1ac2343e98970e\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司轨道交通发展部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwiwwuggkmnexhtizhvstildfsjksthzmmmxqhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161d0f12c435f91dc4ef27e4139b4138\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司证券部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivsqirjuqutvwmwrgfkvjisxvkartzukirtyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"161d0f0e6cbd569abed2097491bbdf1f\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司人力资源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwivkqiqvlpfegklozdevvisqzlkezreuvnirihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"156afdf22e2aaa928866a084f128e08a\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司南京分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvlthigijj3hsdttazsymlcwdqmkrirsmvmqydhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"156afe615a859cdeff476c34e03bb4c9\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 南京分公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvlt1ihwikzdyvmuhghiwkmxwfjkbhqtuukufzhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"15f77227954a6021bb70657406396c90\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司 南京分公司销售部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwlyxsslmevudliusreuliqwvlkiqwtmljfzqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"156afe192944e987156010646498d49d\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司南京分公司 运营中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvltlihrmjyzuuvmiyxrklaqrqlkawuzmvmuzghf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"156afe3b47aa404e476a572492592f5b\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司南京分公司 营销中心\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvltdihtukgxddkikuhullbdvxjkizsvmjnivehf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"156afe36cb55ed8e08ebf7a4855ac6f2\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司南京分公司 技术中心软件研发\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvlttihtlujevvvvsyhqmvleixtkyyvvtukwishf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"159687e6cb94d7f85d16adb466f8ac7c\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"信息公司南京分公司 技术中心硬件研发\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvmluyxhlurezuvlriyvvigwdgukuwwimtnfxfhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1656f77f6e661840a3f41734305b6ae7\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司北京分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwklbixxwljhwwimmuqdjwiurxjkatqvulldhxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"1655c0eb1e33d41a69a63ea4163958f1\",\n" +
//                "\t\t\t\t\t\t\"name\": \"信息公司 北京销售部\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkkvfqhuibhttvk0rdwmtmwthtkyrwtmkkyirhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1656f784acc3be1e2a6fc044330bcb21\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司无锡分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwklrixykttfftuvkrhstldifqkkqttquujesrhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"15f77208547611c4f2a301143f2903b3\",\n" +
//                "\t\t\t\t\t\t\"name\": \"信息公司 无锡销售部\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwlqxsqmkyuxwiivfuijtitqrikktismiktethf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"166800714dc99ae80a9fb4e46fe8ed65\",\n" +
//                "\t\t\t\t\t\"name\": \"信息公司佛山分公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwlmiqqxik1gfzmtzhyqtmlieuvkwwihmvjgwvhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"1655c0d10f0fb538c9adc9149c5861a1\",\n" +
//                "\t\t\t\t\t\t\"name\": \"信息公司 佛山销售部\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkknfqgiiviqiuk2tyfmtlgfzikczfvmlkrdrhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c7c1b892d81c5c54036a5db8\",\n" +
//                "\t\t\t\"name\": \"徐工投资\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjucxfrumuzsgminfvfkkyqtwtklgeyhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"1389f00d1d949fd91d554f1497086966\",\n" +
//                "\t\t\t\t\t\"name\": \"投资一部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmriqqvijgzumwrgzrvkmvuiikazxqmlizwwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"141593e2e460b53d5a9a9a9470cb4618\",\n" +
//                "\t\t\t\t\t\"name\": \"投资二部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruikuzthjvquwquk0tgvtmndzdmkexqfukiwryhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1389f017b6d6ad4ae73347e4c2f98209\",\n" +
//                "\t\t\t\t\t\"name\": \"投资风控部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmjiqrlukwgwtv4udhljituxvknfsimmisqzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1389f01f4195f48ab57ec644b4d9fe41\",\n" +
//                "\t\t\t\t\t\"name\": \"投资财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmmbiqrwkarzvwk4ydekldhfwkkneugmwjhurhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"141593fc77ad79a5aaef4df41eea673a\",\n" +
//                "\t\t\t\t\t\"name\": \"投资综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruik2ztiul4xdglm3dvdtvfiugwkorhhtlmxtdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"146aca77d7f64e0729d19d54ac3999c5\",\n" +
//                "\t\t\t\t\t\"name\": \"投资研究部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprultlfdxlvsxiwkviqxsmvmrzgkk1dftmmkzfvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"147f65851214d2a5938bd1d48ce83a2d\",\n" +
//                "\t\t\t\t\t\"name\": \"投资交易室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprulwywvykiasruvjjdvzjmdegrvkwyfhmjndsghf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3cab59a6751f1d344581aa3bb\",\n" +
//                "\t\t\t\"name\": \"徐州工润实业\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfju1devmtiwxviwcrgtkkyvyrttoteehf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"15a20cbab88860a66e5222247619575a\",\n" +
//                "\t\t\t\t\t\"name\": \"工润公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtjoqfetuayyylizdwwvkasssjkyxwrmkmxvdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a20cd6cf7a2cea8412748468aa97d3\",\n" +
//                "\t\t\t\t\t\"name\": \"工润公司管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtjwqfgluvixdjuthdykiasxumk2wydtmkxgthf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"15a359c44debc5e457783414b51bde95\",\n" +
//                "\t\t\t\t\t\t\"name\": \"住房管理中心\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjevzfkk5gheukzhuvlliytuikbevruvjhzvhf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a35340a91493451b2c88549699589a\",\n" +
//                "\t\t\t\t\t\"name\": \"工润公司财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjqvtuityzrumjauvrujjfyykkyzwzmkmyzdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a3539674e86e55cbec79a43629743d\",\n" +
//                "\t\t\t\t\t\"name\": \"工润公司工程部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjqvtzllsuhylvuvvfuvjfxztkytwsmlmutghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a353a26800949fa5d85d8475d82f4c\",\n" +
//                "\t\t\t\t\t\"name\": \"工润公司成本部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprvtjevtdjliyqqmkozidkveyvgmkexvgmjniufhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c1e7c4d7f389a864daba9962\",\n" +
//                "\t\t\t\"name\": \"工润建筑科技\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjukrhxukngxijmczdylk5gdetmizwshf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"15a689b684cadd96202e48a4ec8881fe\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtleyzelmgufdvvazwsijjhuytkdhfymmorihhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a687272d930d43220f61e45198aabd\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技综合部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtliyxsljbgztivautsjijiwrvkqvrzmtpdeghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"165c2ba03f3a77daf8b05c842b982e9a\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwkuwsedij3itdllhgdimueqvfmkcsezmjnhzdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a68743a630cab2297ea924c7a94aa9\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技采购部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtlyyxujtywtqutzessmldhdzjknfxdmklddzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15a689c10a613f08ac7d86347efb836d\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技生产部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvtlmyzfiijdwrjw2qyduljgywjkgxhiummtwghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15dace798c0eb743188b2a741e4aec9e\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技市场部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvvtlfhxmmvfqhulautrmmnesdlk0rhutvnfzhhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1614b11791e4e9f5e88dea8418dace2c\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技技术部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwikzerrlm0rhuvmfivhmmhghdmk2rygtunhsfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"164d024cedde8ac1a9f9599437fab34a\",\n" +
//                "\t\t\t\t\t\"name\": \"工润建筑科技模具部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkvyqsuuvxgghmtnfrdmwizvzmkmtxitumtudhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1609655fad0fb97c92ee33d4ec1bd547\",\n" +
//                "\t\t\t\t\t\"name\": \"力山建设\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwimqwvvwtvgqiumsxfzjvbhttvkdhfruvivuxhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"160965944d991b0d0ae87c643fb90fa0\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"力山建设公司领导\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwimawvzkkjgzziu0qgqtveyxflkotiemilidqhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"16097730111fb026e17432140d38f1c8\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"力山建设管理部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwimqxxtiierriui2swhiliutsikcqgtmwkrfyhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1609771740f0a9a93320a51471992637\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"力山建设市场部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwimixxrlk0qiqtmjdztjjkqdvikixrzmjiwtxhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"1609772881bee3f34606b7b4bbd858fa\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"力山建设成本部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprwimaxxsmm4rehvjbitulicwexukxeegmkoyidhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t},\n" +
//                "\t\t\t\t\t\t{\n" +
//                "\t\t\t\t\t\t\t\"id\": \"161e5b68e712f57fc0e90ab464e9a88e\",\n" +
//                "\t\t\t\t\t\t\t\"name\": \"力山建设财务部\",\n" +
//                "\t\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwivsvewmvqxrswkwxifivezqduk2wuhmtmyyhhf@xcmg.com\"\n" +
//                "\t\t\t\t\t\t}\n" +
//                "\t\t\t\t\t]\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c8bef7342603304432c9e7ad\",\n" +
//                "\t\t\t\"name\": \"上海徐工项目组\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjuwyehwlatusliattqkk2tsfmvoxdghf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3cba7d8598acecf9423db62f3\",\n" +
//                "\t\t\t\"name\": \"徐工财务公司\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjudedxvmyvzytuphfimkestgulksithf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"13f7394536cc57ce9cf343440c6800d7\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlytzukj4wffkllfhzuwatutkkcqfwmikqgxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13f7394c3367b29d5c89ef94e1d90d7b\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlytzuujatwxujkzgvumozhimknhrgmingxehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13f7394ffe641fb7f7ed86949ee850e8\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司金融服务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlatzuwwjhwuiw3exilvjgywmkwzhhmkkqhyhf@xcmg.com\",\n" +
//                "\t\t\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\t\"id\": \"145ff35c7d3f8ad4be48db2481cb16cf\",\n" +
//                "\t\t\t\t\t\t\"name\": \"票据中心\",\n" +
//                "\t\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukwzitvulvgtimtnguevkgygejkuyrfuiowfihf@xcmg.com\"\n" +
//                "\t\t\t\t\t}]\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13f739560b996d08ee0b6bc49389cb29\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司风险管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlatzvlibezzlvmqyhvineweukyztymujeszhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13f73958641272e953cab634f42ae0f9\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司计划财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlatzvmliursljzhzvjuldewjkziustvkqizhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13f7395ae44e6b270026b3647178c491\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司审计稽核部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlytzvtveuuhluasxqijcwetlkqxrxmuiuzrhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"13f7395d951aa695de6afda4de7bc49c\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司结算服务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtwlqtzvvmmvrdtlmzvgvlpdigtktghxuumuzfhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1473dee68a1e995b774a38e4aa1baf39\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司产业链金融部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruljhghhlm3drhmmkvexlkjdtyvktddrutjitzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15ebbc10dac0f98c582ae6346959c751\",\n" +
//                "\t\t\t\t\t\"name\": \"财务公司国际金融部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprvvudefrivtdfqwmcyfvmjldhwjkywzvmuixvrhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"143805b449d80280c428ccb466f8cb0d\",\n" +
//                "\t\t\t\"name\": \"德国施维英\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprujmeqvekkczgyijeyqfkjgyffukuwwimuneqghf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"137eddc3c9bf4f105e2bfd54e28993d2\",\n" +
//                "\t\t\t\"name\": \"德国FT\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprtlv5ggfjugzeikwirqvvjpeigkkzhsymmktgshf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"138a22481439847c9b8b9104491b487b\",\n" +
//                "\t\t\t\"name\": \"巴西制造\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprtmtqssumiautzmkcxfzumbezrikauzrukmyxehf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"14c767f046dd37346c21e4d49e49e6b1\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulewxiik4wggjlituwujcrhuvk0zhumvkwerhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7683b4acb41a2b06931442a092985\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司行政办公室\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulawytukxdfekifdseilaztrkkksdqmjizyvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c768833d0e7a222f781d34d5ba7ceb\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司人力资源部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulywyyjj3gqhltqssswlmyrgjk3gvetlpfhehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c76a4e9cf22b207a9fd3b406f815e5\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司经营管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruul0wduvmdfisjuysqxtmdigtukuqwimikvhvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7687973510b6184ab5e04509b1d66\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司采购部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulywyxmlatvriuqwryktfevhikqvqzuijgwwhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7687e3217798dee77e914929a5ecd\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司制造部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulywyxvjysrxlm4yghvlkxhzikyzsztkphfghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7684bd86ff465421cc174ba788293\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulawyuuveywiwkqwvujilffrlkdedxmmiszthf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c76862f8991cfeada7bf941f5b43b4\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司信息所\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulawywjwyyzziuxihdvtoxeimkcrivukkteuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c76895b390ce3cbabb8a04fee8b1b9\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司技术中心\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruuliwyzkuytzquvotfetufeydikhihhmukrezhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7689d139f2623c6da3964279aba9b\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司工艺部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulqwyzvietzijlestflvbdtzlkisxztundzehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c768a5d01978278c0ae6b465b8504b\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司质量部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulmwydkviqrzlmisxyuiddhwukuwvemkmquehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7686c50cac0d1bb02f8f4dcd84b49\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司销售市场部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulywywukoqfduifgreuicsiywkhgfgmkjeuzhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c769a76acf621d0a02cda49db8413d\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司备件服务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulmwzdllhdfiljkrgqtiosfgtkgzgemkmrtghf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c7693fed1592cc5678bee4b13b5672\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司下料分厂（G20）\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulqwztwvjgrvmjtffvlloyehvkrertukiwxshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c76956efa528cceac67a844f28bf78\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司结构分厂（G30）\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulqwzvlvdidvjm5ffhtuewxdmkcuismujixyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c769773471f958f2c622748d3b125b\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司装配分厂（G40）\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulywzxljquxrwmuvyijuiwsslksygtuimsvehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c76980e8bfef9852ea57546b595db3\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司涂装分厂（G50）\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruulqwzyivoyeivwqzyvjvjdvxkk0wevmklgethf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14c76c2a331660665096f8848b3bae12\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司其它\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjypruul0wfstjatrwliqwwvimcwiymksyetutjhrshf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"14569399e590a5029507b904bd88a5f7\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西行政管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjipruklyztzmvyvzqtkiqszkicxeziktegymtkvixhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"145693aaa588b2faae4d8ad47b6a26b4\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprukl2ztdttavyyujpiddvkfgydvkkxewtjkweuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1673958d2553b4799ba23414133851bf\",\n" +
//                "\t\t\t\t\t\"name\": \"巴西公司国内支持部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwljazvyvjavvtukqxzzutistuikqrttmkoreihf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"15254110a2bea5e695f8d7f41e9802d2\",\n" +
//                "\t\t\t\"name\": \"美驰车桥\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvjkqurrit4sehtkjhwzkwcygxwkcrhzmiksgshf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"15fe19012a09acfbd36bcb04f6487d74\",\n" +
//                "\t\t\t\"name\": \"徐州泽汇人力资源有限公司\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvirzqijzdqztupiegjlhefeikriwumljgxuhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"15fe190b083abf626d08d2941e4a9e33\",\n" +
//                "\t\t\t\t\t\"name\": \"副总经理\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvarzquieytduwawswvikygsmk0rhutmjhtthf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe190f26336a8d8762396423ab41eb\",\n" +
//                "\t\t\t\t\t\"name\": \"市场开发部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvarzqwjqwttltkygyllastzlkestdukorhehf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe1912d2156ba9b9e52184ca890877\",\n" +
//                "\t\t\t\t\t\"name\": \"共享服务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvarzrjvasrvlu3dzemvavsrmklfdymiiyxxhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe191596f788cd4bf8e11437da9b8f\",\n" +
//                "\t\t\t\t\t\"name\": \"咨询培训部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvyrzrkmcwixmmdfguuwkyhrik2txgtmneyihf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe19195175dfc13e4894b49bf9fa29\",\n" +
//                "\t\t\t\t\t\"name\": \"猎聘部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvyrzrmkarxvvwjfrtvkayzuukozeimwjdszhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"15fe191f85c61354e3f43f24fa7b765d\",\n" +
//                "\t\t\t\t\t\"name\": \"综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvwvarzrwm0vfwijmvuhjweutijktidxulmwvghf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"1616398705745e231f40d764815b4dc6\",\n" +
//                "\t\t\t\"name\": \"徐工电商\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjiprwilitzyliyvxukvastrwkcqgxlkayrvuklgfwhf@xcmg.com\",\n" +
//                "\t\t\t\"ou\": [{\n" +
//                "\t\t\t\t\t\"id\": \"161745624264901f98591ca46e782eb0\",\n" +
//                "\t\t\t\t\t\"name\": \"电商公司领导\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwilauvwjkiswumisrizmkmzrftkcwhxmjlheqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"163cf0d772415b3b9da684b45dcb900a\",\n" +
//                "\t\t\t\t\t\"name\": \"综合管理部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwju3iqgllisurkustezvtawyuukwvgfummqqdhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"163cf0e68dcbad74b4053c1450a99268\",\n" +
//                "\t\t\t\t\t\"name\": \"战略科技部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjufiqhlmpgfetvexuekimvtfik2vqdmmiswyhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"163cf0f4599edf54af9de4f42d1a4db4\",\n" +
//                "\t\t\t\t\t\"name\": \"财务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjuviqikkezzhvwuvudwmdghuwkksgrtklgeuhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"163cf10277b23d7bd5af7894553b7745\",\n" +
//                "\t\t\t\t\t\"name\": \"数字创意部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjurirqjlkxesjv4xegktjixymkqvvtulixuvhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"163cf10c14bfe06365839fd4910a6b90\",\n" +
//                "\t\t\t\t\t\"name\": \"销售部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwjuzirquioueiviiwtwkmetzivkizrqtljezqhf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1617458fecb55016be4b84e4bac8c183\",\n" +
//                "\t\t\t\t\t\"name\": \"电商公司\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjyprwilquvywvlfevkimrwevkjeyuvkxedfmuirythf@xcmg.com\"\n" +
//                "\t\t\t\t},\n" +
//                "\t\t\t\t{\n" +
//                "\t\t\t\t\t\"id\": \"1648775a6104c6120cc1fce4f5badd5e\",\n" +
//                "\t\t\t\t\t\"name\": \"商务部\",\n" +
//                "\t\t\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjaprwkmixxvtlirquulyrsquuorifvknivetvngvhhf@xcmg.com\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t]\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"15b18eb4e4093bed6ecc7a04f95b9955\",\n" +
//                "\t\t\t\"name\": \"美驰车领导\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuiwyhekviuqzju1hgwvuffxdikrizvumizvvhf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"15ba45d6aaf7ec20bdab4c9498c87f58\",\n" +
//                "\t\t\t\"name\": \"测试\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvutuuvglt1dixvuusqevtneufmkuzyfmljivyhf@xcmg.com\"\n" +
//                "\t\t},\n" +
//                "\t\t{\n" +
//                "\t\t\t\"id\": \"15bec23c38529e119e577f2475eb9183\",\n" +
//                "\t\t\t\"name\": \"铁装营销中心\",\n" +
//                "\t\t\t\"email\": \"xcm--1rx0ijgxhgvlnfzgklwvhhmljhryklixuviidddukjqprvuvzfstujyyvsmvyrrzvkexxijkuxvhumirythf@xcmg.com\"\n" +
//                "\t\t}\n" +
//                "\t]\n" +
//                "}]";
//
//        List<EmailInfo> l= FastJsonUtil.parseList(emailsJson,EmailInfo.class);
//        process(l);
//    }
//
//    private static void process(List<EmailInfo> l) {
//        // 1.查询人员
//
//        // 2.查询组织
//
//        // 若组织有下层，process(子组织)
//
//    }
//}
