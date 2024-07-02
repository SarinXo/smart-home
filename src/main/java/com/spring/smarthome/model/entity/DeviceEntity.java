package com.spring.smarthome.model.entity;

import com.spring.smarthome.model.meta.AppSchemaConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(schema = AppSchemaConstants.SCHEMA_NAME,
       name = DeviceEntity.SQL_TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class DeviceEntity {
    public final static String SQL_TABLE_NAME = "device";

    @Id
    @Column(name = Fields.ID)
    private Integer id;
    @Column(name = Fields.NAME)
    private String name;
    @Column(name = Fields.ALIAS)
    private String alias;
    @Column(name = Fields.DESCRIPTION)
    private String description;
    @Column(name = Fields.LAST_USAGE)
    private OffsetDateTime lastUsage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Fields.HOME_ID)
    private HomeEntity home;

    public static class Fields {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String ALIAS = "alias";
        public static final String DESCRIPTION = "description";
        public static final String LAST_USAGE = "last_usage";
        public static final String HOME_ID = "home_id";
    }

}
