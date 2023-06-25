package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.java.servlet.dao.MembersDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class MembersDAOImpl implements MembersDAO {

	@Override
	public List<MembersVO> selectMembersList() {
		List<MembersVO> membersList = null;
		
		String sql = "SELECT nickname\r\n"
				+ "        ,email\r\n"
				+ "        ,name\r\n"
				+ "        ,phone \r\n"
				+ "			,pwd \r\n"
				+ "    FROM members"
				;

				try (Connection connection = DataBaseUtil.getConnection();
						Statement stmt = connection.createStatement();
						ResultSet rs = stmt.executeQuery(sql);) {
					membersList = new ArrayList();

					while (rs.next()) {
						MembersVO vo = new MembersVO();
						vo.setNickname(rs.getString(1));
						vo.setEmail(rs.getString(2));
						vo.setPwd(rs.getString(3));
						vo.setName(rs.getString(4));
						vo.setPhone(rs.getInt(5));

						membersList.add(vo);
					}

					// DataBaseUtil.destroyConnection();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return membersList;
			}

		}
