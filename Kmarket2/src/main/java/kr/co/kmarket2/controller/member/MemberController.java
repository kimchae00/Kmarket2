package kr.co.kmarket2.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket2.entity.MemberEntity;
import kr.co.kmarket2.service.MemberService;
import kr.co.kmarket2.vo.MemberTermsVO;
import kr.co.kmarket2.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("member/signup")
	public String signup(Model model, String type) {
		MemberTermsVO vo = service.selectTerms();
		model.addAttribute("vo", vo);
		model.addAttribute("type", type);
		return "/member/signup";
	}
	
	@GetMapping("member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("member/register")
	public String register(MemberVO vo, HttpServletRequest req) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		int result = service.insertUserNormal(vo);
		return "redirect:/index?success="+result;
	}
	
	@ResponseBody
    @GetMapping("member/checkUid")
    public Map<String, Integer> countUid(String uid){
        int result = service.countUid(uid);
        Map<String, Integer> map = new HashMap<>();
        map.put("result", result);
        return map;
    }
	
	@GetMapping("member/registerSeller")
	public String registerSeller() {
		return "/member/registerSeller";
	}
	
	@PostMapping("member/registerSeller")
	public String registerSeller(MemberVO vo, HttpServletRequest req) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		int result = service.insertUserSeller(vo);
		return "redirect:/index?success="+result;
	}
	
	@GetMapping("member/login")
	public String login() {
		return "/member/login";
	}

	/* 아이디찾기 */
	@GetMapping("member/findId")
	public String findId() {
		return "/member/findId";
	}
	
	@ResponseBody
	@PostMapping("member/findId")
	public Map<String, MemberVO> findId(Model model, @RequestParam("name") String name, @RequestParam("email") String email, HttpSession sess) throws Exception {
		MemberVO vo = service.findId(name, email);
		Map<String, MemberVO> map = new HashMap<>();
		map.put("vo", vo);
		if(vo != null) {
			sess.setAttribute("member", vo);
		}
		return map;
	}
	
	@GetMapping("member/findIdResult")
	public String findIdResult(Model model, HttpSession sess) {
		MemberVO member = (MemberVO) sess.getAttribute("member");
		//System.out.println("memberuid :" + member.getUid());
		model.addAttribute("member", member);
		return "/member/findIdResult";
	}
	
	/* 비밀번호찾기(변경) */
	@GetMapping("member/findPw")
	public String findPw(HttpSession sess) {
		sess.removeAttribute("member");
		return "/member/findPw";
	}
	
	@ResponseBody
	@PostMapping("member/findPw")
	public Map<String, Integer> findPw(String uid, String email) {
		int result = service.findPw(uid, email);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	@GetMapping("member/findPwChange")
	public String findPwChange(Model model, String uid) {
		model.addAttribute("uid",uid);
		return "/member/findPwChange";
	}
	
	@ResponseBody
	@PostMapping("member/findPwChange")
	public Map<String, Integer> findPwChange(@RequestParam("uid") String uid, @RequestParam("pass") String pass) {
		pass = passwordEncoder.encode(pass);
		int result = service.findPwChange(uid, pass);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
}
