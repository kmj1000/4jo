package com.java.servlet.vo;

import java.util.Date;

public class NoticeVO {
		private int notice_no;
	    private String admin_name;
	    private String notice_title;
	    private String notice_content;
	    private Date notice_reg_date;
	    
		public int getNotice_no() {
			return notice_no;
		}
		public void setNotice_no(int notice_no) {
			this.notice_no = notice_no;
		}
		public String getAdmin_name() {
			return admin_name;
		}
		public void setAdmin_name(String admin_name) {
			this.admin_name = admin_name;
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
			return "NoticeVO [notice_no=" + notice_no + ", admin_admin=" + admin_name + ", notice_title=" + notice_title
					+ ", notice_content=" + notice_content + ", notice_reg_date=" + notice_reg_date + "]";
		}
	    
	    


}
