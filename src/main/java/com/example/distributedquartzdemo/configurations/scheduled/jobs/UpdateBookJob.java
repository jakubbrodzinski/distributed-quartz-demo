package com.example.distributedquartzdemo.configurations.scheduled.jobs;

import com.example.distributedquartzdemo.repositories.BookRepository;
import com.mchange.v2.util.XORShiftRandomUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Slf4j
public class UpdateBookJob implements Job {
    public static final String JOB_NAME = "UpdateBookJob";
    private final BookRepository bookRepository;
    @SneakyThrows
    @Override
    @Transactional
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("----- START -----", LocalDateTime.now());
      log.info("The current date is: {}", LocalDateTime.now());
        log.info(Thread.currentThread().getName());
        bookRepository.findAllByIsbnContaining("ea").stream()
                .map(book -> {
                    book.setIsbn(getNewIsbn());
                    return book;
                }).forEach(bookRepository::save);
        log.info("----- STOP -----");
    }

    private String getNewIsbn(){
        String isbn = RandomStringUtils.random(10) + "ea" + Thread.currentThread().getName();
        return isbn.length() > 45 ? isbn.substring(0,45) : isbn;
    }
}
