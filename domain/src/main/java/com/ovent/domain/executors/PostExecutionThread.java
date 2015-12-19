package com.ovent.domain.executors;

import rx.Scheduler;

/**
 * Created by Kunal on 18/12/15.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}