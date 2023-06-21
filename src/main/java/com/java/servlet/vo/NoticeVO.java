package com.java.servlet.vo;

import java.util.Date;

public class NoticeVO {
		private int notice_no;
	    private String admin;
	    private String notice_title;
	    private String notice_content;
	    private Date notice_reg_date;
	    
		public int getNotice_no() {
			return notice_no;
		}
		public void setNotice_no(int notice_no) {
			this.notice_no = notice_no;
		}
		public String getAdmin() {
			return admin;
		}
		public void setAdmin(String admin) {
			this.admin = admin;
		}
		public String getNotice_title() {
			return notice_title;
		}
		public void setNotice_title(String notice_title) {
			this.notice_title = notice_title;
		}
		public String getNotice_content() {
			return notice_content;
		}
		public void setNotice_content(String notice_content) {
			this.notice_content = notice_content;
		}
		public Date getNotice_reg_date() {
			return notice_reg_date;
		}
		public void setNotice_reg_date(Date notice_reg_date) {
			this.notice_reg_date = notice_reg_date;
		}
		
		@Override
		public String toString() {
			return "NoticeVO [notice_no=" + notice_no + ", admin=" + admin + ", notice_title=" + notice_title
					+ ", notice_content=" + notice_content + ", notice_reg_date=" + notice_reg_date + "]";
		}
	    
	    


}
