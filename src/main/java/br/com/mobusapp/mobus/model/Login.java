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
@Table(name = "TB_LOGIN")
public class Login {

    @Id
    @Column(name = "ID")
    private Integer id;
}


