package com.limemul.easssue.api.dto.dash;

import com.limemul.easssue.entity.Category;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DashResDto {

    private GraphDto graph;
    private String cloud;
    private GrassDto grass;


    public DashResDto(List<Category> categories,List<GraphValueDto> radialGraphInfo, String cloud, List<GrassValueDto> calendarHeatMapInfo) {
        this.graph=new GraphDto(categories,radialGraphInfo);
        this.cloud=cloud;
        this.grass=new GrassDto(calendarHeatMapInfo);
    }
}
