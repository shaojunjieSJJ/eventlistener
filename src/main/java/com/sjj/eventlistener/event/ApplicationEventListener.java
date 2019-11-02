package com.sjj.eventlistener.event;

import com.sjj.eventlistener.entity.Student;
import com.sjj.eventlistener.entity.Teacher;
import com.sjj.eventlistener.model.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Slf4j
@Component
public class ApplicationEventListener {

    /**
     * 注意点:
     * applicationEventPublisher.publishEvent(),方法可传递两个参数
     * 第一个是ApplicationEvent,第二个是Object,(如果要传递集合,可以新建一个model,像项目中的StudentDTO类,如例子:五)
     * 也可以自定义一个ApplicationEvent.如StudentEvent,TeacherEvent,每个事务的监听都要使用对应的自定义ApplicationEvent,不可使用相同的,
     * 他是根据事件所传参数类型监听事件,跟类型的泛型没有关系,这样就不必再定义泛型类,直接指定类型像TeacherEvent,
     * 一开始定义StudentEvent为泛型类想着这一个类都可以用,测试后不行
     * @param studentEvent
     * 一.
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, value = StudentEvent.class)// value = 指定监听的事务参数类型
    public void afterCommit(StudentEvent<Student> studentEvent){
        System.out.println("一.StudentEvent<Student>-----------------------------------------");
        Student data = studentEvent.getData();
        List<Student> dataList = studentEvent.getDataList();
        log.info("student:{}", data);
        log.info("studentList:{}", dataList);
    }

    /**
     *  错误的写法,不可使用StudentEvent类型(如果这样接收的数据就为事件入参类型),要使用与之对应的TeacherEvent
     * @param teacher
     * 二.
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommitTeacher(StudentEvent<Teacher> teacher){
        System.out.println("二.StudentEvent<Teacher>-----------------------------------------");
        Teacher data = teacher.getData();
        List<Teacher> dataList = teacher.getDataList();
        log.info("teacher:{}", data);
        log.info("teacherList:{}", dataList);
    }

    /**
     *
     * @param teacherEvent
     * 三.
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, value = TeacherEvent.class)
    public void afterCommit(TeacherEvent teacherEvent) {
        System.out.println("三.TeacherEvent-----------------------------------------");
        Teacher data = teacherEvent.getData();
        List<Teacher> dataList = teacherEvent.getDataList();
        log.info("teacher:{}", data);
        log.info("teacherList:{}", dataList);
    }

    /**
     *
     * @param studentPayloadApplicationEvent
     * 四.
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(PayloadApplicationEvent<Student> studentPayloadApplicationEvent){
        System.out.println("四.Student-----------------------------------------");
        Student data = studentPayloadApplicationEvent.getPayload();
        log.info("student:{}", data);
    }

    /**
     * @param studentDTO
     * 五
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommitStudentDTO(PayloadApplicationEvent<StudentDTO> studentDTO){
        System.out.println("五.StudentDTO-----------------------------------------");
        List<Student> dataList = studentDTO.getPayload().getStudents();
        log.info("dataList:{}", dataList);
    }
}
