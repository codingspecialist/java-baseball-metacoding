package model.team;

import db.DBConnection;
import db.DBInit;
import model.stadium.Stadium;
import model.stadium.StadiumDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

public class TeamDaoTest {

    private TeamDao teamDao;
    private StadiumDao stadiumDao;

    @BeforeEach
    public void setUp(){
        DBInit.teardown();
        Connection connection = DBConnection.getInstance();
        teamDao = new TeamDao(connection);
        stadiumDao = new StadiumDao(connection);
    }

    @Test
    public void save_test(){
        // given
        Stadium stadium = new Stadium();
        stadium.setName("창원NC파크");
        stadiumDao.save(stadium);

        Team team = new Team();
        team.setStadiumId(4);
        team.setName("NC");

        // when
        int row = teamDao.save(team);

        // then
        System.out.println(row);
    }

    @Test
    public void update_test(){
        // given
        Team team = new Team();
        team.setId(1);
        team.setName("키움");

        // when
        int row = teamDao.update(team);

        // then
        System.out.println(row);
    }

    @Test
    public void deleteById_test(){
        // given
        int id = 1;

        // when
        teamDao.deleteById(id);
        
        // Player 때문에 팀 삭제를 하지 못함
    }

    @Test
    public void findById_test(){
        // given
        int id = 1;

        // when
        Team team = teamDao.findById(id);

        // then
        System.out.println(team);
    }

    @Test
    public void findAll_test(){
        // given

        // when
        List<Team> teamList = teamDao.findAll();

        // then
        teamList.forEach(team -> {
            System.out.println(team);
        });
    }
}
