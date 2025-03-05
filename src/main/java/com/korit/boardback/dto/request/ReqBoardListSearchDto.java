package com.korit.boardback.dto.request;

import com.korit.boardback.entity.BoardSearch;
import lombok.Data;

import java.util.List;

@Data
public class ReqBoardListSearchDto {
    private int page;
    private int limitCount;
    private String order;
    private String searchText;
}
