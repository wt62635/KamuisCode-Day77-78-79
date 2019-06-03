package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

/**
 * 封装了数据访问逻辑
 * @author Administrator
 *
 */
public class UserDAO {
	
	/**
	 * 将用户信息从数据库删除
	 * @param user
	 * @throws Exception
	 */
	public void del(int id) throws Exception {
		Connection conn = null ;
		PreparedStatement ps = null ;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("delete from t_user where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, ps, conn);
		}
	}
	
	/**
	 * 将用户的信息保存到数据库
	 * @param user
	 * @throws Exception 
	 */
	public void save(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null ;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("insert into t_user values(null,?,?,?)");
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e ;
		}finally {
			DBUtils.close(null, ps, conn);
		}
		
	}
	
	/**
	 * 将所有用户信息查询出来
	 * @throws Exception 
	 */
	public List<User> findAll() throws Exception{
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement("select * from t_user");
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("username"));
				user.setPwd(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e ;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		
		return users;
	}
}
