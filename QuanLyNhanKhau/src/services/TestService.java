package services;

import Bean.TestBean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TestService {
    public List<TestBean> getListTestBeans() {
        List<TestBean> list = new ArrayList<>();

        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM test JOIN ";
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
