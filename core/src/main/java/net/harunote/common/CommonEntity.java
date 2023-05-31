package net.harunote.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public abstract class CommonEntity implements Serializable {

    @CreatedBy
    @Column
    @Comment("생성자")
    private String createdBy;

    @LastModifiedBy
    @Column
    @Comment("수정자")
    private String updatedBy;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Comment("생성일시")
    private LocalDateTime createdAt;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(nullable = false)
    @LastModifiedDate
    @Comment("수정일시")
    private LocalDateTime updatedAt;
}
