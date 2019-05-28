package io.qiantan.server.domain.model;

import io.qiantan.api.consts.IsDelete;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yujiacheng
 * @date: 2019/5/289:12 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_info")
@ApiModel(value = "用户信息表")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT(20) NOT NULL")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(50) NOT NULL DEFAULT '' COMMENT '用户名'")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_delete", columnDefinition = "VARCHAR(4) NULL DEFAULT 'NO' COMMENT '记录是否删除 YES:是, NO:否'")
    private IsDelete isDelete;

    @Column(name = "created_at", columnDefinition = "DATETIME NOT NULL COMMENT '创建时间'")
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME NOT NULL COMMENT '更新时间'")
    private Date updatedAt;
}
