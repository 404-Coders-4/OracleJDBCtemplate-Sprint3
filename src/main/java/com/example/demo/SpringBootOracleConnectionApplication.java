package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication
public class SpringBootOracleConnectionApplication implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOracleConnectionApplication.class, args);
    }
    public void run(String... args) throws Exception {
        jdbcTemplate.query("SELECT * FROM PIC_IMPRT_STAT_TYPE", (rs)-> {
            System.out.println("");
            System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n",
                    "PIC_IMPRT_STAT_CD",
                    "CRT_USER_ID",
                    "CRT_TS",
                    "LASTMT_USER_ID",
                    "LASTMT_TS",
                    "PIC_IMPRT_STAT_NM",
                    "PIC_IMPRT_STAT_DS");
            System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n",
                    rs.getString("PIC_IMPRT_STAT_CD"),
                    rs.getString("CRT_USER_ID"),
                    rs.getString("CRT_TS"),
                    rs.getString("LASTMT_USER_ID"),
                    rs.getString("LASTMT_TS"),
                    rs.getString("PIC_IMPRT_STAT_NM"),
                    rs.getString("PIC_IMPRT_STAT_DS"));
        });
    }
}