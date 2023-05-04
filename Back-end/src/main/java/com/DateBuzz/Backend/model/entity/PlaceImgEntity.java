package com.DateBuzz.Backend.model.entity;

import com.DateBuzz.Backend.controller.requestDto.PlaceImageRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "\"place_img\"")
@Entity
@Getter
@NoArgsConstructor
public class PlaceImgEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private RecordedPlaceEntity recordedPlace;

    @Column(name = "orders")
    private int orders;

    @Column(name = "img_url")
    private String imgUrl;

    @Builder
    public PlaceImgEntity(RecordedPlaceEntity recordedPlace, int orders, String imgUrl) {
        this.recordedPlace = recordedPlace;
        this.orders = orders;
        this.imgUrl = imgUrl;
    }


    public static PlaceImgEntity FromPlaceImgRequestDto(RecordedPlaceEntity recordedPlace, PlaceImageRequestDto imageRequestDto) {
        return new PlaceImgEntity(
                recordedPlace,
                imageRequestDto.getOrders(),
                imageRequestDto.getImgUrl()
        );
    }
}
