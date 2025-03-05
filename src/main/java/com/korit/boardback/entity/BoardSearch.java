package com.korit.boardback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardSearch {
    private int boardId;
    private String title;
    private String categoryName;
    private String profileImg;
    private String nickName;
    private int viewCount;
    private int likeCount;
    private LocalDate createdAt;
}
