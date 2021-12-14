package com.itnxd.gulimall.product;

import com.itnxd.gulimall.product.entity.BrandEntity;
import com.itnxd.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        this.brandService.save(brandEntity);
    }

//    @Autowired
//    private OSSClient ossClient;
//
//    @Test
//    void testUpload() throws FileNotFoundException {
//
//        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("C:\\Users\\15890\\Desktop\\临时文本\\images\\favicon.ico");
//        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
//        ossClient.putObject("gulimall-nxd", "test2.ico", inputStream);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//        System.out.println("上传成功");
//    }

}
