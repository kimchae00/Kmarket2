package kr.co.kmarket2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket2.entity.MemberTermsEntity;

public interface MemberTermsRepo extends JpaRepository<MemberTermsEntity, String> {

	
}
