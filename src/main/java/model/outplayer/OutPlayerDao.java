package model.outplayer;

import dto.OutPlayerRespDto;
import model.player.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 책임 : 받은 데이터를 순수하게 DB에 저장,수정,삭제,조회
public class OutPlayerDao {

    private Connection connection;

    public OutPlayerDao(Connection connection) {
        this.connection = connection;
    }

    public List<OutPlayerRespDto> findAllJoinPlayer() {
        List<OutPlayerRespDto> dtoList = new ArrayList<>();
        try {
            String sql = "select " +
                    "p.id p_id, " +
                    "p.name p_name, " +
                    "p.position p_position," +
                    "op.reason op_reason," +
                    "op.created_at op_created_at " +
                    "from player p left outer join out_player op " +
                    "on p.id = op.player_id";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OutPlayerRespDto dto = new OutPlayerRespDto();
                dto.setPId(rs.getInt(1));
                dto.setPName(rs.getString(2));
                dto.setPPosition(rs.getString(3));
                dto.setOpReason(rs.getString(4));
                dto.setOpCreatedAt(rs.getTimestamp(5));
                dtoList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    public List<OutPlayer> findAll() {
        List<OutPlayer> entityList = new ArrayList<>();
        try {
            String sql = "select * from out_player";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OutPlayer entity = new OutPlayer();
                entity.setId(rs.getInt("id"));
                entity.setPlayerId(rs.getInt("player_id"));
                entity.setReason(rs.getString("reason"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
                entityList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public OutPlayer findById(int id) {
        OutPlayer entity = new OutPlayer();
        try {
            String sql = "select * from out_player where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                entity.setId(rs.getInt("id"));
                entity.setPlayerId(rs.getInt("player_id"));
                entity.setReason(rs.getString("reason"));
                entity.setCreatedAt(rs.getTimestamp("created_at"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public int update(OutPlayer entity) {
        int row = 0;
        try {
            String sql = "update out_player set reason = ?, player_id = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, entity.getReason());
            pstmt.setInt(2, entity.getPlayerId());
            pstmt.setInt(3, entity.getId());
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public int deleteById(int id) {
        int row = 0;
        try {
            String sql = "delete from out_player where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public int save(OutPlayer entity) {
        int row = 0;
        try {
            String sql = "insert into out_player(player_id, reason, created_at) values(?, ?, now())";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, entity.getPlayerId());
            pstmt.setString(2, entity.getReason());
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
