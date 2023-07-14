package model.stadium;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 책임 : 받은 데이터를 순수하게 DB에 저장,수정,삭제,조회
public class StadiumDao {

    private Connection connection;

    public StadiumDao(Connection connection) {
        this.connection = connection;
    }

    public List<Stadium> findAll(){
        List<Stadium> entityList = new ArrayList<>();
        try {
            String sql = "select * from stadium";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Stadium entity = new Stadium();
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
                entityList.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entityList;
    }

    public Stadium findById(int id){
        Stadium entity = new Stadium();
        try {
            String sql = "select * from stadium where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public int update(Stadium entity){
        int row = 0;
        try {
            String sql = "update stadium set name = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, entity.getName());
            pstmt.setInt(2, entity.getId());
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
    public int deleteById(int id){
        int row = 0;
        try {
            String sql = "delete from stadium where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    public int save(Stadium entity){
        int row = 0;
        try {
            String sql = "insert into stadium(name, created_at) values(?, now())";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, entity.getName());
            row = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
