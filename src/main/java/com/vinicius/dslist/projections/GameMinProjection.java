package com.vinicius.dslist.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getGameYear();           // corresponde ao alias gameYear
    String getImgUrl();
    String getShortDescription();
}
