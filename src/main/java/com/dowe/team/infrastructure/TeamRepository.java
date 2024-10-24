package com.dowe.team.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dowe.team.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

  @Query("SELECT t FROM Team t " +
      "JOIN t.profiles p " +
      "WHERE p.member.id = :memberId")
  List<Team> findAllTeamsByMemberId(Long memberId);

  @Query("SELECT COUNT(p) FROM Profile p " +
      "WHERE p.team.id = :teamId")
  int countMembersByTeamId(Long teamId);

}
