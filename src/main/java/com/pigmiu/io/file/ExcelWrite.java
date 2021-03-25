package com.pigmiu.io.file;

import de.siegmar.fastcsv.writer.CsvWriter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.http.util.ExceptionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author nuosong
 * @version : ExcelWrite.java, v 0.1 2020年10月15日 3:14 PM nuosong Exp $
 */

public class ExcelWrite {
    public void writeExcel(int index) {
        //开始写入excel,创建模型文件头
        String[] titleA = {"userId"};
        //创建Excel文件，B库CD表文件
        File fileA = new File("/Users/yli/Documents/loadData/userId1e.xls");
        /*if (fileA.exists()) {
            //如果文件存在就删除
            fileA.delete();
        }*/
        try {
            //fileA.createNewFile();
            //创建工作簿
            WritableWorkbook workbookA = Workbook.createWorkbook(fileA);
            //创建sheet
            WritableSheet sheetA = workbookA.createSheet("sheet1", 0);
            Label labelA = null;
            //设置列名
            /*for (int i = 0; i < titleA.length; i++) {
                labelA = new Label(i, 0, titleA[i]);
                sheetA.addCell(labelA);
            }*/
            //获取数据源
            //20880025010060G1
            for (int i = index * 10000; i < (index + 1) * 10000; i++) {
                String userId = "2088" + String.format("%012d", i);
                String testUserId = replaceStandardUidToTestUid(userId);
                labelA = new Label(index * 10000, i, testUserId);
                sheetA.addCell(labelA);
            }
            workbookA.write();//写入数据        
            workbookA.close();//关闭连接

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 将正式uid替换为压测uid
     * <p>将正式uid倒数第2位按照0->A,1->B..9->J的规则进行替换。如果不满足该规则,则抛出转换异常</p>
     * <pre>
     * eg: 2088302396964206 -> 20883023969642A6
     *     2088302396964216 -> 20883023969642B6
     * </pre>
     * @param uid 正式uid
     * @return 压测uid
     */
    public static String replaceStandardUidToTestUid(String uid) {
        StringBuilder sb = new StringBuilder(uid.length());
        int len = uid.length();
        for (int i = 0; i < len; i++) {
            char ch = uid.charAt(i);

            if (i == len - 2) {
                ch = (char) (ch - '0' + 'A');
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void writeCsv01(int index){
        CsvWriter csvWriter = new CsvWriter();
        String swipeRecordCsvPath="/Users/yli/Documents/loadData/";
        String fileName="userId1E.csv";
        String filePath = swipeRecordCsvPath +"/"+ fileName;
        Collection<String[]> data = new ArrayList<>();
        try {
            File dir = new File(swipeRecordCsvPath);
            if (!dir.exists()) {
                boolean res = dir.mkdirs();
            }
            //获取数据源
            //20880025010060G1
            for (int i = index * 10000; i < (index + 1) * 10000; i++) {
                String userId = "2088" + String.format("%012d", i);
                String testUserId = replaceStandardUidToTestUid(userId);
                data.add(new String[]{testUserId});
            }
            File file = new File(filePath);
            csvWriter.write(file, StandardCharsets.UTF_8, data);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void writeCsv02(int index)throws IOException {
        String swipeRecordCsvPath="/Users/yli/Documents/loadData";
        String fileName="userId1E.csv";
        String filePath = swipeRecordCsvPath +"/"+ fileName;
        File dir = new File(swipeRecordCsvPath);
        if (!dir.exists()) {
            boolean res = dir.mkdirs();
        }
        File file = new File(filePath);
        Writer writer= new OutputStreamWriter(Files.newOutputStream(file.toPath(), StandardOpenOption.APPEND, StandardOpenOption.APPEND), "UTF-8");
        Collection<String[]> data = new ArrayList<>();
        //获取数据源
        //20880025010060G1
        for (int i = index * 10000; i < (index + 1) * 10000; i++) {
            String userId = "2088" + String.format("%012d", i);
            String testUserId = replaceStandardUidToTestUid(userId);
            data.add(new String[]{testUserId});
        }
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(writer,data);
    }

}
