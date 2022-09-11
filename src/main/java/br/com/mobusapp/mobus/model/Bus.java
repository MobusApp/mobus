package br.com.mobusapp.mobus.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TB_BUS")
public class Bus {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "MAC")
    private String macAddress;

    @Column(name = "BUS_LINE")
    private String busLine;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

}
