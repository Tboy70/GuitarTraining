package com.example.executor;

import rx.Scheduler;

/**
 * Interface implemented by UIThread class.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
