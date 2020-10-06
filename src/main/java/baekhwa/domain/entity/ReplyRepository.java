package baekhwa.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
	//JPQL
	@Query("select r from Reply r where bno=:b_no order by rno desc")
	List<Reply> findAllByBNo(@Param("b_no") Long bno);
	
	//List<Reply> findAllByBNoOrderByRNoDesc(Long b_no);
	
	//Spring-Data-JPA에서 언더스코어(_)가 프로퍼티을 찾기 위한 탐색 경로를 지정하는 예약어

}
