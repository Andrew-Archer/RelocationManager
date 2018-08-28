/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.relocationmanagement;

import com.gmail.razandale.jpa.JPAExecutor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;


public class DefaultDetailsRelocator implements DetailsRelocator {

    private final List<DetailsRelocatorListener> listeners;

    private final EntityManagerFactory emf;

    public DefaultDetailsRelocator(EntityManagerFactory emf) {
        this.emf = emf;
        listeners = new ArrayList<>();
    }

    @Override
    public synchronized void addListener(DetailsRelocatorListener listener) {
        listeners.add(listener);
    }

    @Override
    public synchronized List<Detail> getDetailsOnDevice(Long deviceId) {
        return JPAExecutor.executeQuery((em) -> {
            return em.createNamedQuery("getDetailsOnDevice").getResultList();
        },
                emf);
    }

    @Override
    public synchronized Detail moveDetail(Detail detail, Long sourceDevice_Id, Long targetDevice_Id) {
        detail.setDeviceId(targetDevice_Id);
        return JPAExecutor.merge(detail, emf);
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
