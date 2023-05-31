package net.harunote.goal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import net.harunote.common.CommonEntity;
import net.harunote.goal.enums.GoalType;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author CodeVillains
 */
@Accessors(chain = true)
@Entity
@Table(name = "goal")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = { "goal_id" })
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Comment("마이 노트 목표")
@EntityListeners(AuditingEntityListener.class)
public class Goal extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;

    @Column(name = "type", columnDefinition = "varchar(50)", nullable = false)
    private GoalType type;

    @Size(max = 255)
    @Column(nullable = false)
    @Comment("제목")
    private String title;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    @Comment("삭제 여부")
    private boolean deleted;


    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    @Comment("공유 여부")
    private boolean shared;


    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    @Comment("목표 완료 여부")
    private boolean completed;


    @Column(nullable = false)
    @Comment("유저 ID")
    private long userId;


    @Column(name = "start_at")
    @Comment("목표 시작 일시")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    @Comment("목표 완료 일시")
    private LocalDateTime endAt;
}
