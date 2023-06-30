package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.java.servlet.dao.MembersDAO;
import com.java.servlet.util.DBCP2Util;
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
				+ "    FROM members"
				;

				try (Connection connection = DBCP2Util.getConnection();
						Statement stmt = connection.createStatement();
						ResultSet rs = stmt.executeQuery(sql);
						) {
					membersList = new ArrayList();

					while (rs.next()) {
						MembersVO vo = new MembersVO();
						vo.setNickname(rs.getString(1));
						vo.setEmail(rs.getString(2));
						vo.setName(rs.getString(3));
						vo.setPhone(rs.getInt(4));

						membersList.add(vo);
					}

					// DataBaseUtil.destroyConnection();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return membersList;
			}

		}
