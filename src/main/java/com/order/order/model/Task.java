package com.order.order.model;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Entity
public class Task {

    //data members of Task Object
    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime deadLine;
    private String title;
    private Priority priority;
    private Status status;

    //constructor to automatically initialize id and status, when ever an object is created
    public Task() {

        this.id = UUID.randomUUID().toString();
        this.status = Status.PENDING;
    }

    public enum Priority{
        HIGH(3),MEDIUM(2), LOW(1);
        public final int value;
        Priority(int value) {this.value = value;}

    }

    public enum Status{
        PENDING, COMPLETED;
    }

}
