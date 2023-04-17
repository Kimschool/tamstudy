package com.weavus.board.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weavus.board.entity.Member;

public interface MemberRepo extends CrudRepository<Member, Integer> {
	
    @Query("select u from Member u WHERE u.id=:id AND u.password=:password")
    Member findByIdAndPassword(@Param("id") int id, @Param("password") String password);


}
