package model.team;

import model.stadium.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 책임 : 받은 데이터를 순수하게 DB에 저장,수정,삭제,조회
public class TeamDao {

    private Connection connection;

    public TeamDao(Connection connection) {
        this.connection = connection;
    }

    public List<Team> findAll(){
        List<Team> entityList = new ArrayList<>();
        try {
            String sql = "select * from team";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Team entity = new Team();
                entity.setId(rs.getInt("id"));
                entity.setStadiumId(rs.getInt("stadium_id"));
                entity.setName(rs.getString("name"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
                entityList.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entityList;
    }

    public Team findById(int id){
        Team entity = new Team();
        try {
            String sql = "select * from team where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                entity.setId(rs.getInt("id"));
                entity.setStadiumId(rs.getInt("stadium_id"));
                entity.setName(rs.getString("name"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public int update(Team entity){
        int row = 0;
        try {
            String sql = "update team set name = ?, stadium_id = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getStadiumId());
            pstmt.setInt(3, entity.getId());
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
    public int deleteById(int id){
        int row = 0;
        try {
            String sql = "delete from team where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    public int save(Team entity){
        int row = 0;
        try {
            String sql = "insert into team(stadium_id, name, created_at) values(?, ?, now())";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, entity.getStadiumId());
            pstmt.setString(2, entity.getName());
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
