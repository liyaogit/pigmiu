package com.io;

import com.pigmiu.dto.Dog;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * User: yli
 * Date: 2017/8/28
 * Time: 14:53
 */
public class IoTest {
    public static final String FILE_URL = "MyText.ser";
    @Test
    public void testObjectStream(){           //字节流测试
        try {
            Dog dog = new Dog();
            mmp(dog);
            FileOutputStream fs = new FileOutputStream(FILE_URL);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(new Dog("tom", 18));
            os.writeObject(new Dog("hedy", 10));
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fs = new FileInputStream(FILE_URL);
            ObjectInputStream os = new ObjectInputStream(fs);
            Dog dog1 = (Dog)os.readObject();
            Dog dog2 = (Dog)os.readObject();
            os.close();
            System.out.println(dog2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String mmp(Dog dog){
        dog.setAge(133);
        return "1";
    }

    @Test
    public void testObjectWriter(){
        try {
            FileWriter fw = new FileWriter(FILE_URL);       //字符流,写字符串
            fw.write("哈哈小不点,heiha");
            fw.close();

            FileReader fr = new FileReader(FILE_URL);
            int  character;
            while ((character = fr.read())!= -1){
                //打出每个字符编码
                System.out.println(character);
            }
            fr.close();

            //放入缓冲区,效率更高,相当于购物车
            BufferedReader br = new BufferedReader(new FileReader(FILE_URL));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFile(){
        //创建文件对象
        File file = new File("MyCode.txt");

        //创建目录
        File dir = new File("de");
        dir.mkdir();

        //目录下的内容
        System.out.println(dir.list().length);

        //绝对路径
        System.out.print(dir.getAbsolutePath());

        //删除目录
        boolean isDeleted = dir.delete();

        Assert.assertTrue(isDeleted);
    }
}
