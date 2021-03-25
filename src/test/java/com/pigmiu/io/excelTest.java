package com.pigmiu.io;

import com.pigmiu.io.file.ExcelWrite;
import org.junit.Test;

import java.io.IOException;

/**
 * @author nuosong
 * @version : excelTest.java, v 0.1 2020年10月15日 3:11 PM nuosong Exp $
 */

public class excelTest {
    @Test
    public void testObjectWriter(){
        ExcelWrite excelWrite = new ExcelWrite();
        for (int i = 0; i < 100; i ++){
            excelWrite.writeExcel(i);
        }
    }

    @Test
    public void testObjectWriterInit(){
        ExcelWrite.writeCsv01(0);
    }

    @Test
    public void testObjectWriterInit1(){
        try {
            for (int i = 7000; i<10000; i ++){
                ExcelWrite.writeCsv02(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
