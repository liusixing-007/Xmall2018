package upload;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @title:
 * @description:
 * @author: Asing
 * @date: 2020-04-07 14:55:28
 */
public class UploadUtils {
    public static String uploadfiles(MultipartFile multipartFile) {
        //配置dfs的全局链接地址
        String path = UploadUtils.class.getResource("/traker.conf").getPath();
        try {
            ClientGlobal.init(path);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //新建一个tracker
        TrackerClient trackerClient = new TrackerClient();
        //新建一个实例
        TrackerServer connection = null;
        try {
            connection = trackerClient.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //通过tracker获得一个storage的链接实例

        StorageClient storageClient = new StorageClient(connection, null);

        String[] jpgs;

        String url = "192.168.159.131:7777";


        try {
            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String substring = originalFilename.substring(i + 1);

            jpgs = storageClient.upload_file(bytes, substring, null);
            for (
                    String jpg : jpgs) {
                url += "/" + jpg;
                System.out.println(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

}






