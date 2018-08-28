/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.relocationmanagement;


import com.gmail.razandale.jpa.JPAExecutor;
import java.util.ArrayList;
import java.util.List;


public class DefaultDetailsRelocator implements DetailsRelocator {

    private final List<DetailsRelocatorListener> listeners;

    private final JPAExecutor jpaExecutor;

    public DefaultDetailsRelocator(JPAExecutor jpaExecutor) {
        this.jpaExecutor = jpaExecutor;
        listeners = new ArrayList<>();
    }

    @Override
    public synchronized void addListener(DetailsRelocatorListener listener) {
        listeners.add(listener);
    }

    @Override
    public synchronized List<Detail> getDetailsOnDevice(Long deviceId) {
        return jpaExecutor.executeQuery((em) -> {
            return em.createNamedQuery("getDetailsOnDevice").getResultList();
        });
    }

    @Override
    public synchronized Detail moveDetail(Detail detail, Long sourceDevice_Id, Long targetDevice_Id) {
        detail.setDeviceId(targetDevice_Id);
        return jpaExecutor.merge(detail);
    }

    private synchronized void notifyAllListeners(
            Detail detail,
            Long sourceDevice_Id,
            Long targetDevice_Id) {
        listeners.forEach((listener) -> {
            listener.reactOnDetailRelocation(
                    detail,
                    sourceDevice_Id,
                    targetDevice_Id);
        });
    }

}
