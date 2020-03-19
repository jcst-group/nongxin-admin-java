package com.nongxin.terminal.util;

import com.nongxin.terminal.dao.system.ConstantStorageMapper;
import com.nongxin.terminal.entity.system.ConstantStorage;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import com.nongxin.terminal.vo.FileInfoVo;
import com.nongxin.terminal.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;

@Component
public class ImgUpload {

    //private static final Logger LOGGER = LoggerFactory.getLogger(ImgUpload.class);

    @Value("${fileSize.img}")
    private Integer imgSize;
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ConstantStorageMapper constantStorageMapper;

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImgUpload(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public Result<FileInfoVo> listSample(MultipartFile file) {
        Result<FileInfoVo> result = new Result<>();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf(".")+1);

        if (file.isEmpty()) {
            result.error500("文件不能为空");
            result.setMessage("文件不能为空");
            return result;
        }
        if(file.getSize()>imgSize*1024*1024){
            result.error500("文件大小不能大于"+imgSize+"M");
            result.setMessage("文件大小不能大于"+imgSize+"M");
            return result;
        }

        try {

            boolean isImage = ImageCheckUtil.checkFile(suffixName);
            if(!isImage){
                result.error500("文件不为图片，无法上传");
                result.setMessage("文件不为图片，无法上传");
                return result;
            }

            File upload = getUploadFile();
            if(!upload.exists()){
                //upload.mkdir(); 创建单层文件夹static，报错
                upload.mkdirs();
            }
            String showName =fileName;
            fileName = fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()+"."+suffixName;
            String savePath = upload.getPath()+File.separator+fileName;
            File saveFile = new File(savePath);
            FileCopyUtils.copy(file.getBytes(), saveFile);
            //返回文件名，用户预览时可用
            FileInfoVo fileInfoVo = new FileInfoVo();
            fileInfoVo.setFileName(showName);
            fileInfoVo.setPath(fileName);
            result.setResult(fileInfoVo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result.error500("上传文件路径错误");
            result.setMessage("上传文件路径错误");
            return result;
        }catch (IOException e) {
            e.printStackTrace();
            result.error500("上传出错");
            result.setMessage("上传出错");
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    public Result<FileInfoVo> uploadPic(MultipartFile file) {
        Result<FileInfoVo> result = new Result<>();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf(".")+1);

        if (file.isEmpty()) {
            result.error500("文件不能为空");
            result.setMessage("文件不能为空");
            return result;
        }
        if(file.getSize()>imgSize*1024*1024){
            result.error500("文件大小不能大于"+imgSize+"M");
            result.setMessage("文件大小不能大于"+imgSize+"M");
            return result;
        }

        try {

            boolean isImage = ImageCheckUtil.checkFile(suffixName);
            if(!isImage){
                result.error500("文件不为图片，无法上传");
                result.setMessage("文件不为图片，无法上传");
                return result;
            }

            File upload = getUploadFile();
            if(!upload.exists()){
                //upload.mkdir(); 创建单层文件夹static，报错
                upload.mkdirs();
            }
            String showName =fileName;
            fileName = fileName.substring(0,fileName.lastIndexOf("."))+System.currentTimeMillis()+"."+suffixName;
            String savePath = upload.getPath()+File.separator+fileName;
            File saveFile = new File(savePath);
            FileCopyUtils.copy(file.getBytes(), saveFile);
            //返回文件名，用户预览时可用
            ConstantStorage constantStorage = constantStorageMapper.selectByType(ConstantTypeEnum.IMG_ADDRESS);
            FileInfoVo fileInfoVo = new FileInfoVo();
            fileInfoVo.setFileName(showName);
            fileInfoVo.setPath(constantStorage.getConstant()+"/images/uplaod/"+fileName.substring(0,fileName.lastIndexOf("."))+"."+suffixName);
            result.setResult(fileInfoVo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result.error500("上传文件路径错误");
            result.setMessage("上传文件路径错误");
            return result;
        }catch (IOException e) {
            e.printStackTrace();
            result.error500("上传出错");
            result.setMessage("上传出错");
            return result;
        }
        result.setSuccess(true);
        return result;
    }


    /**
     * 查看图片地址
     * @return
     */
    public String getPath(String fileName){
        try {
            return getUploadPath()+ fileName;
        } catch (Exception e) {
            return null;
        }
    }

    private File getUploadFile() throws IOException{

        //如果上传目录为/static/images/upload/,则可以如下获取
        File upload=new File(getUploadPath());
        return upload;
    }

    private String getUploadPath() throws IOException{
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()){
            path=new File("");
        }
        String upLoadPath = path.getAbsolutePath()+File.separator+"static/images/uplaod/";
        return upLoadPath;
    }

}
