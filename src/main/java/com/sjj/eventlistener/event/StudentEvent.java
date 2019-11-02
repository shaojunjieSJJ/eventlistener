package com.sjj.eventlistener.event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class StudentEvent<T> extends ApplicationEvent {

    private T data;
    /**
     * 需要传递集合，不想再创建一个model时，可以这样写
     */
    private List<T> dataList;

    public StudentEvent(T source) {
        super(source);
        this.data = source;
    }

    public StudentEvent(List<T> source) {
        super(source);
        this.dataList = source;
    }

    public T getData() {
        return data;
    }

    public List<T> getDataList() {
        return dataList;
    }
}
