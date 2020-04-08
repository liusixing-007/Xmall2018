package com.maipu.xmall.admin;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.io.IOException;

@SpringBootTest
class XmallAdminWebApplicationTests {

    @Test
    void contextLoads() throws IOException, MyException {

        //配置dfs的全局链接地址
        String path = XmallAdminWebApplicationTests.class.getResource("/traker.conf").getPath();

        ClientGlobal.init(path);
        //新建一个tracker
        TrackerClient trackerClient = new TrackerClient();
        //新建一个实例
        TrackerServer connection = trackerClient.getConnection();

        //通过tracker获得一个storage的链接实例

        StorageClient storageClient = new StorageClient(connection,null);

        String[] jpgs = storageClient.upload_file("d:/baby.png", "png", null);

        String url="192.168.159.131:7777";
for (String jpg:jpgs){
    url+="/"+jpg;
    System.out.println(url);
}



    }



}
