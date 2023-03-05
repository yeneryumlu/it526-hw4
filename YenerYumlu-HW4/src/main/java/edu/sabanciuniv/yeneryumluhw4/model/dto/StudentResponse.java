package edu.sabanciuniv.yeneryumluhw4.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private int id;
    private String name;
    private String surname;
    private int studentNumber;
}
