package model.outplayer;

import com.google.gson.Gson;
import db.DBConnection;
import db.DBInit;
import dto.OutPlayerRespDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class OutPlayerDaoTest {

    private OutPlayerDao outPlayerDao;

    @BeforeEach
    public void setUp(){
        DBInit.teardown();
        Connection connection = DBConnection.getInstance();
        outPlayerDao = new OutPlayerDao(connection);
    }

    @Test
    public void findAllJoinPlayer_test(){
        // given

        // when
        List<OutPlayerRespDto> dtos = outPlayerDao.findAllJoinPlayer();

        // then
        dtos.forEach(dto -> {
            System.out.println(dto);
        });

    }


}
