package com.eurotech.tests.tag_20;
import com.eurotech.utility.ExcelUtil;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public class _1_DemoExcelUtil {
    @Test
    public void readExcelFile() {
        String path ="src/test/resources/DevEx.xlsx";
        ExcelUtil testData = new ExcelUtil(path,"Test Data");

        System.out.println("testData.getCellData(6,2) = " + testData.getCellData(6, 2)); // SDET
        System.out.println("testData.getCellData(1,2) = " + testData.getCellData(1, 2)); // Teacher

        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames()); // baslik isimleri

        System.out.println("testData.rowCount() = " + testData.rowCount()); // 9 -  kac satir oldugu

        System.out.println("testData.columnCount() = " + testData.columnCount()); //5 - kac sütun oldugu

        List<Map<String, String>> dataList = testData.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }
        System.out.println("dataList.get(0) = " + dataList.get(0));
        //{Company=EuroTech, Username=eurotech@gmail.com, Title=Teacher, Password=Test12345!, Name=Teacher}

        System.out.println("dataList.get(4).get(\"Company\") = " + dataList.get(4).get("Company")); // ZK Gmbh
        System.out.println("dataList.get(5).get(\"Name\") = " + dataList.get(5).get("Name")); // batch16

        String[][] dataArray = testData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray)); // baslikla birlikte tum bilgiler

        String[][] dataArrayWithoutFirstRow = testData.getDataArrayWithoutFirstRow(); // baslik olmadan(ilk satirsiz) tüm bilgiler
        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));

    }
}
