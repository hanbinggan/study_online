package cn.edu.upc.study_online.dao.object;

/**
 * Created by songqiaolin on 2017/5/21.
 */

import java.util.Date;

/**
 * CREATE TABLE file(
 * id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
 * path VARCHAR(128) COMMENT '文件目录',
 * name VARCHAR(64) COMMENT '名字',
 * type TINYINT UNSIGNED COMMENT '文件类型',
 * create_time DATETIME COMMENT '创建时间',
 * update_time DATETIME COMMENT '更新时间'
 * ) COMMENT '文件';
 */
public class FileDo {
    private Long id;
    private String path;
    private Integer type;
    private String name;

    public enum TYPE {
        PDF(1), OTHER(2);
        private final int val;

        TYPE(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Date createTime;
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
