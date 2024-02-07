package com.example.repository;

import com.example.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //update board_table set board_hits=board_hits+1 where id = ?
    //entity를 기준으로 하기 때문에 테이블 대신 entity의 이름이 온다. 또한 엔티티에서 정의한 열이 온다.
    @Modifying
    @Query (value =  "update  BoardEntity  b set b.boardHits= b.boardHits+1 where b.id =:id")
    void updateHit(@Param("id") Long id);
}
