package com.lyy.note.study.io;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IoTest1 {

    /**
     * InputStream：字节输入流基类，抽象类是表示字节输入流的所有类的超类。
     *
     * FileInputStream：字节文件输入流，从文件系统中的某个文件中获得输入字节，用于读取诸如图像数据之类的原始字节流。
     *
     * 构造方法：
     *      通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的File对象file指定
     *     FileInputStream(File file)
     *     通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的路径name指定
     *     FileInputStream(String name)
     *
     *
     * @throws IOException
     */
    @Test
    public static void studyTest1() throws IOException {
        //构造方法1
        // 读取f盘下该文件D://study/io/test1.txt
        InputStream inputStream =new FileInputStream(new File("D://study/io/test1.txt"));
        int i = 0;
        //一次读取一个字节
        while ((i=inputStream.read()) != -1){
            System.out.print((char) i + "");
        }
        //关闭io流
        inputStream.close();

        System.out.println();
//        //构造方法2
//        InputStream inputStream1 = new FileInputStream("D://study/io/test1.txt");
//        int j =0;
//
//        while ((j = inputStream1.read()) != -1){
//            System.out.print((char)j+"");
//        }
//
//        //注： 一次读取一个字节数组，提高了操作效率,IO流使用完毕一定要关闭。
//        inputStream1.close();

    }

    /**
     *FileOutputStream：字节文件输出流是用于将数据写入到File，从程序中写入到其他位置。
     *
     *  构造方法：
     *     // 创建一个向指定File对象表示的文件中写入数据的文件输出流
     *     FileOutputStream(File file)
     *     // 创建一个向指定File对象表示的文件中写入数据的文件输出流
     *     FileOutputStream(File file, boolean append)
     *     // 创建一个向具有指定名称的文件中写入数据的输出文件流
     *     FileOutputStream(String name)
     *     // 创建一个向具有指定name的文件中写入数据的输出文件流
     *     FileOutputStream(String name, boolean append)
     */
    @Test
    public static void studyTest2() throws IOException {

        OutputStream outputStream = new FileOutputStream("D://study/io/test1.txt");
        //写入io流
        outputStream.write("sakura".getBytes());
        //关闭
        outputStream.close();

        //内容追加

        OutputStream outputStream1 = new FileOutputStream("D://study/io/test1.txt",true);
        //输入换行符
        outputStream1.write("\r\n".getBytes());
        //输入追加内容
        outputStream1.write("qwq".getBytes());
        //关闭io流
        outputStream1.close();
        //注；输出的目的地文件不存在，则会自动创建，不指定盘符的话，默认创建在项目目录下;输出换行符时一定要写\r\n不能只写\n,因为不同文本编辑器对换行符的识别存在差异性
    }


    /**
     * 字符转换流
     * 1）.InputStreamReader
     * InputStreamReader：字节流转字符流，它使用的字符集可以由名称指定或显式给定，否则将接受平台默认的字符集。
     * 2）
     * OutputStreamWriter：字节流转字符流。
     *  构造方法：
     *     // 创建使用默认字符编码的 OutputStreamWriter
     *     OutputStreamWriter(OutputStream out)
     *     // 创建使用给定字符集的 OutputStreamWriter
     *     OutputStreamWriter(OutputStream out, Charset cs)
     *     // 创建使用给定字符集编码器的 OutputStreamWriter
     *     OutputStreamWriter(OutputStream out, CharsetEncoder enc)
     *     // 创建使用指定字符集的 OutputStreamWriter
     *     OutputStreamWriter(OutputStream out, String charsetName)
     *  特有方法：
     *     //返回此流使用的字符编码的名称
     *     String getEncoding()
     * @throws IOException
     */
    @Test
    public static void studyTest3() throws IOException {

        OutputStream outputStream = new FileOutputStream("D://study/io/test1.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"utf-8");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.write("亚索");
        outputStreamWriter.close();

    }
    @Test
    public static void studyTest4() throws IOException {

        InputStream intputStream = new FileInputStream("D://study/io/test1.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(intputStream,"utf-8");

        int i = 0;

        while ((i = inputStreamReader.read() )!=-1){
            System.out.print((char) i+"");
        }
        inputStreamReader.close();

    }

    /**
     * 将list集合中的数据写入到txt中
     * @throws IOException
     */
    @Test
    public static void studyTest5() throws IOException {

        List<studentTest1> ss =new ArrayList();
        ss.add(new studentTest1("亚索",18,"三年一班"));
        ss.add(new studentTest1("盖伦",20,"三年二班"));
        ss.add(new studentTest1("皇子",21,"三年二班"));
        ss.add(new studentTest1("艾希",18,"三年一班"));

        File file = new File("D://study/io/test2.txt");
        if(file.exists()){
            file.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
        for (int i = 0; i <ss.size() ; i++) {
            outputStreamWriter.write("\r\n");
            outputStreamWriter.write(String.valueOf(ss.get(i).getName()));
            outputStreamWriter.write(String.valueOf(ss.get(i).getAge()));
            outputStreamWriter.write(String.valueOf(ss.get(i).getClassName()));
            System.out.println("写入第"+i+"个学生成功！");
        }

        outputStreamWriter.close();

    }
    /**
     * 将list集合中的数据写入到excel中
     * @throws IOException
     */
    @Test
    public static void studyTest6() throws IOException {
        List<studentTest1> ss =new ArrayList();
        ss.add(new studentTest1("亚索",18,"三年一班"));
        ss.add(new studentTest1("盖伦",20,"三年二班"));
        ss.add(new studentTest1("皇子",21,"三年二班"));
        ss.add(new studentTest1("艾希",18,"三年一班"));

        //创建xlsx excel文件
        try {
            //在内存中创建一个excel文件
            XSSFWorkbook workbook = new XSSFWorkbook();
            //创建工作簿
            XSSFSheet sheet = workbook.createSheet();
            //创建标题行
            XSSFRow titlerRow = sheet.createRow(0);
            titlerRow.createCell(0).setCellValue("姓名");
            titlerRow.createCell(1).setCellValue("年龄");
            titlerRow.createCell(2).setCellValue("班级");

            for (int i = 0; i <ss.size() ; i++) {
                //XSSFRow row2 = sheet.getRow(1);//获取第二行
                sheet.createRow(i + 1).createCell(0).setCellValue(ss.get(i).getName());
                System.out.println("第"+i+"个学生姓名："+ss.get(i).getName());
                sheet.getRow(i + 1).createCell(1).setCellValue(ss.get(i).getAge());
                System.out.print("，年龄："+ss.get(i).getAge());
                sheet.getRow(i + 1).createCell(2).setCellValue(ss.get(i).getClassName());
                System.out.print("，班级："+ss.get(i).getClassName());

                System.out.println("---------------");
            }
            //指定路径
            File file = new File("D://study/io/qwq.xlsx");
            if(file.exists()){
                file.mkdir();
            }
            FileOutputStream out = new FileOutputStream(file);
            //将此xlsx文件以流的形式写出
            workbook.write(out);
            //关闭流
            out.close();
            System.out.println("createWorkBook success");
        } catch (FileNotFoundException e) {
                 e.printStackTrace();
        } catch (IOException e) {
              e.printStackTrace();
        }
    }

    @Test
    public static void studyTest7() throws IOException {
        File tempFile;

            tempFile = File.createTempFile("12345678998763543",".xlsx");
            //logger.info("生成临时文件：{}，路径：{}",tempFile,tempFile.getPath());
            String parent = tempFile.getParent();

            File file=new File(parent+"\\ALGO_BIG_FILES\\"+"\\"+"12345678998763543"+"\\"+"aaa.txt");
            if(!file.exists()){
                file.mkdirs();
            }
        System.out.println("file"+file);

    }




    public static void main(String[] args) throws IOException {

        studyTest7();

//        studyTest2();
//        studyTest1();
//        System.out.println("---字符转换---");
//        studyTest3();
//        studyTest4();
//        System.out.println("---将list集合中的数据写入到txt中---");
//        studyTest5();
//        System.out.println("");
//        System.out.println("-------将list集合中的数据写入xlsx格式excel中-------");
//        studyTest6();
    }



}

class studentTest1{
    private String name;
    private Integer age;
    private String className;

    public studentTest1(String name, Integer age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "studentTest1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}