package com.DateBuzz.Backend.model.entity;

import com.DateBuzz.Backend.controller.requestDto.UserJoinRequestDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"users\"")
@SQLDelete(sql = "update \"user\" set deleted_at = now() where id = ?")
@Where(clause = "deleted_at is null")
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String profileImg;
    private String nickname;
    private String email;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;



    @PrePersist
    void registeredAt(){
        this.createdAt = Timestamp.from(Instant.now());
    }
    @PreUpdate
    void updatedAt(){
        this.updatedAt = Timestamp.from(Instant.now());
    }

    @Builder
    public UserEntity(String userName, String password, String nickname, String email) {

    }
    public static UserEntity fromJoinRequestDto(String userName, String password, String nickname, String email){
        return new UserEntity(
                userName,
                password,
                nickname,
                email
        );
    }
}
