package kr.co.kmarket2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket2.entity.MemberEntity;

public interface MemberRepo extends JpaRepository<MemberEntity, String> {
	
	public int countByUid(String uid);
	public List<MemberEntity> findMemberEntityByNameAndEmail(String name, String email);
}
