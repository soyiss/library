package com.icia.lib.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {

    private long id; //번호
    private String bookName; //제목
    private String bookPublisher; //출판사
    private String bookAuthor; //저자
    private int bookPrice; //정가

}
