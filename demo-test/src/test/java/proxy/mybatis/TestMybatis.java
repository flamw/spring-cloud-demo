//package proxy.mybatis;
//
//import cn.com.xbed.dao.mapper.AccountBillMapper;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * @Date 2020/1/6 10:21
// * @Created by huangfl
// */
//public class TestMybatis {
//
//    public void testMybatis() throws IOException {
//        String resource = "mybatis/conf/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //从 XML 中构建 SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //获取session
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//            //获取Mapper
//            AccountBillMapper mapper = session.getMapper(AccountBillMapper.class);
//        } finally {
//            session.close();
//        }
//    }
//}
