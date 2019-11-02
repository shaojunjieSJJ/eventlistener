package com.sjj.eventlistener.event;

import com.sjj.eventlistener.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

/**
 * Created by 邵少 on 2019/11/2.
 */
public class TeacherEvent extends ApplicationEvent{

    private Teacher data;
    /**
     * 需要传递集合，不想再创建一个model时，可以这样写
     */
    private List<Teacher> dataList;

    public TeacherEvent(Teacher source) {
        super(source);
        this.data = source;
    }

    public TeacherEvent(List<Teacher> source) {
        super(source);
        this.dataList = source;
    }

    public Teacher getData() {
        return data;
    }

    public List<Teacher> getDataList() {
        return dataList;
    }
}
