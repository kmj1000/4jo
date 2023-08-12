package com.spring.service;

import com.spring.domain.MemberDTO;
import com.spring.domain.ResultDTO;

public interface RestApiService {
	ResultDTO getMemberCheck(MemberDTO member);

	ResultDTO removeMember(MemberDTO member); //각자컬럼 값을 들고다녀도됨 ex)int m_no
	
	ResultDTO modifyMemberName(MemberDTO member);

	ResultDTO registerMember(MemberDTO member);
}
