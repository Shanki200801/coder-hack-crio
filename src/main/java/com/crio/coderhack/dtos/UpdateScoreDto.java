package com.crio.coderhack.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateScoreDto {
    private String userId;
    private int score;
}
