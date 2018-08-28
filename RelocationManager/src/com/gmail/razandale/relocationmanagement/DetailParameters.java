/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.relocationmanagement;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author RazumnovAA
 */
@Entity
public class DetailParameters implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Комментарий к типоразмеру.
     */
    private String comment;
    /**
     * Имя заказчика.
     */
    private String customerName;
    /**
     * Диаметр трубы в мм.
     */
    private int diameter;
    /**
     * Фактические утечки по результатам опрессовки в куб. см.
     */
    private float factLeakValue;
    /**
     * Длительность первого пролива в сек.
     */
    private int fill1Duration;
    /**
     * Длительность 2 пролива в сек.
     */
    private int fill2Duration;
    /**
     * Длительность паузы между 1 и 2 проливами.
     */
    private int fillPauseDuration;
    /**
     * Заданное давление опрессовки.
     */
    private float givenPressure;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Максимально допустимые утечки в куб. см.
     */
    private float maxLeakValue;
    /**
     * Толщина стенки в мм.
     */
    private float sideThick;
    /**
     * Время мойки трубы в сек.
     *
     */
    private int washTime;

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailParameters)) {
            return false;
        }
        DetailParameters other = (DetailParameters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Комментарий к типоразмеру.
     *
     * @return строка комментария.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Задает комментарий к типоразмеру.
     *
     * @param comment строка для задания комментария.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Имя заказчика.
     *
     * @return строка с именем заказчика.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Задет имя заказчика.
     *
     * @param customerName строка для задания имени.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Диаметр трубы.
     *
     * @return диаметр в мм.
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Задает диаметр трубы.
     *
     * @param diameter диаметр для задания в мм.
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    /**
     * Полученные во время опрессовки утечки.
     *
     * @return утечки в куб. см.
     */
    public float getFactLeakValue() {
        return factLeakValue;
    }

    /**
     * Задает полученные во время опрессовки утечки.
     *
     * @param factLeakValue утечки для задания в куб. см.
     */
    public void setFactLeakValue(float factLeakValue) {
        this.factLeakValue = factLeakValue;
    }

    /**
     * Длительность 1 пролива.
     *
     * @return время в сек.
     */
    public int getFill1Duration() {
        return fill1Duration;
    }

    /**
     * Задает длительность 1 пролива.
     *
     * @param fill1Duration длительность для задания в сек.
     */
    public void setFill1Duration(int fill1Duration) {
        this.fill1Duration = fill1Duration;
    }

    /**
     * Длительность 2 пролива.
     *
     * @return время в сек.
     */
    public int getFill2Duration() {
        return fill2Duration;
    }

    /**
     * Задает длительность 2 пролива.
     *
     * @param fill2Duration время для задания в сек.
     */
    public void setFill2Duration(int fill2Duration) {
        this.fill2Duration = fill2Duration;
    }

    /**
     * Длительность паузы между проливами.
     *
     * @return время в сек.
     */
    public int getFillPauseDuration() {
        return fillPauseDuration;
    }

    /**
     * Задет длительность паузы между 1 и 2 проливами.
     *
     * @param fillPauseDuration время для задания в сек.
     */
    public void setFillPauseDuration(int fillPauseDuration) {
        this.fillPauseDuration = fillPauseDuration;
    }

    /**
     * Заданное давление опрессовки.
     *
     * @return в МПа.
     */
    public float getGivenPressure() {
        return givenPressure;
    }

    /**
     * Задает давление опрессовки.
     *
     * @param givenPressure давление для задания в МПа.
     */
    public void setGivenPressure(float givenPressure) {
        this.givenPressure = givenPressure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Максимальнодопустимые утечки.
     *
     * @return утечки в куб. см.
     */
    public float getMaxLeakValue() {
        return maxLeakValue;
    }

    /**
     * Задет максимальнодопустимые утечки.
     *
     * @param maxLeakValue утечки для задания в куб. см.
     */
    public void setMaxLeakValue(float maxLeakValue) {
        this.maxLeakValue = maxLeakValue;
    }

    /**
     * Толщина стенки.
     *
     * @return толщина в мм.
     */
    public float getSideThick() {
        return sideThick;
    }

    /**
     * Задает толщину стенки.
     *
     * @param sideThick толщина для задания в мм.
     */
    public void setSideThick(float sideThick) {
        this.sideThick = sideThick;
    }

    /**
     * Имя типоразмера.
     *
     * @return
     */
    public String getTubeTypeName() {
        return String.format("Ø%dХ%f %s %s",
                getDiameter(),
                getSideThick(),
                getCustomerName(),
                getComment());
    }

    /**
     * Время мыться трубы.
     *
     * @return время в мм.
     */
    public int getWashTime() {
        return washTime;
    }

    /**
     * Задание времени мытья трубы.
     *
     * @param washTime время для задания в сек.
     */
    public void setWashTime(int washTime) {
        this.washTime = washTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ru.npptmk.managers.details.location.DetailParameters[ id=" + id + " ]";
    }

}
