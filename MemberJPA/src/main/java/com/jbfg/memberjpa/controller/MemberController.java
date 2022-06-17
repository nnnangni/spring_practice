package com.jbfg.memberjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbfg.memberjpa.entity.MemberVO;
import com.jbfg.memberjpa.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	ResponseEntity<List<MemberVO>> getAllMembers(){
		List<MemberVO> memberList = memberService.findAll();
		ResponseEntity<List<MemberVO>> entity = new ResponseEntity<List<MemberVO>>(memberList, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping(value="/{mbrNo}")
	public ResponseEntity<MemberVO> getMember(@PathVariable Long mbrNo){
		Optional<MemberVO> oPtionalMemberVO= memberService.findById(mbrNo);
		MemberVO memberVo = oPtionalMemberVO.get();
		ResponseEntity<MemberVO> entity = new ResponseEntity<MemberVO>(memberVo, HttpStatus.OK);
		return entity;
	}
	
	
	
	// 1. 삭제
	@ResponseBody
	@GetMapping("/delete/{mbrNo}")
	public String deleteMember(@PathVariable Long mbrNo, MemberVO memberVO) {
		memberService.delete(mbrNo);
		return "deleteMember(Long mbrNo)";
	}
	
	
	// 2. 수정
	// member/update/2?id=nawon&name=parknw
	@ResponseBody
	@GetMapping("/update/{mbrNo}")
	public String updateMember(@PathVariable Long mbrNo, MemberVO memberVO) {
		memberService.update(mbrNo, memberVO);
		return "updateMember()";
	}
	
	
	// 3. 입력
	@ResponseBody
	@GetMapping("/insert")
	public String insertMember(MemberVO memberVO) {
		memberService.insert(memberVO);
		return "insertMember()";
	}
}
