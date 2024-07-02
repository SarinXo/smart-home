package com.spring.smarthome.model.entity;

import com.spring.smarthome.model.meta.AppSchemaConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(schema = AppSchemaConstants.SCHEMA_NAME,
        name = HomeEntity.SQL_TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class HomeEntity {
    public static final String SQL_TABLE_NAME = "home";
    @Id
    @Column(name = Fields.ID)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "home")
    private List<DeviceEntity> devices;

    public static class Fields {
        public static final String ID = "id";
    }
}
