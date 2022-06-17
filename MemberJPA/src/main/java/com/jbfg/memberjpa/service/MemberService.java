package com.jbfg.memberjpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbfg.memberjpa.entity.MemberVO;
import com.jbfg.memberjpa.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	public List<MemberVO> findAll(){
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = memberRepository.findAll();
		return memberList;
	}

	public Optional<MemberVO> findById(Long id) {
		Optional<MemberVO> memberVO = memberRepository.findById(id);
		return memberVO;
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	public void insert(MemberVO memberVO) {
		memberRepository.save(memberVO);
	}
	
	public void update(Long mbrNo, MemberVO memberVO) {
		Optional<MemberVO> e = memberRepository.findById(mbrNo);
		
		if (e.isPresent()) {
			memberVO.setMbrNo(mbrNo);
			memberRepository.save(memberVO);	
		}
		
	}


}
