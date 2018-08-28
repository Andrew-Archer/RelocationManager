/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.relocationmanagement;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author RazumnovAA
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getDetailsOnDevice", query = "SELECT detail FROM Detail detail WHERE detail.deviceId == :deviceId")
    ,
        @NamedQuery(name = "getDetailsByShift", query = "SELECT detail FROM Detail detail WHERE detail.shiftId == :shiftId")
    ,
        @NamedQuery(name = "getDetailsByDate", query = "SELECT detail FROM Detail detail WHERE detail.controlDate BETWEEN :startDate AND :endDate")
})
@Table(indexes = {
    @Index(name = "DETAIL_INDEX", columnList = "SHIFTID, DEVICEID, CONTROLDATE")
})
public class Detail implements Serializable {

    private static final long serialVersionUID = 145158151515177L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Ссылка на сущность представляющую собой параметры детали. {@link }
     */
    private Long parametersId;
    /**
     * Ссылка представляющая собой результаты испытаний. {@link}
     */
    private Long resultsId;
    /**
     * Ссылка на смену в которой была проконтролирована деталь. {@link }
     */
    private Long shiftId;

    /**
     * Дата прихода трубы на линию.
     */
    private Date controlDate;

    /**
     * Ссылка на устройство на котором находится деталь.
     */
    private Long deviceId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getParametersId() {
        return parametersId;
    }

    public void setParametersId(Long parametersId) {
        this.parametersId = parametersId;
    }

    public Long getResultsId() {
        return resultsId;
    }

    public void setResultsId(Long resultsId) {
        this.resultsId = resultsId;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detail)) {
            return false;
        }
        Detail other = (Detail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.npptmk.managers.details.location.Detail[ id=" + id + " ]";
    }

}
