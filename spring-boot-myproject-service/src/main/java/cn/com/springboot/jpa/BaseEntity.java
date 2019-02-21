package cn.com.springboot.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


/**
 * @author sj
 * @date 2018/11/12
 */

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @CreatedDate
    @Column(name = "create_time", columnDefinition = "datetime default CURRENT_TIMESTAMP", nullable = false)
    private Date createTime;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "update_time", columnDefinition = "datetime default CURRENT_TIMESTAMP", nullable = false)
    private Date lastModifiedTime;
}
