package com.example.executor;

import rx.Scheduler;

/**
 * Created by Thomas on 13/03/2017.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
