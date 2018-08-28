/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.relocationmanagement;

import java.util.List;
import com.gmail.razandale.relocationmanagement.Detail;

/**
 * Интерфейс используемый для взаимодействия с менеджером перемещения деталей.
 * @author RazumnovAA
 */
public interface DetailsRelocator {

    public interface DetailsRelocatorListener {

        /**
         * Метод вызываемый у слушателя события перекладки детали.
         *
         * @param detail деталь.
         * @param sourceDevice_Id идентификатор устройства откуда перекладываем.
         * @param targetDevice_Id идентификатор устройства куда перекладываем.
         */
        public void reactOnDetailRelocation(Detail detail, Long sourceDevice_Id, Long targetDevice_Id);
    }
    
    public Detail moveDetail(Detail detail, Long sourceDevice_Id, Long targetDevice_Id);

    /**
     * Возвращает лист идентификаторов деталей которые находятся на установке.
     *
     * @param deviceId идентификатор устройство список деталей на котором
     * необходимо получить.
     * @return список идентификаторов деталей, находящихся или пустой список
     * если ни одной детали на установке нет.
     */
    public List<Detail> getDetailsOnDevice(Long deviceId);

    /**
     * Добавляет слушателя о событии перекладки деталей.
     *
     * @param listener слушатель для добавления.
     */
    public void addListener(DetailsRelocatorListener listener);

}
