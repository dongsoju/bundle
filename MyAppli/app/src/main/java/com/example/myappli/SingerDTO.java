package com.example.myappli;

import java.io.Serializable;

/*1. DB에 있는 테이블을 기본으로 하여 DTO를 만든다
 *   가정 : 1. DB 에 singerDTO라는 테이블이 있다
 *         2. singerDTO라는 테이블에 name, mobile, age,
 *             resId(이미지경로)의 칼럼이 있다
 */
public class SingerDTO implements Serializable {
    String  name,mop,content;
    int nameimg,mapimg, contentimg;

    public SingerDTO(){

    }
    public SingerDTO(String name, int nameimg){
        this.name = name;
        this.nameimg =nameimg;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNameimg() {
        return nameimg;
    }

    public void setNameimg(int nameimg) {
        this.nameimg = nameimg;
    }

    public int getMapimg() {
        return mapimg;
    }

    public void setMapimg(int mapimg) {
        this.mapimg = mapimg;
    }

    public int getContentimg() {
        return contentimg;
    }

    public void setContentimg(int contentimg) {
        this.contentimg = contentimg;
    }
}
