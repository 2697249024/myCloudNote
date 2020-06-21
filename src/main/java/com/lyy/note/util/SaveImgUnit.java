package com.lyy.note.util;

import com.lyy.note.entity.pojo.FileImport;
import com.lyy.note.eumns.ValidAndStatusEumn;
import com.lyy.note.service.FileImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 **author:liuyueyang
 *上传图片工具类
 */
@Component
public class SaveImgUnit {

    private static final Logger log = LoggerFactory.getLogger(SaveImgUnit.class);
    //以base64编码格式上传，将照片转成字节流
    public static Map<String,String> getImg(String imageFile,String subdirectory){
        // 通过base64来转化图片
        String type = imageFile.substring(imageFile.indexOf("/")+1,imageFile.indexOf(";"));
        if (type.equals("png")){
            imageFile = imageFile.replaceAll("data:image/png;base64,", "");
        }
        if (type.equals("jpeg")){
            imageFile = imageFile.replaceAll("data:image/jpeg;base64,", "");
        }
        if (type.equals("jpg")){
            imageFile = imageFile.replaceAll("data:image/jpg;base64,", "");
        }
        if (type.equals("gif")){
        	imageFile = imageFile.replaceAll("data:image/gif;base64,", "");
        }
        if (type.equals("zip")){
        	imageFile = imageFile.replaceAll("data:image/zip;base64,", "");
        }
        //TODO 添加文件 并区分
        //xlsx  doc docx  txt  pdf
        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码
        byte[] imageByte = null;
        try {
            imageByte = decoder.decodeBuffer(imageFile);
            for (int i = 0; i < imageByte.length; ++i) {
                if (imageByte[i] < 0) {// 调整异常数据
                    imageByte[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        type = "." + type;
        return saveImg(imageByte,subdirectory,type);
    }

    //存储照片到服务器
    private static Map<String,String> saveImg(byte[] imageByte,String subdirectory,String type){
        // 生成文件名及文件类型
        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + type;

        Map<String,String> map = new HashMap<>();
        //获取跟目录---与jar包同级目录并生成文件路径
        String filename = GetServerRealPathUnit.getPath(subdirectory) + files;
        try {
            // 生成文件
            File imageFile = new File(filename);
            imageFile.createNewFile();
            if(!imageFile.exists()){
                imageFile.createNewFile();
            }
            OutputStream imageStream = new FileOutputStream(imageFile);
            imageStream.write(imageByte);
            imageStream.flush();
            imageStream.close();
            map.put("res","success");
            map.put("url",files);
            return map;
        } catch (Exception e) {
            log.error("saveImg error",e.getMessage());
            map.put("res","error");
            return map;
        }
    }

    //以MultipartFile方式上传到服务器
    public static Map<String,String> saveMultFile(MultipartFile file,String subdirectory){
        //上传文件路径
        String path = GetServerRealPathUnit.getPath(subdirectory);
        //重新修改文件名防止重名
        String filename = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + file.getOriginalFilename();
        File filepath = new File(path, filename);
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        Map<String ,String> map = new HashMap<>();
        File file1 = new File(path + File.separator + filename);
        try {
            file.transferTo(file1);
            map.put("res","success");
            map.put("newName",filename);
         	//将原文件名放入集合中
            map.put("oldName", file.getOriginalFilename());
            //真实路径
            map.put("realPath", path);
            //访问路径
            map.put("path", File.separator+subdirectory+ File.separator+filename);
            log.info("realPath真实路径：{}",path);
            log.info("path访问路径：：{}",File.separator+subdirectory+ File.separator+filename);
            log.info("oldName原名：{}",file.getOriginalFilename());
            log.info("newName新名字：{}",filename);
            //System.out.println("realPath真实路径："+path);
            //System.out.println("path访问路径："+ File.separator+subdirectory+ File.separator+filename);
            //System.out.println("oldName原名："+file.getOriginalFilename());
            //System.out.println("newName新名字："+filename);
            return map;
        } catch (IOException e) {
            log.error("saveMultFile error",e.getMessage());
            map.put("res","error");
            //e.printStackTrace();
            return map;
        }
    }

   
}


