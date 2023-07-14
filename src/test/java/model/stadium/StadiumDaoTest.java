package model.stadium;

import db.DBConnection;
import db.DBInit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class StadiumDaoTest {

    private StadiumDao stadiumDao;

    @BeforeEach
    public void setUp(){
        DBInit.teardown();
        Connection connection = DBConnection.getInstance();
        stadiumDao = new StadiumDao(connection);
    }

    @Test
    public void save_test(){
        // given
        Stadium entity = new Stadium();
        entity.setName("창원NC파크");

        // when
        int row = stadiumDao.save(entity);

        // then
        System.out.println(row);
    }

    @Test
    public void update_test(){
        // given
        Stadium stadium = new Stadium();
        stadium.setId(1);
        stadium.setName("고척스카이돔");

        // when
        int row = stadiumDao.update(stadium);

        // then
        System.out.println(row);
    }

    @Test
    public void deleteById_test(){
        // given
        int id = 1;

        // when
        stadiumDao.deleteById(id);
    }

    @Test
    public void findById_test(){
        // given
        int id = 1;

        // when
        Stadium stadium = stadiumDao.findById(id);

        // then
        System.out.println(stadium);
    }

    @Test
    public void findAll_test(){
        // given

        // when
        List<Stadium> stadiumList = stadiumDao.findAll();

        // then
        stadiumList.forEach(stadium -> {
            System.out.println(stadium);
        });
    }
}
