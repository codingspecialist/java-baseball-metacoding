package model.player;

import model.stadium.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 책임 : 받은 데이터를 순수하게 DB에 저장,수정,삭제,조회
public class PlayerDao {

    private Connection connection;

    public PlayerDao(Connection connection) {
        this.connection = connection;
    }

    public List<Player> findAll(){
        List<Player> entityList = new ArrayList<>();
        try {
            String sql = "select * from player";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Player entity = new Player();
                entity.setId(rs.getInt("id"));
                entity.setTeamId(rs.getInt("team_id"));
                entity.setName(rs.getString("name"));
                entity.setPosition(rs.getString("position"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
                entityList.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entityList;
    }

    public Player findById(int id){
        Player entity = new Player();
        try {
            String sql = "select * from player where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                entity.setId(rs.getInt("id"));
                entity.setTeamId(rs.getInt("team_id"));
                entity.setName(rs.getString("name"));
                entity.setPosition(rs.getString("position"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public int update(Player entity){
        int row = 0;
        try {
            String sql = "update player set name = ?, position = ?, team_id = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getPosition());
            pstmt.setInt(3, entity.getTeamId());
            pstmt.setInt(4, entity.getId());
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    public int deleteById(int id){
        int row = 0;
        try {
            String sql = "delete from player where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    public int save(Player entity){
        int row = 0;
        try {
            String sql = "INSERT INTO player (team_id, name, position, created_at) VALUES(?, ?, ?, NOW())";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, entity.getTeamId());
            pstmt.setString(2, entity.getName());
            pstmt.setString(3, entity.getPosition());
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
