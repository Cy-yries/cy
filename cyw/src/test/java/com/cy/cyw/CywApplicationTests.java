package com.cy.cyw;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class CywApplicationTests {

    private final RestTemplate restTemplate;

    @Test
    void contextLoads() {
        try {
            String url="http://1301915397.vod2.myqcloud.com/e5ac1d89vodcq1301915397/5d8a59c35285890808489882396/5z5yXOFxtaMA.jpg";
             Resource forObject = restTemplate.getForObject(url ,Resource.class);
            InputStream inputStream = forObject.getInputStream();
            System.out.println(inputStream);
            int index;
            byte[] bytes = new byte[1024];
            FileOutputStream downloadFile = new FileOutputStream(new File("C:\\Users\\28587\\Desktop\\test\\test1.jpg"));
            while ((index = inputStream.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            inputStream.close();
            downloadFile.close();
            System.out.println("downloadFile = " + downloadFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
