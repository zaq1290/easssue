package com.limemul.easssue.service;

import com.limemul.easssue.api.dto.dash.GraphValueDto;
import com.limemul.easssue.api.dto.dash.GrassValueDto;
import com.limemul.easssue.entity.Article;
import com.limemul.easssue.entity.ArticleLog;
import com.limemul.easssue.entity.User;
import com.limemul.easssue.repo.ArticleLogRepo;
import com.limemul.easssue.repo.ArticleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleLogService {

    private final ArticleLogRepo articleLogRepo;
    private final ArticleRepo articleRepo;

    /**
     * 방사형 그래프 정보 조회
     *  해당 유저의 한 주간 카테고리별 읽은 기사 수 반환
     */
    public List<GraphValueDto> getRadialGraphInfo(User user){
        LocalDateTime lastWeek = LocalDateTime.now().minusWeeks(1L);
        return articleLogRepo.countByUserAndClickTimeAfterGroupByCategory(user, lastWeek);
    }

    /**
     * 캘린더 히트맵 정보 조회
     *  해당 유저의 이번 한 달 날짜별 읽은 기사 수 반환
     */
    public List<GrassValueDto> getCalendarHeatMapInfo(User user){
        LocalDateTime firstDayOfMonth = LocalDateTime.now().with(firstDayOfMonth());
        return articleLogRepo.countByUserAndClickTimeAfterGroupByClickTime(user, firstDayOfMonth);
    }

    /**
     * 읽은 기사 로그 남기기
     *  현재 시간에 해당 유저가 해당 기사 읽었다는 로그 저장
     */
    @Transactional
    public ArticleLog logReadArticle(User user,Long articleId){
        Article article = articleRepo.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기사입니다."));

        return articleLogRepo.save(ArticleLog.of(user,article));
    }
}
