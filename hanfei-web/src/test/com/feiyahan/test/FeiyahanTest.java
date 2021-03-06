package com.feiyahan.test;

import com.alibaba.fastjson.JSONObject;
import com.feiyahan.hanfei.pojo.Person;
import com.feiyahan.hanfei.pojo.Users;
import com.feiyahan.hanfei.service.IDbService;
import com.feiyahan.hanfei.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hanfei7 on 2016/8/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class FeiyahanTest {
    private static final Logger logger= LoggerFactory.getLogger(FeiyahanTest.class);


    @Autowired
    private IndexService indexService;


    @Qualifier("IDbServiceImpl")
    @Autowired
    private IDbService iDbService;

    @Autowired(required = false)
    private SqlSessionTemplate sessionTemplate;

    @Test
    public void printProperties(){
        indexService.printProperties();
    }

    /*@Test
    public void testAkkaService(){
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new akkaClient(i, "host"+i));
            thread.start();	//同时启动5个客户端请求Master
        }
    }

    class akkaClient implements Runnable{
        int num;
        String host;

        public akkaClient(int num,String host) {
            this.num=num;
            this.host=host;
        }

        @Override
        public void run() {
            System.out.println("service "+num +" start");
            String result = akkaService.service2Akka(num, host);
            System.out.println("service "+num +" "+result);
        }
    }
*/
    @Test
    public void testMongo(){
        System.out.println();
        iDbService.insert(new Person("joy",20));
        iDbService.findAll();
    }

    @Test
    public void testUsersDao(){
        Users users=new Users();
        users.setUsername("hf");
        users.setLoginPass("123456");
        users.setUserStatus(0);
        users.setEmail("hf2@feiyahan.com");
        users.setPhone("18888888888");
    }

    @Test
    public void insertLike(){
        Object btmxg_like = sessionTemplate.selectOne("btmxg_like");
        System.out.println(JSONObject.toJSONString(btmxg_like));
    }
}
