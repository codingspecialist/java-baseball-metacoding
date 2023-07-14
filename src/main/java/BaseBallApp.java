import db.DBConnection;
import db.DBInit;
import model.stadium.Stadium;
import model.stadium.StadiumDao;

import java.sql.Connection;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        // 1. TearDown
        DBInit.teardown();

        // 2. DAO 연결 실행
        Connection connection = DBConnection.getInstance();
        StadiumDao stadiumDao = new StadiumDao(connection);

        // 3. 사용자 입력
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        // 4. 파싱
        String action = input.split("\\?")[0]; // 야구장등록
        String queryString = input.split("\\?")[1]; // name=창원NC파크
        String[] params = queryString.split("&"); // name=창원NC파크

        // 5. 실행
        if(action.equals("야구장등록")){
            String name = params[0].split("=")[1];
            Stadium stadium = new Stadium();
            stadium.setName(name);
            stadiumDao.save(stadium);
        }else if(action.equals("선수등록")){

        }

    }
}