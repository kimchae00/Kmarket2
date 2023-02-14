package kr.co.kmarket2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.kmarket2.entity.MemberEntity;
import kr.co.kmarket2.repository.MemberRepo;

@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private MemberRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 해당 사용자 있는지 확인
		MemberEntity member = repo.findById(username).get();
		
		if(member == null) {
			throw new UsernameNotFoundException(username); // 예외처리(해당 사용자 없음)
		}
		
		UserDetails userDts = MyUserDetails.builder()
								.member(member)
								.build();

		return userDts;
	}

}
